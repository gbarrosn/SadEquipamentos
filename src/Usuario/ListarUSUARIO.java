/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuario;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ByteArrayInputStream;

import RelatoriosSAD.FormRelatorioTermoDevolucaoUsuario;
import Geral.Fachada;
import Graficos.*;
import Login.LoginUser;
import Micro.Configuracao.Configuracao;
import Micro.MarcaMicro.MarcaMicro;
import Micro.ModeloMicro.ModeloMicro;
import Micro.OS.OS;
import Micro.PlataformaMicro.PlataformaMicro;
import Micro.ProprietarioMicro.ProprietarioMicro;
import Monitor.MarcaMonitor.MarcaMonitor;
import Monitor.ModeloMonitor.ModeloMonitor;
import Principal.TelaPrincipal;
import RelatoriosSAD.DadosRelatorios;
import RelatoriosSAD.FormRelatorioCompleto;
import RelatoriosSAD.FormRelatorioTermoUsuario;
import RelatoriosSAD.FormRelatorios;
import SADpe.Cargo.Cargo;
import SADpe.Gerencia.Gerencia;
import SADpe.Pavimento.Pavimento;
import Versao_Office.VersaoOffice;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import com.cete.dynamicpdf.*;
import com.cete.dynamicpdf.pageelements.Label;
import com.cete.dynamicpdf.pageelements.PageNumberingLabel;
import com.cete.dynamicpdf.pageelements.Row;
import com.cete.dynamicpdf.pageelements.Table;

/**
 *
 * @author Posseidon
 */
public class ListarUSUARIO extends javax.swing.JFrame {

    /**
     * Creates new form ListarUSUARIO
     */
    public ListarUSUARIO() {
        initComponents();
        setTitle("Listagem de Usuários");
        setLocationRelativeTo(null);
        comboBoxListagem();
        campoPesquisarTodosCampos.setToolTipText("Também é possível pesquisar por data, ex: 10/01/2015.");
        BotaoPesquisaExata.setToolTipText("Ative este botão e clique em Iniciar Listagem.");
        campoNomeListar.requestFocus();
        //jButtonListarFiltros.doClick();
        //setExtendedState(MAXIMIZED_BOTH);
    }

    private LoginUser logado;

    void icone() {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("resources\\favicon-cor.png"));
            this.setIconImage(img);
        } catch (IOException e) {
        }
    }

    public ListarUSUARIO(LoginUser logado) {
        icone();
        initComponents();
        setTitle("Listagem de Usuários");
        setLocationRelativeTo(null);
        comboBoxListagem();
        campoPesquisarTodosCampos.setToolTipText("Também é possível pesquisar por data, ex: 10/01/2015.");
        BotaoPesquisaExata.setToolTipText("Ative este botão e clique em Iniciar Listagem.");
        campoNomeListar.requestFocus();
        //jButtonListarFiltros.doClick();
        //setExtendedState(MAXIMIZED_BOTH);
        this.logado = logado;
    }

    private ArrayList<Pavimento> allPavimentos;
    private ArrayList<Configuracao> allConfiguracoes;
    private ArrayList<ModeloMicro> allModelosMicros;
    private ArrayList<PlataformaMicro> allPlataformas;
    private ArrayList<ModeloMonitor> allModelosMonitores;
    private ArrayList<ModeloMonitor> allModelosMonitores1;
    private ArrayList<Gerencia> allGerencias;
    private ArrayList<VersaoOffice> allVersaoOffice;
    private ArrayList<ProprietarioMicro> allProprietariosMicros;
    private ArrayList<Cargo> allCargos;
    private ArrayList<OS> allOs;

    private void comboBoxListagem() {
        try {

            try {

                DefaultComboBoxModel listaComboNotebook = new DefaultComboBoxModel();

                listaComboNotebook.addElement("Ambos");
                listaComboNotebook.addElement("PC");
                listaComboNotebook.addElement("Notebook");

                ComboBoxNotebook.setModel(listaComboNotebook);

            } catch (Exception e) {
                throw new Exception("Erro - " + e.getMessage());
            }

            //*********************** ComboBox TERMO DE RESPONSABILIDADE
            try {

                DefaultComboBoxModel listaComboTermo = new DefaultComboBoxModel();

                listaComboTermo.addElement("Sim/Não");
                listaComboTermo.addElement("Sim");
                listaComboTermo.addElement("Não");

                ComboTermo.setModel(listaComboTermo);

            } catch (Exception e) {
                throw new Exception("Erro - " + e.getMessage());
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar opções do Combo Box :" + e.getMessage());
        }
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
        campoNomeListar = new javax.swing.JTextField();
        campoTomboMicroListar = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButtonListarFiltros = new javax.swing.JButton();
        jButtonAlterarUsuario = new javax.swing.JButton();
        jButtonRemoverUsuário = new javax.swing.JButton();
        listarVoltar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TodosUsuarios = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        campoFiltroCMTECH = new javax.swing.JTextField();
        jButtonNovoCadastro = new javax.swing.JButton();
        ComboBoxPavimento = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        campoHostName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        ComboBoxConfig = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        ComboBoxModeloMicro = new javax.swing.JComboBox();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        campo_SerieMicro = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        ComboBoxNotebook = new javax.swing.JComboBox();
        textoTotal = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jButtonVisualizarUsuario = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        campoTomboMonitorListar = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        campoSerieMonitorListar = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        ComboBoxModeloMonitor = new javax.swing.JComboBox();
        jLabel14 = new javax.swing.JLabel();
        ComboBoxPlataforma = new javax.swing.JComboBox();
        jLabel15 = new javax.swing.JLabel();
        ComboBoxGerenciaSigla = new javax.swing.JComboBox();
        jLabel16 = new javax.swing.JLabel();
        campoPesquisarTodosCampos = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        buttonOBS = new javax.swing.JButton();
        ButtonLimparSelecao = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        ComboBoxVersaoOffice = new javax.swing.JComboBox();
        BotaoPesquisaExata = new javax.swing.JToggleButton();
        jLabel18 = new javax.swing.JLabel();
        ComboBoxPropMicro = new javax.swing.JComboBox();
        jLabel19 = new javax.swing.JLabel();
        ComboBoxCargo = new javax.swing.JComboBox();
        jLabel20 = new javax.swing.JLabel();
        ComboBoxSO = new javax.swing.JComboBox();
        jButton3 = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        ComboTermo = new javax.swing.JComboBox();
        jLabel24 = new javax.swing.JLabel();
        jTextField_EtiquetaSad = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        campoTomboMonitorListar1 = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        campoSerieMonitorListar1 = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        ComboBoxModeloMonitor1 = new javax.swing.JComboBox();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jButton6 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        exibirTermoOption = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItemSair = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItemRelatorio = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                EscSair(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Nome:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 79, -1, -1));

        campoNomeListar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoNomeListarKeyPressed(evt);
            }
        });
        getContentPane().add(campoNomeListar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 73, 208, -1));

        campoTomboMicroListar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoTomboMicroListarKeyPressed(evt);
            }
        });
        getContentPane().add(campoTomboMicroListar, new org.netbeans.lib.awtextra.AbsoluteConstraints(586, 73, 137, -1));

        jLabel3.setText("Tombo do Micro:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(489, 75, -1, 20));

        jButtonListarFiltros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Icons/sort_desccending.png"))); // NOI18N
        jButtonListarFiltros.setText("Iniciar listagem");
        jButtonListarFiltros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonListarFiltrosActionPerformed(evt);
            }
        });
        jButtonListarFiltros.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButtonListarFiltrosKeyPressed(evt);
            }
        });
        getContentPane().add(jButtonListarFiltros, new org.netbeans.lib.awtextra.AbsoluteConstraints(1018, 259, 142, -1));

        jButtonAlterarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Icons/import.png"))); // NOI18N
        jButtonAlterarUsuario.setText("Alterar");
        jButtonAlterarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAlterarUsuarioActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonAlterarUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 569, -1, 41));

        jButtonRemoverUsuário.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Icons/reject_document.png"))); // NOI18N
        jButtonRemoverUsuário.setText("Remover");
        jButtonRemoverUsuário.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoverUsuárioActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonRemoverUsuário, new org.netbeans.lib.awtextra.AbsoluteConstraints(238, 569, -1, 41));

        listarVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Icons/arrow_left_32.png"))); // NOI18N
        listarVoltar.setText("Voltar");
        listarVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listarVoltarActionPerformed(evt);
            }
        });
        getContentPane().add(listarVoltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1071, 569, -1, 41));

        TodosUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Nome", "Pavimento", "Gerência", "Cargo", "Tombo Micro", "Host Name", "CMTECH", "Etiqueta SAD", "Proprietário"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TodosUsuarios.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        TodosUsuarios.getTableHeader().setReorderingAllowed(false);
        TodosUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TodosUsuariosMousePressed(evt);
            }
        });
        TodosUsuarios.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TodosUsuariosKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(TodosUsuarios);
        if (TodosUsuarios.getColumnModel().getColumnCount() > 0) {
            TodosUsuarios.getColumnModel().getColumn(1).setMaxWidth(70);
            TodosUsuarios.getColumnModel().getColumn(2).setMinWidth(200);
            TodosUsuarios.getColumnModel().getColumn(4).setMinWidth(120);
            TodosUsuarios.getColumnModel().getColumn(4).setMaxWidth(70);
            TodosUsuarios.getColumnModel().getColumn(5).setMinWidth(100);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 310, 1174, 253));

        jLabel7.setText("CESU:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(276, 76, -1, -1));

        campoFiltroCMTECH.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoFiltroCMTECHKeyPressed(evt);
            }
        });
        getContentPane().add(campoFiltroCMTECH, new org.netbeans.lib.awtextra.AbsoluteConstraints(319, 73, 158, -1));

        jButtonNovoCadastro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Icons/accept_document.png"))); // NOI18N
        jButtonNovoCadastro.setText("Cadastrar PC");
        jButtonNovoCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovoCadastroActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonNovoCadastro, new org.netbeans.lib.awtextra.AbsoluteConstraints(924, 569, -1, 41));

        ComboBoxPavimento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pavimento" }));
        ComboBoxPavimento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ComboBoxPavimentoMouseClicked(evt);
            }
        });
        ComboBoxPavimento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ComboBoxPavimentoKeyPressed(evt);
            }
        });
        getContentPane().add(ComboBoxPavimento, new org.netbeans.lib.awtextra.AbsoluteConstraints(73, 169, 185, -1));

        jLabel2.setText("Host Name:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(978, 76, -1, -1));

        campoHostName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoHostNameActionPerformed(evt);
            }
        });
        campoHostName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoHostNameKeyPressed(evt);
            }
        });
        getContentPane().add(campoHostName, new org.netbeans.lib.awtextra.AbsoluteConstraints(1061, 73, 119, -1));

        jLabel4.setText("Pavimento:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 175, -1, -1));

        jLabel5.setText("Configuração:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(276, 104, -1, -1));

        ComboBoxConfig.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Configuração" }));
        ComboBoxConfig.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ComboBoxConfigMouseClicked(evt);
            }
        });
        ComboBoxConfig.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ComboBoxConfigKeyPressed(evt);
            }
        });
        getContentPane().add(ComboBoxConfig, new org.netbeans.lib.awtextra.AbsoluteConstraints(359, 101, 118, -1));

        jLabel6.setText("Modelo do  Micro:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(276, 138, -1, -1));

        ComboBoxModeloMicro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Modelo do Micro" }));
        ComboBoxModeloMicro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ComboBoxModeloMicroMouseClicked(evt);
            }
        });
        ComboBoxModeloMicro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ComboBoxModeloMicroKeyPressed(evt);
            }
        });
        getContentPane().add(ComboBoxModeloMicro, new org.netbeans.lib.awtextra.AbsoluteConstraints(377, 135, 100, -1));
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 45, 1180, 10));

        jLabel8.setText("Filtros de pesquisa");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel9.setText("Monitor 2:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(978, 107, 64, -1));

        campo_SerieMicro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campo_SerieMicroKeyPressed(evt);
            }
        });
        getContentPane().add(campo_SerieMicro, new org.netbeans.lib.awtextra.AbsoluteConstraints(825, 73, 125, -1));

        jLabel10.setText("Notebook ou PC?");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 141, -1, -1));

        ComboBoxNotebook.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ComboBoxNotebook.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ComboBoxNotebookKeyPressed(evt);
            }
        });
        getContentPane().add(ComboBoxNotebook, new org.netbeans.lib.awtextra.AbsoluteConstraints(113, 135, 145, -1));

        textoTotal.setText("Total:");
        getContentPane().add(textoTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 270, -1, -1));
        getContentPane().add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 243, 1180, 10));

        jButtonVisualizarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Icons/find_in_file.png"))); // NOI18N
        jButtonVisualizarUsuario.setText("Visualizar");
        jButtonVisualizarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVisualizarUsuarioActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonVisualizarUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(113, 569, -1, 41));

        jLabel11.setText("Tombo Monitor:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(735, 171, -1, 20));
        getContentPane().add(campoTomboMonitorListar, new org.netbeans.lib.awtextra.AbsoluteConstraints(825, 169, 125, -1));

        jLabel12.setText("Série Monitor:");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(735, 141, -1, -1));
        getContentPane().add(campoSerieMonitorListar, new org.netbeans.lib.awtextra.AbsoluteConstraints(825, 135, 125, -1));

        jLabel13.setText("Modelo Monitor:");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(735, 205, -1, 20));

        ComboBoxModeloMonitor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Modelo do Monitor" }));
        ComboBoxModeloMonitor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ComboBoxModeloMonitorMouseClicked(evt);
            }
        });
        ComboBoxModeloMonitor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxModeloMonitorActionPerformed(evt);
            }
        });
        ComboBoxModeloMonitor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ComboBoxModeloMonitorKeyPressed(evt);
            }
        });
        getContentPane().add(ComboBoxModeloMonitor, new org.netbeans.lib.awtextra.AbsoluteConstraints(825, 203, 125, -1));

        jLabel14.setText("Plataforma:");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 107, -1, -1));

        ComboBoxPlataforma.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Plataforma" }));
        ComboBoxPlataforma.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ComboBoxPlataformaMouseClicked(evt);
            }
        });
        ComboBoxPlataforma.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ComboBoxPlataformaKeyPressed(evt);
            }
        });
        getContentPane().add(ComboBoxPlataforma, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 101, 183, -1));

        jLabel15.setText("Gerência:");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(276, 172, -1, -1));

        ComboBoxGerenciaSigla.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Gerência" }));
        ComboBoxGerenciaSigla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ComboBoxGerenciaSiglaMouseClicked(evt);
            }
        });
        ComboBoxGerenciaSigla.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ComboBoxGerenciaSiglaKeyPressed(evt);
            }
        });
        getContentPane().add(ComboBoxGerenciaSigla, new org.netbeans.lib.awtextra.AbsoluteConstraints(335, 169, 142, -1));

        jLabel16.setText("Pesquisar em todos os campos:");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(735, 12, -1, -1));
        getContentPane().add(campoPesquisarTodosCampos, new org.netbeans.lib.awtextra.AbsoluteConstraints(927, 6, 165, 28));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Icons/run_32.png"))); // NOI18N
        jButton1.setText("Ir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1098, 7, 82, 28));

        buttonOBS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Icons/compare_documents3.png"))); // NOI18N
        buttonOBS.setText("Exibir observações");
        buttonOBS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonOBSActionPerformed(evt);
            }
        });
        getContentPane().add(buttonOBS, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 569, -1, 41));

        ButtonLimparSelecao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Icons/format_painter.png"))); // NOI18N
        ButtonLimparSelecao.setText("Limpar Seleção");
        ButtonLimparSelecao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonLimparSelecaoActionPerformed(evt);
            }
        });
        getContentPane().add(ButtonLimparSelecao, new org.netbeans.lib.awtextra.AbsoluteConstraints(576, 569, -1, 41));

        jLabel17.setText("Pacote Office:");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(489, 171, -1, 20));

        ComboBoxVersaoOffice.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Versão do Pacote Office" }));
        ComboBoxVersaoOffice.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ComboBoxVersaoOfficeMouseClicked(evt);
            }
        });
        ComboBoxVersaoOffice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ComboBoxVersaoOfficeKeyPressed(evt);
            }
        });
        getContentPane().add(ComboBoxVersaoOffice, new org.netbeans.lib.awtextra.AbsoluteConstraints(586, 169, 137, -1));

        BotaoPesquisaExata.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Icons/views_32.png"))); // NOI18N
        BotaoPesquisaExata.setText("Pesquisa Exata");
        BotaoPesquisaExata.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoPesquisaExataActionPerformed(evt);
            }
        });
        getContentPane().add(BotaoPesquisaExata, new org.netbeans.lib.awtextra.AbsoluteConstraints(854, 259, -1, -1));

        jLabel18.setText("Proprietário do Micro:");
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 209, -1, -1));

        ComboBoxPropMicro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Proprietário do Micro" }));
        ComboBoxPropMicro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ComboBoxPropMicroMouseClicked(evt);
            }
        });
        ComboBoxPropMicro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ComboBoxPropMicroKeyPressed(evt);
            }
        });
        getContentPane().add(ComboBoxPropMicro, new org.netbeans.lib.awtextra.AbsoluteConstraints(128, 203, 130, -1));

        jLabel19.setText("Cargo:");
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(276, 209, -1, -1));

        ComboBoxCargo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Cargo" }));
        ComboBoxCargo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ComboBoxCargoMouseClicked(evt);
            }
        });
        ComboBoxCargo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ComboBoxCargoKeyPressed(evt);
            }
        });
        getContentPane().add(ComboBoxCargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(331, 203, 146, -1));

        jLabel20.setText("Sistema Op.:");
        getContentPane().add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(489, 209, -1, -1));

        ComboBoxSO.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Sistema Operacional" }));
        ComboBoxSO.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ComboBoxSOMouseClicked(evt);
            }
        });
        ComboBoxSO.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ComboBoxSOKeyPressed(evt);
            }
        });
        getContentPane().add(ComboBoxSO, new org.netbeans.lib.awtextra.AbsoluteConstraints(586, 203, 137, -1));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Icons/accept_document.png"))); // NOI18N
        jButton3.setText("Cadastrar Notebook");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(741, 569, -1, 41));

        jLabel23.setText("Possui termo?");
        getContentPane().add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(489, 107, -1, -1));

        ComboTermo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ComboTermo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboTermoActionPerformed(evt);
            }
        });
        getContentPane().add(ComboTermo, new org.netbeans.lib.awtextra.AbsoluteConstraints(586, 101, 137, -1));

        jLabel24.setText("Etiqueta Sad:");
        getContentPane().add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(489, 141, -1, -1));
        getContentPane().add(jTextField_EtiquetaSad, new org.netbeans.lib.awtextra.AbsoluteConstraints(586, 135, 137, -1));

        jLabel21.setText("Tombo Monitor2:");
        getContentPane().add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(962, 173, -1, 20));
        getContentPane().add(campoTomboMonitorListar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1061, 169, 119, -1));

        jLabel22.setText("Série Monitor2:");
        getContentPane().add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(962, 145, -1, -1));
        getContentPane().add(campoSerieMonitorListar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1061, 135, 119, -1));

        jLabel25.setText("Modelo Monitor2:");
        getContentPane().add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(962, 205, -1, 20));

        ComboBoxModeloMonitor1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Modelo do Monitor" }));
        ComboBoxModeloMonitor1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ComboBoxModeloMonitor1MouseClicked(evt);
            }
        });
        ComboBoxModeloMonitor1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxModeloMonitor1ActionPerformed(evt);
            }
        });
        ComboBoxModeloMonitor1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ComboBoxModeloMonitor1KeyPressed(evt);
            }
        });
        getContentPane().add(ComboBoxModeloMonitor1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1061, 203, 119, -1));

        jLabel26.setText("Série Micro:");
        getContentPane().add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(735, 79, -1, -1));

        jLabel27.setText("Monitor:");
        getContentPane().add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(735, 107, -1, -1));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Icons/file_format_pdf.png"))); // NOI18N
        jButton2.setText("Termo de Responsabilidade");
        jButton2.setMaximumSize(new java.awt.Dimension(143, 39));
        jButton2.setMinimumSize(new java.awt.Dimension(143, 39));
        jButton2.setRequestFocusEnabled(false);
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 260, 220, 40));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jCheckBox1.setText("Buscar inativos");
        getContentPane().add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 270, 180, -1));

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Icons/file_format_pdf.png"))); // NOI18N
        jButton6.setText("Termo de Devolução");
        jButton6.setMaximumSize(new java.awt.Dimension(143, 39));
        jButton6.setMinimumSize(new java.awt.Dimension(143, 39));
        jButton6.setRequestFocusEnabled(false);
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 260, 200, 40));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jMenu1.setText("Arquivo");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ENTER, 0));
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Icons/sort_desccending.png"))); // NOI18N
        jMenuItem1.setText("Listar (ENTER)");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Icons/repeat_32.png"))); // NOI18N
        jMenuItem4.setText("PC/Notebook (Alterar definição do equipamento)");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        exibirTermoOption.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Icons/file_format_pdf.png"))); // NOI18N
        exibirTermoOption.setText("Exibir Termo de Responsabilidade (T)");
        exibirTermoOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exibirTermoOptionActionPerformed(evt);
            }
        });
        jMenu1.add(exibirTermoOption);

        jMenuItem8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Icons/compare_documents3.png"))); // NOI18N
        jMenuItem8.setText("Exibir Observações (TAB)");
        jMenu1.add(jMenuItem8);

        jMenuItemSair.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        jMenuItemSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Icons/cross_32.png"))); // NOI18N
        jMenuItemSair.setText("Sair (ESC)");
        jMenuItemSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSairActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemSair);

        jMenuBar1.add(jMenu1);

        jMenu3.setText("Relatórios");

        jMenuItemRelatorio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Icons/print_layout.png"))); // NOI18N
        jMenuItemRelatorio.setText("Relatório Por Pavimento");
        jMenuItemRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemRelatorioActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItemRelatorio);

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Icons/print_layout.png"))); // NOI18N
        jMenuItem2.setText("Relatório Completo");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem2);

        jMenuBar1.add(jMenu3);

        jMenu2.setText("Gráficos");
        jMenu2.setEnabled(false);

        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Icons/stats_pie_chart_32.png"))); // NOI18N
        jMenuItem3.setText("Equipamentos por Configuração");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Icons/stats_pie_chart_32.png"))); // NOI18N
        jMenuItem5.setText("Equipamentos por Gerência");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        jMenuItem6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Icons/stats_pie_chart_32.png"))); // NOI18N
        jMenuItem6.setText("Equipamentos por Modelo");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem6);

        jMenuItem7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Icons/stats_column_chart_32.png"))); // NOI18N
        jMenuItem7.setText("Equipamentos por Pavimento");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem7);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton6ActionPerformed(ActionEvent evt) {
        if (TodosUsuarios.getSelectedRow() >= 0) {
            Usuario selecionadoUsuario;
            selecionadoUsuario = listaDeUsuarios.get(TodosUsuarios.getSelectedRow()); // ate aqui o sistema reconheece o usuario, atualzar o relatorio para o termo

            gerarDevolucaoUsuario(selecionadoUsuario);

        } else {
            JOptionPane.showMessageDialog(null, "Escolha algum usuário da tabela para gerar o termo de devolução!");
        }
    }

    private void gerarDevolucaoUsuario(Usuario selecionadoUser) {
        // usar a variavel termoUser para gerar um pdf com os dados do usuario selecionado
        // usar a classe DadosUsuario.visualizarUsuario para pegar os dados do usuario

        // TODO add your handling code here:
        // use the method gerarRelatorio into RelatoriosSAD.FormRelatorioTermoUsuario to get the data
        FormRelatorioTermoDevolucaoUsuario relatorioDevolucao = new FormRelatorioTermoDevolucaoUsuario(selecionadoUser);
        relatorioDevolucao.gerarTermoDevolucao();
        Usuario devolucaoUser = selecionadoUser.criarCopia();
        devolucaoUser.setEstoque(true);
        devolucaoUser.setAtivo(true);

        try {
            DadosUsuario userDados = new DadosUsuario();
            userDados.alterarUsuario(devolucaoUser, selecionadoUser);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.gc();
        // TODO add your handling code here:


    }

    private void jButton2ActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
        // use the method RelatoriosSAD.DadosRelatorios.dadosTermoUsuario to get the data
        if (TodosUsuarios.getSelectedRow() >= 0) {
            Usuario selecionadoUsuario;
            selecionadoUsuario = listaDeUsuarios.get(TodosUsuarios.getSelectedRow()); // ate aqui o sistema reconheece o usuario, atualzar o relatorio para o termo

            gerarTermoUsuario(selecionadoUsuario);

        } else {
            JOptionPane.showMessageDialog(null, "Escolha algum usuário da tabela para gerar o termo!");
        }
    }
    private void gerarTermoUsuario(Usuario selecionadoUsuario) {
        // usar a variavel termoUser para gerar um pdf com os dados do usuario selecionado
        // usar a classe DadosUsuario.visualizarUsuario para pegar os dados do usuario

        // TODO add your handling code here:
        // use the method gerarRelatorio into RelatoriosSAD.FormRelatorioTermoUsuario to get the data
        FormRelatorioTermoUsuario relatorioTermo = new FormRelatorioTermoUsuario(selecionadoUsuario);
        relatorioTermo.gerarRelatorio();

        Usuario termoUser = selecionadoUsuario.criarCopia();
        termoUser.setEstoque(false);
        termoUser.setAtivo(true);
        try {
            DadosUsuario userDados = new DadosUsuario();
            userDados.alterarUsuario(termoUser, selecionadoUsuario);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.gc();

        // TODO add your handling code here:

    }
    private void jButtonAlterarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAlterarUsuarioActionPerformed
        if (TodosUsuarios.getSelectedRow() >= 0) {
            Usuario selecionadoUsuario = new Usuario();
            selecionadoUsuario = listaDeUsuarios.get(TodosUsuarios.getSelectedRow());

            if (selecionadoUsuario.getNotebook().equals("sim") && selecionadoUsuario.getModeloMonitor().getIdModelo() == 31) {
                AlterarUSUARIONOTEBOOK alterarUser = new AlterarUSUARIONOTEBOOK(selecionadoUsuario, this.logado);
                alterarUser.setVisible(true);
            } else if (selecionadoUsuario.getNotebook().equals("sim") && selecionadoUsuario.getModeloMonitor().getIdModelo() != 31) {
                AlterarUSUARIONOTEBOOK1 alterarUser = new AlterarUSUARIONOTEBOOK1(selecionadoUsuario, this.logado);
                alterarUser.setVisible(true);
            } else {
                AlterarUSUARIO alterarUser = new AlterarUSUARIO(selecionadoUsuario, this.logado);
                alterarUser.setVisible(true);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Escolha algum usuário da tabela para alterá-lo!");
        };
    }//GEN-LAST:event_jButtonAlterarUsuarioActionPerformed

    ArrayList<Usuario> listaDeUsuarios;

    private void jButtonListarFiltrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonListarFiltrosActionPerformed

        try {

            Usuario filtroUser = new Usuario();

            if ((BotaoPesquisaExata.isSelected()) == true) {
                filtroUser.setPesq("exata");
            } else {
                filtroUser.setPesq("livre");
            }

            if (campoNomeListar.getText().trim().equals("") == false) {
                filtroUser.setNome(campoNomeListar.getText());
            } else {
                filtroUser.setNome("");
            }

            if (campoFiltroCMTECH.getText().trim().equals("") == false) {
                filtroUser.setEtiquetaCESU(Long.parseLong(campoFiltroCMTECH.getText()));
            } else {
                filtroUser.setEtiquetaCESU(0);
            }

            if (campoTomboMicroListar.getText().trim().equals("") == false) {
                filtroUser.setTombamentoMicro(Long.parseLong(campoTomboMicroListar.getText()));
            } else {
                filtroUser.setTombamentoMicro(0);
            }

            if (campo_SerieMicro.getText().trim().equals("") == false) {
                filtroUser.setSerieMicro(campo_SerieMicro.getText());
            } else {
                filtroUser.setSerieMicro("");
            }

            if (campoHostName.getText().trim().equals("") == false) {
                filtroUser.setNomepc(campoHostName.getText());
            } else {
                filtroUser.setNomepc("");
            }

            if (campoSerieMonitorListar.getText().trim().equals("") == false) {
                filtroUser.setSerieMonitor(campoSerieMonitorListar.getText());
            } else {
                filtroUser.setSerieMonitor("");
            }

            if (campoTomboMonitorListar.getText().trim().equals("") == false) {
                filtroUser.setTombamentoMonitor(Long.parseLong(campoTomboMonitorListar.getText()));
            } else {
                filtroUser.setTombamentoMonitor(0);
            }

            if (campoSerieMonitorListar1.getText().trim().equals("") == false) {
                filtroUser.setSerieMonitor1(campoSerieMonitorListar1.getText());
            } else {
                filtroUser.setSerieMonitor1("");
            }

            if (campoTomboMonitorListar1.getText().trim().equals("") == false) {
                filtroUser.setTombamentoMonitor1(Long.parseLong(campoTomboMonitorListar1.getText()));
            } else {
                filtroUser.setTombamentoMonitor1(0);
            }
            //FILTRO CARGO
            if (ComboBoxSO.getSelectedItem().equals("Sistema Operacional")) {
                OS vazio = new OS();
                vazio.setIdOS(0);
                vazio.setOs("");
                filtroUser.setOsMicro(vazio);

            } else {
                int Selecionado = ComboBoxSO.getSelectedIndex() - 1;
                filtroUser.setOsMicro(allOs.get(Selecionado));

            }

            //FILTRO CARGO
            if (ComboBoxCargo.getSelectedItem().equals("Cargo")) {
                Cargo vazio = new Cargo();
                vazio.setIdCargo(0);
                vazio.setCargo("");
                filtroUser.setCargo(vazio);

            } else {
                int SelecionadoCargo = ComboBoxCargo.getSelectedIndex() - 1;
                filtroUser.setCargo(allCargos.get(SelecionadoCargo));

            }

            //FILTRO PROP. MICRO
            if (ComboBoxPropMicro.getSelectedItem().equals("Proprietário do Micro")) {
                ProprietarioMicro vazio = new ProprietarioMicro();
                vazio.setIdProprietario(0);
                vazio.setProprietario("");
                filtroUser.setProprietarioMicro(vazio);

            } else {
                int SelecionadoPropMicro = ComboBoxPropMicro.getSelectedIndex() - 1;
                filtroUser.setProprietarioMicro(allProprietariosMicros.get(SelecionadoPropMicro));

            }

            //FILTRO VERSAO OFFICE
            if (ComboBoxVersaoOffice.getSelectedItem().equals("Versão do Pacote Office")) {
                VersaoOffice vazio = new VersaoOffice();
                vazio.setId_versao_office(0);
                vazio.setDescricao("");
                filtroUser.setVersao_office(vazio);

            } else {
                int SelecionadoVersaoOffice = ComboBoxVersaoOffice.getSelectedIndex() - 1;
                filtroUser.setVersao_office(allVersaoOffice.get(SelecionadoVersaoOffice));
            }

            //FILTRO PAVIMENTO
            if (ComboBoxPavimento.getSelectedItem().equals("Pavimento")) {
                Pavimento vazio = new Pavimento();
                vazio.setIdPavimento(0);
                vazio.setPavimento("");
                filtroUser.setPavimentoUsuario(vazio);

            } else {
                int SelecionadoPavimento = ComboBoxPavimento.getSelectedIndex() - 1;
                filtroUser.setPavimentoUsuario(allPavimentos.get(SelecionadoPavimento));

            }

            //FILTRO NOTEBOOK
            if (ComboBoxNotebook.getSelectedItem().equals("PC")) {
                filtroUser.setNotebook("não");
            } else if (ComboBoxNotebook.getSelectedItem().equals("Notebook")) {
                filtroUser.setNotebook("sim");
            } else {
                filtroUser.setNotebook("");
            }

            //FILTRO TERMO RESPONSABILIDADE
            if (ComboTermo.getSelectedItem().equals("Sim")) {
                filtroUser.setTermo_responsabilidade(true);
            } else if (ComboTermo.getSelectedItem().equals("Não")) {
                filtroUser.setTermo_responsabilidade(false);
            } else {
                filtroUser.setTermo_responsabilidade(null);
            }

            //FILTRO CONFIGURAÇÃO
            if (ComboBoxConfig.getSelectedItem().equals("Configuração")) {
                Configuracao vazio = new Configuracao();
                vazio.setIdConfiguracao(0);
                vazio.setConfiguracao("");
                filtroUser.setConfigMicro(vazio);

            } else {
                int SelecionadoConfiguracao = ComboBoxConfig.getSelectedIndex() - 1;
                filtroUser.setConfigMicro(allConfiguracoes.get(SelecionadoConfiguracao));

            }

            //FILTRO MODELO DO MICRO
            if (ComboBoxModeloMicro.getSelectedItem().equals("Modelo do Micro")) {
                ModeloMicro vazio = new ModeloMicro();
                vazio.setIdModelo(0);
                vazio.setModelo("");
                filtroUser.setModeloMicro(vazio);

            } else {
                int SelecionadoModeloMicro = ComboBoxModeloMicro.getSelectedIndex() - 1;
                filtroUser.setModeloMicro(allModelosMicros.get(SelecionadoModeloMicro));

            }

            //PLATAFORMA
            if (ComboBoxPlataforma.getSelectedItem().equals("Plataforma")) {
                PlataformaMicro vazio = new PlataformaMicro();
                vazio.setIdPlataforma(0);
                vazio.setPlataforma("");
                filtroUser.setPlataformaMicro(vazio);

            } else {
                int SelecionadoPlataformaMicro = ComboBoxPlataforma.getSelectedIndex() - 1;
                filtroUser.setPlataformaMicro(allPlataformas.get(SelecionadoPlataformaMicro));

            }

            //FILTRO MODELO DO MONITOR
            if (ComboBoxModeloMonitor.getSelectedItem().equals("Modelo do Monitor")) {
                ModeloMonitor vazio = new ModeloMonitor();
                vazio.setIdModelo(0);
                vazio.setModelo("");
                filtroUser.setModeloMonitor(vazio);

            } else {
                int SelecionadoModeloMonitor = ComboBoxModeloMonitor.getSelectedIndex() - 1;
                filtroUser.setModeloMonitor(allModelosMonitores.get(SelecionadoModeloMonitor));

            }
            //FILTRO MODELO DO MONITOR2
            if (ComboBoxModeloMonitor1.getSelectedItem().equals("Modelo do Monitor")) {
                ModeloMonitor vazio = new ModeloMonitor();
                vazio.setIdModelo(0);
                vazio.setModelo("");
                filtroUser.setModeloMonitor1(vazio);

            } else {
                int SelecionadoModeloMonitor1 = ComboBoxModeloMonitor1.getSelectedIndex() - 1;
                filtroUser.setModeloMonitor1(allModelosMonitores1.get(SelecionadoModeloMonitor1));

            }
            //ativos e inativos



            //FILTRO GERÊNCIA SIGLA
            if (ComboBoxGerenciaSigla.getSelectedItem().equals("Gerência")) {
                Gerencia vazio = new Gerencia();
                vazio.setIdGerencia(0);
                vazio.setSiglaGerencia("");
                filtroUser.setGerencia(vazio);

            } else {
                int SelecionadoGerenciaSigla = ComboBoxGerenciaSigla.getSelectedIndex() - 1;
                filtroUser.setGerencia(allGerencias.get(SelecionadoGerenciaSigla));

            }

            //FILTRO TERMO DE RESPONSABILIDADE
            if (ComboTermo.getSelectedItem().equals("Sim")) {

                filtroUser.setTermo_responsabilidade(true);

            } else if (ComboTermo.getSelectedItem().equals("Não")) {
                filtroUser.setTermo_responsabilidade(false);
            } else {
                filtroUser.setTermo_responsabilidade(null);
            }

            if (jCheckBox1.isSelected()) {
                filtroUser.setAtivo(false);
            } else {
                filtroUser.setAtivo(true);
            }

            //FACHADA
            //aqui na verdade
            listaDeUsuarios = Fachada.getInstancia().listarUsuario(filtroUser);

            DefaultTableModel tabelaDeUsuarios = new DefaultTableModel() {

                //private static final long serialVersionUID = 1L;
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
                ;

            };
            tabelaDeUsuarios.setColumnIdentifiers(new String[]{"Nome", "Pavimento", "Gerência", "Cargo", "Tombo Micro", "Host Name", "CESU", "Etiqueta Sad", "Proprietário"});

            TodosUsuarios.getColumnModel().getColumn(1).setMaxWidth(70);
            TodosUsuarios.getColumnModel().getColumn(2).setMinWidth(200);
            TodosUsuarios.getColumnModel().getColumn(4).setMaxWidth(70);
            TodosUsuarios.getColumnModel().getColumn(5).setMinWidth(70);
            TodosUsuarios.getColumnModel().getColumn(6).setMinWidth(100);

            for (Usuario user : listaDeUsuarios) {
                tabelaDeUsuarios.addRow(new String[]{user.getNome(), user.getPavimentoUsuario().getPavimento(), user.getGerencia().getSiglaGerencia(),
                        user.getCargo().getCargo(), user.getTombamentoMicro() + "", user.getNomepc(), user.getEtiquetaCESU() + "", user.getEtiquetaSAD(), user.getProprietarioMicro().getProprietario()});
            }

            TodosUsuarios.setModel(tabelaDeUsuarios);
            TodosUsuarios.getColumnModel().getColumn(0).setMinWidth(200);
            TodosUsuarios.getColumnModel().getColumn(0).setMaxWidth(220);
            TodosUsuarios.getColumnModel().getColumn(1).setMinWidth(100);
            TodosUsuarios.getColumnModel().getColumn(1).setMaxWidth(100);
            TodosUsuarios.getColumnModel().getColumn(2).setMinWidth(90);
            TodosUsuarios.getColumnModel().getColumn(2).setMaxWidth(110);
            TodosUsuarios.getColumnModel().getColumn(4).setMaxWidth(100);
            TodosUsuarios.getColumnModel().getColumn(4).setMinWidth(100);
            TodosUsuarios.getColumnModel().getColumn(5).setMinWidth(100);
            TodosUsuarios.getColumnModel().getColumn(6).setMinWidth(80);
            TodosUsuarios.getColumnModel().getColumn(6).setMaxWidth(100);
            TodosUsuarios.getColumnModel().getColumn(7).setMinWidth(80);
            TodosUsuarios.getColumnModel().getColumn(7).setMaxWidth(100);
            TodosUsuarios.getColumnModel().getColumn(8).setMinWidth(80);
            TodosUsuarios.getColumnModel().getColumn(8).setMaxWidth(100);

            textoTotal.setText("Total: " + listaDeUsuarios.size());

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Erro ao listar." + e.getMessage());
        }
    }//GEN-LAST:event_jButtonListarFiltrosActionPerformed

    private void jButtonRemoverUsuárioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoverUsuárioActionPerformed
        if (TodosUsuarios.getSelectedRow() >= 0) {
            Usuario removerUser = new Usuario();
            removerUser = listaDeUsuarios.get(TodosUsuarios.getSelectedRow());

            if (JOptionPane.showConfirmDialog(new JFrame(),
                    "Tem certeza que deseja remover o Usuário (" + removerUser.getNome() + ")? (esta ação não poderá ser desfeita)",
                    "Remover Usuário", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                try {

                    int selectedrow = (TodosUsuarios.getSelectedRow());
                    Fachada.getInstancia().removerUsuario(removerUser);

                    JOptionPane.showMessageDialog(null, "Usuário removido com sucesso!");

                    listaDeUsuarios.remove(selectedrow);

                    DefaultTableModel tabelaDeUsuarios = new DefaultTableModel() {

                        //private static final long serialVersionUID = 1L;
                        public boolean isCellEditable(int row, int column) {
                            return false;
                        }
                        ;

                    };
                    tabelaDeUsuarios.setColumnIdentifiers(new String[]{"Nome", "Pavimento", "Gerência", "Cargo", "Tombo Micro", "Host Name", "CESU", "Notebook?"});

                    TodosUsuarios.getColumnModel().getColumn(1).setMaxWidth(70);
                    TodosUsuarios.getColumnModel().getColumn(2).setMinWidth(200);
                    TodosUsuarios.getColumnModel().getColumn(4).setMaxWidth(70);
                    TodosUsuarios.getColumnModel().getColumn(5).setMinWidth(100);

                    for (Usuario user : listaDeUsuarios) {
                        tabelaDeUsuarios.addRow(new String[]{user.getNome(), user.getPavimentoUsuario().getPavimento(), user.getGerencia().getGerencia(),
                                user.getCargo().getCargo(), user.getTombamentoMicro() + "", user.getNomepc(), user.getEtiquetaCESU() + "", user.getNotebook()});
                    }

                    TodosUsuarios.setModel(tabelaDeUsuarios);
                    TodosUsuarios.getColumnModel().getColumn(1).setMaxWidth(70);
                    TodosUsuarios.getColumnModel().getColumn(2).setMinWidth(200);
                    TodosUsuarios.getColumnModel().getColumn(4).setMaxWidth(100);
                    TodosUsuarios.getColumnModel().getColumn(4).setMinWidth(100);
                    TodosUsuarios.getColumnModel().getColumn(5).setMinWidth(100);
                    TodosUsuarios.getColumnModel().getColumn(6).setMinWidth(80);
                    TodosUsuarios.getColumnModel().getColumn(6).setMaxWidth(100);
                    TodosUsuarios.getColumnModel().getColumn(7).setMinWidth(80);
                    TodosUsuarios.getColumnModel().getColumn(7).setMaxWidth(100);

                    textoTotal.setText("Total: " + listaDeUsuarios.size());

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            } else {

                JOptionPane.showMessageDialog(rootPane, "Operação cancelada.");
                return;
            }

        } else {

            JOptionPane.showMessageDialog(rootPane, "Escolha algum usuário da tabela para removê-lo!");
        }

    }//GEN-LAST:event_jButtonRemoverUsuárioActionPerformed

    private void listarVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listarVoltarActionPerformed
        TelaPrincipal inicial = new TelaPrincipal(this.logado);
        inicial.setVisible(true);
        dispose();
    }//GEN-LAST:event_listarVoltarActionPerformed

    private void campoNomeListarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoNomeListarKeyPressed
        /* int key=evt.getKeyCode();
         if(key==KeyEvent.VK_ENTER)
         {
         jButtonListarFiltros.doClick();
         }
         if(key==KeyEvent.VK_ESCAPE)
         {
         TelaPrincipal principal = new TelaPrincipal();
         principal.setVisible(true);
         dispose();
         }
         */
    }//GEN-LAST:event_campoNomeListarKeyPressed

    private void campoFiltroCMTECHKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoFiltroCMTECHKeyPressed
        /* int key=evt.getKeyCode();
         if(key==KeyEvent.VK_ENTER)
         {
         jButtonListarFiltros.doClick();
         }
         if(key==KeyEvent.VK_ESCAPE)
         {
         TelaPrincipal principal = new TelaPrincipal();
         principal.setVisible(true);
         dispose();
         }
         */
    }//GEN-LAST:event_campoFiltroCMTECHKeyPressed

    private void campoTomboMicroListarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoTomboMicroListarKeyPressed
        /* int key=evt.getKeyCode();
         if(key==KeyEvent.VK_ENTER)
         {
         jButtonListarFiltros.doClick();
         }
         if(key==KeyEvent.VK_ESCAPE)
         {
         TelaPrincipal principal = new TelaPrincipal();
         principal.setVisible(true);
         dispose();
         }
         */
    }//GEN-LAST:event_campoTomboMicroListarKeyPressed

    private void jButtonNovoCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovoCadastroActionPerformed
        CadastrarUSUARIO novoCadastro = new CadastrarUSUARIO(this.logado);
        novoCadastro.setVisible(true);


    }//GEN-LAST:event_jButtonNovoCadastroActionPerformed

    private void jMenuItemSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSairActionPerformed
        TelaPrincipal tela = new TelaPrincipal(this.logado);
        tela.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItemSairActionPerformed

    private void jMenuItemRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemRelatorioActionPerformed
        FormRelatorios formReport = new FormRelatorios(this.logado);
        formReport.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItemRelatorioActionPerformed

    private void EscSair(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_EscSair
        /*
         int key=evt.getKeyCode();
         if(key==KeyEvent.VK_ESCAPE)
         {
         TelaPrincipal principal = new TelaPrincipal();
         principal.setVisible(true);
         dispose();
         }
         */
    }//GEN-LAST:event_EscSair

    private void TodosUsuariosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TodosUsuariosKeyPressed
        int key = evt.getKeyCode();
        if (key == KeyEvent.VK_ESCAPE) {
            TelaPrincipal principal = new TelaPrincipal(this.logado);
            principal.setVisible(true);
            dispose();
        } else if (key == KeyEvent.VK_TAB) {
            buttonOBS.doClick();
        } else if (key == KeyEvent.VK_T) {
            exibirTermoOption.doClick();
        }
    }//GEN-LAST:event_TodosUsuariosKeyPressed

    private void jButtonListarFiltrosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButtonListarFiltrosKeyPressed
        int key = evt.getKeyCode();
        if (key == KeyEvent.VK_ESCAPE) {
            TelaPrincipal principal = new TelaPrincipal(this.logado);
            principal.setVisible(true);
            dispose();
        }

    }//GEN-LAST:event_jButtonListarFiltrosKeyPressed

    private void ComboBoxPavimentoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ComboBoxPavimentoKeyPressed
        int key = evt.getKeyCode();
        if (key == KeyEvent.VK_ENTER) {
            jButtonListarFiltros.doClick();
        }
        /*
         if(key==KeyEvent.VK_ESCAPE)
         {
         TelaPrincipal principal = new TelaPrincipal();
         principal.setVisible(true);
         dispose();
         }
         */
    }//GEN-LAST:event_ComboBoxPavimentoKeyPressed

    private void campoHostNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoHostNameKeyPressed
        /*int key=evt.getKeyCode();
         if(key==KeyEvent.VK_ENTER)
         {
         jButtonListarFiltros.doClick();
         }
         if(key==KeyEvent.VK_ESCAPE)
         {
         TelaPrincipal principal = new TelaPrincipal();
         principal.setVisible(true);
         dispose();
         }
         */
    }//GEN-LAST:event_campoHostNameKeyPressed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        jButtonListarFiltros.doClick();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void ComboBoxNotebookKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ComboBoxNotebookKeyPressed
        int key = evt.getKeyCode();
        if (key == KeyEvent.VK_ENTER) {
            jButtonListarFiltros.doClick();
        }
    }//GEN-LAST:event_ComboBoxNotebookKeyPressed

    private void jButtonVisualizarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVisualizarUsuarioActionPerformed
        if (TodosUsuarios.getSelectedRow() >= 0) {
            Usuario selecionadoUsuario = new Usuario();
            selecionadoUsuario = listaDeUsuarios.get(TodosUsuarios.getSelectedRow());

            VisualizarUsuario visualizar = new VisualizarUsuario(selecionadoUsuario, this.logado);
            visualizar.setVisible(true);

        } else {
            JOptionPane.showMessageDialog(null, "Escolha algum usuário da tabela para visualizá-lo!");
        };
    }//GEN-LAST:event_jButtonVisualizarUsuarioActionPerformed

    private void ComboBoxConfigKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ComboBoxConfigKeyPressed
        int key = evt.getKeyCode();
        if (key == KeyEvent.VK_ENTER) {
            jButtonListarFiltros.doClick();
        }
    }//GEN-LAST:event_ComboBoxConfigKeyPressed

    private void ComboBoxModeloMicroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ComboBoxModeloMicroKeyPressed
        int key = evt.getKeyCode();
        if (key == KeyEvent.VK_ENTER) {
            jButtonListarFiltros.doClick();
        }
    }//GEN-LAST:event_ComboBoxModeloMicroKeyPressed

    private void campo_SerieMicroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campo_SerieMicroKeyPressed
        int key = evt.getKeyCode();
        if (key == KeyEvent.VK_ENTER) {
            jButtonListarFiltros.doClick();
        }
    }//GEN-LAST:event_campo_SerieMicroKeyPressed

    private void TodosUsuariosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TodosUsuariosMousePressed
        if (evt.getClickCount() == 2 && !evt.isConsumed()) {
            evt.consume();

            if (TodosUsuarios.getSelectedRow() >= 0) {
                Usuario selecionadoUsuario = new Usuario();
                selecionadoUsuario = listaDeUsuarios.get(TodosUsuarios.getSelectedRow());

                VisualizarUsuario visualizar = new VisualizarUsuario(selecionadoUsuario, this.logado);
                visualizar.setVisible(true);

            } else {
                JOptionPane.showMessageDialog(null, "Escolha algum usuário da tabela para visualizá-lo!");
            };

        }
    }//GEN-LAST:event_TodosUsuariosMousePressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        try {

            String filtroUserString = campoPesquisarTodosCampos.getText();

            //FACHADA

            listaDeUsuarios = Fachada.getInstancia().listarUsuarioTodosCampos(filtroUserString);

            DefaultTableModel tabelaDeUsuarios = new DefaultTableModel() {

                //private static final long serialVersionUID = 1L;
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
                ;

            };
            tabelaDeUsuarios.setColumnIdentifiers(new String[]{"Nome", "Pavimento", "Gerência", "Cargo", "Tombo Micro", "Host Name", "CMTECH", "Etiqueta Sad", "Proprietário"});

            for (Usuario user : listaDeUsuarios) {
                tabelaDeUsuarios.addRow(new String[]{user.getNome(), user.getPavimentoUsuario().getPavimento(), user.getGerencia().getSiglaGerencia(),
                        user.getCargo().getCargo(), user.getTombamentoMicro() + "", user.getNomepc(), user.getEtiquetaCESU() + "", user.getEtiquetaSAD(), user.getProprietarioMicro().getProprietario()});
            }

            TodosUsuarios.setModel(tabelaDeUsuarios);
            TodosUsuarios.getColumnModel().getColumn(0).setMinWidth(200);
            TodosUsuarios.getColumnModel().getColumn(0).setMaxWidth(220);
            TodosUsuarios.getColumnModel().getColumn(1).setMinWidth(100);
            TodosUsuarios.getColumnModel().getColumn(1).setMaxWidth(100);
            TodosUsuarios.getColumnModel().getColumn(2).setMinWidth(90);
            TodosUsuarios.getColumnModel().getColumn(2).setMaxWidth(110);
            TodosUsuarios.getColumnModel().getColumn(4).setMaxWidth(100);
            TodosUsuarios.getColumnModel().getColumn(4).setMinWidth(100);
            TodosUsuarios.getColumnModel().getColumn(5).setMinWidth(100);
            TodosUsuarios.getColumnModel().getColumn(6).setMinWidth(80);
            TodosUsuarios.getColumnModel().getColumn(6).setMaxWidth(100);
            TodosUsuarios.getColumnModel().getColumn(7).setMinWidth(80);
            TodosUsuarios.getColumnModel().getColumn(7).setMaxWidth(100);
            TodosUsuarios.getColumnModel().getColumn(8).setMinWidth(80);
            TodosUsuarios.getColumnModel().getColumn(8).setMaxWidth(100);

            textoTotal.setText("Total: " + listaDeUsuarios.size());

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Erro ao listar - " + e.getMessage());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        FormRelatorioCompleto form = new FormRelatorioCompleto(this.logado);
        form.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void buttonOBSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonOBSActionPerformed
        if (TodosUsuarios.getSelectedRow() >= 0) {
            Usuario user = new Usuario();
            user = listaDeUsuarios.get(TodosUsuarios.getSelectedRow());

            ObsHistorico historico = new ObsHistorico(user, this.logado);
            historico.setVisible(true);

        } else {
            JOptionPane.showMessageDialog(null, "Escolha algum computador da lista!");
        };
    }//GEN-LAST:event_buttonOBSActionPerformed

    private void ButtonLimparSelecaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonLimparSelecaoActionPerformed

        campoPesquisarTodosCampos.setText("");

        campoNomeListar.setText("");
        campoFiltroCMTECH.setText("");
        campoTomboMicroListar.setText("");
        campoHostName.setText("");
        campoTomboMonitorListar.setText("");
        campoTomboMonitorListar1.setText("");
        campo_SerieMicro.setText("");
        campoSerieMonitorListar.setText("");
        campoSerieMonitorListar1.setText("");
        jCheckBox1.setSelected(false);
        ComboBoxConfig.setSelectedIndex(0);
        ComboBoxGerenciaSigla.setSelectedIndex(0);
        ComboBoxModeloMicro.setSelectedIndex(0);
        ComboBoxModeloMonitor.setSelectedIndex(0);
        ComboBoxModeloMonitor1.setSelectedIndex(0);
        ComboBoxNotebook.setSelectedIndex(0);
        ComboBoxPavimento.setSelectedIndex(0);
        ComboBoxPlataforma.setSelectedIndex(0);
        ComboBoxVersaoOffice.setSelectedIndex(0);
        ComboBoxPropMicro.setSelectedIndex(0);
        ComboBoxCargo.setSelectedIndex(0);
        ComboBoxSO.setSelectedIndex(0);
    }//GEN-LAST:event_ButtonLimparSelecaoActionPerformed

    private void ComboBoxModeloMonitorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ComboBoxModeloMonitorKeyPressed
        int key = evt.getKeyCode();
        if (key == KeyEvent.VK_ENTER) {
            jButtonListarFiltros.doClick();
        }
    }//GEN-LAST:event_ComboBoxModeloMonitorKeyPressed

    private void ComboBoxGerenciaSiglaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ComboBoxGerenciaSiglaKeyPressed
        int key = evt.getKeyCode();
        if (key == KeyEvent.VK_ENTER) {
            jButtonListarFiltros.doClick();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_ComboBoxGerenciaSiglaKeyPressed

    private void ComboBoxVersaoOfficeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ComboBoxVersaoOfficeKeyPressed
        int key = evt.getKeyCode();
        if (key == KeyEvent.VK_ENTER) {
            jButtonListarFiltros.doClick();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_ComboBoxVersaoOfficeKeyPressed

    private void ComboBoxPropMicroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ComboBoxPropMicroKeyPressed
        int key = evt.getKeyCode();
        if (key == KeyEvent.VK_ENTER) {
            jButtonListarFiltros.doClick();
        }
    }//GEN-LAST:event_ComboBoxPropMicroKeyPressed

    private void ComboBoxCargoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ComboBoxCargoKeyPressed
        int key = evt.getKeyCode();
        if (key == KeyEvent.VK_ENTER) {
            jButtonListarFiltros.doClick();
        }
    }//GEN-LAST:event_ComboBoxCargoKeyPressed

    private void ComboBoxSOKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ComboBoxSOKeyPressed
        int key = evt.getKeyCode();
        if (key == KeyEvent.VK_ENTER) {
            jButtonListarFiltros.doClick();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_ComboBoxSOKeyPressed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        CadastrarUSUARIONOTEBOOK cadastrar = new CadastrarUSUARIONOTEBOOK(this.logado);
        cadastrar.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        try {

            if (TodosUsuarios.getSelectedRow() >= 0) {
                Usuario selecionadoUsuario = new Usuario();
                selecionadoUsuario = listaDeUsuarios.get(TodosUsuarios.getSelectedRow());

                Fachada.getInstancia().alternarNotebookPC(selecionadoUsuario);

                switch (selecionadoUsuario.getNotebook()) {
                    case "sim":
                        JOptionPane.showMessageDialog(null, "Equipamento alterado\nDe: Notebook. \nPara PC.");
                        break;
                    case "não":
                        JOptionPane.showMessageDialog(null, "Equipamento alterado\nDe: PC. \nPara Notebook.");
                        break;
                }

                jButtonListarFiltros.doClick();

            } else {
                JOptionPane.showMessageDialog(null, "Escolha algum equipamentos da tabela para alterar o tipo (Notebook/PC)!");
            }

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(rootPane, "Erro - " + ex.getMessage());

        }
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        GraficoConfiguracoes g = new GraficoConfiguracoes();
        g.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        GraficoGerencia g = new GraficoGerencia();
        g.setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        GraficoModelo g = new GraficoModelo();
        g.setVisible(true);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        GraficoPavimento g = new GraficoPavimento();
        g.setVisible(true);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void exibirTermoOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exibirTermoOptionActionPerformed
        if (TodosUsuarios.getSelectedRow() >= 0) {
            Usuario selecionadoUsuario = new Usuario();
            selecionadoUsuario = listaDeUsuarios.get(TodosUsuarios.getSelectedRow());

            try {
                String urlPadrao = ("\\\\sadfs01\\GTINF\\USINF\\USINF 2015\\TERMO DE RESPONSABILIDADE\\Termos de Responsabilidade - Digitalizados\\");
                File file = new File(urlPadrao + selecionadoUsuario.getNome() + ".pdf");

                Desktop.getDesktop().open(file);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(rootPane, "Nenhum Termo encontrado para o usuário de nome: " + selecionadoUsuario.getNome());
            }

        } else {
            JOptionPane.showMessageDialog(rootPane, "Escolha algum usuário da lista para visualizar o Termo de Responsabilidade.");
        }
    }//GEN-LAST:event_exibirTermoOptionActionPerformed

    private void ComboBoxSOMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ComboBoxSOMouseClicked

        try {

            if (allOs == null) {
                OS comboOS = new OS();

                comboOS.setOs("");

                allOs = Fachada.getInstancia().listarOS(comboOS);

                DefaultComboBoxModel listaComboOS = new DefaultComboBoxModel();

                listaComboOS.addElement("Sistema Operacional");

                for (int i = 0; i < allOs.size(); i++) {
                    OS nomeComboOS = new OS();
                    nomeComboOS = allOs.get(i);
                    listaComboOS.addElement(nomeComboOS.getOs());
                }
                ComboBoxSO.setModel(listaComboOS);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Não existe nenhum Sistema Operacional cadastrado no banco de dados " + e.getMessage());
        }
    }//GEN-LAST:event_ComboBoxSOMouseClicked

    private void ComboBoxCargoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ComboBoxCargoMouseClicked
        try {

            if (allCargos == null) {
                Cargo comboCargo = new Cargo();

                comboCargo.setCargo("");

                allCargos = Fachada.getInstancia().listarCargo(comboCargo);

                DefaultComboBoxModel listaComboCargo = new DefaultComboBoxModel();

                listaComboCargo.addElement("Cargo");

                for (int i = 0; i < allCargos.size(); i++) {
                    Cargo nomeComboCargo = new Cargo();
                    nomeComboCargo = allCargos.get(i);
                    listaComboCargo.addElement(nomeComboCargo.getCargo());
                }
                ComboBoxCargo.setModel(listaComboCargo);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Não existe nenhum Cargo cadastrado no banco de dados " + e.getMessage());
        }
    }//GEN-LAST:event_ComboBoxCargoMouseClicked

    private void ComboBoxPropMicroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ComboBoxPropMicroMouseClicked
        try {

            if (allProprietariosMicros == null) {
                ProprietarioMicro comboProprietarioMicro = new ProprietarioMicro();

                comboProprietarioMicro.setProprietario("");

                allProprietariosMicros = Fachada.getInstancia().listarProprietarioMicro(comboProprietarioMicro);

                DefaultComboBoxModel listaComboProprietarioMicro = new DefaultComboBoxModel();

                listaComboProprietarioMicro.addElement("Proprietário do Micro");

                for (int i = 0; i < allProprietariosMicros.size(); i++) {
                    ProprietarioMicro nomeComboProprietarioMicro = new ProprietarioMicro();
                    nomeComboProprietarioMicro = allProprietariosMicros.get(i);
                    listaComboProprietarioMicro.addElement(nomeComboProprietarioMicro.getProprietario());
                }
                ComboBoxPropMicro.setModel(listaComboProprietarioMicro);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Não existe nenhum Proprietario de Micros cadastrado no banco de dados " + e.getMessage());
        }
    }//GEN-LAST:event_ComboBoxPropMicroMouseClicked

    private void ComboBoxVersaoOfficeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ComboBoxVersaoOfficeMouseClicked
        try {

            if (allVersaoOffice == null) {
                VersaoOffice comboVersaoOffice = new VersaoOffice();

                comboVersaoOffice.setDescricao("");

                allVersaoOffice =Fachada.getInstancia().listarVersaoOffice(comboVersaoOffice);

                DefaultComboBoxModel listaCombo = new DefaultComboBoxModel();

                listaCombo.addElement("Versão do Pacote Office");

                for (int i = 0; i < allVersaoOffice.size(); i++) {
                    VersaoOffice nomeCombo = new VersaoOffice();
                    nomeCombo = allVersaoOffice.get(i);
                    listaCombo.addElement(nomeCombo.getDescricao());
                }
                ComboBoxVersaoOffice.setModel(listaCombo);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Não existe nenhuma Versão do Pacote Office cadastrada no banco de dados.");
        }
    }//GEN-LAST:event_ComboBoxVersaoOfficeMouseClicked

    private void ComboBoxPavimentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ComboBoxPavimentoMouseClicked
        try {

            if (allPavimentos == null) {
                Pavimento comboPavimento = new Pavimento();

                comboPavimento.setPavimento("");

                allPavimentos = Fachada.getInstancia().listarPavimento(comboPavimento);

                DefaultComboBoxModel listaComboPavimento = new DefaultComboBoxModel();

                listaComboPavimento.addElement("Pavimento");

                for (int i = 0; i < allPavimentos.size(); i++) {
                    Pavimento nomeComboPavimento = new Pavimento();
                    nomeComboPavimento = allPavimentos.get(i);
                    listaComboPavimento.addElement(nomeComboPavimento.getPavimento());
                }
                ComboBoxPavimento.setModel(listaComboPavimento);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Não existe nenhumo Pavimento cadastrado no banco de dados " + e.getMessage());
        }
    }//GEN-LAST:event_ComboBoxPavimentoMouseClicked

    private void ComboBoxConfigMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ComboBoxConfigMouseClicked
        try {

            if (allConfiguracoes == null) {
                Configuracao comboConfiguracao = new Configuracao();

                comboConfiguracao.setConfiguracao("");

                allConfiguracoes = Fachada.getInstancia().listarConfiguracao(comboConfiguracao);

                DefaultComboBoxModel listaComboConfiguracao = new DefaultComboBoxModel();

                listaComboConfiguracao.addElement("Configuração");

                for (int i = 0; i < allConfiguracoes.size(); i++) {
                    Configuracao nomeComboConfiguracao = new Configuracao();
                    nomeComboConfiguracao = allConfiguracoes.get(i);
                    listaComboConfiguracao.addElement(nomeComboConfiguracao.getConfiguracao());
                }
                ComboBoxConfig.setModel(listaComboConfiguracao);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Não existe nenhuma Configuração cadastrada no banco de dados " + e.getMessage());
        }

    }//GEN-LAST:event_ComboBoxConfigMouseClicked

    private void ComboBoxModeloMicroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ComboBoxModeloMicroMouseClicked
        try {

            if (allModelosMicros == null) {
                ModeloMicro comboModeloMicro = new ModeloMicro();

                comboModeloMicro.setModelo("");
                comboModeloMicro.setIdModelo(0);

                MarcaMicro vazio = new MarcaMicro();
                vazio.setIdMarca(0);
                vazio.setMarca("");
                comboModeloMicro.setMarca(vazio);


                allModelosMicros = Fachada.getInstancia().listarModeloMicro(comboModeloMicro);

                DefaultComboBoxModel listaComboModelosMicros = new DefaultComboBoxModel();

                listaComboModelosMicros.addElement("Modelo do Micro");

                for (int i = 0; i < allModelosMicros.size(); i++) {
                    ModeloMicro nomeComboModeloMicro = new ModeloMicro();
                    nomeComboModeloMicro = allModelosMicros.get(i);
                    listaComboModelosMicros.addElement(nomeComboModeloMicro.getModelo());
                }
                ComboBoxModeloMicro.setModel(listaComboModelosMicros);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Não existe nenhum Modelo de Micro cadastrado no banco de dados " + e.getMessage());
        }
    }//GEN-LAST:event_ComboBoxModeloMicroMouseClicked

    private void ComboBoxModeloMonitorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ComboBoxModeloMonitorMouseClicked
        try {

            if (allModelosMonitores == null) {
                ModeloMonitor comboModeloMonitor = new ModeloMonitor();

                comboModeloMonitor.setModelo("");
                MarcaMonitor m = new MarcaMonitor();
                m.setIdMarca(0);
                m.setMarca("");
                comboModeloMonitor.setMarca(m);

                allModelosMonitores = Fachada.getInstancia().listarModeloMonitor(comboModeloMonitor);

                DefaultComboBoxModel listaComboModeloMonitor = new DefaultComboBoxModel();

                listaComboModeloMonitor.addElement("Modelo do Monitor");

                for (int i = 0; i < allModelosMonitores.size(); i++) {
                    ModeloMonitor nomeComboModeloMonitor = new ModeloMonitor();
                    nomeComboModeloMonitor = allModelosMonitores.get(i);
                    listaComboModeloMonitor.addElement(nomeComboModeloMonitor.getModelo());
                }
                ComboBoxModeloMonitor.setModel(listaComboModeloMonitor);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Não existe nenhuma Modelo de Monitor cadastrado no banco de dados " + e.getMessage());
        }

    }//GEN-LAST:event_ComboBoxModeloMonitorMouseClicked

    private void ComboBoxGerenciaSiglaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ComboBoxGerenciaSiglaMouseClicked
        try {

            if (allGerencias == null) {

                Gerencia comboGerencia = new Gerencia();

                comboGerencia.setGerencia("");
                comboGerencia.setSiglaGerencia("");
                Pavimento pavGer = new Pavimento();
                pavGer.setIdPavimento(0);
                pavGer.setPavimento("");
                comboGerencia.setPavimento(pavGer);


                allGerencias = Fachada.getInstancia().listarGerencia(comboGerencia);

                DefaultComboBoxModel listaComboGerencia = new DefaultComboBoxModel();

                listaComboGerencia.addElement("Gerência");

                for (int i = 0; i < allGerencias.size(); i++) {
                    Gerencia nomeComboGerencia = new Gerencia();
                    nomeComboGerencia = allGerencias.get(i);
                    listaComboGerencia.addElement(nomeComboGerencia.getSiglaGerencia());
                }
                ComboBoxGerenciaSigla.setModel(listaComboGerencia);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Não existe nenhuma Gerência cadastrada no banco de dados " + e.getMessage());
        }
    }//GEN-LAST:event_ComboBoxGerenciaSiglaMouseClicked

    private void ComboBoxPlataformaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ComboBoxPlataformaMouseClicked
        try {

            if (allPlataformas == null) {

                PlataformaMicro comboPlataformaMicro = new PlataformaMicro();

                comboPlataformaMicro.setPlataforma("");

                allPlataformas = Fachada.getInstancia().listarPlataformaMicro(comboPlataformaMicro);

                DefaultComboBoxModel listaComboPlataformaMicro = new DefaultComboBoxModel();

                listaComboPlataformaMicro.addElement("Plataforma");

                for (int i = 0; i < allPlataformas.size(); i++) {
                    PlataformaMicro nomeComboPlataformaMicro = new PlataformaMicro();
                    nomeComboPlataformaMicro = allPlataformas.get(i);
                    listaComboPlataformaMicro.addElement(nomeComboPlataformaMicro.getPlataforma());
                }
                ComboBoxPlataforma.setModel(listaComboPlataformaMicro);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Não existe nenhuma Plataforma cadastrada no banco de dados " + e.getMessage());
        }

    }//GEN-LAST:event_ComboBoxPlataformaMouseClicked

    private void ComboBoxPlataformaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ComboBoxPlataformaKeyPressed
        int key = evt.getKeyCode();
        if (key == KeyEvent.VK_ENTER) {
            jButtonListarFiltros.doClick();
        }
    }//GEN-LAST:event_ComboBoxPlataformaKeyPressed

    private void BotaoPesquisaExataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoPesquisaExataActionPerformed
        if(BotaoPesquisaExata.isSelected()){
            BotaoPesquisaExata.setText("Pesquisa Exata: Ativada!");
        }else{
            BotaoPesquisaExata.setText("Pesquisa Exata: Desativada!");
        }
    }//GEN-LAST:event_BotaoPesquisaExataActionPerformed

    private void ComboTermoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboTermoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboTermoActionPerformed

    private void ComboBoxModeloMonitor1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ComboBoxModeloMonitor1MouseClicked
        try {

            if (allModelosMonitores1 == null) {
                ModeloMonitor comboModeloMonitor = new ModeloMonitor();

                comboModeloMonitor.setModelo("");
                MarcaMonitor m = new MarcaMonitor();
                m.setIdMarca(0);
                m.setMarca("");
                comboModeloMonitor.setMarca(m);

                allModelosMonitores1 = Fachada.getInstancia().listarModeloMonitor(comboModeloMonitor);

                DefaultComboBoxModel listaComboModeloMonitor = new DefaultComboBoxModel();

                listaComboModeloMonitor.addElement("Modelo do Monitor");

                for (int i = 0; i < allModelosMonitores1.size(); i++) {
                    ModeloMonitor nomeComboModeloMonitor = new ModeloMonitor();
                    nomeComboModeloMonitor = allModelosMonitores1.get(i);
                    listaComboModeloMonitor.addElement(nomeComboModeloMonitor.getModelo());
                }
                ComboBoxModeloMonitor1.setModel(listaComboModeloMonitor);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Não existe nenhuma Modelo de Monitor cadastrado no banco de dados " + e.getMessage());
        }

    }//GEN-LAST:event_ComboBoxModeloMonitor1MouseClicked

    private void ComboBoxModeloMonitor1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ComboBoxModeloMonitor1KeyPressed
        int key1 = evt.getKeyCode();
        if (key1 == KeyEvent.VK_ENTER) {
            jButtonListarFiltros.doClick();
        }
    }//GEN-LAST:event_ComboBoxModeloMonitor1KeyPressed

    private void ComboBoxModeloMonitorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxModeloMonitorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboBoxModeloMonitorActionPerformed

    private void ComboBoxModeloMonitor1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxModeloMonitor1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboBoxModeloMonitor1ActionPerformed

    private void campoHostNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoHostNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoHostNameActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:

    }
//GEN-LAST:event_jCheckBox1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) { //class, interface, or enum expected

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
            java.util.logging.Logger.getLogger(ListarUSUARIO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListarUSUARIO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListarUSUARIO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListarUSUARIO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListarUSUARIO().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton BotaoPesquisaExata;
    private javax.swing.JButton ButtonLimparSelecao;
    private javax.swing.JComboBox ComboBoxCargo;
    private javax.swing.JComboBox ComboBoxConfig;
    private javax.swing.JComboBox ComboBoxGerenciaSigla;
    private javax.swing.JComboBox ComboBoxModeloMicro;
    private javax.swing.JComboBox ComboBoxModeloMonitor;
    private javax.swing.JComboBox ComboBoxModeloMonitor1;
    private javax.swing.JComboBox ComboBoxNotebook;
    private javax.swing.JComboBox ComboBoxPavimento;
    private javax.swing.JComboBox ComboBoxPlataforma;
    private javax.swing.JComboBox ComboBoxPropMicro;
    private javax.swing.JComboBox ComboBoxSO;
    private javax.swing.JComboBox ComboBoxVersaoOffice;
    private javax.swing.JComboBox ComboTermo;
    private javax.swing.JTable TodosUsuarios;
    private javax.swing.JButton buttonOBS;
    private javax.swing.JTextField campoFiltroCMTECH;
    private javax.swing.JTextField campoHostName;
    private javax.swing.JTextField campoNomeListar;
    private javax.swing.JTextField campoPesquisarTodosCampos;
    private javax.swing.JTextField campoSerieMonitorListar;
    private javax.swing.JTextField campoSerieMonitorListar1;
    private javax.swing.JTextField campoTomboMicroListar;
    private javax.swing.JTextField campoTomboMonitorListar;
    private javax.swing.JTextField campoTomboMonitorListar1;
    private javax.swing.JTextField campo_SerieMicro;
    private javax.swing.JMenuItem exibirTermoOption;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButtonAlterarUsuario;
    protected static javax.swing.JButton jButtonListarFiltros;
    private javax.swing.JButton jButtonNovoCadastro;
    private javax.swing.JButton jButtonRemoverUsuário;
    private javax.swing.JButton jButtonVisualizarUsuario;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItemRelatorio;
    private javax.swing.JMenuItem jMenuItemSair;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextField jTextField_EtiquetaSad;
    private javax.swing.JButton listarVoltar;
    private javax.swing.JLabel textoTotal;
    // End of variables declaration//GEN-END:variables
}
