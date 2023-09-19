/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfaceJP;

import ClassesBasicasJP.Equipamentos;
import ClassesBasicasJP.ItensDaNota;
import java.util.ArrayList;

/**
 *
 * @author joao.paulo
 */
public interface InterfaceItensDaNota {
    void CadastrarItensDaNota(ItensDaNota item) throws Exception;
    ArrayList<Equipamentos> listaEquip(String cnpj) throws Exception;
    ArrayList<Equipamentos> listaFiltroEquip(String filtroEquip) throws Exception;
    ArrayList<ItensDaNota> listaItensDaNota(int nf2) throws Exception;
    void RemoverItensDaNota(ItensDaNota remoItens)throws Exception;
}
