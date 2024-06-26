/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Micro.Configuracao;

import Geral.Fachada;
import Login.LoginUser;
import Principal.TelaPrincipal;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Posseidon
 */
public class ListarConfig extends javax.swing.JFrame {

    /**
     * Creates new form ListarConfig
     */
    public ListarConfig() {
        initComponents();
        setTitle("Listagem de Configurações");
        setLocationRelativeTo(null); 
        jButtonListar.doClick();
    }
    
     void icone() {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("src\\resources\\favicon-cor.png"));
            this.setIconImage(img);
        } catch (IOException e) {
        }
    }
    
    private LoginUser logado;
      public ListarConfig(LoginUser logado) {
          icone();
        initComponents();
        setTitle("Listagem de Configurações");
        setLocationRelativeTo(null); 
         this.logado=logado;
        jButtonListar.doClick();
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TodasConfig = new javax.swing.JTable();
        campoListarConfig = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButtonListar = new javax.swing.JButton();
        jButtonAlterar = new javax.swing.JButton();
        jButtonRemover = new javax.swing.JButton();
        jButtonVoltar = new javax.swing.JButton();
        jButtonCadastrarNova = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TodasConfig.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Descrição da Configuração"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TodasConfig.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(TodasConfig);

        campoListarConfig.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoListarConfigKeyPressed(evt);
            }
        });

        jLabel1.setText("Descrição da Configuração:");

        jButtonListar.setText("Listar");
        jButtonListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonListarActionPerformed(evt);
            }
        });

        jButtonAlterar.setText("Alterar");
        jButtonAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAlterarActionPerformed(evt);
            }
        });

        jButtonRemover.setText("Remover");
        jButtonRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoverActionPerformed(evt);
            }
        });

        jButtonVoltar.setText("Voltar");
        jButtonVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVoltarActionPerformed(evt);
            }
        });

        jButtonCadastrarNova.setText("Cadastrar Nova Configuração");
        jButtonCadastrarNova.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCadastrarNovaActionPerformed(evt);
            }
        });

        jMenu1.setText("Arquivo");
        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonAlterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonRemover)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 146, Short.MAX_VALUE)
                        .addComponent(jButtonCadastrarNova)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonVoltar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(campoListarConfig, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonListar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(campoListarConfig, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonListar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonVoltar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButtonRemover, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonCadastrarNova, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
  
 
  
    private void jButtonAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAlterarActionPerformed
      if (TodasConfig.getSelectedRow() >= 0){
            Configuracao selecionadoLoginUser = new Configuracao();
            selecionadoLoginUser =  listaDeConfiguracoes.get(TodasConfig.getSelectedRow());
            
            AlterarConfig alterarConfig = new AlterarConfig(selecionadoLoginUser,this.logado);
            alterarConfig.setVisible(true);
            dispose();

        }else{
            JOptionPane.showMessageDialog(null, "Escolha alguma configuração listada na tabela para alterá-la!");
        };
        
    }//GEN-LAST:event_jButtonAlterarActionPerformed

       ArrayList<Configuracao> listaDeConfiguracoes;
    
    private void jButtonListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonListarActionPerformed
        try {
            
            Configuracao filtroConfig = new Configuracao();
            
            if(campoListarConfig.getText().trim().equals("")==false){
            filtroConfig.setConfiguracao(campoListarConfig.getText());
            }else{
                filtroConfig.setConfiguracao("");
            }
                                             
            
           
            listaDeConfiguracoes = Fachada.getInstancia().listarConfiguracao(filtroConfig);
            
            DefaultTableModel tabelaDeConfiguracoes = new DefaultTableModel();
            tabelaDeConfiguracoes.setColumnIdentifiers(new String [] {"Descrição da Configuração"});
            
            for (Configuracao config: listaDeConfiguracoes){
                tabelaDeConfiguracoes.addRow(new String [] { config.getConfiguracao()});
            }
            
            TodasConfig.setModel(tabelaDeConfiguracoes);     
            
           
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Erro ao listar - "  + e.getMessage());
        }
    }//GEN-LAST:event_jButtonListarActionPerformed

    private void jButtonRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoverActionPerformed
        if(TodasConfig.getSelectedRow()>=0){
        Configuracao removerConfig = new Configuracao();
        removerConfig=listaDeConfiguracoes.get(TodasConfig.getSelectedRow());
        
        if ( JOptionPane.showConfirmDialog(new JFrame(), 
       "Tem certeza que deseja remover esta Configuração("+removerConfig.getConfiguracao()+")? \n(É necessário que nenhum usuário possua este tipo de configuração)", 
       "Remover Configuração", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) { 
          try {
   
    int selectedrow=(TodasConfig.getSelectedRow());
    Fachada.getInstancia().removerConfiguracao(removerConfig);
    
        JOptionPane.showMessageDialog(null,"Configuração removida com sucesso!");
        
        
    listaDeConfiguracoes.remove(selectedrow);
                DefaultTableModel tabelaDeConfiguracoes = new DefaultTableModel();
                tabelaDeConfiguracoes.setColumnIdentifiers(new String [] {"Descrição da Configuração"});
                    //varrendo o ArrayList de Funcionário e colocando cada objeto funcionário em uma linha
                 for (Configuracao config: listaDeConfiguracoes){
                tabelaDeConfiguracoes.addRow(new String [] { config.getConfiguracao()});
            }
            
            TodasConfig.setModel(tabelaDeConfiguracoes);  
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
      } 
      else { 
            
          JOptionPane.showMessageDialog(rootPane,"Operação cancelada.");   
          return; 
      } 
        }else{
       
                JOptionPane.showMessageDialog(rootPane,"Escolha alguma Configuração da lista para removê-la.");
            }
 
    }//GEN-LAST:event_jButtonRemoverActionPerformed

    private void jButtonVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVoltarActionPerformed
      TelaPrincipal inicial= new TelaPrincipal(this.logado);  
        inicial.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButtonVoltarActionPerformed

    private void campoListarConfigKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoListarConfigKeyPressed
        int key=evt.getKeyCode();       
        if(key==KeyEvent.VK_ENTER)
        { 
            jButtonListar.doClick();
        }
    }//GEN-LAST:event_campoListarConfigKeyPressed

    private void jButtonCadastrarNovaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCadastrarNovaActionPerformed
        CadastrarConfig cadastrarConfig = new CadastrarConfig(this.logado);
        cadastrarConfig.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButtonCadastrarNovaActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(ListarConfig.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListarConfig.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListarConfig.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListarConfig.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListarConfig().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TodasConfig;
    private javax.swing.JTextField campoListarConfig;
    private javax.swing.JButton jButtonAlterar;
    private javax.swing.JButton jButtonCadastrarNova;
    private javax.swing.JButton jButtonListar;
    private javax.swing.JButton jButtonRemover;
    private javax.swing.JButton jButtonVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
