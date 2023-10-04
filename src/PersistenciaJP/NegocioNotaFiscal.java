/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PersistenciaJP;

import ClassesBasicasJP.Fornecedor;
import ClassesBasicasJP.NotaFiscal;
import DadosJP.DaoNotaFiscal;
import InterfaceJP.InterfaceNotaFiscal;
import java.util.ArrayList;

/**
 *
 * @author joao.paulo
 *
 *
 */
public class NegocioNotaFiscal implements InterfaceNotaFiscal {

    private static NegocioNotaFiscal instancia;

    public static void setInstancia(NegocioNotaFiscal aInstancia) {
        instancia = aInstancia;
    }

    private NegocioNotaFiscal() {
    }

    public static NegocioNotaFiscal getInstancia() {
        if (instancia == null) {
            setInstancia(new NegocioNotaFiscal());
        }
        return instancia;
    }

    @Override
    public void CadastrarNF(NotaFiscal nfHp) throws Exception {
        DaoNotaFiscal.getInstancia().CadastrarNF(nfHp);
    }

    @Override
    public void AlterarNF(NotaFiscal alterNfHp, NotaFiscal selecionado) throws Exception {
        if((alterNfHp.getNotaFiscal() == selecionado.getNotaFiscal())
           && (alterNfHp.getData().equals(selecionado.getData())) 
           && (alterNfHp.getCod_Forn().getCnpj().equals(selecionado.getCod_Forn().getCnpj()))){
            
            throw new Exception("Não foi alterado nem um dado.");
        }
            DaoNotaFiscal.getInstancia().AlterarNF(alterNfHp, selecionado);
    }

    @Override
    public void RemoverNF(NotaFiscal remoNfHp) throws Exception {
        DaoNotaFiscal.getInstancia().RemoverNF(remoNfHp);
    }

    @Override
    public ArrayList<NotaFiscal> listaNotaFiscal() throws Exception {
        return DaoNotaFiscal.getInstancia().listaNotaFiscal();
    }

    @Override
    public ArrayList<Fornecedor> listaForn() throws Exception {

        return DaoNotaFiscal.getInstancia().listaForn();
    }
    
    @Override
    public ArrayList<NotaFiscal> listaFiltroNF(String filtroNF, String selecionado) throws Exception {
        return DaoNotaFiscal.getInstancia().listaFiltroNF(filtroNF, selecionado);
    }

}
