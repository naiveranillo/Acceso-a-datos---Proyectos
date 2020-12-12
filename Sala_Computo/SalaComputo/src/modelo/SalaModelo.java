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
public class SalaModelo {
    conex conexion=null;

    public SalaModelo() {
        conexion = new conex();
    }
    
    public int AggSala(Sala sal)
    {
        int rpta=0;
        try{
            Connection condb = conexion.getConexion();
            String query = "INSERT INTO sala (codigo, codsede, cantcomp) VALUES (?,?,?)";
            PreparedStatement ps = condb.prepareStatement(query);
            ps.setInt(1, sal.getCod());
            ps.setString(2, sal.getCodsede());
            ps.setInt(3, sal.getCantcomp());
            rpta = ps.executeUpdate();          
        }catch(Exception ec ){
            JOptionPane.showMessageDialog(null, ec.getMessage());
        }
        return rpta;
    }
    
    public int ModificarSala(Sala sal)
    {
        int rpta=0;
        
        try{
            Connection condb = conexion.getConexion();
            String query = "UPDATE sala Set codsede = ?, cantcomp = ? WHERE codigo = ?";
            PreparedStatement ps = condb.prepareStatement(query);
            ps.setString(1, sal.getCodsede());
            ps.setInt(2, sal.getCantcomp());
            ps.setInt(3, sal.getCod());
            
            rpta = ps.executeUpdate();
            
        }catch(Exception ec){
            JOptionPane.showMessageDialog(null, ec.getMessage());
        }
        
        return rpta;
    }
    
    public Sala BuscarSala(int cod){
    
        Sala sal = null;
        try{
            Connection condb = conexion.getConexion();
            String query = "SELECT * FROM sala WHERE codigo = ?";
            PreparedStatement ps = condb.prepareStatement(query);
            ps.setInt(1, cod);
            
            ResultSet result = ps.executeQuery();
            while(result.next())
            {
                sal = new Sala();
                sal.setCod(result.getInt("codigo"));
                sal.setCodsede(result.getString("codsede"));
                sal.setCantcomp(result.getInt("cantcomp"));
                
            }
        }catch(Exception ec)
        {
            JOptionPane.showMessageDialog(null, ec.getMessage());
        }
        return sal;
        
    }
    
    public int ContarSalas(String codsede){
    
        int cont=0;
        try{
            Connection condb = conexion.getConexion();
            String query = "SELECT * FROM sala WHERE codsede = ?";
            PreparedStatement ps = condb.prepareStatement(query);
            ps.setString(1, codsede);
            
            ResultSet result = ps.executeQuery();
            while(result.next())
            {
                cont=cont+1;
                
            }
        }catch(Exception ec)
        {
            JOptionPane.showMessageDialog(null, ec.getMessage());
        }
        return cont;
        
    }
    
    
    public int EliminarSala(int cod)
    {
        int rpta=0;
        try{
            Connection condb = conexion.getConexion();
            String query = "DELETE FROM sala WHERE codigo = ?";
            PreparedStatement ps = condb.prepareStatement(query);
            ps.setInt(1, cod);
            
            rpta = ps.executeUpdate();
        }catch(Exception ec)
        {
            JOptionPane.showMessageDialog(null, ec.getMessage());
        }
        
        return rpta;
    }
    
    public ArrayList<Computador> listComp()
    {
        ArrayList <Computador> rpta = new ArrayList <Computador>();
        
        try{
            Connection condb = conexion.getConexion();
            String query = "SELECT * FROM computador";
            Statement ps = condb.createStatement();
            ResultSet result = ps.executeQuery(query);
            while(result.next()){
                Computador comp = new Computador();
                comp.setCod(result.getInt("codigo"));
                comp.setCodsede(result.getString("codsede"));
                comp.setCodsala(result.getInt("codsala"));
                rpta.add(comp);
            }
        }catch(Exception ec ){
            JOptionPane.showMessageDialog(null, ec.getMessage());
        }
        
        return rpta;
        
    }
}
