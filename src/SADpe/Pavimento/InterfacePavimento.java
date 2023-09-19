/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SADpe.Pavimento;

import java.util.ArrayList;

/**
 *
 * @author Posseidon
 */
public interface InterfacePavimento {
    void cadastrarPavimento (Pavimento pavimento)throws Exception;
    void alterarPavimento (Pavimento alterarPavimento, Pavimento selecionadoPavimento) throws Exception;
    void removerPavimento (Pavimento removerPavimento)throws Exception;
    ArrayList<Pavimento> listarPavimento (Pavimento filtroPavimento)throws Exception;    
}
