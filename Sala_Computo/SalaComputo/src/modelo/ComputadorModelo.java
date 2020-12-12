/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author NaiAnillo
 */
public class ComputadorModelo {
    conex conexion=null;

    public ComputadorModelo() {
        conexion = new conex();
    }
    
    public int AggComp(Computador comp)
    {
        int rpta=0;
        try{
            Connection condb = conexion.getConexion();
            String query = "INSERT INTO computador (codigo, codsede, codsala) VALUES (?,?,?)";
            PreparedStatement ps = condb.prepareStatement(query);
            ps.setInt(1, comp.getCod());
            ps.setString(2, comp.getCodsede());
            ps.setInt(3, comp.getCodsala());
            rpta = ps.executeUpdate();          
        }catch(Exception ec ){
            JOptionPane.showMessageDialog(null, ec.getMessage());
        }
        return rpta;
    }
    
    public int ModificarComp(Computador comp)
    {
        int rpta=0;
        
        try{
            Connection condb = conexion.getConexion();
            String query = "UPDATE computador Set codsede = ?, codsala = ? WHERE codigo = ?";
            PreparedStatement ps = condb.prepareStatement(query);
            ps.setString(1, comp.getCodsede());
            ps.setInt(2, comp.getCodsala());
            ps.setInt(3, comp.getCod());
            
            rpta = ps.executeUpdate();
            
        }catch(Exception ec){
            JOptionPane.showMessageDialog(null, ec.getMessage());
        }
        
        return rpta;
    }
    
    public Computador BuscarComp (int cod)
    {
        Computador comp = null;
        try{
            Connection condb = conexion.getConexion();
            String query = "SELECT * FROM computador WHERE codigo = ?";
            PreparedStatement ps = condb.prepareStatement(query);
            ps.setInt(1, cod);
            
            ResultSet result = ps.executeQuery();
            while(result.next())
            {
                comp = new Computador();
                comp.setCod(result.getInt("codigo"));
                comp.setCodsede(result.getString("codsede"));
                comp.setCodsala(result.getInt("codsala"));
                
            }
        }catch(Exception ec)
        {
            JOptionPane.showMessageDialog(null, ec.getMessage());
        }
        return comp;
        
    }
    
    
    public int ContarComp(int codsala){
    
        int cont=0;
        try{
            Connection condb = conexion.getConexion();
            String query = "SELECT * FROM computador WHERE codsala = ?";
            PreparedStatement ps = condb.prepareStatement(query);
            ps.setInt(1, codsala);
            
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
    
    public Sede ExisteSede(String cod)
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
    
    
     public Sala ExisteSala(int cod)
     {
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
    
    
        
        public int EliminarComp(int cod)
        {
            int rpta=0;
            try{
                Connection condb = conexion.getConexion();
                String query = "DELETE FROM computador WHERE codigo = ?";
                PreparedStatement ps = condb.prepareStatement(query);
                ps.setInt(1, cod);

                rpta = ps.executeUpdate();
            }catch(Exception ec)
            {
                JOptionPane.showMessageDialog(null, ec.getMessage());
            }

            return rpta;
        }
    
}
