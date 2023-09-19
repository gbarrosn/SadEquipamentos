/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Usuario;

import java.util.ArrayList;

/**
 *
 * @author Posseidon
 */
public interface InterfaceUsuario {
    void cadastrarUsuario (Usuario user) throws Exception;
    void alterarUsuario(Usuario alterarUser , Usuario selecionadoUser) throws Exception;
    void removerUsuario (Usuario removerUser) throws Exception;
    ArrayList<Usuario> listarUsuario(Usuario filtroUser) throws Exception;
    ArrayList<Usuario>listarUsuarioTodosCampos(String filtroUserString) throws Exception;
    void verificarDadosCadastrar (Usuario user) throws Exception;
    void alternarNotebookPC(Usuario user) throws Exception;
            
    //OBS
    void informarObservacao (Obs obs) throws Exception;
    void alterarObservacao(Obs alterarObs , Obs selecionadoObs) throws Exception;
    void removerObservacao (Obs removerObs) throws Exception;
    ArrayList<Obs> listarObs(Obs filtroObs) throws Exception;
}
