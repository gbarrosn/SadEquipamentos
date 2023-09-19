/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Micro.OS;

import java.util.ArrayList;

/**
 *
 * @author Posseidon
 */
public interface InterfaceOS {
    void cadastrarOS (OS os)throws Exception;
    void alterarOS (OS alterarOS, OS selecionadoOS)throws Exception;
    void removerOS (OS removerOS)throws Exception;
    ArrayList<OS> listarOS (OS filtroOS)throws Exception;
}
