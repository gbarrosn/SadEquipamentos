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
import Versao_Office.VersaoOffice;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static Usuario.ListarUSUARIO.jButtonListarFiltros;

/**
 *
 * @author Posseidon
 */
public class AlterarUSUARIONOTEBOOK1 extends javax.swing.JFrame {

    /**
     * Creates new form FormCadastrarUsuario
     */
    public AlterarUSUARIONOTEBOOK1() {
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

    public AlterarUSUARIONOTEBOOK1(Usuario selecionadoUser) {

    }

    public AlterarUSUARIONOTEBOOK1(Usuario selecionadoUser, LoginUser logado) {

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
/*
        Box_MarcaMonitor.setSelectedItem(selecionadoUser.getMarcaMonitor().getMarca());
        Box_ModeloMonitor.setSelectedItem(selecionadoUser.getModeloMonitor().getModelo());
        Campo_SerieMonitor.setText(selecionadoUser.getSerieMonitor());
        Campo_TomboMonitor.setText(selecionadoUser.getTombamentoMonitor() + "");
        Box_ProprietarioMonitor.setSelectedItem(selecionadoUser.getProprietarioMonitor().getProprietario());
        */
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
        ButtonRemoverMonitorExtra = new javax.swing.JButton();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel17 = new javax.swing.JLabel();
        Box_ModeloMonitor = new javax.swing.JComboBox();
        Campo_SerieMonitor = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        Box_ProprietarioMonitor = new javax.swing.JComboBox();
        jLabel19 = new javax.swing.JLabel();
        Campo_TomboMonitor = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        Box_MarcaMonitor = new javax.swing.JComboBox();
        jLabel21 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jButtonLimparCampos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Icons/format_painter.png"))); // NOI18N
        jButtonLimparCampos.setText("Limpar Campos");
        jButtonLimparCampos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimparCamposActionPerformed(evt);
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

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("         Notebook:");
        jLabel6.setAlignmentX(0.5F);
        jLabel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("Nome:");

        Box_ModeloMicro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        Box_ModeloMicro.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                Box_ModeloMicroItemStateChanged(evt);
            }
        });

        jLabel7.setText("Host Name:");

        jLabel12.setText("Modelo:");

        Box_SO.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        Box_MarcaMicro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        Box_ConfigMicro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        Box_Plataforma.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("            Usuário:");
        jLabel1.setAlignmentX(0.5F);
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        Box_CargoUser.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel23.setText("CESU:");

        jLabel15.setText("Plataforma:");

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

        Box_ProprietarioMicro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel10.setText("Configuração:");

        jLabel5.setText("Pavimento:");

        jLabel14.setText("Sistema:");

        jLabel4.setText("Cargo:");

        jLabel11.setText("Marca:");

        jLabel9.setText("Série:");

        Campo_SerieMicro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Campo_SerieMicroActionPerformed(evt);
            }
        });

        jLabel13.setText("Proprietário:");

        Button_Alterar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Button_Alterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Icons/diskette_32.png"))); // NOI18N
        Button_Alterar.setText("Alterar");
        Button_Alterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_AlterarActionPerformed(evt);
            }
        });

        jLabel8.setText("Tombo:");

        campoDescricao.setText("Descrição:");

        jLabel26.setText("Office:");

        Box_Office.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        textoDataAlteracao.setText("Data da última alteração:");

        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Icons/clock_32.png"))); // NOI18N

        campoExibirTermo.setText("Exibir Termo de Responsabilidade");
        campoExibirTermo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoExibirTermoActionPerformed(evt);
            }
        });

        checkPossuiTermo.setText("Possui Termo?");

        ButtonExibirInformarObs.setText("Exibir/Registrar Observações");
        ButtonExibirInformarObs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonExibirInformarObsActionPerformed(evt);
            }
        });

        jLabel22.setText("Garantia:");

        jLabel3.setText("Gerência:");

        Box_GerenciaUser.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        Box_GerenciaUser.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                Box_GerenciaUserItemStateChanged(evt);
            }
        });

        ButtonExibirOrganograma.setText("Exibir organograma");
        ButtonExibirOrganograma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonExibirOrganogramaActionPerformed(evt);
            }
        });

        jLabel16.setText("Cpf:");

        jCheckBox_Ativo.setText("Usuário Inativo?");

        ButtonRemoverMonitorExtra.setText("Remover Monitor Extra");
        ButtonRemoverMonitorExtra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonRemoverMonitorExtraActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setText("        Monitor:");
        jLabel17.setBorder(javax.swing.BorderFactory.createEtchedBorder());

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
        Box_ModeloMonitor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Box_ModeloMonitorActionPerformed(evt);
            }
        });

        jLabel18.setText("Série:");

        Box_ProprietarioMonitor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Proprietário do Monitor" }));
        Box_ProprietarioMonitor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Box_ProprietarioMonitorMouseClicked(evt);
            }
        });

        jLabel19.setText("Tombo:");

        jLabel20.setText("Modelo:");

        Box_MarcaMonitor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Marca do Monitor" }));
        Box_MarcaMonitor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Box_MarcaMonitorMouseClicked(evt);
            }
        });

        jLabel21.setText("Marca:");

        jLabel25.setText("Proprietário:");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18)
                            .addComponent(jLabel20)
                            .addComponent(jLabel25))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Box_ModeloMonitor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Campo_SerieMonitor)
                            .addComponent(Box_ProprietarioMonitor, 0, 210, Short.MAX_VALUE))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19)
                            .addComponent(jLabel21))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Box_MarcaMonitor, 0, 230, Short.MAX_VALUE)
                            .addComponent(Campo_TomboMonitor)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jLabel24)
                        .addGap(6, 6, 6)
                        .addComponent(textoDataAlteracao))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel2)
                        .addGap(42, 42, 42)
                        .addComponent(Campo_NomeUser, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jLabel4)
                        .addGap(29, 29, 29)
                        .addComponent(Box_CargoUser, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jLabel16)
                        .addGap(6, 6, 6)
                        .addComponent(Campo_CpfUser, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel5)
                        .addGap(12, 12, 12)
                        .addComponent(Box_PavimentoUser, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jLabel3)
                        .addGap(10, 10, 10)
                        .addComponent(Box_GerenciaUser, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(ButtonExibirOrganograma, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(412, 412, 412)
                        .addComponent(campoDescricao))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 866, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jCheckBox_Ativo))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel7)
                        .addGap(20, 20, 20)
                        .addComponent(Campo_HostNameMicro, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(jLabel8)
                        .addGap(6, 6, 6)
                        .addComponent(Campo_TomboMicro, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel23)
                        .addGap(52, 52, 52)
                        .addComponent(Campo_cmtech, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel12)
                        .addGap(47, 47, 47)
                        .addComponent(Box_ModeloMicro, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(Campo_SerieMicro, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel13)
                        .addGap(18, 18, 18)
                        .addComponent(Box_ProprietarioMicro, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel10)
                        .addGap(6, 6, 6)
                        .addComponent(Box_ConfigMicro, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jLabel11)
                        .addGap(12, 12, 12)
                        .addComponent(Box_MarcaMicro, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel15)
                        .addGap(22, 22, 22)
                        .addComponent(Box_Plataforma, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(Box_SO, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jLabel26)
                        .addGap(13, 13, 13)
                        .addComponent(Box_Office, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(ButtonRemoverMonitorExtra, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 869, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 869, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel22)
                        .addGap(21, 21, 21)
                        .addComponent(campo_Garantia, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(ButtonExibirInformarObs, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(checkPossuiTermo)
                        .addGap(7, 7, 7)
                        .addComponent(campoExibirTermo, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 869, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(Button_Alterar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(453, 453, 453)
                        .addComponent(jButtonLimparCampos)
                        .addGap(1, 1, 1)
                        .addComponent(Button_Cadastrar1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(8, 8, 8))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(textoDataAlteracao)))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Campo_NomeUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Box_CargoUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Campo_CpfUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel16))))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(Box_PavimentoUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(Box_GerenciaUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(ButtonExibirOrganograma, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addComponent(campoDescricao)
                .addGap(12, 12, 12)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jCheckBox_Ativo)))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Campo_HostNameMicro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Campo_TomboMicro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Campo_cmtech, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel23))))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Box_ModeloMicro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Campo_SerieMicro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Box_ProprietarioMicro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel9)
                            .addComponent(jLabel13))))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Box_ConfigMicro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Box_MarcaMicro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Box_Plataforma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jLabel15))))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel14))
                    .addComponent(Box_SO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel26))
                    .addComponent(Box_Office, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(ButtonRemoverMonitorExtra, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jLabel17)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(Campo_SerieMonitor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19)
                    .addComponent(Campo_TomboMonitor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(Box_ModeloMonitor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20)
                    .addComponent(Box_MarcaMonitor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(Box_ProprietarioMonitor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25))
                .addGap(15, 15, 15)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(campoExibirTermo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkPossuiTermo)
                    .addComponent(ButtonExibirInformarObs, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campo_Garantia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(Button_Alterar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonLimparCampos, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Button_Cadastrar1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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

    private void ButtonRemoverMonitorExtraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonRemoverMonitorExtraActionPerformed
        // TODO add your handling code here:
        //TODO isso é gambiarra, tem que implementar algum campo que informe se tem monitor ou não e daí fazer a remoção

        Usuario userSemMonitorExtra = new Usuario();
        userSemMonitorExtra = selecionadoUser.criarCopia();

        ModeloMonitor modeloMonitor = new ModeloMonitor();
        modeloMonitor.setIdModelo(31);

        ProprietarioMonitor proprietarioMonitor = new ProprietarioMonitor();
        proprietarioMonitor.setIdProprietario(7);

        MarcaMonitor marcaMonitor = new MarcaMonitor();
        marcaMonitor.setIdMarca(8);

        userSemMonitorExtra.setMarcaMonitor(marcaMonitor);
        userSemMonitorExtra.setModeloMonitor(modeloMonitor);
        userSemMonitorExtra.setProprietarioMonitor(proprietarioMonitor);
        userSemMonitorExtra.setSerieMonitor("");
        userSemMonitorExtra.setTombamentoMonitor(1);

        try {
            Fachada.getInstancia().alterarUsuario(userSemMonitorExtra, selecionadoUser);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        JOptionPane.showMessageDialog(rootPane, "Monitor extra removido com sucesso!");

        AlterarUSUARIONOTEBOOK alterar = new AlterarUSUARIONOTEBOOK(selecionadoUser, this.logado);
        alterar.setVisible(true);
        dispose();
    }//GEN-LAST:event_ButtonRemoverMonitorExtraActionPerformed

    private void Box_ModeloMonitorItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_Box_ModeloMonitorItemStateChanged
        try {
            if (Box_ModeloMonitor.getSelectedItem().equals("Modelo do Monitor")) {
                listarMarcaMonitor();
            } else {
                MarcaMonitor filtroMarcaMonitor = new MarcaMonitor();
                try {
                    filtroMarcaMonitor.setMarca("");
                    int SelecionadoModelo = Box_ModeloMonitor.getSelectedIndex() - 1;
                    ModeloMonitor modelo = new ModeloMonitor();
                    modelo = (allModelosMonitores.get(SelecionadoModelo));
                    filtroMarcaMonitor.setIdMarca(modelo.getMarca().getIdMarca());
                    allMarcasMonitores = Fachada.getInstancia().listarMarcaMonitor(filtroMarcaMonitor);
                    DefaultComboBoxModel listaCombo = new DefaultComboBoxModel();
                    listaCombo.addElement("Marca do Monitor");
                    for (int i = 0; i < allMarcasMonitores.size(); i++) {
                        MarcaMonitor nomeCombo = new MarcaMonitor();
                        nomeCombo = allMarcasMonitores.get(i);
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

    private void listarMarcaMonitor() {
        try {
            //*********************** ComboBox MarcaMonitor:
            try {
                MarcaMonitor comboMarcaMonitor = new MarcaMonitor();

                comboMarcaMonitor.setMarca("");
                allMarcasMonitores = Fachada.getInstancia().listarMarcaMonitor(comboMarcaMonitor);

                DefaultComboBoxModel listaComboMarcasMonitores = new DefaultComboBoxModel();

                listaComboMarcasMonitores.addElement("Marca do Monitor");

                for (int i = 0; i < allMarcasMonitores.size(); i++) {
                    MarcaMonitor nomeComboMarcaMonitor = new MarcaMonitor();
                    nomeComboMarcaMonitor = allMarcasMonitores.get(i);
                    listaComboMarcasMonitores.addElement(nomeComboMarcaMonitor.getMarca());
                }
                Box_MarcaMonitor.setModel(listaComboMarcasMonitores);

            } catch (Exception e) {
                throw new Exception("Não existe nenhuma Marca de Monitor cadastrada no banco de dados " + e.getMessage());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        }
    }

    private void Box_ModeloMonitorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Box_ModeloMonitorMouseClicked
        populateModeloMonitorComboBox();
    }//GEN-LAST:event_Box_ModeloMonitorMouseClicked

    private void populateModeloMonitorComboBox() {
        try {
            //*********************** ComboBox ModeloMonitor:
            try {
                ModeloMonitor comboModeloMonitor = new ModeloMonitor();

                comboModeloMonitor.setModelo("");
                allModelosMonitores = Fachada.getInstancia().listarModeloMonitor(comboModeloMonitor);

                DefaultComboBoxModel listaComboModelosMonitores = new DefaultComboBoxModel();

                listaComboModelosMonitores.addElement("Modelo do Monitor");

                for (int i = 0; i < allModelosMonitores.size(); i++) {
                    ModeloMonitor nomeComboModeloMonitor = new ModeloMonitor();
                    nomeComboModeloMonitor = allModelosMonitores.get(i);
                    listaComboModelosMonitores.addElement(nomeComboModeloMonitor.getModelo());
                }
                Box_ModeloMonitor.setModel(listaComboModelosMonitores);

            } catch (Exception e) {
                throw new Exception("Não existe nenhum Modelo de Monitor cadastrado no banco de dados " + e.getMessage());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        }
    }

    private void Box_ModeloMonitorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Box_ModeloMonitorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Box_ModeloMonitorActionPerformed

    private void Box_ProprietarioMonitorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Box_ProprietarioMonitorMouseClicked
        populateProprietarioMonitorComboBox();
    }//GEN-LAST:event_Box_ProprietarioMonitorMouseClicked

    private void populateProprietarioMonitorComboBox() {
        try {
            //*********************** ComboBox ProprietarioMonitor:
            try {
                ProprietarioMonitor comboProprietarioMonitor = new ProprietarioMonitor();

                comboProprietarioMonitor.setProprietario("");
                allProprietariosMonitores = Fachada.getInstancia().listarProprietarioMonitor(comboProprietarioMonitor);

                DefaultComboBoxModel listaComboProprietariosMonitores = new DefaultComboBoxModel();

                listaComboProprietariosMonitores.addElement("Proprietário do Monitor");

                for (int i = 0; i < allProprietariosMonitores.size(); i++) {
                    ProprietarioMonitor nomeComboProprietarioMonitor = new ProprietarioMonitor();
                    nomeComboProprietarioMonitor = allProprietariosMonitores.get(i);
                    listaComboProprietariosMonitores.addElement(nomeComboProprietarioMonitor.getProprietario());
                }
                Box_ProprietarioMonitor.setModel(listaComboProprietariosMonitores);

            } catch (Exception e) {
                throw new Exception("Não existe nenhum Proprietário de Monitor cadastrado no banco de dados " + e.getMessage());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        }
    }

    private void Box_MarcaMonitorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Box_MarcaMonitorMouseClicked
        listarMarcaMonitor();
    }//GEN-LAST:event_Box_MarcaMonitorMouseClicked

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
            java.util.logging.Logger.getLogger(AlterarUSUARIONOTEBOOK1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AlterarUSUARIONOTEBOOK1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AlterarUSUARIONOTEBOOK1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AlterarUSUARIONOTEBOOK1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AlterarUSUARIONOTEBOOK1().setVisible(true);
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
    private javax.swing.JButton ButtonExibirInformarObs;
    private javax.swing.JButton ButtonExibirOrganograma;
    private javax.swing.JButton ButtonRemoverMonitorExtra;
    private javax.swing.JButton Button_Alterar;
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
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JLabel textoDataAlteracao;
    // End of variables declaration//GEN-END:variables
}
