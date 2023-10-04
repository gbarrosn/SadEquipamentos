/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Micro.Configuracao;
import Geral.ConectarSQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Posseidon
 */
public class DadosConfiguracao extends ConectarSQL implements InterfaceConfiguracao{

    @Override
    public void cadastrarConfiguracao(Configuracao config) throws Exception {
       try {
           
        Connection conectarSQL = conectarPrepared();
        PreparedStatement conex = conectarSQL.prepareStatement("INSERT INTO Configuracao (configuracao) Values (?)");
        conex.setString(1, config.getConfiguracao());
        conex.executeUpdate();
        
        /*
        String sqlValida = "select Configuracao ";
        sqlValida += " from Configuracao where configuracao = '"+ config.getConfiguracao()+"';";
        ResultSet rs = conex.executeQuery(sqlValida);
       
        while (rs.next()) {
            throw new Exception("Já existe Configuração cadastrada com esta descrição.");
        }
        
            
        String sql = "INSERT INTO Configuracao (configuracao)";
        sql += "VALUES ('"+config.getConfiguracao()+"');";
        conex.execute(sql);
        */
        
        } catch (SQLException e) {
            
            throw new Exception(e.getMessage());
        }
        
        desconectar();
    }

    @Override
    public void alterarConfiguracao(Configuracao alterarConfig, Configuracao selecionadoConfig) throws Exception {
       
        try {
                        
        Connection conectarSQL = conectarPrepared();
        String sql;
        sql =  "UPDATE Configuracao SET configuracao = (?)";
        sql += "where id_configuracao = (?)";
        PreparedStatement conex = conectarSQL.prepareStatement(sql);
        conex.setString(1, alterarConfig.getConfiguracao());
        conex.setInt(2, selecionadoConfig.getIdConfiguracao());
        conex.executeUpdate();
        
            /*
            Statement conex = conectar();
            String sql = "UPDATE Configuracao SET ";
            sql+= "configuracao='"+alterarConfig.getConfiguracao()+"' ";
            sql+= " WHERE id_configuracao="+selecionadoConfig.getIdConfiguracao()+";" ;
            
            
            conex.execute(sql);
                    */
        
        }catch (SQLException ex) {
                //caso haja algum erro neste método será levantada esta execeção
            throw new Exception(ex.getMessage());
        }
            //fechando a conexão com o banco de dados
        desconectar(); 
        
    }

    @Override
    public void removerConfiguracao(Configuracao removerConfig) throws Exception {
       
            try {
                
        Connection conectarSQL = conectarPrepared();
        PreparedStatement conex = conectarSQL.prepareStatement("DELETE Configuracao WHERE id_configuracao = (?)");
        conex.setInt(1, removerConfig.getIdConfiguracao());
        conex.executeUpdate();
                
                /*
                Statement conex = conectar();
                     
                String sql = "DELETE Configuracao WHERE id_configuracao= "+ removerConfig.getIdConfiguracao();
                    //executando a instrução sql
                conex.execute(sql);
                 */
        
            } catch (SQLException e) {
                    //caso haja algum erro neste método será levantada esta execeção
                throw new Exception(e.getMessage());
            }
                //fechando a conexão com o banco de dados
            desconectar();
    }
    
    
    @Override
    public ArrayList<Configuracao> listarConfiguracao(Configuracao filtroConfig) throws Exception {
        
        ArrayList<Configuracao> listaConfiguracaos = new ArrayList<Configuracao>(); 
        PreparedStatement conex = null;

       try {     
                
        Connection conectarSQL = conectarPrepared();
        String sql =  "select * from Configuracao ";              
        sql += "where configuracao=configuracao ";
                
        //FILTROS DE PESQUISA VINDOS DO FORMULÁRIO
        if ((filtroConfig.getConfiguracao().trim().equals("")) == false) {
           sql += " and configuracao LIKE (?)";                
        } 
                
        //STATEMENT
        conex = conectarSQL.prepareStatement(sql);
        
        
        //DEFININDO VALOR DOS FILTROS NA QUERY
        if ((filtroConfig.getConfiguracao().trim().equals("")) == false) {
         conex.setString(1, "%"+filtroConfig.getConfiguracao()+"%");           
        }
        
        
        //RECEBENDO DADOS
        ResultSet rs = conex.executeQuery();    
        while (rs.next()) {   
            
                    Configuracao config = new Configuracao(); 
                    config.setIdConfiguracao(rs.getInt("id_configuracao"));
                    config.setConfiguracao(rs.getString("configuracao"));
                           
        listaConfiguracaos.add(config);  
        
        }
                
                
                /*
                Statement conex = conectar();
               
                String sql = "select * from Configuracao";
                sql += " where configuracao=configuracao ";
                
                if ((filtroConfig.getConfiguracao().trim().equals("")) == false) {
                    sql += " and configuracao LIKE '%" + filtroConfig.getConfiguracao().trim() + "%'";
                } 
                
                sql+= " order by configuracao";
                
                ResultSet rs = conex.executeQuery(sql);
                      
                while (rs.next()) {                
                    Configuracao config = new Configuracao(); 
                    config.setIdConfiguracao(rs.getInt("id_configuracao"));
                    config.setConfiguracao(rs.getString("configuracao"));
                    
        
                  listaConfiguracaos.add(config);    
                  
                }
                */
        
            } catch (SQLException e) {
                    
                throw new Exception("Erro ao executar Consulta/Listagem: " + e.getMessage());
            }
                
            desconectar();
                
            return listaConfiguracaos;
            
    }

    
    
}
