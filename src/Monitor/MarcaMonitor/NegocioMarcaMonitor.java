/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Monitor.MarcaMonitor;

import Micro.MarcaMicro.DadosMarcaMicro;
import java.util.ArrayList;

/**
 *
 * @author Posseidon
 */
public class NegocioMarcaMonitor implements InterfaceMarcaMonitor{

    @Override
    public void cadastrarMarcaMonitor(MarcaMonitor marcaMonitor) throws Exception {
     if (marcaMonitor.getMarca().trim().equals("")){
            throw new Exception ("Informe a descrição da Marca");
        }
        
        DadosMarcaMonitor newDados = new DadosMarcaMonitor();
        newDados.cadastrarMarcaMonitor(marcaMonitor);
    }

    @Override
    public void alterarMarcaMonitor(MarcaMonitor alterarMarcaMonitor, MarcaMonitor selecionadoMarcaMonitor) throws Exception {
       
        if (alterarMarcaMonitor.getMarca().equalsIgnoreCase(selecionadoMarcaMonitor.getMarca())){
            throw new Exception("Não houve nenhuma alteração no tipo de Marca selecionada.");
        }
        
        if (alterarMarcaMonitor.getMarca().trim().equals("")){
            throw new Exception ("Informe a descrição da Marca");
        }
        
        
        DadosMarcaMonitor newDados = new DadosMarcaMonitor();
        newDados.alterarMarcaMonitor(alterarMarcaMonitor, selecionadoMarcaMonitor);
    }

    @Override
    public void removerMarcaMonitor(MarcaMonitor removerMarcaMonitor) throws Exception {
      DadosMarcaMonitor newDados = new DadosMarcaMonitor();
      newDados.removerMarcaMonitor(removerMarcaMonitor);
    }

    @Override
    public ArrayList<MarcaMonitor> listarMarcaMonitor(MarcaMonitor filtroMarcaMonitor) throws Exception {
        DadosMarcaMonitor dadosFiltroMarcaMonitor = new DadosMarcaMonitor();
        return dadosFiltroMarcaMonitor.listarMarcaMonitor(filtroMarcaMonitor);
    }
    
}
