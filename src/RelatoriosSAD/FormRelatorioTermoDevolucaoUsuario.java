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


        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao gerar termo de devolução: " + e);

        }
    }

}
