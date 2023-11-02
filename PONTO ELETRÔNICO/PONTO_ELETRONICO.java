// import java.io.File;
// import java.io.IOException;
import java.io.*;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.UnknownHostException;

import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

import java.awt.Font; //Para usar a classe Font
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;

import javax.swing.JOptionPane; //biblioteca de interface para windows
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;
import javax.swing.Timer;
import javax.swing.border.TitledBorder;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class PONTO_ELETRONICO {
    // private static String password = "oivjaoij64148349u0nkla";
    private static final int PORT = 65000;  // random large port number
    private static ServerSocket s;
    private static Map<String, Employee> employees = new HashMap<>(); // para armazenar os funcionários cadastrados
    private static List<Registro> registros = new ArrayList<Registro>(); // para armazenar os registros de entrada e saída
    private static List<Registro> saidaRegistros = new ArrayList<Registro>();
    private static final String FILE_NAME = "PONTO_ELETRONICO.xlsx";    
    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss");
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/YYYY");       

    // static initializer para testar se o programa já está em execução. Neste caso, 
    // ele não permite a execução de uma nova instância do programa.
    static 
    {
        try {
            s = new ServerSocket(PORT, 10, InetAddress.getLocalHost());
        } catch (UnknownHostException e) {
            // shouldn't happen for localhost
        } catch (IOException e) {
            // port taken, so app is already running
            System.out.print("Application is already running,");
            System.out.println(" so terminating this instance.");
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Icon logo = new ImageIcon("Icone_governo_pe.PNG");
        Object[] options = {"REGISTRAR ENTRADA", "REGISTRAR SAÍDA", "FECHAR PROGRAMA"};   

        // Configurando os textos das mensagens
        final String TITULO = "EXPRESSO CIDADÃO - PONTO ELETRÔNICO";
        final String opcao = "Por favor, escolha uma opção:";
        final String digitarMatricula = "Digite a matrícula:";
        final String semCadastro = "A matrícula informada não está cadastrada.";
        final String entradaRegistrada = "A entrada já foi registrada.";
        final String saidaRegistrada = "A saída já foi registrada.";
        final int numCaracteres = 28; // Configura o número máximo de caracteres do nome do funcionário a ser exibido
       
        // Configurando a fonte do título, das mensagens e dos botões     
        UIManager.put("OptionPane.buttonFont", new FontUIResource("Arial", Font.BOLD, 22));
        UIManager.put("OptionPane.messageFont", new FontUIResource("Arial", Font.BOLD, 26));
        
        // Carrega a pasta de trabalho na estrutura de dados do JAVA POI
        //loadFromFile();  
      
        while (true) {                      
            int choice = JOptionPane.showOptionDialog(frame, opcao, TITULO,
                    JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE,
                    logo, options, options[2]);
            if (choice == 2) {
                saveToFile();               
                break;
            } else if (choice == 0) { // registra a entrada do funcionário                                
                // Para que o cursor fique no campo de digitação da matrícula é necessário criar e configurar o panel antes de executar
                // o ActionListener e colocar o inputField.requestFocusInWindow dentro do ActionEvent
                loadFromFile();
                // Criando e configurando o JPanel e o frame.
                JTextField inputField = new JTextField(12);
                inputField.setFont(new Font("Arial", Font.BOLD, 24));
                JLabel dateTimeLabel = new JLabel();
                dateTimeLabel.setFont(new Font("Arial", Font.BOLD, 18));
                JPanel panel = new JPanel();
                TitledBorder title = BorderFactory.createTitledBorder(digitarMatricula);
                title.setTitleFont(new Font("Arial", Font.BOLD,18));
                panel.setBorder(title);
                panel.add(inputField);
                panel.add(dateTimeLabel);
                frame.add(panel);
                panel.setPreferredSize(new Dimension(300, 100)); 
                //------------------------------------------------------------
                // Configurando o ActionListener para exibir hora e data ao usuário
                Timer timer = new Timer(250, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        dateTimeLabel.setText(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm:ss")));
                        inputField.requestFocusInWindow();
                    }
                });  
                timer.start();                
                JOptionPane.showConfirmDialog(frame, panel, TITULO, JOptionPane.PLAIN_MESSAGE, JOptionPane.PLAIN_MESSAGE);                
                timer.stop();
                //------------------------------------------------------------
                String id = inputField.getText();                
                // Removendo todos os caracteres que não são numéricos informados pelo usuário
                id = id.replaceAll("[^0-9]", "");
                // Laço para procurar o id, removendo todos os caracteres não numéricos para comparar somente os números da cada string
                for (Employee employee : employees.values()) {
                    if (id.equals(employee.getId().replaceAll("[^0-9]", ""))) {
                        id = employee.getId();
                        break;
                    }
                }
                Employee employee = employees.get(id);
                // Teste para saber se o usuário informou uma matrícula válida
                if (employee == null || id.isEmpty()) {
                    JOptionPane.showMessageDialog(null,semCadastro, 
                                                    TITULO, JOptionPane.WARNING_MESSAGE);
                } else {
                    // Cria um novo registro que é anexado à lista de registros se algumas condições forem satisfeitas.
                    // TIME e DATE FORMATTER são usados para configurar o formato desejado de apresentação de hora e data.                                      
                    Registro registro = new Registro(employee.getId(),employee.getName(), employee.getSetor(), employee.getTurno());
                    String date = java.time.LocalDate.now().format(DATE_FORMATTER);   
                    // Atualizar a data do registro
                    registro.setDate(date);                
                    // Laço para identificar se a matrícula informada já foi registrada
                    boolean setBeginTime = true; 
                    // Testa se a entrada foi registrada. registros.size() > 0 é testado para identificar se a planilha 
                    // REGISTROS não possui nenhum registro
                    // laço for substituido por while para evitar que o registros.get() tente acessar um índice menor que zero
                    int index = registros.size() - 1;
                    // BUG DETECTADO: para verificar corretamente se já houve uma entrada registrada, deve-se percorrer o index até index == 0.
                    while (index >= 0) {                                  
                        // procura se já há um registro de entrada do funcionário com este id na data atual           
                        if ( registros.get(index).getDate().equals(registro.getDate())){  
                                if (registros.get(index).getId().equals(registro.getId()) /*&& registros.get(index).getBeginTime() != null*/) {                               
                                    JOptionPane.showMessageDialog(null,entradaRegistrada, 
                                                                    TITULO, JOptionPane.WARNING_MESSAGE); 
                                                                    registros.clear();
                                                                    frame.dispose();
                                                                    main(null);
                                    setBeginTime = false;
                                    break;                         
                                }                            
                        }  
                        // Decrementar o index para não cair num loop
                        index--;
                    }
                    // Executa o if se a hora de entrada pode ser registrada, isto é, se a matrícula é válida e se a entrada ainda não foi registrada
                    if (setBeginTime){                           
                        String beginTime =  LocalTime.now().format(TIME_FORMATTER);             
                        registro.setBeginTime(beginTime); 
                        registro.setEndTime("");                       
                        registros.add(registro);
                        // para capturar uma string com "numCaracteres" caracteres e tratar a excessão quando o método substring
                        // tenta acessar índice fora do limite.
                        int length = registro.getName().length();
                        length  = length < (numCaracteres) ? length : numCaracteres;
                        saveToFile(); // Salva o registro na planilha REGISTROS       
                        registros.clear();                
                        String mensagem =   "Entrada de " + registro.getName().substring(0, length) + 
                                            " registrada com sucesso!";
                                JOptionPane.showMessageDialog(null, mensagem, 
                                                            TITULO, JOptionPane.DEFAULT_OPTION);
                                                            frame.dispose();
                                                            main(null);                        
                    }                   
                } System.gc();
            } else if (choice == 1) { // Registra a saída do funcionário                  
                // Para que o cursor fique no campo de digitação da matrícula é necessário criar e configurar o panel antes de executar
                // o ActionListener e colocar o inputField.requestFocusInWindow dentro do ActionEvent

                lerEntradas();
                // Criando e configurando o JPanel e o frame.
                JTextField inputField = new JTextField(12);
                inputField.setFont(new Font("Arial", Font.BOLD, 24));
                JLabel dateTimeLabel = new JLabel();
                dateTimeLabel.setFont(new Font("Arial", Font.BOLD, 18));
                JPanel panel = new JPanel();
                TitledBorder title = BorderFactory.createTitledBorder(digitarMatricula);
                title.setTitleFont(new Font("Arial", Font.BOLD,18));
                panel.setBorder(title);
                panel.add(inputField);
                panel.add(dateTimeLabel);
                frame.add(panel);
                panel.setPreferredSize(new Dimension(300, 100)); 
                //-----------------------------------------------------------
                // Configurando o ActionListener para exibir data e hora
                Timer timer = new Timer(250, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        dateTimeLabel.setText(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm:ss")));
                        inputField.requestFocusInWindow();
                    }
                });  
                timer.start();                   
                JOptionPane.showConfirmDialog(frame, panel, TITULO, JOptionPane.PLAIN_MESSAGE, JOptionPane.PLAIN_MESSAGE);                
                timer.stop();
                //-----------------------------------------------------------
                String id = inputField.getText();                
                // Removendo todos os caracteres que não são numéricos informados pelo usuário
                id = id.replaceAll("[^0-9]", "");
                // Laço para procurar o id, removendo todos os caracteres não numéricos para comparar somente os números da cada string
                for (Employee employee : employees.values()) {
                    if (id.equals(employee.getId().replaceAll("[^0-9]", ""))) {
                        id = employee.getId();
                        break;
                    }
                }                   
                Employee employee = employees.get(id);
                // Teste para saber se o usuário informou uma matrícula válida
                if (employee == null) {
                    JOptionPane.showMessageDialog(null,semCadastro,
                                                 TITULO,JOptionPane.WARNING_MESSAGE);
                } else { // registra a saída se a entrada foi registrada
                    String endTime = LocalTime.now().format(TIME_FORMATTER);
                    String date = java.time.LocalDate.now().format(DATE_FORMATTER); 
                    boolean saidaSemEntrada = true;  // Controle para executar instruções caso seja identificado uma tentativa de saída sem entrada     
                    // length é usado para capturar o tamanho de uma string                               
                    // Testa se a entrada foi registrada. registros.size() > 0 é testado para identificar se a planilha 
                    // REGISTROS não possui nenhum registro
                    // laço for substituido por while para evitar que o registros.get() tente acessar um índice menor que zero
                    int index = saidaRegistros.size();                    
                    while (index > 0) {                                          
                        // Laço para registrar a saída. Testa se a saída já foi registrada
                        if ( saidaRegistros.get(index - 1).getDate().equals(date)){                        
                            if (saidaRegistros.get(index - 1).getId().equals(id)) {
                                String str = saidaRegistros.get(index - 1).getEndTime() + "";
                                // Testa se a string é vazia. A célula pode estar vazia mas não ser null.
                                // O teste !str.equals("null") é para tratar o caso em que o programa leia uma célula vazia como
                                // uma string "null". Pois o método "+" trata uma string nula como a string "null"
                                // System.out.println("string: " + str + "\n");

                                if (str.length() != 0 && !str.equals("null")){                               
                                    JOptionPane.showMessageDialog(null, saidaRegistrada, 
                                                                TITULO, JOptionPane.WARNING_MESSAGE); 
                                    saidaSemEntrada = false;
                                    break; 
                                } else {  
                                    // length captura o tamanho de uma string que deve ter no máximo "numCaracteres" caracteres 
                                    // e trata a excessão quando o método substring tenta acessar índice fora do limite.                                       
                                    int length = saidaRegistros.get(index - 1).getName().length();
                                    length  = length < (numCaracteres) ? length : numCaracteres;
                                    saidaRegistros.get(index-1).setEndTime(endTime);                                   
                                    String mensagem =   "Saída de " + saidaRegistros.get(index - 1).getName().substring(0,length) +
                                                        " registrada com sucesso!";
                                    JOptionPane.showMessageDialog(null, mensagem, 
                                                                TITULO, JOptionPane.DEFAULT_OPTION);                                     
                                    saidaSemEntrada = false;
                                    break;
                                }                                                
                            }                  
                        }
                        index--;
                    }
                    if (saidaSemEntrada){
                        // length captura o tamanho de uma string que deve ter no máximo 20 caracteres 
                        // e trata a excessão quando o método substring tenta acessar índice fora do limite  
                        int length = employee.getName().length();
                        length  = length < (numCaracteres) ? length : numCaracteres;                        
                        JOptionPane.showMessageDialog(null, "Funcionária/o " + employee.getName().substring(0,length) +
                                                                            "  não teve sua entrada registrada. \n" +
                                                                            "Saída não registrada.", TITULO, JOptionPane.WARNING_MESSAGE);
                    }                                                                    
                                     
                } 
                registros = saidaRegistros;
                saveToFile();
                registros.clear();
                saidaRegistros.clear();
                System.gc();
            }
        }      
        System.exit(0);   
    }

    private static void lerEntradas(){

        try (FileInputStream file = new FileInputStream(FILE_NAME)){
            // A planilha terá duas abas. A primeira com a lista de funcionários cadastrados.
            // A segunda com os registros de entrada e saída.
       
            // POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(FILE_NAME));           
            // EncryptionInfo info  = new EncryptionInfo(fs);            
            XSSFWorkbook workbook = new XSSFWorkbook(file);    
            Sheet FUNCIONARIOS = workbook.getSheetAt(0);
            Sheet REGISTROS = workbook.getSheetAt(1);
            String MATRICULA = "";
            String NOME = "";
            String SETOR = "";
            String TURNO = "";
            String ENTRADA = "";
            String SAIDA = "";
            String DATA = "";

            
            // Laço para carregar os registros de todos os funcionários da unidade
            try {
                for (int i = 1; i <= FUNCIONARIOS.getLastRowNum(); i++)
                {
                    Row row = FUNCIONARIOS.getRow(i);
                    // The getCell method has a second argument that specifies a policy for handling empty cells.
                    //Cell cell = row.getCell(0, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL); 
                    
                    if (row != null /*&& cell != null*/) {
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
                        if (row.getCell(2) == null) {
                            SETOR = "";
                        } else {
                            Cell c = row.getCell(2);
                            DataFormatter fmt = new DataFormatter();
                            CellReference cr = new CellReference(c);
                            cr.formatAsString();// Formatando a célula como uma string
                            SETOR = fmt.formatCellValue(c);
                        }     
                        if (row.getCell(3) == null) {
                            TURNO = "";
                        } else {
                            Cell c = row.getCell(3);
                            DataFormatter fmt = new DataFormatter();
                            CellReference cr = new CellReference(c);
                            cr.formatAsString();// Formatando a célula como uma string
                            TURNO = fmt.formatCellValue(c);
                        }                                        
                                    
                        // System.out.println(MATRICULA);
                        Employee employee = new Employee(MATRICULA, NOME, SETOR, TURNO);
                        employees.put(MATRICULA, employee);
                    }  
                    else 
                    {
                        // sai do laço se encontrou alguma linha null.
                        break;
                    }
                }                                           
            } catch (Exception e) {}     

            
            //  Laço para armazenar os registros de entrada e saída
            try
            {
                for (int i = 1; i <= REGISTROS.getLastRowNum(); i++) {
                Row row = REGISTROS.getRow(i);
                // The getCell method has a second argument that specifies a policy for handling empty cells.
                // Cell cell = row.getCell(0, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL); 
                if (row != null /*&& cell != null*/) {
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
                        ENTRADA = fmt.formatCellValue(c);                        
                    }  
                    if (row.getCell(5) != null) {
                        Cell c = row.getCell(5);
                        DataFormatter fmt = new DataFormatter();
                        CellReference cr = new CellReference(c);
                        cr.formatAsString();// Formatando a célula como uma string
                        SAIDA = fmt.formatCellValue(c);                       
                    }
                    if (row.getCell(6) != null) {
                        Cell c = row.getCell(6);
                        DataFormatter fmt = new DataFormatter();
                        CellReference cr = new CellReference(c);
                        cr.formatAsString();// Formatando a célula como uma string
                        DATA = fmt.formatCellValue(c);
                    }

                    Registro registro = new Registro(MATRICULA, NOME, SETOR, TURNO);                    
                    registro.setBeginTime(ENTRADA);
                    registro.setEndTime(SAIDA);
                    registro.setDate(DATA);
                    saidaRegistros.add(registro);
                } 
                else
                {
                    // Sai do laço se encontrou alguma linha null.
                    break;
                }               
                }
            } catch (Exception e) {}
            
            workbook.close();
        } catch (IOException ex) {
            throw new RuntimeException("Arquivo não encontrado.", ex);
        }        
    }

    private static void loadFromFile() {
                
        try (FileInputStream file = new FileInputStream(FILE_NAME)){
            // A planilha terá duas abas. A primeira com a lista de funcionários cadastrados.
            // A segunda com os registros de entrada e saída.
       
            // POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(FILE_NAME));           
            // EncryptionInfo info  = new EncryptionInfo(fs);            
            XSSFWorkbook workbook = new XSSFWorkbook(file);    
            Sheet FUNCIONARIOS = workbook.getSheetAt(0);
            Sheet REGISTROS = workbook.getSheetAt(1);
            String MATRICULA = "";
            String NOME = "";
            String SETOR = "";
            String TURNO = "";
            String ENTRADA = "";
            String SAIDA = "";
            String DATA = "";

            // Laço para carregar os registros de todos os funcionários da unidade
            try {
                for (int i = 1; i <= FUNCIONARIOS.getLastRowNum(); i++)
                {
                    Row row = FUNCIONARIOS.getRow(i);
                    // The getCell method has a second argument that specifies a policy for handling empty cells.
                    //Cell cell = row.getCell(0, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL); 
                    
                    if (row != null /*&& cell != null*/) {
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
                        if (row.getCell(2) == null) {
                            SETOR = "";
                        } else {
                            Cell c = row.getCell(2);
                            DataFormatter fmt = new DataFormatter();
                            CellReference cr = new CellReference(c);
                            cr.formatAsString();// Formatando a célula como uma string
                            SETOR = fmt.formatCellValue(c);
                        }     
                        if (row.getCell(3) == null) {
                            TURNO = "";
                        } else {
                            Cell c = row.getCell(3);
                            DataFormatter fmt = new DataFormatter();
                            CellReference cr = new CellReference(c);
                            cr.formatAsString();// Formatando a célula como uma string
                            TURNO = fmt.formatCellValue(c);
                        }                                        
                                    
                        // System.out.println(MATRICULA);
                        Employee employee = new Employee(MATRICULA, NOME, SETOR, TURNO);
                        employees.put(MATRICULA, employee);
                    }  
                    else 
                    {
                        // sai do laço se encontrou alguma linha null.
                        break;
                    }
                }                                           
            } catch (Exception e) {}     

            
            //  Laço para armazenar os registros de entrada e saída
            try
            {
                for (int i = 1; i <= REGISTROS.getLastRowNum(); i++) {
                Row row = REGISTROS.getRow(i);
                // The getCell method has a second argument that specifies a policy for handling empty cells.
                // Cell cell = row.getCell(0, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL); 
                if (row != null /*&& cell != null*/) {
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
                        ENTRADA = fmt.formatCellValue(c);                        
                    }  
                    if (row.getCell(5) != null) {
                        Cell c = row.getCell(5);
                        DataFormatter fmt = new DataFormatter();
                        CellReference cr = new CellReference(c);
                        cr.formatAsString();// Formatando a célula como uma string
                        SAIDA = fmt.formatCellValue(c);                       
                    }
                    if (row.getCell(6) != null) {
                        Cell c = row.getCell(6);
                        DataFormatter fmt = new DataFormatter();
                        CellReference cr = new CellReference(c);
                        cr.formatAsString();// Formatando a célula como uma string
                        DATA = fmt.formatCellValue(c);
                    }

                    Registro registro = new Registro(MATRICULA, NOME, SETOR, TURNO);                    
                    registro.setBeginTime(ENTRADA);
                    registro.setEndTime(SAIDA);
                    registro.setDate(DATA);
                    registros.add(registro);
                } 
                else
                {
                    // Sai do laço se encontrou alguma linha null.
                    break;
                }               
                }
            } catch (Exception e) {}
            
            workbook.close();
        } catch (IOException ex) {
            throw new RuntimeException("Arquivo não encontrado.", ex);
        }        
    }

    private static void saveToFile() {
        try (FileInputStream file = new FileInputStream(FILE_NAME);
            Workbook workbook = new XSSFWorkbook(file)) {                
            Sheet FUNCIONARIOS = workbook.getSheet("FUNCIONARIOS");
            Sheet REGISTROS = workbook.getSheet("REGISTROS");
            // Criação da linha de cabeçalho da planilha FUNCIONARIOS
            Row FheaderRow = FUNCIONARIOS.createRow(0);
            FheaderRow.createCell(0).setCellValue("MATRICULA");
            FheaderRow.createCell(1).setCellValue("NOME");
            FheaderRow.createCell(2).setCellValue("SETOR");
            FheaderRow.createCell(3).setCellValue("TURNO");

            // Criação da linha de cabeçalho da planilha REGISTROS
            Row RheaderRow = REGISTROS.createRow(0);
            RheaderRow.createCell(0).setCellValue("MATRICULA");
            RheaderRow.createCell(1).setCellValue("NOME");
            RheaderRow.createCell(2).setCellValue("SETOR");
            RheaderRow.createCell(3).setCellValue("TURNO");
            RheaderRow.createCell(4).setCellValue("HORA DE ENTRADA");
            RheaderRow.createCell(5).setCellValue("HORA DE SAIDA");
            RheaderRow.createCell(6).setCellValue("DATA");

            int rowNum = 1;            
            // Atualizando os registros de entrada e saída da planilha REGISTROS.
            for (Registro registro : registros) {
                Row row = REGISTROS.createRow(rowNum++);
                row.createCell(0).setCellValue(registro.getId());
                row.createCell(1).setCellValue(registro.getName());
                row.createCell(2).setCellValue(registro.getSetor());
                row.createCell(3).setCellValue(registro.getTurno());
                row.createCell(4).setCellValue(registro.getBeginTime());
                row.createCell(5).setCellValue(registro.getEndTime());
                row.createCell(6).setCellValue(registro.getDate());                                            
            }
            // Ajustando a ordem das planilhas da pasta de trabalho
            workbook.setSheetOrder("FUNCIONARIOS", 0);
            workbook.setSheetOrder("REGISTROS", 1);

            // Ajustando a largura das colunas de FUNCIONARIOSao conteúdo das células
            for (int i = 0; i <= 3; i++) {
                    FUNCIONARIOS.autoSizeColumn(i);
                }
            for (int i = 0; i <= 6; i++) {
                REGISTROS.autoSizeColumn(i);
            }
            // FileLock é usado para bloquear outras instâncias da planilha de serem abertas
            try (FileOutputStream outputStream = new FileOutputStream(FILE_NAME);
            FileChannel channel = outputStream.getChannel();
            FileLock lock = channel.lock()) { 
                // write to the channel
                workbook.write(outputStream);
            }           
            workbook.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class Employee {
        private String id;
        private String name;
        private String setor;
        private String turno;

        public Employee(String id, String name) {
            this.id = id;
            this.name = name;
        }           

        public Employee(String id, String name, String setor, String turno) {
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

        @Override
        public String toString() {
            return "Employee{" +
                    "id='" + id + '\'' +
                    ", name='" + name + '\'' + 
                    ", setor='" + setor + '\'' +
                    ", turno='" + turno + '\'' +                   
                    '}';
        }
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
}

