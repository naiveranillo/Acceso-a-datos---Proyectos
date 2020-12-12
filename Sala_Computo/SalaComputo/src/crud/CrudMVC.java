/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;
import modelo.*;
import vista.*;
import controlador.*;
/**
 *
 * @author NaiAnillo
 */
public class CrudMVC {
    
    public static void main(String[] args) {
        
        SalaCompVista scv = new SalaCompVista();
        
        SedeModelo sm = new SedeModelo();
        SedeControlador sc = new SedeControlador(scv,sm);  
        
        SalaModelo sam = new SalaModelo();
        SalaControlador sac = new SalaControlador(scv,sam);
        
        ComputadorModelo cm = new ComputadorModelo();
        ComputadorControlador cc = new ComputadorControlador(scv,cm);
        
        scv.setVisible(true);
        scv.setLocationRelativeTo(null);
    }
}






