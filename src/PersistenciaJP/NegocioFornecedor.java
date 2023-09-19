/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PersistenciaJP;

import ClassesBasicasJP.Fornecedor;
import InterfaceJP.InterfaceFornecedor;
import DadosJP.DaoFornecedor;
import java.util.ArrayList;

/**
 *
 * @author joao.paulo
 */
public class NegocioFornecedor implements InterfaceFornecedor {

    private static NegocioFornecedor instancia;

    public static void setInstancia(NegocioFornecedor aInstancia) {
        instancia = aInstancia;
    }

    private NegocioFornecedor() {
    }

    public static NegocioFornecedor getInstancia() {
        if (instancia == null) {
            setInstancia(new NegocioFornecedor());
        }
        return instancia;
    }

    @Override
    public void cadastrarFornecedor(Fornecedor forn) throws Exception {
        if (forn.getNome().trim().equals("") || forn.getNome() == null) {
            throw new Exception("O NOME DO FORNECEDOR não pode estar vazio");
        }
        DaoFornecedor.getInstancia().cadastrarFornecedor(forn);
    }

    @Override
    public void alterarFornecedor(Fornecedor altForn, Fornecedor selecionado) throws Exception {
        if((altForn.getCnpj().trim().equals(selecionado.getCnpj()))
           && (altForn.getNome().trim().equals(selecionado.getNome()))){ 
            
            throw new Exception("Não foi alterado nem um dado.");
        }
        
        if (altForn.getNome().trim().equals("") || altForn.getNome() == null) {
            throw new Exception("O NOME DO FORNECEDOR não pode estar vazio");
        }
        DaoFornecedor.getInstancia().alterarFornecedor(altForn, selecionado);
    }

    @Override
    public void removerFornecedor(Fornecedor remoForn) throws Exception {
        DaoFornecedor.getInstancia().removerFornecedor(remoForn);
    }

    @Override
    public ArrayList<Fornecedor> listaFornecedor() throws Exception {
        return DaoFornecedor.getInstancia().listaFornecedor();
    }

    @Override
    public ArrayList<Fornecedor> listaFiltroForn(String filtroForn) throws Exception {
        return DaoFornecedor.getInstancia().listaFiltroForn(filtroForn);
    }

}
