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
public interface InterfaceConfiguracao {
    void cadastrarConfiguracao (Configuracao config) throws Exception;
    void alterarConfiguracao(Configuracao alterarConfig , Configuracao selecionadoConfig) throws Exception;
    void removerConfiguracao (Configuracao removerConfig) throws Exception;
    ArrayList<Configuracao> listarConfiguracao(Configuracao filtroConfig) throws Exception;   
}
