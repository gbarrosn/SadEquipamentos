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
public class NegocioLogin implements InterfaceLogin{

    @Override
    public void cadastrarLogin(LoginUser loginUser) throws Exception {
        
        if (loginUser.getLogin().trim().equals("")){
          throw new Exception ("Informe um login para o usuário!");  
        }
        
        if (loginUser.getSenha().trim().equals("")){
          throw new Exception ("Informe uma senha para o usuário!");  
        }
        
        DadosLogin dadosCadastrar = new DadosLogin();
        dadosCadastrar.cadastrarLogin(loginUser);
        
    }

    @Override
    public void alterarLoginSenha(LoginUser alterarLoginUser, LoginUser selecionadoLoginUser) throws Exception {
       if (alterarLoginUser.getLogin().trim().equals(selecionadoLoginUser.getLogin())&&
               alterarLoginUser.getSenha().trim().equals(selecionadoLoginUser.getSenha())&&
               alterarLoginUser.getAdm().equals(selecionadoLoginUser.getAdm()))
       {
       throw new Exception("Não houve alterações, mude alguma informação do login ou clique em Voltar.");
       }
       
       
       
          if (alterarLoginUser.getLogin().trim().equals("")){
          throw new Exception ("Informe um login para o usuário!");  
        }
        
        if (alterarLoginUser.getSenha().trim().equals("")){
          throw new Exception ("Informe uma senha para o usuário!");  
        }
        
         if (alterarLoginUser.getSenha().trim().equals("0")){
          throw new Exception ("Informe uma senha para o usuário!");  
        }
        
        DadosLogin dadosAlterar = new DadosLogin();
        dadosAlterar.alterarLoginSenha(alterarLoginUser, selecionadoLoginUser);
        
    }

    @Override
    public void removerLogin(LoginUser removerLoginUser) throws Exception {
       DadosLogin dadosRemover = new DadosLogin();
       dadosRemover.removerLogin(removerLoginUser);
    }

    @Override
    public ArrayList<LoginUser> listarLogins(LoginUser filtroLoginUser) throws Exception {
        DadosLogin dadosListar = new DadosLogin();
        return dadosListar.listarLogins(filtroLoginUser);
    }

    @Override
    public LoginUser logarSadEquip(LoginUser logar) throws Exception {
        
        if (logar.getLogin().trim().equals("")){
          throw new Exception ("Login não informado!");  
        }
        
        if (logar.getSenha().trim().equals("0")){
          throw new Exception ("Senha não informada!");  
        }
        
        if (logar.getSenha().trim().equals("")){
          throw new Exception ("Senha não informada!");  
        }
        
        DadosLogin dadosLogar = new DadosLogin();
        return dadosLogar.logarSadEquip(logar);
    }

    @Override
    public void verificaLogin(LoginUser loginUser) throws Exception {
       DadosLogin dados = new DadosLogin();
       dados.verificaLogin(loginUser);
    }

    @Override
    public void resetarSenha(LoginUser loginUser) throws Exception {
       DadosLogin dados = new DadosLogin();
       dados.resetarSenha(loginUser);
    }
    
}
