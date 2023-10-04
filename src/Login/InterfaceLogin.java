/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import java.util.ArrayList;

/**
 *
 * @author airton.oliveira
 */
public interface InterfaceLogin {
    
    void cadastrarLogin (LoginUser loginUser) throws Exception;
    void alterarLoginSenha(LoginUser alterarLoginUser , LoginUser selecionadoLoginUser) throws Exception;
    void removerLogin (LoginUser removerLoginUser) throws Exception;
    ArrayList<LoginUser> listarLogins(LoginUser filtroLoginUser) throws Exception;  
    LoginUser logarSadEquip (LoginUser logar) throws Exception;
    void verificaLogin(LoginUser loginUser) throws Exception;
    void resetarSenha(LoginUser loginUser) throws Exception;
 
}
