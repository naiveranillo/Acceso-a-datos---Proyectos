/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import controlador.*;
import modelo.*;
import vista.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author NaiAnillo
 */
public class FrontController implements ActionListener{
    
    vistaBiblioteca BibliV = new vistaBiblioteca();
    contUsuario UsuC = new contUsuario();
    contLibro LibC = new contLibro();
    contPrestamo PreC = new contPrestamo();
    Usuarios usu = new Usuarios();
    Libro lib = new Libro();
    Prestamo pre = new Prestamo();
    
    //Guardar Datos 
    String estado;
    int cant_lib;
    int cedula;
    
    
    public FrontController(vistaBiblioteca vb, contUsuario cu, contLibro cl, contPrestamo cp) {
        this.BibliV = vb;
        this.UsuC = cu;
        this.LibC = cl;
        this.PreC = cp;
        
        //Paleta de Registro
        BibliV.textCedula.addActionListener(this);
        BibliV.textNombre.addActionListener(this);
        BibliV.textFecha.addActionListener(this);
        BibliV.comboSexo.addActionListener(this);
        BibliV.comboTipousu.addActionListener(this);
        BibliV.buttonAgg.addActionListener(this);   
       
        //Paleta de Login
        BibliV.buttonCerrar.addActionListener(this);
        BibliV.buttonLogin.addActionListener(this);
        
        //Paleta Menu
        BibliV.tabbedMenu.setVisible(false);
        BibliV.buttonCerrar.setVisible(false);
        
        //Paleta Crear Libros 
        BibliV.textNomLib.addActionListener(this);
        BibliV.textCodISBN.addActionListener(this);
        BibliV.textCodEjem.addActionListener(this);
        BibliV.textCateg.addActionListener(this);
        BibliV.buttonAggLib.addActionListener(this);
        
        //Paleta Estado de Usuarios
        BibliV.buttonEstUsu.addActionListener(this);
        BibliV.comboEstUsu.addActionListener(this);
        
        //Paleta Activar Usuarios
        BibliV.comboActUsu.addActionListener(this);
        BibliV.buttonActUsu.addActionListener(this);
        
        //Rellenar Combobox "Panel Activar Usuarios"
        List <Usuarios> listaUsu = UsuC.ListarUsuariosInac();
        BibliV.comboActUsu.addItem("Seleccione:");
        for(int i = 0; i<listaUsu.size(); i++)
        {
            BibliV.comboActUsu.addItem(Integer.toString(listaUsu.get(i).getCedula()));
        }
        
        //Paleta Lista de Usuarios
        BibliV.comboListUsu.addActionListener(this);
        BibliV.buttonListUsu.addActionListener(this);
        
        //Paleta Modificar Usuario
        BibliV.comboBusUsu.addActionListener(this);
        BibliV.buttonBusUsu.addActionListener(this);
        BibliV.textModCed.addActionListener(this);
        BibliV.textModNom.addActionListener(this);
        BibliV.textModFec.addActionListener(this);
        BibliV.comboModSex.addActionListener(this);
        BibliV.comboModTpUsu.addActionListener(this);
        BibliV.buttonModUsu.addActionListener(this);
        
        //Rellenar Combobox "Buscar Usuario"
        List <Usuarios> listUsu = UsuC.ListarTodosUsu();
        BibliV.comboBusUsu.addItem("Seleccione:");
        for(int i =0; i<listUsu.size(); i++)
        {
            BibliV.comboBusUsu.addItem(Integer.toString(listUsu.get(i).getCedula()));
        }
        
        //Paleta Listar Libros
        BibliV.comboLisLib.addActionListener(this);
        BibliV.buttonLisLib.addActionListener(this);
        
        //Paleta Prestar Libro
        BibliV.comboPreCed.addActionListener(this);
        BibliV.comboPreEjem.addActionListener(this);
        BibliV.comboPreLib.addActionListener(this);
        BibliV.buttonPreLib.addActionListener(this);
        
        //Paleta Entregar Libro
        BibliV.comboEntLib.addActionListener(this);
        BibliV.comboEntEjem.addActionListener(this);
        BibliV.buttonEntLib.addActionListener(this);
        
        //Paleta Estado de Libros
        BibliV.comboEstLib.addActionListener(this);
        BibliV.buttonEstLib.addActionListener(this);
        
        //Agregar datos al combobox de Libros "Prestar Libros"
        FiltroLib();
        
        //Agregar datos al combobox de Ejemplares "Prestar Libros"
        BibliV.comboPreLib.addItemListener(new ItemListener()
        {
            @Override
            public void itemStateChanged(ItemEvent e)
            {
                if(BibliV.comboPreLib.getSelectedIndex() == 0)
                {
                    BibliV.comboPreEjem.removeAllItems();
                    BibliV.comboPreEjem.addItem("Seleccione:");
                }else{
                    
                    if(BibliV.comboPreLib.getSelectedIndex() != -1)
                    {
                        BibliV.comboPreEjem.removeAllItems();
                    
                        FiltroEjem(BibliV.comboPreLib.getSelectedItem().toString());
                    }                    
                }
            }
             
        });
        
        //Agregar datos al Jtable del Libro "Prestar Libros"
        BibliV.comboPreEjem.addItemListener(new ItemListener() {

            public void itemStateChanged(ItemEvent e) {

                if (e.getStateChange() == ItemEvent.SELECTED) {
                    
                    if(BibliV.comboPreEjem.getSelectedIndex()>0)
                    {
                        String codlib = BibliV.comboPreLib.getSelectedItem().toString();
                        String codejem = BibliV.comboPreEjem.getSelectedItem().toString();
                        
                        MostrarLibro(codlib, codejem);
                    }     
                }

            }
        });
        
        //Agregar datos al combobox de Cedula "Prestar Libros"
        ComboCed();
        
        //Agregar datos al Jtable del Usuario "Prestar Libros"
        BibliV.comboPreCed.addItemListener(new ItemListener() {

            public void itemStateChanged(ItemEvent e) {

                if (e.getStateChange() == ItemEvent.SELECTED) {
                    
                    if(BibliV.comboPreCed.getSelectedIndex()>0)
                    {
                        int ced = Integer.parseInt(BibliV.comboPreCed.getSelectedItem().toString());
                               
                        MostrarUsu(ced);
                    }     
                }

            }
        });
        
        //Agregar datos al combobox de Libro "Entregar Libros"
        ComboLibEnt();
        
        //Agregar datos al Jtable del Libro "Entregar Libros"
        BibliV.comboEntLib.addItemListener(new ItemListener()
        {
            @Override
            public void itemStateChanged(ItemEvent e)
            {
                if(BibliV.comboEntLib.getSelectedIndex() == 0)
                {
                    BibliV.comboEntEjem.removeAllItems();
                    BibliV.comboEntEjem.addItem("Seleccione:");
                }else{
                    
                    if(BibliV.comboEntLib.getSelectedIndex() != -1)
                    {
                        BibliV.comboEntEjem.removeAllItems();
                        
                        ComboEjemEnt(BibliV.comboEntLib.getSelectedItem().toString());
                    }                    
                }
            }
             
        });
        //Agrega datos del usuario al Jtable de "Entregar Libro"
        BibliV.comboEntEjem.addItemListener(new ItemListener() {

            public void itemStateChanged(ItemEvent e) {

                if (e.getStateChange() == ItemEvent.SELECTED) {
                    
                    if(BibliV.comboEntEjem.getSelectedIndex()>0)
                    {
                        String cob_isbn = BibliV.comboEntLib.getSelectedItem().toString();
                        String cod_ejem = BibliV.comboEntEjem.getSelectedItem().toString();
                               
                        MostrarUsuEnt(cob_isbn, cod_ejem);
                    }     
                }

            }
        });
        
        //Digitar solo numeros
        BibliV.textCedula.addKeyListener(new KeyListener() { 
            @Override
            
              public void keyTyped(KeyEvent e) {
                char veri=e.getKeyChar();
                if(!Character.isDigit(veri) && veri !=e.VK_BACK_SPACE && veri !=e.VK_DELETE && veri!=e.VK_ENTER){
                    e.consume();
                    JOptionPane.showMessageDialog(BibliV, "Ingrese solo numeros");
                }
                
              }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {             
            }
        });
            
    }     
       
    public void FiltroLib()
    {
        List <Libro> lib = new ArrayList<Libro>();
        List <String> libaux = new ArrayList<String>();
        
        lib = LibC.LibrosDispo();
        
        boolean sw = false;
        int i,j;
        
        for(i = 0;i<lib.size();i++)
        {
            if(libaux.isEmpty())
            {
                libaux.add(lib.get(i).getCodIsbn());
            }else{
                sw=false;
                
                for(j = 0; j<libaux.size();j++)
                {
                    if(libaux.get(j).equals(lib.get(i).getCodIsbn()))
                    {
                        sw=true;
                    }
                }
                
                if(sw != true)
                {
                    libaux.add(lib.get(i).getCodIsbn());
                }
            }
        }
        
        BibliV.comboPreLib.addItem("Seleccione:");
        
        for(i = 0;i<libaux.size(); i++)
        {
            BibliV.comboPreLib.addItem(libaux.get(i));
        }
    }
    
    public void FiltroEjem(String codlib)
    {
        List <Libro> lib = new ArrayList<Libro>();
        lib = LibC.LibrosDispo();
        int i;
        
        BibliV.comboPreEjem.addItem("Seleccione:");
        for(i = 0; i<lib.size();i++)
        {
            if(codlib.equals(lib.get(i).getCodIsbn()))
            {
                BibliV.comboPreEjem.addItem(lib.get(i).getCodEjemp());
            }
        }
        
    }
    
    public void MostrarLibro(String codlib, String codejem)
    {
        List <Libro> lib = new ArrayList<Libro>();
        lib = LibC.LibrosDispo();
        
        DefaultTableModel tabLib= new DefaultTableModel();
        
        String tituLib[] = {"Nombre", "Codigo ISBN", "Codigo Ejemplar", "Categoria"};
        tabLib.setColumnIdentifiers(tituLib);
        Object filLib[] = new Object[4];
        
        for(int i = 0; i<lib.size(); i++)
        {
            if(lib.get(i).getCodIsbn().equals(codlib) && lib.get(i).getCodEjemp().equals(codejem))
            {
                filLib[0] = lib.get(i).getNombre();
                filLib[1] = lib.get(i).getCodIsbn();
                filLib[2] = lib.get(i).getCodEjemp();
                filLib[3] = lib.get(i).getCategoria();
                
                tabLib.addRow(filLib);
            }    
        }
        
        BibliV.tablePreLib.setModel(tabLib);
    }
    
    public void ComboCed()
    {
        List <Usuarios> Listusu = new ArrayList<Usuarios>();
        
        Listusu = UsuC.ListarUsuAct();
        
        int i;
        
        BibliV.comboPreCed.addItem("Seleccione:");
        for(i = 0; i<Listusu.size(); i++)
        {
            BibliV.comboPreCed.addItem(Integer.toString(Listusu.get(i).getCedula()));
        }
    }
    
    public void MostrarUsu(int ced)
    {
        List <Usuarios> listUsu = new ArrayList<Usuarios>();      
        listUsu = UsuC.ListarUsuAct();
        int i;
        
        DefaultTableModel tabUsu = new DefaultTableModel();
        String tituUsu[] = {"Cedula", "Nombre", "Fecha_Nac", "Sexo", "Tipo_Usu"};
        tabUsu.setColumnIdentifiers(tituUsu);
        Object filUsu[] = new Object[5];
        
        for (i=0; i<listUsu.size();i++)
        {
            if(ced == listUsu.get(i).getCedula())
            {
                filUsu[0] = listUsu.get(i).getCedula();
                filUsu[1] = listUsu.get(i).getNombre();
                filUsu[2] = listUsu.get(i).getFechaNac();
                filUsu[3] = listUsu.get(i).getSexo();
                filUsu[4] = listUsu.get(i).getTipoUsu();

                tabUsu.addRow(filUsu);
            } 
        }
        
        BibliV.tableVerUsu.setModel(tabUsu);
    }
    
    public void ComboLibEnt()
    {
        List <Prestamo> libpre = new ArrayList<Prestamo>();
        List <String> libpreaux = new ArrayList<String>();
        
        libpre = PreC.Registro();
        
        boolean sw = false;
        int i,j;
        
        for(i = 0;i<libpre.size();i++)
        {
            if(libpreaux.isEmpty())
            {
                libpreaux.add(libpre.get(i).getCodIsbn());
            }else{
                sw=false;
                
                for(j = 0; j<libpreaux.size();j++)
                {
                    if(libpreaux.get(j).equals(libpre.get(i).getCodIsbn()))
                    {
                        sw=true;
                    }
                }
                
                if(sw != true)
                {
                    libpreaux.add(libpre.get(i).getCodIsbn());
                }
            }
        }
        
        BibliV.comboEntLib.addItem("Seleccione:");
        
        for(i = 0;i<libpreaux.size(); i++)
        {
            BibliV.comboEntLib.addItem(libpreaux.get(i));
        }
    }
    
    public void ComboEjemEnt(String codlib)
    {
        List <Prestamo> libpre = new ArrayList<Prestamo>();
        libpre = PreC.Registro();
        int i;
        
        BibliV.comboEntEjem.addItem("Seleccione:");
        for(i = 0; i<libpre.size();i++)
        {
            if(codlib.equals(libpre.get(i).getCodIsbn()))
            {
                BibliV.comboEntEjem.addItem(libpre.get(i).getCodEjemp());
            }
        }
        
    }
    
    public void MostrarUsuEnt(String cob_isbn, String cod_ejem)
    {
        List<Libro> lib;
        List<Prestamo> pre;
        usu = new Usuarios();
        
        lib = LibC.BuscarLibro(cob_isbn, cod_ejem);
        pre = PreC.BuscarPrestamo(cob_isbn, cod_ejem);
        usu = UsuC.BuscarUsuario(pre.get(0).getCedula());
        
        DefaultTableModel tabUsuEnt = new DefaultTableModel();
        String tituUsuEnt[] = {"Nom_Libro", "Cedula", "Nombre", "Sexo", "Tipo_Usu"};
        tabUsuEnt.setColumnIdentifiers(tituUsuEnt);
        Object filUsuEnt[] = new Object[5];
        
        filUsuEnt[0] = lib.get(0).getNombre();
        filUsuEnt[1] = usu.getCedula();
        filUsuEnt[2] = usu.getNombre();
        filUsuEnt[3] = usu.getSexo();
        filUsuEnt[4] = usu.getTipoUsu();

        tabUsuEnt.addRow(filUsuEnt);

        
        BibliV.tableEntLib.setModel(tabUsuEnt);
        cedula = Integer.parseInt(tabUsuEnt.getValueAt(0, 1).toString());
    }
    
    public void EstadoLibro(int opc)
    {
        List<Libro> lib;
        List<Prestamo> pre;
        
        lib = LibC.TodosLibros();
        int i,j;
        
        DefaultTableModel tabEstLib = new DefaultTableModel();
        String tituEstLib[] = {"Nombre", "Codigo ISBN", "Codigo Ejemplar", "Categoria"};
        tabEstLib.setColumnIdentifiers(tituEstLib);
        Object filUsuEnt[] = new Object[4];
        
        if(opc == 0)
        {
            for(i = 0;i<lib.size();i++)
            {
                if(lib.get(i).getDisponibilidad().equals("true"))
                {
                    filUsuEnt[0] = lib.get(i).getNombre();
                    filUsuEnt[1] = lib.get(i).getCodIsbn();
                    filUsuEnt[2] = lib.get(i).getCodEjemp();
                    filUsuEnt[3] = lib.get(i).getCategoria();

                    tabEstLib.addRow(filUsuEnt);
                }    
            }
        }else{
            pre = PreC.Registro();
            String cod_isbn,cod_ejem;
            for(i = 0; i<lib.size();i++)
            {
                cod_isbn = lib.get(i).getCodIsbn();
                cod_ejem = lib.get(i).getCodEjemp();
                
                for(j = 0; j<pre.size(); j++)
                {
                    if(cod_isbn.equals(pre.get(j).getCodIsbn()) && cod_ejem.equals(pre.get(j).getCodEjemp()))
                    {
                        filUsuEnt[0] = lib.get(i).getNombre();
                        filUsuEnt[1] = lib.get(i).getCodIsbn();
                        filUsuEnt[2] = lib.get(i).getCodEjemp();
                        filUsuEnt[3] = lib.get(i).getCategoria();
                        
                        tabEstLib.addRow(filUsuEnt);
                    }
                }
            }
            
        }

        BibliV.tableEstLib.setModel(tabEstLib);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
       
        if(e.getSource() == BibliV.buttonAgg)
        {
            if(BibliV.textCedula.getText().isEmpty() || BibliV.textFecha.getText().isEmpty() || BibliV.textNombre.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Llene todos los campos");  
            }else{
                String sexo = (String) BibliV.comboSexo.getSelectedItem();
                String tipousu = (String) BibliV.comboTipousu.getSelectedItem();
                
                List <Usuarios> listusu = null;
                
                listusu = UsuC.BuscarUsuarioList(Integer.parseInt(BibliV.textCedula.getText()));
                
                if(!listusu.isEmpty())
                {
                    JOptionPane.showMessageDialog(null, "Esta cedula ya existe");  
                }else{
                    UsuC.aggUsuario(Integer.parseInt(BibliV.textCedula.getText()), BibliV.textNombre.getText(),
                            BibliV.textFecha.getText(), sexo, tipousu);

                    BibliV.textCedula.setText("");
                    BibliV.textNombre.setText("");
                    BibliV.textFecha.setText("");

                    //Actualice el combobox de "Activar Usuario"
                    BibliV.comboActUsu.removeAllItems();
                    List<Usuarios> listaUsu = UsuC.ListarUsuariosInac();
                    BibliV.comboActUsu.addItem("Seleccione:");
                    for (int i = 0; i < listaUsu.size(); i++) {
                        BibliV.comboActUsu.addItem(Integer.toString(listaUsu.get(i).getCedula()));
                    }

                    //Actualice el combobox de "Buscar Cedula(Modificar Usuario)"
                    BibliV.comboBusUsu.removeAllItems();
                    List<Usuarios> listUsu = UsuC.ListarTodosUsu();
                    BibliV.comboBusUsu.addItem("Seleccione:");
                    for (int i = 0; i < listUsu.size(); i++) {
                        BibliV.comboBusUsu.addItem(Integer.toString(listUsu.get(i).getCedula()));
                    }
                }
                  
            }
        }
        
        if(e.getSource() == BibliV.buttonLogin)
        {
            if(BibliV.textNomLogin.getText().isEmpty() || BibliV.textPassLogin.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Llene todos los campos"); 
                
            }else{
                
                boolean sw;
                
                sw = UsuC.DatosLogin(Integer.parseInt(BibliV.textPassLogin.getText()), BibliV.textNomLogin.getText());
                
                if(sw != true)
                {
                    JOptionPane.showMessageDialog(null, "Nombre y/o Contraseña incorrectos");  
                }else{
                    BibliV.tabbedMenu.setVisible(true);
                    BibliV.buttonCerrar.setVisible(true);
                    BibliV.labelMensaje.setVisible(false);
                    BibliV.textNomLogin.setEnabled(false);
                    BibliV.textPassLogin.setEnabled(false);
                    BibliV.buttonLogin.setEnabled(false);
                    
                    JOptionPane.showMessageDialog(null, "Sesion Iniciada");  
                }
            }
        }
        
        if(e.getSource() == BibliV.buttonCerrar)
        {
            BibliV.tabbedMenu.setVisible(false);
            BibliV.buttonCerrar.setVisible(false);
            BibliV.labelMensaje.setVisible(true);
            BibliV.textNomLogin.setEnabled(true);
            BibliV.textNomLogin.setText("");
            BibliV.textPassLogin.setEnabled(true);
            BibliV.textPassLogin.setText("");
            BibliV.buttonLogin.setEnabled(true);
            
            JOptionPane.showMessageDialog(null, "Sesion Finalizada");  
        }
        
        if(e.getSource() == BibliV.buttonAggLib)
        {
            if(BibliV.textNomLib.getText().isEmpty() || BibliV.textCodISBN.getText().isEmpty() || BibliV.textCodEjem.getText().isEmpty() ||
                    BibliV.textCateg.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Llene todos los campos");  
            }else{
                
                List <Libro> lib = null;
                
                String cod_isbn = BibliV.textCodISBN.getText();
                String cod_ejem = BibliV.textCodEjem.getText();
                
                lib = LibC.BuscarLibro(cod_isbn, cod_ejem);
                
                if(!lib.isEmpty())
                {
                   JOptionPane.showMessageDialog(null, "Este libro ya existe");   
                }else{
                    LibC.aggLibro(BibliV.textNomLib.getText(), BibliV.textCodISBN.getText(),
                            BibliV.textCodEjem.getText(), BibliV.textCateg.getText());

                    BibliV.textNomLib.setText("");
                    BibliV.textCodISBN.setText("");
                    BibliV.textCodEjem.setText("");
                    BibliV.textCateg.setText("");

                    //Actualice el combobox de libro "Prestar Libro"
                    BibliV.comboPreLib.removeAllItems();
                    FiltroLib();
                }
            }
        }
        
        if(e.getSource() == BibliV.buttonEstUsu)
        {
           DefaultTableModel tabEstUsu= new DefaultTableModel();          
           
           if(BibliV.comboEstUsu.getSelectedIndex() == 0)
           {
               tabEstUsu = UsuC.ListarEstadoUsu("true");
           }else{
               tabEstUsu = UsuC.ListarEstadoUsu("false");
           }
           
           BibliV.tableEstUsu.setModel(tabEstUsu);
           
        }
        
        if(e.getSource() == BibliV.buttonActUsu)
        {
            if(BibliV.comboActUsu.getSelectedIndex() == 0)
            {
                JOptionPane.showMessageDialog(null, "Seleccione una cedula");
                
            }else{
               
                UsuC.ActivarUsuario(Integer.parseInt(BibliV.comboActUsu.getSelectedItem().toString()));
                
                BibliV.comboActUsu.removeAllItems();
                List <Usuarios> listaUsu = UsuC.ListarUsuariosInac();
                BibliV.comboActUsu.addItem("Seleccione:");
                for(int i = 0; i<listaUsu.size(); i++)
                {
                    BibliV.comboActUsu.addItem(Integer.toString(listaUsu.get(i).getCedula()));
                }
            }
            
            //Actualice el combobox de cedula "Prestar Libro"
            BibliV.comboPreCed.removeAllItems();
            ComboCed();
        }
        
        if(e.getSource() == BibliV.buttonListUsu)
        {
            DefaultTableModel tabListUsu = new DefaultTableModel();    
            
            if(BibliV.comboListUsu.getSelectedIndex() == 1)
            {
                tabListUsu = UsuC.Listar_TipoUsu("Profesor");
            }else{
                if(BibliV.comboListUsu.getSelectedIndex() == 2)
                {
                    tabListUsu = UsuC.Listar_TipoUsu("Estudiante");
                }else{
                    tabListUsu = UsuC.Listar_TipoUsu("Todos");
                }    
            }
            
            BibliV.tableListUsu.setModel(tabListUsu);
           
        }
        
        if(e.getSource() == BibliV.buttonBusUsu)
        {
            if(BibliV.comboBusUsu.getSelectedItem() == "Seleccione:")
            {
                JOptionPane.showMessageDialog(null, "Seleccione una cedula");
            }else{
                
                usu = new Usuarios();
                int ced = Integer.parseInt(BibliV.comboBusUsu.getSelectedItem().toString());
                
                usu = UsuC.BuscarUsuario(ced);
                
                BibliV.textModNom.setText(usu.getNombre());
                BibliV.textModCed.setText(Integer.toString(usu.getCedula()));
                BibliV.textModFec.setText(usu.getFechaNac());
                
                BibliV.comboModSex.removeAllItems();
                BibliV.comboModTpUsu.removeAllItems();
                
                if(usu.getSexo().equals("Masculino"))
                {
                    BibliV.comboModSex.addItem("Masculino");
                    BibliV.comboModSex.addItem("Femenino");
                }else{
                    BibliV.comboModSex.addItem("Femenino");
                    BibliV.comboModSex.addItem("Masculino");
                }
                
                if(usu.getTipoUsu().equals("Estudiante"))
                {
                    BibliV.comboModTpUsu.addItem("Estudiante");
                    BibliV.comboModTpUsu.addItem("Profesor");
                    BibliV.comboModTpUsu.addItem("Bibliotecario");
                }else{
                    if (usu.getTipoUsu().equals("Profesor"))
                    {
                        BibliV.comboModTpUsu.addItem("Profesor");
                        BibliV.comboModTpUsu.addItem("Estudiante");
                        BibliV.comboModTpUsu.addItem("Bibliotecario");
                    }else{
                        BibliV.comboModTpUsu.addItem("Bibliotecario");
                        BibliV.comboModTpUsu.addItem("Estudiante");
                        BibliV.comboModTpUsu.addItem("Profesor");
                    }        
                }
                
                this.estado = usu.getEstado();
                this.cant_lib = usu.getCantLibrosPrest();
                
                BibliV.comboModSex.setEnabled(true);
                BibliV.comboModTpUsu.setEnabled(true);
            }
        }
        
        if(e.getSource() == BibliV.buttonModUsu)
        {
            if(BibliV.textModCed.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Realice una Busqueda");
            }else{
                
                if(BibliV.textModNom.getText().isEmpty() || BibliV.textModFec.getText().isEmpty())
                {
                    JOptionPane.showMessageDialog(null, "Llene todos los campos");
                }else{               
                    
                    UsuC.ModificarUsuario(Integer.parseInt(BibliV.textModCed.getText()),
                            BibliV.textModNom.getText(), BibliV.textModFec.getText(),
                            BibliV.comboModSex.getSelectedItem().toString(),
                            BibliV.comboModTpUsu.getSelectedItem().toString(),this.estado, this.cant_lib);
                    
                    BibliV.textModNom.setText("");
                    BibliV.textModCed.setText("");
                    BibliV.textModFec.setText("");
                    BibliV.comboModSex.removeAllItems();
                    BibliV.comboModTpUsu.removeAllItems();
                    BibliV.comboModSex.setEnabled(false);
                    BibliV.comboModTpUsu.setEnabled(false);
                }
            }
        }
        
        if(e.getSource() == BibliV.buttonLisLib)
        {
            DefaultTableModel tabListLib = new DefaultTableModel();    
            
            if(BibliV.comboLisLib.getSelectedIndex() == 0)
            {
                tabListLib = LibC.ListarLib(0);
            }else{
                tabListLib = LibC.ListarLib(1);
            }
            
            BibliV.tableLisLib.setModel(tabListLib);
        }
        
        if(e.getSource() == BibliV.buttonPreLib)
        {
            if(BibliV.comboPreLib.getSelectedIndex() ==0 || BibliV.comboPreEjem.getSelectedIndex() ==0 || BibliV.comboPreCed.getSelectedIndex() ==0)
            {
               JOptionPane.showMessageDialog(null, "Seleccione todas las listas"); 
            }else{
                
                String cod_isbn = BibliV.comboPreLib.getSelectedItem().toString();
                String cod_ejem = BibliV.comboPreEjem.getSelectedItem().toString();
                int ced = Integer.parseInt(BibliV.comboPreCed.getSelectedItem().toString());
                
                int contEjemp = LibC.VerificarEjemp(cod_isbn);
                
                if(contEjemp >= 3)
                {
                    usu = new Usuarios();
                    usu = UsuC.BuscarUsuario(ced);
                    int cant_lib = usu.getCantLibrosPrest();
                    String tip_usu = usu.getTipoUsu();

                    if (tip_usu.equals("Profesor")) {
                        if (cant_lib < 3) {
                            UsuC.SumarLibrosUsu(ced);
                            LibC.LibroNoDispo(cod_isbn, cod_ejem);
                            PreC.aggPrestamo(ced, cod_isbn, cod_ejem);
                        } else {
                            JOptionPane.showMessageDialog(null, "El Profesor " + usu.getNombre() + " ha alcanzado el limite de Libros");
                        }
                    }

                    if (tip_usu.equals("Estudiante")) {
                        if (cant_lib < 2) {
                            UsuC.SumarLibrosUsu(ced);
                            LibC.LibroNoDispo(cod_isbn, cod_ejem);
                            PreC.aggPrestamo(ced, cod_isbn, cod_ejem);
                        } else {
                            JOptionPane.showMessageDialog(null, "El Estudiante " + usu.getNombre() + " ha alcanzado el limite de Libros");
                        }
                    }

                    //Actualice el combobox de libro "Prestar Libro"
                    BibliV.comboPreLib.removeAllItems();
                    FiltroLib();
                    
                    //Actualizar el combobox de libro "Entregar Libro"
                    BibliV.comboEntLib.removeAllItems();
                    ComboLibEnt();
                }else{
                    JOptionPane.showMessageDialog(null, "Prestamo no Realizado, hay pocos ejemplares del libro"); 
                }

            }
        }
        
        if(e.getSource() == BibliV.buttonEntLib)
        {
            if(BibliV.comboEntLib.getSelectedIndex() == 0 || BibliV.comboEntEjem.getSelectedIndex() == 0)
            {
                JOptionPane.showMessageDialog(null, "Seleccione todas las listas"); 
            }else{
                
                String cod_isbn = BibliV.comboEntLib.getSelectedItem().toString();
                String cod_ejem = BibliV.comboEntEjem.getSelectedItem().toString();
                
                UsuC.RestarLibrosUsu(cedula);
                LibC.LibroSiDispo(cod_isbn, cod_ejem);
                PreC.EliminarPres(cod_isbn, cod_ejem);
                
                JOptionPane.showMessageDialog(null, "Libro Entregado"); 
                
                //Actualizar combobox de Libro "Entregar Libros"
                BibliV.comboEntLib.removeAllItems();
                ComboLibEnt();
                
                 //Actualice el combobox de libro "Prestar Libro"
                BibliV.comboPreLib.removeAllItems();
                FiltroLib();
            }
        }
        
        if(e.getSource() == BibliV.buttonEstLib)
        {
            EstadoLibro(BibliV.comboEstLib.getSelectedIndex());
        }
          
    }
    
}
