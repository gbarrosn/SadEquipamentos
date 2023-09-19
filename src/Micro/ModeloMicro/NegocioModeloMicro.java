/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Micro.ModeloMicro;


import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Posseidon
 */
public class NegocioModeloMicro implements InterfaceModeloMicro{

    @Override
    public void cadastrarModeloMicro(ModeloMicro modeloMicro) throws Exception {
       try{
           if (modeloMicro.getModelo().trim().equals("")){
               throw new Exception ("Informe uma descrição para o Modelo!");
           }
           
           
           DadosModeloMicro dados = new DadosModeloMicro();
           dados.cadastrarModeloMicro(modeloMicro);
           
       }catch (Exception ex){
           JOptionPane.showMessageDialog(null, "Erro ao cadastrar - "+ ex.getMessage());
       }
    }

    @Override
    public void alterarModeloMicro(ModeloMicro alterarModeloMicro, ModeloMicro selecionadoModeloMicro) throws Exception {
    
        try{
        
        if (alterarModeloMicro.getModelo().equalsIgnoreCase(selecionadoModeloMicro.getModelo())&&
            alterarModeloMicro.getMarca()==selecionadoModeloMicro.getMarca()){
            throw new Exception("Não houve nenhuma alteração no tipo de Modelo.");
        }
        
        if (alterarModeloMicro.getModelo().trim().equals("")){
            throw new Exception ("Informe a descrição do Modelo!");
        }
        
        
        
        DadosModeloMicro dados = new DadosModeloMicro();
        dados.alterarModeloMicro(alterarModeloMicro, selecionadoModeloMicro);
        
        }catch (Exception ex){
             throw new Exception("Erro - "+ ex.getMessage());
        }
        
    }

    @Override
    public void removerModeloMicro(ModeloMicro removerModeloMicro) throws Exception {
        DadosModeloMicro dados = new DadosModeloMicro();
        dados.removerModeloMicro(removerModeloMicro);
    }

    @Override
    public ArrayList<ModeloMicro> listarModeloMicro(ModeloMicro filtroModeloMicro) throws Exception {
        DadosModeloMicro dadosFiltroModeloMicro = new DadosModeloMicro();
        return dadosFiltroModeloMicro.listarModeloMicro(filtroModeloMicro);
    }
    
}
