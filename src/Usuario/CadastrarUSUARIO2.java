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
        Campo_SerieMonitor = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        campoDescricao = new javax.swing.JLabel();
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
        Campo_CpfUser = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        ButtonRemoverMonitorExtra = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("            Usuário:");
        jLabel1.setAlignmentX(0.5F);
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 6, 150, 29));

        jLabel22.setText("Garantia:");
        getContentPane().add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 516, -1, -1));
        getContentPane().add(campo_Garantia, new org.netbeans.lib.awtextra.AbsoluteConstraints(122, 513, 263, -1));

        Button_Cadastrar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Button_Cadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Icons/diskette_32.png"))); // NOI18N
        Button_Cadastrar.setText("Concluir");
        Button_Cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_CadastrarActionPerformed(evt);
            }
        });
        getContentPane().add(Button_Cadastrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 558, 125, -1));
        getContentPane().add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 502, 925, 10));
        getContentPane().add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 164, 1, 0));

        Button_Cadastrar1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Button_Cadastrar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Icons/arrow_left_32.png"))); // NOI18N
        Button_Cadastrar1.setText("Voltar");
        Button_Cadastrar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_Cadastrar1ActionPerformed(evt);
            }
        });
        getContentPane().add(Button_Cadastrar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(839, 558, 112, -1));

        jButtonLimparCampos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Icons/format_painter.png"))); // NOI18N
        jButtonLimparCampos.setText("Limpar Campos");
        jButtonLimparCampos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimparCamposActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonLimparCampos, new org.netbeans.lib.awtextra.AbsoluteConstraints(656, 558, -1, -1));
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 549, 885, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("      Notebook:");
        jLabel6.setAlignmentX(0.5F);
        jLabel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 167, 159, 35));

        jLabel2.setText("Nome:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 50, -1, -1));

        jLabel3.setText("Gerência:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(368, 89, -1, -1));

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
        getContentPane().add(Box_ModeloMicro, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 253, 241, -1));

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
        getContentPane().add(Box_GerenciaUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(445, 86, 190, -1));

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setText("            Monitor:");
        jLabel16.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 388, 150, 33));
        getContentPane().add(Campo_HostNameMicro, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 217, 239, -1));

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
        getContentPane().add(Box_ModeloMonitor, new org.netbeans.lib.awtextra.AbsoluteConstraints(116, 467, 266, -1));
        getContentPane().add(Campo_SerieMonitor, new org.netbeans.lib.awtextra.AbsoluteConstraints(114, 435, 266, -1));

        jLabel7.setText("Host Name:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 220, -1, -1));

        jLabel8.setText("Tombo:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(399, 220, -1, -1));

        campoDescricao.setText("Descrição:");
        getContentPane().add(campoDescricao, new org.netbeans.lib.awtextra.AbsoluteConstraints(368, 120, -1, -1));

        ButtonExibirOrganograma.setText("Exibir organograma");
        ButtonExibirOrganograma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonExibirOrganogramaActionPerformed(evt);
            }
        });
        getContentPane().add(ButtonExibirOrganograma, new org.netbeans.lib.awtextra.AbsoluteConstraints(685, 83, 170, 31));

        jLabel26.setText("Office:");
        getContentPane().add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(399, 331, -1, -1));

        Box_Office.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Versão do Pacote Office" }));
        Box_Office.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Box_OfficeMouseClicked(evt);
            }
        });
        getContentPane().add(Box_Office, new org.netbeans.lib.awtextra.AbsoluteConstraints(455, 328, 220, -1));

        jLabel12.setText("Modelo:");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 256, -1, -1));

        Box_SO.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Sistema Operacional" }));
        Box_SO.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Box_SOMouseClicked(evt);
            }
        });
        getContentPane().add(Box_SO, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 328, 243, -1));

        Box_MarcaMicro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Marca do Micro" }));
        Box_MarcaMicro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Box_MarcaMicroMouseClicked(evt);
            }
        });
        getContentPane().add(Box_MarcaMicro, new org.netbeans.lib.awtextra.AbsoluteConstraints(455, 289, 220, -1));

        Box_ConfigMicro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Configuração" }));
        Box_ConfigMicro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Box_ConfigMicroMouseClicked(evt);
            }
        });
        getContentPane().add(Box_ConfigMicro, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 289, 243, -1));

        jLabel18.setText("Série:");
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 439, -1, 20));

        Box_ProprietarioMonitor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Proprietário do Monitor" }));
        Box_ProprietarioMonitor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Box_ProprietarioMonitorMouseClicked(evt);
            }
        });
        getContentPane().add(Box_ProprietarioMonitor, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 467, 149, -1));

        jLabel17.setText("Tombo:");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(401, 438, -1, -1));

        Box_Plataforma.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Plataforma do Micro" }));
        Box_Plataforma.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Box_PlataformaMouseClicked(evt);
            }
        });
        Box_Plataforma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Box_PlataformaActionPerformed(evt);
            }
        });
        getContentPane().add(Box_Plataforma, new org.netbeans.lib.awtextra.AbsoluteConstraints(768, 217, 163, -1));

        Box_CargoUser.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Cargo" }));
        Box_CargoUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Box_CargoUserMouseClicked(evt);
            }
        });
        getContentPane().add(Box_CargoUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(445, 47, 190, -1));

        jLabel23.setText("CESU:");
        getContentPane().add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(687, 256, -1, -1));

        jLabel15.setText("Plataforma:");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(687, 220, -1, -1));

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
        getContentPane().add(Box_PavimentoUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 86, 220, -1));
        getContentPane().add(Campo_NomeUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 47, 220, -1));
        getContentPane().add(Campo_cmtech, new org.netbeans.lib.awtextra.AbsoluteConstraints(768, 253, 163, -1));

        Box_ProprietarioMicro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Proprietário do Micro" }));
        Box_ProprietarioMicro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Box_ProprietarioMicroMouseClicked(evt);
            }
        });
        getContentPane().add(Box_ProprietarioMicro, new org.netbeans.lib.awtextra.AbsoluteConstraints(772, 289, 163, -1));

        jLabel10.setText("Configuração:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 292, -1, -1));

        jLabel5.setText("Pavimento:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 89, -1, -1));
        getContentPane().add(Campo_TomboMonitor, new org.netbeans.lib.awtextra.AbsoluteConstraints(457, 432, 232, -1));
        getContentPane().add(Campo_TomboMicro, new org.netbeans.lib.awtextra.AbsoluteConstraints(455, 217, 220, -1));

        jLabel19.setText("Modelo:");
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 470, -1, -1));

        Box_MarcaMonitor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Marca do Monitor" }));
        Box_MarcaMonitor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Box_MarcaMonitorMouseClicked(evt);
            }
        });
        getContentPane().add(Box_MarcaMonitor, new org.netbeans.lib.awtextra.AbsoluteConstraints(459, 467, 232, -1));

        jLabel14.setText("Sistema:");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 331, 60, -1));

        jLabel4.setText("Cpf:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(645, 50, 30, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 153, 879, 2));
        getContentPane().add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 374, 879, 2));

        jLabel11.setText("Marca:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(399, 292, -1, -1));

        jLabel20.setText("Marca:");
        getContentPane().add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(403, 473, -1, -1));

        jLabel9.setText("Série:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(399, 256, 50, -1));

        jLabel21.setText("Proprietário:");
        getContentPane().add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(701, 470, -1, -1));

        Campo_SerieMicro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Campo_SerieMicroActionPerformed(evt);
            }
        });
        getContentPane().add(Campo_SerieMicro, new org.netbeans.lib.awtextra.AbsoluteConstraints(455, 253, 220, -1));

        jLabel13.setText("Proprietário:");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(687, 292, -1, -1));

        campoPossuiTermo.setText("Possui Termo?");
        getContentPane().add(campoPossuiTermo, new org.netbeans.lib.awtextra.AbsoluteConstraints(403, 514, -1, -1));
        getContentPane().add(Campo_CpfUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(685, 47, 220, -1));

        jLabel24.setText("Cargo:");
        getContentPane().add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(368, 50, -1, -1));

        ButtonRemoverMonitorExtra.setText("Remover Monitor Extra");
        ButtonRemoverMonitorExtra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonRemoverMonitorExtraActionPerformed(evt);
            }
        });
        getContentPane().add(ButtonRemoverMonitorExtra, new org.netbeans.lib.awtextra.AbsoluteConstraints(725, 325, 210, 31));

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

    private void ButtonRemoverMonitorExtraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonRemoverMonitorExtraActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_ButtonRemoverMonitorExtraActionPerformed

    private void Box_PlataformaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Box_PlataformaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Box_PlataformaActionPerformed

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
    private javax.swing.JButton ButtonRemoverMonitorExtra;
    private javax.swing.JButton Button_Cadastrar;
    private javax.swing.JButton Button_Cadastrar1;
    private javax.swing.JTextField Campo_CpfUser;
    private javax.swing.JTextField Campo_HostNameMicro;
    private javax.swing.JTextField Campo_NomeUser;
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
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel26;
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
