/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Micro.ProprietarioMicro;

import java.util.ArrayList;

/**
 *
 * @author Posseidon
 */
public interface InterfaceProprietarioMicro {
    void cadastrarProprietarioMicro (ProprietarioMicro proprietarioMicro) throws Exception;
    void alterarProprietarioMicro (ProprietarioMicro alterarProprietarioMicro, ProprietarioMicro selecionadoProprietarioMicro) throws Exception;
    void removerProprietarioMicro (ProprietarioMicro removerProprietarioMicro)throws Exception;
    ArrayList<ProprietarioMicro> listarProprietarioMicro (ProprietarioMicro filtroProprietarioMicro)throws Exception;
}
