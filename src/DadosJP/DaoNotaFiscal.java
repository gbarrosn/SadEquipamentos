/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DadosJP;

import ClassesBasicasJP.Fornecedor;
import ClassesBasicasJP.NotaFiscal;
import Geral.ConectarSQL;
import InterfaceJP.InterfaceNotaFiscal;
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
public class DaoNotaFiscal extends ConectarSQL implements InterfaceNotaFiscal {

    private static DaoNotaFiscal instancia;

    public static void setInstancia(DaoNotaFiscal aInstancia) {
        instancia = aInstancia;
    }

    private DaoNotaFiscal() {
    }

    public static DaoNotaFiscal getInstancia() {
        if (instancia == null) {
            setInstancia(new DaoNotaFiscal());
        }
        return instancia;
    }

    @Override
    public void CadastrarNF(NotaFiscal nf) throws Exception {
        try {
            Connection ConectarSQL = conectarPrepared();
            String sql = "Insert into Equipamentos.dbo.NotaFiscal(cod_Fornecedor, notaFiscal, data)";
            sql += "values (?,?,?)";
            PreparedStatement conex = ConectarSQL.prepareStatement(sql);
            conex.setString(1, nf.getCod_Forn().getCnpj());
            conex.setLong(2, nf.getNotaFiscal());
            conex.setString(3, nf.getData());

            conex.executeUpdate();

        } catch (Exception ex) {
            throw new Exception("Não foi possível cadastrar uma nova Nota Fiscal  - " + ex.getMessage());
        }
        desconectar();
    }

    @Override
    public void AlterarNF(NotaFiscal alterNf, NotaFiscal selecionado) throws Exception {
        try {

            Statement conex = conectar();
            String sql = "UPDATE Equipamentos.dbo.NotaFiscal set ";
            sql += "notaFiscal = " + alterNf.getNotaFiscal() + ", cod_Fornecedor = '" + alterNf.getCod_Forn().getCnpj() + "', data = '" + alterNf.getData() + "' ";
            sql += " where codigo = " + selecionado.getCodigo() + ";";

            conex.execute(sql);

        } catch (Exception ex) {
            throw new Exception("Não foi possível Alterar a Nota Fiscal - " + ex.getMessage());
        }
        desconectar();
    }

    @Override
    public void RemoverNF(NotaFiscal remoNf) throws Exception {
        Statement conex = conectar();
        try {
            //   Connection ConectarSQL = conectarPrepared();
            String sql = "DELETE FROM dbo.NotaFiscal WHERE codigo = " + remoNf.getCodigo();
            conex.execute(sql);
        } catch (Exception ex) {
            throw new Exception("Não foi possível Remover esta Nota Fiscal" + ex.getMessage());
        }
        desconectar();
    }

    @Override
    public ArrayList<NotaFiscal> listaNotaFiscal() throws Exception {
        ArrayList<NotaFiscal> listaNF = new ArrayList<NotaFiscal>();

        try {
            Statement conex = conectar();

            String sql = "select NotaFiscal.codigo, NotaFiscal.notaFiscal, Fornecedor.cnpj, Fornecedor.nome, NotaFiscal.data from NotaFiscal inner join Fornecedor \n"
                    + "  on NotaFiscal.cod_Fornecedor = Fornecedor.cnpj;";
            ResultSet rs = conex.executeQuery(sql);

            while (rs.next()) {
                NotaFiscal nota = new NotaFiscal();
                Fornecedor forn = new Fornecedor();
                nota.setCodigo(rs.getInt("codigo"));
                nota.setNotaFiscal(rs.getLong("notaFiscal"));
                //PEGANDO VALORES DO FORNECEDOR
                forn.setCnpj(rs.getString("cnpj"));
                forn.setNome(rs.getString("nome"));
                nota.setCod_Forn(forn);
                nota.setData(rs.getString("data"));
                listaNF.add(nota);
            }

        } catch (SQLException e) {
            throw new Exception("Não foi possível Consultar as Notas Fiscais" + e.getMessage());
        }
        desconectar();
        return listaNF;

    }

    @Override
    public ArrayList<Fornecedor> listaForn() throws Exception {
        ArrayList<Fornecedor> listaForn = new ArrayList<Fornecedor>();

        try {
            Statement conex = conectar();

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
    public ArrayList<NotaFiscal> listaFiltroNF(String filtroNF, String selecionado) throws Exception {
        ArrayList<NotaFiscal> listaFiltro = new ArrayList<NotaFiscal>();
        try {

            Statement conex = conectar();
            String sql = "Select NotaFiscal.codigo, NotaFiscal.notaFiscal, Fornecedor.cnpj, Fornecedor.nome, NotaFiscal.data from NotaFiscal inner join Fornecedor on NotaFiscal.cod_Fornecedor = Fornecedor.cnpj ";

            //TIRANDO OS ESPAÇOS EM BRANCO ANTES E DEPOIS DO FILTRO E VERIFICANDO O QUE FOI DIGITADO NA PALAVRA TODA
            switch (selecionado.trim()) {

                case "Código":
                    sql += "where NotaFiscal.codigo LIKE '%" + filtroNF.trim() + "%' ; ";
                    break;
                case "Nota Fiscal":
                    sql += "where NotaFiscal.notaFiscal LIKE '%" + filtroNF.trim() + "%' ; ";
                    break;
                case "Cnpj":
                    sql += "where Fornecedor.cnpj LIKE '%" + filtroNF.trim().toUpperCase() + "%' ; ";
                    break;
                case "Fornecedor":
                    sql += "where Fornecedor.nome LIKE '%" + filtroNF.trim().toUpperCase() + "%' ; ";
                    break;
                case "Data":
                    sql += "where NotaFiscal.data LIKE '%" + filtroNF.trim() + "%' ; ";
                    break;
                default:
                    sql += "where (NotaFiscal.codigo LIKE '%" + filtroNF.trim() + "%' ";
                    sql += "or NotaFiscal.notaFiscal LIKE '%" + filtroNF.trim() + "%' ";
                    sql += "or Fornecedor.cnpj LIKE '%" + filtroNF.trim() + "%' ";
                    sql += "or Fornecedor.nome LIKE '%" + filtroNF.trim() + "%' ";
                    sql += "or NotaFiscal.data LIKE '%" + filtroNF.trim() + "%')";
                    break;
            }

            ResultSet rs = conex.executeQuery(sql);

            while (rs.next()) {
                NotaFiscal nf = new NotaFiscal();
                Fornecedor forn = new Fornecedor();
                nf.setCodigo(rs.getInt("codigo"));
                nf.setNotaFiscal(rs.getLong("notaFiscal"));
              
                //FORNECEDOR
                forn.setCnpj(rs.getString("cnpj"));
                forn.setNome(rs.getString("nome"));
                nf.setCod_Forn(forn);
                
                nf.setData(rs.getString("data"));

                listaFiltro.add(nf);

            }

        } catch (SQLException e) {
            throw new Exception("Não foi possível Consultar as Notas Fiscais " + e.getMessage());
        }
        desconectar();
        return listaFiltro;

    }

}
