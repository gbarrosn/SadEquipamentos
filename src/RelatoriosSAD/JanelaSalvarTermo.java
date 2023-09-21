package RelatoriosSAD;

import SADpe.Pavimento.Pavimento;
import com.cete.dynamicpdf.Document;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.plaf.FileChooserUI;
public class JanelaSalvarTermo extends javax.swing.JFrame {

    /**
     * Creates new form JanelaSalvar
     */
    public JanelaSalvarTermo() {
            initComponents();
            }


    final void icone() {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("src\\resources\\favicon-cor.png"));
            this.setIconImage(img);
        } catch (IOException e) {
        }
    }

    private Document documento;

    public JanelaSalvarTermo(Document documento, String nomeUsuario) {
        icone();
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Salvar Termo de Responsabilidade em PDF");
        this.documento = documento;

        String defaultFile="";
        Date data = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String dataString;
        dataString = dateFormat.format(data);

defaultFile = "Termo de Responsabilidade - "+nomeUsuario;


        try {

            FileChooserUI fcUi = janelaSalvarTermo.getUI();
            Class<? extends FileChooserUI> fcClass = fcUi.getClass();
            Method setFileName = fcClass.getMethod("setFileName", String.class);
            setFileName.invoke(fcUi, defaultFile);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Erro - " + e.getMessage());
        }

    }
    private void initComponents() {

        janelaSalvarTermo = new javax.swing.JFileChooser();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        janelaSalvarTermo.setDialogType(JFileChooser.SAVE_DIALOG);
        janelaSalvarTermo.setApproveButtonToolTipText("");
        janelaSalvarTermo.setDialogTitle("Salvar Termo");
        janelaSalvarTermo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                janelaSalvarTermoActionPerformed(evt);
            }
        });
        janelaSalvarTermo.addPropertyChangeListener(new PropertyChangeListener() {
            public void propertyChange(PropertyChangeEvent evt) {
                janelaSalvarTermoPropertyChange(evt);
            }
        });

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(janelaSalvarTermo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(janelaSalvarTermo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void janelaSalvarTermoPropertyChange(PropertyChangeEvent evt) {
        // TODO add your handling code here:
    }

    private void janelaSalvarTermoActionPerformed(ActionEvent evt) {
        try {

            //JFileChooser input = new JFileChooser();
            //int result = input.showSaveDialog(this);
            String nomeDoArquivo;
            nomeDoArquivo = janelaSalvarTermo.getSelectedFile() + ".pdf";

            if (!nomeDoArquivo.equals("null.pdf")) {

                this.documento.draw(nomeDoArquivo);
                JOptionPane.showMessageDialog(rootPane, "Termo de Responsabilidade gerado com sucesso em:   \n" + "\"" + nomeDoArquivo + "\"");
                dispose();

            } else if (nomeDoArquivo.equals("null.pdf")) {

                dispose();

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Erro - " + e.getMessage());
        }
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JanelaSalvarTermo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JanelaSalvarTermo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JanelaSalvarTermo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JanelaSalvarTermo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JanelaSalvarTermo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFileChooser janelaSalvarTermo;
    // End of variables declaration//GEN-END:variables


}
