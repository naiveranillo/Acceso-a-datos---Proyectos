/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda_hibernate;

import controlador.*;
import modelo.*;
import vista.*;
/**
 *
 * @author NaiAnillo
 */
public class Crud {
    
    public static void main(String[] args) {
        
        VistaPersona vp = new VistaPersona();
        controladorPersona cp = new controladorPersona();
        
        FrontController fc = new FrontController(cp,vp);
        
        vp.setVisible(true);
        vp.setLocationRelativeTo(null);
    }
}
