/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import modelo.*;
import vista.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;





/**
 *
 * @author NaiAnillo
 */
public class SedeControlador implements ActionListener {
    SalaCompVista sedeV = new SalaCompVista();
    SedeModelo SedeM = new SedeModelo(); 
    
    public SedeControlador (SalaCompVista scv, SedeModelo sm){
        //CONSTRUCTOR
        this.sedeV = scv;
        this.SedeM = sm;
        
        sedeV.aggsede.addActionListener(this);
        sedeV.btnbuscmod.addActionListener(this);
        sedeV.btnmodse.addActionListener(this);
        sedeV.btnelimsed.addActionListener(this);
        sedeV.btnlistsala.addActionListener(this);
        
        sedeV.nomse.addKeyListener(new KeyListener() { //limite de caracteres - crear sede - atributo nombre
            @Override
            
              public void keyTyped(KeyEvent e) {
                
                if(sedeV.nomse.getText().length()==30){
                    e.consume();
                
                }
              }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {             
            }
        });
        
        sedeV.codse.addKeyListener(new KeyListener() { //limite de caracteres - crear sede - atributo codigo
            @Override
            
              public void keyTyped(KeyEvent e) {
                
                if(sedeV.codse.getText().length()==10){
                    e.consume();
                
                }
              }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {             
            }
        });
        
        sedeV.nommodi.addKeyListener(new KeyListener() { //limite de caracteres - modif sede - atributo nombre
            @Override
            
              public void keyTyped(KeyEvent e) {
                
                if(sedeV.nommodi.getText().length()==30){
                    e.consume();
                
                }
              }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {             
            }
        });
        
        sedeV.telse.addKeyListener(new KeyListener() { //solo numeros - crear sede - atributo telefono
            @Override
            
              public void keyTyped(KeyEvent e) {
                char veri=e.getKeyChar();
                if(!Character.isDigit(veri) && veri !=e.VK_BACK_SPACE && veri !=e.VK_DELETE && veri!=e.VK_ENTER){
                    e.consume();
                    JOptionPane.showMessageDialog(sedeV, "Ingrese solo numeros");
                }
                
              }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {             
            }
        });
        
        sedeV.telmod.addKeyListener(new KeyListener() { //solo numeros - modif sede - atributo telefono
            @Override
            
              public void keyTyped(KeyEvent e) {
                char veri=e.getKeyChar();
                if(!Character.isDigit(veri) && veri !=e.VK_BACK_SPACE && veri !=e.VK_DELETE && veri!=e.VK_ENTER){
                    e.consume();
                    JOptionPane.showMessageDialog(sedeV, "Ingrese solo numeros");
                }
                
              }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {             
            }
        });
        
        sedeV.cantse.addKeyListener(new KeyListener() { //solo numeros - crear sede - atributo cantidad salas
            @Override
            
              public void keyTyped(KeyEvent e) {
                char veri=e.getKeyChar();
                if(!Character.isDigit(veri) && veri !=e.VK_BACK_SPACE && veri !=e.VK_DELETE && veri!=e.VK_ENTER){
                    e.consume();
                    JOptionPane.showMessageDialog(sedeV, "Ingrese solo numeros");
                }
                
              }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {             
            }
        });
        
        sedeV.cantmod.addKeyListener(new KeyListener() { //solo numeros - modif sede - atributo cantidad sala
            @Override
            
              public void keyTyped(KeyEvent e) {
                char veri=e.getKeyChar();
                if(!Character.isDigit(veri) && veri !=e.VK_BACK_SPACE && veri !=e.VK_DELETE && veri!=e.VK_ENTER){
                    e.consume();
                    JOptionPane.showMessageDialog(sedeV, "Ingrese solo numeros");
                }
                
              }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {             
            }
        });
        
        
    }

    
    public void AggSede (String nom, String cod, String dir, int tel, int cantsal)
    {   //AGREGAR
        Sede sed = new Sede();
        sed.setNombre(nom);
        sed.setCod(cod);
        sed.setDir(dir);
        sed.setNumtel(tel);
        sed.setCantsal(cantsal);
        
        if(SedeM.AggSede(sed)!=0)
        {
            JOptionPane.showMessageDialog(null, "Sede Agregado");
        }else{
            JOptionPane.showMessageDialog(null, "Sede no Agregado");
        }
        
    }
    
    public void ModificarSede (String cod, String nom, String dir, int tel, int cantsal)
    {   //MODIFICAR
        Sede sed = new Sede();
        sed.setNombre(nom);
        sed.setCod(cod);
        sed.setDir(dir);
        sed.setNumtel(tel);
        sed.setCantsal(cantsal);
        
        if(SedeM.ModificarSede(sed)!=0)
        {
            JOptionPane.showMessageDialog(null, "Modificacion exitosa");
        }else{
            JOptionPane.showMessageDialog(null, "Modificacion no exitosa");
        }
    }
    
    public Sede BuscarCod(String cod)     //BUSCAR    
    {
        Sede sed = new Sede();
        sed=SedeM.BuscarCod(cod);
        
        return sed;
    }
    
    public void EliminarSede(String cod) //ELIMINAR
    {
        
        if(SedeM.EliminarSede(cod)!=0)
        {
            JOptionPane.showMessageDialog(null, "Eliminacion exitosa");
        }else{
            JOptionPane.showMessageDialog(null, "Eliminacion no exitosa");
        }
    }
    
    public DefaultTableModel listSala()
    {
       DefaultTableModel tabSala= new DefaultTableModel(); 
       ArrayList <Sala> listsal = SedeM.listSala();
       String tituSala[] = {"Codigo","Codigo Sede","Cantidad de Computadores"};
       tabSala.setColumnIdentifiers(tituSala);
       Object filSala[]= new Object[3];
        for (int i = 0; i < listsal.size(); i++) {
            filSala[0] = listsal.get(i).getCod();
            filSala[1] = listsal.get(i).getCodsede();
            filSala[2] = listsal.get(i).getCantcomp();
            tabSala.addRow(filSala);
        }
       return tabSala;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
       if(e.getSource()==sedeV.aggsede)
       {
           if(sedeV.nomse.getText().isEmpty() || 
                   sedeV.codse.getText().isEmpty() || 
                   sedeV.dirse.getText().isEmpty() || 
                   sedeV.telse.getText().isEmpty() || 
                   sedeV.cantse.getText().isEmpty())
           {
               JOptionPane.showMessageDialog(null, "Llene todos los campos");
           }else{
               Sede sed = new Sede();
               
               sed = BuscarCod(sedeV.codse.getText());
               
               if(sed != null)
               {
                   JOptionPane.showMessageDialog(null, "Este Codigo ya existe");
                   sedeV.codse.setText("");
               }else{
                    AggSede(sedeV.nomse.getText(),
                    sedeV.codse.getText(),
                    sedeV.dirse.getText(),
                    Integer.parseInt(sedeV.telse.getText()),
                    Integer.parseInt(sedeV.cantse.getText()));
               
                    sedeV.nomse.setText("");
                    sedeV.codse.setText("");
                    sedeV.dirse.setText("");
                    sedeV.telse.setText("");
                    sedeV.cantse.setText("");
               }               
           }
       }
       
       if(e.getSource()==sedeV.btnbuscmod)
       {
           Sede sed = new Sede();
           
           if(sedeV.textbusc.getText().isEmpty())
           {
               JOptionPane.showMessageDialog(null, "Llene el campo de busqueda");
           }else{
               sed=BuscarCod(sedeV.textbusc.getText());
               
                if(sed != null)
                {
                    sedeV.codmod.setText(sed.getCod());
                    sedeV.nommodi.setText(sed.getNombre());
                    sedeV.dirmod.setText(sed.getDir());
                    sedeV.telmod.setText(Integer.toString(sed.getNumtel()));
                    sedeV.cantmod.setText(Integer.toString(sed.getCantsal()));
                }else{
                    JOptionPane.showMessageDialog(null, "Este codigo no existe");
                }
           }
               
       }
       
       if(e.getSource()==sedeV.btnmodse)
           {
               if(sedeV.codmod.getText().isEmpty())
               {
                   JOptionPane.showMessageDialog(null, "Busque para Modificar Registro");
               }else{
                   
                   if(!sedeV.codmod.getText().isEmpty() && (sedeV.nommodi.getText().isEmpty() || sedeV.dirmod.getText().isEmpty() || sedeV.telmod.getText().isEmpty() || sedeV.cantmod.getText().isEmpty()))
                   {
                       JOptionPane.showMessageDialog(null, "Llene todos los campos");
                   }else{
                       
                       Sede sed = new Sede();
                       
                       sed = BuscarCod(sedeV.codmod.getText());
                       
                       if(Integer.parseInt(sedeV.cantmod.getText())< sed.getCantsal())
                       {
                           JOptionPane.showMessageDialog(null, "No se puede disminuir el numero de salas");
                       }else{
                           
                            ModificarSede(sedeV.codmod.getText(),
                            sedeV.nommodi.getText(),
                            sedeV.dirmod.getText(),
                            Integer.parseInt(sedeV.telmod.getText()),
                            Integer.parseInt(sedeV.cantmod.getText()));
                       
                            sedeV.codmod.setText("");
                            sedeV.nommodi.setText("");
                            sedeV.dirmod.setText("");
                            sedeV.telmod.setText("");
                            sedeV.cantmod.setText("");
                            
                       }
                   }
               }
           }
       
       if(e.getSource()==sedeV.btnelimsed)
       {
           if(sedeV.codmod.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Busque para Eliminar Registro");
            }else{
               EliminarSede(sedeV.codmod.getText());
               
               sedeV.codmod.setText("");
               sedeV.nommodi.setText("");
               sedeV.dirmod.setText("");
               sedeV.telmod.setText("");
               sedeV.cantmod.setText("");
            }
       }
       
       if(e.getSource()==sedeV.btnlistsala)
       {
           DefaultTableModel tabSala= new DefaultTableModel();
           
           tabSala = listSala();
           
           sedeV.tablaSala.setModel(tabSala);
       }
        
        //aqui hago las invocaciones de lo subprogramas
    }
    
 
    
}
