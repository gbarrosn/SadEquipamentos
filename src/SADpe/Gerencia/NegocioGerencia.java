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
public class NegocioGerencia implements InterfaceGerencia{

    @Override
    public void cadastrarGerencia(Gerencia gerencia) throws Exception {
        
        try{
        
           if (gerencia.getGerencia().trim().equals("")){
               throw new Exception ("Informe uma descrição para a Gerência!");
           }
           if (gerencia.getSiglaGerencia().trim().equals("")){
               throw new Exception ("Informe uma sigla para a Gerência!");
           }
           
           DadosGerencia dados = new DadosGerencia();
           dados.cadastrarGerencia(gerencia);
        }catch(Exception ex){
             throw new Exception("Erro - "+ ex.getMessage());
        }
        }

    @Override
    public void alterarGerencia(Gerencia alterarGerencia, Gerencia selecionadoGerencia) throws Exception {
         
        try{
        
        if (
            
            alterarGerencia.getGerencia().equalsIgnoreCase(selecionadoGerencia.getGerencia())&&
            alterarGerencia.getSiglaGerencia().equalsIgnoreCase(selecionadoGerencia.getSiglaGerencia()) &&
            alterarGerencia.getPavimento().getIdPavimento()==selecionadoGerencia.getPavimento().getIdPavimento()
            
            ){
            
            throw new Exception("Não houve nenhuma alteração na Gerência.");
        }
        
        if (alterarGerencia.getGerencia().trim().equals("")){
            throw new Exception ("Informe a descrição da Gerência!");
        }
        if (alterarGerencia.getSiglaGerencia().trim().equals("")){
            throw new Exception ("Informe a sigla da Gerência!");
        }
        
        DadosGerencia dados = new DadosGerencia();
        dados.alterarGerencia(alterarGerencia, selecionadoGerencia);
        
        }catch (Exception ex){
             throw new Exception("Erro - "+ ex.getMessage());
        }
    }

    @Override
    public void removerGerencia(Gerencia removerGerencia) throws Exception {
         DadosGerencia dados = new DadosGerencia();
        dados.removerGerencia(removerGerencia);
    }

    @Override
    public ArrayList<Gerencia> listarGerencia(Gerencia filtroGerencia) throws Exception {
        DadosGerencia dadosFiltroGerencia = new DadosGerencia();
        return dadosFiltroGerencia.listarGerencia(filtroGerencia);
    }
    
}
