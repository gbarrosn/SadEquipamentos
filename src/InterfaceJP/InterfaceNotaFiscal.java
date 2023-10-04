/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfaceJP;

import ClassesBasicasJP.Fornecedor;
import ClassesBasicasJP.NotaFiscal;
import java.util.ArrayList;

/**
 *
 * @author joao.paulo
 */
public interface InterfaceNotaFiscal {
    //CADASTRANDO OS DADOS DA NOTA FISCAL
    void CadastrarNF(NotaFiscal nfHp) throws Exception;        
    void AlterarNF(NotaFiscal alterNfHp, NotaFiscal selecionado) throws Exception;
    void RemoverNF(NotaFiscal remoNfHp) throws Exception;
    ArrayList<NotaFiscal> listaNotaFiscal() throws Exception;  
    ArrayList<Fornecedor> listaForn() throws Exception;
    ArrayList<NotaFiscal> listaFiltroNF(String filtroNF, String selecionado) throws Exception;
//ArrayList<NotaFiscal> listaNotaFiscalHp() throws Exception;
    
    
}
