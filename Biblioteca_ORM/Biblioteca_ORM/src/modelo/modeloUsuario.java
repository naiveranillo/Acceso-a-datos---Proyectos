/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.PreparedStatement;
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
public class modeloUsuario {
    
    private Session session;
    Usuarios usu = new Usuarios();

    public modeloUsuario() {
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        session = sesion.openSession();
    }
    
    public void aggUsuario(Usuarios usu)
    {
        try{
            SessionFactory sesion = NewHibernateUtil.getSessionFactory();
            session = sesion.openSession();
            Transaction tx = session.beginTransaction();
            session.save(usu);
            tx.commit();
            session.close();
            JOptionPane.showMessageDialog(null, "Usuario Agregado");  
        }catch(Exception e){
            
            JOptionPane.showMessageDialog(null,"Usuario no Agregado - Error: "+e);
        }
    }
    
    public List<Usuarios> ListarEstadoUsu(String estado)
    {
        
        List<Usuarios> listaUsu = null;
        try{ 
            SessionFactory sesion = NewHibernateUtil.getSessionFactory();
            session = sesion.openSession();
            Transaction tx = session.beginTransaction();
            listaUsu = session.createQuery("From Usuarios Where estado = '"+estado+"' ").list();  
            tx.commit();
            session.close();
        }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Error: "+e);
        }
        
        
        return listaUsu;
    }
    
    public List<Usuarios> DatosLogin(int ced, String nom)
    {
        List<Usuarios> listaUsu = null;
        try{ 
            SessionFactory sesion = NewHibernateUtil.getSessionFactory();
            session = sesion.openSession();
            Transaction tx = session.beginTransaction();
            listaUsu = session.createQuery("From Usuarios Where nombre = '"+nom+"' and cedula = '"+ced+"' and tipo_usu = 'Bibliotecario'").list();  
            tx.commit();
            session.close();
        }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Error: "+e);
        }
        
        return listaUsu;
    }
    
    public List<Usuarios> ListaUsuariosInac()
    {
        List<Usuarios> listaUsu = null;
        
        try{
            SessionFactory sesion = NewHibernateUtil.getSessionFactory();
            session = sesion.openSession();
            Transaction tx = session.beginTransaction();
            listaUsu = session.createQuery("From Usuarios Where estado = 'false' ").list();  
            tx.commit();
            session.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error: "+e);
        }
        
        return listaUsu;
    }
    
    public void ActivarUsuario(int ced)
    {
        try{
            SessionFactory sesion = NewHibernateUtil.getSessionFactory();
            session = sesion.openSession();
            Transaction tx = session.beginTransaction();
            session.createQuery("UPDATE Usuarios SET estado = 'true' WHERE cedula = '"+ced+"' ").executeUpdate();
            tx.commit();
            session.close();
            JOptionPane.showMessageDialog(null, "Usuario Activado"); 
           
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error: "+e);
        }
    }
    
    public List<Usuarios> Listar_TipoUsu(String tip)
    {
        
        List<Usuarios> listaUsu = null;
        try{ 
            SessionFactory sesion = NewHibernateUtil.getSessionFactory();
            session = sesion.openSession();
            Transaction tx = session.beginTransaction();
            listaUsu = session.createQuery("From Usuarios Where tipo_usu = '"+tip+"' ").list();  
            tx.commit();
            session.close();
        }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Error: "+e);
        }
        
        
        return listaUsu;
    }
    
    public List<Usuarios> ListarTodosUsu()
    {
        List<Usuarios> listaUsu = null;
        try{ 
            SessionFactory sesion = NewHibernateUtil.getSessionFactory();
            session = sesion.openSession();
            Transaction tx = session.beginTransaction();
            listaUsu = session.createQuery("From Usuarios").list();  
            tx.commit();
            session.close();
        }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Error: "+e);
        }

        return listaUsu;
    }
    
    public Usuarios BuscarUsuario(int ced)
    {
        Usuarios usu = null;
        try{
            SessionFactory sesion = NewHibernateUtil.getSessionFactory();
            session = sesion.openSession();
            Transaction tx = session.beginTransaction();
            usu = (Usuarios) session.get(Usuarios.class, ced);
            tx.commit();
            session.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error: "+e);    
        }
        
        return usu;
    }
    
    public void ModificarUsuario(Usuarios usu)
    {
        try{
            SessionFactory sesion = NewHibernateUtil.getSessionFactory();
            session = sesion.openSession();
            Transaction tx = session.beginTransaction();
            session.update(usu);
            tx.commit();
            session.close();
            JOptionPane.showMessageDialog(null, "Modificacion Exitosa");
        }catch(Exception e){
            
            JOptionPane.showMessageDialog(null,"Modificacion no Exitosa || Error: "+e);    
        }
    }
    
    public List<Usuarios> ListarUsuAct()
    {
        
        List<Usuarios> listaUsu = null;
        try{ 
            SessionFactory sesion = NewHibernateUtil.getSessionFactory();
            session = sesion.openSession();
            Transaction tx = session.beginTransaction();
            listaUsu = session.createQuery("From Usuarios Where estado = 'true' and tipo_usu != 'Bibliotecario'").list();  
            tx.commit();
            session.close();
        }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Error: "+e);
        }
        
        
        return listaUsu;
    }
    
    public void SumarLibrosUsu(int ced)
    {
        try{
            SessionFactory sesion = NewHibernateUtil.getSessionFactory();
            session = sesion.openSession();
            Transaction tx = session.beginTransaction();
            session.createQuery("UPDATE Usuarios SET cant_libros_prest = cant_libros_prest+1 WHERE cedula = '"+ced+"' ").executeUpdate();
            tx.commit();
            session.close();
           
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error: "+e);
        }
    }
    
    public void RestarLibrosUsu(int ced)
    {
        try{
            SessionFactory sesion = NewHibernateUtil.getSessionFactory();
            session = sesion.openSession();
            Transaction tx = session.beginTransaction();
            session.createQuery("UPDATE Usuarios SET cant_libros_prest = cant_libros_prest-1 WHERE cedula = '"+ced+"' ").executeUpdate();
            tx.commit();
            session.close();
           
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error: "+e);
        }
    }
    
    public List<Usuarios> BuscarUsuarioList (int ced)
    {
        List <Usuarios> listusu = null;
        try{
            SessionFactory sesion = NewHibernateUtil.getSessionFactory();
            session = sesion.openSession();
            Transaction tx = session.beginTransaction();
            listusu = session.createQuery("From Usuarios Where cedula = '"+ced+"' ").list();  
            tx.commit();
            session.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error: "+e);    
        }
        
        return listusu;
    }
}
