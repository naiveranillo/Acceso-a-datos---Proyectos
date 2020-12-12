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
import javax.swing.JOptionPane;



/**
 *
 * @author NaiAnillo
 */
public class ComputadorControlador implements ActionListener {
   SalaCompVista compV = new SalaCompVista();
   ComputadorModelo compM = new ComputadorModelo();
   
   public ComputadorControlador(SalaCompVista scv, ComputadorModelo cm)
   {
       this.compV = scv;
       this.compM = cm;
       
       compV.btnaggcomp.addActionListener(this);
       compV.btnbuscomp.addActionListener(this);
       compV.btnmodcomp.addActionListener(this);
       compV.btnelimcomp.addActionListener(this);
       
       compV.codcomp.addKeyListener(new KeyListener() { //solo numeros - crear comp - atributo codigo
            @Override
            
              public void keyTyped(KeyEvent e) {
                char veri=e.getKeyChar();
                if(!Character.isDigit(veri) && veri !=e.VK_BACK_SPACE && veri !=e.VK_DELETE && veri!=e.VK_ENTER){
                    e.consume();
                    JOptionPane.showMessageDialog(compV, "Ingrese solo numeros");
                }
                
              }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {             
            }
        });
       
       compV.codsalacomp.addKeyListener(new KeyListener() { //solo numeros - crear comp - atributo codsala
            @Override
            
              public void keyTyped(KeyEvent e) {
                char veri=e.getKeyChar();
                if(!Character.isDigit(veri) && veri !=e.VK_BACK_SPACE && veri !=e.VK_DELETE && veri!=e.VK_ENTER){
                    e.consume();
                    JOptionPane.showMessageDialog(compV, "Ingrese solo numeros");
                }
                
              }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {             
            }
        });
       
       compV.textbuscomp.addKeyListener(new KeyListener() { //solo numeros - modif comp - atributo codigo
            @Override
            
              public void keyTyped(KeyEvent e) {
                char veri=e.getKeyChar();
                if(!Character.isDigit(veri) && veri !=e.VK_BACK_SPACE && veri !=e.VK_DELETE && veri!=e.VK_ENTER){
                    e.consume();
                    JOptionPane.showMessageDialog(compV, "Ingrese solo numeros");
                }
                
              }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {             
            }
        });
       
       compV.codsalmodcomp.addKeyListener(new KeyListener() { //solo numeros - modif comp - atributo cod sala
            @Override
            
              public void keyTyped(KeyEvent e) {
                char veri=e.getKeyChar();
                if(!Character.isDigit(veri) && veri !=e.VK_BACK_SPACE && veri !=e.VK_DELETE && veri!=e.VK_ENTER){
                    e.consume();
                    JOptionPane.showMessageDialog(compV, "Ingrese solo numeros");
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
   
   public void AggComp(int cod, String codsede, int codsala)
   {
       Computador comp = new Computador();
       comp.setCod(cod);
       comp.setCodsede(codsede);
       comp.setCodsala(codsala);
       
       if(compM.AggComp(comp)!=0)
       {
           JOptionPane.showMessageDialog(null, "Computador Agregado");
       }else{
           JOptionPane.showMessageDialog(null, "Computador no Agregado");
       }
   }
   
   public void ModificarComp (int cod, String codsede, int codsala)
   {
       Computador comp = new Computador();
       comp.setCod(cod);
       comp.setCodsede(codsede);
       comp.setCodsala(codsala);
       
       if(compM.ModificarComp(comp)!=0)
       {
           JOptionPane.showMessageDialog(null, "Modificacion exitosa");
       }else{
           JOptionPane.showMessageDialog(null, "Modificacion no exitosa");
       }
   }
   
   public Computador BuscarComp(int cod)
   {
       Computador comp = new Computador();
       comp=compM.BuscarComp(cod);
       
       return comp;
   }
   
   public void EliminarComp(int cod)
   {
       if(compM.EliminarComp(cod)!=0)
       {
           JOptionPane.showMessageDialog(null, "Eliminacion exitosa");
       }else{
           JOptionPane.showMessageDialog(null, "Eliminacion no exitosa");
       }
   }
   
   public int ContarComp(int codsala)
   {
       int cont;
       
       cont = compM.ContarComp(codsala);
       
       return cont;
   }
   
   public Sede ExisteSede(String cod)
   {
        Sede sed = new Sede();
        
        sed=compM.ExisteSede(cod);
        
        return sed;
       
   }
   
   public Sala ExisteSala(int cod)
   {
       Sala sal = new Sala();
       
       sal = compM.ExisteSala(cod);
       
       return sal;
   }
   
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==compV.btnaggcomp)
        {
            if(compV.codcomp.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Llene el campo codigo");
            }else{
                
                if(compV.codsalacomp.getText().isEmpty())
                {
                    Computador comp = new Computador();
                    
                    comp = BuscarComp(Integer.parseInt(compV.codcomp.getText()));
                    
                    if(comp != null)
                    {
                        JOptionPane.showMessageDialog(null, "Este codigo ya existe");
                    }else{
                        Sede sed = new Sede();
                        
                        sed = ExisteSede(compV.codsedecomp.getText());
                        
                        if(sed == null)
                        {
                            JOptionPane.showMessageDialog(null, "La sede no existe");
                            
                            compV.codsedecomp.setText("");
                        }else{
                            AggComp(Integer.parseInt(compV.codcomp.getText()), //MANDE UN 0, SI NO DIGITO CODIGO DE SALA, PORQUE EN LA BD CODSALA ES ENTERA
                            compV.codsedecomp.getText(),
                            0);

                            compV.codcomp.setText("");
                            compV.codsedecomp.setText("");
                            compV.codsalacomp.setText("");               
                        }
                    }
                }else{
                    
                    Computador comp = new Computador();
                    
                    comp = BuscarComp(Integer.parseInt(compV.codcomp.getText()));
                    
                    if(comp != null)
                    {
                       JOptionPane.showMessageDialog(null, "Este codigo ya existe");
                    }else{
                        
                         Sede sed = new Sede();
                        
                            sed = ExisteSede(compV.codsedecomp.getText());
                        
                        if(sed == null) //hecho
                        {
                            JOptionPane.showMessageDialog(null, "La sede no existe"); //hecho
                            
                            compV.codsedecomp.setText(""); //hecho
                        }else{//hecho
                            
                            Sala sal = new Sala(); //hecho
                            
                            sal = ExisteSala(Integer.parseInt(compV.codsalacomp.getText())); //hecho
                            
                            if(sal != null) //hecho
                            {
                                comp = new Computador();
                                int cont;
                                
                                cont = ContarComp(Integer.parseInt(compV.codsalacomp.getText()));
                                
                                if(cont < sal.getCantcomp())
                                {
                                    AggComp(Integer.parseInt(compV.codcomp.getText()),
                                    compV.codsedecomp.getText(),
                                    Integer.parseInt(compV.codsalacomp.getText()));

                                    compV.codcomp.setText("");
                                    compV.codsedecomp.setText("");
                                    compV.codsalacomp.setText("");  
                                }else{
                                    JOptionPane.showMessageDialog(null, "Ah alcanzado el numero maximo de computadores");
                                }
                                
                                
                            }else{
                                JOptionPane.showMessageDialog(null, "La sala no existe");
                                
                                compV.codsalacomp.setText("");
                            }
                        }
                              
                    }    
                }       
            }
        }
        
        if(e.getSource()==compV.btnbuscomp)
        {
            Computador comp = new Computador();
            
            if(compV.textbuscomp.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Llene el campo de busqueda");
            }else{
                comp=BuscarComp(Integer.parseInt(compV.textbuscomp.getText()));
                
                if(comp != null)
                {
                    compV.codmodcomp.setText(Integer.toString(comp.getCod()));
                    compV.codsedmodcomp.setText(comp.getCodsede());
                    compV.codsalmodcomp.setText(Integer.toString(comp.getCodsala()));
                }else{
                    JOptionPane.showMessageDialog(null, "Este codigo no existe");
                }
            }
        }
        
        if(e.getSource()==compV.btnmodcomp)
        {
            if(compV.codmodcomp.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Busque para Modificar Registro");
            }else{
                if(!compV.codmodcomp.getText().isEmpty() && (compV.codsedmodcomp.getText().isEmpty()) )
                {
                    JOptionPane.showMessageDialog(null, "Llene todos los campos");
                }else{
                    
                    if(compV.codsalmodcomp.getText().isEmpty())
                    {
                        Sede sed = new Sede();
                        
                        sed = ExisteSede(compV.codsedmodcomp.getText());
                        
                        if(sed == null)
                        {
                            JOptionPane.showMessageDialog(null, "La sede no existe");
                            compV.codsedmodcomp.setText("");
                        }else{
                            ModificarComp(Integer.parseInt(compV.codmodcomp.getText()),
                                    compV.codsedmodcomp.getText(),
                                    0);
                            
                            compV.codmodcomp.setText("");
                            compV.codsedmodcomp.setText("");
                            compV.codsalmodcomp.setText("");
                        }    
                        
                    }else{
                        
                        Sede sed = new Sede();
                        
                        sed = ExisteSede(compV.codsedmodcomp.getText());
                        
                        if(sed == null)
                        {
                            JOptionPane.showMessageDialog(null, "La sede no existe");
                            compV.codsedmodcomp.setText("");
                        }else{
                            Sala sal = new Sala();
                            
                            sal = ExisteSala(Integer.parseInt(compV.codsalmodcomp.getText()));
                            
                            if(sal != null)
                            {
                                Computador comp = new Computador();
                                int cont;
                                
                                cont = ContarComp(Integer.parseInt(compV.codsalmodcomp.getText()));
                                
                                if(cont < sal.getCantcomp())
                                {
                                    ModificarComp(Integer.parseInt(compV.codmodcomp.getText()),
                                    compV.codsedmodcomp.getText(),
                                    Integer.parseInt(compV.codsalmodcomp.getText()));

                                    compV.codmodcomp.setText("");
                                    compV.codsedmodcomp.setText("");
                                    compV.codsalmodcomp.setText("");
                                }else{
                                    JOptionPane.showMessageDialog(null, "Ah alcanzado el numero maximo de computadores");
                                }
                            }else{
                                JOptionPane.showMessageDialog(null, "La sala no existe");
                                
                                compV.codsalmodcomp.setText("");
                            }
                        }
                    }
  
                }
            }
        }
        
        if(e.getSource()==compV.btnelimcomp)
        {
            if(compV.codmodcomp.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Busque para Eliminar Registro");
            }else{
                EliminarComp(Integer.parseInt(compV.codmodcomp.getText()));
                
                 compV.codmodcomp.setText("");
                 compV.codsedmodcomp.setText("");
                 compV.codsalmodcomp.setText("");
            }
        }
    }
}
