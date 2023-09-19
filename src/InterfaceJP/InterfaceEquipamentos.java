/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfaceJP;

import ClassesBasicasJP.Equipamentos;
import ClassesBasicasJP.Fornecedor;
import java.util.ArrayList;

/**
 *
 * @author joao.paulo
 */
public interface InterfaceEquipamentos {
    
    void cadastrarEquipamentos(Equipamentos equip) throws Exception;
    void alterarEquipamentos(Equipamentos alterEquip, Equipamentos selecionado) throws Exception;
    void removerEquipamentos(Equipamentos removeEquip) throws Exception;
    void alterarTombEquipamentos(Equipamentos tomb, Equipamentos selecionado) throws Exception;
    ArrayList<Equipamentos> listaTudoEquip() throws Exception;
    ArrayList<Fornecedor> listaEscolherForn() throws Exception;
    ArrayList<Equipamentos> listaFiltroEquipamentos(String filtroEquip, String selecionado) throws Exception;
    
}
