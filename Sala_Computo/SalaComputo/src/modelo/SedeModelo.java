/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author NaiAnillo
 */
public class SedeModelo {
    conex conexion=null;

    public SedeModelo(){
        conexion = new conex();
    }
    
    public int AggSede(Sede sed)
    {
        int rpta=0;
        
        try{
            Connection condb = conexion.getConexion();
            String query = "INSERT INTO sede (nombre, codigo, direccion, numtel, cantsala) VALUES (?,?,?,?,?)";
            PreparedStatement ps = condb.prepareStatement(query);
            ps.setString(1, sed.getNombre());
            ps.setString(2, sed.getCod());
            ps.setString(3, sed.getDir());
            ps.setInt(4, sed.getNumtel());
            ps.setInt(5, sed.getCantsal());
            
            rpta = ps.executeUpdate(); 
            
        }catch(Exception ec ){
            JOptionPane.showMessageDialog(null, ec.getMessage());
        }
        
        return rpta;
    }
    
    public int ModificarSede(Sede sed)
    {
        int rpta=0;
        
        try{
            Connection condb = conexion.getConexion();
            String query = "UPDATE sede Set nombre = ?, direccion = ?, numtel = ?, cantsala = ? WHERE codigo = ?";
            PreparedStatement ps = condb.prepareStatement(query);
            ps.setString(1, sed.getNombre());
            ps.setString(2,sed.getDir());
            ps.setInt(3, sed.getNumtel());
            ps.setInt(4, sed.getCantsal());
            ps.setString(5, sed.getCod());
            
            rpta = ps.executeUpdate();
            
            
            
        }catch(Exception ec){
            JOptionPane.showMessageDialog(null, ec.getMessage());
        }
        
        return rpta;
    }
    
    public Sede BuscarCod(String cod)
    {
        Sede sed = null;
        
        try{
            Connection condb = conexion.getConexion();
            String query = "SELECT * FROM sede WHERE codigo = ?";
            PreparedStatement ps = condb.prepareStatement(query);
            ps.setString(1, cod);
            
            ResultSet result = ps.executeQuery();
            while(result.next())
            {
                sed = new Sede();
                sed.setNombre(result.getString("nombre"));
                sed.setCod(result.getString("codigo"));
                sed.setDir(result.getString("direccion"));
                sed.setNumtel(result.getInt("numtel"));
                sed.setCantsal(result.getInt("cantsala"));
            }
        }catch(Exception ec)
        {
            JOptionPane.showMessageDialog(null, ec.getMessage());
        }
        
        return sed;
    }
    
    public int EliminarSede (String cod)
    {
        int rpta=0;
        try{
            Connection condb = conexion.getConexion();
            String query = "DELETE FROM sede WHERE codigo = ?";
            PreparedStatement ps = condb.prepareStatement(query);
            ps.setString(1, cod);
            
            rpta = ps.executeUpdate();
        }catch(Exception ec)
        {
            JOptionPane.showMessageDialog(null, ec.getMessage());
        }
        
        return rpta;
    }
    
    public ArrayList<Sala> listSala()
    {
        ArrayList <Sala> rpta = new ArrayList <Sala>();
        
        try{
            Connection condb = conexion.getConexion();
            String query = "SELECT * FROM sala";
            Statement ps = condb.createStatement();
            ResultSet result = ps.executeQuery(query);
            while(result.next()){
                Sala sal = new Sala();
                sal.setCod(result.getInt("codigo"));
                sal.setCodsede(result.getString("codsede"));
                sal.setCantcomp(result.getInt("cantcomp"));
                rpta.add(sal);
            }
        }catch(Exception ec ){
            JOptionPane.showMessageDialog(null, ec.getMessage());
        }
        
        return rpta;
    }
}
