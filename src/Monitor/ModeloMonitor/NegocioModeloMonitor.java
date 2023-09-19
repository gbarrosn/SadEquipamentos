/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Monitor.ModeloMonitor;

import java.util.ArrayList;

/**
 *
 * @author Posseidon
 */
public class NegocioModeloMonitor implements InterfaceModeloMonitor{

    @Override
    public void cadastrarModeloMonitor(ModeloMonitor modeloMonitor) throws Exception {
       if (modeloMonitor.getModelo().trim().equals("")){
            throw new Exception ("Informe a descrição do Modelo!");
        }
        
        DadosModeloMonitor newDados = new DadosModeloMonitor();
        newDados.cadastrarModeloMonitor(modeloMonitor);
    }

    @Override
    public void alterarModeloMonitor(ModeloMonitor alterarModeloMonitor, ModeloMonitor selecionadoModeloMonitor) throws Exception {
        
        if (alterarModeloMonitor.getModelo().equalsIgnoreCase(selecionadoModeloMonitor.getModelo())&&
            alterarModeloMonitor.getMarca()==selecionadoModeloMonitor.getMarca()){
            throw new Exception("Não houve nenhuma alteração no tipo de Modelo selecionado.");
        }
        
        if (alterarModeloMonitor.getModelo().trim().equals("")){
            throw new Exception ("Informe a descrição do Modelo");
        }
        
        
        DadosModeloMonitor newDados = new DadosModeloMonitor();
        newDados.alterarModeloMonitor(alterarModeloMonitor, selecionadoModeloMonitor);
    }

    @Override
    public void removerModeloMonitor(ModeloMonitor removerModeloMonitor) throws Exception {
       DadosModeloMonitor newDados = new DadosModeloMonitor();
       newDados.removerModeloMonitor(removerModeloMonitor);
    }

    @Override
    public ArrayList<ModeloMonitor> listarModeloMonitor(ModeloMonitor filtroModeloMonitor) throws Exception {
        DadosModeloMonitor dadosFiltroModeloMonitor = new DadosModeloMonitor();
        return dadosFiltroModeloMonitor.listarModeloMonitor(filtroModeloMonitor);
    }
    
}
