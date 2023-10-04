/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Monitor.ProprietarioMonitor;

import java.util.ArrayList;

/**
 *
 * @author Posseidon
 */
public class NegocioProprietarioMonitor implements InterfaceProprietarioMonitor{

    @Override
    public void cadastrarProprietarioMonitor(ProprietarioMonitor proprietarioMonitor) throws Exception {
     if (proprietarioMonitor.getProprietario().trim().equals("")){
            throw new Exception ("Informe a descrição do Proprietário do Monitor!");
        }
        
        DadosProprietarioMonitor newDados = new DadosProprietarioMonitor();
        newDados.cadastrarProprietarioMonitor(proprietarioMonitor);
    }

    @Override
    public void alterarProprietarioMonitor(ProprietarioMonitor alterarProprietarioMonitor, ProprietarioMonitor selecionadoProprietarioMonitor) throws Exception {
       
        if (alterarProprietarioMonitor.getProprietario().equalsIgnoreCase(selecionadoProprietarioMonitor.getProprietario())){
            throw new Exception("Não houve nenhuma alteração no tipo de Proprietário selecionado.");
        }
        
        if (alterarProprietarioMonitor.getProprietario().trim().equals("")){
            throw new Exception ("Informe a descrição do Proprietário");
        }
        
        
        DadosProprietarioMonitor newDados = new DadosProprietarioMonitor();
        newDados.alterarProprietarioMonitor(alterarProprietarioMonitor, selecionadoProprietarioMonitor);
    }

    @Override
    public void removerProprietarioMonitor(ProprietarioMonitor removerProprietarioMonitor) throws Exception {
      DadosProprietarioMonitor newDados = new DadosProprietarioMonitor();
      newDados.removerProprietarioMonitor(removerProprietarioMonitor);
    }

    @Override
    public ArrayList<ProprietarioMonitor> listarProprietarioMonitor(ProprietarioMonitor filtroProprietarioMonitor) throws Exception {
        DadosProprietarioMonitor dadosFiltroProprietarioMonitor = new DadosProprietarioMonitor();
        return dadosFiltroProprietarioMonitor.listarProprietarioMonitor(filtroProprietarioMonitor);
    }
    
}
