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
import java.awt.Desktop;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Posseidon
 */
public class VisualizarUsuario extends javax.swing.JFrame {

    /**
     * Creates new form FormCadastrarUsuario
     */
    public VisualizarUsuario() {
        initComponents();
        setTitle("Visualização de cadastro de Usuário.");
    }

    private Usuario selecionadoUser;
    private Usuario user;
    private LoginUser logado;

    void icone() {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("resources\\favicon-cor.png"));
            this.setIconImage(img);
        } catch (IOException e) {
        }
    }

    public VisualizarUsuario(Usuario selecionadoUser, LoginUser logado) {
        icone();

        initComponents();

        setLocationRelativeTo(null);

        setTitle("Visualização de cadastro de Usuário.");

        comboBoxListagem();

        this.logado = logado;

        textoDataAlteracao.setText("Data da última alteração: " + selecionadoUser.getDataAlteracao() + "   por: " + selecionadoUser.getUsuarioAlteracao());
        Box_ModeloMicro.setSelectedItem(selecionadoUser.getModeloMicro().getModelo());
        Box_ProprietarioMonitor.setSelectedItem(selecionadoUser.getProprietarioMonitor().getProprietario());
        Box_ModeloMonitor.setSelectedItem(selecionadoUser.getModeloMonitor().getModelo());
        Box_Office.setSelectedItem(selecionadoUser.getVersao_office().getDescricao());
        Box_ProprietarioMonitor1.setSelectedItem(selecionadoUser.getProprietarioMonitor1().getProprietario());
        Box_ModeloMonitor1.setSelectedItem(selecionadoUser.getModeloMonitor1().getModelo());
        
        //Carregando combo com dados do Usuário selecionado:    
        Campo_NomeUser.setText(selecionadoUser.getNome());
        Box_CargoUser.setSelectedItem(selecionadoUser.getCargo().getCargo());
        Box_PavimentoUser.setSelectedItem(selecionadoUser.getPavimentoUsuario().getPavimento());
        Box_GerenciaUser.setSelectedItem(selecionadoUser.getGerencia().getSiglaGerencia());
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
        //Carregando combo com dados do Monitor do Usuário selecionado: 
        Campo_TomboMonitor.setText(selecionadoUser.getTombamentoMonitor() + "");
        Campo_SerieMonitor.setText(selecionadoUser.getSerieMonitor());
        Box_MarcaMonitor.setSelectedItem(selecionadoUser.getMarcaMonitor().getMarca());
        campo_Garantia.setText(selecionadoUser.getGarantia());
        Box_MarcaMonitor1.setSelectedItem(selecionadoUser.getMarcaMonitor().getMarca());
        Campo_TomboMonitor1.setText(selecionadoUser.getTombamentoMonitor1() + "");
        Campo_SerieMonitor1.setText(selecionadoUser.getSerieMonitor1());
        // carregando cpf do usuario
        Campo_CpfUser.setText(selecionadoUser.getCpf());


        if (selecionadoUser.getAtivo()) {
            jCheckBox1.setSelected(false);
        }
        if (!selecionadoUser.getAtivo()) {
            jCheckBox1.setSelected(true);
        }

        //campoOBS.setText(selecionadoUser.getObs());       

        //atribui valor a variável global selecionadoNota
        this.selecionadoUser = selecionadoUser;

        /*
         try {
            
         String urlPadrao = ("\\\\sadfs01\\GTINF\\USINF\\USINF 2015\\TERMO DE RESPONSABILIDADE\\Termos de Responsabilidade - Digitalizados\\");
         File file = new File (urlPadrao+selecionadoUser.getNome()+".pdf");
        
         if(file.exists()==true){
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
    private ArrayList<ModeloMonitor> allModelosMonitores1;
    private ArrayList<MarcaMonitor> allMarcasMonitores1;
    private ArrayList<ProprietarioMonitor> allProprietariosMonitores1;
    private ArrayList<VersaoOffice> allVersaoOffice;
    private ArrayList<OS> allOs;

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
//*********************** ComboBox MarcaMonitor2:
            try {
                MarcaMonitor comboMarcaMonitor = new MarcaMonitor();

                comboMarcaMonitor.setMarca("");

                allMarcasMonitores1 = Fachada.getInstancia().listarMarcaMonitor(comboMarcaMonitor);

                DefaultComboBoxModel listaComboMarcaMonitor = new DefaultComboBoxModel();

                listaComboMarcaMonitor.addElement("Marca do Monitor");

                for (int i = 0; i < allMarcasMonitores1.size(); i++) {
                    MarcaMonitor nomeComboMarcaMonitor = new MarcaMonitor();
                    nomeComboMarcaMonitor = allMarcasMonitores1.get(i);
                    listaComboMarcaMonitor.addElement(nomeComboMarcaMonitor.getMarca());
                }
                Box_MarcaMonitor1.setModel(listaComboMarcaMonitor);

            } catch (Exception e) {
                throw new Exception("Não existe nenhuma Marca de Monitor cadastrado no banco de dados " + e.getMessage());
            }

            //*********************** ComboBox ModeloMonitor2:
            try {
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
                Box_ModeloMonitor1.setModel(listaComboModeloMonitor);

            } catch (Exception e) {
                throw new Exception("Não existe nenhuma Modelo de Monitor cadastrado no banco de dados " + e.getMessage());
            }

            //*********************** ComboBox ProprietarioMonitor2:
            try {
                ProprietarioMonitor comboProprietarioMonitor = new ProprietarioMonitor();

                comboProprietarioMonitor.setProprietario("");
                allProprietariosMonitores1 = Fachada.getInstancia().listarProprietarioMonitor(comboProprietarioMonitor);

                DefaultComboBoxModel listaComboProprietarioMonitor = new DefaultComboBoxModel();

                listaComboProprietarioMonitor.addElement("Proprietario do Monitor");

                for (int i = 0; i < allProprietariosMonitores1.size(); i++) {
                    ProprietarioMonitor nomeComboProprietarioMonitor = new ProprietarioMonitor();
                    nomeComboProprietarioMonitor = allProprietariosMonitores1.get(i);
                    listaComboProprietarioMonitor.addElement(nomeComboProprietarioMonitor.getProprietario());
                }
                Box_ProprietarioMonitor1.setModel(listaComboProprietarioMonitor);

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

                listaComboGerencia.addElement("Gerencia");

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
        Button_Cadastrar1 = new javax.swing.JButton();
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
        jLabel8 = new javax.swing.JLabel();
        jButtonAtivarAlterar = new javax.swing.JButton();
        textoDataAlteracao = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        ButtonExibirInformarObs = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        Box_Office = new javax.swing.JComboBox();
        ButtonExibirOrganograma = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        checkPossuiTermo = new javax.swing.JCheckBox();
        jSeparator6 = new javax.swing.JSeparator();
        Campo_TomboMonitor1 = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        Box_MarcaMonitor1 = new javax.swing.JComboBox();
        jLabel29 = new javax.swing.JLabel();
        Campo_SerieMonitor1 = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        Box_ProprietarioMonitor1 = new javax.swing.JComboBox();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        Box_ModeloMonitor1 = new javax.swing.JComboBox();
        jSeparator7 = new javax.swing.JSeparator();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel34 = new javax.swing.JLabel();
        Campo_CpfUser = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Campo_TomboMonitor.setEditable(false);
        Campo_TomboMonitor.setFocusable(false);
        Campo_TomboMonitor.setRequestFocusEnabled(false);
        getContentPane().add(Campo_TomboMonitor, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 361, 140, -1));

        Campo_TomboMicro.setEditable(false);
        Campo_TomboMicro.setFocusable(false);
        Campo_TomboMicro.setRequestFocusEnabled(false);
        getContentPane().add(Campo_TomboMicro, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 172, 213, -1));

        jLabel19.setText("Modelo:");
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 394, -1, -1));

        Box_MarcaMonitor.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Box_MarcaMonitor.setEnabled(false);
        Box_MarcaMonitor.setFocusable(false);
        Box_MarcaMonitor.setName(""); // NOI18N
        Box_MarcaMonitor.setRequestFocusEnabled(false);
        Box_MarcaMonitor.setVerifyInputWhenFocusTarget(false);
        getContentPane().add(Box_MarcaMonitor, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 391, 130, -1));
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 498, 870, -1));

        Button_Cadastrar1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Button_Cadastrar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Icons/arrow_left_32.png"))); // NOI18N
        Button_Cadastrar1.setText("Voltar");
        Button_Cadastrar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_Cadastrar1ActionPerformed(evt);
            }
        });
        getContentPane().add(Button_Cadastrar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 508, 118, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("      Microcomputador:");
        jLabel6.setAlignmentX(0.5F);
        jLabel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 131, 159, 35));

        jLabel2.setText("Nome:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 50, -1, -1));

        jLabel3.setText("Gerência:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(445, 84, -1, -1));

        Box_ModeloMicro.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Box_ModeloMicro.setEnabled(false);
        Box_ModeloMicro.setFocusable(false);
        Box_ModeloMicro.setName(""); // NOI18N
        Box_ModeloMicro.setRequestFocusEnabled(false);
        Box_ModeloMicro.setVerifyInputWhenFocusTarget(false);
        getContentPane().add(Box_ModeloMicro, new org.netbeans.lib.awtextra.AbsoluteConstraints(107, 209, 243, -1));

        Box_GerenciaUser.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Box_GerenciaUser.setEnabled(false);
        Box_GerenciaUser.setFocusable(false);
        Box_GerenciaUser.setName(""); // NOI18N
        Box_GerenciaUser.setRequestFocusEnabled(false);
        Box_GerenciaUser.setVerifyInputWhenFocusTarget(false);
        getContentPane().add(Box_GerenciaUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(505, 81, 200, -1));

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setText("          Monitor:");
        jLabel16.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 329, 130, 20));

        Campo_HostNameMicro.setEditable(false);
        Campo_HostNameMicro.setFocusable(false);
        Campo_HostNameMicro.setRequestFocusEnabled(false);
        getContentPane().add(Campo_HostNameMicro, new org.netbeans.lib.awtextra.AbsoluteConstraints(107, 172, 243, -1));

        Campo_SerieMonitor.setEditable(false);
        Campo_SerieMonitor.setFocusable(false);
        Campo_SerieMonitor.setRequestFocusEnabled(false);
        getContentPane().add(Campo_SerieMonitor, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 361, 130, -1));

        jLabel7.setText("Host Name:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 175, -1, -1));

        jLabel12.setText("Modelo:");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 212, -1, -1));

        Box_SO.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Box_SO.setEnabled(false);
        Box_SO.setFocusable(false);
        Box_SO.setName(""); // NOI18N
        Box_SO.setRequestFocusEnabled(false);
        Box_SO.setVerifyInputWhenFocusTarget(false);
        getContentPane().add(Box_SO, new org.netbeans.lib.awtextra.AbsoluteConstraints(107, 283, 243, -1));

        Box_MarcaMicro.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Box_MarcaMicro.setEnabled(false);
        Box_MarcaMicro.setFocusable(false);
        Box_MarcaMicro.setName(""); // NOI18N
        Box_MarcaMicro.setRequestFocusEnabled(false);
        Box_MarcaMicro.setVerifyInputWhenFocusTarget(false);
        getContentPane().add(Box_MarcaMicro, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 246, 213, -1));

        Box_ConfigMicro.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Box_ConfigMicro.setEnabled(false);
        Box_ConfigMicro.setFocusable(false);
        Box_ConfigMicro.setName(""); // NOI18N
        Box_ConfigMicro.setRequestFocusEnabled(false);
        Box_ConfigMicro.setVerifyInputWhenFocusTarget(false);
        getContentPane().add(Box_ConfigMicro, new org.netbeans.lib.awtextra.AbsoluteConstraints(107, 246, 243, -1));

        jLabel18.setText("Série:");
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 364, -1, -1));

        Box_ProprietarioMonitor.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Box_ProprietarioMonitor.setEnabled(false);
        Box_ProprietarioMonitor.setFocusable(false);
        Box_ProprietarioMonitor.setName(""); // NOI18N
        Box_ProprietarioMonitor.setRequestFocusEnabled(false);
        Box_ProprietarioMonitor.setVerifyInputWhenFocusTarget(false);
        getContentPane().add(Box_ProprietarioMonitor, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 419, 190, -1));

        campo_Garantia.setEditable(false);
        campo_Garantia.setFocusable(false);
        campo_Garantia.setRequestFocusEnabled(false);
        getContentPane().add(campo_Garantia, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 464, 263, -1));

        jLabel17.setText("Tombo:");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 364, -1, -1));

        Box_Plataforma.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Box_Plataforma.setEnabled(false);
        Box_Plataforma.setFocusable(false);
        Box_Plataforma.setName(""); // NOI18N
        Box_Plataforma.setRequestFocusEnabled(false);
        Box_Plataforma.setVerifyInputWhenFocusTarget(false);
        getContentPane().add(Box_Plataforma, new org.netbeans.lib.awtextra.AbsoluteConstraints(735, 172, 192, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("            Usuário:");
        jLabel1.setAlignmentX(0.5F);
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 6, 150, 29));

        jLabel22.setText("Garantia:");
        getContentPane().add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 467, -1, -1));

        Box_CargoUser.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Box_CargoUser.setEnabled(false);
        Box_CargoUser.setFocusable(false);
        Box_CargoUser.setName(""); // NOI18N
        Box_CargoUser.setRequestFocusEnabled(false);
        Box_CargoUser.setVerifyInputWhenFocusTarget(false);
        getContentPane().add(Box_CargoUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(505, 47, 200, -1));

        jLabel23.setText("CESU:");
        getContentPane().add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(645, 212, -1, -1));

        jLabel15.setText("Plataforma:");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(645, 175, -1, -1));

        Box_PavimentoUser.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Box_PavimentoUser.setEnabled(false);
        Box_PavimentoUser.setFocusable(false);
        Box_PavimentoUser.setName(""); // NOI18N
        Box_PavimentoUser.setRequestFocusEnabled(false);
        Box_PavimentoUser.setVerifyInputWhenFocusTarget(false);
        Box_PavimentoUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Box_PavimentoUserActionPerformed(evt);
            }
        });
        getContentPane().add(Box_PavimentoUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 81, 320, -1));

        Campo_NomeUser.setEditable(false);
        Campo_NomeUser.setFocusable(false);
        Campo_NomeUser.setRequestFocusEnabled(false);
        getContentPane().add(Campo_NomeUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 47, 320, -1));

        Campo_cmtech.setEditable(false);
        Campo_cmtech.setFocusable(false);
        Campo_cmtech.setRequestFocusEnabled(false);
        getContentPane().add(Campo_cmtech, new org.netbeans.lib.awtextra.AbsoluteConstraints(735, 209, 192, -1));

        Box_ProprietarioMicro.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Box_ProprietarioMicro.setEnabled(false);
        Box_ProprietarioMicro.setFocusable(false);
        Box_ProprietarioMicro.setName(""); // NOI18N
        Box_ProprietarioMicro.setRequestFocusEnabled(false);
        Box_ProprietarioMicro.setVerifyInputWhenFocusTarget(false);
        getContentPane().add(Box_ProprietarioMicro, new org.netbeans.lib.awtextra.AbsoluteConstraints(735, 246, 192, -1));

        jLabel10.setText("Configuração:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 249, -1, -1));

        jLabel5.setText("Pavimento:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 84, -1, -1));

        jLabel14.setText("Sistema:");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 286, 60, -1));

        jLabel4.setText("Cargo:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(445, 50, -1, -1));
        getContentPane().add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 116, 887, -1));
        getContentPane().add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 449, 910, -1));

        jLabel11.setText("Marca:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(372, 249, -1, -1));

        jLabel20.setText("Marca:");
        getContentPane().add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 394, -1, -1));

        jLabel9.setText("Série:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(372, 212, 36, -1));

        jLabel21.setText("Proprietário:");
        getContentPane().add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 422, 70, -1));

        Campo_SerieMicro.setEditable(false);
        Campo_SerieMicro.setFocusable(false);
        Campo_SerieMicro.setRequestFocusEnabled(false);
        Campo_SerieMicro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Campo_SerieMicroActionPerformed(evt);
            }
        });
        getContentPane().add(Campo_SerieMicro, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 209, 213, -1));

        jLabel13.setText("Proprietário:");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(645, 249, -1, -1));

        Box_ModeloMonitor.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Box_ModeloMonitor.setEnabled(false);
        Box_ModeloMonitor.setFocusable(false);
        Box_ModeloMonitor.setName(""); // NOI18N
        Box_ModeloMonitor.setRequestFocusEnabled(false);
        Box_ModeloMonitor.setVerifyInputWhenFocusTarget(false);
        getContentPane().add(Box_ModeloMonitor, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 391, 140, -1));

        jLabel8.setText("Tombo:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(372, 175, -1, -1));

        jButtonAtivarAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Icons/file_transfer_32.png"))); // NOI18N
        jButtonAtivarAlterar.setText("Liberar Campos para Alteração");
        jButtonAtivarAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAtivarAlterarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonAtivarAlterar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 508, -1, -1));

        textoDataAlteracao.setText("Data da última alteração:");
        getContentPane().add(textoDataAlteracao, new org.netbeans.lib.awtextra.AbsoluteConstraints(216, 13, -1, -1));

        jLabel24.setText("Obs:");
        getContentPane().add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 467, -1, -1));

        ButtonExibirInformarObs.setText("Exibir/Registrar Observações");
        ButtonExibirInformarObs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonExibirInformarObsActionPerformed(evt);
            }
        });
        getContentPane().add(ButtonExibirInformarObs, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 461, -1, 29));

        jLabel25.setText("Office:");
        getContentPane().add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(372, 286, -1, -1));

        Box_Office.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        Box_Office.setEnabled(false);
        getContentPane().add(Box_Office, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 283, 213, -1));

        ButtonExibirOrganograma.setText("Exibir organograma");
        ButtonExibirOrganograma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonExibirOrganogramaActionPerformed(evt);
            }
        });
        getContentPane().add(ButtonExibirOrganograma, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 80, 200, -1));

        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Icons/clock_32.png"))); // NOI18N
        getContentPane().add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(178, 6, -1, -1));

        jButton1.setText("Exibir Termo de Responsabilidade");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 460, -1, 31));

        jLabel27.setText("Possui termo?");
        getContentPane().add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 467, -1, -1));
        getContentPane().add(checkPossuiTermo, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 458, -1, 35));
        getContentPane().add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 124, 887, 0));

        Campo_TomboMonitor1.setEditable(false);
        Campo_TomboMonitor1.setFocusable(false);
        Campo_TomboMonitor1.setRequestFocusEnabled(false);
        getContentPane().add(Campo_TomboMonitor1, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 361, 140, -1));

        jLabel28.setText("Modelo:");
        getContentPane().add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 394, -1, -1));

        Box_MarcaMonitor1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Box_MarcaMonitor1.setEnabled(false);
        Box_MarcaMonitor1.setFocusable(false);
        Box_MarcaMonitor1.setName(""); // NOI18N
        Box_MarcaMonitor1.setRequestFocusEnabled(false);
        Box_MarcaMonitor1.setVerifyInputWhenFocusTarget(false);
        getContentPane().add(Box_MarcaMonitor1, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 391, 130, -1));

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel29.setText("          Monitor:");
        jLabel29.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 329, 130, 20));

        Campo_SerieMonitor1.setEditable(false);
        Campo_SerieMonitor1.setFocusable(false);
        Campo_SerieMonitor1.setRequestFocusEnabled(false);
        getContentPane().add(Campo_SerieMonitor1, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 361, 130, -1));

        jLabel30.setText("Série:");
        getContentPane().add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 364, -1, -1));

        Box_ProprietarioMonitor1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Box_ProprietarioMonitor1.setEnabled(false);
        Box_ProprietarioMonitor1.setFocusable(false);
        Box_ProprietarioMonitor1.setName(""); // NOI18N
        Box_ProprietarioMonitor1.setRequestFocusEnabled(false);
        Box_ProprietarioMonitor1.setVerifyInputWhenFocusTarget(false);
        getContentPane().add(Box_ProprietarioMonitor1, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 419, 190, -1));

        jLabel31.setText("Tombo:");
        getContentPane().add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 364, -1, -1));

        jLabel32.setText("Marca:");
        getContentPane().add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 394, -1, -1));

        jLabel33.setText("Proprietário:");
        getContentPane().add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 422, 80, -1));

        Box_ModeloMonitor1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Box_ModeloMonitor1.setEnabled(false);
        Box_ModeloMonitor1.setFocusable(false);
        Box_ModeloMonitor1.setName(""); // NOI18N
        Box_ModeloMonitor1.setRequestFocusEnabled(false);
        Box_ModeloMonitor1.setVerifyInputWhenFocusTarget(false);
        getContentPane().add(Box_ModeloMonitor1, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 391, 140, -1));
        getContentPane().add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 314, 887, -1));

        jCheckBox1.setText("Usuáio inativo");
        getContentPane().add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 140, -1, -1));

        jLabel34.setText("CPF:");
        getContentPane().add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 50, -1, -1));

        Campo_CpfUser.setEditable(false);
        Campo_CpfUser.setFocusable(false);
        Campo_CpfUser.setRequestFocusEnabled(false);
        getContentPane().add(Campo_CpfUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 50, 170, -1));

        jMenu1.setText("Opções");

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

    private void Button_Cadastrar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_Cadastrar1ActionPerformed
        dispose();
    }//GEN-LAST:event_Button_Cadastrar1ActionPerformed

    private void Box_PavimentoUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Box_PavimentoUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Box_PavimentoUserActionPerformed

    private void Campo_SerieMicroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Campo_SerieMicroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Campo_SerieMicroActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        TelaPrincipal principal = new TelaPrincipal(this.logado);
        principal.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        ListarUSUARIO listar = new ListarUSUARIO(this.logado);
        listar.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jButtonAtivarAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAtivarAlterarActionPerformed
        AlterarUSUARIO alterarUser = new AlterarUSUARIO(this.selecionadoUser, this.logado);
        alterarUser.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButtonAtivarAlterarActionPerformed

    private void ButtonExibirInformarObsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonExibirInformarObsActionPerformed
        this.user = selecionadoUser;
        ObsHistorico exibirInformarObs = new ObsHistorico(user, this.logado);
        exibirInformarObs.setVisible(true);
    }//GEN-LAST:event_ButtonExibirInformarObsActionPerformed

    private void ButtonExibirOrganogramaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonExibirOrganogramaActionPerformed
        Organograma org = new Organograma(this.logado);
        org.setVisible(true);
    }//GEN-LAST:event_ButtonExibirOrganogramaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            String urlPadrao = ("\\\\sadfs01\\GTINF\\USINF\\Sistema SAD Equipamentos\\Termos de Responsabilidade\\");
            File file = new File(urlPadrao + "Termo de Responsabilidade - " + this.selecionadoUser.getNome()
                    + " - " + this.selecionadoUser.getModeloMicro().getModelo()+ ".pdf");

            Desktop.getDesktop().open(file);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "Nenhum Termo encontrado para o usuário de nome: " + this.selecionadoUser.getNome());
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
            java.util.logging.Logger.getLogger(VisualizarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VisualizarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VisualizarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VisualizarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new VisualizarUsuario().setVisible(true);
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
    private javax.swing.JButton Button_Cadastrar1;
    private javax.swing.JTextField Campo_CpfUser;
    private javax.swing.JTextField Campo_HostNameMicro;
    private javax.swing.JTextField Campo_NomeUser;
    private javax.swing.JTextField Campo_SerieMicro;
    private javax.swing.JTextField Campo_SerieMonitor;
    private javax.swing.JTextField Campo_SerieMonitor1;
    private javax.swing.JTextField Campo_TomboMicro;
    private javax.swing.JTextField Campo_TomboMonitor;
    private javax.swing.JTextField Campo_TomboMonitor1;
    private javax.swing.JTextField Campo_cmtech;
    private javax.swing.JTextField campo_Garantia;
    private javax.swing.JCheckBox checkPossuiTermo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonAtivarAlterar;
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
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JLabel textoDataAlteracao;
    // End of variables declaration//GEN-END:variables
}
