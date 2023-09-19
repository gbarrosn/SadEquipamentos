/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Geral;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


/**
 *
 * @author Posseidon
 */
public class ConectarSQL {
    private Statement stmt;
    private Connection conn;

    public Statement conectar() throws ClassNotFoundException, SQLException {
        return this.conectarSqlServer();
    }
    
    public Connection conectarPrepared() throws ClassNotFoundException, SQLException {
        return this.conectarSqlServerPrepared();
    }

    public void desconectar() throws SQLException {
        conn.close();
    }

    private Statement conectarSqlServer() throws ClassNotFoundException, SQLException {
     
            String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
            
            

            
            //CONEXAO COM O SERVIDOR ABAIXO FUNCIONANDO(COMENTEI PARA TESTAR LOCAL)
            //M AIS EM BAIXO TEM QUE MUDAR TBM:            
            
            String url = "jdbc:sqlserver://10.1.0.12:14222;DatabaseName=Equipamentos;integratedSecurity=false;trustServerCertificate=true"; 
            
            // Login para DB no servidor da SAD
            String usuario = "sa";
            String senha = "suporteadm";   
            
          
            /*
            //CONEXAO LOCAL ABAIXO
            String url = "jdbc:sqlserver://localhost:1433;DatabaseName=Equipamentos;integratedSecurity=false;trustServerCertificate=true";
            //----------------------------------------------------
            
            //Login para meu server local 
            String usuario = "adm";
            String senha = "suporteadm";
            
 */
            
            Class.forName(driver);
            conn = DriverManager.getConnection(url, usuario, senha);
            stmt = conn.createStatement();
            return stmt;    
            
    }
    
    private Connection conectarSqlServerPrepared() throws ClassNotFoundException, SQLException {
     
            //String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
            String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
            

            
            
              
            //CONEXAO COM O SERVIDOR ABAIXO FUNCIONANDO(COMENTEI PARA TESTAR LOCAL):   
            
            String url = "jdbc:sqlserver://10.1.0.12:14222;DatabaseName=Equipamentos;integratedSecurity=false;trustServerCertificate=true"; 
            
            // Login para DB no servidor da SAD
            String usuario = "sa";
            String senha = "suporteadm";  
             
          

           /*
            //CONEXAO LOCAL ABAIXO:
            String url = "jdbc:sqlserver://localhost:1433;DatabaseName=Equipamentos;integratedSecurity=false;trustServerCertificate=true";
         
            //Login para meu server local 
            String usuario = "adm";
            String senha = "suporteadm";
            //----------------------------------------------------   
           
*/
            
            Class.forName(driver);
            conn = DriverManager.getConnection(url, usuario, senha);
            return conn;    
            
    }
    
}

