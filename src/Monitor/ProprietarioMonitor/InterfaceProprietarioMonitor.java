/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Monitor.ProprietarioMonitor;

import Monitor.ModeloMonitor.ModeloMonitor;
import java.util.ArrayList;

/**
 *
 * @author Posseidon
 */
public interface InterfaceProprietarioMonitor {
    void cadastrarProprietarioMonitor (ProprietarioMonitor proprietarioMonitor)throws Exception;
    void alterarProprietarioMonitor (ProprietarioMonitor alterarProprietarioMonitor, ProprietarioMonitor selecionadoProprietarioMonitor) throws Exception;
    void removerProprietarioMonitor (ProprietarioMonitor removerProprietarioMonitor)throws Exception;
    ArrayList<ProprietarioMonitor> listarProprietarioMonitor (ProprietarioMonitor filtroProprietarioMonitor)throws Exception;    
}
