/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import java.util.List;
import modelo.*;

/**
 *
 * @author NaiAnillo
 */
public class contPrestamo {
    
    modeloPrestamo mp = new modeloPrestamo();
    Prestamo pre = new Prestamo();
    
    public void aggPrestamo(int ced, String cod_isbn, String cod_ejem)
    {
        pre = new Prestamo();
        
        pre.setCedula(ced);
        pre.setCodIsbn(cod_isbn);
        pre.setCodEjemp(cod_ejem);  
        
        mp.aggPrestamo(pre);
    }
    
    public List<Prestamo> Registro()
    {
        List <Prestamo> Reg;
        
        Reg = mp.Registro();
        
        return Reg;
    }
    
    public List<Prestamo> BuscarPrestamo(String cod_isbn, String cod_ejem)
    {
        List<Prestamo> pre;
        
        pre = mp.BuscarPrestamo(cod_isbn, cod_ejem);
        
        return pre;
    }
    
    public void EliminarPres(String cod_isbn, String cod_ejem)
    {
        mp.EliminarPres(cod_isbn, cod_ejem);
    }
}
