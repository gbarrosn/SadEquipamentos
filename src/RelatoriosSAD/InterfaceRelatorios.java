/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RelatoriosSAD;

import Usuario.Usuario;
import java.util.ArrayList;

/**
 *
 * @author Posseidon
 */
public interface InterfaceRelatorios {
    //relatorio pavimento
    ArrayList<Usuario> listarUsuarioPavimentoRelatorio(Usuario userPavimentoRelatorio) throws Exception;
    int contagemUsuariosPavimento (Usuario UsuarioPavimentoRelatorio) throws Exception;  
    int contagemTotal () throws Exception; 
    //relatorio personalizado
    ArrayList<Usuario> listarUsuarioRelatorioPersonalizado (Usuario userRelatorioPersonalizado,Relatorios checkRelatorio) throws Exception;
    int contagemUsuariosPersonalizado (Usuario UsuarioRelatorioPersonalizado,Relatorios checkRelatorio) throws Exception;  
    //relatorio completo
    //ArrayList<Usuario> listarUsuarioRelatorioCompleto (Usuario userRelatorioCompleto,Relatorios checkRelatorio) throws Exception;
    
}
