/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author NaiAnillo
 */
public class ModeloPersona {
    
    private Session session;
            
    public ModeloPersona() {
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        session = sesion.openSession();
    }
    
    public void addUsuario (Persona per){
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        session = sesion.openSession();
        Transaction tx = session.beginTransaction();
        session.save(per);
        tx.commit();
        session.close();
        JOptionPane.showMessageDialog(null, "Usuario Agregado");  
    }
    
    
    public Persona Buscar(int cedula)
    {
        Persona per = null;
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        session = sesion.openSession();
        Transaction tx = session.beginTransaction();
        per = (Persona) session.get(Persona.class, cedula);
        tx.commit();
        session.close();
        
        return per;

    }
    
    public void Modificar (Persona per){
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        session = sesion.openSession();
        Transaction tx = session.beginTransaction();
        session.update(per);
        tx.commit();
        session.close();
        JOptionPane.showMessageDialog(null, "Usuario Modificado");
        
    }
 
    public void Eliminar (Persona per){
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        session = sesion.openSession();
        Transaction tx = session.beginTransaction();
        session.delete(per);
        tx.commit();
        session.close();
        JOptionPane.showMessageDialog(null, "Usuario Eliminado");        
    }
    
    public List<Persona> ListarPersona()
    {
        List<Persona> listaP = null;
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        session = sesion.openSession();
        Transaction tx = session.beginTransaction();
        listaP = session.createQuery("From Persona").list();
        tx.commit();
        session.close();
        
        return listaP;
    }
    
}
