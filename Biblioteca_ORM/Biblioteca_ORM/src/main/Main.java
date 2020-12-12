/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;
import controlador.*;
import vista.*;

import javax.swing.JTextField;

/**
 *
 * @author NaiAnillo
 */
public class Main {
 
    public static void main(String[] args) {
        
        vistaBiblioteca vb = new vistaBiblioteca();
        contUsuario cu = new contUsuario();
        contLibro cl = new contLibro();
        contPrestamo cp = new contPrestamo();
        
        FrontController fc = new FrontController(vb,cu,cl,cp);
        
        vb.setVisible(true);
        vb.setLocationRelativeTo(null);
    }
}
