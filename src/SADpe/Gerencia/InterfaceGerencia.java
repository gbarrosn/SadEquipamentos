/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SADpe.Gerencia;

import SADpe.Cargo.Cargo;
import java.util.ArrayList;

/**
 *
 * @author Posseidon
 */
public interface InterfaceGerencia {
    void cadastrarGerencia (Gerencia gerencia)throws Exception;
    void alterarGerencia (Gerencia alterarGerencia, Gerencia selecionadoGerencia) throws Exception;
    void removerGerencia (Gerencia removerGerencia)throws Exception;
    ArrayList<Gerencia> listarGerencia (Gerencia filtroGerencia)throws Exception;    
}
