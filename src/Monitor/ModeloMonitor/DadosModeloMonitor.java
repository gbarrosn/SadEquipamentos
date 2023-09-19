/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Monitor.ModeloMonitor;

import Geral.ConectarSQL;
import Monitor.MarcaMonitor.MarcaMonitor;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Posseidon
 */
public class DadosModeloMonitor extends ConectarSQL implements InterfaceModeloMonitor{

    @Override
    public void cadastrarModeloMonitor(ModeloMonitor modeloMonitor) throws Exception {
       try {
        Statement conex = conectar();

        
        String sqlValida = "select modelo_monitor ";
        sqlValida += " from Modelo_Monitor where modelo_monitor = '"+ modeloMonitor.getModelo()+"';";
        ResultSet rs = conex.executeQuery(sqlValida);
       
        while (rs.next()) {
            throw new Exception("Já existe Modelo cadastrado com esta descrição.");
        }
        
            
        String sql = "INSERT INTO Modelo_Monitor (modelo_monitor,id_marca_monitor)";
        sql += "VALUES ('"+modeloMonitor.getModelo()+"',"+modeloMonitor.getMarca().getIdMarca()+");";
        
            conex.execute(sql);
        } catch (SQLException e) {
            
            throw new Exception("Erro - "+e.getMessage());
        }
        
        desconectar();
    }

    @Override
    public void alterarModeloMonitor(ModeloMonitor alterarModeloMonitor, ModeloMonitor selecionadoModeloMonitor) throws Exception {
      try {
            
            Statement conex = conectar();
            String sql = "UPDATE Modelo_Monitor SET ";
            sql+= "modelo_monitor='"+alterarModeloMonitor.getModelo()+"', ";
            sql+= "id_marca_monitor="+alterarModeloMonitor.getMarca().getIdMarca();
            sql+= " WHERE id_modelo_monitor="+selecionadoModeloMonitor.getIdModelo()+";" ;
            
            
            conex.execute(sql);
        }catch (SQLException ex) {
                //caso haja algum erro neste método será levantada esta execeção
            throw new Exception(ex.getMessage());
        }
            //fechando a conexão com o banco de dados
        desconectar(); 
    }

    @Override
    public void removerModeloMonitor(ModeloMonitor removerModeloMonitor) throws Exception {
        try {
                Statement conex = conectar();
                     
                String sql = "DELETE Modelo_Monitor WHERE id_modelo_monitor= "+ removerModeloMonitor.getIdModelo();
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
    public ArrayList<ModeloMonitor> listarModeloMonitor(ModeloMonitor filtroModeloMonitor) throws Exception {
        
        ArrayList<ModeloMonitor> listaModeloMonitor = new ArrayList<ModeloMonitor>(); 

            try {     

                Statement conex = conectar();
               
                String sql = "select * from Modelo_Monitor,Marca_Monitor";
                sql += " where Modelo_Monitor.id_marca_monitor=Marca_Monitor.id_marca_monitor ";
                
                if (((filtroModeloMonitor.getModelo()).trim().equals("")) == false) {
                    sql += " and modelo_monitor LIKE '%" + filtroModeloMonitor.getModelo().trim() + "%'";
                } 
                
                if ((filtroModeloMonitor.getMarca().getIdMarca()!=0)){
                    sql += " and Modelo_Monitor.id_marca_monitor="+filtroModeloMonitor.getMarca().getIdMarca();
                }
                   
                    
                sql+= " order by modelo_monitor";
                
                ResultSet rs = conex.executeQuery(sql);
                      
                while (rs.next()) {                
                    ModeloMonitor modeloMonitor = new ModeloMonitor();
                    modeloMonitor.setIdModelo(rs.getInt("id_modelo_monitor"));
                    modeloMonitor.setModelo(rs.getString("modelo_monitor"));
                                   
                        MarcaMonitor marca = new MarcaMonitor();
                        marca.setIdMarca(rs.getInt("id_marca_monitor"));
                        marca.setMarca(rs.getString("marca_monitor"));
                    
                    modeloMonitor.setMarca(marca);
                            
                    listaModeloMonitor.add(modeloMonitor);
                  
                }
            } catch (SQLException e) {
                    
                throw new Exception("Erro ao executar Consulta/Listagem: " + e.getMessage());
            }
                
            desconectar();
                
            return listaModeloMonitor;
    }
    
}
