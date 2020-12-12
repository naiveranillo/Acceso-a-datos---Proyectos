/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import vista.*;
import modelo.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author NaiAnillo
 */
public class FrontController implements ActionListener {
    controladorPersona PerC = new controladorPersona();
    VistaPersona PerV = new VistaPersona();
    Persona per = new Persona();
    
    
    public FrontController(controladorPersona pc, VistaPersona vp) {
        this.PerV = vp;
        this.PerC = pc;
        
        //Paleta de Agregar
        PerV.txtCedula.addActionListener(this);
        PerV.txtNombre.addActionListener(this);
        PerV.boxSexo.addActionListener(this);
        PerV.aggButtom.addActionListener(this);
        
        //Paleta de Modificar y Eliminacion
        PerV.txtBuscar.addActionListener(this);
        PerV.busButtom.addActionListener(this);
        PerV.txtModCed.addActionListener(this);
        PerV.txtModNom.addActionListener(this);
        PerV.boxModSex.addActionListener(this);
        PerV.ModButton.addActionListener(this);
        PerV.EliButtom.addActionListener(this);
        
        //Paleta de Listar
        PerV.listButton.addActionListener(this);
        
    }

    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==PerV.aggButtom)
        {
            if(PerV.txtCedula.getText().isEmpty() || PerV.txtNombre.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Llene todos los campos");
            }else{
                
                per = new Persona();
                
                per = PerC.Buscar(Integer.parseInt(PerV.txtCedula.getText()));
                
                if(per != null)
                {
                    JOptionPane.showMessageDialog(null, "Esta cedula ya existe");
                }else{
                    
                    String sexo = (String) PerV.boxSexo.getSelectedItem();
                    PerC.aggPersona(Integer.parseInt(PerV.txtCedula.getText()),PerV.txtNombre.getText(),sexo);
                    PerV.txtCedula.setText("");
                    PerV.txtNombre.setText("");
                }
            }
        }
        
        if(e.getSource()==PerV.busButtom)
        {
            if(PerV.txtBuscar.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Llene el campo buscar");
            }else{
                Persona per = new Persona();
                        
                per = PerC.Buscar(Integer.parseInt(PerV.txtBuscar.getText()));
                
                if(per == null)
                {
                    JOptionPane.showMessageDialog(null, "La cedula no existe");
                    PerV.txtBuscar.setText("");
                }else{
                    
                    PerV.txtModCed.setText(Integer.toString(per.getId()));
                    PerV.txtModNom.setText(per.getNombre());
                    String Sexo = per.getSexo();
                    PerV.boxModSex.removeAllItems();

                    if(Sexo.equals("Femenino"))
                    {
                        PerV.boxModSex.addItem(per.getSexo());
                        PerV.boxModSex.addItem("Masculino");
                    }else{
                        PerV.boxModSex.addItem(per.getSexo());
                        PerV.boxModSex.addItem("Femenino");
                    }
                    
                    PerV.boxModSex.setEnabled(true);
                }
            }
        }
        
        if(e.getSource() == PerV.ModButton)
        {
            if(PerV.txtModCed.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Busca el registro");
            }else{
                if(PerV.txtModNom.getText().isEmpty())
                {
                    JOptionPane.showMessageDialog(null, "Llena el campo");
                }else{
                    String sexo = (String) PerV.boxModSex.getSelectedItem();
                    PerC.Modificar(Integer.parseInt(PerV.txtModCed.getText()), PerV.txtModNom.getText(), sexo);
                    PerV.boxModSex.removeAllItems();
                    PerV.boxModSex.setEnabled(false);
                    PerV.txtModCed.setText("");
                    PerV.txtModNom.setText("");
                }
            }
        }
        
        if(e.getSource() == PerV.EliButtom)
        {
            if(PerV.txtModCed.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Busca el registro");
            }else{
                String sexo = (String) PerV.boxModSex.getSelectedItem();
                PerC.Eliminar(Integer.parseInt(PerV.txtModCed.getText()),PerV.txtModNom.getText(),sexo);
                PerV.boxModSex.removeAllItems();
                PerV.boxModSex.setEnabled(false);
                PerV.txtModCed.setText("");
                PerV.txtModNom.setText("");
            }
        }

        if(e.getSource() == PerV.listButton)
        {
            DefaultTableModel tabPer= new DefaultTableModel();
            
            tabPer = PerC.listarPer();
            
            PerV.listTable.setModel(tabPer);
        }
    }
    
}
