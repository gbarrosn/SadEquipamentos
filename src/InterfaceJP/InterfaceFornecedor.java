/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfaceJP;

import ClassesBasicasJP.Fornecedor;
import java.util.ArrayList;

/**
 *
 * @author joao.paulo
 */
public interface InterfaceFornecedor {
    void cadastrarFornecedor(Fornecedor forn)throws Exception;
    void alterarFornecedor(Fornecedor altForn, Fornecedor selecionado) throws Exception;
    void removerFornecedor(Fornecedor remoForn) throws Exception;
    ArrayList<Fornecedor> listaFornecedor() throws Exception;
    ArrayList<Fornecedor> listaFiltroForn(String filtroForn) throws Exception;
    
}
