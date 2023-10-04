/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Versao_Office;
import Geral.ConectarSQL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Posseidon
 */
public class DadosVersaoOffice extends ConectarSQL implements InterfaceVersaoOffice{

    @Override
    public void cadastrarVersaoOffice(VersaoOffice versaoOffice) throws Exception {
        try {
        Statement conex = conectar();

        
        String sqlValida = "select descricao_office ";
        sqlValida += " from Versao_Office where descricao_office = '"+ versaoOffice.getDescricao()+"';";
        ResultSet rs = conex.executeQuery(sqlValida);
       
        while (rs.next()) {
            throw new Exception("Já existe uma versão do Office cadastrada com esta descrição!");           
        }
        
        
            
        String sql = "INSERT INTO Versao_Office (descricao_office)";
        sql += "VALUES ('"+versaoOffice.getDescricao()+"');";
        
            conex.execute(sql);
        } catch (SQLException e) {
            
            throw new Exception("Erro - "+e.getMessage());
        }
        
        desconectar();
    }

    @Override
    public void alterarVersaoOffice(VersaoOffice alterarVersaoOffice, VersaoOffice selecionadoVersaoOffice) throws Exception {
        try {
             
      Statement conex = conectar();
            String sql = "UPDATE Versao_Office SET ";
            sql+= "descricao_office='"+alterarVersaoOffice.getDescricao()+"' ";
            sql+= " WHERE id_Versao_Office="+selecionadoVersaoOffice.getId_versao_office()+";" ;
            
            
            conex.execute(sql);
        }catch (SQLException ex) {
                //caso haja algum erro neste método será levantada esta execeção
            throw new Exception(ex.getMessage());
        }
            //fechando a conexão com o banco de dados
        desconectar();  
        
    }

    @Override
    public void removerVersaoOffice(VersaoOffice removerVersaoOffice) throws Exception {
        try {
                Statement conex = conectar();
                     
                String sql = "DELETE Versao_Office WHERE id_Versao_Office= "+ removerVersaoOffice.getId_versao_office();
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
    public ArrayList<VersaoOffice> listarVersaoOffice(VersaoOffice filtroVersaoOffice) throws Exception {
      
        ArrayList<VersaoOffice> listaVersaoOffice = new ArrayList<VersaoOffice>(); 

            try {     

                Statement conex = conectar();
               
                String sql = "select * from Versao_Office";
                sql += " where descricao_office=descricao_office ";
                
                if (((filtroVersaoOffice.getDescricao()).trim().equals("")) == false) {
                    sql += " and descricao_office LIKE '%" + filtroVersaoOffice.getDescricao().trim() + "%'";
                }
                
                sql+= " order by descricao_office";
                    
                ResultSet rs = conex.executeQuery(sql);
                      
                while (rs.next()) {                
                    VersaoOffice versaoOffice = new VersaoOffice();
                    versaoOffice.setId_versao_office(rs.getInt("id_versao_office"));
                    versaoOffice.setDescricao(rs.getString("descricao_office"));
                            
                    listaVersaoOffice.add(versaoOffice);
                  
                }
            } catch (SQLException e) {
                    
                throw new Exception("Erro ao executar Consulta/Listagem: " + e.getMessage());
            }
                
            desconectar();
                
            return listaVersaoOffice;
    }
    }


    

