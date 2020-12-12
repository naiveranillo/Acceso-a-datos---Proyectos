/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import modelo.*;
/**
 *
 * @author NaiAnillo
 */
public class contLibro {
    
    modeloLibro ml = new modeloLibro();
    Libro lib = new Libro();
    
    public void aggLibro(String nom, String cod_isbn, String cod_ejemp, String Categ)
    {
        lib = new Libro();
        
        lib.setNombre(nom);
        lib.setCodIsbn(cod_isbn);
        lib.setCodEjemp(cod_ejemp);
        lib.setCategoria(Categ);
        lib.setDisponibilidad("true");
        
        ml.aggLibro(lib);   
        
    }
    
    public DefaultTableModel ListarLib(int ite)
    {
        List <Libro> listLib;
        
        if(ite == 0)
        {
            listLib = ml.ListarPorCodISBN();
        }else{
            listLib = ml.ListarPorCateg();
        }
        
        DefaultTableModel tabLib = new DefaultTableModel();
        String tituLib[] = {"Nombre", "Codigo ISBN", "Codigo Ejemplar", "Categoria"};
        tabLib.setColumnIdentifiers(tituLib);
        Object filLib[] = new Object[4];
        
        for(int i = 0; i<listLib.size(); i++)
        {
            filLib[0] = listLib.get(i).getNombre();
            filLib[1] = listLib.get(i).getCodIsbn();
            filLib[2] = listLib.get(i).getCodEjemp();
            filLib[3] = listLib.get(i).getCategoria();
            
            tabLib.addRow(filLib);
        }
        
        return tabLib;
    }
    
    public List<Libro> LibrosDispo()
    {
        List <Libro> listLib;
        
        listLib = ml.LibrosDispo();
        
        return listLib;
    }
    
    public void LibroNoDispo(String cod_isbn, String cod_ejem)
    {
        ml.LibroNoDispo(cod_isbn, cod_ejem);
    }
    
    public void LibroSiDispo(String cod_isbn, String cod_ejem)
    {
        ml.LibroSiDispo(cod_isbn, cod_ejem);
    }
    
    public int VerificarEjemp(String cod_isbn)
    {
        int cont=0, i;
        List <Libro> listCod;
        
        listCod = ml.VerificarEjemp(cod_isbn);
        
        for(i = 0; i<listCod.size(); i++)
        {
            cont = cont + 1;
        }
        
        return cont;
    }
    
    public List<Libro> BuscarLibro(String cod_isbn, String cod_ejem)
    {
        List<Libro> lib;
        
        lib = ml.BuscarLibro(cod_isbn, cod_ejem);
        
        return lib;
    }
    
    public List<Libro> TodosLibros()
    {
        List<Libro> lib;
        
        lib = ml.TodosLibros();
        
        return lib;
    }
}
