/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Micro.PlataformaMicro;

import Geral.ConectarSQL;
import java.util.ArrayList;

/**
 *
 * @author Posseidon
 */
public class NegocioPlataformaMicro extends ConectarSQL implements InterfacePlataformaMicro{

    @Override
    public void cadastrarPlataformaMicro(PlataformaMicro plataforma) throws Exception {
       if (plataforma.getPlataforma().trim().equals("")){
            throw new Exception ("Informe a descrição da Plataforma!");
        }
        
        DadosPlataformaMicro newDados = new DadosPlataformaMicro();
        newDados.cadastrarPlataformaMicro(plataforma);
    }

    @Override
    public void alterarPlataformaMicro(PlataformaMicro alterarPlataforma, PlataformaMicro selecionadoPlataforma) throws Exception {
       
        if (alterarPlataforma.getPlataforma().equalsIgnoreCase(selecionadoPlataforma.getPlataforma())){
            throw new Exception("Não houve nenhuma alteração no tipo de Plataforma selecionada.");
        }
        
        if (alterarPlataforma.getPlataforma().trim().equals("")){
            throw new Exception ("Informe a descrição da Plataforma");
        }
        
        
        DadosPlataformaMicro newDados = new DadosPlataformaMicro();
        newDados.alterarPlataformaMicro(alterarPlataforma, selecionadoPlataforma);
               
    }

    @Override
    public void removerPlataformaMicro(PlataformaMicro removerPlataforma) throws Exception {
        DadosPlataformaMicro newDados = new DadosPlataformaMicro();
        newDados.removerPlataformaMicro(removerPlataforma);
    }

    @Override
    public ArrayList<PlataformaMicro> listarPlataformaMicro(PlataformaMicro filtroPlataformaMicro) throws Exception {
        DadosPlataformaMicro dadosFiltroPlataforma = new DadosPlataformaMicro();
        return dadosFiltroPlataforma.listarPlataformaMicro(filtroPlataformaMicro);     
            
    }
    
}
