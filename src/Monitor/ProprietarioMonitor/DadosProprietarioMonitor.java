/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Monitor.ProprietarioMonitor;

import Geral.ConectarSQL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Posseidon
 */
public class DadosProprietarioMonitor extends ConectarSQL implements InterfaceProprietarioMonitor{

    @Override
    public void cadastrarProprietarioMonitor(ProprietarioMonitor proprietarioMonitor) throws Exception {
       try {
        Statement conex = conectar();

        
        String sqlValida = "select proprietario_monitor ";
        sqlValida += " from Proprietario_Monitor where proprietario_monitor = '"+ proprietarioMonitor.getProprietario()+"';";
        ResultSet rs = conex.executeQuery(sqlValida);
       
        while (rs.next()) {
            throw new Exception("Já existe Proprietario de Monitor cadastrado com esta descrição.");
        }
        
            
        String sql = "INSERT INTO Proprietario_Monitor (proprietario_monitor)";
        sql += "VALUES ('"+proprietarioMonitor.getProprietario()+"');";
        
            conex.execute(sql);
        } catch (SQLException e) {
            
            throw new Exception("Erro - "+e.getMessage());
        }
        
        desconectar();
    }

    @Override
    public void alterarProprietarioMonitor(ProprietarioMonitor alterarProprietarioMonitor, ProprietarioMonitor selecionadoProprietarioMonitor) throws Exception {
         try {
            
            Statement conex = conectar();
            String sql = "UPDATE Proprietario_Monitor SET ";
            sql+= "proprietario_monitor='"+alterarProprietarioMonitor.getProprietario()+"' ";
            sql+= " WHERE id_proprietario_monitor="+selecionadoProprietarioMonitor.getIdProprietario()+";" ;
            
            
            conex.execute(sql);
        }catch (SQLException ex) {
                //caso haja algum erro neste método será levantada esta execeção
            throw new Exception(ex.getMessage());
        }
            //fechando a conexão com o banco de dados
        desconectar(); 
    
    }

    @Override
    public void removerProprietarioMonitor(ProprietarioMonitor removerProprietarioMonitor) throws Exception {
        try {
                Statement conex = conectar();
                     
                String sql = "DELETE Proprietario_Monitor WHERE id_proprietario_monitor= "+ removerProprietarioMonitor.getIdProprietario();
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
    public ArrayList<ProprietarioMonitor> listarProprietarioMonitor(ProprietarioMonitor filtroProprietarioMonitor) throws Exception {
      
        ArrayList<ProprietarioMonitor> listaProprietarioMonitor = new ArrayList<ProprietarioMonitor>(); 

            try {     

                Statement conex = conectar();
               
                String sql = "select * from Proprietario_Monitor";
                sql += " where proprietario_monitor=proprietario_monitor ";
                
                if (((filtroProprietarioMonitor.getProprietario()).trim().equals("")) == false) {
                    sql += " and proprietario_monitor LIKE '%" + filtroProprietarioMonitor.getProprietario().trim() + "%'";
                } 
                    
                sql+= " order by proprietario_monitor";
                
                ResultSet rs = conex.executeQuery(sql);
                      
                while (rs.next()) {                
                    ProprietarioMonitor proprietarioMonitor = new ProprietarioMonitor();
                    proprietarioMonitor.setIdProprietario(rs.getInt("id_proprietario_monitor"));
                    proprietarioMonitor.setProprietario(rs.getString("proprietario_monitor"));
                            
                    listaProprietarioMonitor.add(proprietarioMonitor);
                  
                }
            } catch (SQLException e) {
                    
                throw new Exception("Erro ao executar Consulta/Listagem: " + e.getMessage());
            }
                
            desconectar();
                
            return listaProprietarioMonitor;
    }
    
}
