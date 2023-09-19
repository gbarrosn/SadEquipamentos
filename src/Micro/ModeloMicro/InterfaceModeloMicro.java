/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Micro.ModeloMicro;

import java.util.ArrayList;

/**
 *
 * @author Posseidon
 */
public interface InterfaceModeloMicro {
    void cadastrarModeloMicro (ModeloMicro modeloMicro) throws Exception;
    void alterarModeloMicro (ModeloMicro alterarModeloMicro, ModeloMicro selecionadoModeloMicro) throws Exception;
    void removerModeloMicro (ModeloMicro removerModeloMicro) throws Exception;
    ArrayList<ModeloMicro> listarModeloMicro (ModeloMicro filtroModeloMicro) throws Exception;

}
