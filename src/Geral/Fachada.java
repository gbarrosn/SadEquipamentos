/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Geral;

import ClassesBasicasJP.Equipamentos;
import ClassesBasicasJP.Fornecedor;
import ClassesBasicasJP.ItensDaNota;
import ClassesBasicasJP.NotaFiscal;
import InterfaceJP.InterfaceEquipamentos;
import InterfaceJP.InterfaceFornecedor;
import InterfaceJP.InterfaceItensDaNota;
import InterfaceJP.InterfaceNotaFiscal;
import PersistenciaJP.NegocioEquipamentos;
import PersistenciaJP.NegocioFornecedor;
import Login.InterfaceLogin;
import Login.LoginUser;
import Login.NegocioLogin;
import Micro.Configuracao.Configuracao;
import Micro.Configuracao.InterfaceConfiguracao;
import Micro.Configuracao.NegocioConfiguracao;
import Micro.MarcaMicro.InterfaceMarcaMicro;
import Micro.MarcaMicro.MarcaMicro;
import Micro.MarcaMicro.NegocioMarcaMicro;
import Micro.ModeloMicro.InterfaceModeloMicro;
import Micro.ModeloMicro.ModeloMicro;
import Micro.ModeloMicro.NegocioModeloMicro;
import Micro.OS.InterfaceOS;
import Micro.OS.NegocioOS;
import Micro.OS.OS;
import Micro.PlataformaMicro.InterfacePlataformaMicro;
import Micro.PlataformaMicro.NegocioPlataformaMicro;
import Micro.PlataformaMicro.PlataformaMicro;
import Micro.ProprietarioMicro.InterfaceProprietarioMicro;
import Micro.ProprietarioMicro.NegocioProprietarioMicro;
import Micro.ProprietarioMicro.ProprietarioMicro;
import Monitor.MarcaMonitor.InterfaceMarcaMonitor;
import Monitor.MarcaMonitor.MarcaMonitor;
import Monitor.MarcaMonitor.NegocioMarcaMonitor;
import Monitor.ModeloMonitor.InterfaceModeloMonitor;
import Monitor.ModeloMonitor.ModeloMonitor;
import Monitor.ModeloMonitor.NegocioModeloMonitor;
import Monitor.ProprietarioMonitor.InterfaceProprietarioMonitor;
import Monitor.ProprietarioMonitor.NegocioProprietarioMonitor;
import Monitor.ProprietarioMonitor.ProprietarioMonitor;
import PersistenciaJP.NegocioItensDaNota;
import PersistenciaJP.NegocioNotaFiscal;
import SADpe.Cargo.Cargo;
import SADpe.Cargo.InterfaceCargo;
import SADpe.Cargo.NegocioCargo;
import SADpe.Gerencia.Gerencia;
import SADpe.Gerencia.InterfaceGerencia;
import SADpe.Gerencia.NegocioGerencia;
import SADpe.Pavimento.InterfacePavimento;
import SADpe.Pavimento.NegocioPavimento;
import SADpe.Pavimento.Pavimento;
import Usuario.CadastrarUSUARIO;
import Usuario.InterfaceUsuario;
import Usuario.NegocioUsuario;
import Usuario.Obs;
import Usuario.Usuario;
import Versao_Office.InterfaceVersaoOffice;
import Versao_Office.NegocioVersaoOffice;
import Versao_Office.VersaoOffice;
import java.util.ArrayList;

/**
 *
 * @author Posseidon
 */
public class Fachada implements InterfaceUsuario, InterfaceConfiguracao, InterfaceMarcaMicro,
        InterfaceModeloMicro, InterfaceOS, InterfacePlataformaMicro,
        InterfaceProprietarioMicro, InterfaceMarcaMonitor, InterfaceModeloMonitor,
        InterfaceProprietarioMonitor, InterfaceCargo, InterfaceGerencia, InterfacePavimento,
        InterfaceVersaoOffice, InterfaceLogin, InterfaceEquipamentos, InterfaceFornecedor, InterfaceNotaFiscal, InterfaceItensDaNota {

    private static Fachada instancia;

    public static void setInstancia(Fachada aInstancia) {
        instancia = aInstancia;
    }
    public static void setInstancia1(Fachada aInstancia) {
        instancia = aInstancia;
    }



    private Fachada() {

    }

    public static Fachada getInstancia() {
        if (instancia == null) {
            setInstancia(new Fachada());
        }
        return instancia;
    }
    public static Fachada getInstancia1() {
        if (instancia == null) {
            setInstancia(new Fachada());
        }
        return instancia;
    }

    //IMPLEMENTAR USUÁRIO: OK!
    @Override
    public void cadastrarUsuario(Usuario user) throws Exception {
        NegocioUsuario negocioUser = new NegocioUsuario();
        negocioUser.cadastrarUsuario(user);
    }

    @Override
    public void alterarUsuario(Usuario alterarUser, Usuario selecionadoUser) throws Exception {
        NegocioUsuario alteraNegocioUser = new NegocioUsuario();
        alteraNegocioUser.alterarUsuario(alterarUser, selecionadoUser);
    }

    @Override
    public void removerUsuario(Usuario removerUser) throws Exception {
        NegocioUsuario negocioRemoverUsuario = new NegocioUsuario();
        negocioRemoverUsuario.removerUsuario(removerUser);
    }

    @Override
    public ArrayList<Usuario> listarUsuario(Usuario filtroUser) throws Exception {
        NegocioUsuario negocioFiltroUser = new NegocioUsuario();
        return negocioFiltroUser.listarUsuario(filtroUser);
    }

    //IMPLEMENTAR CONFIGURACÇÃO: 
    @Override
    public void cadastrarConfiguracao(Configuracao config) throws Exception {
        NegocioConfiguracao negocioConfig = new NegocioConfiguracao();
        negocioConfig.cadastrarConfiguracao(config);
    }

    @Override
    public void alterarConfiguracao(Configuracao alterarConfig, Configuracao selecionadoConfig) throws Exception {
        NegocioConfiguracao negocioConfig = new NegocioConfiguracao();
        negocioConfig.alterarConfiguracao(alterarConfig, selecionadoConfig);
    }

    @Override
    public void removerConfiguracao(Configuracao removerConfig) throws Exception {
        NegocioConfiguracao negocioConfig3 = new NegocioConfiguracao();
        negocioConfig3.removerConfiguracao(removerConfig);
    }

    @Override
    public ArrayList<Configuracao> listarConfiguracao(Configuracao filtroConfig) throws Exception {
        NegocioConfiguracao negocioFiltroConfiguracao = new NegocioConfiguracao();
        return negocioFiltroConfiguracao.listarConfiguracao(filtroConfig);
    }

    //IMPLEMENTAR MARCA MICRO:
    @Override
    public void cadastrarMarcaMicro(MarcaMicro cadastrarMarcaMicro) throws Exception {
        NegocioMarcaMicro cadastrar = new NegocioMarcaMicro();
        cadastrar.cadastrarMarcaMicro(cadastrarMarcaMicro);
    }

    @Override
    public void alterarMarcaMicro(MarcaMicro alterarMarcaMicro, MarcaMicro selecionadoMarcaMicro) throws Exception {
        NegocioMarcaMicro alterar = new NegocioMarcaMicro();
        alterar.alterarMarcaMicro(alterarMarcaMicro, selecionadoMarcaMicro);

    }

    @Override
    public void removerMarcaMicro(MarcaMicro removerMarcaMicro) throws Exception {
        NegocioMarcaMicro remover = new NegocioMarcaMicro();
        remover.removerMarcaMicro(removerMarcaMicro);
    }

    @Override
    public ArrayList<MarcaMicro> listarMarcaMicro(MarcaMicro filtroMarcaMicro) throws Exception {
        NegocioMarcaMicro negocioFiltroMarcaMicro = new NegocioMarcaMicro();
        return negocioFiltroMarcaMicro.listarMarcaMicro(filtroMarcaMicro);
    }

    //IMPLEMENTAR MODELO MICRO:
    @Override
    public void cadastrarModeloMicro(ModeloMicro modeloMicro) throws Exception {
        NegocioModeloMicro negocio = new NegocioModeloMicro();
        negocio.cadastrarModeloMicro(modeloMicro);
    }

    @Override
    public void alterarModeloMicro(ModeloMicro alterarModeloMicro, ModeloMicro selecionadoModeloMicro) throws Exception {
        NegocioModeloMicro negocio = new NegocioModeloMicro();
        negocio.alterarModeloMicro(alterarModeloMicro, selecionadoModeloMicro);
    }

    @Override
    public void removerModeloMicro(ModeloMicro removerModeloMicro) throws Exception {
        NegocioModeloMicro negocio = new NegocioModeloMicro();
        negocio.removerModeloMicro(removerModeloMicro);
    }

    @Override
    public ArrayList<ModeloMicro> listarModeloMicro(ModeloMicro filtroModeloMicro) throws Exception {
        NegocioModeloMicro negocioFiltroModeloMicro = new NegocioModeloMicro();
        return negocioFiltroModeloMicro.listarModeloMicro(filtroModeloMicro);
    }

    //IMPLEMENTAR OS:
    @Override
    public void cadastrarOS(OS os) throws Exception {
        NegocioOS negoOS = new NegocioOS();
        negoOS.cadastrarOS(os);
    }

    @Override
    public void alterarOS(OS alterarOS, OS selecionadoOS) throws Exception {
        NegocioOS negoOS = new NegocioOS();
        negoOS.alterarOS(alterarOS, selecionadoOS);
    }

    @Override
    public void removerOS(OS removerOS) throws Exception {
        NegocioOS negoOS = new NegocioOS();
        negoOS.removerOS(removerOS);

    }

    @Override
    public ArrayList<OS> listarOS(OS filtroOS) throws Exception {
        NegocioOS negocioFiltroOS = new NegocioOS();
        return negocioFiltroOS.listarOS(filtroOS);
    }

    //IMPLEMENTAR PLATAFORMA MICRO:
    @Override
    public void cadastrarPlataformaMicro(PlataformaMicro plataforma) throws Exception {
        NegocioPlataformaMicro negoPlataformaMicro = new NegocioPlataformaMicro();
        negoPlataformaMicro.cadastrarPlataformaMicro(plataforma);
    }

    @Override
    public void alterarPlataformaMicro(PlataformaMicro alterarPlataforma, PlataformaMicro selecionadoPlataforma) throws Exception {
        NegocioPlataformaMicro negoPlataformaMicro = new NegocioPlataformaMicro();
        negoPlataformaMicro.alterarPlataformaMicro(alterarPlataforma, selecionadoPlataforma);
    }

    @Override
    public void removerPlataformaMicro(PlataformaMicro removerPlataforma) throws Exception {
        NegocioPlataformaMicro negoPlataformaMicro = new NegocioPlataformaMicro();
        negoPlataformaMicro.removerPlataformaMicro(removerPlataforma);
    }

    @Override
    public ArrayList<PlataformaMicro> listarPlataformaMicro(PlataformaMicro filtroPlataformaMicro) throws Exception {
        NegocioPlataformaMicro negocioFiltroPlataformaMicro = new NegocioPlataformaMicro();
        return negocioFiltroPlataformaMicro.listarPlataformaMicro(filtroPlataformaMicro);
    }

    //IMPLEMENTAR PROPRIETARIO MICRO:
    @Override
    public void cadastrarProprietarioMicro(ProprietarioMicro proprietarioMicro) throws Exception {
        NegocioProprietarioMicro negoPropMicro = new NegocioProprietarioMicro();
        negoPropMicro.cadastrarProprietarioMicro(proprietarioMicro);
    }

    @Override
    public ArrayList<ProprietarioMicro> listarProprietarioMicro(ProprietarioMicro filtroProprietarioMicro) throws Exception {
        NegocioProprietarioMicro negoPropMicro = new NegocioProprietarioMicro();
        return negoPropMicro.listarProprietarioMicro(filtroProprietarioMicro);
    }

    @Override
    public void alterarProprietarioMicro(ProprietarioMicro alterarProprietarioMicro, ProprietarioMicro selecionadoProprietarioMicro) throws Exception {
        NegocioProprietarioMicro negoPropMicro = new NegocioProprietarioMicro();
        negoPropMicro.alterarProprietarioMicro(alterarProprietarioMicro, selecionadoProprietarioMicro);
    }

    @Override
    public void removerProprietarioMicro(ProprietarioMicro removerProprietarioMicro) throws Exception {
        NegocioProprietarioMicro negoPropMicro = new NegocioProprietarioMicro();
        negoPropMicro.removerProprietarioMicro(removerProprietarioMicro);
    }

    //IMPLEMENTAR MARCA MONITOR:
    @Override
    public void cadastrarMarcaMonitor(MarcaMonitor marcaMonitor) throws Exception {
        NegocioMarcaMonitor negoMarcaMonitor = new NegocioMarcaMonitor();
        negoMarcaMonitor.cadastrarMarcaMonitor(marcaMonitor);
    }

    @Override
    public void alterarMarcaMonitor(MarcaMonitor alterarMarcaMonitor, MarcaMonitor selecionadoMarcaMonitor) throws Exception {
        NegocioMarcaMonitor negoMarcaMonitor = new NegocioMarcaMonitor();
        negoMarcaMonitor.alterarMarcaMonitor(alterarMarcaMonitor, selecionadoMarcaMonitor);
    }

    @Override
    public void removerMarcaMonitor(MarcaMonitor removerMarcaMonitor) throws Exception {
        NegocioMarcaMonitor negoMarcaMonitor = new NegocioMarcaMonitor();
        negoMarcaMonitor.removerMarcaMonitor(removerMarcaMonitor);
    }

    @Override
    public ArrayList<MarcaMonitor> listarMarcaMonitor(MarcaMonitor filtroMarcaMonitor) throws Exception {
        NegocioMarcaMonitor negocioFiltroMarcaMonitor = new NegocioMarcaMonitor();
        return negocioFiltroMarcaMonitor.listarMarcaMonitor(filtroMarcaMonitor);

    }

    //IMPLEMENTAR MODELO MONITOR:
    @Override
    public void cadastrarModeloMonitor(ModeloMonitor modeloMonitor) throws Exception {
        NegocioModeloMonitor negoModeloMonitor = new NegocioModeloMonitor();
        negoModeloMonitor.cadastrarModeloMonitor(modeloMonitor);
    }

    @Override
    public void alterarModeloMonitor(ModeloMonitor alterarModeloMonitor, ModeloMonitor selecionadoModeloMonitor) throws Exception {
        NegocioModeloMonitor negoModeloMonitor = new NegocioModeloMonitor();
        negoModeloMonitor.alterarModeloMonitor(alterarModeloMonitor, selecionadoModeloMonitor);
    }

    @Override
    public void removerModeloMonitor(ModeloMonitor removerModeloMonitor) throws Exception {
        NegocioModeloMonitor negoModeloMonitor = new NegocioModeloMonitor();
        negoModeloMonitor.removerModeloMonitor(removerModeloMonitor);
    }

    @Override
    public ArrayList<ModeloMonitor> listarModeloMonitor(ModeloMonitor filtroModeloMonitor) throws Exception {
        NegocioModeloMonitor negocioFiltroModeloMonitor = new NegocioModeloMonitor();
        return negocioFiltroModeloMonitor.listarModeloMonitor(filtroModeloMonitor);
    }

    //IMPLEMENTAR PROPRIETARIO MONITOR:
    @Override
    public void cadastrarProprietarioMonitor(ProprietarioMonitor proprietarioMonitor) throws Exception {
        NegocioProprietarioMonitor negoPropMonitor = new NegocioProprietarioMonitor();
        negoPropMonitor.cadastrarProprietarioMonitor(proprietarioMonitor);
    }

    @Override
    public void alterarProprietarioMonitor(ProprietarioMonitor alterarProprietarioMonitor, ProprietarioMonitor selecionadoProprietarioMonitor) throws Exception {
        NegocioProprietarioMonitor negoPropMonitor = new NegocioProprietarioMonitor();
        negoPropMonitor.alterarProprietarioMonitor(alterarProprietarioMonitor, selecionadoProprietarioMonitor);
    }

    @Override
    public void removerProprietarioMonitor(ProprietarioMonitor removerProprietarioMonitor) throws Exception {

        NegocioProprietarioMonitor negoPropMonitor = new NegocioProprietarioMonitor();
        negoPropMonitor.removerProprietarioMonitor(removerProprietarioMonitor);
    }

    @Override
    public ArrayList<ProprietarioMonitor> listarProprietarioMonitor(ProprietarioMonitor filtroProprietarioMonitor) throws Exception {
        NegocioProprietarioMonitor negocioFiltroProprietarioMonitor = new NegocioProprietarioMonitor();
        return negocioFiltroProprietarioMonitor.listarProprietarioMonitor(filtroProprietarioMonitor);
    }

    //MONITOR 2
     //IMPLEMENTAR MARCA MONITOR:
    
    public void cadastrarMarcaMonitor1(MarcaMonitor marcaMonitor) throws Exception {
        NegocioMarcaMonitor negoMarcaMonitor = new NegocioMarcaMonitor();
        negoMarcaMonitor.cadastrarMarcaMonitor(marcaMonitor);
    }

   
    public void alterarMarcaMonitor1(MarcaMonitor alterarMarcaMonitor, MarcaMonitor selecionadoMarcaMonitor) throws Exception {
        NegocioMarcaMonitor negoMarcaMonitor = new NegocioMarcaMonitor();
        negoMarcaMonitor.alterarMarcaMonitor(alterarMarcaMonitor, selecionadoMarcaMonitor);
    }


    public void removerMarcaMonitor1(MarcaMonitor removerMarcaMonitor) throws Exception {
        NegocioMarcaMonitor negoMarcaMonitor = new NegocioMarcaMonitor();
        negoMarcaMonitor.removerMarcaMonitor(removerMarcaMonitor);
    }

    public ArrayList<MarcaMonitor> listarMarcaMonitor1(MarcaMonitor filtroMarcaMonitor) throws Exception {
        NegocioMarcaMonitor negocioFiltroMarcaMonitor = new NegocioMarcaMonitor();
        return negocioFiltroMarcaMonitor.listarMarcaMonitor(filtroMarcaMonitor);

    }

    //IMPLEMENTAR MODELO MONITOR:
    
    public void cadastrarModeloMonitor1(ModeloMonitor modeloMonitor) throws Exception {
        NegocioModeloMonitor negoModeloMonitor = new NegocioModeloMonitor();
        negoModeloMonitor.cadastrarModeloMonitor(modeloMonitor);
    }

    
    public void alterarModeloMonitor1(ModeloMonitor alterarModeloMonitor, ModeloMonitor selecionadoModeloMonitor) throws Exception {
        NegocioModeloMonitor negoModeloMonitor = new NegocioModeloMonitor();
        negoModeloMonitor.alterarModeloMonitor(alterarModeloMonitor, selecionadoModeloMonitor);
    }

  
    public void removerModeloMonitor1(ModeloMonitor removerModeloMonitor) throws Exception {
        NegocioModeloMonitor negoModeloMonitor = new NegocioModeloMonitor();
        negoModeloMonitor.removerModeloMonitor(removerModeloMonitor);
    }

   
    public ArrayList<ModeloMonitor> listarModeloMonitor1(ModeloMonitor filtroModeloMonitor) throws Exception {
        NegocioModeloMonitor negocioFiltroModeloMonitor = new NegocioModeloMonitor();
        return negocioFiltroModeloMonitor.listarModeloMonitor(filtroModeloMonitor);
    }

    //IMPLEMENTAR PROPRIETARIO MONITOR:
  
    public void cadastrarProprietarioMonitor1(ProprietarioMonitor proprietarioMonitor) throws Exception {
        NegocioProprietarioMonitor negoPropMonitor = new NegocioProprietarioMonitor();
        negoPropMonitor.cadastrarProprietarioMonitor(proprietarioMonitor);
    }

  
    public void alterarProprietarioMonitor1(ProprietarioMonitor alterarProprietarioMonitor, ProprietarioMonitor selecionadoProprietarioMonitor) throws Exception {
        NegocioProprietarioMonitor negoPropMonitor = new NegocioProprietarioMonitor();
        negoPropMonitor.alterarProprietarioMonitor(alterarProprietarioMonitor, selecionadoProprietarioMonitor);
    }


    public void removerProprietarioMonitor1(ProprietarioMonitor removerProprietarioMonitor) throws Exception {

        NegocioProprietarioMonitor negoPropMonitor = new NegocioProprietarioMonitor();
        negoPropMonitor.removerProprietarioMonitor(removerProprietarioMonitor);
    }


    public ArrayList<ProprietarioMonitor> listarProprietarioMonitor1(ProprietarioMonitor filtroProprietarioMonitor) throws Exception {
        NegocioProprietarioMonitor negocioFiltroProprietarioMonitor = new NegocioProprietarioMonitor();
        return negocioFiltroProprietarioMonitor.listarProprietarioMonitor(filtroProprietarioMonitor);
    }
    //FIM DO MONITOR 2
    
    //IMPLEMENTAR CARGO:
    @Override
    public void cadastrarCargo(Cargo cargo) throws Exception {
        NegocioCargo negoCargo = new NegocioCargo();
        negoCargo.cadastrarCargo(cargo);
    }

    @Override
    public void alterarCargo(Cargo alterarCargo, Cargo selecionadoCargo) throws Exception {
        NegocioCargo negoCargo = new NegocioCargo();
        negoCargo.alterarCargo(alterarCargo, selecionadoCargo);
    }

    @Override
    public void removerCargo(Cargo removerCargo) throws Exception {
        NegocioCargo negoCargo = new NegocioCargo();
        negoCargo.removerCargo(removerCargo);
    }

    @Override
    public ArrayList<Cargo> listarCargo(Cargo filtroCargo) throws Exception {
        NegocioCargo negocioFiltroCargo = new NegocioCargo();
        return negocioFiltroCargo.listarCargo(filtroCargo);
    }

    //IMPLEMENTAR GERENCIA:
    @Override
    public void cadastrarGerencia(Gerencia gerencia) throws Exception {
        NegocioGerencia negoGerencia = new NegocioGerencia();
        negoGerencia.cadastrarGerencia(gerencia);
    }

    @Override
    public void alterarGerencia(Gerencia alterarGerencia, Gerencia selecionadoGerencia) throws Exception {
        NegocioGerencia negoGerencia = new NegocioGerencia();
        negoGerencia.alterarGerencia(alterarGerencia, selecionadoGerencia);
    }

    @Override
    public void removerGerencia(Gerencia removerGerencia) throws Exception {
        NegocioGerencia negoGerencia = new NegocioGerencia();
        negoGerencia.removerGerencia(removerGerencia);
    }

    @Override
    public ArrayList<Gerencia> listarGerencia(Gerencia filtroGerencia) throws Exception {
        NegocioGerencia negocioFiltroGerencia = new NegocioGerencia();
        return negocioFiltroGerencia.listarGerencia(filtroGerencia);
    }

    //IMPLEMENTAR PAVIMENTO:
    @Override
    public void cadastrarPavimento(Pavimento pavimento) throws Exception {
        NegocioPavimento negoPavimento = new NegocioPavimento();
        negoPavimento.cadastrarPavimento(pavimento);
    }

    @Override
    public void alterarPavimento(Pavimento alterarPavimento, Pavimento selecionadoPavimento) throws Exception {
        NegocioPavimento negoPavimento = new NegocioPavimento();
        negoPavimento.alterarPavimento(alterarPavimento, selecionadoPavimento);
    }

    @Override
    public void removerPavimento(Pavimento removerPavimento) throws Exception {
        NegocioPavimento negoPavimento = new NegocioPavimento();
        negoPavimento.removerPavimento(removerPavimento);
    }

    @Override
    public ArrayList<Pavimento> listarPavimento(Pavimento filtroPavimento) throws Exception {
        NegocioPavimento negocioFiltroPavimento = new NegocioPavimento();
        return negocioFiltroPavimento.listarPavimento(filtroPavimento);
    }

    @Override
    public ArrayList<Usuario> listarUsuarioTodosCampos(String filtroUserString) throws Exception {
        NegocioUsuario negocioFiltroUser = new NegocioUsuario();
        return negocioFiltroUser.listarUsuarioTodosCampos(filtroUserString);
    }

    @Override
    public void informarObservacao(Obs obs) throws Exception {
        NegocioUsuario negocioOBS = new NegocioUsuario();
        negocioOBS.informarObservacao(obs);
    }

    @Override
    public void alterarObservacao(Obs alterarObs, Obs selecionadoObs) throws Exception {
        NegocioUsuario negocioOBS = new NegocioUsuario();
        negocioOBS.alterarObservacao(alterarObs, selecionadoObs);
    }

    @Override
    public void removerObservacao(Obs removerObs) throws Exception {
        NegocioUsuario negocioOBS = new NegocioUsuario();
        negocioOBS.removerObservacao(removerObs);
    }

    @Override
    public ArrayList<Obs> listarObs(Obs filtroObs) throws Exception {
        NegocioUsuario negocioOBS = new NegocioUsuario();
        return negocioOBS.listarObs(filtroObs);
    }

    @Override
    public void cadastrarVersaoOffice(VersaoOffice versaoOffice) throws Exception {
        NegocioVersaoOffice negocioOffice = new NegocioVersaoOffice();
        negocioOffice.cadastrarVersaoOffice(versaoOffice);
    }

    @Override
    public void alterarVersaoOffice(VersaoOffice alterarVersaoOffice, VersaoOffice selecionadoVersaoOffice) throws Exception {
        NegocioVersaoOffice negocioalterarOffice = new NegocioVersaoOffice();
        negocioalterarOffice.alterarVersaoOffice(alterarVersaoOffice, selecionadoVersaoOffice);
    }

    @Override
    public void removerVersaoOffice(VersaoOffice removerVersaoOffice) throws Exception {
        NegocioVersaoOffice negocioremoverOffice = new NegocioVersaoOffice();
        negocioremoverOffice.removerVersaoOffice(removerVersaoOffice);
    }

    @Override
    public ArrayList<VersaoOffice> listarVersaoOffice(VersaoOffice filtroVersaoOffice) throws Exception {
        NegocioVersaoOffice negocioListarOffice = new NegocioVersaoOffice();
        return negocioListarOffice.listarVersaoOffice(filtroVersaoOffice);
    }

    @Override
    public void cadastrarLogin(LoginUser loginUser) throws Exception {
        NegocioLogin negocioCadastrarLogin = new NegocioLogin();
        negocioCadastrarLogin.cadastrarLogin(loginUser);
    }

    @Override
    public void alterarLoginSenha(LoginUser alterarLoginUser, LoginUser selecionadoLoginUser) throws Exception {
        NegocioLogin negocioLogin = new NegocioLogin();
        negocioLogin.alterarLoginSenha(alterarLoginUser, selecionadoLoginUser);
    }

    @Override
    public void removerLogin(LoginUser removerLoginUser) throws Exception {
        NegocioLogin negocioLogin = new NegocioLogin();
        negocioLogin.removerLogin(removerLoginUser);
    }

    @Override
    public ArrayList<LoginUser> listarLogins(LoginUser filtroLoginUser) throws Exception {
        NegocioLogin negocioLogin = new NegocioLogin();
        return negocioLogin.listarLogins(filtroLoginUser);
    }

    @Override
    public LoginUser logarSadEquip(LoginUser logar) throws Exception {
        NegocioLogin negocioLogin = new NegocioLogin();
        return negocioLogin.logarSadEquip(logar);
    }

    @Override
    public void verificaLogin(LoginUser loginUser) throws Exception {
        NegocioLogin negocioVerifica = new NegocioLogin();
        negocioVerifica.verificaLogin(loginUser);
    }

    @Override
    public void resetarSenha(LoginUser loginUser) throws Exception {
        NegocioLogin negocioResetar = new NegocioLogin();
        negocioResetar.resetarSenha(loginUser);
    }

    @Override
    public void verificarDadosCadastrar(Usuario user) throws Exception {
        NegocioUsuario negocioVerificarDados = new NegocioUsuario();
        negocioVerificarDados.verificarDadosCadastrar(user);
    }

    @Override
    public void alternarNotebookPC(Usuario user) throws Exception {
        NegocioUsuario negocio = new NegocioUsuario();
        negocio.alternarNotebookPC(user);
    }

    @Override
    public void cadastrarEquipamentos(Equipamentos equip) throws Exception {
        NegocioEquipamentos.getInstancia().cadastrarEquipamentos(equip);
    }

    @Override
    public void alterarEquipamentos(Equipamentos alterEquip, Equipamentos selecionado) throws Exception {
        NegocioEquipamentos.getInstancia().alterarEquipamentos(alterEquip, selecionado);
    }

    @Override
    public void removerEquipamentos(Equipamentos removeEquip) throws Exception {
        NegocioEquipamentos.getInstancia().removerEquipamentos(removeEquip);
    }

    @Override
    public ArrayList<Equipamentos> listaFiltroEquipamentos(String filtroEquip, String selecionado) throws Exception {
        return NegocioEquipamentos.getInstancia().listaFiltroEquipamentos(filtroEquip, selecionado);
    }
    
     @Override
    public ArrayList<Equipamentos> listaTudoEquip() throws Exception {
        return NegocioEquipamentos.getInstancia().listaTudoEquip();
    }
    
     @Override
    public void alterarTombEquipamentos(Equipamentos tomb, Equipamentos selecionado) throws Exception {
        NegocioEquipamentos.getInstancia().alterarTombEquipamentos(tomb, selecionado);
    }


    @Override
    public ArrayList<Fornecedor> listaEscolherForn() throws Exception {
        return NegocioFornecedor.getInstancia().listaFornecedor();
    }

    @Override
    public void cadastrarFornecedor(Fornecedor forn) throws Exception {
        NegocioFornecedor.getInstancia().cadastrarFornecedor(forn);
    }

    @Override
    public void alterarFornecedor(Fornecedor altForn, Fornecedor selecionado) throws Exception {
        NegocioFornecedor.getInstancia().alterarFornecedor(altForn, selecionado);
    }

    @Override
    public void removerFornecedor(Fornecedor remoForn) throws Exception {
        NegocioFornecedor.getInstancia().removerFornecedor(remoForn);
    }

    @Override
    public ArrayList<Fornecedor> listaFornecedor() throws Exception {
        return NegocioFornecedor.getInstancia().listaFornecedor();
    }

    @Override
    public ArrayList<Fornecedor> listaFiltroForn(String filtroForn) throws Exception {
        return NegocioFornecedor.getInstancia().listaFiltroForn(filtroForn);
    }

    //CADASTRANDO A NOTA FISCAL
    @Override
    public void CadastrarNF(NotaFiscal nfHp) throws Exception {
        NegocioNotaFiscal.getInstancia().CadastrarNF(nfHp);
    }

    @Override
    public void AlterarNF(NotaFiscal alterNfHp, NotaFiscal selecionado) throws Exception {
        NegocioNotaFiscal.getInstancia().AlterarNF(alterNfHp, selecionado);
    }

    @Override
    public void RemoverNF(NotaFiscal remoNfHp) throws Exception {
        NegocioNotaFiscal.getInstancia().RemoverNF(remoNfHp);
    }

    @Override
    public ArrayList<NotaFiscal> listaNotaFiscal() throws Exception {
        return NegocioNotaFiscal.getInstancia().listaNotaFiscal();
    }

    @Override
    public ArrayList<NotaFiscal> listaFiltroNF(String filtroNF, String selecionado) throws Exception {
        return NegocioNotaFiscal.getInstancia().listaFiltroNF(filtroNF, selecionado);
    }

    @Override
    public ArrayList<Fornecedor> listaForn() throws Exception {
        return NegocioNotaFiscal.getInstancia().listaForn();
    }

    @Override
    public void CadastrarItensDaNota(ItensDaNota item) throws Exception {
        NegocioItensDaNota.getInstancia().CadastrarItensDaNota(item);
    }

    @Override
    public ArrayList<Equipamentos> listaEquip(String cnpj) throws Exception {
        return NegocioItensDaNota.getInstancia().listaEquip(cnpj);
    }

    @Override
    public ArrayList<ItensDaNota> listaItensDaNota(int nf) throws Exception {
        return NegocioItensDaNota.getInstancia().listaItensDaNota(nf);
    }

    @Override
    public ArrayList<Equipamentos> listaFiltroEquip(String filtroEquip) throws Exception {
       return NegocioItensDaNota.getInstancia().listaFiltroEquip(filtroEquip);
    }

    @Override
    public void RemoverItensDaNota(ItensDaNota remoItens) throws Exception {
        NegocioItensDaNota.getInstancia().RemoverItensDaNota(remoItens);
    }

   
}
