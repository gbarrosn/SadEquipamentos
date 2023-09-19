/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Geral;

/**import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;*/
import javax.swing.JOptionPane;


/**
 *
 * @author airton.oliveira
 */
public class Updates extends ConectarSQL{

   
  
   
    public static void main(String[] args) throws Exception {
        
        try{
            updateTombos up = new updateTombos();
            up.updateTomboMonitor();
            JOptionPane.showMessageDialog(null, "Atualização dos tombos de MONITOR concluída!");
            
            up.updateTomboMicro();
            JOptionPane.showMessageDialog(null, "Atualização dos tombos de MICRO concluída!");
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Erro - "+e.getMessage() );
        }
     
    }
    
}
