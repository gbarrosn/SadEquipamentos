/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import GuiJP.TelaConsultaEquip;
import GuiJP.TelaEquipamentosEscolha;
import GuiJP.TelaNovoEquip;
import Login.AlterarSenha;
import Login.ListarLoginUser;
import Login.LogarSadEquip;
import Login.LoginUser;
import Micro.Configuracao.CadastrarConfig;
import Micro.Configuracao.ListarConfig;
import Micro.MarcaMicro.CadastrarMarcaMicro;
import Micro.MarcaMicro.ListarMarcaMicro;
import Micro.ModeloMicro.CadastrarModeloMicro;
import Micro.ModeloMicro.ListarModeloMicro;
import Micro.OS.CadastrarOS;
import Micro.OS.ListarOS;
import Micro.PlataformaMicro.CadastrarPlataforma;
import Micro.PlataformaMicro.ListarPlataforma;
import Micro.ProprietarioMicro.CadastrarProprietarioMicro;
import Micro.ProprietarioMicro.ListarProprietarioMicro;
import Monitor.MarcaMonitor.CadastrarMarcaMonitor;
import Monitor.MarcaMonitor.ListarMarcaMonitor;
import Monitor.ModeloMonitor.CadastrarModeloMonitor;
import Monitor.ModeloMonitor.ListarModeloMonitor;
import Monitor.ProprietarioMonitor.CadastrarProprietarioMonitor;
import Monitor.ProprietarioMonitor.ListarProprietarioMonitor;
import Patrimonio.CadastrarBensMoveis;
import RelatoriosSAD.FormRelatorioCompleto;
import RelatoriosSAD.FormRelatorios;
import SADpe.Cargo.CadastrarCargo;
import SADpe.Cargo.ListarCargo;
import SADpe.Gerencia.CadastrarGerencia;
import SADpe.Gerencia.ListarGerencia;
import SADpe.Pavimento.CadastrarPavimento;
import SADpe.Pavimento.ListarPavimento;
import Usuario.ListarUSUARIO;
import Usuario.CadastrarUSUARIO2;
import Usuario.ObsGeral;
//import Principal.FormSobre;
import Versao_Office.CadastrarVersaoOffice;
import Versao_Office.ListarVersaoOffice;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 *
 * @author Posseidon
 */
public class TelaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form GESAD
     */
    public TelaPrincipal() {

        //ImageIcon icon = new ImageIcon (Toolkit.getDefaultToolkit().getImage(getClass().getResource("/resources/favicon-cor.ico"))); 
        //setIconImage(icon.getImage());
        initComponents();
        setTitle("Gerenciador de Equipamentos da Secretaria de Administração de Pernambuco - v8.0.1");
        //Centralizar formulário na tela:
        setLocationRelativeTo(null);
        //setExtendedState(MAXIMIZED_BOTH);
    }

    void icone() {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("resources\\favicon-cor.png"));
            this.setIconImage(img);
        } catch (IOException e) {
        }
    }


    LoginUser logado = new LoginUser();

    

    
    //logado precisa ser o usuario conectado
    public TelaPrincipal(LoginUser logado) {
        this.logado = logado;
        
        icone();
        initComponents();
        verificaPermissaoUsuario();
        setTitle("Gerenciador de Equipamentos da Secretaria de Administração de Pernambuco - v8.0.1");
        //Centralizar formulário na tela:
        setLocationRelativeTo(null);
        opcaoLogout.setText("Logout (" + logado.getLogin() + ")");
        campoNomeUserTelaPrinc.setText(logado.getLogin());
        textoHostName.setText(null);

        try {
            java.net.InetAddress localMachine = java.net.InetAddress.getLocalHost();
            textoHostName.setText(localMachine.getHostName());
        } catch (Exception e) {

        }

    }
// Sempre vai permitir enquanto as credencieais estiverem fixas no codigo
    public void verificaPermissaoUsuario() {
        if (logado.getAdm().equals("ALMOXARIFADO")) {
            jMenu1.setEnabled(false);
            jMenu2.setEnabled(false);
            jMenu3.setEnabled(false);
            jMenu4.setEnabled(false);
            jMenu5.setEnabled(false);
            jMenu6.setEnabled(false);
            jMenu7.setEnabled(false);
            jMenu8.setEnabled(false);
            jMenu9.setEnabled(false);
            jMenu10.setEnabled(false);
            jMenu11.setEnabled(false);
            jMenu11.setEnabled(false);
            jMenu14.setEnabled(false);
            jMenu16.setEnabled(false);
            jButtonListagemRapida.setEnabled(false);

        }else if (!logado.getAdm().equals("ALMOXARIFADO") && !!logado.getAdm().equals("ADM")) {
           jButtonEquipamentos.setEnabled(true);
           jMenuEquipamentos.setEnabled(true);
           jMenu12.setEnabled(false);
        }else if (logado.getAdm().equals("PATRIMONIO")) {
            jMenu1.setEnabled(false);
            jMenu2.setEnabled(false);
            jMenu3.setEnabled(false);
            jMenu4.setEnabled(false);
            jMenu5.setEnabled(false);
            jMenu6.setEnabled(false);
            jMenu7.setEnabled(false);
            jMenu8.setEnabled(false);
            jMenu9.setEnabled(false);
            jMenu10.setEnabled(false);
            jMenu11.setEnabled(false);
            jMenu11.setEnabled(false);
            jMenu14.setEnabled(false);
            jMenu16.setEnabled(false);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jMenu8 = new javax.swing.JMenu();
        jMenu16 = new javax.swing.JMenu();
        jLabel1 = new javax.swing.JLabel();
        jButtonListagemRapida = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        campoNomeUserTelaPrinc = new javax.swing.JLabel();
        textoHostName = new javax.swing.JLabel();
        jButtonEquipamentos = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuArquivo = new javax.swing.JMenu();
        jMenuItem32 = new javax.swing.JMenuItem();
        jMenuItem33 = new javax.swing.JMenuItem();
        jMenuItem24 = new javax.swing.JMenuItem();
        opcaoLogout = new javax.swing.JMenuItem();
        jMenuItem28 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        FormCadastrar = new javax.swing.JMenuItem();
        FormSair = new javax.swing.JMenuItem();
        jMenuItem29 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuEquipamentos = new javax.swing.JMenu();
        jMenuItem34 = new javax.swing.JMenuItem();
        jMenuItem35 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenu9 = new javax.swing.JMenu();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenuItem16 = new javax.swing.JMenuItem();
        jMenu10 = new javax.swing.JMenu();
        jMenuItem17 = new javax.swing.JMenuItem();
        jMenuItem18 = new javax.swing.JMenuItem();
        jMenu11 = new javax.swing.JMenu();
        jMenuItem19 = new javax.swing.JMenuItem();
        jMenuItem20 = new javax.swing.JMenuItem();
        jMenuItem21 = new javax.swing.JMenuItem();
        jMenuItem22 = new javax.swing.JMenuItem();
        jMenu14 = new javax.swing.JMenu();
        jMenuItem26 = new javax.swing.JMenuItem();
        jMenuItem27 = new javax.swing.JMenuItem();
        jMenuItem30 = new javax.swing.JMenuItem();
        jMenuItem31 = new javax.swing.JMenuItem();
        jMenuRelatorio = new javax.swing.JMenu();
        jMenuItem23 = new javax.swing.JMenuItem();
        jMenuItem25 = new javax.swing.JMenuItem();
        jMenu12 = new javax.swing.JMenu();
        jMenuItem36 = new javax.swing.JMenuItem();
        jMenuItem37 = new javax.swing.JMenuItem();
        jMenuItem38 = new javax.swing.JMenuItem();
        jMenuItem39 = new javax.swing.JMenuItem();

        jMenu1.setText("jMenu1");

        jMenu8.setText("jMenu8");

        jMenu16.setText("jMenu16");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/GovPERGB1.png"))); // NOI18N
        jLabel1.setToolTipText("");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jButtonListagemRapida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Icons/sort_desccending.png"))); // NOI18N
        jButtonListagemRapida.setText("Cadastro/Listagem Rápida");
        jButtonListagemRapida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonListagemRapidaActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Icons/print_layout.png"))); // NOI18N
        jButton3.setText("Relatório Rápido");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Icons/student_32.png"))); // NOI18N

        campoNomeUserTelaPrinc.setText("Usuário");

        textoHostName.setText("jLabel3");

        jButtonEquipamentos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Icons/accept_document.png"))); // NOI18N
        jButtonEquipamentos.setText("Equipamentos");
        jButtonEquipamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEquipamentosActionPerformed(evt);
            }
        });

        jMenuArquivo.setText("Arquivo");

        jMenuItem32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Icons/gear_32.png"))); // NOI18N
        jMenuItem32.setText("Gerenciar Usuários do Sistema (Requer Login de Administrador)");
        jMenuItem32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem32ActionPerformed(evt);
            }
        });
        jMenuArquivo.add(jMenuItem32);

        jMenuItem33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Icons/webmaster_32.png"))); // NOI18N
        jMenuItem33.setText("Alterar Minha Senha");
        jMenuItem33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem33ActionPerformed(evt);
            }
        });
        jMenuArquivo.add(jMenuItem33);

        jMenuItem24.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, 0));
        jMenuItem24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Icons/help_32.png"))); // NOI18N
        jMenuItem24.setText("Sobre");
        jMenuItem24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem24ActionPerformed(evt);
            }
        });
        jMenuArquivo.add(jMenuItem24);

        opcaoLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Icons/sign_out_32.png"))); // NOI18N
        opcaoLogout.setText("Logout");
        opcaoLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcaoLogoutActionPerformed(evt);
            }
        });
        jMenuArquivo.add(opcaoLogout);

        jMenuItem28.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        jMenuItem28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Icons/cross_32.png"))); // NOI18N
        jMenuItem28.setText("Sair");
        jMenuItem28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem28ActionPerformed(evt);
            }
        });
        jMenuArquivo.add(jMenuItem28);

        jMenuBar1.add(jMenuArquivo);

        jMenu2.setText("Usuário");

        FormCadastrar.setText("Cadastro de Usuários");
        FormCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FormCadastrarActionPerformed(evt);
            }
        });
        jMenu2.add(FormCadastrar);

        FormSair.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ENTER, 0));
        FormSair.setText("Lista de Usuários");
        FormSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FormSairActionPerformed(evt);
            }
        });
        jMenu2.add(FormSair);

        jMenuItem29.setText("Lista Geral de Observações");
        jMenuItem29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem29ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem29);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Gerência");

        jMenuItem1.setText("Cadastro de Gerências");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_1, 0));
        jMenuItem2.setText("Lista de Gerências");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem2);

        jMenuBar1.add(jMenu3);

        jMenu5.setText("Cargo");

        jMenuItem3.setText("Cadastro de Cargos");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem3);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_2, 0));
        jMenuItem4.setText("Lista de Cargos");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem4);

        jMenuBar1.add(jMenu5);

        jMenu6.setText("Pavimento");

        jMenuItem5.setText("Cadastro de Pavimentos");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem5);

        jMenuItem6.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_3, 0));
        jMenuItem6.setText("Lista de Pavimentos");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem6);

        jMenuBar1.add(jMenu6);

        jMenuEquipamentos.setText("Equipamentos");

        jMenuItem34.setText("Cadastro de Equipamentos");
        jMenuItem34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem34ActionPerformed(evt);
            }
        });
        jMenuEquipamentos.add(jMenuItem34);

        jMenuItem35.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, 0));
        jMenuItem35.setText("Lista de Equipamentos");
        jMenuItem35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem35ActionPerformed(evt);
            }
        });
        jMenuEquipamentos.add(jMenuItem35);

        jMenuBar1.add(jMenuEquipamentos);

        jMenu4.setText("Configuração de Máquina");

        jMenuItem7.setText("Cadastro de Configurações de Máquina");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem7);

        jMenuItem8.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_4, 0));
        jMenuItem8.setText("Lista de Configurações de Máquina");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem8);

        jMenuBar1.add(jMenu4);

        jMenu7.setText("Marca");

        jMenuItem12.setText("Cadastro de Marcas de Micros");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem12);

        jMenuItem11.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_5, 0));
        jMenuItem11.setText("Lista de Marcas de Micros");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem11);

        jMenuItem9.setText("Cadastro de Marcas de Monitores");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem9);

        jMenuItem10.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_5, java.awt.event.InputEvent.SHIFT_DOWN_MASK));
        jMenuItem10.setText("Lista de Marcas de Monitores");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem10);

        jMenuBar1.add(jMenu7);

        jMenu9.setText("Modelo");

        jMenuItem13.setText("Cadastro de Modelos de Micros");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        jMenu9.add(jMenuItem13);

        jMenuItem14.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_6, 0));
        jMenuItem14.setText("Lista de Modelos de Micros");
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        jMenu9.add(jMenuItem14);

        jMenuItem15.setText("Cadastro de Modelos de Monitores");
        jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem15ActionPerformed(evt);
            }
        });
        jMenu9.add(jMenuItem15);

        jMenuItem16.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_6, java.awt.event.InputEvent.SHIFT_DOWN_MASK));
        jMenuItem16.setText("Lista de Modelos de Monitores");
        jMenuItem16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem16ActionPerformed(evt);
            }
        });
        jMenu9.add(jMenuItem16);

        jMenuBar1.add(jMenu9);

        jMenu10.setText("Plataforma");

        jMenuItem17.setText("Cadastro de Plataformas");
        jMenuItem17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem17ActionPerformed(evt);
            }
        });
        jMenu10.add(jMenuItem17);

        jMenuItem18.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_7, 0));
        jMenuItem18.setText("Lista de Plataformas");
        jMenuItem18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem18ActionPerformed(evt);
            }
        });
        jMenu10.add(jMenuItem18);

        jMenuBar1.add(jMenu10);

        jMenu11.setText("Proprietário");

        jMenuItem19.setText("Cadastro de Proprietários de Micros");
        jMenuItem19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem19ActionPerformed(evt);
            }
        });
        jMenu11.add(jMenuItem19);

        jMenuItem20.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_8, 0));
        jMenuItem20.setText("Lista de Proprietários de Micros");
        jMenuItem20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem20ActionPerformed(evt);
            }
        });
        jMenu11.add(jMenuItem20);

        jMenuItem21.setText("Cadastro de Proprietários de Monitores");
        jMenuItem21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem21ActionPerformed(evt);
            }
        });
        jMenu11.add(jMenuItem21);

        jMenuItem22.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_8, java.awt.event.InputEvent.SHIFT_DOWN_MASK));
        jMenuItem22.setText("Lista de Proprietários de Monitores");
        jMenuItem22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem22ActionPerformed(evt);
            }
        });
        jMenu11.add(jMenuItem22);

        jMenuBar1.add(jMenu11);

        jMenu14.setText("Sistema");

        jMenuItem26.setText("Cadastrar Sistema Operacional");
        jMenuItem26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem26ActionPerformed(evt);
            }
        });
        jMenu14.add(jMenuItem26);

        jMenuItem27.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_9, 0));
        jMenuItem27.setText("Lista de Sistemas Operacionais");
        jMenuItem27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem27ActionPerformed(evt);
            }
        });
        jMenu14.add(jMenuItem27);

        jMenuItem30.setText("Cadastrar Versão do Pacote Office");
        jMenuItem30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem30ActionPerformed(evt);
            }
        });
        jMenu14.add(jMenuItem30);

        jMenuItem31.setText("Listar Versões do Pacote Office");
        jMenuItem31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem31ActionPerformed(evt);
            }
        });
        jMenu14.add(jMenuItem31);

        jMenuBar1.add(jMenu14);

        jMenuRelatorio.setText("Relatórios");

        jMenuItem23.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, 0));
        jMenuItem23.setText("Relatório - Pavimento");
        jMenuItem23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem23ActionPerformed(evt);
            }
        });
        jMenuRelatorio.add(jMenuItem23);

        jMenuItem25.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.SHIFT_DOWN_MASK));
        jMenuItem25.setText("Relatório - Completo");
        jMenuItem25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem25ActionPerformed(evt);
            }
        });
        jMenuRelatorio.add(jMenuItem25);

        jMenuBar1.add(jMenuRelatorio);

        jMenu12.setText("Cadastrar Bens Móveis");

        jMenuItem36.setText("Cadastro de Bens");
        jMenuItem36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem36ActionPerformed(evt);
            }
        });
        jMenu12.add(jMenuItem36);

        jMenuItem37.setText("Listagem de Bens");
        jMenuItem37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem37ActionPerformed(evt);
            }
        });
        jMenu12.add(jMenuItem37);

        jMenuItem38.setText("Cadastrar tipo de móvel");
        jMenuItem38.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem38ActionPerformed(evt);
            }
        });
        jMenu12.add(jMenuItem38);

        jMenuItem39.setText("Listar tipos de móvel");
        jMenuItem39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem39ActionPerformed(evt);
            }
        });
        jMenu12.add(jMenuItem39);

        jMenuBar1.add(jMenu12);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(5, 5, 5)
                        .addComponent(jLabel2)
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campoNomeUserTelaPrinc)
                            .addComponent(textoHostName)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jButtonEquipamentos, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(141, 141, 141)
                        .addComponent(jButtonListagemRapida)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(56, 56, 56))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 355, Short.MAX_VALUE)
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(campoNomeUserTelaPrinc)
                                .addGap(6, 6, 6)
                                .addComponent(textoHostName)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonListagemRapida)
                    .addComponent(jButton3)
                    .addComponent(jButtonEquipamentos))
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void FormCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FormCadastrarActionPerformed
        //chama form de cadastro
        CadastrarUSUARIO2 novoCadastro = new CadastrarUSUARIO2(this.logado);
        novoCadastro.setVisible(true);
        //torna não visível o form atual
        dispose();
    }//GEN-LAST:event_FormCadastrarActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        CadastrarGerencia cadastrar = new CadastrarGerencia(this.logado);
        cadastrar.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        ListarGerencia listar = new ListarGerencia(this.logado);
        listar.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem20ActionPerformed
        ListarProprietarioMicro listar = new ListarProprietarioMicro(this.logado);
        listar.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem20ActionPerformed

    private void FormSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FormSairActionPerformed
        ListarUSUARIO listaAtual = new ListarUSUARIO(this.logado);
        listaAtual.setVisible(true);
        dispose();
    }//GEN-LAST:event_FormSairActionPerformed

    private void jMenuItem23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem23ActionPerformed
        FormRelatorios formReport = new FormRelatorios(this.logado);
        formReport.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem23ActionPerformed

    private void jMenuItem24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem24ActionPerformed
        if (this.logado == null) {
            JOptionPane.showMessageDialog(rootPane, "Falha ao identificar o usuário. Ação negada!");
        } else if (this.logado.getAdm().equals("SIM")) {
            FormSobre sobre = new FormSobre(this.logado);
            sobre.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(rootPane, "Seu perfil de usuário atual não tem permissão para alterar logins do sistema.");
        }


    }//GEN-LAST:event_jMenuItem24ActionPerformed

    private void jMenuItem25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem25ActionPerformed
        FormRelatorioCompleto novoCustom = new FormRelatorioCompleto(this.logado);
        novoCustom.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem25ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        ListarConfig listar = new ListarConfig(this.logado);
        listar.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        CadastrarConfig cadastrar = new CadastrarConfig(this.logado);
        cadastrar.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        CadastrarMarcaMicro cadastrar = new CadastrarMarcaMicro(this.logado);
        cadastrar.setVisible(true);
        dispose();

    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        ListarMarcaMicro listar = new ListarMarcaMicro(this.logado);
        listar.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        CadastrarModeloMicro cadastrar = new CadastrarModeloMicro(this.logado);
        cadastrar.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
        ListarModeloMicro listar = new ListarModeloMicro(this.logado);
        listar.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem14ActionPerformed

    private void jMenuItem26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem26ActionPerformed
        CadastrarOS cadastrar = new CadastrarOS(this.logado);
        cadastrar.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem26ActionPerformed

    private void jMenuItem27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem27ActionPerformed
        ListarOS listar = new ListarOS(this.logado);
        listar.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem27ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        CadastrarCargo cadastrar = new CadastrarCargo(this.logado);
        cadastrar.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        ListarCargo listar = new ListarCargo(this.logado);
        listar.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        CadastrarMarcaMonitor cadastrar = new CadastrarMarcaMonitor(this.logado);
        cadastrar.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        ListarMarcaMonitor listar = new ListarMarcaMonitor(this.logado);
        listar.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        int key = evt.getKeyCode();
        if (key == KeyEvent.VK_ESCAPE) {
            System.exit(0);
        }
    }//GEN-LAST:event_formKeyPressed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        CadastrarPavimento cadastrar = new CadastrarPavimento(this.logado);
        cadastrar.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        ListarPavimento listar = new ListarPavimento(this.logado);
        listar.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem15ActionPerformed
        CadastrarModeloMonitor cadastrar = new CadastrarModeloMonitor(this.logado);
        cadastrar.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem15ActionPerformed

    private void jMenuItem16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem16ActionPerformed
        ListarModeloMonitor listar = new ListarModeloMonitor(this.logado);
        listar.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem16ActionPerformed

    private void jMenuItem17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem17ActionPerformed
        CadastrarPlataforma cadastrar = new CadastrarPlataforma(this.logado);
        cadastrar.setVisible(true);
        dispose();

    }//GEN-LAST:event_jMenuItem17ActionPerformed

    private void jMenuItem18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem18ActionPerformed
        ListarPlataforma listar = new ListarPlataforma(this.logado);
        listar.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem18ActionPerformed

    private void jMenuItem19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem19ActionPerformed
        CadastrarProprietarioMicro cadastrar = new CadastrarProprietarioMicro(this.logado);
        cadastrar.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem19ActionPerformed

    private void jMenuItem21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem21ActionPerformed
        CadastrarProprietarioMonitor cadastrar = new CadastrarProprietarioMonitor(this.logado);
        cadastrar.setVisible(true);
        dispose();

    }//GEN-LAST:event_jMenuItem21ActionPerformed

    private void jMenuItem22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem22ActionPerformed
        ListarProprietarioMonitor listar = new ListarProprietarioMonitor(this.logado);
        listar.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem22ActionPerformed

    private void jMenuItem28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem28ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem28ActionPerformed

    private void jMenuItem29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem29ActionPerformed
        ObsGeral obsGeral = new ObsGeral(this.logado);
        obsGeral.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem29ActionPerformed

    private void jMenuItem30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem30ActionPerformed
        CadastrarVersaoOffice cadastrar = new CadastrarVersaoOffice(this.logado);
        cadastrar.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem30ActionPerformed

    private void jMenuItem31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem31ActionPerformed
        ListarVersaoOffice listar = new ListarVersaoOffice(this.logado);
        listar.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem31ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        FormRelatorios form = new FormRelatorios(this.logado);
        form.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButtonListagemRapidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonListagemRapidaActionPerformed
        if (this.logado.getAdm().equals("SIM")) {
            ListarUSUARIO listaAtual = new ListarUSUARIO(this.logado);
            listaAtual.setVisible(true);
            dispose();
        } else if (this.logado.equals("PATRIMONIO")) { //TODO: criar tela de cadastro de bens móveis (igual o cadastro de usuario de pc)
            /*ListarBensMoveis listaBens = new ListarBensMoveis(this.logado);
            listaBens.setVisible(true);
            dispose();*/
        } else {
            JOptionPane.showMessageDialog(rootPane, "Seu perfil de usuário atual não tem permissão para acessar esta funcionalidade.");
        }
    }//GEN-LAST:event_jButtonListagemRapidaActionPerformed

    private void jMenuItem32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem32ActionPerformed

        if (this.logado == null) {
            JOptionPane.showMessageDialog(rootPane, "Falha ao identificar o usuário. Ação negada!");
        } else if (this.logado.getAdm().equals("SIM")) { 
            ListarLoginUser novo = new ListarLoginUser(this.logado);
            novo.setVisible(true);
            dispose();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Seu perfil de usuário atual não tem permissão para alterar logins do sistema.");
        }
    }//GEN-LAST:event_jMenuItem32ActionPerformed

    private void jMenuItem33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem33ActionPerformed
        AlterarSenha senha = new AlterarSenha(this.logado);
        senha.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem33ActionPerformed

    private void opcaoLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcaoLogoutActionPerformed
        LogarSadEquip loga = new LogarSadEquip();
        loga.setVisible(true);
        dispose();
    }//GEN-LAST:event_opcaoLogoutActionPerformed

// Cadastro de euipamentos hp
    private void jMenuItem34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem34ActionPerformed
        // Open the window for equipment registration
        //Cadastro de Equipament os HP
        TelaNovoEquip novo = new TelaNovoEquip(this.logado);
        novo.setVisible(true);
        dispose();
        
    }//GEN-LAST:event_jMenuItem34ActionPerformed
// Listar equipamentos hp
    private void jMenuItem35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem35ActionPerformed
        TelaConsultaEquip telaEquipHP = new TelaConsultaEquip(this.logado);
        telaEquipHP.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem35ActionPerformed


// Menu equipamentos
    private void jButtonEquipamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEquipamentosActionPerformed
        TelaEquipamentosEscolha equipEscolha = new TelaEquipamentosEscolha(logado);
        equipEscolha.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButtonEquipamentosActionPerformed

    private void jMenuItem38ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem38ActionPerformed
        // TODO add your handling code here: criar 
    }//GEN-LAST:event_jMenuItem38ActionPerformed

    private void jMenuItem36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem36ActionPerformed
        // TODO add your handling code here:
        CadastrarBensMoveis cadastroBens = new CadastrarBensMoveis();
        cadastroBens.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem36ActionPerformed

    private void jMenuItem37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem37ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem37ActionPerformed

    private void jMenuItem39ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem39ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem39ActionPerformed


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
                if ("MAC".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem FormCadastrar;
    private javax.swing.JMenuItem FormSair;
    private javax.swing.JLabel campoNomeUserTelaPrinc;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButtonEquipamentos;
    private javax.swing.JButton jButtonListagemRapida;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenu jMenu11;
    private javax.swing.JMenu jMenu12;
    private javax.swing.JMenu jMenu14;
    private javax.swing.JMenu jMenu16;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenu jMenuArquivo;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuEquipamentos;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem18;
    private javax.swing.JMenuItem jMenuItem19;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem20;
    private javax.swing.JMenuItem jMenuItem21;
    private javax.swing.JMenuItem jMenuItem22;
    private javax.swing.JMenuItem jMenuItem23;
    private javax.swing.JMenuItem jMenuItem24;
    private javax.swing.JMenuItem jMenuItem25;
    private javax.swing.JMenuItem jMenuItem26;
    private javax.swing.JMenuItem jMenuItem27;
    private javax.swing.JMenuItem jMenuItem28;
    private javax.swing.JMenuItem jMenuItem29;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem30;
    private javax.swing.JMenuItem jMenuItem31;
    private javax.swing.JMenuItem jMenuItem32;
    private javax.swing.JMenuItem jMenuItem33;
    private javax.swing.JMenuItem jMenuItem34;
    private javax.swing.JMenuItem jMenuItem35;
    private javax.swing.JMenuItem jMenuItem36;
    private javax.swing.JMenuItem jMenuItem37;
    private javax.swing.JMenuItem jMenuItem38;
    private javax.swing.JMenuItem jMenuItem39;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JMenu jMenuRelatorio;
    private javax.swing.JMenuItem opcaoLogout;
    private javax.swing.JLabel textoHostName;
    // End of variables declaration//GEN-END:variables

}
