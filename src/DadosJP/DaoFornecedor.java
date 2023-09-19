/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DadosJP;

import ClassesBasicasJP.Fornecedor;
import InterfaceJP.InterfaceFornecedor;
import Geral.ConectarSQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author joao.paulo
 */
public class DaoFornecedor extends ConectarSQL implements InterfaceFornecedor {

    private static DaoFornecedor instancia;

    public static void setInstancia(DaoFornecedor aInstancia) {
        instancia = aInstancia;
    }

    private DaoFornecedor() {
    }

    public static DaoFornecedor getInstancia() {
        if (instancia == null) {
            setInstancia(new DaoFornecedor());
        }
        return instancia;
    }

    @Override
    public void cadastrarFornecedor(Fornecedor forn) throws Exception {
        try {
            Connection ConectarSQL = conectarPrepared();
            String sql = "INSERT INTO dbo.Fornecedor(cnpj, nome) ";
            sql += "values (?,?)";
            PreparedStatement conex = ConectarSQL.prepareStatement(sql);
            conex.setString(1, forn.getCnpj());
            conex.setString(2, forn.getNome());
            conex.executeUpdate();

        } catch (Exception ex) {
            throw new Exception("Não foi possível Cadastrar o Fornecedor - " + ex.getMessage());
        }
        desconectar();

    }

    @Override
    public void alterarFornecedor(Fornecedor altForn, Fornecedor selecionado) throws Exception {
        try {
            Statement conex = conectar();
            String sql = "UPDATE Equipamentos.dbo.Fornecedor set ";
            sql += "cnpj = '" + altForn.getCnpj() + "', nome = '" + altForn.getNome() + "' where cnpj = '" + selecionado.getCnpj() + "';";
            conex.execute(sql);

        } catch (Exception ex) {
            throw new Exception("Não foi possível Alterar o Equipamento  - ");
        }
    }

    @Override
    public void removerFornecedor(Fornecedor remoForn) throws Exception {
        Statement conex = conectar();
        try {
            //   Connection ConectarSQL = conectarPrepared();
            String sql = "DELETE FROM dbo.Fornecedor WHERE cnpj = '" + remoForn.getCnpj() + "'";
            conex.execute(sql);
        } catch (Exception ex) {
            throw new Exception("Não foi possível Remover este Fornecedor" + ex.getMessage());
        }
        desconectar();
    }

    @Override
    public ArrayList<Fornecedor> listaFornecedor() throws Exception {
        ArrayList<Fornecedor> listaForn = new ArrayList<Fornecedor>();

        try {
            Statement conex = conectar();
            //LISTAR TODOS (SEM FILTRO)
            String sql = "select * from Equipamentos.dbo.Fornecedor order by  nome";
            ResultSet rs = conex.executeQuery(sql);

            while (rs.next()) {
                Fornecedor forn = new Fornecedor();
                forn.setCnpj(rs.getString("cnpj"));
                forn.setNome(rs.getString("nome"));

                listaForn.add(forn);
            }

        } catch (SQLException e) {
            throw new Exception("Não foi possível Consultar os Fornecedores" + e.getMessage());
        }
        desconectar();
        return listaForn;
    }

    @Override
    public ArrayList<Fornecedor> listaFiltroForn(String filtroForn) throws Exception {
        ArrayList<Fornecedor> listaFiltro = new ArrayList<Fornecedor>();
        try {
            Statement conex = conectar();
            String sql = "select * from Fornecedor ";
            sql += "where (cnpj LIKE '%" + filtroForn.trim() + "%' ";
            sql += "or nome LIKE '%" + filtroForn.trim() + "%') order by nome;";

            ResultSet rs = conex.executeQuery(sql);

            while (rs.next()) {
                Fornecedor forn = new Fornecedor();
                forn.setCnpj(rs.getString("cnpj"));
                forn.setNome(rs.getString("nome"));

                listaFiltro.add(forn);
            }
        } catch (Exception ex) {
            throw new Exception("Não foi possível Consultar os Fornecedores " + ex.getMessage());

        }
        desconectar();
        return listaFiltro;
    }

}
