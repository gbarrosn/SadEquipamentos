/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Micro.PlataformaMicro;

import java.util.ArrayList;

/**
 *
 * @author Posseidon
 */
public interface InterfacePlataformaMicro {
    void cadastrarPlataformaMicro (PlataformaMicro plataforma)throws Exception;
    void alterarPlataformaMicro (PlataformaMicro alterarPlataforma, PlataformaMicro selecionadoPlataforma)throws Exception;
    void removerPlataformaMicro (PlataformaMicro removerPlataforma)throws Exception;
    ArrayList<PlataformaMicro> listarPlataformaMicro (PlataformaMicro filtroPlataformaMicro)throws Exception;
}
