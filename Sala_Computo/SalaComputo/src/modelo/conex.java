/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author NaiAnillo
 */
public class conex {

    public conex() {
        
    }
    
     public Connection getConexion (){
         
        Connection con = null;
        try{
              Class.forName("com.mysql.jdbc.Driver");
              con = DriverManager.getConnection("jdbc:mysql://localhost/salacomputo","anillonaiver", "naiver3753313");
        }catch(Exception e){
            System.out.print(e.getMessage());
        }
        return con;
     }
}
