/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Micro.ProprietarioMicro;

import java.util.ArrayList;

/**
 *
 * @author Posseidon
 */
public class NegocioProprietarioMicro implements InterfaceProprietarioMicro{

    @Override
    public void cadastrarProprietarioMicro(ProprietarioMicro proprietarioMicro) throws Exception {
       if (proprietarioMicro.getProprietario().trim().equals("")){
            throw new Exception ("Informe a descrição do Proprietário do Microcomputador!");
        }
        
        DadosProprietarioMicro newDados = new DadosProprietarioMicro();
        newDados.cadastrarProprietarioMicro(proprietarioMicro);
    }


    @Override
    public ArrayList<ProprietarioMicro> listarProprietarioMicro(ProprietarioMicro filtroProprietarioMicro) throws Exception {
        DadosProprietarioMicro dadosFiltroProprietarioMicro = new DadosProprietarioMicro();
        return dadosFiltroProprietarioMicro.listarProprietarioMicro(filtroProprietarioMicro);     
    }

    @Override
    public void alterarProprietarioMicro(ProprietarioMicro alterarProprietarioMicro, ProprietarioMicro selecionadoProprietarioMicro) throws Exception {
      
        if (alterarProprietarioMicro.getProprietario().equalsIgnoreCase(selecionadoProprietarioMicro.getProprietario())){
            throw new Exception("Não houve nenhuma alteração no tipo de Proprietário selecionado.");
        }
        
        if (alterarProprietarioMicro.getProprietario().trim().equals("")){
            throw new Exception ("Informe a descrição do Proprietário");
        }
        
        
        DadosProprietarioMicro newDados = new DadosProprietarioMicro();
        newDados.alterarProprietarioMicro(alterarProprietarioMicro, selecionadoProprietarioMicro);
    }

    @Override
    public void removerProprietarioMicro(ProprietarioMicro removerProprietarioMicro) throws Exception {
       DadosProprietarioMicro newDados = new DadosProprietarioMicro();
       newDados.removerProprietarioMicro(removerProprietarioMicro);
    }
    
}
