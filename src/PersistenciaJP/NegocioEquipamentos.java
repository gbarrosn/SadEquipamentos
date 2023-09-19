/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PersistenciaJP;

import ClassesBasicasJP.Equipamentos;
import ClassesBasicasJP.Fornecedor;
import InterfaceJP.InterfaceEquipamentos;
import DadosJP.DaoEquipamentos;
import java.util.ArrayList;

/**
 *
 * @author joao.paulo
 */
public class NegocioEquipamentos implements InterfaceEquipamentos {

    private static NegocioEquipamentos instancia;

    public static void setInstancia(NegocioEquipamentos aInstancia) {
        instancia = aInstancia;
    }

    private NegocioEquipamentos() {
    }

    public static NegocioEquipamentos getInstancia() {
        if (instancia == null) {
            setInstancia(new NegocioEquipamentos());
        }
        return instancia;
    }

    @Override
    public void cadastrarEquipamentos(Equipamentos equip) throws Exception {
        
        
        if(equip.getTombamento()  == null || equip.getTombamento().trim().equals("") ){
            throw new Exception(" Informe o número do Tombamento ");
        }
        if (equip.getEspecificacao().trim().equals("") || equip.getEspecificacao() == null) {
            throw new Exception(" Informe a Especificação deste equipamento");
        }
        if (equip.getCategoria().trim().equals("Selecione a categoria do equipamento")){
            throw new Exception(" Informe a Categoria do equipamento que está cadastrando");
        }   
        if (equip.getSerie() == null || equip.getSerie().trim().equals("")){
            throw new Exception(" Informe o número de Série do equipamento que está cadastrando");
        }   
        
      
        
        
        DaoEquipamentos.getInstancia().cadastrarEquipamentos(equip);
    }

    @Override
    public void alterarEquipamentos(Equipamentos alterEquip, Equipamentos selecionado) throws Exception {
        if((alterEquip.getTombamento() == selecionado.getTombamento())
           && (alterEquip.getEspecificacao().equals(selecionado.getEspecificacao()))
           && (alterEquip.getCategoria().equals(selecionado.getCategoria()))     
           && (alterEquip.getValUnitario().equals(selecionado.getValUnitario()))
           && (alterEquip.getCnpj_forn().getCnpj().equals(selecionado.getCnpj_forn().getCnpj()))     ){
            
            throw new Exception("Não foi alterado nem um dado.");
        }
        
        
        
        if(alterEquip.getTombamento()  == null || alterEquip.getTombamento().trim().equals("") ){
            throw new Exception(" Informe o número do Tombamento ");
        }

        if (alterEquip.getEspecificacao().trim().equals("") || alterEquip.getEspecificacao() == null) {
            throw new Exception(" O campo de Especificação não pode estar vazio");
        }
       
        
        
        DaoEquipamentos.getInstancia().alterarEquipamentos(alterEquip, selecionado);
     
    }

    @Override
    public void removerEquipamentos(Equipamentos removeEquip) throws Exception {
        DaoEquipamentos.getInstancia().removerEquipamentos(removeEquip);
    }

    @Override
    public ArrayList<Equipamentos> listaFiltroEquipamentos(String filtroEquip, String selecionado) throws Exception {
       if(filtroEquip.trim().equals("")){
           throw new Exception("Informe algum valor para a consulta");
       }
       return DaoEquipamentos.getInstancia().listaFiltroEquipamentos(filtroEquip, selecionado);
    }

    @Override
    public ArrayList<Fornecedor> listaEscolherForn() throws Exception {
       return DaoEquipamentos.getInstancia().listaEscolherForn();
    }

    @Override
    public ArrayList<Equipamentos> listaTudoEquip() throws Exception {
        return DaoEquipamentos.getInstancia().listaTudoEquip();
    }

    @Override
    public void alterarTombEquipamentos(Equipamentos tomb, Equipamentos selecionado) throws Exception {
        DaoEquipamentos.getInstancia().alterarTombEquipamentos(tomb, selecionado);
    }


}
