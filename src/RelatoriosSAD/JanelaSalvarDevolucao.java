package RelatoriosSAD;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.plaf.FileChooserUI;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocument.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class JanelaSalvarDevolucao extends javax.swing.JFrame {

    private PDDocument documento;

    public JanelaSalvarDevolucao() {
        initComponents();
    }

    final void icone() {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("resources\\favicon-cor.png"));
            this.setIconImage(img);
        } catch (IOException e) {
            // Handle the exception appropriately
        }
    }

    public JanelaSalvarDevolucao(PDDocument documento, String nomeUsuario) {
        icone();
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Salvar Termo de Devolução em PDF");
        this.documento = documento;

        String defaultFile = "Termo de Devolução - " + nomeUsuario;

        try {
            janelaSalvarDevolucao.setCurrentDirectory(new File("\\\\sadfs01\\GTINF\\USINF\\Sistema SAD Equipamentos\\Termos de Devolução\\"));
            FileChooserUI fcUi = janelaSalvarDevolucao.getUI();
            Class<? extends FileChooserUI> fcClass = fcUi.getClass();
            Method setFileName = fcClass.getMethod("setFileName", String.class);
            setFileName.invoke(fcUi, defaultFile);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Erro - " + e.getMessage());
        }
    }

    private void initComponents() {
        janelaSalvarDevolucao = new javax.swing.JFileChooser();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        janelaSalvarDevolucao.setDialogType(JFileChooser.SAVE_DIALOG);
        janelaSalvarDevolucao.setApproveButtonToolTipText("");
        janelaSalvarDevolucao.setDialogTitle("Salvar Termo");
        janelaSalvarDevolucao.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                janelaSalvarDevolucaoActionPerformed(evt);
            }
        });
        janelaSalvarDevolucao.addPropertyChangeListener(new PropertyChangeListener() {
            public void propertyChange(PropertyChangeEvent evt) {
                janelaSalvarDevolucaoPropertyChange(evt);
            }
        });

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(janelaSalvarDevolucao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(janelaSalvarDevolucao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        pack();
    }

    private void janelaSalvarDevolucaoPropertyChange(PropertyChangeEvent evt) {
        // TODO add your handling code here
    }

    private void janelaSalvarDevolucaoActionPerformed(ActionEvent evt) {
        try {
            String nomeDoArquivo = janelaSalvarDevolucao.getSelectedFile() + ".pdf";

            if (!nomeDoArquivo.equals("null.pdf")) {
                this.documento.save(nomeDoArquivo);
                JOptionPane.showMessageDialog(rootPane, "Termo de Devolução gerado com sucesso em:   \n" + "\"" + nomeDoArquivo + "\"");
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
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JanelaSalvarDevolucao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JanelaSalvarDevolucao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JanelaSalvarDevolucao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JanelaSalvarDevolucao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JanelaSalvarDevolucao().setVisible(true);
            }
        });
    }

    private javax.swing.JFileChooser janelaSalvarDevolucao;
}
