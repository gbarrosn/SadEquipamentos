/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PersistenciaJP;

import ClassesBasicasJP.Equipamentos;
import ClassesBasicasJP.ItensDaNota;
import DadosJP.DaoItensDaNota;
import InterfaceJP.InterfaceItensDaNota;
import java.util.ArrayList;

/**
 *
 * @author joao.paulo
 */
public class NegocioItensDaNota implements InterfaceItensDaNota {

    private static NegocioItensDaNota instancia;

    public static void setInstancia(NegocioItensDaNota aInstancia) {
        instancia = aInstancia;
    }

    private NegocioItensDaNota() {
    }

    public static NegocioItensDaNota getInstancia() {
        if (instancia == null) {
            setInstancia(new NegocioItensDaNota());
        }
        return instancia;
    }

    @Override
    public void CadastrarItensDaNota(ItensDaNota item) throws Exception {
        DaoItensDaNota.getInstancia().CadastrarItensDaNota(item);
    }

    @Override
    public ArrayList<Equipamentos> listaEquip(String cnpj) throws Exception {
        return DaoItensDaNota.getInstancia().listaEquip(cnpj);
    }

    @Override
    public ArrayList<ItensDaNota> listaItensDaNota(int nf) throws Exception {
        return DaoItensDaNota.getInstancia().listaItensDaNota(nf);
    }

    @Override
    public ArrayList<Equipamentos> listaFiltroEquip(String filtroEquip) throws Exception {
      return  DaoItensDaNota.getInstancia().listaFiltroEquip(filtroEquip);
    }

    @Override
    public void RemoverItensDaNota(ItensDaNota remoItens) throws Exception {
        DaoItensDaNota.getInstancia().RemoverItensDaNota(remoItens);
    }

}
