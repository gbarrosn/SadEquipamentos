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
public class NegocioPavimento implements InterfacePavimento{

    @Override
    public void cadastrarPavimento(Pavimento pavimento) throws Exception {
       
           if (pavimento.getPavimento().trim().equals("")){
               throw new Exception ("Informe uma descrição para o Pavimento!");
           }
           
           
           DadosPavimento dados = new DadosPavimento();
           dados.cadastrarPavimento(pavimento);
    }

    @Override
    public void alterarPavimento(Pavimento alterarPavimento, Pavimento selecionadoPavimento) throws Exception {
       
        try{
        
        if (alterarPavimento.getPavimento().equalsIgnoreCase(selecionadoPavimento.getPavimento())){
            throw new Exception("Não houve nenhuma alteração no Pavimento.");
        }
        
        if (alterarPavimento.getPavimento().trim().equals("")){
            throw new Exception ("Informe a descrição do pavimento!");
        }
        
        
        DadosPavimento dados = new DadosPavimento();
        dados.alterarPavimento(alterarPavimento, selecionadoPavimento);
        
        }catch (Exception ex){
             throw new Exception("Erro - "+ ex.getMessage());
        }
        
    }

    @Override
    public void removerPavimento(Pavimento removerPavimento) throws Exception {
        DadosPavimento dados = new DadosPavimento();
        dados.removerPavimento(removerPavimento);
    }

    @Override
    public ArrayList<Pavimento> listarPavimento(Pavimento filtroPavimento) throws Exception {
        DadosPavimento dadosFiltroPavimento = new DadosPavimento();
        return dadosFiltroPavimento.listarPavimento(filtroPavimento);
    }
    
}
