/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Micro.ProprietarioMicro;

import Geral.ConectarSQL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Posseidon
 */
public class DadosProprietarioMicro extends ConectarSQL implements InterfaceProprietarioMicro{

    @Override
    public void cadastrarProprietarioMicro(ProprietarioMicro proprietarioMicro) throws Exception {
        try {
        Statement conex = conectar();

        
        String sqlValida = "select proprietario_micro ";
        sqlValida += " from Proprietario_Micro where proprietario_micro = '"+ proprietarioMicro.getProprietario()+"';";
        ResultSet rs = conex.executeQuery(sqlValida);
       
        while (rs.next()) {
            throw new Exception("Já existe Proprietario de Micro cadastrado com esta descrição.");
        }
        
            
        String sql = "INSERT INTO Proprietario_Micro (proprietario_micro)";
        sql += "VALUES ('"+proprietarioMicro.getProprietario()+"');";
        
            conex.execute(sql);
        } catch (SQLException e) {
            
            throw new Exception("Erro - "+e.getMessage());
        }
        
        desconectar();
    }

    @Override
    public ArrayList<ProprietarioMicro> listarProprietarioMicro(ProprietarioMicro filtroProprietarioMicro) throws Exception {
        
        ArrayList<ProprietarioMicro> listaProprietarioMicro = new ArrayList<ProprietarioMicro>(); 

            try {     

                Statement conex = conectar();
               
                String sql = "select * from Proprietario_Micro";
                sql += " where proprietario_micro=proprietario_micro ";
                
                if (((filtroProprietarioMicro.getProprietario()).trim().equals("")) == false) {
                    sql += " and proprietario_micro LIKE '%" + filtroProprietarioMicro.getProprietario().trim() + "%'";
                } 
                    
                sql+= " order by proprietario_micro";
                
                ResultSet rs = conex.executeQuery(sql);
                      
                while (rs.next()) {                
                    ProprietarioMicro proprietarioMicro = new ProprietarioMicro();
                    proprietarioMicro.setIdProprietario(rs.getInt("id_proprietario_micro"));
                    proprietarioMicro.setProprietario(rs.getString("proprietario_micro"));
                            
                  listaProprietarioMicro.add(proprietarioMicro);    
                  
                }
            } catch (SQLException e) {
                    
                throw new Exception("Erro ao executar Consulta/Listagem: " + e.getMessage());
            }
                
            desconectar();
                
            return listaProprietarioMicro;
    }

    @Override
    public void alterarProprietarioMicro(ProprietarioMicro alterarProprietarioMicro, ProprietarioMicro selecionadoProprietarioMicro) throws Exception {
    
         try {
            
            Statement conex = conectar();
            String sql = "UPDATE Proprietario_Micro SET ";
            sql+= "proprietario_micro='"+alterarProprietarioMicro.getProprietario()+"' ";
            sql+= " WHERE id_proprietario_micro="+selecionadoProprietarioMicro.getIdProprietario()+";" ;
            
            
            conex.execute(sql);
        }catch (SQLException ex) {
                //caso haja algum erro neste método será levantada esta execeção
            throw new Exception(ex.getMessage());
        }
            //fechando a conexão com o banco de dados
        desconectar(); 
    
    }

    @Override
    public void removerProprietarioMicro(ProprietarioMicro removerProprietarioMicro) throws Exception {
     
          try {
                Statement conex = conectar();
                     
                String sql = "DELETE Proprietario_Micro WHERE id_proprietario_micro= "+ removerProprietarioMicro.getIdProprietario();
                    //executando a instrução sql
                conex.execute(sql);
            } catch (SQLException e) {
                    //caso haja algum erro neste método será levantada esta execeção
                throw new Exception(e.getMessage());
            }
                //fechando a conexão com o banco de dados
            desconectar();
    
    }
    
}
