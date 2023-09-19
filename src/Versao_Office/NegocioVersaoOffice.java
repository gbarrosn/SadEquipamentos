/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Versao_Office;
import java.util.ArrayList;

/**
 *
 * @author Posseidon
 */
public class NegocioVersaoOffice implements InterfaceVersaoOffice {

    @Override
    public void cadastrarVersaoOffice(VersaoOffice versaoOffice) throws Exception {
     
        if (versaoOffice.getDescricao().trim().equals("")){
               throw new Exception ("Informe uma descrição para o Office!");
           }
           
           
           DadosVersaoOffice dadosversaoOffice = new DadosVersaoOffice();
           dadosversaoOffice.cadastrarVersaoOffice(versaoOffice);
    }

    @Override
    public void alterarVersaoOffice(VersaoOffice alterarVersaoOffice, VersaoOffice selecionadoVersaoOffice) throws Exception {
        if (alterarVersaoOffice.getDescricao().equals(selecionadoVersaoOffice.getDescricao())){
            throw new Exception ("Não houve nenhuma alteração na descrição do Office.");
        }
        
        if (alterarVersaoOffice.getDescricao().trim().equals("")){
               throw new Exception ("Informe uma descrição para o Office!");
           }
           
           
           DadosVersaoOffice dadosalterarversaoOffice = new DadosVersaoOffice();
           dadosalterarversaoOffice.alterarVersaoOffice(alterarVersaoOffice, selecionadoVersaoOffice);
    }

    @Override
    public void removerVersaoOffice(VersaoOffice removerVersaoOffice) throws Exception {
       DadosVersaoOffice dadosRemoverOffice = new DadosVersaoOffice();
       dadosRemoverOffice.removerVersaoOffice(removerVersaoOffice);
    }

    @Override
    public ArrayList<VersaoOffice> listarVersaoOffice(VersaoOffice filtroVersaoOffice) throws Exception {
        DadosVersaoOffice dadosListarOffice = new DadosVersaoOffice();
        return dadosListarOffice.listarVersaoOffice(filtroVersaoOffice);
    }

}