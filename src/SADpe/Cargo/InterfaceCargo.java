/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SADpe.Cargo;


import java.util.ArrayList;

/**
 *
 * @author Posseidon
 */
public interface InterfaceCargo {
    void cadastrarCargo (Cargo cargo)throws Exception;
    void alterarCargo (Cargo alterarCargo, Cargo selecionadoCargo) throws Exception;
    void removerCargo (Cargo removerCargo)throws Exception;
    ArrayList<Cargo> listarCargo (Cargo filtroCargo)throws Exception;    
}
