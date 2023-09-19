/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Monitor.MarcaMonitor;

import Geral.ConectarSQL;
import Micro.ProprietarioMicro.ProprietarioMicro;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Posseidon
 */
public class DadosMarcaMonitor extends ConectarSQL implements InterfaceMarcaMonitor{

    @Override
    public void cadastrarMarcaMonitor(MarcaMonitor marcaMonitor) throws Exception {
       try {
        Statement conex = conectar();

        
        String sqlValida = "select marca_monitor ";
        sqlValida += " from Marca_Monitor where marca_monitor = '"+ marcaMonitor.getMarca()+"';";
        ResultSet rs = conex.executeQuery(sqlValida);
       
        while (rs.next()) {
            throw new Exception("Já existe Marca cadastrada com esta descrição.");
        }
        
            
        String sql = "INSERT INTO Marca_Monitor (marca_monitor)";
        sql += "VALUES ('"+marcaMonitor.getMarca()+"');";
        
            conex.execute(sql);
        } catch (SQLException e) {
            
            throw new Exception("Erro - "+e.getMessage());
        }
        
        desconectar();
    }

    @Override
    public void alterarMarcaMonitor(MarcaMonitor alterarMarcaMonitor, MarcaMonitor selecionadoMarcaMonitor) throws Exception {
      try {
            
            Statement conex = conectar();
            String sql = "UPDATE Marca_Monitor SET ";
            sql+= "marca_monitor='"+alterarMarcaMonitor.getMarca()+"' ";
            sql+= " WHERE id_marca_monitor="+selecionadoMarcaMonitor.getIdMarca()+";" ;
            
            
            conex.execute(sql);
        }catch (SQLException ex) {
                //caso haja algum erro neste método será levantada esta execeção
            throw new Exception(ex.getMessage());
        }
            //fechando a conexão com o banco de dados
        desconectar(); 
    }

    @Override
    public void removerMarcaMonitor(MarcaMonitor removerMarcaMonitor) throws Exception {
      try {
                Statement conex = conectar();
                     
                String sql = "DELETE Marca_Monitor WHERE id_marca_monitor= "+ removerMarcaMonitor.getIdMarca();
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
    public ArrayList<MarcaMonitor> listarMarcaMonitor(MarcaMonitor filtroMarcaMonitor) throws Exception {
        
         ArrayList<MarcaMonitor> listaMarcaMonitor = new ArrayList<MarcaMonitor>(); 

            try {     

                Statement conex = conectar();
               
                String sql = "select * from Marca_Monitor";
                sql += " where marca_monitor=marca_monitor ";
                
                if (((filtroMarcaMonitor.getMarca()).trim().equals("")) == false) {
                    sql += " and marca_monitor LIKE '%" + filtroMarcaMonitor.getMarca().trim() + "%'";
                } 
                
                if ((filtroMarcaMonitor.getIdMarca() !=0)) {
                    sql += " and id_marca_monitor=" + filtroMarcaMonitor.getIdMarca();
                }
                    
                sql+= " order by marca_monitor";
                
                ResultSet rs = conex.executeQuery(sql);
                      
                while (rs.next()) {                
                    MarcaMonitor marcaMonitor = new MarcaMonitor();
                    marcaMonitor.setIdMarca(rs.getInt("id_marca_monitor"));
                    marcaMonitor.setMarca(rs.getString("marca_monitor"));
                            
                    listaMarcaMonitor.add(marcaMonitor);
                  
                }
            } catch (SQLException e) {
                    
                throw new Exception("Erro ao executar Consulta/Listagem: " + e.getMessage());
            }
                
            desconectar();
                
            return listaMarcaMonitor;
    }
    
}
