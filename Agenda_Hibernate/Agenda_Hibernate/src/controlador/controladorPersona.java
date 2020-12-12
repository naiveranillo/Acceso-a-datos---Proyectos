/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import modelo.*;

/**
 *
 * @author NaiAnillo
 */
public class controladorPersona {
    
    ModeloPersona mp = new ModeloPersona();
    
    public void aggPersona(int ced, String nom, String sexo)
    {
        Persona per = new Persona();
        per.setId(ced);
        per.setNombre(nom);
        per.setSexo(sexo);
        
        mp.addUsuario(per);
        
    }
    
    public Persona Buscar(int cedula)
    {
        Persona per = new Persona();
        
        per = mp.Buscar(cedula);
        
        return per;
    }
    
    public void Modificar(int ced, String nom, String sexo)
    {
        Persona per = new Persona();
        per.setId(ced);
        per.setNombre(nom);
        per.setSexo(sexo);
        
        mp.Modificar(per);
    }
    
    public void Eliminar(int ced, String nom, String sexo)
    {
        Persona per = new Persona();
        per.setId(ced);
        per.setNombre(nom);
        per.setSexo(sexo);
        
        mp.Eliminar(per);
    }
    
   public DefaultTableModel listarPer()
   {
      List<Persona> listPer;    
      listPer = mp.ListarPersona();
      DefaultTableModel tabPer = new DefaultTableModel();
      String tituPer[]={"Cedula", "Nombre", "Sexo"};
      tabPer.setColumnIdentifiers(tituPer);
      Object filPer[] = new Object[3];
      
      for (int i=0 ;i<listPer.size(); i++)
      {
          filPer[0] = listPer.get(i).getId();
          filPer[1] = listPer.get(i).getNombre();
          filPer[2] = listPer.get(i).getSexo();
          tabPer.addRow(filPer);
      }    
      
      return tabPer;  
   }
}
