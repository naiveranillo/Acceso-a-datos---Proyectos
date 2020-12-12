/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import modelo.*;
import vista.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Naiver Anillo
 */
public class PersonaControlador implements ActionListener {
    PersonaVista perVista = new PersonaVista();
    PersonaDAO perDAO = new PersonaDAO ();
    
    public PersonaControlador(PersonaVista pv, PersonaDAO pd) {   
        this.perVista = pv;
        this.perDAO = pd; 
        perVista.btnagg.addActionListener(this);
        perVista.btnlistar.addActionListener(this);
        perVista.btnmod.addActionListener(this);
        perVista.btnelim.addActionListener(this);
        perVista.btnbuscar.addActionListener(this);
        
    }
    public void addPersona (String id,String nombre,String sexo){
        Persona per = new Persona();
        per.setCedula(id);
        per.setNombre(nombre);
        per.setSexo(sexo);
        if (perDAO.addPersona(per)!=0){
            JOptionPane.showMessageDialog(null, "Registro exitoso");
        }else{
            JOptionPane.showMessageDialog(null, "Registro no exitoso");
        }
    }
    public DefaultListModel listPersona(){
        DefaultListModel lm = new DefaultListModel();
        ArrayList per = perDAO.listPersona();
        Iterator iPer = per.iterator();
        while(iPer.hasNext()){
            lm.addElement(iPer.next());
        }
        return lm;
    }
    
    public void Modificar (String id, String nombre, String sexo)
    {
        Persona per = new Persona();
        per.setCedula(id);
        per.setNombre(nombre);
        per.setSexo(sexo);
        if(perDAO.Modificar(per)!=0){
            JOptionPane.showMessageDialog(null, "Modificacion exitosa");
        }else{
            JOptionPane.showMessageDialog(null, "Modificacion no exitosa");
        }
    }
    
    public Persona BuscarId(String id)
    {
       Persona per = new Persona();
       per=perDAO.BuscarId(id);
       
        return per;
             
    }
    
    public void Eliminar (String id)
    {
        if(perDAO.Eliminar(id) != 0){
            JOptionPane.showMessageDialog(null, "Eliminacion exitosa");
        }else{
            JOptionPane.showMessageDialog(null, "Eliminacion no exitosa");
        }
        Limpiar(2);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        int opc;
        if(e.getSource()==perVista.btnagg){
            
            if(perVista.aggid.getText().isEmpty() || perVista.aggnombre.getText().isEmpty() || perVista.aggsexo.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Llene todos los campos");
            }else{
                addPersona(perVista.aggid.getText(),
                              perVista.aggnombre.getText(),
                              perVista.aggsexo.getText());
                opc=1;
                Limpiar(opc);
            } 
        }
        if(e.getSource()==perVista.btnlistar){
            perVista.mostrar.setModel(listPersona());
        }
       
        if(e.getSource()==perVista.btnmod)
        {
            
            if(perVista.idvista.getText().isEmpty() || perVista.nombrevista.getText().isEmpty() || perVista.sexovista.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Busque para modificar registro");
            }else{
                Modificar(perVista.idvista.getText(),
                              perVista.nombrevista.getText(),
                              perVista.sexovista.getText());
                opc=2;
                Limpiar(opc);
            }  
        }
        
        if(e.getSource()==perVista.btnbuscar)
        {
            Persona per = new Persona();
            
            if(perVista.buscar.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Llene el campo de busqueda");
            }else{
                per=BuscarId(perVista.buscar.getText());
                
                if(per != null)
                {
                    perVista.idvista.setText(per.getCedula());
                    perVista.nombrevista.setText(per.getNombre());
                    perVista.sexovista.setText(per.getSexo());
                }else{
                    JOptionPane.showMessageDialog(null, "Este id no existe");
                }
            }
            
        }
        
        if(e.getSource()==perVista.btnelim)
        {
            
            if(perVista.idvista.getText().isEmpty() || perVista.nombrevista.getText().isEmpty() || perVista.sexovista.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Busque para Eliminar registro");
            }else{
                Eliminar(perVista.idvista.getText());
            }
            
        }
    }
    
    public void Limpiar(int opc)
    {
        if(opc==1)
        {
            perVista.aggid.setText("");
            perVista.aggnombre.setText("");
            perVista.aggsexo.setText("");
        }
        
        if(opc==2)
        {
            perVista.idvista.setText("");
            perVista.nombrevista.setText("");
            perVista.sexovista.setText("");
            perVista.buscar.setText("");
            
        }
    }
}
