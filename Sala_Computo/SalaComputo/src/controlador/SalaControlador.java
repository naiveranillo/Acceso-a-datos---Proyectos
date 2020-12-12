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
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author NaiAnillo
 */
public class SalaControlador implements ActionListener {

    SalaCompVista salaV = new SalaCompVista();
    SalaModelo salaM = new SalaModelo();
    
    SedeModelo sedeM = new SedeModelo();
    SedeControlador sedeC = new SedeControlador(salaV,sedeM);
    
    ComputadorModelo compM = new ComputadorModelo();
    ComputadorControlador compC = new ComputadorControlador(salaV,compM);
    
    public SalaControlador(SalaCompVista sav, SalaModelo sam)
    {
        this.salaV = sav;
        this.salaM = sam;
        
        salaV.btncresala.addActionListener(this);
        salaV.btnbuscsala.addActionListener(this);
        salaV.btnmodsala.addActionListener(this);
        salaV.btnelimsala.addActionListener(this);
        salaV.btnlistcomp.addActionListener(this);
        
        salaV.codsala.addKeyListener(new KeyListener() { //solo numeros - crear sala - atributo codigo
            @Override
            
              public void keyTyped(KeyEvent e) {
                char veri=e.getKeyChar();
                if(!Character.isDigit(veri) && veri !=e.VK_BACK_SPACE && veri !=e.VK_DELETE && veri!=e.VK_ENTER){
                    e.consume();
                    JOptionPane.showMessageDialog(salaV, "Ingrese solo numeros");
                }
                
              }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {             
            }
        });
        
        salaV.cantcompsala.addKeyListener(new KeyListener() { //solo numeros - crear sala - atributo cantcompu
            @Override
            
              public void keyTyped(KeyEvent e) {
                char veri=e.getKeyChar();
                if(!Character.isDigit(veri) && veri !=e.VK_BACK_SPACE && veri !=e.VK_DELETE && veri!=e.VK_ENTER){
                    e.consume();
                    JOptionPane.showMessageDialog(salaV, "Ingrese solo numeros");
                }
                
              }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {             
            }
        });
        
        salaV.codmodsala.addKeyListener(new KeyListener() { //solo numeros - modif sala - atributo codigo
            @Override
            
              public void keyTyped(KeyEvent e) {
                char veri=e.getKeyChar();
                if(!Character.isDigit(veri) && veri !=e.VK_BACK_SPACE && veri !=e.VK_DELETE && veri!=e.VK_ENTER){
                    e.consume();
                    JOptionPane.showMessageDialog(salaV, "Ingrese solo numeros");
                }
                
              }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {             
            }
        });
        
        salaV.cantcompmodsala.addKeyListener(new KeyListener() { //solo numeros - modif sala - atributo cant compu
            @Override
            
              public void keyTyped(KeyEvent e) {
                char veri=e.getKeyChar();
                if(!Character.isDigit(veri) && veri !=e.VK_BACK_SPACE && veri !=e.VK_DELETE && veri!=e.VK_ENTER){
                    e.consume();
                    JOptionPane.showMessageDialog(salaV, "Ingrese solo numeros");
                }
                
              }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {             
            }
        });
        
        salaV.textbuscsala.addKeyListener(new KeyListener() { //solo numeros - modif sala - atributo buscar codigo
            @Override
            
              public void keyTyped(KeyEvent e) {
                char veri=e.getKeyChar();
                if(!Character.isDigit(veri) && veri !=e.VK_BACK_SPACE && veri !=e.VK_DELETE && veri!=e.VK_ENTER){
                    e.consume();
                    JOptionPane.showMessageDialog(salaV, "Ingrese solo numeros");
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
    
    public void AggSala(int cod, String codsede, int cantcomp)
    {
        Sala sal = new Sala();
        sal.setCod(cod);
        sal.setCodsede(codsede);
        sal.setCantcomp(cantcomp);
        
        if(salaM.AggSala(sal)!=0){
            JOptionPane.showMessageDialog(null, "Sala Agregada");
        }else{
            JOptionPane.showMessageDialog(null, "Sala no Agregada");
        }
    }
    
    public void ModificarSala(int cod, String codsede, int cantcomp)
    {
        Sala sal = new Sala();
        sal.setCod(cod);
        sal.setCodsede(codsede);
        sal.setCantcomp(cantcomp);
        
        if(salaM.ModificarSala(sal)!=0){
            JOptionPane.showMessageDialog(null, "Modificacion exitosa");
        }else{
            JOptionPane.showMessageDialog(null, "Modificacion no exitosa");
        }
    }
    
    public Sala BuscarSala(int cod)
    {
        Sala sal = new Sala();
        
        sal=salaM.BuscarSala(cod);
        
        return sal;
    }
    
    public void EliminarSala(int cod)
    {
        if(salaM.EliminarSala(cod)!=0)
        {
            JOptionPane.showMessageDialog(null, "Eliminacion exitosa");
        }else{
            JOptionPane.showMessageDialog(null, "Eliminacion no exitosa");
        }
    }
    
    public DefaultTableModel listComp()
    {
        DefaultTableModel tabComp = new DefaultTableModel();
        ArrayList <Computador> listcomp = salaM.listComp();
        String tituComp[] = {"Codigo","Codigo Sede","Codigo Sala"};
        tabComp.setColumnIdentifiers(tituComp);
        Object filComp[] = new Object[3];
        for (int i = 0; i < listcomp.size(); i++) {
            filComp[0] = listcomp.get(i).getCod();
            filComp[1] = listcomp.get(i).getCodsede();
            filComp[2] = listcomp.get(i).getCodsala();
            tabComp.addRow(filComp);
        }
        
        return tabComp;
    }
    
    public int ContarSalas(String codsede)
    {
        int cont;
        
        cont = salaM.ContarSalas(codsede);
        
        return cont;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==salaV.btncresala)
        {
            if(salaV.codsala.getText().isEmpty() || salaV.codsedesala.getText().isEmpty() || salaV.cantcompsala.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Llene todos los campos");
            }else{
                
                Sala sal = new Sala();
                
                sal = BuscarSala(Integer.parseInt(salaV.codsala.getText()));
                
                if(sal != null)
                {
                    JOptionPane.showMessageDialog(null, "Este codigo existe");
                    salaV.codsala.setText("");
                }else{ 
                    Sede sed = new Sede();
                    
                    sed = sedeC.BuscarCod(salaV.codsedesala.getText());
                    
                    if(sed != null)
                    {
                        int cont;
                        cont = ContarSalas(sed.getCod());
                        
                        if(cont < sed.getCantsal())
                        {
                            AggSala(Integer.parseInt(salaV.codsala.getText()),
                            salaV.codsedesala.getText(),
                            Integer.parseInt(salaV.cantcompsala.getText()));

                            salaV.codsala.setText("");
                            salaV.codsedesala.setText("");
                            salaV.cantcompsala.setText("");
                        }else{
                            JOptionPane.showMessageDialog(null, "Ah alcanzado el maximo de salas");
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "La sede no existe");
                    }               
                }   
            }
        }
        
        if(e.getSource()==salaV.btnbuscsala)
        {
            Sala sal = new Sala();
            
            if(salaV.textbuscsala.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Llene el campo de busqueda");
            }else{
                sal=BuscarSala(Integer.parseInt(salaV.textbuscsala.getText()));
                
                if(sal != null)
                {
                    salaV.codmodsala.setText(Integer.toString(sal.getCod()));
                    salaV.sedemodsala.setText(sal.getCodsede());
                    salaV.cantcompmodsala.setText(Integer.toString(sal.getCantcomp()));
                }else{
                    JOptionPane.showMessageDialog(null, "Este codigo no existe");
                }
            }
        }
        
        if(e.getSource()==salaV.btnmodsala)
        {
            if(salaV.codmodsala.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Busque para Modificar Registro");
            }else{
                
                if(!salaV.codmodsala.getText().isEmpty() && (salaV.sedemodsala.getText().isEmpty() || salaV.cantcompmodsala.getText().isEmpty()))
                {
                   JOptionPane.showMessageDialog(null, "Llene todos los campos"); 
                }else{
                    
                    Sala sal = new Sala();
                    
                    sal = BuscarSala(Integer.parseInt(salaV.codmodsala.getText()));
                    
                    if(Integer.parseInt(salaV.cantcompmodsala.getText())< sal.getCantcomp())
                    {
                        JOptionPane.showMessageDialog(null, "No se puede disminuir la Cantidad de Computadores"); 
                    }else{
                        Sede sed = new Sede();
                    
                        sed = sedeC.BuscarCod(salaV.sedemodsala.getText());

                        if(sed != null)
                        {
                            int cont;
                            cont = ContarSalas(sed.getCod());

                            if(cont < sed.getCantsal())
                            {

                                ModificarSala(Integer.parseInt(salaV.codmodsala.getText()),
                                salaV.sedemodsala.getText(),
                                Integer.parseInt(salaV.cantcompmodsala.getText()));

                                salaV.codmodsala.setText("");
                                salaV.sedemodsala.setText("");
                                salaV.cantcompmodsala.setText("");
                            }else{
                                JOptionPane.showMessageDialog(null, "Ah alcanzado el maximo de salas");
                            }
                        }else{
                            JOptionPane.showMessageDialog(null, "La sede no existe");
                        }           
                    } 
                }    
            }
        }
        
        
        if(e.getSource()==salaV.btnelimsala)
        {
            if(salaV.codmodsala.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Busque para Eliminar Registro");
            }else{
                
                Computador comp = new Computador();
                int cont;
                
                cont = compC.ContarComp(Integer.parseInt(salaV.codmodsala.getText()));
                
                if(cont == 0)
                {
                    EliminarSala(Integer.parseInt(salaV.codmodsala.getText()));
                
                    salaV.codmodsala.setText("");
                    salaV.sedemodsala.setText("");
                    salaV.cantcompmodsala.setText("");
                }else{
                    JOptionPane.showMessageDialog(null, "No puede eliminar, tiene computadores asociados");
                }
            }
        }
        
        if(e.getSource()==salaV.btnlistcomp)
        {
            DefaultTableModel tabComp = new DefaultTableModel();
            
            tabComp = listComp();
            
            salaV.tablaComp.setModel(tabComp);
        }
    }
    
    
}
