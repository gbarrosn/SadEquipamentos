/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Micro.MarcaMicro;

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
public class DadosMarcaMicro extends ConectarSQL implements InterfaceMarcaMicro {

    @Override
    public void cadastrarMarcaMicro(MarcaMicro cadastrarMarcaMicro) throws Exception {

        try {

            Connection conectarSQL = conectarPrepared();
            PreparedStatement conex = conectarSQL.prepareStatement("Select marca_micro from Marca_micro where marca_micro = (?)");
            conex.setString(1, cadastrarMarcaMicro.getMarca());
            ResultSet rs = conex.executeQuery();
            while (rs.next()) {
                throw new Exception("Já existe Marca cadastrada com esta descrição.");
            }

            conex = conectarSQL.prepareStatement("INSERT INTO Marca_Micro (marca_micro) Values (?)");
            conex.setString(1, cadastrarMarcaMicro.getMarca());
            conex.executeUpdate();

        } catch (SQLException e) {

            throw new Exception("Erro ao inserir dados.");
        }

        desconectar();


    }

    @Override
    public void alterarMarcaMicro(MarcaMicro alterarMarcaMicro, MarcaMicro selecionadoMarcaMicro) throws Exception {
        try {

            Connection conectarSQL = conectarPrepared();
            String sql;
            sql = "UPDATE Marca_Micro SET marca_micro = (?)";
            sql += "where id_marca_micro = (?)";
            PreparedStatement conex = conectarSQL.prepareStatement(sql);
            conex.setString(1, alterarMarcaMicro.getMarca());
            conex.setInt(2, selecionadoMarcaMicro.getIdMarca());
            conex.executeUpdate();

        } catch (SQLException ex) {
            //caso haja algum erro neste método será levantada esta execeção
            throw new Exception(ex.getMessage());
        }
        //fechando a conexão com o banco de dados
        desconectar();
    }

    @Override
    public void removerMarcaMicro(MarcaMicro removerMarcaMicro) throws Exception {
        
        try {
            Connection conectarSQL = conectarPrepared();
            PreparedStatement conex = conectarSQL.prepareStatement("DELETE Marca_Micro WHERE id_marca_micro = (?)");
            conex.setInt(1, removerMarcaMicro.getIdMarca());
            conex.executeUpdate();
        } catch (SQLException e) {
            //caso haja algum erro neste método será levantada esta execeção
            throw new Exception(e.getMessage());
        }
        //fechando a conexão com o banco de dados
        desconectar();
    }

    @Override
    public ArrayList<MarcaMicro> listarMarcaMicro(MarcaMicro filtroMarcaMicro) throws Exception {

      ArrayList<MarcaMicro> listaMarcaMicros = new ArrayList<MarcaMicro>(); 
        PreparedStatement conex = null;

       try {     
                
        Connection conectarSQL = conectarPrepared();
        String sql =  "select * from Marca_Micro ";              
        sql += "where marca_micro=marca_micro ";
                
        //FILTROS DE PESQUISA VINDOS DO FORMULÁRIO
        if ((filtroMarcaMicro.getMarca().trim().equals("")) == false) {
           sql += " and marca_micro LIKE (?)";                
        } 
                
        //STATEMENT
        conex = conectarSQL.prepareStatement(sql);
        
        
        //DEFININDO VALOR DOS FILTROS NA QUERY
        if ((filtroMarcaMicro.getMarca().trim().equals("")) == false) {
         conex.setString(1, "%"+filtroMarcaMicro.getMarca()+"%");           
        }
        
        
        //RECEBENDO DADOS
        ResultSet rs = conex.executeQuery();  
            while (rs.next()) {
                MarcaMicro marcaMicro = new MarcaMicro();
                marcaMicro.setIdMarca(rs.getInt("id_marca_micro"));
                marcaMicro.setMarca(rs.getString("marca_micro"));

                listaMarcaMicros.add(marcaMicro);

            }
        } catch (SQLException e) {

            throw new Exception("Erro ao executar Consulta/Listagem: " + e.getMessage());
        }

        desconectar();

        return listaMarcaMicros;

    }

}
