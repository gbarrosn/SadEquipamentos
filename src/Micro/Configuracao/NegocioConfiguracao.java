/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Micro.Configuracao;

import java.util.ArrayList;

/**
 *
 * @author Posseidon
 */
public class NegocioConfiguracao implements InterfaceConfiguracao {

    @Override
    public void cadastrarConfiguracao(Configuracao config) throws Exception {
        if(config.getConfiguracao().trim().equals("")){
            throw new Exception("Informe uma descrição para a Configuração.");
        }
        
        DadosConfiguracao dadosConfig = new DadosConfiguracao();
        dadosConfig.cadastrarConfiguracao(config);
        
    }

    @Override
    public void alterarConfiguracao(Configuracao alterarConfig, Configuracao selecionadoConfig) throws Exception {
        try{
        
        if (alterarConfig.getConfiguracao().equalsIgnoreCase(selecionadoConfig.getConfiguracao())){
            throw new Exception("Não houve nenhuma alteração no tipo de Configuração selecionada.");
        }
        
        if (alterarConfig.getConfiguracao().trim().equals("")){
            throw new Exception ("Informe a descrição da configuraçã");
        }
        
        
        DadosConfiguracao dadosConfig = new DadosConfiguracao();
        dadosConfig.alterarConfiguracao(alterarConfig, selecionadoConfig);
        
        }catch (Exception ex){
             throw new Exception("Erro - "+ ex.getMessage());
        }
        
        }

    @Override
    public void removerConfiguracao(Configuracao removerConfig) throws Exception {
       DadosConfiguracao removerDadosConfig = new DadosConfiguracao();
       removerDadosConfig.removerConfiguracao(removerConfig);
       
    }

    @Override
    public ArrayList<Configuracao> listarConfiguracao(Configuracao filtroConfig) throws Exception {
        DadosConfiguracao dadosFiltroConfig = new DadosConfiguracao();
        return dadosFiltroConfig.listarConfiguracao(filtroConfig);
    }
    
}
