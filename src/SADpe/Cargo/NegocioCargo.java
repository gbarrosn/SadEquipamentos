/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SADpe.Cargo;

import Micro.OS.DadosOS;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Posseidon
 */
public class NegocioCargo implements InterfaceCargo{

    @Override
    public void cadastrarCargo(Cargo cargo) throws Exception {
       
           if (cargo.getCargo().trim().equals("")){
               throw new Exception ("Informe uma descrição para o Cargo!");
           }
           
           
           DadosCargo dados = new DadosCargo();
           dados.cadastrarCargo(cargo);
           
    }

    @Override
    public void alterarCargo(Cargo alterarCargo, Cargo selecionadoCargo) throws Exception {
        
        
        if (alterarCargo.getCargo().equalsIgnoreCase(selecionadoCargo.getCargo())){
            throw new Exception("Não houve nenhuma alteração no Cargo.");
        }
        
        if (alterarCargo.getCargo().trim().equals("")){
            throw new Exception ("Informe a descrição do Cargo!");
        }
        
        
        DadosCargo dados = new DadosCargo();
        dados.alterarCargo(alterarCargo, selecionadoCargo);
        
        
    }

    @Override
    public void removerCargo(Cargo removerCargo) throws Exception {
        DadosCargo dados = new DadosCargo();
        dados.removerCargo(removerCargo);
    }

    @Override
    public ArrayList<Cargo> listarCargo(Cargo filtroCargo) throws Exception {
        DadosCargo dadosFiltroCargo  = new DadosCargo();
        return dadosFiltroCargo.listarCargo(filtroCargo);
    }
    
}
