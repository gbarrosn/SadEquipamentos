package RelatoriosSAD;

import Usuario.Usuario;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.io.RandomAccessReadBufferedFile;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;

import java.net.URL;
import javax.swing.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

/*
PDDocument(COSDocument doc)
Constructor that uses an existing document. The COSDocument that is passed in must be valid.
 */
public class FormRelatorioTermoUsuario {
    private final Usuario usuario;

    public FormRelatorioTermoUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void gerarRelatorio() {
        try {

            // use Usuario object to load the daata

            String nome = usuario.getNome();
            String CESU = String.valueOf(usuario.getEtiquetaCESU());
            String tomboMicro = ManipulaNumero.manipularNumero((int) usuario.getTombamentoMicro());
            String tomboMonitor = ManipulaNumero.manipularNumero((int) usuario.getTombamentoMonitor());
            String tomboMonitor1 = ManipulaNumero.manipularNumero((int) usuario.getTombamentoMonitor1());
            String serieMicro = usuario.getSerieMicro();
            String serieMonitor = usuario.getSerieMonitor();
            String serieMonitor1 = usuario.getSerieMonitor1();
            String modeloMicro = usuario.getModeloMicro().getModelo();
            String gerencia = usuario.getGerencia().getSiglaGerencia();
            String cargo = usuario.getCargo().getCargo();
            String configuracao = usuario.getConfigMicro().getConfiguracao();
            String cpf = usuario.getCpf();

            if (String.valueOf(usuario.getTombamentoMicro()).length() == 4) {
                tomboMicro = "0" + usuario.getTombamentoMicro() + " - SEPLAG";
            }
            else if (String.valueOf(usuario.getTombamentoMicro()).length() == 4 && String.valueOf(usuario.getTombamentoMicro()).substring(0, 1).equals("8")
            || String.valueOf(usuario.getTombamentoMicro()).length() == 5 && String.valueOf(usuario.getTombamentoMicro()).substring(0, 1).equals("6")){
                tomboMicro = "0" + usuario.getTombamentoMicro() + " - SEFAZ";
            }
            else if (String.valueOf(usuario.getTombamentoMicro()).length() == 6 && String.valueOf(usuario.getTombamentoMicro()).substring(0, 3).equals("300")){
                tomboMicro = usuario.getTombamentoMicro() + " - SEFAZ";
            }
            else if (String.valueOf(usuario.getTombamentoMicro()).equals("1")){
                tomboMicro = "Não Informado.";
            }

            if (String.valueOf(usuario.getTombamentoMonitor()).length() == 4) {
                tomboMonitor = "0" + usuario.getTombamentoMonitor() + " - SEPLAG";
            }
            else if (String.valueOf(usuario.getTombamentoMonitor()).length() == 4 && String.valueOf(usuario.getTombamentoMonitor()).substring(0, 1).equals("8")
            || String.valueOf(usuario.getTombamentoMonitor()).length() == 5 && String.valueOf(usuario.getTombamentoMonitor()).substring(0, 1).equals("6")){
                tomboMonitor = "0" + usuario.getTombamentoMonitor() + " - SEFAZ";
            }
            else if (String.valueOf(usuario.getTombamentoMonitor()).length() == 6 && String.valueOf(usuario.getTombamentoMonitor()).substring(0, 3).equals("300")){
                tomboMonitor = usuario.getTombamentoMonitor() + " - SEFAZ";
            }
            else if (String.valueOf(usuario.getTombamentoMonitor()).equals("1")){
                tomboMonitor = "Não Informado.";
            }

            if (usuario.getTombamentoMonitor1() != 1){
                if (String.valueOf(usuario.getTombamentoMonitor1()).length() == 4) {
                    tomboMonitor1 = "0" + usuario.getTombamentoMonitor1() + " - SEPLAG";
                }
                else if (String.valueOf(usuario.getTombamentoMonitor1()).length() == 4 && String.valueOf(usuario.getTombamentoMonitor1()).substring(0, 1).equals("8")
                    || String.valueOf(usuario.getTombamentoMonitor1()).length() == 5 && String.valueOf(usuario.getTombamentoMonitor1()).substring(0, 1).equals("6")){
                    tomboMonitor1 = "0" + usuario.getTombamentoMonitor1() + " - SEFAZ";
                }
                else if (String.valueOf(usuario.getTombamentoMonitor1()).length() == 6 && String.valueOf(usuario.getTombamentoMonitor1()).substring(0, 3).equals("300")){
                    tomboMonitor1 = usuario.getTombamentoMonitor1() + " - SEFAZ";
                }

            }

            if (cpf != null) {
                //foprmatando cpf para o termo
                String cpf1 = cpf.substring(0, 3);
                String cpf2 = cpf.substring(3, 6);
                String cpf3 = cpf.substring(6, 9);
                String cpf4 = cpf.substring(9, 11);
                cpf = cpf1 + "." + cpf2 + "." + cpf3 + "-" + cpf4;
            }
            Date data = new Date();
            DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            String dataString;
            dataString = dateFormat.format(data);

            String dataDia = dataString.substring(0, 2);
            String dataMes = dataString.substring(3, 5);
            String dataAno = dataString.substring(6, 10);

            if (usuario.getTombamentoMonitor1() == 1) {
                URL resource = getClass().getResource("/resources/termo1monitor.pdf");
                assert resource != null;
                String filePath = resource.getPath();
                PDDocument document = Loader.loadPDF(new RandomAccessReadBufferedFile(filePath));

                //PDDocument document = Loader.loadPDF(new RandomAccessReadBufferedFile("resources/termo1monitor.pdf"));

                if (document == null) {
                    System.out.println("Documento não carregado.");
                } else {
                    System.out.println("Documento carregado com sucesso");
                }

                assert document != null;
                PDAcroForm acroForm = document.getDocumentCatalog().getAcroForm();

                acroForm.getField("text_nome").setValue(nome);
                acroForm.getField("text_cesu").setValue(CESU);
                acroForm.getField("text_tomboMicro").setValue(tomboMicro);
                acroForm.getField("text_tomboMonitor").setValue(tomboMonitor);
                acroForm.getField("text_serieMicro").setValue(serieMicro);
                acroForm.getField("text_serieMonitor").setValue(serieMonitor);
                acroForm.getField("text_modeloMicro").setValue(modeloMicro);
                acroForm.getField("text_gerencia").setValue(gerencia);
                acroForm.getField("text_cargo").setValue(cargo);
                acroForm.getField("text_dataDia").setValue(dataDia);
                acroForm.getField("text_dataMes").setValue(dataMes);
                acroForm.getField("text_dataAno").setValue(dataAno);
                acroForm.getField("textarea_config_equipamento").setValue(configuracao);


                if (cpf != null) {
                    acroForm.getField("text_cpf").setValue(cpf);
                    acroForm.setNeedAppearances(false);
                    acroForm.flatten();
                    JanelaSalvarTermo janelaSalvarTermo = new JanelaSalvarTermo(document, nome, configuracao);
                    janelaSalvarTermo.setVisible(true);
                } else {
                    acroForm.setNeedAppearances(false);
                    acroForm.flatten();
                    JanelaSalvarTermo janelaSalvarTermo = new JanelaSalvarTermo(document, nome, configuracao);
                    janelaSalvarTermo.setVisible(true);
                }
            }
            else if (usuario.getNotebook().equals("sim")) {
                URL resource = getClass().getResource("/resources/termoNotebook.pdf");
                assert resource != null;
                String filePath = resource.getPath();
                PDDocument document = Loader.loadPDF(new RandomAccessReadBufferedFile(filePath));

                //PDDOcument document = Loader.loadPDF(new RandomAccessReadBufferedFile("resources/termoNotebook.pdf"));

                if (document == null) {
                    System.out.println("Documento não carregado");
                } else {
                    System.out.println("Documento carregado com sucesso");
                }
                assert document != null;
                PDAcroForm acroForm = document.getDocumentCatalog().getAcroForm();

                    acroForm.getField("text_nome").setValue(nome);
                    acroForm.getField("text_cesu").setValue(CESU);
                    acroForm.getField("text_tomboMicro").setValue(tomboMicro);
                    acroForm.getField("text_serieMicro").setValue(serieMicro);
                    acroForm.getField("text_gerencia").setValue(gerencia);
                    acroForm.getField("texrt_cargo").setValue(cargo);
                    acroForm.getField("text_dataDia").setValue(dataDia);
                    acroForm.getField("text_dataMes").setValue(dataMes);
                    acroForm.getField("text_dataAno").setValue(dataAno);
                    acroForm.getField("textarea_config_equipamento").setValue("Notebook " + configuracao +"\n"+"Mochila, Mouse");

                if (cpf != null && cpf != "null") {
                    acroForm.getField("text_cpf").setValue(cpf);
                    acroForm.setNeedAppearances(true);
                    acroForm.flatten();
                    JanelaSalvarDevolucao janelaSalvarDevolucao = new JanelaSalvarDevolucao(document, nome, configuracao);
                    janelaSalvarDevolucao.setVisible(true);
                } else {
                    acroForm.setNeedAppearances(true);
                    acroForm.flatten();
                    JanelaSalvarDevolucao janelaSalvarDevolucao = new JanelaSalvarDevolucao(document, nome, configuracao);
                    janelaSalvarDevolucao.setVisible(true);
                }

            }
            else {

                URL resource = getClass().getResource("/resources/termo2monitores.pdf");
                assert resource != null;
                String filePath = resource.getPath();
                PDDocument document = Loader.loadPDF(new RandomAccessReadBufferedFile(filePath));

                //PDDocument document = Loader.loadPDF(new RandomAccessReadBufferedFile("resources/termo2monitores.pdf"));

                if (document == null) {
                    System.out.println("Documento não carregado");
                } else {
                    System.out.println("Documento carregado com sucesso");}
                assert document != null;
                PDAcroForm acroForm = document.getDocumentCatalog().getAcroForm();

                    acroForm.getField("text_nome").setValue(nome);
                    acroForm.getField("text_cesu").setValue(CESU);
                    acroForm.getField("text_tomboMicro").setValue(tomboMicro);
                    acroForm.getField("text_tomboMonitor").setValue(tomboMonitor);
                    acroForm.getField("text_tomboMonitor1").setValue(tomboMonitor1);
                    acroForm.getField("text_serieMicro").setValue(serieMicro);
                    acroForm.getField("text_serieMonitor").setValue(serieMonitor);
                    acroForm.getField("text_serieMonitor1").setValue(serieMonitor1);
                    acroForm.getField("text_modeloMicro").setValue(modeloMicro);
                    acroForm.getField("text_gerencia").setValue(gerencia);
                    acroForm.getField("text_cargo").setValue(cargo);
                    acroForm.getField("text_dataDia").setValue(dataDia);
                    acroForm.getField("text_dataMes").setValue(dataMes);
                    acroForm.getField("text_dataAno").setValue(dataAno);
                    acroForm.getField("textarea_config_equipamento").setValue(configuracao);

                    if (cpf != null) {
                        acroForm.getField("text_cpf").setValue(cpf);
                        acroForm.setNeedAppearances(false);
                        acroForm.flatten();
                        JanelaSalvarTermo janelaSalvarTermo = new JanelaSalvarTermo(document, nome, configuracao);
                        janelaSalvarTermo.setVisible(true);
                    } else {
                        acroForm.setNeedAppearances(false);
                        acroForm.flatten();
                        JanelaSalvarTermo janelaSalvarTermo = new JanelaSalvarTermo(document, nome, configuracao);
                        janelaSalvarTermo.setVisible(true);
                    }

                }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao gerar relatório - " + e.getMessage());
        }
    }
}
