/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Monitor.MarcaMonitor;

import java.util.ArrayList;

/**
 *
 * @author Posseidon
 */
public interface InterfaceMarcaMonitor {
    void cadastrarMarcaMonitor (MarcaMonitor marcaMonitor)throws Exception;
    void alterarMarcaMonitor (MarcaMonitor alterarMarcaMonitor, MarcaMonitor selecionadoMarcaMonitor) throws Exception;
    void removerMarcaMonitor (MarcaMonitor removerMarcaMonitor)throws Exception;
    ArrayList<MarcaMonitor> listarMarcaMonitor (MarcaMonitor filtroMarcaMonitor)throws Exception;
}
