/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Geral;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author airton.oliveira
 */
public class updateTombos extends ConectarSQL{
    
    
        
    public void updateTomboMicro() throws SQLException, ClassNotFoundException, Exception{
         
        String[]tombosnovos = pegarTombosNovosMicro();
        String[] tombosantigos = pegarTombosAntigosMicro();
        
        try {
                        
        Connection conectarSQL = conectarPrepared();
        String sql;
        for (int i=0;i<tombosnovos.length;i++){
            sql = "Update Usuario SET novo_tombo_micro= (?) where tombo_micro = (?)";
            PreparedStatement conex = conectarSQL.prepareStatement(sql);
            conex.setString(1, tombosnovos[i]);
            conex.setString(2, tombosantigos[i]);
            conex.executeUpdate();
        }
      
        }catch (Exception ex) {
              
            throw new Exception(ex.getMessage());
        }
           
        desconectar(); 
    }
    
    public void updateTomboMonitor() throws SQLException, ClassNotFoundException, Exception{
         
        String[]tombosnovos = pegarTombosNovos();
        String[] tombosantigos = pegarTombosAntigos();
        
        try {
                        
        Connection conectarSQL = conectarPrepared();
        String sql;
        for (int i=0;i<tombosnovos.length;i++){
            sql = "Update Usuario SET novo_tombo_monitor= (?) where tombo_monitor = (?)";
            PreparedStatement conex = conectarSQL.prepareStatement(sql);
            conex.setString(1, tombosnovos[i]);
            conex.setString(2, tombosantigos[i]);
            conex.executeUpdate();
        }
      
        }catch (Exception ex) {
              
            throw new Exception(ex.getMessage());
        }
           
        desconectar(); 
    }
    
    
    
    
    public String readFile( String file ) throws IOException {
        
    try (BufferedReader reader = new BufferedReader( new FileReader (file))) {
        String         line = null;
        StringBuilder  stringBuilder = new StringBuilder();
        //String         ls = System.getProperty("line.separator");

        while( ( line = reader.readLine() ) != null ) {
            stringBuilder.append( line );
            stringBuilder.append("/");
        }

        return stringBuilder.toString();
    }
}
    
    public String[] pegarTombosAntigos(){
       String arquivo="C:\\tombos-old.txt";
       String ler="";
       try{
       ler = readFile(arquivo);
       }catch (Exception e ){
       System.out.println(e.getMessage());    
       }
       //System.out.println(ler);  
       String paramTombosAntogiso[] = ler.split(("/"));
       return paramTombosAntogiso;
       
    }
    
    public String[] pegarTombosNovos(){
       String arquivo="C:\\tombos-new.txt";
       String ler="";
       try{
       ler = readFile(arquivo);
       }catch (Exception e ){
       System.out.println(e.getMessage());    
       }
       //System.out.println(ler);  
       String paramTombosNovos[] = ler.split(("/"));
       return paramTombosNovos;
       
    }
    
    
    //************************************************
    
      public String[] pegarTombosAntigosMicro(){
       String arquivo="C:\\tombos-oldMicro.txt";
       String ler="";
       try{
       ler = readFile(arquivo);
       }catch (Exception e ){
       System.out.println(e.getMessage());    
       }
       //System.out.println(ler);  
       String paramTombosAntogiso[] = ler.split(("/"));
       return paramTombosAntogiso;
       
    }
    
    public String[] pegarTombosNovosMicro(){
       String arquivo="C:\\tombos-newMicro.txt";
       String ler="";
       try{
       ler = readFile(arquivo);
       }catch (Exception e ){
       System.out.println(e.getMessage());    
       }
       //System.out.println(ler);  
       String paramTombosNovos[] = ler.split(("/"));
       return paramTombosNovos;
       
    }
    
}
