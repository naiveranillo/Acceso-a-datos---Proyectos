/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.sql.*;
/**
 *
 * @author Naiver Anillo
 */
public class Conexion {
    
    public Conexion(){
    }
    
    public Connection getConexion (){
        Connection con = null;
        try{
              Class.forName("com.mysql.jdbc.Driver");
              con = DriverManager.getConnection("jdbc:mysql://localhost/persona","anillonaiver", "naiver3753313");
        }catch(Exception e){
            System.out.print(e.getMessage());
        }
        return con;
    }
}
