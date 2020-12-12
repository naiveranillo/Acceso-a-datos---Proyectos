/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import modelo.*;
/**
 *
 * @author NaiAnillo
 */
public class contUsuario {
    
    modeloUsuario mu = new modeloUsuario();
    Usuarios usu = new Usuarios();
    
    public void aggUsuario(int ced, String nom, String fecha, String sexo, String tipousu)
    {
        usu = new Usuarios();
        
        usu.setCedula(ced);
        usu.setNombre(nom);
        usu.setFechaNac(fecha);
        usu.setSexo(sexo);
        usu.setTipoUsu(tipousu);
        usu.setEstado("false");
        usu.setCantLibrosPrest(0);
        
        mu.aggUsuario(usu);
    }
    
    public DefaultTableModel ListarEstadoUsu(String est)
    {  
        List<Usuarios> listUsu;
        listUsu = mu.ListarEstadoUsu(est);
        DefaultTableModel tabUsu = new DefaultTableModel();
        String tituUsu[] = {"Cedula", "Nombre", "Fecha_Nac", "Sexo", "Tipo_Usuario"};
        tabUsu.setColumnIdentifiers(tituUsu);
        Object filUsu[] = new Object[5];
        
        for (int i=0; i<listUsu.size();i++)
        {
            filUsu[0] = listUsu.get(i).getCedula();
            filUsu[1] = listUsu.get(i).getNombre();
            filUsu[2] = listUsu.get(i).getFechaNac();
            filUsu[3] = listUsu.get(i).getSexo();
            filUsu[4] = listUsu.get(i).getTipoUsu();
            
            tabUsu.addRow(filUsu);
        }
        
        return tabUsu;
    }
    
    public boolean DatosLogin(int ced, String nom)
    {
        List<Usuarios> listUsu;
        
        listUsu= mu.DatosLogin(ced, nom);
        
        if(listUsu.isEmpty())
        {
            return false;
        }else{
            return true;
        }
       
    }        
    
    public List<Usuarios> ListarUsuariosInac()
    {
        List <Usuarios> listaUsu = null;
        
        listaUsu = mu.ListaUsuariosInac();
        
        return listaUsu;
    }
    
    public void ActivarUsuario(int ced)
    {
        mu.ActivarUsuario(ced);
    }
    
    public DefaultTableModel Listar_TipoUsu(String tip)
    {
        List<Usuarios> listUsu;
        
        if(tip.equals("Profesor") || tip.equals("Estudiante"))
        {
            listUsu = mu.Listar_TipoUsu(tip);
        }else{
            listUsu = mu.ListarTodosUsu();
        }
        
        DefaultTableModel tabUsu = new DefaultTableModel();
        String tituUsu[] = {"Cedula", "Nombre", "Fecha_Nac", "Sexo", "Tipo_Usu", "Cant_Libros"};
        tabUsu.setColumnIdentifiers(tituUsu);
        Object filUsu[] = new Object[6];
        
        for (int i=0; i<listUsu.size();i++)
        {
            filUsu[0] = listUsu.get(i).getCedula();
            filUsu[1] = listUsu.get(i).getNombre();
            filUsu[2] = listUsu.get(i).getFechaNac();
            filUsu[3] = listUsu.get(i).getSexo();
            filUsu[4] = listUsu.get(i).getTipoUsu();
            filUsu[5] = listUsu.get(i).getCantLibrosPrest();
            
            tabUsu.addRow(filUsu);
        }
        
        return tabUsu;
    }
    
    public List<Usuarios> ListarTodosUsu()
    {
        List<Usuarios> listUsu;
        
        listUsu = mu.ListarTodosUsu();
        
        return listUsu;
    }
    
    public Usuarios BuscarUsuario(int ced)
    {
        usu = new Usuarios();

        usu = mu.BuscarUsuario(ced);
        
        return usu;
    }
    
    public void ModificarUsuario(int ced, String nom, String fecha, String sexo, String tipousu, String estado, int cant_lib){
        
        usu = new Usuarios();
        
        usu.setCedula(ced);
        usu.setNombre(nom);
        usu.setFechaNac(fecha);
        usu.setSexo(sexo);
        usu.setTipoUsu(tipousu);
        usu.setEstado(estado);
        usu.setCantLibrosPrest(cant_lib);
        
        mu.ModificarUsuario(usu);
    }
    
    public List<Usuarios> ListarUsuAct()
    {
        List<Usuarios> listaUsu;
        
        listaUsu = mu.ListarUsuAct();
        
        return listaUsu;
    }
    
    public void SumarLibrosUsu(int ced)
    {
        mu.SumarLibrosUsu(ced);
    }
    
    public void RestarLibrosUsu(int ced)
    {
        mu.RestarLibrosUsu(ced);
    }
    
    public List <Usuarios> BuscarUsuarioList (int ced)
    {
        List <Usuarios> listusu;
        
        listusu = mu.BuscarUsuarioList(ced);
        
        return listusu;
    }
}
