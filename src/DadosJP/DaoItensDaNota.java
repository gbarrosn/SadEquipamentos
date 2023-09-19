/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DadosJP;

import ClassesBasicasJP.Equipamentos;
//import ClassesBasicasJP.Fornecedor;
import ClassesBasicasJP.ItensDaNota;
import Geral.ConectarSQL;
import InterfaceJP.InterfaceItensDaNota;
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
public class DaoItensDaNota extends ConectarSQL implements InterfaceItensDaNota {

    private static DaoItensDaNota instancia;

    public static void setInstancia(DaoItensDaNota aInstancia) {
        instancia = aInstancia;
    }

    private DaoItensDaNota() {
    }

    public static DaoItensDaNota getInstancia() {
        if (instancia == null) {
            setInstancia(new DaoItensDaNota());
        }
        return instancia;
    }

    @Override
    public void CadastrarItensDaNota(ItensDaNota item) throws Exception {
        try {
            Connection ConectarSQL = conectarPrepared();
            String sql = "Insert into Equipamentos.dbo.ItensDaNota([cod_NF], [cod_Equip], [quantidade], [valor_Unidade], [valor_Total_Item])";
            sql += "values (?,?,?,?,?)";
            PreparedStatement conex = ConectarSQL.prepareStatement(sql);
            conex.setInt(1, item.getCod_NF().getCodigo());
            conex.setInt(2, item.getCod_Equip().getCodigo());
            conex.setInt(3, item.getQuantidade());
             conex.setString(4, item.getValorUnidade());
             conex.setString(5, item.getValorTotalItem());

            conex.executeUpdate();

        } catch (Exception ex) {
            throw new Exception("Não foi possível inserir Itens na Nota Fiscal  - " + ex.getMessage());
        }
        desconectar();
    }

    @Override
    public ArrayList<Equipamentos> listaEquip(String cnpj) throws Exception {
        ArrayList<Equipamentos> listaEquip = new ArrayList<Equipamentos>();
        try {
            Statement conex = conectar();

            String sql = "select Equipamentos.codigo, Equipamentos.categoria, Equipamentos.especificacao, Equipamentos.valorUnitario from Equipamentos inner join  Fornecedor on  Equipamentos.cnpj_forn = Fornecedor.cnpj  where Equipamentos.cnpj_forn '" + cnpj + "' order by categoria;" ;

            ResultSet rs = conex.executeQuery(sql);

            while (rs.next()) {
                Equipamentos equip = new Equipamentos();
                equip.setCodigo(rs.getInt("codigo"));
                equip.setCategoria(rs.getString("categoria"));
                equip.setEspecificacao(rs.getString("especificacao"));
                equip.setValUnitario(rs.getString("valorUnitario"));

                listaEquip.add(equip);
            }

        } catch (SQLException e) {
            throw new Exception("Não foi possível Consultar os Equipamentos  " + e.getMessage());
        }
        desconectar();
        return listaEquip;
    }

    @Override
    public ArrayList<ItensDaNota> listaItensDaNota(int nf) throws Exception {
        ArrayList<ItensDaNota> listaItens = new ArrayList<ItensDaNota>();
        try {
            Statement conex = conectar();

            String sql = "select ItensDaNota.codigo, Equipamentos.categoria, Equipamentos.especificacao, ItensDaNota.valor_Unidade, ItensDaNota.quantidade, ItensDaNota.valor_Total_Item";
            sql += " from ItensDaNota inner join Equipamentos on ItensDaNota.cod_Equip = Equipamentos.codigo where ItensDaNota.cod_NF = " + nf + " order by Equipamentos.categoria ;";
           
            ResultSet rs = conex.executeQuery(sql);

            while (rs.next()) {
                Equipamentos equip = new Equipamentos();
                ItensDaNota item = new ItensDaNota();
                //RECEBENDO OS VALORES DO EQUIPAMENTO 
                equip.setCategoria(rs.getString("categoria"));
                equip.setEspecificacao(rs.getString("especificacao"));
                item.setCod_Equip(equip);
                //RECEBENDO OS ITENS
                item.setCodigo(rs.getInt("codigo"));
                item.setValorUnidade(rs.getString("valor_Unidade"));
                item.setQuantidade(rs.getInt("quantidade"));
                item.setValorTotalItem(rs.getString("valor_Total_Item"));
                listaItens.add(item);
            }

        } catch (SQLException e) {
            throw new Exception("Não foi possível Listar os Itens da Nota" + e.getMessage());
        }
        desconectar();
        return listaItens;

    }

    
    @Override
    public ArrayList<Equipamentos> listaFiltroEquip(String filtroEquip) throws Exception {
        ArrayList<Equipamentos> listaFiltro = new ArrayList<Equipamentos>();
        try {
            Statement conex = conectar();
            String sql = "Select Equipamentos.codigo, Equipamentos.categoria, Equipamentos.especificacao, Equipamentos.valorUnitario from Equipamentos inner join "
                    + "Fornecedor on Equipamentos.cnpj_forn = Fornecedor.cnpj ";
            sql += "where (Equipamentos.codigo LIKE '%" + filtroEquip.trim() + "%' ";
            sql += "or Equipamentos.categoria LIKE '%" + filtroEquip.trim() + "%' ";
            sql += "or Equipamentos.especificacao LIKE '%" + filtroEquip.trim() + "%' ";
            sql += "or Equipamentos.valorUnitario LIKE '%" + filtroEquip.trim() + "%') order by categoria ";

            ResultSet rs = conex.executeQuery(sql);

            while (rs.next()) {
                Equipamentos equip = new Equipamentos();
                equip.setCodigo(rs.getInt("codigo"));
                equip.setCategoria(rs.getString("categoria"));
                equip.setEspecificacao(rs.getString("especificacao"));
                equip.setValUnitario(rs.getString("valorUnitario"));
                listaFiltro.add(equip);

            }
        } catch (Exception e) {
            throw new Exception("Não foi possível Consultar os Equipamentos " + e.getMessage());
        }
        desconectar();
        return listaFiltro;
    }

    @Override
    public void RemoverItensDaNota(ItensDaNota remoItens) throws Exception {
       Statement conex = conectar();
        try {
            String sql = "DELETE FROM dbo.ItensDaNota WHERE codigo = " + remoItens.getCodigo();
            conex.execute(sql);
        } catch (Exception ex) {
            throw new Exception("Não foi possível Remover o Item da Nota - " + ex.getMessage());
        }
        desconectar();
    }
}
