/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Versao_Office;


import Micro.Configuracao.*;
import java.util.ArrayList;

/**
 *
 * @author Posseidon
 */
public interface InterfaceVersaoOffice {
    void cadastrarVersaoOffice (VersaoOffice versaoOffice) throws Exception;
    void alterarVersaoOffice(VersaoOffice alterarVersaoOffice , VersaoOffice selecionadoVersaoOffice) throws Exception;
    void removerVersaoOffice (VersaoOffice removerVersaoOffice) throws Exception;
    ArrayList<VersaoOffice> listarVersaoOffice(VersaoOffice filtroVersaoOffice) throws Exception;   
}
