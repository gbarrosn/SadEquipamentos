/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SADpe.Cargo;

import Geral.ConectarSQL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Posseidon
 */
public class DadosCargo extends ConectarSQL implements InterfaceCargo{

    @Override
    public void cadastrarCargo(Cargo cargo) throws Exception {
        
      try {
        Statement conex = conectar();

        
        String sqlValida = "select cargo ";
        sqlValida += " from Cargo where cargo = '"+ cargo.getCargo()+"';";
        ResultSet rs = conex.executeQuery(sqlValida);
       
        while (rs.next()) {
            throw new Exception("Já existe Cargo cadastrado com esta descrição!");           
        }
        
        
            
        String sql = "INSERT INTO Cargo (cargo)";
        sql += "VALUES ('"+cargo.getCargo()+"');";
        
            conex.execute(sql);
        } catch (SQLException e) {
            
            throw new Exception("Erro - "+e.getMessage());
        }
        
        desconectar();
        
    }

    @Override
    public void alterarCargo(Cargo alterarCargo, Cargo selecionadoCargo) throws Exception {
        
      try {
             
      Statement conex = conectar();
            String sql = "UPDATE Cargo SET ";
            sql+= "cargo='"+alterarCargo.getCargo()+"' ";
            sql+= " WHERE id_cargo="+selecionadoCargo.getIdCargo()+";" ;
            
            
            conex.execute(sql);
        }catch (SQLException ex) {
                //caso haja algum erro neste método será levantada esta execeção
            throw new Exception(ex.getMessage());
        }
            //fechando a conexão com o banco de dados
        desconectar();  
        
    }

    @Override
    public void removerCargo(Cargo removerCargo) throws Exception {
        
        try {
                Statement conex = conectar();
                     
                String sql = "DELETE Cargo WHERE id_cargo= "+ removerCargo.getIdCargo();
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
    public ArrayList<Cargo> listarCargo(Cargo filtroCargo) throws Exception {
        
         ArrayList<Cargo> listaCargo = new ArrayList<Cargo>(); 

            try {     

                Statement conex = conectar();
               
                String sql = "select * from Cargo";
                sql += " where cargo=cargo ";
                
                if (((filtroCargo.getCargo()).trim().equals("")) == false) {
                    sql += " and cargo LIKE '%" + filtroCargo.getCargo().trim() + "%'";
                }
                
                sql+= " order by cargo";
                    
                ResultSet rs = conex.executeQuery(sql);
                      
                while (rs.next()) {                
                    Cargo cargo = new Cargo();
                    cargo.setIdCargo(rs.getInt("id_cargo"));
                    cargo.setCargo(rs.getString("cargo"));
                            
                    listaCargo.add(cargo);
                  
                }
            } catch (SQLException e) {
                    
                throw new Exception("Erro ao executar Consulta/Listagem: " + e.getMessage());
            }
                
            desconectar();
                
            return listaCargo;
    }
    
}
