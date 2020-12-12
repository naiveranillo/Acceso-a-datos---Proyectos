/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crudmvc;
import modelo.*;
import vista.*;
import controlador.*;
/**
 *
 * @author Naiver Anillo
 */

public class Crudmvc {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        PersonaVista pv = new PersonaVista();
        PersonaDAO pd = new PersonaDAO();
        PersonaControlador pc = new PersonaControlador(pv,pd);
        
        pv.setVisible(true);
        pv.setLocationRelativeTo(null);
    }
    
}
