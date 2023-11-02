import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileInputStream;
import java.text.Collator;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import java.awt.Font;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

import java.util.Collections;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellReference;
// import org.apache.poi.xssf.usermodel.XSSFFormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FOLHAS_DE_PONTO {
    private static List<Registro> registros = new ArrayList<Registro>(); // para armazenar os registros de entrada e saída
    private static List<Registro> registrosDoMesSelecionado = new ArrayList<Registro>();
    private static final String FILE_REGISTROS = "PONTO_ELETRONICO.xlsx";
    private static final String FILE_FOLHAS = "FOLHAS DE PONTO.xlsx";
    private static final String HORA_ENTRADA_MANHA = "07:40:00";
    private static final String HORA_SAIDA_MANHA = "14:00:00";
    private static final String HORA_ENTRADA_TARDE = "13:40:00";
    private static final String HORA_SAIDA_TARDE = "20:00:00";  
    private static final String HORA_ENTRADA_SABADO = "07:40:00";
    private static final String HORA_SAIDA_SABADO = "14:00:00";   
    private static final int numLinhasDaFolha = 44; // Número de linhas na planilha Excel de uma folha de ponto
    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss");
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final String[] meses = {"JANEIRO", "FEVEREIRO", "MARÇO", "ABRIL", "MAIO", "JUNHO",
                        "JULHO", "AGOSTO", "SETEMBRO", "OUTUBRO", "NOVEMBRO", "DEZEMBRO"};
    private static final String[] anos = {"2023" ,"2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032"}; 
    private static String COPIED_FOLHAS = "";
    private static int mes, ano; // Para armazenar o mês e o ano das folhas de ponto que se deseja gerar 
    private static int firstIndex = 0; // Para armazenar o índice do primeiro registro da lista registros do mês e ano informados   
    public static void main(String[] args) throws IOException {              
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Para que o programa funcione adequadamente os registros são reordenados pelos nomes do funcionários
        Collections.sort(registros, new SortByDate());

        // Carregando os registros.
        loadFromFile();

        // Carrega a pasta de trabalho na estrutura de dados do JAVA POI
        while (true)
        {
            boolean registrosExistem = false;
            // Exibindo o menu.
            menu();            
           
            for( ; firstIndex < registros.size(); firstIndex++) {
                if (ano == LocalDate.parse(registros.get(firstIndex).getDate(), DATE_FORMATTER).getYear())
                {
                    if (mes == LocalDate.parse(registros.get(firstIndex).getDate(), DATE_FORMATTER).getMonthValue())
                    {
                        registrosExistem = true;
                        break;
                    }
                }
            }
            if (registrosExistem)
            {
                // Significa que o mês e o ano informados foram registrados
                // e o firstIndex está armazenando o primeiro indice dos registros
                // para gerar as folhas de ponto do mês e ano informado.
                break;
            }
            else
            {
                JOptionPane.showMessageDialog(frame,"Registros do mês e ano informados não existem.", 
                                             "Mensagem",JOptionPane.WARNING_MESSAGE);
                firstIndex = 0;
            }
        }   
        
        // Alimentando a lista de registros do mês e ano selecionados       
        for (int i = firstIndex; LocalDate.parse(registros.get(i).getDate(), DATE_FORMATTER).getMonthValue() == mes &&
                                 LocalDate.parse(registros.get(i).getDate(), DATE_FORMATTER).getYear() == ano; i++)
        {
            registrosDoMesSelecionado.add(registros.get(i));
            if (i == registros.size() - 1) break;
        }

        // Ordenando os registros do mês e ano selecionado pelo nome
        Collections.sort(registrosDoMesSelecionado, new SortByName());   

        // Criando uma cópia da folha de ponto com o nome de acordo com o mês e ano selecionado
        COPIED_FOLHAS =    FILE_FOLHAS.substring(0, FILE_FOLHAS.length() - 5) + " " 
                           + meses[mes - 1].substring(0, 3)
                           + "-" + anos[ano - 2023] + ".xlsx";

        Path sourcePath = Paths.get(FILE_FOLHAS);
        Path targetPath = Paths.get(COPIED_FOLHAS);
        Files.copy(sourcePath, targetPath, StandardCopyOption.REPLACE_EXISTING);

        // Salva os registros nas folhas de ponto de cada funcionário
        saveToFile();
        JOptionPane.showConfirmDialog(frame, "Folhas de ponto geradas com sucesso!", "Mensagem", JOptionPane.PLAIN_MESSAGE, JOptionPane.PLAIN_MESSAGE); 
        System.exit(0);
    }

    private static void menu()
    {     
        try
        {
            JFrame frame = new JFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);         
            // mau funcionamento do LocalDate.now().getYear() se somar ou subtrair algum valor 
            // dele no mesmo momento de atribuir seu valor a uma variável.
            mes = LocalDate.now().getMonthValue(); // Para armazenar a escolha do mês das folhas a serem geradas
            ano = LocalDate.now().getYear(); // Para armazenar a escolha do ano das folhas a serem geradas

            int mesAtual = mes - 1; // Para acessar o índice correspondente ao mês atual da String[] meses.
            int anoAtual = ano - 2023; // Para acessar o índice correspondente ao ano atual da String[] anos.
            UIManager.put("OptionPane.buttonFont", new FontUIResource("Arial", Font.BOLD, 22));
            UIManager.put("OptionPane.messageFont", new FontUIResource("Arial", Font.BOLD, 26));

            String strAno = (String) JOptionPane.showInputDialog(frame, "Escolha o ano:",
                                                        "Ano: ", JOptionPane.QUESTION_MESSAGE,
                                                        null, 
                                                                anos, 
                                                                anos[anoAtual]);
            String strMes = (String) JOptionPane.showInputDialog(frame, "Escolha o mês:",
                                                        "Mês: ", JOptionPane.QUESTION_MESSAGE,
                                                            null, 
                                                                meses, 
                                                                meses[mesAtual]); 
            if (strMes == null) {
                System.exit(-1);
            }
            switch (strMes) 
            {
                case "JANEIRO": mes = 1; break;
                case "FEVEREIRO": mes = 2; break;   
                case "MARÇO": mes = 3; break;
                case "ABRIL": mes = 4; break;
                case "MAIO": mes = 5; break;   
                case "JUNHO": mes = 6; break;
                case "JULHO": mes = 7; break;
                case "AGOSTO": mes = 8; break;   
                case "SETEMBRO": mes = 9; break;
                case "OUTUBRO": mes = 10; break;
                case "NOVEMBRO": mes = 11; break;   
                case "DEZEMBRO": mes = 12; break;
            }     
            ano = Integer.parseInt(strAno); 
        }    
        catch (NullPointerException e) 
        {
            e.printStackTrace();
            System.exit(-1);
        }                         
    }

    // Armazenar os registros de entrada e saída dos funcionários lido da planilha 
    // REGISTROS da pasta de trabalho PONTO_ELETRONICO.xlsx
    // BUG: loadFromFile inserindo valor incorreto na lista registros ****************************************************
    private static void loadFromFile() 
    {    
        // Um bloco try é usado para lançar exceção em caso de row ser null   
        try (Workbook workbook = new XSSFWorkbook(new FileInputStream(FILE_REGISTROS))) {
            // A planilha terá duas abas. A primeira com a lista de funcionários cadastrados.
            // A segunda com os registros de entrada e saída. O loarFromFile() carrega somente a planilha REGISTROS            
            Sheet REGISTROS = workbook.getSheet("REGISTROS");
            String MATRICULA = "";
            String NOME = "";
            String SETOR = "";
            String TURNO = "";
            String ENTRADA = "";
            String SAIDA = "";
            String DATA = "";
            // Criando um CreationHelper e CellStyle para salvar armazenar as datas lidas no formato dd/MM/yyyy
            CreationHelper createDateHelper = workbook.getCreationHelper();  
            CellStyle dateStyle = workbook.createCellStyle(); 
            dateStyle.setDataFormat(createDateHelper.createDataFormat().getFormat("dd/mm/yyyy"));
            // Criando um CreationHelper e CellStyle para salvar armazenar os horários lidos no formato hh:mm:ss
            CreationHelper createTimeHelper = workbook.getCreationHelper();  
            CellStyle timeStyle = workbook.createCellStyle(); 
            timeStyle.setDataFormat(createTimeHelper.createDataFormat().getFormat("hh:mm:ss"));
            // Gets the last row on the sheet Note: rows which had content before and were set to empty later might still be 
            // counted as rows by Excel and Apache POI, so the result of this method will include such rows and thus the 
            // returned value might be higher than expected!
            
            // Laço para armazenar os registros de entrada e saída.
            for (int i = 1; i <= REGISTROS.getLastRowNum(); i++) {
                Row row = REGISTROS.getRow(i);
                
                // The getCell method has a second argument that specifies a policy for handling empty cells.
                // Cell cell = row.getCell(0, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);                
                if (row != null) {
                    if (row.getCell(0) != null) {
                        // Usando DataFormatter para salvar formatar as células como texto. Isso evita que matrículas constituidas 
                        // somente por números sejam lidas como decimais do tipo 123456.00
                        Cell c = row.getCell(0);
                        DataFormatter fmt = new DataFormatter();
                        CellReference cr = new CellReference(c);
                        cr.formatAsString();// Formatando a célula como uma string
                        MATRICULA = fmt.formatCellValue(c);
                    }
                    if (row.getCell(1) != null) {
                        Cell c = row.getCell(1);
                        DataFormatter fmt = new DataFormatter();
                        CellReference cr = new CellReference(c);
                        cr.formatAsString();// Formatando a célula como uma string
                        NOME = fmt.formatCellValue(c);
                    }
                    if (row.getCell(2) != null) {
                        Cell c = row.getCell(2);
                        DataFormatter fmt = new DataFormatter();
                        CellReference cr = new CellReference(c);
                        cr.formatAsString();// Formatando a célula como uma string
                        SETOR = fmt.formatCellValue(c);                        
                    }
                    if (row.getCell(3) != null){
                        Cell c = row.getCell(3);
                        DataFormatter fmt = new DataFormatter();
                        CellReference cr = new CellReference(c);
                        cr.formatAsString();// Formatando a célula como uma string
                        TURNO = fmt.formatCellValue(c);                        
                    }    
                    if (row.getCell(4) != null){
                        Cell c = row.getCell(4);
                        DataFormatter fmt = new DataFormatter();
                        CellReference cr = new CellReference(c);
                        cr.formatAsString();// Formatando a célula como uma string
                        c.setCellStyle(timeStyle);
                        ENTRADA = fmt.formatCellValue(c);                     
                    }
                    else ENTRADA = "";

                    if (row.getCell(5) != null) {
                        Cell c = row.getCell(5);
                        DataFormatter fmt = new DataFormatter();
                        CellReference cr = new CellReference(c);
                        cr.formatAsString();// Formatando a célula como uma string
                        c.setCellStyle(timeStyle);
                        SAIDA = fmt.formatCellValue(c);                       
                    }
                    else SAIDA = "";
                    if (row.getCell(6) != null) {
                        Cell c = row.getCell(6);
                        DataFormatter fmt = new DataFormatter();
                        CellReference cr = new CellReference(c);
                        cr.formatAsString();// Formatando a célula como uma string
                        c.setCellStyle(dateStyle);
                        DATA = fmt.formatCellValue(c);
                    }                    
                    Registro registro = new Registro(MATRICULA, NOME, SETOR, TURNO);                    
                    registro.setBeginTime(ENTRADA);
                    registro.setEndTime(SAIDA);
                    registro.setDate(DATA);
                    registros.add(registro);
                }                               
            }
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }               
    }

    // Salvar os dados dos funcionários e registros de entrada e saída nas respectivas folhas de ponto
    private static void saveToFile() 
    {        
        try (Workbook workbookFolhas = new XSSFWorkbook(new FileInputStream(COPIED_FOLHAS))) 
        {
            Sheet FOLHAS = workbookFolhas.getSheetAt(0);
            // Criando um cell style para inserir quebra de linha
            CellStyle wrapStyle = workbookFolhas.createCellStyle();
            org.apache.poi.ss.usermodel.Font font = workbookFolhas.createFont(); // Necessário citar todo o caminho da classe pois o pacote awt.Font possui uma classe com o mesmo nome
            font.setFontHeight((short) 180);
            font.setBold(true);
            wrapStyle.setWrapText(true);
            wrapStyle.setFont(font);
            wrapStyle.setAlignment(HorizontalAlignment.LEFT);
            wrapStyle.setVerticalAlignment(VerticalAlignment.TOP);
            
            // Strings para escrever na folha de ponto o registro corrente, que é atualizado durante a execução
            String currentId = registrosDoMesSelecionado.get(0).getId();
            String currentName = registrosDoMesSelecionado.get(0).getName(); 
            String currentSetor = registrosDoMesSelecionado.get(0).getSetor();
            String currentTurno = registrosDoMesSelecionado.get(0).getTurno(); 
            String currentBeginTime = registrosDoMesSelecionado.get(0).getBeginTime();
            String currentEndTime = registrosDoMesSelecionado.get(0).getEndTime();
            String currentDate = registrosDoMesSelecionado.get(0).getDate(); // a data é comum a todos os registros

            int atrasoTotalEmSegundos = 0;
            int seconds = 0;
            int minutes = 0;
            int hours = 0;
            for (int i = 0, index = 0; index < registrosDoMesSelecionado.size() ; i++) 
            {                                            
                // Se currentId possuir valor diferente do ID do índice i de registros, significa que é um registro de 
                // outro funcionário. Dessa forma o programa deve passar a escrever os registros desse funcionário
                // na próxima folha de ponto
               
                if (!currentId.equals(registrosDoMesSelecionado.get(index).getId())) 
                {    
                    // registra na folha o atraso total  
                    // j é calculado para posicionar o programa na linha correspondente ao campo do atraso total                
                    int j = i + numLinhasDaFolha - i % numLinhasDaFolha - 6;
                    Row row = FOLHAS.getRow(j);                                    
                    hours = atrasoTotalEmSegundos/3600;
                    atrasoTotalEmSegundos -= 3600*hours;
                    minutes = atrasoTotalEmSegundos/60;
                    atrasoTotalEmSegundos -= 60*minutes;
                    String somaDosAtrasosToStr = String.format("%02d:%02d:%02d", hours, minutes, atrasoTotalEmSegundos);
                    row.getCell(4).setCellValue(somaDosAtrasosToStr);  

                    atrasoTotalEmSegundos = seconds = minutes = hours = 0; 
                    // Atualiza o indice do loop para acessar a próxima folha de ponto  
                    // A lógica aqui é que o índice salte para a primeira linha da folha seguinte. Isto é feito
                    // incrementando o índice na quantidade que falta para cair na primeira linha da próxima folha
                    i = i + numLinhasDaFolha - i % numLinhasDaFolha + 1;
                    // o programa deve sair do loop caso o incremento em i ultrapasse o tamanho de registros
                    if (i >= FOLHAS.getLastRowNum() || index >= registrosDoMesSelecionado.size()) 
                    {                        
                        break;
                    }                                             

                    // carregando os dados do próximo funcionário
                    currentId = registrosDoMesSelecionado.get(index).getId();
                    currentName = registrosDoMesSelecionado.get(index).getName();
                    currentSetor = registrosDoMesSelecionado.get(index).getSetor();
                    currentTurno = registrosDoMesSelecionado.get(index).getTurno();  
                    // somaDosAtrasos = Duration.ZERO;                  
                }      
                
                if (i % numLinhasDaFolha == 0)
                {
                    // Para inserir a logo
                }
                // Testa se é a linha para escrever a matrícula e nome
                if (i % numLinhasDaFolha == 1) 
                {                    
                    // row é usad para acessar as células das linhas 2, 4 e 7 até 37 e duas colunas de cada folha de ponto
                    Row row = FOLHAS.getRow(i);
                    row.getCell(0).setCellValue("NOME: " + currentName);  
                    row.getCell(5).setCellValue("Matrícula: " + currentId);                                 
                }   
                // Para preencher as células com o mês/ano da folha
                if (i % numLinhasDaFolha == 2) 
                {
                    Row row = FOLHAS.getRow(i);
                    // Registrando o turno
                     row.getCell(5).setCellValue(currentTurno);
                    // Registrando o mês/ano correntes.
                    int mesCorrente = LocalDate.parse(registrosDoMesSelecionado.get(0).getDate(), DATE_FORMATTER).getMonthValue();  
                    int anoCorrente = LocalDate.parse(registrosDoMesSelecionado.get(0).getDate(), DATE_FORMATTER).getYear();                      
                    String strAno = String.valueOf(anoCorrente);
                    
                    switch (mesCorrente)
                    {
                        case 1:                            
                            row.getCell(5).setCellValue("MÊS/ANO: JAN/" + strAno);
                            break;
                        case 2:                            
                            row.getCell(5).setCellValue("MÊS/ANO: FEV/" + strAno);
                            break;
                        case 3:                            
                            row.getCell(5).setCellValue("MÊS/ANO: MAR/" + strAno);
                            break;
                        case 4:                            
                            row.getCell(5).setCellValue("MÊS/ANO: ABR/" + strAno);
                            break;
                        case 5:                            
                            row.getCell(5).setCellValue("MÊS/ANO: MAI/" + strAno);
                            break;
                        case 6:                            
                            row.getCell(5).setCellValue("MÊS/ANO: JUN/" + strAno);
                            break; 
                        case 7:                            
                            row.getCell(5).setCellValue("MÊS/ANO: JUL/" + strAno);
                            break;
                        case 8:                            
                            row.getCell(5).setCellValue("MÊS/ANO: AGO/" + strAno);
                            break;
                        case 9:                            
                            row.getCell(5).setCellValue("MÊS/ANO: SET/" + strAno);
                            break;
                        case 10:                            
                            row.getCell(5).setCellValue("MÊS/ANO: OUT/" + strAno);
                            break;
                        case 11:                            
                            row.getCell(5).setCellValue("MÊS/ANO: NOV/" + strAno);
                            break;
                        case 12:                            
                            row.getCell(5).setCellValue("MÊS/ANO: DEZ/" + strAno);
                            break;                                                                    
                    }                                        
                }

                if (i % numLinhasDaFolha == 3)
                {
                    Row row = FOLHAS.getRow(i);
                    Cell cell = row.getCell(5);
                    cell.setCellStyle(wrapStyle);                    
                    cell.setCellValue("DEPARTAMENTO: \n" + currentSetor);
                }

                // Registrando o turno
                if (i % numLinhasDaFolha == 4)
                {
                    Row row = FOLHAS.getRow(i);
                    row.getCell(6).setCellValue(currentTurno);
                }
                
                if ((i % numLinhasDaFolha >= 7) && (i % numLinhasDaFolha <= 37)) 
                {    
                    // Laço para preencher os dias da semana baseado na data do primeiro registro de registros
                    // O laço com indice j deve ser executado somente quando i % numLinhasDaFolha seja 7
                    // para não reescrever os dias da semana toda vez que o contador i seja incrementado
                    if (i % numLinhasDaFolha == 7) 
                    {
                        // Loop para preencher os dias da semana: SEGUNDA-FEIRA, TERÇA-FEIRA, etc.
                        for (int j = i; j % numLinhasDaFolha <= 37; j++) 
                        {
                            Row row = FOLHAS.getRow(j);                            
                            // parse transforma a string em Localdate; getDayOfWeek().getValue() associa os dias da semana
                            // aos números inteiros de zero (sunday) até seis (saturday)  
                            // dayOfCurrentRow serve para indicar o dia do mês da linha atual considerada na planilha
                            // mes e ano servirão para armazenar o primeiro dia do do mês e do ano informados
                            // o valor -6 é para percorrer os dias de um mês a partir do dia 1°, pois 7 <= j <= 37
                            int dayOfCurrentRow = j % numLinhasDaFolha - 6;                                 
                            int mes = LocalDate.parse(registrosDoMesSelecionado.get(0).getDate(), DATE_FORMATTER).getMonthValue();  
                            int ano = LocalDate.parse(registrosDoMesSelecionado.get(0).getDate(), DATE_FORMATTER).getYear();  
                            // strDia, strMes e strAno servem para concatenar o zero caso o dia ou mês informado possuam somente um dígito
                            // para que o LocalDate possa pegar a formatação correta de dd/MM/yyyy 
                            String strDia = "0" + String.valueOf(dayOfCurrentRow);
                            String strMes = "0" + String.valueOf(mes);  
                            String strAno = String.valueOf(ano);                    
                            strDia = strDia.substring(strDia.length() - 2);  
                            strMes = strMes.substring(strMes.length() - 2);
                        
                            String dateOfCurrentRow = strDia + "/" + strMes + "/" + strAno;    
                            DayOfWeek diaDaSemana =  LocalDate.parse(dateOfCurrentRow, DATE_FORMATTER).getDayOfWeek();                                               
                            // Configura o dia da semana conforme a data                            
                            switch (diaDaSemana) 
                            {                                
                                case MONDAY:                             
                                    row.getCell(1).setCellValue("SEGUNDA");
                                    break;
                                case TUESDAY:                             
                                    row.getCell(1).setCellValue("TERÇA");
                                    break;
                                case WEDNESDAY:                             
                                    row.getCell(1).setCellValue("QUARTA");
                                    break;
                                case THURSDAY:                             
                                    row.getCell(1).setCellValue("QUINTA");
                                    break;
                                case FRIDAY:                            
                                    row.getCell(1).setCellValue("SEXTA");
                                    break;
                                case SATURDAY:                                                             
                                    row.getCell(1).setCellValue("SÁBADO");                                    
                                    break;
                                case SUNDAY:                             
                                    row.getCell(1).setCellValue("DOMINGO");
                                    row.getCell(6).setCellValue("DOMINGO");
                                break;
                            }
                        }
                    }                 
                         
                    // Testa se a string é nula ou vazia para poder calcular a diferença entre as horas de chegada e saída.
                    // trim() é usado para remover espaços em branco que possam haver antes e depois de algum conteúdo da célula.
                    // Pesquisar sobre Java short-circuit na avaliação de expressões lógicas
                     
                    try 
                    {                        
                        Row row = FOLHAS.getRow(i);                       
                        // dayOfCurrentRow identifica a linha correspondente ao dia do mês que está sendo considerado na planilha.                       
                        int dayOfCurrentRow = i % numLinhasDaFolha - 6; 
                        // diaRegistrado é o dia do registro corrente que está sendo lido.
                        currentDate = registrosDoMesSelecionado.get(index).getDate();
                        int currentDay = LocalDate.parse(currentDate, DATE_FORMATTER).getDayOfMonth();
                        currentBeginTime = registrosDoMesSelecionado.get(index).getBeginTime();
                        currentEndTime = registrosDoMesSelecionado.get(index).getEndTime();                        
                        if ((currentBeginTime != null &&
                            !currentBeginTime.trim().isEmpty()) || 
                            (currentEndTime != null &&
                            !currentEndTime.trim().isEmpty()))                             
                        {
                            // Calculando os atrasos e determinando os dias de falta
                            // É subtraido 6 pois 7 <= i <= 37                                                           
                            int mesCorrente = LocalDate.parse(registrosDoMesSelecionado.get(0).getDate(), DATE_FORMATTER).getMonthValue();  
                            int anoCorrente = LocalDate.parse(registrosDoMesSelecionado.get(0).getDate(), DATE_FORMATTER).getYear();  
                            // strDia, strMes e strAno servem para concatenar o zero caso o dia ou mês informado possuam somente um dígito
                            // para que o LocalDate possa pegar a formatação correta de dd/MM/yyyy 
                            String strDia = "0" + String.valueOf(dayOfCurrentRow);
                            String strMes = "0" + String.valueOf(mesCorrente);  
                            String strAno = String.valueOf(anoCorrente);                    
                            strDia = strDia.substring(strDia.length() - 2);  
                            strMes = strMes.substring(strMes.length() - 2);
                        
                            String dataCorrente = strDia + "/" + strMes + "/" + strAno;    
                            DayOfWeek diaDaSemana =  LocalDate.parse(dataCorrente, DATE_FORMATTER).getDayOfWeek();

                            // LocalTime.parse(String) transforma uma string para o tipo LocalTime
                            // LocalDate data = LocalDate.parse(registros.get(index).getDate());
                            // Usando a biblioteca Collator para comparar strings ignorando case e accent
                            final Collator compararTurnos = Collator.getInstance();     
                            compararTurnos.setStrength(Collator.PRIMARY);
                            // String turno = registros.get(index).getTurno();                        
                            // Estabelecendo os LocaTime das horas de entrada e saida do funcionário, assim como
                            // os horários de entrada e saída dos turnos da manhã e tarde da central
                            LocalTime entrada = LocalTime.parse(currentBeginTime);                            
                            LocalTime saida = LocalTime.parse("00:00:00", TIME_FORMATTER);                           
                            if (!currentEndTime.trim().isEmpty() && currentEndTime != null)
                            {
                                saida = LocalTime.parse(currentEndTime, TIME_FORMATTER);
                            }                                                          
                            LocalTime horaEntradaManha = LocalTime.parse(HORA_ENTRADA_MANHA, TIME_FORMATTER);
                            LocalTime horaSaidaManha = LocalTime.parse(HORA_SAIDA_MANHA, TIME_FORMATTER);
                            LocalTime horaEntradaTarde = LocalTime.parse(HORA_ENTRADA_TARDE, TIME_FORMATTER);
                            LocalTime horaSaidaTarde = LocalTime.parse(HORA_SAIDA_TARDE, TIME_FORMATTER);
                            LocalTime horaEntradaSabado = LocalTime.parse(HORA_ENTRADA_SABADO, TIME_FORMATTER);
                            LocalTime horaSaidaSabado = LocalTime.parse(HORA_SAIDA_SABADO, TIME_FORMATTER);
                            // a diferença entre a horaSaidaManha e horaEntradaManha é a mesma que a diferença entre
                            // horaSaidaTarde e horaentradaTarde (6:20:00)
                            Duration tempoTrabalhado = Duration.between(horaEntradaManha, horaSaidaManha);                     
                            Duration atrasoTotal = Duration.ZERO;
                            // Calculando o tempo de atraso, considerando que há atraso na entrada quando o funcionário chega depois
                            // do horário e que há atraso na saída quando o funcionário sai antes do horário
                            
                            if (compararTurnos.compare(currentTurno, "MANHA") == 0) // Verifica se o turno do funcionário é manhã
                            {   
                                Duration atrasoEntrada, atrasoSaida;
                                if(diaDaSemana.compareTo(DayOfWeek.SATURDAY) == 0)
                                {
                                    atrasoEntrada = Duration.between(horaEntradaSabado, entrada);
                                }
                                else
                                {
                                    atrasoEntrada = Duration.between(horaEntradaManha, entrada);
                                }                                                     
                                if (saida.compareTo( LocalTime.parse("00:00:00", TIME_FORMATTER)) == 0)
                                {                                   
                                    saida = horaSaidaManha;
                                }
                                if(diaDaSemana.compareTo(DayOfWeek.SATURDAY) == 0)
                                {
                                    atrasoSaida = Duration.between(saida, horaSaidaSabado);
                                }
                                else
                                {
                                    atrasoSaida = Duration.between(saida, horaSaidaManha);
                                }
                                if (atrasoEntrada.isNegative()) atrasoEntrada = Duration.ZERO;
                                if (atrasoSaida.isNegative()) atrasoSaida = Duration.ZERO;                                                 
                                atrasoTotal = atrasoEntrada.plus(atrasoSaida);
                                Duration temp = tempoTrabalhado.minus(atrasoTotal);
                                tempoTrabalhado = temp; 
                            }
                            // Verifica se o turno do funcionário é tarde
                            else if (compararTurnos.compare(currentTurno, "TARDE") == 0) 
                            {
                                // Caso o funcionário da tarde trabalhe no sábado,
                                // considera-se o horário da manhã
                                if (diaDaSemana.compareTo(DayOfWeek.SATURDAY) == 0) 
                                {
                                    Duration atrasoEntrada = Duration.between(horaEntradaSabado, entrada);
                                    if (saida.compareTo( LocalTime.parse("00:00:00", TIME_FORMATTER)) == 0)
                                    {
                                       saida = horaSaidaSabado;
                                    }
                                    Duration atrasoSaida = Duration.between(saida, horaSaidaSabado);
                                    if (atrasoEntrada.isNegative()) atrasoEntrada = Duration.ZERO;
                                    if (atrasoSaida.isNegative()) atrasoSaida = Duration.ZERO;
                                    atrasoTotal = atrasoEntrada.plus(atrasoSaida);
                                    Duration temp = tempoTrabalhado.minus(atrasoTotal);
                                    tempoTrabalhado = temp;
                                }
                                else
                                {
                                    Duration atrasoEntrada = Duration.between(horaEntradaTarde, entrada);
                                    if (saida.compareTo( LocalTime.parse("00:00:00", TIME_FORMATTER)) == 0)
                                    {
                                       saida = horaSaidaTarde;
                                    }
                                    Duration atrasoSaida = Duration.between(saida, horaSaidaTarde);             
                                    if (atrasoEntrada.isNegative()) atrasoEntrada = Duration.ZERO;
                                    if (atrasoSaida.isNegative()) atrasoSaida = Duration.ZERO;
                                    atrasoTotal = atrasoEntrada.plus(atrasoSaida);
                                    Duration temp = tempoTrabalhado.minus(atrasoTotal);
                                    tempoTrabalhado = temp;
                                }                            
                            }
                           
                            // Formatando o atrasoTotal e o tempoTrabalhado para escrever na planilha
                            seconds = (int) tempoTrabalhado.toSeconds();                            
                            hours = seconds/3600;
                            seconds = seconds - 3600*hours;
                            minutes = seconds/60;
                            seconds = seconds - 60*minutes;
                            
                            // String tempoTrabalhadoToString = String.format("%02d:%02d:%02d", hours, minutes, seconds);

                            seconds = (int) atrasoTotal.toSeconds();
                            int 
                            s = seconds;
                            hours = seconds/3600;
                            seconds = seconds - 3600*hours;
                            minutes = seconds/60;
                            seconds = seconds - 60*minutes;
                            String atrasoTotalToString = String.format("%02d:%02d:%02d", hours, minutes, seconds);

                            // Insere na planilha tempo trabalhado e o atraso total na linha correspondente à data do registro corrente.
                            if (dayOfCurrentRow == currentDay)
                            {                               
                                atrasoTotalEmSegundos += s;
                                // row.getCell(4).setCellValue(tempoTrabalhadoToString.substring(0, 5));
                                row.getCell(4).setCellValue(atrasoTotalToString);                                                                                       
                            }                                                                                                                                   
                        }
                        // Insere na planilha o registro da hora de entrada e saída na linha correspondente à data do registro corrente. 
                        
                        if (dayOfCurrentRow == currentDay)
                        {

                            if (registrosDoMesSelecionado.get(index).getBeginTime() == null || 
                                registrosDoMesSelecionado.get(index).getBeginTime().trim().isEmpty())
                            {                               
                                row.getCell(2).setCellValue("");
                            }                                
                            else
                            {
                                row.getCell(2).setCellValue(registrosDoMesSelecionado.get(index).getBeginTime());
                            }                            
                            if (registrosDoMesSelecionado.get(index).getEndTime() == null ||
                                registrosDoMesSelecionado.get(index).getEndTime().trim().isEmpty())   
                            {
                                row.getCell(3).setCellValue("");
                            }                                
                            else
                            {
                                row.getCell(3).setCellValue(registrosDoMesSelecionado.get(index).getEndTime()); 
                            }
                                                                                     
                            index++;                                 
                        }                         
                    }   catch (Exception exc)
                    {
                        System.out.println("Exception!");
                        break;
                    }                                    
                }                              
            }
            // In Apache POI, Excel formulas aren't automatically recalculated when a value changes.
            // When you are finished changing the values of any cells referenced in formulas, create a FormulaEvaluator and tell it to evaluate all formulas with the evaluateAll method.
            // Or you can force Excel to re-calculate formulas upon opening by setting the appropriate flag with setForceFormulaRecalculation on the Workbook.
            
            // FOLHAS.getWorkbook().setForceFormulaRecalculation(true); 
            // XSSFFormulaEvaluator.evaluateAllFormulaCells(workbookFolhas);                   
            try (FileOutputStream outputStream = new FileOutputStream(COPIED_FOLHAS)) 
            {
                workbookFolhas.write(outputStream);
            }
            workbookFolhas.close();
        } catch (IOException e) {}   
                     
    }

    static class Registro {
        private String id;
        private String name;
        private String setor;
        private String turno;
        private String beginTime;
        private String endTime;
        private String date;

        public Registro(String id, String name) {
            this.id = id;
            this.name = name;
        }
        public Registro(String id, String name, String setor, String turno) {
            this.id = id;
            this.name = name;
            this.setor = setor;
            this.turno = turno;
        }

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getSetor() {
            return setor;
        }

        public String getTurno() {
            return turno;
        }

        public String getBeginTime() {
            return beginTime;
        }

        public String getEndTime() {
            return endTime;
        }

        public String getDate(){
            return date;
        }

        public void setSetor(String setor) {
            this.setor = setor;
        }        

        public void setTurno(String turno) {
            this.turno = turno;
        }

        public void setBeginTime(String beginTime) {
            this.beginTime = beginTime;
        }       

        public void setEndTime(String endTime) {
            this.endTime = endTime;
        }        

        public void setDate(String date) {
            this.date = date;
        }

        @Override
        public String toString() {
            return "Registro{" +
                    "id='" + id + '\'' +
                    ", name='" + name + '\'' +
                    ", setor='" + setor + '\'' +
                    ", turno='" + turno + '\'' + 
                    ", beginTime='" + beginTime + '\'' +
                    ", endTime='" + endTime + '\'' +
                    ", date='" + date + '\'' +
                    '}';
        }
    }

    static class SortByName implements java.util.Comparator<Registro> {
        // classe para implementar um comparador para objetos da classe Registro para fazer a ordenação baseada nos nomes dos funcionários
        @Override
        public int compare(Registro r1, Registro r2) {
            final Collator compareIgnoringAccent = Collator.getInstance();     
            compareIgnoringAccent.setStrength(Collator.PRIMARY);   
            return compareIgnoringAccent.compare(r1.name,r2.name);
            // return r1.name.compareTo(r2.name);
        }
    }

    static class SortBySetor implements java.util.Comparator<Registro> {
        // classe para implementar um comparador para objetos da classe Registro para fazer a ordenação baseada nos nomes dos funcionários
        @Override
        public int compare(Registro r1, Registro r2) {            
            final Collator compareIgnoringAccent = Collator.getInstance();     
            compareIgnoringAccent.setStrength(Collator.PRIMARY);         
            return compareIgnoringAccent.compare(r1.setor,r2.setor);
        }
    }

    static class SortByDate implements java.util.Comparator<Registro> {
        // classe para implementar um comparador para objetos da classe Registro para fazer a ordenação baseada nos nomes dos funcionários
        @Override
        public int compare(Registro r1, Registro r2) 
        {
            LocalDate date1 = LocalDate.parse(r1.getDate(), DATE_FORMATTER);
            LocalDate date2 = LocalDate.parse(r2.getDate(), DATE_FORMATTER);
            if (date1.isBefore(date2)) return -1;
            if (date1.isAfter(date2)) return 1;
            else return 0;
        }
    }

}

