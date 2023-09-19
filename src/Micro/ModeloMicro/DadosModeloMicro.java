/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Micro.ModeloMicro;

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
public class DadosModeloMicro extends ConectarSQL implements InterfaceModeloMicro{

    @Override
    public void cadastrarModeloMicro(ModeloMicro modeloMicro) throws Exception {
           try {
        Statement conex = conectar();

        
        String sqlValida = "select modelo_micro ";
        sqlValida += " from Modelo_Micro where modelo_micro = '"+ modeloMicro.getModelo()+"';";
        ResultSet rs = conex.executeQuery(sqlValida);
       
        while (rs.next()) {
            throw new Exception("Já existe Modelo cadastrado com esta descrição!");
        }
        
            
        String sql = "INSERT INTO Modelo_Micro (modelo_micro,id_marca_micro)";
        sql += "VALUES ('"+modeloMicro.getModelo()+"',"+modeloMicro.getMarca().getIdMarca()+");";
        
            conex.execute(sql);
        } catch (SQLException e) {
            
            throw new Exception("Erro - "+e.getMessage());
        }
        
        desconectar();
    }

    @Override
    public void alterarModeloMicro(ModeloMicro alterarModeloMicro, ModeloMicro selecionadoModeloMicro) throws Exception {
       try {
            
            Statement conex = conectar();
            String sql = "UPDATE Modelo_Micro SET ";
            sql+= "modelo_micro='"+alterarModeloMicro.getModelo()+"', ";
            sql+= "id_marca_micro="+alterarModeloMicro.getMarca().getIdMarca();
            sql+= " WHERE id_modelo_micro="+selecionadoModeloMicro.getIdModelo()+";" ;
            
            
            conex.execute(sql);
        }catch (SQLException ex) {
                //caso haja algum erro neste método será levantada esta execeção
            throw new Exception(ex.getMessage());
        }
            //fechando a conexão com o banco de dados
        desconectar(); 
    }

    @Override
    public void removerModeloMicro(ModeloMicro removerModeloMicro) throws Exception {
        try {
                Statement conex = conectar();
                     
                String sql = "DELETE Modelo_Micro WHERE id_modelo_micro= "+ removerModeloMicro.getIdModelo();
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
    public ArrayList<ModeloMicro> listarModeloMicro(ModeloMicro filtroModeloMicro) throws Exception {
        
        ArrayList<ModeloMicro> listaModeloMicros = new ArrayList<ModeloMicro>(); 

            try {     

                Statement conex = conectar();
               
                String sql = "select * from Modelo_Micro,Marca_Micro";
                sql += " where Modelo_micro.id_marca_micro=Marca_Micro.id_marca_micro ";
                
                if ((filtroModeloMicro.getModelo().trim().equals("")) == false) {
                    sql += " and modelo_micro LIKE '%" + filtroModeloMicro.getModelo().trim() + "%'";
                } 
                
                if ((filtroModeloMicro.getMarca().getIdMarca()!=0)){
                    sql += " and Modelo_Micro.id_marca_micro="+filtroModeloMicro.getMarca().getIdMarca();
                }
                    
                sql+= " order by modelo_micro";
                
                ResultSet rs = conex.executeQuery(sql);
                      
                while (rs.next()) {                
                    ModeloMicro modeloMicro = new ModeloMicro();
                    modeloMicro.setIdModelo(rs.getInt("id_modelo_micro"));
                    modeloMicro.setModelo(rs.getString("modelo_micro"));
                    
                        MarcaMicro marca = new MarcaMicro();
                        marca.setIdMarca(rs.getInt("id_marca_micro"));
                        marca.setMarca(rs.getString("marca_micro"));
                    
                    modeloMicro.setMarca(marca);
                    
                  listaModeloMicros.add(modeloMicro);
                  
                }
            } catch (SQLException e) {
                    
                throw new Exception("Erro ao executar Consulta/Listagem: " + e.getMessage());
            }
                
            desconectar();
                
            return listaModeloMicros;
            
    }
    
}
