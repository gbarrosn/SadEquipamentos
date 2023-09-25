package RelatoriosSAD;
import java.io.IOException;
import java.io.InputStream;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.io.RandomAccessReadWriteBuffer;
import org.apache.pdfbox.io.RandomAccessReadBufferedFile;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.cos.COSDocument;
import java.util.Date;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import com.cete.dynamicpdf.*;
import com.cete.dynamicpdf.pageelements.Label;
import com.cete.dynamicpdf.forms.FormField;
import com.cete.dynamicpdf.forms.FormFieldList;
import com.cete.dynamicpdf.forms.FormField;
import com.cete.dynamicpdf.forms.TextField;
import com.cete.dynamicpdf.PageElement;
import com.cete.dynamicpdf.merger.MergeDocument;
import com.cete.dynamicpdf.merger.forms.PdfTextField;
import com.cete.dynamicpdf.merger.FormFlatteningOptions;
import java.io.File;
import Usuario.Usuario;

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
                    PDDocument document = Loader.loadPDF(new RandomAccessReadBufferedFile(resource.getPath()));

                    if (document == null) {
                        System.out.println("Documento não carregado");
                    } else {
                        System.out.println("Documento carregado com sucesso");
                    }

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
                    acroForm.getField("text_cpf").setValue(cpf);

                    acroForm.flatten();
                    JanelaSalvarTermo janelaSalvarTermo = new JanelaSalvarTermo(document, nome);
                    janelaSalvarTermo.setVisible(true);


            }
            else {
                URL resource = getClass().getResource("/resources/termo2monitores.pdf");
                assert resource != null;
                PDDocument document = Loader.loadPDF(new RandomAccessReadBufferedFile(resource.getPath()));

                if (document == null) {
                    System.out.println("Documento não carregado");
                } else {
                    System.out.println("Documento carregado com sucesso");}
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
                    acroForm.getField("text_cpf").setValue(cpf);

                    acroForm.flatten();

                    JanelaSalvarTermo janelaSalvarTermo = new JanelaSalvarTermo(document, nome);
                    janelaSalvarTermo.setVisible(true);

                    document.close();

                }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
