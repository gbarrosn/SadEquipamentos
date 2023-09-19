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
import javax.swing.*;

/**
 *
 * @author Posseidon
 */
public final class AlterarUSUARIO extends javax.swing.JFrame {

    /**
     * Creates new form FormCadastrarUsuario
     */
    private LoginUser logado;
    private Usuario selecionadoUser;
    private Usuario user;
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
    private ArrayList<ModeloMonitor> allModelosMonitores1;
    private ArrayList<MarcaMonitor> allMarcasMonitores1;
    private ArrayList<ProprietarioMonitor> allProprietariosMonitores1;
    private ArrayList<VersaoOffice> allVersaoOffice;
    private ArrayList<OS> allOs;
    
    private JCheckBox jCheckBox1;

    public AlterarUSUARIO() {
        initComponents();
        setTitle("Formulário de alteração de cadastro de Usuário.");
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

    public AlterarUSUARIO(Usuario selecionadoUser) {

        initComponents();
    }

    public AlterarUSUARIO(Usuario selecionadoUser, LoginUser logado) {

        initComponents();
        setLocationRelativeTo(null);
        setTitle("Formulário de alteração de cadastro de Usuário.");

        comboBoxListagem();

        listarMarcaMicro();
        listarMarcaMonitor();
        listarMarcaMonitor1();

        this.logado = logado;

        textoDataAlteracao.setText("Data da última alteração: " + selecionadoUser.getDataAlteracao() + "   por: " + selecionadoUser.getUsuarioAlteracao());
        Box_ModeloMicro.setSelectedItem(selecionadoUser.getModeloMicro().getModelo());
        Box_ProprietarioMonitor.setSelectedItem(selecionadoUser.getProprietarioMonitor().getProprietario());
        Box_ModeloMonitor.setSelectedItem(selecionadoUser.getModeloMonitor().getModelo());
        Box_ProprietarioMonitor1.setSelectedItem(selecionadoUser.getProprietarioMonitor1().getProprietario());
        Box_ModeloMonitor1.setSelectedItem(selecionadoUser.getModeloMonitor1().getModelo());
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
        jTextField_EtiquetaSad.setText(selecionadoUser.getEtiquetaSAD());
        Box_Plataforma.setSelectedItem(selecionadoUser.getPlataformaMicro().getPlataforma());
        Box_ConfigMicro.setSelectedItem(selecionadoUser.getConfigMicro().getConfiguracao());
        Box_MarcaMicro.setSelectedItem(selecionadoUser.getMarcaMicro().getMarca());
        Box_ProprietarioMicro.setSelectedItem(selecionadoUser.getProprietarioMicro().getProprietario());
        Box_SO.setSelectedItem(selecionadoUser.getOsMicro().getOs());
        //Carregando combo com dados do Monitor do Usuário selecionado:
        Campo_TomboMonitor.setText(selecionadoUser.getTombamentoMonitor() + "");
        Campo_SerieMonitor.setText(selecionadoUser.getSerieMonitor());
        Box_MarcaMonitor.setSelectedItem(selecionadoUser.getMarcaMonitor().getMarca());
        campo_Garantia.setText(selecionadoUser.getGarantia());
        Campo_TomboMonitor1.setText(selecionadoUser.getTombamentoMonitor1() + "");
        Campo_SerieMonitor1.setText(selecionadoUser.getSerieMonitor1());
        Box_MarcaMonitor1.setSelectedItem(selecionadoUser.getMarcaMonitor1().getMarca());
        jCheckBox1.setSelected(selecionadoUser.getAtivo());

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

    void listarMarcaMonitor() {
        try {
            //*********************** ComboBox MarcaMonitor:
            try {
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

            } catch (Exception e) {
                throw new Exception("Não existe nenhuma Marca de Monitor cadastrado no banco de dados " + e.getMessage());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        }
    }
    public void listarMarcaMonitor1() {
        try {

            try {

                if (allMarcasMonitores1 == null) {
                    MarcaMonitor comboMarcaMonitor1 = new MarcaMonitor();

                    comboMarcaMonitor1.setMarca("");

                    allMarcasMonitores1 = Fachada.getInstancia().listarMarcaMonitor(comboMarcaMonitor1);

                    DefaultComboBoxModel listaComboMarcaMonitor1 = new DefaultComboBoxModel();

                    listaComboMarcaMonitor1.addElement("Marca do Monitor");

                    for (int i = 0; i < allMarcasMonitores1.size(); i++) {
                        MarcaMonitor nomeComboMarcaMonitor = new MarcaMonitor();
                        nomeComboMarcaMonitor = allMarcasMonitores1.get(i);
                        listaComboMarcaMonitor1.addElement(nomeComboMarcaMonitor.getMarca());
                    }
                    Box_MarcaMonitor1.setModel(listaComboMarcaMonitor1);
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

    public void listarGerencia(int filter) {
        try {

            try {
                Gerencia comboGerencia = new Gerencia();

                comboGerencia.setGerencia("");
                comboGerencia.setSiglaGerencia("");
                Pavimento pavGer = new Pavimento();

                if (filter == 10000) {
                    pavGer.setIdPavimento(0);
                    pavGer.setPavimento("");
                    comboGerencia.setPavimento(pavGer);
                } else {
                    comboGerencia.setPavimento(allPavimentos.get(filter));
                }
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


            //*********************** ComboBox Gerência:
            listarGerencia(10000);

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

            //*********************** ComboBox ModeloMonitor:
            try {
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

            } catch (Exception e) {
                throw new Exception("Não existe nenhuma Modelo de Monitor cadastrado no banco de dados " + e.getMessage());
            }

            //*********************** ComboBox ProprietarioMonitor:
            try {
                ProprietarioMonitor comboProprietarioMonitor = new ProprietarioMonitor();

                comboProprietarioMonitor.setProprietario("");
                allProprietariosMonitores = Fachada.getInstancia().listarProprietarioMonitor(comboProprietarioMonitor);

                DefaultComboBoxModel listaComboProprietarioMonitor = new DefaultComboBoxModel();

                listaComboProprietarioMonitor.addElement("Proprietario do Monitor");

                for (int i = 0; i < allProprietariosMonitores.size(); i++) {
                    ProprietarioMonitor nomeComboProprietarioMonitor = new ProprietarioMonitor();
                    nomeComboProprietarioMonitor = allProprietariosMonitores.get(i);
                    listaComboProprietarioMonitor.addElement(nomeComboProprietarioMonitor.getProprietario());
                }
                Box_ProprietarioMonitor.setModel(listaComboProprietarioMonitor);

            } catch (Exception e) {
                throw new Exception("Não existe nenhum Proprietario de Monitores cadastrado no banco de dados " + e.getMessage());
            }
            //*********************** ComboBox ModeloMonitor2:
            try {
                ModeloMonitor comboModeloMonitor1 = new ModeloMonitor();

                comboModeloMonitor1.setModelo("");
                MarcaMonitor m1 = new MarcaMonitor();
                m1.setIdMarca(0);
                m1.setMarca("");
                comboModeloMonitor1.setMarca(m1);
                allModelosMonitores1 = Fachada.getInstancia().listarModeloMonitor1(comboModeloMonitor1);

                DefaultComboBoxModel listaComboModeloMonitor1 = new DefaultComboBoxModel();

                listaComboModeloMonitor1.addElement("Modelo do Monitor");

                for (int i = 0; i < allModelosMonitores1.size(); i++) {
                    ModeloMonitor nomeComboModeloMonitor1 = new ModeloMonitor();
                    nomeComboModeloMonitor1 = allModelosMonitores1.get(i);
                    listaComboModeloMonitor1.addElement(nomeComboModeloMonitor1.getModelo());
                }
                Box_ModeloMonitor1.setModel(listaComboModeloMonitor1);

            } catch (Exception e) {
                throw new Exception("Não existe nenhuma Modelo de Monitor cadastrado no banco de dados " + e.getMessage());
            }

            //*********************** ComboBox ProprietarioMonitor2:
            try {
                ProprietarioMonitor comboProprietarioMonitor1 = new ProprietarioMonitor();

                comboProprietarioMonitor1.setProprietario("");
                allProprietariosMonitores1 = Fachada.getInstancia().listarProprietarioMonitor1(comboProprietarioMonitor1);

                DefaultComboBoxModel listaComboProprietarioMonitor1 = new DefaultComboBoxModel();

                listaComboProprietarioMonitor1.addElement("Proprietario do Monitor");

                for (int i = 0; i < allProprietariosMonitores1.size(); i++) {
                    ProprietarioMonitor nomeComboProprietarioMonitor1 = new ProprietarioMonitor();
                    nomeComboProprietarioMonitor1 = allProprietariosMonitores1.get(i);
                    listaComboProprietarioMonitor1.addElement(nomeComboProprietarioMonitor1.getProprietario());
                }
                Box_ProprietarioMonitor1.setModel(listaComboProprietarioMonitor1);

            } catch (Exception e) {
                throw new Exception("Não existe nenhum Proprietario de Monitores cadastrado no banco de dados " + e.getMessage());
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

        Campo_TomboMonitor = new javax.swing.JTextField();
        Campo_TomboMicro = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        Box_MarcaMonitor = new javax.swing.JComboBox();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator1 = new javax.swing.JSeparator();
        Button_Voltar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Box_ModeloMicro = new javax.swing.JComboBox();
        Box_GerenciaUser = new javax.swing.JComboBox();
        jLabel16 = new javax.swing.JLabel();
        Campo_HostNameMicro = new javax.swing.JTextField();
        Campo_SerieMonitor = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        Box_SO = new javax.swing.JComboBox();
        Box_MarcaMicro = new javax.swing.JComboBox();
        Box_ConfigMicro = new javax.swing.JComboBox();
        jLabel18 = new javax.swing.JLabel();
        Box_ProprietarioMonitor = new javax.swing.JComboBox();
        campo_Garantia = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        Box_Plataforma = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
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
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel11 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        Campo_SerieMicro = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        Box_ModeloMonitor = new javax.swing.JComboBox();
        Button_Alterar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        campoDescricao = new javax.swing.JLabel();
        textoDataAlteracao = new javax.swing.JLabel();
        ButtonExibirOrganograma = new javax.swing.JButton();
        ButtonExibirInformarObs = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        Box_Office = new javax.swing.JComboBox();
        jLabel24 = new javax.swing.JLabel();
        buttonExibirTermo = new javax.swing.JButton();
        checkPossuiTermo = new javax.swing.JCheckBox();
        jButton2 = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jTextField_EtiquetaSad = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        Campo_TomboMonitor1 = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        Box_MarcaMonitor1 = new javax.swing.JComboBox();
        Campo_SerieMonitor1 = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        Box_ProprietarioMonitor1 = new javax.swing.JComboBox();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        Box_ModeloMonitor1 = new javax.swing.JComboBox();
        jCheckBox1 = new javax.swing.JCheckBox();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jCheckBox1 = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(Campo_TomboMonitor, new org.netbeans.lib.awtextra.AbsoluteConstraints(306, 387, 128, -1));
        getContentPane().add(Campo_TomboMicro, new org.netbeans.lib.awtextra.AbsoluteConstraints(418, 204, 204, -1));

        jLabel19.setText("Modelo:");
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, -1, -1));

        Box_MarcaMonitor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        Box_MarcaMonitor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Box_MarcaMonitorActionPerformed(evt);
            }
        });
        getContentPane().add(Box_MarcaMonitor, new org.netbeans.lib.awtextra.AbsoluteConstraints(306, 417, 128, -1));
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 532, 879, 4));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 143, 879, 2));

        Button_Voltar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Button_Voltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Icons/arrow_left_32.png"))); // NOI18N
        Button_Voltar.setText("Voltar");
        Button_Voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_VoltarActionPerformed(evt);
            }
        });
        getContentPane().add(Button_Voltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(792, 544, 118, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("      Microcomputador:");
        jLabel6.setAlignmentX(0.5F);
        jLabel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 157, 159, 35));

        jLabel2.setText("Nome:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 52, -1, -1));

        jLabel3.setText("Gerência:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(445, 90, -1, -1));

        Box_ModeloMicro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        Box_ModeloMicro.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                Box_ModeloMicroItemStateChanged(evt);
            }
        });
        getContentPane().add(Box_ModeloMicro, new org.netbeans.lib.awtextra.AbsoluteConstraints(114, 237, 239, -1));

        Box_GerenciaUser.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
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
        getContentPane().add(Box_GerenciaUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(514, 87, 129, -1));

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setText("            Monitor2:");
        jLabel16.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(477, 346, 150, 33));
        getContentPane().add(Campo_HostNameMicro, new org.netbeans.lib.awtextra.AbsoluteConstraints(114, 204, 239, -1));
        getContentPane().add(Campo_SerieMonitor, new org.netbeans.lib.awtextra.AbsoluteConstraints(101, 387, 152, -1));

        jLabel7.setText("Host Name:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 207, -1, -1));

        jLabel12.setText("Modelo:");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 240, -1, -1));

        Box_SO.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(Box_SO, new org.netbeans.lib.awtextra.AbsoluteConstraints(114, 303, 239, -1));

        Box_MarcaMicro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(Box_MarcaMicro, new org.netbeans.lib.awtextra.AbsoluteConstraints(418, 270, 204, -1));

        Box_ConfigMicro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(Box_ConfigMicro, new org.netbeans.lib.awtextra.AbsoluteConstraints(114, 270, 239, -1));

        jLabel18.setText("Série:");
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 388, -1, 20));

        Box_ProprietarioMonitor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        Box_ProprietarioMonitor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Box_ProprietarioMonitorActionPerformed(evt);
            }
        });
        getContentPane().add(Box_ProprietarioMonitor, new org.netbeans.lib.awtextra.AbsoluteConstraints(101, 447, 152, -1));
        getContentPane().add(campo_Garantia, new org.netbeans.lib.awtextra.AbsoluteConstraints(89, 497, 269, -1));

        jLabel17.setText("Tombo:");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(259, 390, -1, -1));

        Box_Plataforma.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(Box_Plataforma, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 298, 163, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("            Usuário:");
        jLabel1.setAlignmentX(0.5F);
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 11, 150, 32));

        jLabel22.setText("Garantia:");
        getContentPane().add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 500, -1, -1));

        Box_CargoUser.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(Box_CargoUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(514, 49, 339, -1));

        jLabel23.setText("CESU:");
        getContentPane().add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 240, -1, -1));

        jLabel15.setText("Plataforma:");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 308, -1, -1));

        Box_PavimentoUser.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
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
        getContentPane().add(Box_PavimentoUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 87, 332, -1));
        getContentPane().add(Campo_NomeUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(101, 49, 332, -1));
        getContentPane().add(Campo_cmtech, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 237, 163, -1));

        Box_ProprietarioMicro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(Box_ProprietarioMicro, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 270, 163, -1));

        jLabel10.setText("Configuração:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 273, -1, -1));

        jLabel5.setText("Pavimento:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 90, -1, -1));

        jLabel14.setText("Sistema:");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 306, 60, -1));

        jLabel4.setText("Cargo:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(445, 52, -1, -1));
        getContentPane().add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 338, 879, 2));
        getContentPane().add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 477, 879, 2));

        jLabel11.setText("Marca:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(375, 273, -1, -1));

        jLabel20.setText("Marca:");
        getContentPane().add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(259, 420, -1, -1));

        jLabel9.setText("Série:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(375, 240, 36, -1));

        jLabel21.setText("Proprietário:");
        getContentPane().add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 450, -1, -1));

        Campo_SerieMicro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Campo_SerieMicroActionPerformed(evt);
            }
        });
        getContentPane().add(Campo_SerieMicro, new org.netbeans.lib.awtextra.AbsoluteConstraints(418, 237, 204, -1));

        jLabel13.setText("Proprietário:");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 273, -1, -1));

        Box_ModeloMonitor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        Box_ModeloMonitor.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                Box_ModeloMonitorItemStateChanged(evt);
            }
        });
        Box_ModeloMonitor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Box_ModeloMonitorActionPerformed(evt);
            }
        });
        getContentPane().add(Box_ModeloMonitor, new org.netbeans.lib.awtextra.AbsoluteConstraints(101, 417, 152, -1));

        Button_Alterar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Button_Alterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Icons/diskette_32.png"))); // NOI18N
        Button_Alterar.setText("Alterar");
        Button_Alterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_AlterarActionPerformed(evt);
            }
        });
        getContentPane().add(Button_Alterar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 542, 125, 43));

        jLabel8.setText("Tombo:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(375, 207, -1, -1));

        campoDescricao.setText("Descrição:");
        getContentPane().add(campoDescricao, new org.netbeans.lib.awtextra.AbsoluteConstraints(445, 121, -1, -1));

        textoDataAlteracao.setText("Data da última alteração:");
        getContentPane().add(textoDataAlteracao, new org.netbeans.lib.awtextra.AbsoluteConstraints(226, 21, -1, -1));

        ButtonExibirOrganograma.setText("Exibir organograma");
        ButtonExibirOrganograma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonExibirOrganogramaActionPerformed(evt);
            }
        });
        getContentPane().add(ButtonExibirOrganograma, new org.netbeans.lib.awtextra.AbsoluteConstraints(649, 83, 204, 31));

        ButtonExibirInformarObs.setText("Exibir/Registrar Observações");
        ButtonExibirInformarObs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonExibirInformarObsActionPerformed(evt);
            }
        });
        getContentPane().add(ButtonExibirInformarObs, new org.netbeans.lib.awtextra.AbsoluteConstraints(376, 491, 186, 35));

        jLabel26.setText("Office:");
        getContentPane().add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(375, 306, -1, -1));

        Box_Office.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(Box_Office, new org.netbeans.lib.awtextra.AbsoluteConstraints(418, 303, 204, -1));

        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Icons/clock_32.png"))); // NOI18N
        getContentPane().add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(188, 11, -1, -1));

        buttonExibirTermo.setText("Exibir Termo de Responsabilidade");
        buttonExibirTermo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonExibirTermoActionPerformed(evt);
            }
        });
        getContentPane().add(buttonExibirTermo, new org.netbeans.lib.awtextra.AbsoluteConstraints(691, 491, 209, 35));
        getContentPane().add(checkPossuiTermo, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 491, -1, 35));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Icons/format_painter.png"))); // NOI18N
        jButton2.setText("Limpar Campos");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 542, 147, 43));

        jLabel25.setText("Possui termo?");
        getContentPane().add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 500, -1, -1));

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel29.setText("EtiquetaSad:");
        getContentPane().add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 208, 80, -1));
        getContentPane().add(jTextField_EtiquetaSad, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 208, 163, -1));

        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel30.setText("            Monitor:");
        jLabel30.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 348, 150, 33));
        getContentPane().add(Campo_TomboMonitor1, new org.netbeans.lib.awtextra.AbsoluteConstraints(761, 387, 128, -1));

        jLabel31.setText("Modelo2:");
        getContentPane().add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(477, 420, -1, -1));

        Box_MarcaMonitor1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        Box_MarcaMonitor1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Box_MarcaMonitor1ActionPerformed(evt);
            }
        });
        getContentPane().add(Box_MarcaMonitor1, new org.netbeans.lib.awtextra.AbsoluteConstraints(763, 417, 126, -1));
        getContentPane().add(Campo_SerieMonitor1, new org.netbeans.lib.awtextra.AbsoluteConstraints(554, 387, 152, -1));

        jLabel32.setText("Série2:");
        getContentPane().add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(477, 388, -1, 20));

        Box_ProprietarioMonitor1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        Box_ProprietarioMonitor1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Box_ProprietarioMonitor1ActionPerformed(evt);
            }
        });
        getContentPane().add(Box_ProprietarioMonitor1, new org.netbeans.lib.awtextra.AbsoluteConstraints(554, 447, 152, -1));

        jLabel33.setText("Tombo:");
        getContentPane().add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(712, 390, -1, -1));

        jLabel34.setText("Marca 2:");
        getContentPane().add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(712, 420, -1, -1));

        jLabel35.setText("Proprietário2:");
        getContentPane().add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(477, 450, -1, -1));

        Box_ModeloMonitor1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        Box_ModeloMonitor1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                Box_ModeloMonitor1ItemStateChanged(evt);
            }
        });
        Box_ModeloMonitor1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Box_ModeloMonitor1ActionPerformed(evt);
            }
        });
        getContentPane().add(Box_ModeloMonitor1, new org.netbeans.lib.awtextra.AbsoluteConstraints(554, 417, 152, -1));

        jCheckBox1.setText("Inativar usuário");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 160, 140, -1));

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

    private void Button_VoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_VoltarActionPerformed
        dispose();
    }//GEN-LAST:event_Button_VoltarActionPerformed

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
            alterarUser.setNotebook("não");

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
                int SelecionadoProprietarioMonitor = Box_ProprietarioMonitor.getSelectedIndex() - 1;
                alterarUser.setProprietarioMonitor(allProprietariosMonitores.get(SelecionadoProprietarioMonitor));
            } catch (Exception e) {
                throw new Exception("Selecione um Proprietário para o Monitor");
            }

            //Modelo Monitor:
            try {
                int SelecionadoModeloMonitor = Box_ModeloMonitor.getSelectedIndex() - 1;
                alterarUser.setModeloMonitor(allModelosMonitores.get(SelecionadoModeloMonitor));
            } catch (Exception e) {
                throw new Exception("Selecione um Modelo para o Monitor");
            }

            //Marca Monitor:
            try {
                int SelecionadoMarcaMonitor = Box_MarcaMonitor.getSelectedIndex() - 1;
                alterarUser.setMarcaMonitor(allMarcasMonitores.get(SelecionadoMarcaMonitor));
            } catch (Exception e) {
                throw new Exception("Selecione uma Marca para o Monitor");
            }

            //Proprietário Monitor2:
            try {
                int SelecionadoProprietarioMonitor1 = Box_ProprietarioMonitor1.getSelectedIndex() - 1;
                alterarUser.setProprietarioMonitor1(allProprietariosMonitores1.get(SelecionadoProprietarioMonitor1));
            } catch (Exception e) {
                throw new Exception("Selecione um Proprietário para o Monitor 2");
            }

            //Modelo Monitor2:
            try {
                int SelecionadoModeloMonitor1 = Box_ModeloMonitor1.getSelectedIndex() - 1;
                alterarUser.setModeloMonitor1(allModelosMonitores1.get(SelecionadoModeloMonitor1));
            } catch (Exception e) {
                throw new Exception("Selecione um Modelo para o Monitor 2");
            }

            //Marca Monitor2:
            try {
                int SelecionadoMarcaMonitor1 = Box_MarcaMonitor1.getSelectedIndex() - 1;
                alterarUser.setMarcaMonitor1(allMarcasMonitores1.get(SelecionadoMarcaMonitor1));
            } catch (Exception e) {
                throw new Exception("Selecione uma Marca para o Monitor 2");
            }

            //Recebendo campos Strings:
            alterarUser.setNome(Campo_NomeUser.getText().toUpperCase());

            alterarUser.setNomepc(Campo_HostNameMicro.getText().toUpperCase());

            alterarUser.setSerieMicro(Campo_SerieMicro.getText().toUpperCase());

            alterarUser.setSerieMonitor(Campo_SerieMonitor.getText().toUpperCase());

            alterarUser.setSerieMonitor1(Campo_SerieMonitor1.getText().toUpperCase());

            alterarUser.setGarantia(campo_Garantia.getText().toUpperCase());

            alterarUser.setTermo_responsabilidade(checkPossuiTermo.isSelected());

            alterarUser.setEtiquetaSAD(jTextField_EtiquetaSad.getText());

            if (!alterarUser.getAtivo()) {
                jCheckBox1.setSelected(false);
            }
            else {
                jCheckBox1.setSelected(true);
            }

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

            //Tombo Monitor:
            try {
                String tomboMonitorPC = Campo_TomboMonitor.getText();
                long tomboMonitorPCIntParse = Long.parseLong(tomboMonitorPC);
                alterarUser.setTombamentoMonitor(tomboMonitorPCIntParse);
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
                int etiquetaIntParse = Integer.parseInt(etiqueta);
                alterarUser.setEtiquetaCESU(etiquetaIntParse);
            } catch (NumberFormatException e) {
                if (Campo_cmtech.getText().trim().equals("") == true) {
                    throw new Exception("Preencha o campo Etiqueta CMTECH!(Obrigatório).");
                } else {
                    throw new Exception("Erro - Campo Etiqueta CMTECH: Preencha apenas com números.");
                }
            }

            if (jCheckBox1.isSelected()) {
                alterarUser.setAtivo(false);
            } else {
                alterarUser.setAtivo(true);
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
        Campo_SerieMonitor1.setText("");
        Campo_SerieMonitor.setText("");
        Campo_TomboMicro.setText("");
        Campo_TomboMonitor.setText("");
        Campo_TomboMonitor1.setText("");
        Campo_cmtech.setText("");
        campo_Garantia.setText("");
        jTextField_EtiquetaSad.setText("");
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        ListarUSUARIO listar = new ListarUSUARIO(this.logado);
        listar.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

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

    private void ButtonExibirInformarObsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonExibirInformarObsActionPerformed
        this.user = selecionadoUser;
        ObsHistorico exibirInformarObs = new ObsHistorico(user, this.logado);
        exibirInformarObs.setVisible(true);
    }//GEN-LAST:event_ButtonExibirInformarObsActionPerformed

    private void Box_PavimentoUserItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_Box_PavimentoUserItemStateChanged

        try {

            if (Box_PavimentoUser.getSelectedItem().equals("Pavimento")) {
                if (allPavimentos != null) {
                    int selecionadoPavimento = Box_PavimentoUser.getSelectedIndex() - 1;
                    listarGerencia(selecionadoPavimento);
                }else{
                    listarGerencia(10000);
                    Box_GerenciaUser.setSelectedItem(selecionadoUser.getGerencia().getSiglaGerencia());
                }
            } else {
                int selecionadoPavimento = Box_PavimentoUser.getSelectedIndex() - 1;
                listarGerencia(selecionadoPavimento);
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

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Campo_HostNameMicro.setText("");
        Campo_NomeUser.setText("");
        Campo_SerieMicro.setText("");
        Campo_SerieMonitor1.setText("");
        Campo_SerieMonitor.setText("");
        Campo_TomboMicro.setText("");
        Campo_TomboMonitor.setText("");
        Campo_TomboMonitor1.setText("");
        Campo_cmtech.setText("");
        campo_Garantia.setText("");
        jTextField_EtiquetaSad.setText("");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void buttonExibirTermoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonExibirTermoActionPerformed
        try {
            String urlPadrao = ("\\\\sadfs01\\GTINF\\USINF\\USINF 2015\\TERMO DE RESPONSABILIDADE\\Termos de Responsabilidade - Digitalizados\\");
            File file = new File(urlPadrao + this.selecionadoUser.getNome() + ".pdf");

            Desktop.getDesktop().open(file);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "Nenhum Termo encontrado para o usuário de nome: " + this.selecionadoUser.getNome());
        }

    }//GEN-LAST:event_buttonExibirTermoActionPerformed

    private void Box_GerenciaUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Box_GerenciaUserMouseClicked

        //if (allGerencias == null) {
        ///    listarGerencia(10000);
        //    Box_GerenciaUser.setSelectedItem(selecionadoUser.getGerencia().getSiglaGerencia());
        //}

    }//GEN-LAST:event_Box_GerenciaUserMouseClicked

    private void Box_PavimentoUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Box_PavimentoUserMouseClicked

    }//GEN-LAST:event_Box_PavimentoUserMouseClicked

    private void Box_ModeloMonitor1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_Box_ModeloMonitor1ItemStateChanged
        try {

            if (Box_ModeloMonitor1.getSelectedItem().equals("Modelo do Monitor")) {

                listarMarcaMonitor1();

            } else {

                MarcaMonitor filtroMarcaMonitor = new MarcaMonitor();

                //*********************** ComboBox Gerencia:
                try {

                    filtroMarcaMonitor.setMarca("");

                    //filtroGerencia.setPavimento(pavGer);
                    int SelecionadoModelo = Box_ModeloMonitor1.getSelectedIndex() - 1;
                    ModeloMonitor modelo = new ModeloMonitor();
                    modelo = (allModelosMonitores1.get(SelecionadoModelo));
                    filtroMarcaMonitor.setIdMarca(modelo.getMarca().getIdMarca());

                    allMarcasMonitores1 = Fachada.getInstancia().listarMarcaMonitor(filtroMarcaMonitor);

                    DefaultComboBoxModel listaCombo = new DefaultComboBoxModel();

                    listaCombo.addElement("Marca do Monitor");

                    for (MarcaMonitor allMarcas : allMarcasMonitores1) {
                        MarcaMonitor nomeCombo = new MarcaMonitor();
                        nomeCombo = allMarcas;
                        listaCombo.addElement(nomeCombo.getMarca());
                    }
                    Box_MarcaMonitor1.setModel(listaCombo);
                    Box_MarcaMonitor1.setSelectedIndex(1);

                } catch (Exception e) {
                    throw new Exception(e.getMessage());
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Erro - " + e.getMessage());
        }
    }//GEN-LAST:event_Box_ModeloMonitor1ItemStateChanged

    private void Box_ModeloMonitor1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Box_ModeloMonitor1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Box_ModeloMonitor1ActionPerformed

    private void Box_MarcaMonitor1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Box_MarcaMonitor1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Box_MarcaMonitor1ActionPerformed
    private void Box_MarcaMonitor1MouseClicked(java.awt.event.MouseEvent evt) {
        listarMarcaMonitor1();
    }
    private void Box_MarcaMonitorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Box_MarcaMonitorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Box_MarcaMonitorActionPerformed

    private void Box_ModeloMonitorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Box_ModeloMonitorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Box_ModeloMonitorActionPerformed

    private void Box_ProprietarioMonitorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Box_ProprietarioMonitorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Box_ProprietarioMonitorActionPerformed

    private void Box_ProprietarioMonitor1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Box_ProprietarioMonitor1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Box_ProprietarioMonitor1ActionPerformed

    private void Campo_TomboMonitor1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Campo_TomboMonitor1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Campo_TomboMonitor1ActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox1ActionPerformed

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
            java.util.logging.Logger.getLogger(AlterarUSUARIO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AlterarUSUARIO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AlterarUSUARIO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AlterarUSUARIO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AlterarUSUARIO().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox Box_CargoUser;
    private javax.swing.JComboBox Box_ConfigMicro;
    private javax.swing.JComboBox Box_GerenciaUser;
    private javax.swing.JComboBox Box_MarcaMicro;
    private javax.swing.JComboBox Box_MarcaMonitor;
    private javax.swing.JComboBox Box_MarcaMonitor1;
    private javax.swing.JComboBox Box_ModeloMicro;
    private javax.swing.JComboBox Box_ModeloMonitor;
    private javax.swing.JComboBox Box_ModeloMonitor1;
    private javax.swing.JComboBox Box_Office;
    private javax.swing.JComboBox Box_PavimentoUser;
    private javax.swing.JComboBox Box_Plataforma;
    private javax.swing.JComboBox Box_ProprietarioMicro;
    private javax.swing.JComboBox Box_ProprietarioMonitor;
    private javax.swing.JComboBox Box_ProprietarioMonitor1;
    private javax.swing.JComboBox Box_SO;
    private javax.swing.JButton ButtonExibirInformarObs;
    private javax.swing.JButton ButtonExibirOrganograma;
    private javax.swing.JButton Button_Alterar;
    private javax.swing.JButton Button_Voltar;
    private javax.swing.JTextField Campo_HostNameMicro;
    private javax.swing.JTextField Campo_NomeUser;
    private javax.swing.JTextField Campo_SerieMicro;
    private javax.swing.JTextField Campo_SerieMonitor;
    private javax.swing.JTextField Campo_SerieMonitor1;
    private javax.swing.JTextField Campo_TomboMicro;
    private javax.swing.JTextField Campo_TomboMonitor;
    private javax.swing.JTextField Campo_TomboMonitor1;
    private javax.swing.JTextField Campo_cmtech;
    private javax.swing.JButton buttonExibirTermo;
    private javax.swing.JLabel campoDescricao;
    private javax.swing.JTextField campo_Garantia;
    private javax.swing.JCheckBox checkPossuiTermo;
    private javax.swing.JButton jButton2;
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
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
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
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JTextField jTextField_EtiquetaSad;
    private javax.swing.JLabel textoDataAlteracao;
    // End of variables declaration//GEN-END:variables
}
