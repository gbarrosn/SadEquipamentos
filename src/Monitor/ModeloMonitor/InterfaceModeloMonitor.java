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
public interface InterfaceModeloMonitor {
    void cadastrarModeloMonitor (ModeloMonitor modeloMonitor)throws Exception;
    void alterarModeloMonitor (ModeloMonitor alterarModeloMonitor, ModeloMonitor selecionadoModeloMonitor) throws Exception;
    void removerModeloMonitor (ModeloMonitor removerModeloMonitor)throws Exception;
    ArrayList<ModeloMonitor> listarModeloMonitor (ModeloMonitor filtroModeloMonitor)throws Exception;    
}
