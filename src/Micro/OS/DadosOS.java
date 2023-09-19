/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Micro.OS;

import Geral.ConectarSQL;
import Micro.MarcaMicro.MarcaMicro;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Posseidon
 */
public class DadosOS extends ConectarSQL implements InterfaceOS {

    @Override
    public void cadastrarOS(OS os) throws Exception {
      try {
        Statement conex = conectar();

        
        String sqlValida = "select so ";
        sqlValida += " from Sistema where so = '"+ os.getOs()+"';";
        ResultSet rs = conex.executeQuery(sqlValida);
       
        while (rs.next()) {
            throw new Exception("Já existe Sistema Operacional cadastrado com esta descrição!");
        }
        
            
        String sql = "INSERT INTO Sistema (so)";
        sql += "VALUES ('"+os.getOs()+"');";
        
            conex.execute(sql);
        } catch (SQLException e) {
            
            throw new Exception("Erro - "+e.getMessage());
        }
        
        desconectar();
    }

    @Override
    public void alterarOS(OS alterarOS, OS selecionadoOS) throws Exception {
         try {
             
      Statement conex = conectar();
            String sql = "UPDATE Sistema SET ";
            sql+= "so='"+alterarOS.getOs()+"' ";
            sql+= " WHERE id_so="+selecionadoOS.getIdOS()+";" ;
            
            
            conex.execute(sql);
        }catch (SQLException ex) {
                //caso haja algum erro neste método será levantada esta execeção
            throw new Exception(ex.getMessage());
        }
            //fechando a conexão com o banco de dados
        desconectar();  
    }

    @Override
    public void removerOS(OS removerOS) throws Exception {
       try {
                Statement conex = conectar();
                     
                String sql = "DELETE Sistema WHERE id_so= "+ removerOS.getIdOS();
                    //executando a instrução sql
                conex.execute(sql);
            } catch (SQLException e) {
                    //caso haja algum erro neste método será levantada esta execeção
                throw new Exception(e.getMessage());
            }
                //fechando a conexão com o banco de dados
            desconectar();
    }

    @Override
    public ArrayList<OS> listarOS(OS filtroOS) throws Exception {
        
        ArrayList<OS> listaOS = new ArrayList<OS>(); 

            try {     

                Statement conex = conectar();
               
                String sql = "select * from Sistema";
                sql += " where so=so ";
                
                if ((filtroOS.getOs().trim().equals("")) == false) {
                    sql += " and so LIKE '%" + filtroOS.getOs().trim() + "%'";
                } 
                    
                sql+= " order by so";
                
                ResultSet rs = conex.executeQuery(sql);
                      
                while (rs.next()) {                
                    OS os = new OS();
                    os.setIdOS(rs.getInt("id_so"));
                    os.setOs(rs.getString("so"));
                            
                  listaOS.add(os);    
                  
                }
            } catch (SQLException e) {
                    
                throw new Exception("Erro ao executar Consulta/Listagem: " + e.getMessage());
            }
                
            desconectar();
                
            return listaOS;
            
    }
    
}
