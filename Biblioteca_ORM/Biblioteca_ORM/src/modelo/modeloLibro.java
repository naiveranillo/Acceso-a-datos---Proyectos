/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author NaiAnillo
 */
public class modeloLibro {
    
    private Session session;

    public modeloLibro() {
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        session = sesion.openSession();
    }
    
    public void aggLibro(Libro lib)
    {
        try{
            SessionFactory sesion = NewHibernateUtil.getSessionFactory();
            session = sesion.openSession();
            Transaction tx = session.beginTransaction();
            session.save(lib);
            tx.commit();
            session.close();
            JOptionPane.showMessageDialog(null, "Libro Agregado");  
        }catch(Exception e){
            
            JOptionPane.showMessageDialog(null,"Libro no Agregado - Error: "+e);
        }
    }
    
    public List<Libro> ListarPorCodISBN()
    {
        List <Libro> listLib = null;
        
        try{ 
            SessionFactory sesion = NewHibernateUtil.getSessionFactory();
            session = sesion.openSession();
            Transaction tx = session.beginTransaction();
            listLib = session.createQuery("From Libro Order By cod_isbn").list();  
            tx.commit();
            session.close();
        }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Error: "+e);
        }
        
        return listLib;
    }
    
    public List<Libro> ListarPorCateg()
    {
        List <Libro> listLib = null;
        
        try{ 
            SessionFactory sesion = NewHibernateUtil.getSessionFactory();
            session = sesion.openSession();
            Transaction tx = session.beginTransaction();
            listLib = session.createQuery("From Libro Order By categoria").list();  
            tx.commit();
            session.close();
        }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Error: "+e);
        }
        
        return listLib;
    }
    
    public List<Libro> LibrosDispo()
    {
        List <Libro> listLib = null;
        
        try{ 
            SessionFactory sesion = NewHibernateUtil.getSessionFactory();
            session = sesion.openSession();
            Transaction tx = session.beginTransaction();
            listLib = session.createQuery("From Libro Where disponibilidad = 'true' ").list();  
            tx.commit();
            session.close();
        }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Error: "+e);
        }
        
        return listLib;
    }
    
    public void LibroNoDispo(String cod_isbn, String cod_ejem)
    {  
        
        try{ 
            SessionFactory sesion = NewHibernateUtil.getSessionFactory();
            session = sesion.openSession();
            Transaction tx = session.beginTransaction();
            session.createQuery("UPDATE Libro SET disponibilidad = 'false' WHERE cod_isbn = '"+cod_isbn+"' and cod_ejemp = '"+cod_ejem+"'").executeUpdate();
            tx.commit();
            session.close();
        }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Error: "+e);
        }
        
    }
    
    public void LibroSiDispo(String cod_isbn, String cod_ejem)
    {  
        
        try{ 
            SessionFactory sesion = NewHibernateUtil.getSessionFactory();
            session = sesion.openSession();
            Transaction tx = session.beginTransaction();
            session.createQuery("UPDATE Libro SET disponibilidad = 'true' WHERE cod_isbn = '"+cod_isbn+"' and cod_ejemp = '"+cod_ejem+"'").executeUpdate();
            tx.commit();
            session.close();
        }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Error: "+e);
        }
        
    }
    
    public List<Libro> VerificarEjemp(String cod_isbn)
    {
        List<Libro> listCod = null;
        
        try{ 
            SessionFactory sesion = NewHibernateUtil.getSessionFactory();
            session = sesion.openSession();
            Transaction tx = session.beginTransaction();
            listCod = session.createQuery("From Libro Where disponibilidad = 'true' and cod_isbn = '"+cod_isbn+"' ").list();  
            tx.commit();
            session.close();
        }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Error: "+e);
        }
        
        return listCod;
    }
    
    public List<Libro> BuscarLibro(String cod_isbn, String cod_ejem)
    {
        List <Libro> lib=null;
        
        try{
            SessionFactory sesion = NewHibernateUtil.getSessionFactory();
            session = sesion.openSession();
            Transaction tx = session.beginTransaction();
            lib = session.createQuery("From Libro Where cod_isbn = '"+cod_isbn+"' and cod_ejemp = '"+cod_ejem+"' ").list();  
            tx.commit();
            session.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error: "+e);    
        }
        
        return lib;
    }
    
    public List<Libro> TodosLibros()
    {
        List <Libro> lib=null;
        
        try{
            SessionFactory sesion = NewHibernateUtil.getSessionFactory();
            session = sesion.openSession();
            Transaction tx = session.beginTransaction();
            lib = session.createQuery("From Libro").list();  
            tx.commit();
            session.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error: "+e);    
        }
        
        return lib;
    }
    
}
