package RelatoriosSAD;

import Usuario.Usuario;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.io.RandomAccessReadBufferedFile;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;

import javax.swing.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FormRelatorioTermoDevolucaoUsuario {

    private final Usuario usuario;

    public FormRelatorioTermoDevolucaoUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void gerarTermoDevolucao() {
        try {

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

            Date data = new Date();
            DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            String dataString;
            dataString = dateFormat.format(data);

            String dataDia = dataString.substring(0, 2);
            String dataMes = dataString.substring(3, 5);
            String dataAno = dataString.substring(6, 10);

            if (usuario.getTombamentoMonitor() == 1) {
                PDDocument document = Loader.loadPDF(new RandomAccessReadBufferedFile("resources/devolucao1monitor.pdf"));

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
                    acroForm.setNeedAppearances(true);
                    acroForm.flatten();
                    JanelaSalvarTermo janelaSalvarTermo = new JanelaSalvarTermo(document, nome);
                    janelaSalvarTermo.setVisible(true);
                } else {
                    acroForm.setNeedAppearances(true);
                    acroForm.flatten();
                    JanelaSalvarTermo janelaSalvarTermo = new JanelaSalvarTermo(document, nome);
                    janelaSalvarTermo.setVisible(true);
                }

            } else {
                PDDocument document = Loader.loadPDF(new RandomAccessReadBufferedFile("resources/devolucao2monitores.pdf"));

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
                    acroForm.setNeedAppearances(true);
                    acroForm.flatten();
                    JanelaSalvarTermo janelaSalvarTermo = new JanelaSalvarTermo(document, nome);
                    janelaSalvarTermo.setVisible(true);
                } else {
                    acroForm.setNeedAppearances(true);
                    acroForm.flatten();
                    JanelaSalvarTermo janelaSalvarTermo = new JanelaSalvarTermo(document, nome);
                    janelaSalvarTermo.setVisible(true);
                }
            }


        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao gerar termo de devolução: " + e);

        }
    }

}
