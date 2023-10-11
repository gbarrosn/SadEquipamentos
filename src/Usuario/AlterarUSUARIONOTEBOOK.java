/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuario;

import Geral.Fachada;
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
import static Usuario.ListarUSUARIO.jButtonListarFiltros;
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
import javax.swing.JOptionPane;

/**
 *
 * @author Posseidon
 */
public class AlterarUSUARIONOTEBOOK extends javax.swing.JFrame {

    /**
     * Creates new form FormCadastrarUsuario
     */
    public AlterarUSUARIONOTEBOOK() {
        initComponents();
        setTitle("Formulário de alteração de cadastro de Usuário.");
    }

    private LoginUser logado;
    private Usuario selecionadoUser;
    private Usuario user;

    void icone() {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("src\\resources\\favicon-cor.png"));
            this.setIconImage(img);
        } catch (IOException e) {
        }
    }

    public AlterarUSUARIONOTEBOOK(Usuario selecionadoUser) {

    }

    public AlterarUSUARIONOTEBOOK(Usuario selecionadoUser, LoginUser logado) {

        icone();

        initComponents();

        setLocationRelativeTo(null);

        setTitle("Formulário de alteração de cadastro de Usuário.");

        comboBoxListagem();
        listarGerencia();
        listarMarcaMicro();

        this.logado = logado;

        textoDataAlteracao.setText("Data da última alteração: " + selecionadoUser.getDataAlteracao() + "   por: " + selecionadoUser.getUsuarioAlteracao());
        Box_ModeloMicro.setSelectedItem(selecionadoUser.getModeloMicro().getModelo());

        Box_Office.setSelectedItem(selecionadoUser.getVersao_office().getDescricao());

        //Carregando combo com dados do Usuário selecionado:    
        Campo_NomeUser.setText(selecionadoUser.getNome());
        Box_CargoUser.setSelectedItem(selecionadoUser.getCargo().getCargo());
        Box_PavimentoUser.setSelectedItem(selecionadoUser.getPavimentoUsuario().getPavimento());
        Box_GerenciaUser.setSelectedItem(selecionadoUser.getGerencia().getSiglaGerencia());
        campoDescricao.setText("Descrição: " + selecionadoUser.getGerencia().getGerencia());
        //Carregando combo com dados da Máquina do Usuário selecionado: 
        Campo_HostNameMicro.setText(selecionadoUser.getNomepc());
        Campo_TomboMicro.setText(selecionadoUser.getTombamentoMicro() + "");
        Campo_SerieMicro.setText(selecionadoUser.getSerieMicro());
        Campo_cmtech.setText(selecionadoUser.getEtiquetaCESU() + "");
        Box_Plataforma.setSelectedItem(selecionadoUser.getPlataformaMicro().getPlataforma());
        Box_ConfigMicro.setSelectedItem(selecionadoUser.getConfigMicro().getConfiguracao());
        Box_MarcaMicro.setSelectedItem(selecionadoUser.getMarcaMicro().getMarca());
        Box_ProprietarioMicro.setSelectedItem(selecionadoUser.getProprietarioMicro().getProprietario());
        Box_SO.setSelectedItem(selecionadoUser.getOsMicro().getOs());
        jCheckBox_Ativo.setSelected(!selecionadoUser.getAtivo());
        Campo_CpfUser.setText(selecionadoUser.getCpf());
        //Carregando combo com dados do Monitor do Usuário selecionado: 

        campo_Garantia.setText(selecionadoUser.getGarantia());
        //campoOBS.setText(selecionadoUser.getObs());


        //atribui valor a variável global selecionadoNota
        this.selecionadoUser = selecionadoUser;

        /*
         try {

         String urlPadrao = ("\\\\sadfs01\\GTINF\\USINF\\USINF 2015\\TERMO DE RESPONSABILIDADE\\Termos de Responsabilidade - Digitalizados\\");
         File file = new File(urlPadrao + selecionadoUser.getNome() + ".pdf");

         if (file.exists() == true) {
         checkPossuiTermo.setSelected(true);
         }
         } catch (Exception ex) {
         checkPossuiTermo.setSelected(false);
         }
         */
    }

    //ARRAYS DO COMBO BOX LISTAGEM
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
    private ArrayList<ProprietarioMonitor> allProprietariosMonitores;
    private ArrayList<VersaoOffice> allVersaoOffice;
    private ArrayList<OS> allOs;

    public void listarMarcaMicro() {

        try {
            //*********************** ComboBox MarcaMicro:
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
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        }
    }

    public void listarGerencia() {
        try {
            //*********************** ComboBox Gerencia:
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
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        }
    }

    public void comboBoxListagem() {

        try {
            //*********************** ComboBox Versão do Pacote Office:
            try {
                VersaoOffice comboVersaoOffice = new VersaoOffice();

                comboVersaoOffice.setDescricao("");
                allVersaoOffice = Fachada.getInstancia().listarVersaoOffice(comboVersaoOffice);

                DefaultComboBoxModel listaCombo = new DefaultComboBoxModel();

                listaCombo.addElement("Versão do Pacote Office");

                for (int i = 0; i < allVersaoOffice.size(); i++) {
                    VersaoOffice nomeCombo = new VersaoOffice();
                    nomeCombo = allVersaoOffice.get(i);
                    listaCombo.addElement(nomeCombo.getDescricao());
                }
                Box_Office.setModel(listaCombo);

            } catch (Exception e) {
                throw new Exception("Não existe nenhuma Versão do Pacote Office cadastrada no banco de dados.");
            }
            //*********************** ComboBox Pavimento:
            try {
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

            } catch (Exception e) {
                throw new Exception("Não existe nenhumo Pavimento cadastrado no banco de dados " + e.getMessage());
            }

            //*********************** ComboBox Configuração:
            try {
                Configuracao comboConfiguracao = new Configuracao();

                comboConfiguracao.setConfiguracao("");
                allConfiguracoes = Fachada.getInstancia().listarConfiguracao(comboConfiguracao);

                DefaultComboBoxModel listaComboConfiguracao = new DefaultComboBoxModel();

                listaComboConfiguracao.addElement("Configuração:");

                for (int i = 0; i < allConfiguracoes.size(); i++) {
                    Configuracao nomeComboConfiguracao = new Configuracao();
                    nomeComboConfiguracao = allConfiguracoes.get(i);
                    listaComboConfiguracao.addElement(nomeComboConfiguracao.getConfiguracao());
                }
                Box_ConfigMicro.setModel(listaComboConfiguracao);

            } catch (Exception e) {
                throw new Exception("Não existe nenhuma Configuração cadastrada no banco de dados " + e.getMessage());
            }

            //*********************** ComboBox ModeloMicro:
            try {
                ModeloMicro comboModeloMicro = new ModeloMicro();
                comboModeloMicro.setModelo("");
                MarcaMicro m = new MarcaMicro();
                m.setIdMarca(0);
                m.setMarca("");
                comboModeloMicro.setMarca(m);

                allModelosMicros = Fachada.getInstancia().listarModeloMicro(comboModeloMicro);
                DefaultComboBoxModel listaComboModeloMicro = new DefaultComboBoxModel();
                listaComboModeloMicro.addElement("Modelo do Micro");

                for (int i = 0; i < allModelosMicros.size(); i++) {
                    ModeloMicro nomeComboModeloMicro = new ModeloMicro();
                    nomeComboModeloMicro = allModelosMicros.get(i);
                    listaComboModeloMicro.addElement(nomeComboModeloMicro.getModelo());
                }
                Box_ModeloMicro.setModel(listaComboModeloMicro);

            } catch (Exception e) {
                throw new Exception("Não existe nenhum Modelo de Micro cadastrado no banco de dados " + e.getMessage());
            }

            //*********************** ComboBox OS:
            try {
                OS comboOS = new OS();

                comboOS.setOs("");

                allOs = Fachada.getInstancia().listarOS(comboOS);

                DefaultComboBoxModel listaComboOS = new DefaultComboBoxModel();

                listaComboOS.addElement("OS");

                for (int i = 0; i < allOs.size(); i++) {
                    OS nomeComboOS = new OS();
                    nomeComboOS = allOs.get(i);
                    listaComboOS.addElement(nomeComboOS.getOs());
                }
                Box_SO.setModel(listaComboOS);

            } catch (Exception e) {
                throw new Exception("Não existe nenhum Sistema Operacional cadastrado no banco de dados " + e.getMessage());
            }

            //*********************** ComboBox PlataformaMicro:
            try {
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

            } catch (Exception e) {
                throw new Exception("Não existe nenhuma Plataforma cadastrada no banco de dados " + e.getMessage());
            }

            //*********************** ComboBox ProprietarioMicro:
            try {
                ProprietarioMicro comboProprietarioMicro = new ProprietarioMicro();

                comboProprietarioMicro.setProprietario("");
                allProprietariosMicros = Fachada.getInstancia().listarProprietarioMicro(comboProprietarioMicro);

                DefaultComboBoxModel listaComboProprietarioMicro = new DefaultComboBoxModel();

                listaComboProprietarioMicro.addElement("Proprietario do Micro");

                for (int i = 0; i < allProprietariosMicros.size(); i++) {
                    ProprietarioMicro nomeComboProprietarioMicro = new ProprietarioMicro();
                    nomeComboProprietarioMicro = allProprietariosMicros.get(i);
                    listaComboProprietarioMicro.addElement(nomeComboProprietarioMicro.getProprietario());
                }
                Box_ProprietarioMicro.setModel(listaComboProprietarioMicro);

            } catch (Exception e) {
                throw new Exception("Não existe nenhum Proprietario de Micros cadastrado no banco de dados " + e.getMessage());
            }

            //*********************** ComboBox Cargo:
            try {
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
                Box_CargoUser.setModel(listaComboCargo);

            } catch (Exception e) {
                throw new Exception("Não existe nenhum Cargo cadastrado no banco de dados " + e.getMessage());
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

        Campo_TomboMicro = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jButtonLimparCampos = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        Button_Cadastrar1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Box_ModeloMicro = new javax.swing.JComboBox();
        Campo_HostNameMicro = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        Box_SO = new javax.swing.JComboBox();
        Box_MarcaMicro = new javax.swing.JComboBox();
        Box_ConfigMicro = new javax.swing.JComboBox();
        Box_Plataforma = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        Box_CargoUser = new javax.swing.JComboBox();
        jLabel23 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        Box_PavimentoUser = new javax.swing.JComboBox();
        Campo_NomeUser = new javax.swing.JTextField();
        Campo_cmtech = new javax.swing.JTextField();
        Box_ProprietarioMicro = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel11 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        Campo_SerieMicro = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        Button_Alterar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        campoDescricao = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        Box_Office = new javax.swing.JComboBox();
        textoDataAlteracao = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        campoExibirTermo = new javax.swing.JButton();
        checkPossuiTermo = new javax.swing.JCheckBox();
        ButtonExibirInformarObs = new javax.swing.JButton();
        campo_Garantia = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Box_GerenciaUser = new javax.swing.JComboBox();
        ButtonExibirOrganograma = new javax.swing.JButton();
        Campo_CpfUser = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jCheckBox_Ativo = new javax.swing.JCheckBox();
        ButtonMonitorExtra = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(Campo_TomboMicro, new org.netbeans.lib.awtextra.AbsoluteConstraints(406, 220, 209, -1));
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 441, 869, 2));

        jButtonLimparCampos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Icons/format_painter.png"))); // NOI18N
        jButtonLimparCampos.setText("Limpar Campos");
        jButtonLimparCampos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimparCamposActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonLimparCampos, new org.netbeans.lib.awtextra.AbsoluteConstraints(602, 449, 149, 39));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 156, 866, 2));

        Button_Cadastrar1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Button_Cadastrar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Icons/arrow_left_32.png"))); // NOI18N
        Button_Cadastrar1.setText("Voltar");
        Button_Cadastrar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_Cadastrar1ActionPerformed(evt);
            }
        });
        getContentPane().add(Button_Cadastrar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(757, 449, 118, 39));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("         Notebook:");
        jLabel6.setAlignmentX(0.5F);
        jLabel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 170, 147, 35));

        jLabel2.setText("Nome:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 62, -1, -1));

        Box_ModeloMicro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        Box_ModeloMicro.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                Box_ModeloMicroItemStateChanged(evt);
            }
        });
        getContentPane().add(Box_ModeloMicro, new org.netbeans.lib.awtextra.AbsoluteConstraints(103, 256, 241, -1));
        getContentPane().add(Campo_HostNameMicro, new org.netbeans.lib.awtextra.AbsoluteConstraints(103, 220, 239, -1));

        jLabel7.setText("Host Name:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 223, -1, -1));

        jLabel12.setText("Modelo:");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 259, -1, -1));

        Box_SO.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(Box_SO, new org.netbeans.lib.awtextra.AbsoluteConstraints(103, 328, 243, -1));

        Box_MarcaMicro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(Box_MarcaMicro, new org.netbeans.lib.awtextra.AbsoluteConstraints(406, 292, 209, -1));

        Box_ConfigMicro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(Box_ConfigMicro, new org.netbeans.lib.awtextra.AbsoluteConstraints(103, 292, 243, -1));

        Box_Plataforma.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(Box_Plataforma, new org.netbeans.lib.awtextra.AbsoluteConstraints(724, 292, 160, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("            Usuário:");
        jLabel1.setAlignmentX(0.5F);
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 6, 150, 32));

        Box_CargoUser.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(Box_CargoUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(485, 59, 175, -1));

        jLabel23.setText("CESU:");
        getContentPane().add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(627, 223, -1, -1));

        jLabel15.setText("Plataforma:");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(627, 295, -1, -1));

        Box_PavimentoUser.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        Box_PavimentoUser.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                Box_PavimentoUserItemStateChanged(evt);
            }
        });
        Box_PavimentoUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Box_PavimentoUserActionPerformed(evt);
            }
        });
        getContentPane().add(Box_PavimentoUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(117, 92, 289, -1));
        getContentPane().add(Campo_NomeUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(117, 59, 289, -1));
        getContentPane().add(Campo_cmtech, new org.netbeans.lib.awtextra.AbsoluteConstraints(724, 220, 160, -1));

        Box_ProprietarioMicro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(Box_ProprietarioMicro, new org.netbeans.lib.awtextra.AbsoluteConstraints(724, 256, 160, -1));

        jLabel10.setText("Configuração:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 295, -1, -1));

        jLabel5.setText("Pavimento:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 95, -1, -1));

        jLabel14.setText("Sistema:");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 331, 60, -1));

        jLabel4.setText("Cargo:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(412, 62, -1, -1));
        getContentPane().add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 379, 869, -1));

        jLabel11.setText("Marca:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 295, -1, -1));

        jLabel9.setText("Série:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 259, 40, -1));

        Campo_SerieMicro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Campo_SerieMicroActionPerformed(evt);
            }
        });
        getContentPane().add(Campo_SerieMicro, new org.netbeans.lib.awtextra.AbsoluteConstraints(406, 256, 209, -1));

        jLabel13.setText("Proprietário:");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(627, 259, -1, -1));

        Button_Alterar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Button_Alterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Icons/diskette_32.png"))); // NOI18N
        Button_Alterar.setText("Alterar");
        Button_Alterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_AlterarActionPerformed(evt);
            }
        });
        getContentPane().add(Button_Alterar, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 449, 125, 39));

        jLabel8.setText("Tombo:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 223, -1, -1));

        campoDescricao.setText("Descrição:");
        getContentPane().add(campoDescricao, new org.netbeans.lib.awtextra.AbsoluteConstraints(412, 126, -1, -1));

        jLabel26.setText("Office:");
        getContentPane().add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 331, -1, -1));

        Box_Office.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(Box_Office, new org.netbeans.lib.awtextra.AbsoluteConstraints(406, 328, 209, -1));

        textoDataAlteracao.setText("Data da última alteração:");
        getContentPane().add(textoDataAlteracao, new org.netbeans.lib.awtextra.AbsoluteConstraints(226, 12, -1, -1));

        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Icons/clock_32.png"))); // NOI18N
        getContentPane().add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(188, 6, -1, -1));

        campoExibirTermo.setText("Exibir Termo de Responsabilidade");
        campoExibirTermo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoExibirTermoActionPerformed(evt);
            }
        });
        getContentPane().add(campoExibirTermo, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 390, 209, 35));

        checkPossuiTermo.setText("Possui Termo?");
        getContentPane().add(checkPossuiTermo, new org.netbeans.lib.awtextra.AbsoluteConstraints(516, 400, -1, -1));

        ButtonExibirInformarObs.setText("Exibir/Registrar Observações");
        ButtonExibirInformarObs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonExibirInformarObsActionPerformed(evt);
            }
        });
        getContentPane().add(ButtonExibirInformarObs, new org.netbeans.lib.awtextra.AbsoluteConstraints(318, 394, 186, 35));
        getContentPane().add(campo_Garantia, new org.netbeans.lib.awtextra.AbsoluteConstraints(83, 399, 223, -1));

        jLabel22.setText("Garantia:");
        getContentPane().add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 402, -1, -1));

        jLabel3.setText("Gerência:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(412, 95, -1, -1));

        Box_GerenciaUser.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        Box_GerenciaUser.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                Box_GerenciaUserItemStateChanged(evt);
            }
        });
        getContentPane().add(Box_GerenciaUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(485, 92, 175, -1));

        ButtonExibirOrganograma.setText("Exibir organograma");
        ButtonExibirOrganograma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonExibirOrganogramaActionPerformed(evt);
            }
        });
        getContentPane().add(ButtonExibirOrganograma, new org.netbeans.lib.awtextra.AbsoluteConstraints(699, 89, 165, 31));
        getContentPane().add(Campo_CpfUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(699, 59, 180, -1));

        jLabel16.setText("Cpf:");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(666, 62, -1, -1));

        jCheckBox_Ativo.setText("Usuário Inativo?");
        getContentPane().add(jCheckBox_Ativo, new org.netbeans.lib.awtextra.AbsoluteConstraints(191, 176, -1, -1));

        ButtonMonitorExtra.setText("Adicionar Monitor Extra");
        ButtonMonitorExtra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonMonitorExtraActionPerformed(evt);
            }
        });
        getContentPane().add(ButtonMonitorExtra, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 330, 210, 30));

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

        jMenuItem3.setText("Menu Principal");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem4.setText("Sair");
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

    private void jButtonLimparCamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimparCamposActionPerformed
        Campo_HostNameMicro.setText("");
        Campo_NomeUser.setText("");
        Campo_SerieMicro.setText("");
        Campo_CpfUser.setText("");
        Campo_TomboMicro.setText("");
        jCheckBox_Ativo.setSelected(false);
        Campo_cmtech.setText("");
        campo_Garantia.setText("");
    }//GEN-LAST:event_jButtonLimparCamposActionPerformed

    private void Button_Cadastrar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_Cadastrar1ActionPerformed
        dispose();
    }//GEN-LAST:event_Button_Cadastrar1ActionPerformed

    private void Box_PavimentoUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Box_PavimentoUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Box_PavimentoUserActionPerformed

    private void Campo_SerieMicroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Campo_SerieMicroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Campo_SerieMicroActionPerformed

    private void Button_AlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_AlterarActionPerformed

        try {

            Usuario alterarUser = new Usuario();

            alterarUser.setId_usuario(selecionadoUser.getId_usuario());
            alterarUser.setNotebook("sim");

            //Recebendo objetos do ComboBox:
            //VERSÃO DO PACOTE OFFICE
            try {
                int SelecionadoVersaoOffice = Box_Office.getSelectedIndex() - 1;
                alterarUser.setVersao_office(allVersaoOffice.get(SelecionadoVersaoOffice));
            } catch (Exception e) {
                throw new Exception("Selecione a versão do Pacote do Office usada pelo Usuário.");
            }
            //Cargo:
            try {
                int SelecionadoCargo = Box_CargoUser.getSelectedIndex() - 1;
                alterarUser.setCargo(allCargos.get(SelecionadoCargo));
            } catch (Exception e) {
                throw new Exception("Selecione um Cargo para o Usuário.");
            }
            //Gerência:
            try {
                int SelecionadoGerencia = Box_GerenciaUser.getSelectedIndex() - 1;
                alterarUser.setGerencia(allGerencias.get(SelecionadoGerencia));
            } catch (Exception e) {
                throw new Exception("Selecione uma Gerência para o Usuário.");
            }
            //Pavimento:
            try {
                int SelecionadoPavimento = Box_PavimentoUser.getSelectedIndex() - 1;
                alterarUser.setPavimentoUsuario(allPavimentos.get(SelecionadoPavimento));
            } catch (Exception e) {
                throw new Exception("Selecione um Pavimento para o Usuário");
            }
            //Plataforma:
            try {
                int SelecionadoPlataforma = Box_Plataforma.getSelectedIndex() - 1;
                alterarUser.setPlataformaMicro(allPlataformas.get(SelecionadoPlataforma));
            } catch (Exception e) {
                throw new Exception("Selecione uma Plataforma para o Microcomputador");
            }
            //Modelo Micro:
            try {
                int SelecionadoModeloMicro = Box_ModeloMicro.getSelectedIndex() - 1;
                alterarUser.setModeloMicro(allModelosMicros.get(SelecionadoModeloMicro));
            } catch (Exception e) {
                throw new Exception("Selecione um Modelo para o Microcomputador");
            }

            //Configuração:
            try {
                int SelecionadoConfiguracao = Box_ConfigMicro.getSelectedIndex() - 1;
                alterarUser.setConfigMicro(allConfiguracoes.get(SelecionadoConfiguracao));
            } catch (Exception e) {
                throw new Exception("Selecione uma Configuração para o Microcomputador");
            }

            //Marca Micro:
            try {
                int SelecionadoMarcaMicro = Box_MarcaMicro.getSelectedIndex() - 1;
                alterarUser.setMarcaMicro(allMarcasMicros.get(SelecionadoMarcaMicro));
            } catch (Exception e) {
                throw new Exception("Selecione uma Marca para o Microcomputador");
            }

            //Proprietário Micro:
            try {
                int SelecionadoProprietarioMicro = Box_ProprietarioMicro.getSelectedIndex() - 1;
                alterarUser.setProprietarioMicro(allProprietariosMicros.get(SelecionadoProprietarioMicro));
            } catch (Exception e) {
                throw new Exception("Selecione um Proprietário para o Microcomputador");
            }

            //Sistema:
            try {
                int SelecionadoOs = Box_SO.getSelectedIndex() - 1;
                alterarUser.setOsMicro(allOs.get(SelecionadoOs));
            } catch (Exception e) {
                throw new Exception("Selecione uma Sistema Operacional para o Microcomputador");
            }

            //Proprietário Monitor:
            try {
                ProprietarioMonitor novoprop = new ProprietarioMonitor();
                novoprop.setIdProprietario(5);
                alterarUser.setProprietarioMonitor(novoprop);
            } catch (Exception e) {
                throw new Exception("Proprietário monitor - ERRO");
            }
                
                
            //Modelo Monitor:
            try {
                ModeloMonitor novomod = new ModeloMonitor();
                novomod.setIdModelo(12);
                alterarUser.setModeloMonitor(novomod);
            } catch (Exception e) {
                throw new Exception("Modelo monitor - ERRO");
            }

            //Marca Monitor:
            try{
            MarcaMonitor novomar = new MarcaMonitor();
            novomar.setIdMarca(6);
            alterarUser.setMarcaMonitor(novomar);
            } catch (Exception e ) {
                throw new Exception("Marca monitor - ERRO");
            }

            //Recebendo campos Strings:
            alterarUser.setNome(Campo_NomeUser.getText().toUpperCase());

            alterarUser.setNomepc(Campo_HostNameMicro.getText().toUpperCase());

            alterarUser.setSerieMicro(Campo_SerieMicro.getText().toUpperCase());

            alterarUser.setGarantia(campo_Garantia.getText().toUpperCase());

            alterarUser.setTermo_responsabilidade(checkPossuiTermo.isSelected());

            alterarUser.setCpf(Campo_CpfUser.getText());

            alterarUser.setAtivo(!jCheckBox_Ativo.isSelected());
            //String campoGarantia = campo_Garantia.getText().toUpperCase();
            alterarUser.setGarantia(campo_Garantia.getText().toUpperCase());

            //String campoObs = campoOBS.getText();
            //alterarUser.setObs(campoObs);
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            Date date = new Date();
            String dataAlt;
            dataAlt = dateFormat.format(date);
            //String nomeUsuarioPC = System.getProperty("user.name");
            alterarUser.setDataAlteracao(dataAlt);

            alterarUser.setUsuarioAlteracao(this.logado.getLogin());

            //********************************** Recebendo e Tratando excessão de números inteiros.
            //Tombo Micro:
            try {
                String tomboMicroPC = Campo_TomboMicro.getText();
                long tomboMicroPCIntParse = Long.parseLong(tomboMicroPC);
                alterarUser.setTombamentoMicro(tomboMicroPCIntParse);
            } catch (NumberFormatException e) {
                if (Campo_TomboMicro.getText().trim().equals("") == true) {
                    throw new Exception("Preencha o campo Tombamento do Micro!(Obrigatório).");
                } else {
                    throw new Exception("Erro - Campo Tombamento do Micro: Preencha apenas com números.");
                }
            }

            //Etiqueta CMTECH:
            try {
                String etiqueta = Campo_cmtech.getText();
                int etiquetaIntParse = Integer.parseInt(etiqueta);
                alterarUser.setEtiquetaCESU(etiquetaIntParse);
            } catch (NumberFormatException e) {
                if (Campo_cmtech.getText().trim().equals("") == true) {
                    throw new Exception("Preencha o campo Etiqueta CESU!(Obrigatório).");
                } else {
                    throw new Exception("Erro - Campo Etiqueta CESU: Preencha apenas com números.");
                }
            }

            Fachada.getInstancia().alterarUsuario(alterarUser, selecionadoUser);
            JOptionPane.showMessageDialog(rootPane, "Usuário: " + alterarUser.getNome() + " alterado com sucesso!");

            jButtonListarFiltros.doClick();
            dispose();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar - " + ex.getMessage());
        }
    }//GEN-LAST:event_Button_AlterarActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        TelaPrincipal principal = new TelaPrincipal(this.logado);
        principal.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        Campo_HostNameMicro.setText("");
        Campo_NomeUser.setText("");
        Campo_SerieMicro.setText("");
        Campo_CpfUser.setText("");
        Campo_TomboMicro.setText("");
        jCheckBox_Ativo.setSelected(false);
        Campo_cmtech.setText("");
        campo_Garantia.setText("");
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        ListarUSUARIO listar = new ListarUSUARIO(this.logado);
        listar.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

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

    private void ButtonExibirInformarObsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonExibirInformarObsActionPerformed
        this.user = selecionadoUser;
        ObsHistorico exibirInformarObs = new ObsHistorico(user, this.logado);
        exibirInformarObs.setVisible(true);
    }//GEN-LAST:event_ButtonExibirInformarObsActionPerformed

    private void Box_GerenciaUserItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_Box_GerenciaUserItemStateChanged
        //Gerência:
        Usuario userSigla = new Usuario();

        int SelecionadoGerencia = Box_GerenciaUser.getSelectedIndex() - 1;
        userSigla.setGerencia(allGerencias.get(SelecionadoGerencia));
        String descricao = userSigla.getGerencia().getGerencia();

        campoDescricao.setText("Descrição:  " + descricao);
    }//GEN-LAST:event_Box_GerenciaUserItemStateChanged

    private void ButtonExibirOrganogramaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonExibirOrganogramaActionPerformed
        try {
            String urlPadrao = ("src\\resources\\organograma2015.pdf");
            File file = new File(urlPadrao);

            Desktop.getDesktop().open(file);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "Nenhum organograma encontrado no sistema!");
        }
    }//GEN-LAST:event_ButtonExibirOrganogramaActionPerformed

    private void campoExibirTermoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoExibirTermoActionPerformed
        try {
            String urlPadrao = ("\\\\sadfs01\\GTINF\\USINF\\USINF 2015\\TERMO DE RESPONSABILIDADE\\Termos de Responsabilidade - Digitalizados\\");
            File file = new File(urlPadrao + this.selecionadoUser.getNome() + ".pdf");

            Desktop.getDesktop().open(file);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "Nenhum Termo encontrado para o usuário de nome: " + this.selecionadoUser.getNome());
        }
    }//GEN-LAST:event_campoExibirTermoActionPerformed

    private void ButtonMonitorExtraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonMonitorExtraActionPerformed
        // TODO add your handling code here:
        AlterarUSUARIO1 monitorExtra = new AlterarUSUARIO1(selecionadoUser, logado);
        monitorExtra.setVisible(true);
        dispose();
    }//GEN-LAST:event_ButtonMonitorExtraActionPerformed

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
            java.util.logging.Logger.getLogger(AlterarUSUARIONOTEBOOK.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AlterarUSUARIONOTEBOOK.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AlterarUSUARIONOTEBOOK.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AlterarUSUARIONOTEBOOK.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AlterarUSUARIONOTEBOOK().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox Box_CargoUser;
    private javax.swing.JComboBox Box_ConfigMicro;
    private javax.swing.JComboBox Box_GerenciaUser;
    private javax.swing.JComboBox Box_MarcaMicro;
    private javax.swing.JComboBox Box_ModeloMicro;
    private javax.swing.JComboBox Box_Office;
    private javax.swing.JComboBox Box_PavimentoUser;
    private javax.swing.JComboBox Box_Plataforma;
    private javax.swing.JComboBox Box_ProprietarioMicro;
    private javax.swing.JComboBox Box_SO;
    private javax.swing.JButton ButtonExibirInformarObs;
    private javax.swing.JButton ButtonExibirOrganograma;
    private javax.swing.JButton ButtonMonitorExtra;
    private javax.swing.JButton Button_Alterar;
    private javax.swing.JButton Button_Cadastrar1;
    private javax.swing.JTextField Campo_CpfUser;
    private javax.swing.JTextField Campo_HostNameMicro;
    private javax.swing.JTextField Campo_NomeUser;
    private javax.swing.JTextField Campo_SerieMicro;
    private javax.swing.JTextField Campo_TomboMicro;
    private javax.swing.JTextField Campo_cmtech;
    private javax.swing.JLabel campoDescricao;
    private javax.swing.JButton campoExibirTermo;
    private javax.swing.JTextField campo_Garantia;
    private javax.swing.JCheckBox checkPossuiTermo;
    private javax.swing.JButton jButtonLimparCampos;
    private javax.swing.JCheckBox jCheckBox_Ativo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JLabel textoDataAlteracao;
    // End of variables declaration//GEN-END:variables
}
