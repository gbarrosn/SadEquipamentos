/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import Geral.ConectarSQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author airton.oliveira
 */
public class DadosLogin extends ConectarSQL implements InterfaceLogin{

    @Override
    public void verificaLogin(LoginUser loginUser) throws Exception{
        
        try{
        Connection conectarSQL = conectarPrepared();
        PreparedStatement conex = conectarSQL.prepareStatement("select * from LoginEquip where usuario=(?)");
        conex.setString(1, loginUser.getLogin());
        ResultSet rs = conex.executeQuery(); 
        
        while (rs.next()) {
            throw new Exception("Este LOGIN já está cadastrado no sistema.");
        }

        
        }catch (SQLException e) {
            throw new Exception("Erro ao se conectar ao servidor.");
        }
        
        desconectar();
    }
    
    @Override
    public void cadastrarLogin(LoginUser loginUser) throws Exception {
       
      try {
           
          
        Connection conectarSQL = conectarPrepared();
        PreparedStatement conex = conectarSQL.prepareStatement("INSERT INTO LoginEquip (usuario,senha,adm) Values (?,?,?)");
        conex.setString(1, loginUser.getLogin());
        conex.setString(2, loginUser.getSenha());
        conex.setString(3, loginUser.getAdm());
        conex.executeUpdate();
        
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Erro ao se conectar ao servidor.");
        }
        
        desconectar();
    }

    @Override
    public void alterarLoginSenha(LoginUser alterarLoginUser, LoginUser selecionadoLoginUser) throws Exception {
         try {
                        
        Connection conectarSQL = conectarPrepared();
        String sql;
        sql =  "UPDATE LoginEquip SET usuario = (?), senha = (?), adm = (?)";
        sql += "where id_login = (?)";
        PreparedStatement conex = conectarSQL.prepareStatement(sql);
        conex.setString(1, alterarLoginUser.getLogin());
        conex.setString(2, alterarLoginUser.getSenha());
        conex.setString(3, alterarLoginUser.getAdm());
        conex.setInt(4, selecionadoLoginUser.getId_login());
        conex.executeUpdate();
        
        }catch (SQLException ex) {
                //caso haja algum erro neste método será levantada esta execeção
            throw new Exception("Erro ao se conectar ao servidor.");
        }
            //fechando a conexão com o banco de dados
        desconectar(); 
    }

    @Override
    public void removerLogin(LoginUser removerLoginUser) throws Exception {
        try {
                
        Connection conectarSQL = conectarPrepared();
        PreparedStatement conex = conectarSQL.prepareStatement("DELETE LoginEquip WHERE id_login = (?)");
        conex.setInt(1, removerLoginUser.getId_login());
        conex.executeUpdate();       
        
            } catch (SQLException e) {
                    //caso haja algum erro neste método será levantada esta execeção
                throw new Exception("Erro ao se conectar ao servidor.");
            }
                //fechando a conexão com o banco de dados
            desconectar();
    }

    @Override
    public ArrayList<LoginUser> listarLogins(LoginUser filtroLoginUser) throws Exception {
         
        ArrayList<LoginUser> listaLogins = new ArrayList<LoginUser>(); 
        PreparedStatement conex = null;

       try {     
                
        Connection conectarSQL = conectarPrepared();
        String sql =  "select * from LoginEquip ";              
        sql += "where id_login=id_login ";
                
        //FILTROS DE PESQUISA VINDOS DO FORMULÁRIO
        if ((filtroLoginUser.getLogin().trim().equals("")) == false) {
           sql += " and usuario LIKE (?)";                
        }
        
        sql += " order by adm desc";
                
        //STATEMENT
        conex = conectarSQL.prepareStatement(sql);
        
        
        //DEFININDO VALOR DOS FILTROS NA QUERY
        if ((filtroLoginUser.getLogin().trim().equals("")) == false) {
         conex.setString(1, "%"+filtroLoginUser.getLogin()+"%");           
        }
        
        
        //RECEBENDO DADOS
        ResultSet rs = conex.executeQuery();    
        while (rs.next()) {   
            
                    LoginUser loginUser = new LoginUser();
                    loginUser.setId_login(rs.getInt("id_login"));
                    loginUser.setLogin(rs.getString("usuario"));
                    loginUser.setSenha(rs.getString("senha"));
                    loginUser.setAdm(rs.getString("adm"));
                           
        listaLogins.add(loginUser);  
        
        }
        
            } catch (SQLException e) {
                    
                throw new Exception("Erro ao executar Consulta/Listagem: Não foi possível se conectar ao servidor.");
            }
                
            desconectar();
                
            return listaLogins;
    }

    @Override
    public LoginUser logarSadEquip(LoginUser logar) throws Exception {
      
        LoginUser logado= new LoginUser();
        //boolean valida=false;
        
        try {
                        
        Connection conectarSQL = conectarPrepared();
        String sql;
        sql =  "Select * from LoginEquip";
        sql += " where LoginEquip.usuario = ? and LoginEquip.senha = ?";
        PreparedStatement conex = conectarSQL.prepareStatement(sql);
        conex.setString(1, logar.getLogin());
        conex.setString(2, logar.getSenha());
        
                                                                                                                                                                                                                                              ResultSet rs = conex.executeQuery();  
        
        if (rs.next()==true){
            logado.setId_login(rs.getInt("id_login"));
            logado.setLogin(rs.getString("usuario"));
            logado.setSenha(rs.getString("senha"));
            logado.setAdm(rs.getString("adm"));
            logado.setLoga("sim");
        }else{
            logado.setLoga("nao");
        }
        
        
        
        }catch (SQLException ex) {
            ex.printStackTrace();
                //caso haja algum erro neste método será levantada esta execeção
            throw new Exception("Erro ao se conectar ao servidor.");
        }
         
        
        //fechando a conexão com o banco de dados
        desconectar(); 
        
        return logado;
        
    }

    @Override
    public void resetarSenha(LoginUser loginUser) throws Exception {
        
      try {
                        
        Connection conectarSQL = conectarPrepared();
        String sql;
        sql =  "UPDATE LoginEquip SET senha = '113622'";
        sql += "where id_login = (?)";
        PreparedStatement conex = conectarSQL.prepareStatement(sql);
        conex.setInt(1, loginUser.getId_login());
  
        conex.executeUpdate();
        
        }catch (SQLException ex) {
                //caso haja algum erro neste método será levantada esta execeção
            throw new Exception("Erro ao se conectar ao servidor.");
        }
            //fechando a conexão com o banco de dados
        desconectar(); 
    }
    
}
