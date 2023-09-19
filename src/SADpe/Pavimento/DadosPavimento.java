/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SADpe.Pavimento;

import Geral.ConectarSQL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Posseidon
 */
public class DadosPavimento extends ConectarSQL implements InterfacePavimento{

    @Override
    public void cadastrarPavimento(Pavimento pavimento) throws Exception {
      try {
        Statement conex = conectar();

        //executando o select de validacao de usuario repetido
        String sqlValida = "select pavimento ";
        sqlValida += " from Pavimento where pavimento = '"+ pavimento.getPavimento()+"';";
        ResultSet rs = conex.executeQuery(sqlValida);      
        while (rs.next()) {
            throw new Exception("Já existe um Pavimento cadastrado com esta descrição!");
        }

        //instrução sql para cadastro do usuário
        //String sql ="DECLARE @TRANSACTION VARCHAR(200) = '"+user.getTransactID()+"' BEGIN TRANSACTION "+user.getTransactID()+" SAVE TRANSACTION "+user.getTransactID();
        String sql= " INSERT INTO Pavimento (pavimento) ";
        sql += "VALUES ('"+ pavimento.getPavimento()+ "');";
        
        conex.execute(sql);
        } catch (SQLException e) {
            //caso haja algum erro neste método será levantada esta execeção
            throw new Exception("Erro - "+e.getMessage());
        }
        //fechando a conexão com o banco de dados
        desconectar();
    }

    @Override
    public void alterarPavimento(Pavimento alterarPavimento, Pavimento selecionadoPavimento) throws Exception {
       try {
            
            Statement conex = conectar();
            String sql = "UPDATE Pavimento SET ";
            sql+= "pavimento='"+alterarPavimento.getPavimento()+"' ";
            sql+= " WHERE id_pavimento="+selecionadoPavimento.getIdPavimento()+";" ;
            
            
            conex.execute(sql);
        }catch (SQLException e) {
                //caso haja algum erro neste método será levantada esta execeção
            throw new Exception(e.getMessage());
        }
            //fechando a conexão com o banco de dados
        desconectar(); 
    }

    @Override
    public void removerPavimento(Pavimento removerPavimento) throws Exception {
       try {
                Statement conex = conectar();
                     
                String sql = "DELETE pavimento WHERE id_pavimento= "+ removerPavimento.getIdPavimento();
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
    public ArrayList<Pavimento> listarPavimento(Pavimento filtroPavimento) throws Exception {
        
        ArrayList<Pavimento> listaPavimento = new ArrayList<Pavimento>(); 

            try {     

                Statement conex = conectar();
               
                String sql = "select * from Pavimento";
                sql += " where pavimento=pavimento ";
                
                if (((filtroPavimento.getPavimento()).trim().equals("")) == false) {
                    sql += " and pavimento LIKE '%" + filtroPavimento.getPavimento().trim() + "%'";
                } 
                   
                sql+= " order by id_pavimento";
                
                ResultSet rs = conex.executeQuery(sql);
                      
                while (rs.next()) {                
                    Pavimento pavimento = new Pavimento();
                    pavimento.setIdPavimento(rs.getInt("id_pavimento"));
                    pavimento.setPavimento(rs.getString("pavimento"));
                            
                    listaPavimento.add(pavimento);
                  
                }
            } catch (SQLException e) {
                    
                throw new Exception("Erro ao executar Consulta/Listagem: " + e.getMessage());
            }
                
            desconectar();
                
            return listaPavimento;
    }
    
}
