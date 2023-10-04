/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Micro.OS;

import Micro.ModeloMicro.DadosModeloMicro;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Posseidon
 */
public class NegocioOS implements InterfaceOS{

    @Override
    public void cadastrarOS(OS os) throws Exception {
        
       try{
           if (os.getOs().trim().equals("")){
               throw new Exception ("Informe uma descrição para o Sistema Operacional!");
           }
           
           
           DadosOS dados = new DadosOS();
           dados.cadastrarOS(os);
           
       }catch (Exception ex){
           JOptionPane.showMessageDialog(null, "Erro ao cadastrar - "+ ex.getMessage());
       }
       
    }

    @Override
    public void alterarOS(OS alterarOS, OS selecionadoOS) throws Exception {
        
        try{
        
        if (alterarOS.getOs().equalsIgnoreCase(selecionadoOS.getOs())){
            throw new Exception("Não houve nenhuma alteração no SO.");
        }
        
        if (alterarOS.getOs().trim().equals("")){
            throw new Exception ("Informe a descrição do Sistema Operacional!");
        }
        
        
        DadosOS dados = new DadosOS();
        dados.alterarOS(alterarOS, selecionadoOS);
        
        }catch (Exception ex){
             throw new Exception("Erro - "+ ex.getMessage());
        }
        
    }

    @Override
    public void removerOS(OS removerOS) throws Exception {
       DadosOS dados = new DadosOS();
       dados.removerOS(removerOS);
    }

    @Override
    public ArrayList<OS> listarOS(OS filtroOS) throws Exception {
        DadosOS dadosFiltroOS = new DadosOS();
        return dadosFiltroOS.listarOS(filtroOS);
    }
    
}
