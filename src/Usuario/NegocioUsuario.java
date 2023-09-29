/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuario;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author Posseidon
 */
public class NegocioUsuario implements InterfaceUsuario {

    @Override
    public void cadastrarUsuario(Usuario user) throws Exception {

        //Tombos e Etiqueta:
        if (user.getTombamentoMicro() <= 0) {
            throw new Exception("Erro - Campo Tombamento do Micro: Não preencha com zero ou valores negativos.");
        }
        
        //***********************************************************
        if ((user.getNovoTomboMicro().trim().equalsIgnoreCase(""))) {
                throw new Exception("Preencha o campo Novo Tombo do Micro!");
        }
        
        if ((user.getNotebook().equals("não"))) {
            if ((user.getNovoTomboMonitor().trim().equalsIgnoreCase(""))) {
                throw new Exception("Preencha o campo Novo Tombo do Monitor!");
            }
        }
        
        if ((user.getNotebook().equals("não"))) {
            if ((user.getTombamentoMonitor() <= 0)) {
                throw new Exception("Erro - Campo Tombamento do Monitor: Não preencha com zero ou valores negativos.");
            }
        }
        if (user.getEtiquetaCESU() <= 0) {
            throw new Exception("Erro - Campo Etiqueta CMTECH: Não preencha com zero ou valores negativos.");
        }

        //Strings - Nome:
        if (user.getNome() == null) {
            throw new Exception("Preencha o campo Nome");
        }
        if (user.getNome().trim().equals("") == true) {
            throw new Exception("Preencha o campo Nome");
        }
        if (user.getNome().length() > 27) {
            throw new Exception("O Nome do Usuário deve possuir no máximo 27 caracteres.\nEspaços em branco também são considerados caracteres.");
        }
        //Strings - Host Name:
        if (user.getNomepc() == null) {
            throw new Exception("Preencha o campo Host Name");
        }
        if (user.getNomepc().trim().equals("") == true) {
            throw new Exception("Preencha o campo Host Name");
        }
        if (user.getNomepc().length() > 16) {
            throw new Exception("O Host Name deve possuir no máximo 16 caracteres.\nEspaços em branco também são considerados caracteres.");
        }
        //Strings - Serie Micro:
        if (user.getSerieMicro() == null) {
            throw new Exception("Preencha o campo Série Micro");
        }
        if (user.getSerieMicro().trim().equals("") == true) {
            throw new Exception("Preencha o campo Série Micro");
        }
        //13
        if (user.getSerieMicro().length() > 15) {
            throw new Exception("O Nº de Serie do Gabinete deve possuir no máximo 15 caracteres.\nEspaços em branco também são considerados caracteres.");
        }
        //Strings - Serie Monitor:
        if ((user.getSerieMonitor() == null) && ((user.getNotebook().equals("não")))) {
            throw new Exception("Preencha o campo Série Monitor");
        }
        if ((user.getSerieMonitor().trim().equals("") == true) && ((user.getNotebook().equals("não")))) {
            throw new Exception("Preencha o campo Série Monitor");
        }
        if (user.getSerieMonitor().length() > 15) {
            throw new Exception("O Nº de Serie do Monitor deve possuir no máximo 15 caracteres.\nEspaços em branco também são considerados caracteres.");
        }
        //Strings - Garantia:
        if (user.getGarantia() == null) {
            throw new Exception("Preencha o campo Garantia");
        }
        if (user.getGarantia().trim().equals("") == true) {
            throw new Exception("Preencha o campo Garantia");
        }
                

        //Verifica duplicidade dos dados.
        verificarDadosCadastrar(user);
        
        DadosUsuario userDados = new DadosUsuario();
        userDados.cadastrarUsuario(user);
    }

    @Override
    public void alterarUsuario(Usuario alterarUser, Usuario selecionadoUser) throws Exception {
        if ((alterarUser.getNome().equals(selecionadoUser.getNome()))
                && (alterarUser.getGerencia().getIdGerencia() == selecionadoUser.getGerencia().getIdGerencia())
                && (alterarUser.getCargo().getIdCargo() == selecionadoUser.getCargo().getIdCargo())
                && (alterarUser.getPavimentoUsuario().getIdPavimento() == selecionadoUser.getPavimentoUsuario().getIdPavimento())
                && (alterarUser.getNomepc().equals(selecionadoUser.getNomepc()))
                && (alterarUser.getTombamentoMicro() == (selecionadoUser.getTombamentoMicro()))
                && (alterarUser.getSerieMicro().equals(selecionadoUser.getSerieMicro()))
                && (alterarUser.getConfigMicro().getIdConfiguracao() == selecionadoUser.getConfigMicro().getIdConfiguracao())
                && (alterarUser.getModeloMicro().getIdModelo() == selecionadoUser.getModeloMicro().getIdModelo())
                && (alterarUser.getPlataformaMicro().getIdPlataforma() == selecionadoUser.getPlataformaMicro().getIdPlataforma())
                && (alterarUser.getProprietarioMicro().getIdProprietario() == selecionadoUser.getProprietarioMicro().getIdProprietario())
                && (alterarUser.getOsMicro().getIdOS() == selecionadoUser.getOsMicro().getIdOS())
                && (alterarUser.getTombamentoMonitor() == selecionadoUser.getTombamentoMonitor())
                && (alterarUser.getSerieMonitor().equals(selecionadoUser.getSerieMonitor()))
                && (alterarUser.getModeloMonitor().getIdModelo() == selecionadoUser.getModeloMonitor().getIdModelo())
                && (alterarUser.getMarcaMonitor().getIdMarca() == selecionadoUser.getMarcaMonitor().getIdMarca())
                && (alterarUser.getProprietarioMonitor().getIdProprietario() == selecionadoUser.getProprietarioMonitor().getIdProprietario())
                && (alterarUser.getGarantia().equals(selecionadoUser.getGarantia()))
                && (alterarUser.getEtiquetaCESU() == selecionadoUser.getEtiquetaCESU())
                && (alterarUser.getEtiquetaSAD() == selecionadoUser.getEtiquetaSAD())
                && (alterarUser.getVersao_office().getId_versao_office() == selecionadoUser.getVersao_office().getId_versao_office())
                && (alterarUser.getEstoque() == selecionadoUser.getEstoque())
                && (Objects.equals(alterarUser.getTermo_responsabilidade(), selecionadoUser.getTermo_responsabilidade()))) {

            throw new Exception("Não houve nenhuma alteração no Usuário.");
        }

        //Tombos e Etiqueta:
        if (alterarUser.getTombamentoMicro() <= 0) {
            throw new Exception("Campo Obrigatório: Preencha corretamente o campo Tombamento do Micro! (use apenas números inteiros)");
        }
        
        //***********************************************************
        /*if ((alterarUser.getNovoTomboMicro().trim().equalsIgnoreCase(""))) {
                throw new Exception("Preencha o campo Novo Tombo do Micro!");
        }*/
        
        if ((alterarUser.getNotebook().equals("não"))) {
            if ((alterarUser.getNovoTomboMonitor().trim().equalsIgnoreCase(""))) {
                throw new Exception("Preencha o campo Novo Tombo do Monitor!");
            }
        }
        
        //VALIDAÇÃO PARA NOTEBOOK
        if ((alterarUser.getNotebook().equals("não"))) {

            if (alterarUser.getTombamentoMonitor() <= 0) {
                throw new Exception("Campo Obrigatório: Preencha corretamente o campo Tombamento do Monitor! (use apenas números inteiros)");
            }

        }
        if (alterarUser.getEtiquetaCESU() <= 0) {
            throw new Exception("Campo Obrigatório: Preencha corretamente o campo Etiqueta CMTECH! (use apenas números inteiros)");
        }

        //Strings - Nome:
        if (alterarUser.getNome() == null) {
            throw new Exception("Preencha o campo Nome");
        }
        if (alterarUser.getNome().trim().equals("") == true) {
            throw new Exception("Preencha o campo Nome");
        }
        if (alterarUser.getNome().length() > 27) {
            throw new Exception("O Nome do Usuário deve possuir no máximo 27 caracteres.\nEspaços em branco também são considerados caracteres.");
        }
        //Strings - Host Name:
        if (alterarUser.getNomepc() == null) {
            throw new Exception("Preencha o campo Host Name");
        }
        if (alterarUser.getNomepc().trim().equals("") == true) {
            throw new Exception("Preencha o campo Host Name");
        }
        if (alterarUser.getNomepc().length() > 16) {
            throw new Exception("O Host Name deve possuir no máximo 16 caracteres.\nEspaços em branco também são considerados caracteres.");
        }
        //Strings - Serie Micro:
        if (alterarUser.getSerieMicro() == null) {
            throw new Exception("Preencha o campo Série Micro");
        }
        if (alterarUser.getSerieMicro().trim().equals("") == true) {
            throw new Exception("Preencha o campo Série Micro");
        }
        if (alterarUser.getSerieMicro().length() > 15) {
            throw new Exception("O Nº de Serie do Gabinete deve possuir no máximo 15 caracteres.\nEspaços em branco também são considerados caracteres.");
        }
        //Strings - Serie Monitor:

        if ((alterarUser.getNotebook().equals("não"))) {
            if (alterarUser.getSerieMonitor() == null) {
                throw new Exception("Preencha o campo Série Monitor");
            }
        }
        if ((alterarUser.getNotebook().equals("não"))) {
            if (alterarUser.getSerieMonitor().trim().equals("") == true) {
                throw new Exception("Preencha o campo Série Monitor");
            }
        }
        if (alterarUser.getSerieMonitor().length() > 15) {
            throw new Exception("O Nº de Serie do Monitor deve possuir no máximo 15 caracteres.\nEspaços em branco também são considerados caracteres.");
        }
        //Strings - Garantia:
        if (alterarUser.getGarantia() == null) {
            throw new Exception("Preencha o campo Garantia");
        }
        if (alterarUser.getGarantia().trim().equals("") == true) {
            throw new Exception("Preencha o campo Garantia");
        }

        
         //Verifica duplicidade dos dados.
        verificarDadosCadastrar(alterarUser);
        
        DadosUsuario userDados = new DadosUsuario();
        userDados.alterarUsuario(alterarUser, selecionadoUser);

    }

    @Override
    public void removerUsuario(Usuario removerUser) throws Exception {
        //Falta implementar.

        DadosUsuario userDados = new DadosUsuario();
        userDados.removerUsuario(removerUser);

    }

    @Override
    public ArrayList<Usuario> listarUsuario(Usuario filtroUser) throws Exception {
        
        DadosUsuario userFilterDados = new DadosUsuario();
        return userFilterDados.listarUsuario(filtroUser);

    }

    @Override
    public ArrayList<Usuario> listarUsuarioTodosCampos(String filtroUserString) throws Exception {

        if (filtroUserString.trim().equals("") == true) {
            throw new Exception("Informe algum valor para a pesquisa!");
        }

        if (filtroUserString == null) {
            throw new Exception("Informe algum valor para a pesquisa!");
        }

        DadosUsuario userFilterDados = new DadosUsuario();
        return userFilterDados.listarUsuarioTodosCampos(filtroUserString);
    }

    //CLASSE OBSERVAÇÃO
    @Override
    public void informarObservacao(Obs obs) throws Exception {
        if (obs.getObs().trim().equals("") == true) {
            throw new Exception("Informe qual é a observação!");
        }

        DadosUsuario dados = new DadosUsuario();
        dados.informarObservacao(obs);
    }

    @Override
    public void alterarObservacao(Obs alterarObs, Obs selecionadoObs) throws Exception {
        if (alterarObs.getObs().trim().equals("") == true) {
            throw new Exception(" A observação não pode estar vazia!");
        }

        if (alterarObs.getObs().equals(selecionadoObs.getObs())) {
            throw new Exception(" Não houve nenhuma alteração na observação!");
        }

        DadosUsuario dados = new DadosUsuario();
        dados.alterarObservacao(alterarObs, selecionadoObs);
    }

    @Override
    public void removerObservacao(Obs removerObs) throws Exception {
        DadosUsuario dados = new DadosUsuario();
        dados.removerObservacao(removerObs);
    }

    @Override
    public ArrayList<Obs> listarObs(Obs filtroObs) throws Exception {
        DadosUsuario dados = new DadosUsuario();
        return dados.listarObs(filtroObs);
    }

    @Override
    public void verificarDadosCadastrar(Usuario user) throws Exception {
        DadosUsuario dadosVerificar = new DadosUsuario();
        dadosVerificar.verificarDadosCadastrar(user);

    }

    @Override
    public void alternarNotebookPC(Usuario user) throws Exception {
       DadosUsuario dados = new DadosUsuario();
       dados.alternarNotebookPC(user);
    }

}
