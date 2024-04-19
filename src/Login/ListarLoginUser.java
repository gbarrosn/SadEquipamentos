/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import Geral.Fachada;
import Principal.TelaPrincipal;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author airton.oliveira
 */
public class ListarLoginUser extends javax.swing.JFrame {

    /**
     * Creates new form ListarLoginUser
     */
    public ListarLoginUser() {
        initComponents();
        setTitle("Listagem de Logins do Sistema");
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
    public ListarLoginUser(LoginUser logado) {
        icone();
        initComponents();
        setTitle("Listagem de Logins do Sistema");
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

        jLabel1 = new javax.swing.JLabel();
        campoFiltro = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaLogins = new javax.swing.JTable();
        jButtonAlterar = new javax.swing.JButton();
        jButtonRemover = new javax.swing.JButton();
        jButtonListar = new javax.swing.JButton();
        jButtonNovo = new javax.swing.JButton();
        jButtonVoltar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setText("Usuário:");

        tabelaLogins.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Login", "Administrador?", "Image"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaLogins.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tabelaLogins);

        jButtonAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Icons/import.png"))); // NOI18N
        jButtonAlterar.setText("Alterar");
        jButtonAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAlterarActionPerformed(evt);
            }
        });

        jButtonRemover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Icons/reject_document.png"))); // NOI18N
        jButtonRemover.setText("Remover");
        jButtonRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoverActionPerformed(evt);
            }
        });

        jButtonListar.setText("Listar");
        jButtonListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonListarActionPerformed(evt);
            }
        });

        jButtonNovo.setText("Novo Login");
        jButtonNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovoActionPerformed(evt);
            }
        });

        jButtonVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Icons/arrow_left_32.png"))); // NOI18N
        jButtonVoltar.setText("Voltar");
        jButtonVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVoltarActionPerformed(evt);
            }
        });

        jButton1.setText("Resetar Senha");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(campoFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonListar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonAlterar)
                        .addGap(11, 11, 11)
                        .addComponent(jButtonRemover)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonVoltar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 525, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campoFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonListar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButtonAlterar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonRemover, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

     ArrayList<LoginUser> listaDeLogins;
    
    private void jButtonListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonListarActionPerformed
        try {
            
           LoginUser filtroLoginUser = new LoginUser();
            
            if(campoFiltro.getText().trim().equals("")==false){
            filtroLoginUser.setLogin(campoFiltro.getText());
            }else{
                filtroLoginUser.setLogin("");
            }
                                                        
            
            listaDeLogins = Fachada.getInstancia().listarLogins(filtroLoginUser);
                    
            DefaultTableModel tabela = new DefaultTableModel();
            tabela.setColumnIdentifiers(new String [] {"","Login","Administrador?"}); //TODO: patrimônio
                      
            int qtdADM=0;
            for (LoginUser este: listaDeLogins){
                     
                    if(este.getAdm().equals("SIM")){
                        qtdADM++;
                    }
                        
                    Object image = new Object();
                    tabela.addRow(new Object [] { image,este.getLogin(),este.getAdm()}); 
                         
            }
                  
            tabelaLogins.setModel(tabela);
            tabelaLogins.setRowHeight(35);
            tabelaLogins.getColumnModel().getColumn(0).setMinWidth(50);
            tabelaLogins.getColumnModel().getColumn(0).setMaxWidth(50);
            tabelaLogins.getColumnModel().getColumn(1).setMinWidth(350);
            tabelaLogins.getColumnModel().getColumn(1).setMaxWidth(350);
            tabelaLogins.getColumnModel().getColumn(2).setMinWidth(150);
            tabelaLogins.getColumnModel().getColumn(2).setMaxWidth(150);
           
             tabelaLogins.getColumnModel().getColumn(0).setCellRenderer(new ImageRendererADM(qtdADM));      
           
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Erro ao listar - "  + e.getMessage());
        }
    }//GEN-LAST:event_jButtonListarActionPerformed

    private void jButtonVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVoltarActionPerformed
       TelaPrincipal inicial= new TelaPrincipal(this.logado);  
        inicial.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButtonVoltarActionPerformed

    private void jButtonRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoverActionPerformed
              if(tabelaLogins.getSelectedRow()>=0){
        LoginUser removerLoginUser = new LoginUser();
        removerLoginUser=listaDeLogins.get(tabelaLogins.getSelectedRow());
        
        if(!removerLoginUser.getLogin().equalsIgnoreCase("administrador")){
            
        
        
        if ( JOptionPane.showConfirmDialog(new JFrame(), 
       "Tem certeza que deseja remover este login do sistema? ("+removerLoginUser.getLogin()+")?" , 
       "Remover Login", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) { 
          try {
   
    int selectedrow=(tabelaLogins.getSelectedRow());
    Fachada.getInstancia().removerLogin(removerLoginUser);
    
        JOptionPane.showMessageDialog(null,"Login removido com sucesso!");
        
        
    listaDeLogins.remove(selectedrow);
                DefaultTableModel tabela = new DefaultTableModel();
            tabela.setColumnIdentifiers(new String [] {"Login","Administrador?"});
            
            for (LoginUser este: listaDeLogins){
                tabela.addRow(new String [] { este.getLogin(),este.getAdm()});
            }
            
            tabelaLogins.setModel(tabela);    
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
      } 
      else { 
            
          JOptionPane.showMessageDialog(rootPane,"Operação cancelada.");   
          return; 
      } 
        }else{
               JOptionPane.showMessageDialog(null, "O login de administrador não pode ser removido.");
            }
        }else{
       
                JOptionPane.showMessageDialog(rootPane,"Escolha algum Login da lista para removê-lo.");
            }
 
    }//GEN-LAST:event_jButtonRemoverActionPerformed

    private void jButtonNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovoActionPerformed
       CadastrarLoginUser cadastrar = new CadastrarLoginUser(this.logado);
       cadastrar.setVisible(true);
    
    }//GEN-LAST:event_jButtonNovoActionPerformed

    private void jButtonAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAlterarActionPerformed
         
        
        if (tabelaLogins.getSelectedRow() >= 0){
            
            LoginUser selecionadoLoginUser = new LoginUser();
            selecionadoLoginUser =  listaDeLogins.get(tabelaLogins.getSelectedRow());
            
            if(!selecionadoLoginUser.getLogin().equalsIgnoreCase("administrador")){
            AlterarLoginSenha alterar = new AlterarLoginSenha(selecionadoLoginUser,this.logado);
            alterar.setVisible(true);
            dispose();
            }else{
               JOptionPane.showMessageDialog(null, "O login de administrador não pode ser alterado.");
            }

        }else{
            JOptionPane.showMessageDialog(null, "Escolha algum Login listado na tabela para alterá-lo!");
        };
    }//GEN-LAST:event_jButtonAlterarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
          if(tabelaLogins.getSelectedRow()>=0){
        LoginUser loginUser = new LoginUser();
        loginUser=listaDeLogins.get(tabelaLogins.getSelectedRow());
        
        if(!loginUser.getLogin().equalsIgnoreCase("administrador")){
            
        
        
        if ( JOptionPane.showConfirmDialog(new JFrame(), 
       "Tem certeza que deseja resetar a senha deste Login? ("+loginUser.getLogin()+")?" , 
       "Resetar Senha", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) { 
          try {
   
    
        Fachada.getInstancia().resetarSenha(loginUser);
    
        JOptionPane.showMessageDialog(null,"Senha resetada com sucesso!\nSenha Padrão: SAD");
        
    
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
      } 
      else { 
            
          JOptionPane.showMessageDialog(rootPane,"Operação cancelada.");   
          return; 
      } 
        }else{
               JOptionPane.showMessageDialog(null, "O login de administrador não pode ser alterado.");
            }
        }else{
       
                JOptionPane.showMessageDialog(rootPane,"Escolha algum Login da lista para resetar a senha.");
            }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(ListarLoginUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListarLoginUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListarLoginUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListarLoginUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListarLoginUser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField campoFiltro;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonAlterar;
    private javax.swing.JButton jButtonListar;
    private javax.swing.JButton jButtonNovo;
    private javax.swing.JButton jButtonRemover;
    private javax.swing.JButton jButtonVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaLogins;
    // End of variables declaration//GEN-END:variables
}
