/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author Naiver Anillo
 */
public class PersonaDAO {
    Conexion conexion=null;
    public PersonaDAO(){
        conexion = new Conexion();
    }
    public Integer addPersona(Persona per){
        int rpta=0;
        try{
            Connection condb = conexion.getConexion();
            String query = "INSERT INTO usuario (id, nombre, sexo) VALUES (?,?,?)";
            PreparedStatement ps = condb.prepareStatement(query);
            ps.setString(1, per.getCedula());
            ps.setString(2, per.getNombre());
            ps.setString(3, per.getSexo());
            rpta = ps.executeUpdate();          
        }catch(Exception ec ){
            JOptionPane.showMessageDialog(null, ec.getMessage());
        }
        return rpta;
    } 
    public ArrayList<Persona>  listPersona(){
        ArrayList <Persona> rpta = new ArrayList <Persona>();
        try{
            Connection condb = conexion.getConexion();
            String query = "SELECT * FROM usuario";
            Statement ps = condb.createStatement();
            ResultSet result = ps.executeQuery(query);
            while(result.next()){
                Persona per = new Persona();
                per.setCedula(result.getString("id"));
                per.setNombre(result.getString("nombre"));
                per.setSexo(result.getString("sexo"));
                rpta.add(per);
            }
        }catch(Exception ec ){
            JOptionPane.showMessageDialog(null, ec.getMessage());
        }
        return rpta;
    } 
    
    public Integer Modificar(Persona per)
    {
        int rpta=0;
        
        try{
            Connection condb = conexion.getConexion();
            String query = "UPDATE usuario Set nombre = ?, sexo = ? WHERE id = ?";
            PreparedStatement ps = condb.prepareStatement(query);
            ps.setString(1, per.getNombre());
            ps.setString(2, per.getSexo());
            ps.setString(3, per.getCedula());
            
            rpta = ps.executeUpdate();
            
        }catch(Exception ec){
            JOptionPane.showMessageDialog(null, ec.getMessage());
        }
        
        return rpta;
    }
    
    public Persona BuscarId(String id)
    {
        Persona per = null;
        try{
            Connection condb = conexion.getConexion();
            String query = "SELECT * FROM usuario WHERE id = ?";
            PreparedStatement ps = condb.prepareStatement(query);
            ps.setString(1, id);
            
            ResultSet result = ps.executeQuery();
            while(result.next())
            {
                per = new Persona();
                per.setCedula(result.getString("id"));
                per.setNombre(result.getString("nombre"));
                per.setSexo(result.getString("sexo"));
                
            }
        }catch(Exception ec)
        {
            JOptionPane.showMessageDialog(null, ec.getMessage());
        }
        return per;
    }
    
    public Integer Eliminar(String id)
    {
        int rpta=0;
        try{
            Connection condb = conexion.getConexion();
            String query = "DELETE FROM usuario WHERE id = ?";
            PreparedStatement ps = condb.prepareStatement(query);
            ps.setString(1, id);
            
            rpta = ps.executeUpdate();
        }catch(Exception ec)
        {
            JOptionPane.showMessageDialog(null, ec.getMessage());
        }
        
        return rpta;
    }
    
}
