/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Micro.MarcaMicro;

import Micro.Configuracao.Configuracao;
import java.util.ArrayList;

/**
 *
 * @author Posseidon
 */
public interface InterfaceMarcaMicro {
     void cadastrarMarcaMicro (MarcaMicro cadastrarMarcaMicro) throws Exception;
     void alterarMarcaMicro(MarcaMicro alterarMarcaMicro , MarcaMicro selecionadoMarcaMicro) throws Exception;
     void removerMarcaMicro (MarcaMicro removerMarcaMicro) throws Exception;
     ArrayList<MarcaMicro> listarMarcaMicro(MarcaMicro filtroMarcaMicro) throws Exception;   
}
