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
public class modeloPrestamo {
    
    private Session session;

    public modeloPrestamo() {
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        session = sesion.openSession();
    }
    
    public void aggPrestamo(Prestamo pre)
    {
        try{
            SessionFactory sesion = NewHibernateUtil.getSessionFactory();
            session = sesion.openSession();
            Transaction tx = session.beginTransaction();
            session.save(pre);
            tx.commit();
            session.close();
            JOptionPane.showMessageDialog(null, "Prestamo Relizado con Exito");  
        }catch(Exception e){
            
            JOptionPane.showMessageDialog(null,"Prestamo no Realizado - Error: "+e);
        }
    }
    
    public List<Prestamo> Registro()
    {
        List<Prestamo> Reg = null;
        
        try{ 
            SessionFactory sesion = NewHibernateUtil.getSessionFactory();
            session = sesion.openSession();
            Transaction tx = session.beginTransaction();
            Reg = session.createQuery("From Prestamo").list();  
            tx.commit();
            session.close();
        }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Error: "+e);
        }
        
        return Reg;
    }
    
    public List<Prestamo> BuscarPrestamo(String cod_isbn, String cod_ejem)
    {
        List <Prestamo> pre=null;
        
        try{
            SessionFactory sesion = NewHibernateUtil.getSessionFactory();
            session = sesion.openSession();
            Transaction tx = session.beginTransaction();
            pre = session.createQuery("From Prestamo Where cod_isbn = '"+cod_isbn+"' and cod_ejemp = '"+cod_ejem+"' ").list();  
            tx.commit();
            session.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error: "+e);    
        }
        
        return pre;
    }
    
    public void EliminarPres(String cod_isbn, String cod_ejem)
    {
        
        try{
            SessionFactory sesion = NewHibernateUtil.getSessionFactory();
            session = sesion.openSession();
            Transaction tx = session.beginTransaction();
            session.createQuery("DELETE FROM Prestamo WHERE cod_isbn = '"+cod_isbn+"' and cod_ejemp = '"+cod_ejem+"' ").executeUpdate();
            tx.commit();
            session.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error: "+e);    
        }
        
    }
    
    
}
