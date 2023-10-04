/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Micro.PlataformaMicro;

import Geral.ConectarSQL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Posseidon
 */
public class DadosPlataformaMicro extends ConectarSQL implements InterfacePlataformaMicro{

    @Override
    public void cadastrarPlataformaMicro(PlataformaMicro plataforma) throws Exception {
     
        try {
        Statement conex = conectar();

        
        String sqlValida = "select plataforma ";
        sqlValida += " from Plataforma where plataforma = '"+ plataforma.getPlataforma()+"';";
        ResultSet rs = conex.executeQuery(sqlValida);
       
        while (rs.next()) {
            throw new Exception("Já existe Plataforma cadastrada com esta descrição.");
        }
        
            
        String sql = "INSERT INTO Plataforma (plataforma)";
        sql += "VALUES ('"+plataforma.getPlataforma()+"');";
        
            conex.execute(sql);
        } catch (SQLException e) {
            
            throw new Exception("Erro - "+e.getMessage());
        }
        
        desconectar();
    }

    @Override
    public void alterarPlataformaMicro(PlataformaMicro alterarPlataforma, PlataformaMicro selecionadoPlataforma) throws Exception {
       
        try {
            
            Statement conex = conectar();
            String sql = "UPDATE Plataforma SET ";
            sql+= "plataforma='"+alterarPlataforma.getPlataforma()+"' ";
            sql+= " WHERE id_plataforma="+selecionadoPlataforma.getIdPlataforma()+";" ;
            
            
            conex.execute(sql);
        }catch (SQLException ex) {
                //caso haja algum erro neste método será levantada esta execeção
            throw new Exception(ex.getMessage());
        }
            //fechando a conexão com o banco de dados
        desconectar(); 
    }

    @Override
    public void removerPlataformaMicro(PlataformaMicro removerPlataforma) throws Exception {
       
        try {
                Statement conex = conectar();
                     
                String sql = "DELETE Plataforma WHERE id_plataforma= "+ removerPlataforma.getIdPlataforma();
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
    public ArrayList<PlataformaMicro> listarPlataformaMicro(PlataformaMicro filtroPlataformaMicro) throws Exception {
         
        ArrayList<PlataformaMicro> listaPlataformaMicros = new ArrayList<PlataformaMicro>(); 

            try {     

                Statement conex = conectar();
               
                String sql = "select * from Plataforma";
                sql += " where plataforma=plataforma ";
                
                if ((filtroPlataformaMicro.getPlataforma().trim().equals("")) == false) {
                    sql += " and plataforma LIKE '%" + filtroPlataformaMicro.getPlataforma().trim() + "%'";
                } 
                
                sql+= " order by plataforma";
                    
                ResultSet rs = conex.executeQuery(sql);
                      
                while (rs.next()) {                
                    PlataformaMicro plataformaMicro = new PlataformaMicro();
                    plataformaMicro.setIdPlataforma(rs.getInt("id_plataforma"));
                    plataformaMicro.setPlataforma(rs.getString("plataforma"));
                            
                  listaPlataformaMicros.add(plataformaMicro);    
                  
                }
            } catch (SQLException e) {
                    
                throw new Exception("Erro ao executar Consulta/Listagem: " + e.getMessage());
            }
                
            desconectar();
                
            return listaPlataformaMicros;
    }
    
}
