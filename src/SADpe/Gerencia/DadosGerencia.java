/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SADpe.Gerencia;

import Geral.ConectarSQL;
import SADpe.Pavimento.Pavimento;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Posseidon
 */
public class DadosGerencia extends ConectarSQL implements InterfaceGerencia{

    @Override
    public void cadastrarGerencia(Gerencia gerencia) throws Exception {
        
        try {
        Statement conex = conectar();

        //executando o select de validacao de usuario repetido
        String sqlValida = "select gerencia ";
        sqlValida += " from Gerencia where sigla = '"+ gerencia.getSiglaGerencia()+"';";
        ResultSet rs = conex.executeQuery(sqlValida);      
        while (rs.next()) {
            throw new Exception("Já existe uma Gerência cadastrada com esta sigla!");
        }

        //instrução sql para cadastro do usuário
        //String sql ="DECLARE @TRANSACTION VARCHAR(200) = '"+user.getTransactID()+"' BEGIN TRANSACTION "+user.getTransactID()+" SAVE TRANSACTION "+user.getTransactID();
        String sql= " INSERT INTO Gerencia (gerencia,sigla,id_pavimento) ";
        sql += "VALUES ('"+ gerencia.getGerencia()+ "','"+gerencia.getSiglaGerencia()+"',"+gerencia.getPavimento().getIdPavimento()+")";
        
        conex.execute(sql);
        } catch (SQLException e) {
            //caso haja algum erro neste método será levantada esta execeção
            throw new Exception("Erro - "+e.getMessage());
        }
        //fechando a conexão com o banco de dados
        desconectar();
    }

    @Override
    public void alterarGerencia(Gerencia alterarGerencia, Gerencia selecionadoGerencia) throws Exception {

        try {
            
            Statement conex = conectar();
            String sql = "UPDATE Gerencia SET ";
            sql+= "gerencia='"+alterarGerencia.getGerencia()+"' ";
            sql+= ", sigla='"+alterarGerencia.getSiglaGerencia()+"' ";
            sql+= ",id_pavimento="+alterarGerencia.getPavimento().getIdPavimento();
            sql+= " WHERE id_gerencia="+selecionadoGerencia.getIdGerencia()+";" ;
            
            
            conex.execute(sql);
        }catch (SQLException e) {
                //caso haja algum erro neste método será levantada esta execeção
            throw new Exception(e.getMessage());
        }
            //fechando a conexão com o banco de dados
        desconectar(); 
    }

    @Override
    public void removerGerencia(Gerencia removerGerencia) throws Exception {

        try {
                Statement conex = conectar();
                     
                String sql = "DELETE gerencia WHERE id_gerencia= "+ removerGerencia.getIdGerencia();
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
    public ArrayList<Gerencia> listarGerencia(Gerencia filtroGerencia) throws Exception {
        
        ArrayList<Gerencia> listaGerencia = new ArrayList<Gerencia>(); 

            try {     

                Statement conex = conectar();
               
                String sql = "select * from Gerencia,Pavimento";
                sql += " where gerencia.id_pavimento=pavimento.id_pavimento ";
                
                if (((filtroGerencia.getGerencia()).trim().equals("")) == false) {
                    sql += " and gerencia LIKE '%" + filtroGerencia.getGerencia().trim() + "%'";
                } 
                 
                if (((filtroGerencia.getSiglaGerencia()).trim().equals("")) == false) {
                    sql += " and sigla LIKE '%" + filtroGerencia.getSiglaGerencia().trim() + "%'";
                } 
                if ((filtroGerencia.getPavimento().getIdPavimento()!=0)){
                    sql += " and gerencia.id_pavimento="+filtroGerencia.getPavimento().getIdPavimento();
                }
                sql+=" order by pavimento.id_pavimento,gerencia.sigla";
                        
                ResultSet rs = conex.executeQuery(sql);
                      
                while (rs.next()) {                
                    Gerencia gerencia = new Gerencia();
                    gerencia.setIdGerencia(rs.getInt("id_gerencia"));
                    gerencia.setGerencia(rs.getString("gerencia"));
                    gerencia.setSiglaGerencia(rs.getString("sigla"));
                    
                        Pavimento pavimento = new Pavimento();
                        pavimento.setIdPavimento(rs.getInt("id_pavimento"));
                        pavimento.setPavimento(rs.getString("pavimento"));
                    
                    gerencia.setPavimento(pavimento);
                            
                    listaGerencia.add(gerencia);
                  
                }
            } catch (SQLException e) {
                    
                throw new Exception("Erro ao executar Consulta/Listagem: " + e.getMessage());
            }
                
            desconectar();
                
            return listaGerencia;
    }
    
}
