/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DadosJP;

import ClassesBasicasJP.Equipamentos;
import ClassesBasicasJP.Fornecedor;
import InterfaceJP.InterfaceEquipamentos;
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
public class DaoEquipamentos extends ConectarSQL implements InterfaceEquipamentos {

    private static DaoEquipamentos instancia;

    public static void setInstancia(DaoEquipamentos aInstancia) {
        instancia = aInstancia;
    }

    private DaoEquipamentos() {
    }

    public static DaoEquipamentos getInstancia() {
        if (instancia == null) {
            setInstancia(new DaoEquipamentos());
        }
        return instancia;
    }

    @Override
    public void cadastrarEquipamentos(Equipamentos equip) throws Exception {
        try {
            Connection ConectarSQL = conectarPrepared();
            String sql = "Insert into Equipamentos.dbo.Equipamentos([cnpj_forn], [tombamento], [categoria], [especificacao], [valorUnitario], [serie])";
            sql += "values (?,?,?,?,?,?)";
            PreparedStatement conex = ConectarSQL.prepareStatement(sql);
            conex.setString(1, equip.getCnpj_forn().getCnpj());
            conex.setString(2, equip.getTombamento());
            conex.setString(3, equip.getCategoria());
            conex.setString(4, equip.getEspecificacao());
            conex.setString(5, equip.getValUnitario());
            conex.setString(6, equip.getSerie());

            conex.executeUpdate();

        } catch (Exception ex) {
            throw new Exception("Não foi possível Cadastrar o Equipamento - " + ex.getMessage());
        }
        desconectar();
    }

    @Override
    public void alterarEquipamentos(Equipamentos alterEquip, Equipamentos selecionado) throws Exception {
        try {

            Statement conex = conectar();
            String sql = "UPDATE Equipamentos.dbo.Equipamentos set ";
            sql += "cnpj_forn = '" + alterEquip.getCnpj_forn().getCnpj() + "', tombamento = '" + alterEquip.getTombamento() + "', categoria = '" + alterEquip.getCategoria()+ "', especificacao = '" + alterEquip.getEspecificacao() + "', valorUnitario = '" + alterEquip.getValUnitario() + "', serie = '" + alterEquip.getSerie() + "' ";
            sql += "where codigo = " + selecionado.getCodigo() + ";";

            conex.execute(sql);

        } catch (Exception ex) {
            throw new Exception("Não foi possível Alterar o Equipamento - " + ex.getMessage());
        }
        desconectar();
    }

    @Override
    public void removerEquipamentos(Equipamentos removeEquip) throws Exception {
        Statement conex = conectar();
        try {
            //   Connection ConectarSQL = conectarPrepared();
            String sql = "DELETE FROM dbo.Equipamentos WHERE codigo = " + removeEquip.getCodigo();
            conex.execute(sql);
        } catch (Exception ex) {
            throw new Exception("Não foi possível Remover este Equipamento - " + ex.getMessage());
        }
        desconectar();
    }


    @Override

    public ArrayList<Equipamentos> listaFiltroEquipamentos(String filtroEquip, String selecionado) throws Exception {
        ArrayList<Equipamentos> listaFiltro = new ArrayList<Equipamentos>();
        try {

            Statement conex = conectar();
            String sql = "SELECT  [codigo], [cnpj_forn], [tombamento], [categoria], [especificacao], [valorUnitario], [serie] FROM [Equipamentos].[dbo].[Equipamentos] INNER JOIN Equipamentos.dbo.Fornecedor on Equipamentos.cnpj_forn = Fornecedor.cnpj";

            //TIRANDO OS ESPAÇOS EM BRANCO ANTES E DEPOIS DO FILTRO E VERIFICANDO O QUE FOI DIGITADO NA PALAVRA TODA
            switch (selecionado.trim()) {

                case "Codigo": 
                    sql += "where Equipamentos.codigo LIKE '%" + filtroEquip.trim() + "%' order by categoria ; ";
                    break;
                case "Tombamento":
                    sql += "where Equipamentos.tombamento LIKE '%" + filtroEquip.trim() + "%' order by categoria ; ";
                    break;
                case "Número Série":
                    sql += "where Equipamentos.serie LIKE '%" + filtroEquip.trim() + "%' order by categoria ; ";
                    break;
                case "Categoria":
                    sql += "where Equipamentos.categoria LIKE '%" + filtroEquip.trim().toUpperCase() + "%' order by categoria ; ";
                    break;
                case "Especificação":
                    sql += "where Equipamentos.especificacao LIKE '%" + filtroEquip.trim().toUpperCase() + "%' order by categoria ; ";
                    break;
                case "Valor Unitário":
                    sql += "where Equipamentos.valorUnitario LIKE '%" + filtroEquip.trim() + "%' order by categoria ; ";
                    break;
                case "Cnpj":
                    sql += "where Fornecedor.cnpj LIKE '%" + filtroEquip.trim() + "%' order by categoria ; ";
                    break;
                case "Fornecedor":
                    sql += "where Fornecedor.nome LIKE '%" + filtroEquip.trim() + "%' order by categoria ; ";
                    break;
                default:
                    sql += "where (Equipamentos.codigo LIKE '%" + filtroEquip.trim() + "%' ";
                    sql += "or Equipamentos.tombamento LIKE '%" + filtroEquip.trim() + "%' ";
                    sql += "or Equipamentos.serie LIKE '%" + filtroEquip.trim() + "%' ";
                    sql += "or Equipamentos.categoria LIKE '%" + filtroEquip.trim() + "%' ";
                    sql += "or Equipamentos.especificacao LIKE '%" + filtroEquip.trim() + "%' ";
                    sql += "or Equipamentos.valorUnitario LIKE '%" + filtroEquip.trim() + "%' ";
                    sql += "or Fornecedor.cnpj LIKE '%" + filtroEquip.trim() + "%' ";
                    sql += "or Fornecedor.nome LIKE '%" + filtroEquip.trim() + "%') order by categoria ";
                    break;
            }

            ResultSet rs = conex.executeQuery(sql);

            while (rs.next()) {
               Equipamentos equip = new Equipamentos();
                Fornecedor forn = new Fornecedor();
                equip.setCodigo(rs.getInt("codigo"));
                equip.setTombamento(rs.getString("tombamento"));
                equip.setSerie(rs.getString("serie"));
                equip.setCategoria(rs.getString("categoria"));
                equip.setEspecificacao(rs.getString("especificacao"));
                equip.setValUnitario(rs.getString("valorUnitario"));
                //FORNECEDOR
                forn.setCnpj(rs.getString("cnpj"));
                forn.setNome(rs.getString("nome"));
                equip.setCnpj_forn(forn);
                
                
                listaFiltro.add(equip);

            }

        } catch (SQLException e) {
            throw new Exception("Não foi possível Consultar os Equipamentos " + e.getMessage());
        }
        desconectar();
        return listaFiltro;

    }

    @Override
    public ArrayList<Fornecedor> listaEscolherForn() throws Exception {
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
    public ArrayList<Equipamentos> listaTudoEquip() throws Exception {
        ArrayList<Equipamentos> listaEquip = new ArrayList<Equipamentos>();
        try {
            Statement conex = conectar();

            String sql = "Select Equipamentos.codigo, Equipamentos.tombamento, Equipamentos.serie, Equipamentos.categoria, Equipamentos.especificacao, Equipamentos.valorUnitario, Fornecedor.cnpj, Fornecedor.nome from Equipamentos inner join "
                    + "Fornecedor on Equipamentos.cnpj_forn = Fornecedor.cnpj order by Equipamentos.categoria;";
            ResultSet rs = conex.executeQuery(sql);

            while (rs.next()) {
                Equipamentos equip = new Equipamentos();
                Fornecedor forn = new Fornecedor();
                equip.setCodigo(rs.getInt("codigo"));
                equip.setTombamento(rs.getString("tombamento"));
                equip.setSerie(rs.getString("serie"));
                equip.setCategoria(rs.getString("categoria"));
                equip.setEspecificacao(rs.getString("especificacao"));
                equip.setValUnitario(rs.getString("valorUnitario"));
                //FORNECEDOR
                forn.setCnpj(rs.getString("cnpj"));
                forn.setNome(rs.getString("nome"));
                equip.setCnpj_forn(forn);

                listaEquip.add(equip);
            }

        } catch (SQLException e) {
            throw new Exception("Não foi possível Consultar os Equipamentos" + e.getMessage());
        }
        desconectar();
        return listaEquip;
    }

    @Override
    public void alterarTombEquipamentos(Equipamentos tomb, Equipamentos selecionado) throws Exception {
        try {

            Statement conex = conectar();
            String sql = "UPDATE Equipamentos.dbo.Equipamentos set ";
            sql += "tombamento = '" + tomb.getTombamento() + "', serie = '" + tomb.getSerie() + "'  where codigo = " + selecionado.getCodigo() + ";";

            conex.execute(sql);

        } catch (Exception ex) {
            throw new Exception("Não foi possível Alterar o Tombamento ou Série do Equipamento - " + ex.getMessage());
        }
        desconectar();
    }


}
