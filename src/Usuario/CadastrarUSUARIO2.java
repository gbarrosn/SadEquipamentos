/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuario;

import Geral.Fachada;
import GuiJP.TelaEquipamentosEscolha;
import Login.LoginUser;
import Micro.Configuracao.Configuracao;
import Micro.MarcaMicro.MarcaMicro;
import Micro.ModeloMicro.ModeloMicro;
import Micro.OS.OS;
import Micro.PlataformaMicro.PlataformaMicro;
import Micro.ProprietarioMicro.ProprietarioMicro;
import Monitor.MarcaMonitor.MarcaMonitor;
import Monitor.ModeloMonitor.ModeloMonitor;
import Monitor.ProprietarioMonitor.ProprietarioMonitor;
import Principal.TelaPrincipal;
import SADpe.Cargo.Cargo;
import SADpe.Gerencia.Gerencia;
import SADpe.Pavimento.Pavimento;
import Versao_Office.VersaoOffice;
import java.awt.Desktop;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Posseidon
 */
public class CadastrarUSUARIO2 extends javax.swing.JFrame {

    /**
     * Creates new form CadastrarUSUARIO
     */
    private LoginUser logado;
    private ArrayList<Gerencia> allGerencias;
    private ArrayList<Cargo> allCargos;
    private ArrayList<Pavimento> allPavimentos;
    private ArrayList<Configuracao> allConfiguracoes;
    private ArrayList<MarcaMicro> allMarcasMicros;
    private ArrayList<ModeloMicro> allModelosMicros;
    private ArrayList<PlataformaMicro> allPlataformas;
    private ArrayList<ProprietarioMicro> allProprietariosMicros;
    private ArrayList<ModeloMonitor> allModelosMonitores;
    private ArrayList<MarcaMonitor> allMarcasMonitores;
    private ArrayList<VersaoOffice> allVersaoOffice;
    private ArrayList<ProprietarioMonitor> allProprietariosMonitores;
    private ArrayList<OS> allOs;

    public CadastrarUSUARIO2() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Formulário de cadastro de Usuário");

        campo_Garantia.setText("N/I");
        Campo_SerieMicro.setText("N/I");
        Campo_SerieMonitor.setText("N/I");
        Campo_NovoTomboMicro.setText("N/I");
        Campo_NovoTomboMonitor.setText("N/I");
        campoPossuiTermo.setSelected(false);

        Campo_TomboMicro.setText(1 + "");
        Campo_TomboMonitor.setText(1 + "");
        Campo_cmtech.setText(1 + "");

        //Box_SO.setSelectedIndex(5);
        //Box_Office.setSelectedIndex(1);
    }

    public CadastrarUSUARIO2(LoginUser logado) {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Formulário de cadastro de Usuário");

        this.logado = logado;

        campo_Garantia.setText("N/I");
        Campo_SerieMicro.setText("N/I");
        Campo_SerieMonitor.setText("N/I");

        Campo_NovoTomboMicro.setText("N/I");
        Campo_NovoTomboMonitor.setText("N/I");
        campoPossuiTermo.setSelected(false);

        Campo_TomboMicro.setText(1 + "");
        Campo_TomboMonitor.setText(1 + "");
        Campo_cmtech.setText(1 + "");

        //Box_SO.setSelectedIndex(5);
        //Box_Office.setSelectedIndex(1);
    }

    @Deprecated
    void icone() {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("src\\resources\\favicon-cor.png"));
            this.setIconImage(img);
        } catch (IOException e) {
        }
    }

    public void listarGerencia() {
        try {

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
                    Box_GerenciaUser.setModel(listaComboGerencia);
                }
            } catch (Exception e) {
                throw new Exception("Não existe nenhuma Gerência cadastrada no banco de dados " + e.getMessage());
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        }

    }

    public void listarMarcaMonitor() {
        try {

            try {

                if (allMarcasMonitores == null) {
                    MarcaMonitor comboMarcaMonitor = new MarcaMonitor();

                    comboMarcaMonitor.setMarca("");
                    allMarcasMonitores = Fachada.getInstancia().listarMarcaMonitor(comboMarcaMonitor);

                    DefaultComboBoxModel listaComboMarcaMonitor = new DefaultComboBoxModel();

                    listaComboMarcaMonitor.addElement("Marca do Monitor");

                    for (int i = 0; i < allMarcasMonitores.size(); i++) {
                        MarcaMonitor nomeComboMarcaMonitor = new MarcaMonitor();
                        nomeComboMarcaMonitor = allMarcasMonitores.get(i);
                        listaComboMarcaMonitor.addElement(nomeComboMarcaMonitor.getMarca());
                    }
                    Box_MarcaMonitor.setModel(listaComboMarcaMonitor);
                }
            } catch (Exception e) {
                throw new Exception("Não existe nenhuma Marca de Monitor cadastrado no banco de dados " + e.getMessage());
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        }

    }

    public void listarMarcaMicro() {

        try {
            if (allMarcasMicros == null) {
                try {
                    MarcaMicro comboMarcaMicro = new MarcaMicro();

                    comboMarcaMicro.setMarca("");
                    allMarcasMicros = Fachada.getInstancia().listarMarcaMicro(comboMarcaMicro);

                    DefaultComboBoxModel listaComboMarcasMicros = new DefaultComboBoxModel();

                    listaComboMarcasMicros.addElement("Marca do Micro");

                    for (int i = 0; i < allMarcasMicros.size(); i++) {
                        MarcaMicro nomeComboMarcaMicro = new MarcaMicro();
                        nomeComboMarcaMicro = allMarcasMicros.get(i);
                        listaComboMarcasMicros.addElement(nomeComboMarcaMicro.getMarca());
                    }
                    Box_MarcaMicro.setModel(listaComboMarcasMicros);

                } catch (Exception e) {
                    throw new Exception("Não existe nenhuma Marca de Micro cadastrada no banco de dados " + e.getMessage());
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
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
        jLabel22 = new javax.swing.JLabel();
        campo_Garantia = new javax.swing.JTextField();
        Button_Cadastrar = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        Button_Cadastrar1 = new javax.swing.JButton();
        jButtonLimparCampos = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Box_ModeloMicro = new javax.swing.JComboBox();
        Box_GerenciaUser = new javax.swing.JComboBox();
        jLabel16 = new javax.swing.JLabel();
        Campo_HostNameMicro = new javax.swing.JTextField();
        Box_ModeloMonitor = new javax.swing.JComboBox();
        jLabel27 = new javax.swing.JLabel();
        Campo_SerieMonitor = new javax.swing.JTextField();
        Campo_NovoTomboMonitor = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        campoDescricao = new javax.swing.JLabel();
        Campo_NovoTomboMicro = new javax.swing.JTextField();
        ButtonExibirOrganograma = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        Box_Office = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        Box_SO = new javax.swing.JComboBox();
        Box_MarcaMicro = new javax.swing.JComboBox();
        Box_ConfigMicro = new javax.swing.JComboBox();
        jLabel18 = new javax.swing.JLabel();
        Box_ProprietarioMonitor = new javax.swing.JComboBox();
        jLabel17 = new javax.swing.JLabel();
        Box_Plataforma = new javax.swing.JComboBox();
        Box_CargoUser = new javax.swing.JComboBox();
        jLabel23 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        Box_PavimentoUser = new javax.swing.JComboBox();
        Campo_NomeUser = new javax.swing.JTextField();
        Campo_cmtech = new javax.swing.JTextField();
        Box_ProprietarioMicro = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Campo_TomboMonitor = new javax.swing.JTextField();
        Campo_TomboMicro = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        Box_MarcaMonitor = new javax.swing.JComboBox();
        jLabel14 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel11 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        Campo_SerieMicro = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        campoPossuiTermo = new javax.swing.JCheckBox();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("            Usuário:");
        jLabel1.setAlignmentX(0.5F);
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel22.setText("Garantia:");

        Button_Cadastrar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Button_Cadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Icons/diskette_32.png"))); // NOI18N
        Button_Cadastrar.setText("Concluir");
        Button_Cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_CadastrarActionPerformed(evt);
            }
        });

        Button_Cadastrar1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Button_Cadastrar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Icons/arrow_left_32.png"))); // NOI18N
        Button_Cadastrar1.setText("Voltar");
        Button_Cadastrar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_Cadastrar1ActionPerformed(evt);
            }
        });

        jButtonLimparCampos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Icons/format_painter.png"))); // NOI18N
        jButtonLimparCampos.setText("Limpar Campos");
        jButtonLimparCampos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimparCamposActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("      Microcomputador:");
        jLabel6.setAlignmentX(0.5F);
        jLabel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("Nome:");

        jLabel3.setText("Gerência:");

        Box_ModeloMicro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Modelo do Micro" }));
        Box_ModeloMicro.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                Box_ModeloMicroItemStateChanged(evt);
            }
        });
        Box_ModeloMicro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Box_ModeloMicroMouseClicked(evt);
            }
        });

        Box_GerenciaUser.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Gerência" }));
        Box_GerenciaUser.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                Box_GerenciaUserItemStateChanged(evt);
            }
        });
        Box_GerenciaUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Box_GerenciaUserMouseClicked(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setText("            Monitor:");
        jLabel16.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        Box_ModeloMonitor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Modelo do Monitor" }));
        Box_ModeloMonitor.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                Box_ModeloMonitorItemStateChanged(evt);
            }
        });
        Box_ModeloMonitor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Box_ModeloMonitorMouseClicked(evt);
            }
        });

        jLabel27.setText("Novo Tombo:");

        jLabel7.setText("Host Name:");

        jLabel8.setText("Tombo:");

        jLabel28.setText("Novo Tombo:");

        campoDescricao.setText("Descrição:");

        ButtonExibirOrganograma.setText("Exibir organograma");
        ButtonExibirOrganograma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonExibirOrganogramaActionPerformed(evt);
            }
        });

        jLabel26.setText("Office:");

        Box_Office.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Versão do Pacote Office" }));
        Box_Office.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Box_OfficeMouseClicked(evt);
            }
        });

        jLabel12.setText("Modelo:");

        Box_SO.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Sistema Operacional" }));
        Box_SO.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Box_SOMouseClicked(evt);
            }
        });

        Box_MarcaMicro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Marca do Micro" }));
        Box_MarcaMicro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Box_MarcaMicroMouseClicked(evt);
            }
        });

        Box_ConfigMicro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Configuração" }));
        Box_ConfigMicro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Box_ConfigMicroMouseClicked(evt);
            }
        });

        jLabel18.setText("Série:");

        Box_ProprietarioMonitor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Proprietário do Monitor" }));
        Box_ProprietarioMonitor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Box_ProprietarioMonitorMouseClicked(evt);
            }
        });

        jLabel17.setText("Tombo:");

        Box_Plataforma.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Plataforma do Micro" }));
        Box_Plataforma.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Box_PlataformaMouseClicked(evt);
            }
        });

        Box_CargoUser.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Cargo" }));
        Box_CargoUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Box_CargoUserMouseClicked(evt);
            }
        });

        jLabel23.setText("CESU:");

        jLabel15.setText("Plataforma:");

        Box_PavimentoUser.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pavimento" }));
        Box_PavimentoUser.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                Box_PavimentoUserItemStateChanged(evt);
            }
        });
        Box_PavimentoUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Box_PavimentoUserMouseClicked(evt);
            }
        });
        Box_PavimentoUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Box_PavimentoUserActionPerformed(evt);
            }
        });

        Box_ProprietarioMicro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Proprietário do Micro" }));
        Box_ProprietarioMicro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Box_ProprietarioMicroMouseClicked(evt);
            }
        });

        jLabel10.setText("Configuração:");

        jLabel5.setText("Pavimento:");

        jLabel19.setText("Modelo:");

        Box_MarcaMonitor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Marca do Monitor" }));
        Box_MarcaMonitor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Box_MarcaMonitorMouseClicked(evt);
            }
        });

        jLabel14.setText("Sistema:");

        jLabel4.setText("Cargo:");

        jLabel11.setText("Marca:");

        jLabel20.setText("Marca:");

        jLabel9.setText("Série:");

        jLabel21.setText("Proprietário:");

        Campo_SerieMicro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Campo_SerieMicroActionPerformed(evt);
            }
        });

        jLabel13.setText("Proprietário:");

        campoPossuiTermo.setText("Possui Termo?");

        jMenu1.setText("Opções");

        jMenuItem1.setText("Limpar Campos");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Listar Usuários");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem4.setText("Sair do Sistema");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.DEFAULT_SIZE, 1, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSeparator5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(22, 22, 22)
                                            .addComponent(jLabel5)
                                            .addGap(10, 10, 10)
                                            .addComponent(Box_PavimentoUser, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(jLabel3)
                                            .addGap(18, 18, 18)
                                            .addComponent(Box_GerenciaUser, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(10, 10, 10)
                                            .addComponent(ButtonExibirOrganograma, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(436, 436, 436)
                                            .addComponent(campoDescricao))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(22, 22, 22)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(22, 22, 22)
                                            .addComponent(jLabel10)
                                            .addGap(10, 10, 10)
                                            .addComponent(Box_ConfigMicro, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(jLabel11)
                                            .addGap(10, 10, 10)
                                            .addComponent(Box_MarcaMicro, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(jLabel13)
                                            .addGap(20, 20, 20)
                                            .addComponent(Box_ProprietarioMicro, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(22, 22, 22)
                                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(22, 22, 22)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(jLabel18)
                                                    .addGap(28, 28, 28)
                                                    .addComponent(Campo_SerieMonitor, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(21, 21, 21)
                                                    .addComponent(jLabel17)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(Campo_TomboMonitor, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(13, 13, 13)
                                                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(Campo_NovoTomboMonitor, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(jLabel19)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(Box_ModeloMonitor, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(21, 21, 21)
                                                    .addComponent(jLabel20)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(Box_MarcaMonitor, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(10, 10, 10)
                                                    .addComponent(jLabel21)
                                                    .addGap(10, 10, 10)
                                                    .addComponent(Box_ProprietarioMonitor, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 879, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(22, 22, 22)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel15))
                                            .addGap(24, 24, 24)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(Box_SO, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(jLabel26)
                                                    .addGap(10, 10, 10)
                                                    .addComponent(Box_Office, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addComponent(Box_Plataforma, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(22, 22, 22)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(jLabel7)
                                                    .addGap(24, 24, 24)
                                                    .addComponent(Campo_HostNameMicro, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(20, 20, 20)
                                                    .addComponent(jLabel8)
                                                    .addGap(4, 4, 4)
                                                    .addComponent(Campo_TomboMicro, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(jLabel12)
                                                    .addGap(42, 42, 42)
                                                    .addComponent(Box_ModeloMicro, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(4, 4, 4)
                                                    .addComponent(Campo_SerieMicro, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(21, 21, 21)
                                                    .addComponent(jLabel23)))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(Campo_cmtech)
                                                .addComponent(Campo_NovoTomboMicro, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(22, 22, 22)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(jLabel2)
                                                    .addGap(33, 33, 33)
                                                    .addComponent(Campo_NomeUser, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(jLabel4)
                                                    .addGap(31, 31, 31)
                                                    .addComponent(Box_CargoUser, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                    .addGap(6, 6, 6))
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 879, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Button_Cadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(497, 497, 497)
                                .addComponent(jButtonLimparCampos)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Button_Cadastrar1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 885, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(22, 22, 22))
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(campo_Garantia, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(campoPossuiTermo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(174, 174, 174)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(campo_Garantia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoPossuiTermo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 24, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Campo_NomeUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Box_CargoUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel5))
                            .addComponent(Box_PavimentoUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel3))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(Box_GerenciaUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(ButtonExibirOrganograma, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(7, 7, 7)
                        .addComponent(campoDescricao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Campo_HostNameMicro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(Campo_TomboMicro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel28)
                                .addComponent(Campo_NovoTomboMicro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8))))
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Box_ModeloMicro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Campo_SerieMicro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Campo_cmtech, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel23))))
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Box_ConfigMicro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Box_MarcaMicro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Box_ProprietarioMicro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel13))))
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Box_Office, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel26)
                                        .addComponent(Box_SO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(Box_Plataforma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel17)
                                        .addComponent(Campo_SerieMonitor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(Campo_TomboMonitor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel27)
                                    .addComponent(Campo_NovoTomboMonitor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel19))
                            .addComponent(Box_ModeloMonitor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel20))
                            .addComponent(Box_MarcaMonitor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel21))
                            .addComponent(Box_ProprietarioMonitor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)))
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonLimparCampos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Button_Cadastrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(Button_Cadastrar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void Button_CadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_CadastrarActionPerformed

        try {

            Usuario user = new Usuario();

            user.setNotebook("não");

            //Recebendo objetos do ComboBox:
            //VERSÃO DO PACOTE OFFICE
            try {
                int SelecionadoVersaoOffice = Box_Office.getSelectedIndex() - 1;
                user.setVersao_office(allVersaoOffice.get(SelecionadoVersaoOffice));
            } catch (Exception e) {
                throw new Exception("Selecione a versão do Pacote do Office usada pelo Usuário.");
            }
            //Gerência:
            try {
                int SelecionadoGerencia = Box_GerenciaUser.getSelectedIndex() - 1;
                user.setGerencia(allGerencias.get(SelecionadoGerencia));
            } catch (Exception e) {
                throw new Exception("Selecione uma Gerência para o Usuário.");
            }

            //Cargo:
            try {
                int SelecionadoCargo = Box_CargoUser.getSelectedIndex() - 1;
                user.setCargo(allCargos.get(SelecionadoCargo));
            } catch (Exception e) {
                throw new Exception("Selecione um Cargo para o Usuário.");
            }
            //Gerência:
            try {
                int SelecionadoGerencia = Box_GerenciaUser.getSelectedIndex() - 1;
                user.setGerencia(allGerencias.get(SelecionadoGerencia));
            } catch (Exception e) {
                throw new Exception("Selecione uma Gerência para o Usuário.");
            }
            //Pavimento:
            try {
                int SelecionadoPavimento = Box_PavimentoUser.getSelectedIndex() - 1;
                user.setPavimentoUsuario(allPavimentos.get(SelecionadoPavimento));
            } catch (Exception e) {
                throw new Exception("Selecione um Pavimento para o Usuário");
            }
            //Plataforma:
            try {
                int SelecionadoPlataforma = Box_Plataforma.getSelectedIndex() - 1;
                user.setPlataformaMicro(allPlataformas.get(SelecionadoPlataforma));
            } catch (Exception e) {
                throw new Exception("Selecione uma Plataforma para o Microcomputador");
            }
            //Modelo Micro:
            try {
                int SelecionadoModeloMicro = Box_ModeloMicro.getSelectedIndex() - 1;
                user.setModeloMicro(allModelosMicros.get(SelecionadoModeloMicro));
            } catch (Exception e) {
                throw new Exception("Selecione um Modelo para o Microcomputador");
            }

            //Configuração:
            try {
                int SelecionadoConfiguracao = Box_ConfigMicro.getSelectedIndex() - 1;
                user.setConfigMicro(allConfiguracoes.get(SelecionadoConfiguracao));
            } catch (Exception e) {
                throw new Exception("Selecione uma Configuração para o Microcomputador");
            }

            //Marca Micro:
            try {
                int SelecionadoMarcaMicro = Box_MarcaMicro.getSelectedIndex() - 1;
                user.setMarcaMicro(allMarcasMicros.get(SelecionadoMarcaMicro));
            } catch (Exception e) {
                throw new Exception("Selecione uma Marca para o Microcomputador");
            }

            //Proprietário Micro:
            try {
                int SelecionadoProprietarioMicro = Box_ProprietarioMicro.getSelectedIndex() - 1;
                user.setProprietarioMicro(allProprietariosMicros.get(SelecionadoProprietarioMicro));
            } catch (Exception e) {
                throw new Exception("Selecione um Proprietário para o Microcomputador");
            }

            //Sistema:
            try {
                int SelecionadoOs = Box_SO.getSelectedIndex() - 1;
                user.setOsMicro(allOs.get(SelecionadoOs));
            } catch (Exception e) {
                throw new Exception("Selecione uma Sistema Operacional para o Microcomputador");
            }

            //Proprietário Monitor:          
            try {
                int SelecionadoProprietarioMonitor = Box_ProprietarioMonitor.getSelectedIndex() - 1;
                user.setProprietarioMonitor(allProprietariosMonitores.get(SelecionadoProprietarioMonitor));
            } catch (Exception e) {
                throw new Exception("Selecione um Proprietário para o Monitor");
            }

            //Modelo Monitor:           
            try {
                int SelecionadoModeloMonitor = Box_ModeloMonitor.getSelectedIndex() - 1;
                user.setModeloMonitor(allModelosMonitores.get(SelecionadoModeloMonitor));
            } catch (Exception e) {
                throw new Exception("Selecione um Modelo para o Monitor");
            }

            //Marca Monitor:           
            try {
                int SelecionadoMarcaMonitor = Box_MarcaMonitor.getSelectedIndex() - 1;
                user.setMarcaMonitor(allMarcasMonitores.get(SelecionadoMarcaMonitor));
            } catch (Exception e) {
                throw new Exception("Selecione uma Marca para o Monitor");
            }

            //Recebendo campos Strings:
            user.setNome(Campo_NomeUser.getText().toUpperCase());

            user.setNomepc(Campo_HostNameMicro.getText().toUpperCase());

            user.setSerieMicro(Campo_SerieMicro.getText().toUpperCase());

            user.setSerieMonitor(Campo_SerieMonitor.getText().toUpperCase());

            user.setGarantia(campo_Garantia.getText().toUpperCase());

            user.setNovoTomboMicro(Campo_NovoTomboMicro.getText().toUpperCase());

            user.setNovoTomboMonitor(Campo_NovoTomboMonitor.getText().toUpperCase());

            user.setTermo_responsabilidade(campoPossuiTermo.isSelected());

            //String campoObs = campoOBS.getText();
            //user.setObs(campoObs);
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            Date date = new Date();
            String dataAlt;
            dataAlt = dateFormat.format(date);
            //String nomeUsuarioPC = System.getProperty("user.name");
            user.setDataAlteracao(dataAlt);

            user.setUsuarioAlteracao(this.logado.getLogin());

            //********************************** Recebendo e Tratando excessão de números inteiros.
            //Tombo Micro:
            try {
                String tomboMicroPC = Campo_TomboMicro.getText();
                long tomboMicroPCIntParse = Long.parseLong(tomboMicroPC);
                user.setTombamentoMicro(tomboMicroPCIntParse);
            } catch (NumberFormatException e) {
                if (Campo_TomboMicro.getText().trim().equals("") == true) {
                    throw new Exception("Preencha o campo Tombamento do Micro!(Obrigatório).");
                } else {
                    throw new Exception("Erro - Campo Tombamento do Micro: Preencha apenas com números.");
                }
            }

            //Tombo Monitor:      
            try {
                String tomboMonitorPC = Campo_TomboMonitor.getText();
                long tomboMonitorPCIntParse = Long.parseLong(tomboMonitorPC);
                user.setTombamentoMonitor(tomboMonitorPCIntParse);
            } catch (NumberFormatException e) {
                if (Campo_TomboMonitor.getText().trim().equals("") == true) {
                    throw new Exception("Preencha o campo Tombamento do Monitor!(Obrigatório).");
                } else {
                    throw new Exception("Erro - Campo Tombamento do Monitor: Preencha apenas com números.");
                }
            }

            //Etiqueta CMTECH:
            try {
                String etiqueta = Campo_cmtech.getText();
                Long etiquetaIntParse = Long.parseLong(etiqueta);
                user.setEtiquetaCESU(etiquetaIntParse);
            } catch (NumberFormatException e) {
                if (Campo_cmtech.getText().trim().equals("") == true) {
                    throw new Exception("Preencha o campo Etiqueta CESU!(Obrigatório).");
                } else {
                    throw new Exception("Erro - Campo Etiqueta CESU: Preencha apenas com números.");
                }
            }

            Fachada.getInstancia().cadastrarUsuario(user);
            JOptionPane.showMessageDialog(rootPane, "Usuário: " + user.getNome() + " cadastrado com sucesso!");

            if (JOptionPane.showConfirmDialog(new JFrame(),
                    "Deseja cadastrar outro Usuário?",
                    "Cadastrar Novo Usuário", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                jButtonLimparCampos.doClick();
            } else {
                TelaPrincipal inicial = new TelaPrincipal(this.logado);
                inicial.setVisible(true);
                dispose();dispose();
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Cadastrar - " + ex.getMessage());
        }


    }//GEN-LAST:event_Button_CadastrarActionPerformed


    private void Button_Cadastrar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_Cadastrar1ActionPerformed
        TelaPrincipal frame = new TelaPrincipal(logado);
        frame.setVisible(true);
        dispose();
    }//GEN-LAST:event_Button_Cadastrar1ActionPerformed

    private void jButtonLimparCamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimparCamposActionPerformed
        Campo_HostNameMicro.setText("");
        Campo_NomeUser.setText("");
        Campo_SerieMicro.setText("");
        Campo_SerieMonitor.setText("");
        Campo_TomboMicro.setText("");
        Campo_TomboMonitor.setText("");
        Campo_cmtech.setText("");
        campo_Garantia.setText("");

    }//GEN-LAST:event_jButtonLimparCamposActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        Campo_HostNameMicro.setText("");
        Campo_NomeUser.setText("");
        Campo_SerieMicro.setText("");
        Campo_SerieMonitor.setText("");
        Campo_TomboMicro.setText("");
        Campo_TomboMonitor.setText("");
        Campo_cmtech.setText("");
        campo_Garantia.setText("");
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed

        dispose();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void Box_ModeloMicroItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_Box_ModeloMicroItemStateChanged

        //*********************** ComboBox Pavimento:
        try {

            if (Box_ModeloMicro.getSelectedItem().equals("Modelo do Micro")) {

                listarMarcaMicro();

            } else {

                MarcaMicro filtroMarcaMicro = new MarcaMicro();

                //*********************** ComboBox Gerencia:
                try {

                    filtroMarcaMicro.setMarca("");

                    //filtroGerencia.setPavimento(pavGer);
                    int SelecionadoModelo = Box_ModeloMicro.getSelectedIndex() - 1;
                    ModeloMicro modelo = new ModeloMicro();
                    modelo = (allModelosMicros.get(SelecionadoModelo));
                    filtroMarcaMicro.setIdMarca(modelo.getMarca().getIdMarca());

                    allMarcasMicros = Fachada.getInstancia().listarMarcaMicro(filtroMarcaMicro);

                    DefaultComboBoxModel listaCombo = new DefaultComboBoxModel();

                    listaCombo.addElement("Marca do Micro");

                    for (int i = 0; i < allMarcasMicros.size(); i++) {
                        MarcaMicro nomeCombo = new MarcaMicro();
                        nomeCombo = allMarcasMicros.get(i);
                        listaCombo.addElement(nomeCombo.getMarca());
                    }
                    Box_MarcaMicro.setModel(listaCombo);
                    Box_MarcaMicro.setSelectedIndex(1);

                } catch (Exception e) {
                    throw new Exception(e.getMessage());
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Erro - " + e.getMessage());
        }

    }//GEN-LAST:event_Box_ModeloMicroItemStateChanged

    private void Box_GerenciaUserItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_Box_GerenciaUserItemStateChanged
        //Gerência:
        Usuario userSigla = new Usuario();

        int SelecionadoGerencia = Box_GerenciaUser.getSelectedIndex() - 1;
        userSigla.setGerencia(allGerencias.get(SelecionadoGerencia));
        String descricao = userSigla.getGerencia().getGerencia();

        campoDescricao.setText("Descrição:  " + descricao);
    }//GEN-LAST:event_Box_GerenciaUserItemStateChanged

    private void Box_ModeloMonitorItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_Box_ModeloMonitorItemStateChanged

        //*********************** ComboBox Pavimento:
        try {

            if (Box_ModeloMonitor.getSelectedItem().equals("Modelo do Monitor")) {

                listarMarcaMonitor();

            } else {

                MarcaMonitor filtroMarcaMonitor = new MarcaMonitor();

                //*********************** ComboBox Gerencia:
                try {

                    filtroMarcaMonitor.setMarca("");

                    //filtroGerencia.setPavimento(pavGer);
                    int SelecionadoModelo = Box_ModeloMonitor.getSelectedIndex() - 1;
                    ModeloMonitor modelo = new ModeloMonitor();
                    modelo = (allModelosMonitores.get(SelecionadoModelo));
                    filtroMarcaMonitor.setIdMarca(modelo.getMarca().getIdMarca());

                    allMarcasMonitores = Fachada.getInstancia().listarMarcaMonitor(filtroMarcaMonitor);

                    DefaultComboBoxModel listaCombo = new DefaultComboBoxModel();

                    listaCombo.addElement("Marca do Monitor");

                    for (MarcaMonitor allMarcas : allMarcasMonitores) {
                        MarcaMonitor nomeCombo = new MarcaMonitor();
                        nomeCombo = allMarcas;
                        listaCombo.addElement(nomeCombo.getMarca());
                    }
                    Box_MarcaMonitor.setModel(listaCombo);
                    Box_MarcaMonitor.setSelectedIndex(1);

                } catch (Exception e) {
                    throw new Exception(e.getMessage());
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Erro - " + e.getMessage());
        }
    }//GEN-LAST:event_Box_ModeloMonitorItemStateChanged

    private void ButtonExibirOrganogramaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonExibirOrganogramaActionPerformed
        try {
            String urlPadrao = ("src\\resources\\organograma2015.pdf");
            File file = new File(urlPadrao);

            Desktop.getDesktop().open(file);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "Nenhum organograma encontrado no sistema!");
        }
    }//GEN-LAST:event_ButtonExibirOrganogramaActionPerformed

    private void Box_PavimentoUserItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_Box_PavimentoUserItemStateChanged

        //*********************** ComboBox Pavimento:
        try {

            if (Box_PavimentoUser.getSelectedItem().equals("Pavimento")) {

                listarGerencia();

                try {
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
                    Box_GerenciaUser.setModel(listaComboGerencia);

                } catch (Exception e) {
                    throw new Exception("Não existe nenhuma Gerência cadastrada no banco de dados " + e.getMessage());
                }

            } else {

                Gerencia filtroGerencia = new Gerencia();

                //*********************** ComboBox Gerencia:
                try {

                    filtroGerencia.setGerencia("");
                    filtroGerencia.setSiglaGerencia("");
                    //filtroGerencia.setPavimento(pavGer);
                    int SelecionadoPavimento = Box_PavimentoUser.getSelectedIndex() - 1;
                    filtroGerencia.setPavimento(allPavimentos.get(SelecionadoPavimento));

                    allGerencias = Fachada.getInstancia().listarGerencia(filtroGerencia);

                    DefaultComboBoxModel listaComboGerencia = new DefaultComboBoxModel();

                    listaComboGerencia.addElement("Gerência");

                    for (int i = 0; i < allGerencias.size(); i++) {
                        Gerencia nomeComboGerencia = new Gerencia();
                        nomeComboGerencia = allGerencias.get(i);
                        listaComboGerencia.addElement(nomeComboGerencia.getSiglaGerencia());
                    }
                    Box_GerenciaUser.setModel(listaComboGerencia);

                } catch (Exception e) {
                    throw new Exception(e.getMessage());
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Erro - " + e.getMessage());
        }

    }//GEN-LAST:event_Box_PavimentoUserItemStateChanged

    private void Box_PavimentoUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Box_PavimentoUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Box_PavimentoUserActionPerformed

    private void Campo_SerieMicroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Campo_SerieMicroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Campo_SerieMicroActionPerformed

    private void Box_OfficeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Box_OfficeMouseClicked
        try {

            if (allVersaoOffice == null) {

                VersaoOffice comboVersaoOffice = new VersaoOffice();

                comboVersaoOffice.setDescricao("");
                allVersaoOffice = Fachada.getInstancia().listarVersaoOffice(comboVersaoOffice);

                DefaultComboBoxModel listaCombo = new DefaultComboBoxModel();

                listaCombo.addElement("Versão do Pacote Office");

                for (int i = 0; i < allVersaoOffice.size(); i++) {
                    VersaoOffice nomeCombo;
                    nomeCombo = allVersaoOffice.get(i);
                    listaCombo.addElement(nomeCombo.getDescricao());
                }
                Box_Office.setModel(listaCombo);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Não existe nenhuma Versão do Pacote Office cadastrada no banco de dados.");
        }

    }//GEN-LAST:event_Box_OfficeMouseClicked

    private void Box_PavimentoUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Box_PavimentoUserMouseClicked
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
                Box_PavimentoUser.setModel(listaComboPavimento);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Não existe nenhumo Pavimento cadastrado no banco de dados.");
        }

    }//GEN-LAST:event_Box_PavimentoUserMouseClicked

    private void Box_ConfigMicroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Box_ConfigMicroMouseClicked
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
                Box_ConfigMicro.setModel(listaComboConfiguracao);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Não existe nenhuma Configuração cadastrada no banco de dados " + e.getMessage());
        }
    }//GEN-LAST:event_Box_ConfigMicroMouseClicked

    private void Box_ModeloMicroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Box_ModeloMicroMouseClicked
        try {

            if (allModelosMicros == null) {
                ModeloMicro comboModeloMicro = new ModeloMicro();

                comboModeloMicro.setModelo("");
                MarcaMicro m = new MarcaMicro();
                m.setIdMarca(0);
                m.setMarca("");
                comboModeloMicro.setMarca(m);

                allModelosMicros = Fachada.getInstancia().listarModeloMicro(comboModeloMicro);

                DefaultComboBoxModel listaComboModelosMicros = new DefaultComboBoxModel();

                listaComboModelosMicros.addElement("Modelo do Micro");

                for (int i = 0; i < allModelosMicros.size(); i++) {
                    ModeloMicro nomeComboModeloMicro;
                    nomeComboModeloMicro = allModelosMicros.get(i);
                    listaComboModelosMicros.addElement(nomeComboModeloMicro.getModelo());
                }
                Box_ModeloMicro.setModel(listaComboModelosMicros);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Não existe nenhum Modelo de Micro cadastrado no banco de dados " + e.getMessage());
        }

    }//GEN-LAST:event_Box_ModeloMicroMouseClicked

    private void Box_SOMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Box_SOMouseClicked
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
                Box_SO.setModel(listaComboOS);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Não existe nenhum Sistema Operacional cadastrado no banco de dados " + e.getMessage());
        }
    }//GEN-LAST:event_Box_SOMouseClicked

    private void Box_PlataformaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Box_PlataformaMouseClicked
        try {

            if (allPlataformas == null) {
                PlataformaMicro comboPlataformaMicro = new PlataformaMicro();

                comboPlataformaMicro.setPlataforma("");
                allPlataformas = Fachada.getInstancia().listarPlataformaMicro(comboPlataformaMicro);

                DefaultComboBoxModel listaComboPlataformaMicro = new DefaultComboBoxModel();

                listaComboPlataformaMicro.addElement("Plataforma do Micro");

                for (int i = 0; i < allPlataformas.size(); i++) {
                    PlataformaMicro nomeComboPlataformaMicro = new PlataformaMicro();
                    nomeComboPlataformaMicro = allPlataformas.get(i);
                    listaComboPlataformaMicro.addElement(nomeComboPlataformaMicro.getPlataforma());
                }
                Box_Plataforma.setModel(listaComboPlataformaMicro);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Não existe nenhuma Plataforma cadastrada no banco de dados " + e.getMessage());
        }

    }//GEN-LAST:event_Box_PlataformaMouseClicked

    private void Box_ProprietarioMicroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Box_ProprietarioMicroMouseClicked
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
                Box_ProprietarioMicro.setModel(listaComboProprietarioMicro);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Não existe nenhum Proprietario de Micros cadastrado no banco de dados " + e.getMessage());
        }

    }//GEN-LAST:event_Box_ProprietarioMicroMouseClicked

    private void Box_ModeloMonitorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Box_ModeloMonitorMouseClicked
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
                Box_ModeloMonitor.setModel(listaComboModeloMonitor);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Não existe nenhuma Modelo de Monitor cadastrado no banco de dados " + e.getMessage());
        }

    }//GEN-LAST:event_Box_ModeloMonitorMouseClicked

    private void Box_ProprietarioMonitorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Box_ProprietarioMonitorMouseClicked
        try {

            if (allProprietariosMonitores == null) {
                ProprietarioMonitor comboProprietarioMonitor = new ProprietarioMonitor();

                comboProprietarioMonitor.setProprietario("");
                allProprietariosMonitores = Fachada.getInstancia().listarProprietarioMonitor(comboProprietarioMonitor);

                DefaultComboBoxModel listaComboProprietarioMonitor = new DefaultComboBoxModel();

                listaComboProprietarioMonitor.addElement("Proprietário do Monitor");

                for (int i = 0; i < allProprietariosMonitores.size(); i++) {
                    ProprietarioMonitor nomeComboProprietarioMonitor = new ProprietarioMonitor();
                    nomeComboProprietarioMonitor = allProprietariosMonitores.get(i);
                    listaComboProprietarioMonitor.addElement(nomeComboProprietarioMonitor.getProprietario());
                }
                Box_ProprietarioMonitor.setModel(listaComboProprietarioMonitor);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Não existe nenhum Proprietario de Monitores cadastrado no banco de dados " + e.getMessage());
        }

    }//GEN-LAST:event_Box_ProprietarioMonitorMouseClicked

    private void Box_CargoUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Box_CargoUserMouseClicked
        try {

            if (allCargos == null) {
                Cargo comboCargo = new Cargo();

                comboCargo.setCargo("");
                ;
                allCargos = Fachada.getInstancia().listarCargo(comboCargo);

                DefaultComboBoxModel listaComboCargo = new DefaultComboBoxModel();

                listaComboCargo.addElement("Cargo");

                for (int i = 0; i < allCargos.size(); i++) {
                    Cargo nomeComboCargo = new Cargo();
                    nomeComboCargo = allCargos.get(i);
                    listaComboCargo.addElement(nomeComboCargo.getCargo());
                }
                Box_CargoUser.setModel(listaComboCargo);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Não existe nenhum Cargo cadastrado no banco de dados " + e.getMessage());
        }
    }//GEN-LAST:event_Box_CargoUserMouseClicked

    private void Box_GerenciaUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Box_GerenciaUserMouseClicked
        listarGerencia();
    }//GEN-LAST:event_Box_GerenciaUserMouseClicked

    private void Box_MarcaMonitorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Box_MarcaMonitorMouseClicked
        listarMarcaMonitor();
    }//GEN-LAST:event_Box_MarcaMonitorMouseClicked

    private void Box_MarcaMicroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Box_MarcaMicroMouseClicked
        listarMarcaMicro();
    }//GEN-LAST:event_Box_MarcaMicroMouseClicked

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
            java.util.logging.Logger.getLogger(CadastrarUSUARIO2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastrarUSUARIO2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastrarUSUARIO2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastrarUSUARIO2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastrarUSUARIO2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox Box_CargoUser;
    private javax.swing.JComboBox Box_ConfigMicro;
    private javax.swing.JComboBox Box_GerenciaUser;
    private javax.swing.JComboBox Box_MarcaMicro;
    private javax.swing.JComboBox Box_MarcaMonitor;
    private javax.swing.JComboBox Box_ModeloMicro;
    private javax.swing.JComboBox Box_ModeloMonitor;
    private javax.swing.JComboBox Box_Office;
    private javax.swing.JComboBox Box_PavimentoUser;
    private javax.swing.JComboBox Box_Plataforma;
    private javax.swing.JComboBox Box_ProprietarioMicro;
    private javax.swing.JComboBox Box_ProprietarioMonitor;
    private javax.swing.JComboBox Box_SO;
    private javax.swing.JButton ButtonExibirOrganograma;
    private javax.swing.JButton Button_Cadastrar;
    private javax.swing.JButton Button_Cadastrar1;
    private javax.swing.JTextField Campo_HostNameMicro;
    private javax.swing.JTextField Campo_NomeUser;
    private javax.swing.JTextField Campo_NovoTomboMicro;
    private javax.swing.JTextField Campo_NovoTomboMonitor;
    private javax.swing.JTextField Campo_SerieMicro;
    private javax.swing.JTextField Campo_SerieMonitor;
    private javax.swing.JTextField Campo_TomboMicro;
    private javax.swing.JTextField Campo_TomboMonitor;
    private javax.swing.JTextField Campo_cmtech;
    private javax.swing.JLabel campoDescricao;
    private javax.swing.JCheckBox campoPossuiTermo;
    private javax.swing.JTextField campo_Garantia;
    private javax.swing.JButton jButtonLimparCampos;
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
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    // End of variables declaration//GEN-END:variables
}
