/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Micro.MarcaMicro;


import Micro.Configuracao.DadosConfiguracao;
import java.util.ArrayList;

/**
 *
 * @author Posseidon
 */
public class NegocioMarcaMicro implements InterfaceMarcaMicro{

    @Override
    public void cadastrarMarcaMicro(MarcaMicro cadastrarMarcaMicro) throws Exception {
        if (cadastrarMarcaMicro.getMarca().trim().equals("")){
            throw new Exception ("Informe a descrição da Marca");
        }
        
        DadosMarcaMicro newDados = new DadosMarcaMicro();
        newDados.cadastrarMarcaMicro(cadastrarMarcaMicro);
    }

    @Override
    public void alterarMarcaMicro(MarcaMicro alterarMarcaMicro, MarcaMicro selecionadoMarcaMicro) throws Exception {

        
        if (alterarMarcaMicro.getMarca().equalsIgnoreCase(selecionadoMarcaMicro.getMarca())){
            throw new Exception("Não houve nenhuma alteração no tipo de Marca selecionada.");
        }
        
        if (alterarMarcaMicro.getMarca().trim().equals("")){
            throw new Exception ("Informe a descrição da Marca");
        }
        
        
        DadosMarcaMicro newDados = new DadosMarcaMicro();
        newDados.alterarMarcaMicro(alterarMarcaMicro, selecionadoMarcaMicro);
               
        
        }
    

    @Override
    public void removerMarcaMicro(MarcaMicro removerMarcaMicro) throws Exception {
       DadosMarcaMicro newDados = new DadosMarcaMicro();
       newDados.removerMarcaMicro(removerMarcaMicro);
    }

    @Override
    public ArrayList<MarcaMicro> listarMarcaMicro(MarcaMicro filtroMarcaMicro) throws Exception {
       DadosMarcaMicro dadosFiltroMarcaMicro = new DadosMarcaMicro();
       return dadosFiltroMarcaMicro.listarMarcaMicro(filtroMarcaMicro);
    }
    
}
