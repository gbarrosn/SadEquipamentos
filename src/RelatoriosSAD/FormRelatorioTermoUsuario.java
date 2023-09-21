package RelatoriosSAD;


import com.cete.dynamicpdf.*;
import com.cete.dynamicpdf.pageelements.Label;
import com.cete.dynamicpdf.forms.FormField;
import com.cete.dynamicpdf.forms.FormFieldList;
import com.cete.dynamicpdf.forms.FormField;
import com.cete.dynamicpdf.forms.TextField;
import com.cete.dynamicpdf.PageElement;
import com.cete.dynamicpdf.merger.MergeDocument;
import com.cete.dynamicpdf.merger.forms.PdfTextField;

import Usuario.Usuario;
/*
MergeDocument document = new MergeDocument( pdfFilePath );
// Set the field values
document.Form.Fields["TextBox1"].Value = "My Text"; // TextBox field
document.Form.Fields["CheckBox1"].Value = "Yes"; // CheckBox field
document.Form.Fields["ComboBox1"].Value = "Item4"; // ComboBox field
document.Form.Fields["RadioButton1"].Value = "Item2"; // RadioButton field
ListBoxField listBox = (ListBoxField) document.Form.Fields["ListBox1"]; // ListBox field
listBox.SetValues( new string[] { "Item1", "Item3", "Item5" } );
// Save the PDF
document.Draw(pdfFilePath);
MergeDocument document = new MergeDocument(@"OutputPDF.pdf");
document.Pages[0].ReaderEvents.Open = new ImportFormDataAction("FDF file path");
document.Draw(outputPath);

using ceTe.DynamicPDF;
using ceTe.DynamicPDF.PageElements.Forms;
using ceTe.DynamicPDF.PageElements;

public class Example
{
    public static void CreatePDF(string fdfFilePath, string outputPath)
    {
        // Create a PDF Document
        Document document = new Document();

        // Create a page and add it to the document
        Page page = new Page();
        document.Pages.Add(page);

        Button button = new Button("btn", 50, 150, 100, 30);
        button.Label = "Click Here";

        // Create label and text field
        Label label1 = new Label("Click the button to fill the text field using import data action: ", 50, 100, 250, 30);
        ceTe.DynamicPDF.PageElements.Forms.TextField field = new ceTe.DynamicPDF.PageElements.Forms.TextField("Text1", 320, 100, 100, 30);

        // Add the label and form fields to the page
        page.Elements.Add(button);
        page.Elements.Add(field);
        page.Elements.Add(label1);

        // Create a import form data action and assign to the button events.
        ImportFormDataAction action = new ImportFormDataAction(fdfFilePath);
        button.ReaderEvents.MouseUp = action;

        // Save the PDF
        document.Draw(outputPath);
    }
}
 */
public class FormRelatorioTermoUsuario {
    private Usuario usuario;

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

            //import an existing pdf form and fill the fields
            MergeDocument document = new MergeDocument("termoForm.pdf");

            document.getForm().getFields().getFormField("texto_nome").setValue(nome);
            document.getForm().getFields().getFormField("texto_cesu").setValue(CESU);
            document.getForm().getFields().getFormField("texto_tomboMicro").setValue(tomboMicro);
            document.getForm().getFields().getFormField("texto_tomboMonitor").setValue(tomboMonitor);
            document.getForm().getFields().getFormField("texto_tomboMonitor1").setValue(tomboMonitor1);
            document.getForm().getFields().getFormField("texto_serieMicro").setValue(serieMicro);
            document.getForm().getFields().getFormField("texto_serieMonitor").setValue(serieMonitor);
            document.getForm().getFields().getFormField("texto_serieMonitor1").setValue(serieMonitor1);
            document.getForm().getFields().getFormField("texto_modeloMicro").setValue(modeloMicro);

            //save the pdf
            document.draw("termo de responsabilidade " +nome+ ".pdf");


        } catch (Exception e) {

        }

    }


}
