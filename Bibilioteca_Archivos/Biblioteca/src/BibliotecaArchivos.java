/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Naiver Anillo
 */
import java.io.*;
import java.util.*;
public class BibliotecaArchivos {
    
    Scanner sc = new Scanner(System.in);
    File usu = new File("Usuario.txt");
    File lib = new File("Libro.txt");
    File pres = new File("Prestamo.txt");
    File newArc = new File("newArchivo.txt");
    
    BufferedWriter BW;
    BufferedReader BR;
    
    public BibliotecaArchivos(){
        
    }
    
    public void AgregarUsuario (Usuario usuario)  //AGREGAR USUARIO
    {
        try{
            BW = new BufferedWriter(new FileWriter(usu,true));
            BW.write(usuario.getCed()+";"+
                     usuario.getNom()+";"+
                     usuario.getSex()+";"+
                     usuario.isNolib()+";"+
                     "\r\n");
            BW.close();
        }catch(Exception e){
            e.printStackTrace();;
        }
    }
    
    public void AgregarLibro (Libro libro) //AGREGAR LIBRO
    {
        try{
            BW = new BufferedWriter(new FileWriter(lib,true));
            BW.write(libro.getCodlib()+";"+
                     libro.getNomlib()+";"+
                     libro.getCatlib()+";"+
                     libro.getNumpag()+";"+
                     libro.getNumejemp()+";"+
                     "\r\n");
            BW.close();
        }catch(Exception e){
            e.printStackTrace();;
        }
    }
    
    public void AgregarPrestamo (Prestamo prestamo) //AGREGAR PRESTAMO
    {
        try{
            BW = new BufferedWriter(new FileWriter(pres,true));
            BW.write(prestamo.getIdpre()+";"+
                     prestamo.getCedusup()+";"+
                     prestamo.getNomusup()+";"+
                     prestamo.getIdlibp()+";"+
                     prestamo.getNomlibp()+";"+
                     prestamo.getCantlib()+";"+
                     "\r\n");
            BW.close();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public String SearchUsu (String id) //BUSQUEDA DE USUARIOS
    {
        String lines="";
        boolean sw = true;
        if(usu.exists()){
            try{
                BR=new BufferedReader(new FileReader(usu));
                String linea;
                while(( linea = BR.readLine())!=null && sw){
                    int i=0;
                    String ide="";
                    while(!linea.substring(i, i+1).equals(";")){
                        ide=ide+linea.substring(i, i+1);
                        i++;
                    }
                    if(ide.equals(id)){
                        lines=linea;
                        sw=false;
                    }
                }
                BR.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            System.out.print("\n[NO HAY USUARIOS]");
        }
        return lines;
    }
    
    public String SearchLib (String cod) //BUSQUEDA DE LIBROS
    {
        String lines="";
        boolean sw = true;
        if(lib.exists()){
            try{
                BR=new BufferedReader(new FileReader(lib));
                String linea;
                while(( linea = BR.readLine())!=null && sw){
                    int i=0;
                    String ide="";
                    while(!linea.substring(i, i+1).equals(";")){
                        ide=ide+linea.substring(i, i+1);
                        i++;
                    }
                    if(ide.equals(cod)){
                        lines=linea;
                        sw=false;
                    }
                }
                BR.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            System.out.print("\n[NO HAY LIBROS]");
        }
        return lines;
    }
    
    public String SearchPrestamo (String cod) //BUSQUEDA DE PRESTAMOS
    {
        String lines="";
        boolean sw = true;
        if(pres.exists()){
            try{
                BR=new BufferedReader(new FileReader(pres));
                String linea;
                while(( linea = BR.readLine())!=null && sw){
                    int i=0;
                    String ide="";
                    while(!linea.substring(i, i+1).equals(";")){
                        ide=ide+linea.substring(i, i+1);
                        i++;
                    }
                    if(ide.equals(cod)){
                        lines=linea;
                        sw=false;
                    }
                }
                BR.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            System.out.print("\n[NO HAY PRESTAMOS]");
        }
        return lines;
    }
    
    public boolean VerificarId (String id, String opc) //VERIFICAR CODIGO O CEDULA
    {
        boolean sw = true,ver = false;
        
        if(opc.equals("1"))
        {
            if(usu.exists()){
                try{
                    BR=new BufferedReader(new FileReader(usu));
                    String linea;
                    while(( linea = BR.readLine())!=null && sw){
                        int i=0;
                        String ide="";
                        while(!linea.substring(i, i+1).equals(";")){
                            ide=ide+linea.substring(i, i+1);
                            i++;
                        }
                        if(ide.equals(id)){
                            ver=true;
                            sw=false;
                            System.out.println("\n[CEDULA REPETIDA, INTENTELO DE NUEVO]");
                        }
                    }
                    BR.close();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }else{
            if(opc.equals("2"))
            {
                if(lib.exists()){
                    try{
                        BR=new BufferedReader(new FileReader(lib));
                        String linea;
                        while(( linea = BR.readLine())!=null && sw){
                            int i=0;
                            String ide="";
                            while(!linea.substring(i, i+1).equals(";")){
                                ide=ide+linea.substring(i, i+1);
                                i++;
                            }
                            if(ide.equals(id)){
                                ver=true;
                                sw=false;
                                System.out.println("\n[CODIGO REPETIDO, INTENTELO DE NUEVO]");
                            }
                        }
                        BR.close();
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                }
            }else{
                if(pres.exists()){
                    try{
                        BR=new BufferedReader(new FileReader(pres));
                        String linea;
                        while(( linea = BR.readLine())!=null && sw){
                            int i=0;
                            String ide="";
                            while(!linea.substring(i, i+1).equals(";")){
                                ide=ide+linea.substring(i, i+1);
                                i++;
                            }
                            if(ide.equals(id)){
                                ver=true;
                                sw=false;
                                System.out.println("\n[CODIGO REPETIDO, INTENTELO DE NUEVO]");
                            }
                        }
                        BR.close();
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                }
            }   
        }
        
     
        return ver;
    }
    
    public void Modificar(String ced)  //MODIFICAR USUARIO
    {
        int i;
        String sw;
        String lines = SearchUsu(ced);
        if(lines.equals("")){
            System.out.println("\n[EL REGISTRO NO FUE ENCONTRADO]");
        }else{
            String [] dato = lines.split(";");
            System.out.println("\n[REGISTRO ENCONTRADO]");
            System.out.println("[CEDULA]: "+dato[0]+
                               "\n[NOMBRE]: "+dato[1]+
                               "\n[SEXO]: "+dato[2]);
            System.out.print("Desea modificar el registro SI(1) NO(2): ");
            i= sc.nextInt();
            if(i==1){
                String nombre, sex;
                System.out.print("\n[NOMBRE]: ");
                nombre = sc.next();
                System.out.print("[SEXO]: ");
                sex = sc.next();
                sw=dato[3];
                if(usu.exists()){
                    try{
                        BR=new BufferedReader(new FileReader(usu));
                        BW = new BufferedWriter(new FileWriter(newArc,true));
                        String line;
                        while(( line = BR.readLine())!=null){
                            if(!lines.equals(line)){
                               BW.write(line+"\r\n");
                            }else{
                               BW.write(ced+";"+
                                            nombre+";"+
                                            sex+";"+
                                            sw+";"+
                                            "\r\n");
                            }
                        }
                        BW.close();
                        BR.close();
                        usu.delete();
                        newArc.renameTo(usu);
                        
                        System.out.println("\n[USUARIO MODIFICADO]");
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                }else{
                    System.out.print("[EL ARCHIVO NO HA SIDO CREADO]");
                }
            }
            
        }
    }
    
    public void ModificarLibro (String linealib, String opc, Prestamo prest) //MODIFICAR LIBRO, PARA RESTARLE LOS NUMEROS EJEMPLARES
    {
        int numejem, aux;
        String [] datolib = linealib.split(";");
        numejem = Integer.parseInt(datolib[4]);
        aux = Integer.parseInt(prest.getCantlib());
        try{
            BR=new BufferedReader(new FileReader(lib));
            BW = new BufferedWriter(new FileWriter(newArc,true));
            String line;
            while(( line = BR.readLine())!=null){
                if(!linealib.equals(line)){
                    BW.write(line+"\r\n");
                }else{
                    if(opc.equals("1"))
                    {
                        BW.write(datolib[0]+";"+
                             datolib[1]+";"+
                             datolib[2]+";"+
                             datolib[3]+";"+
                             (numejem-aux)+";"+
                             "\r\n");
                    }else{
                        BW.write(datolib[0]+";"+
                             datolib[1]+";"+
                             datolib[2]+";"+
                             datolib[3]+";"+
                             (numejem+aux)+";"+
                             "\r\n");
                    }      
                }
            }
            BW.close();
            BR.close();
            lib.delete();
            newArc.renameTo(lib);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void ModificarUsuario (String lineausu) //MODIFICAR USUARIO, PARA CAMBIARLE LA VARIABLE BOOLEANA DE FALSE A TRUE
    {
        String aux="true";
        String [] datolib = lineausu.split(";");
                
        try{
            BR=new BufferedReader(new FileReader(usu));
            BW = new BufferedWriter(new FileWriter(newArc,true));
            String line;
            while(( line = BR.readLine())!=null){
                if(!lineausu.equals(line)){
                    BW.write(line+"\r\n");
                }else{
                    BW.write(datolib[0]+";"+
                             datolib[1]+";"+
                             datolib[2]+";"+
                             aux+";"+
                             "\r\n");
                }
            }
            BW.close();
            BR.close();
            usu.delete();
            newArc.renameTo(usu);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void Eliminar (String ced) //ELIMINAR USUARIO
    {
        int i;
        String lines = SearchUsu(ced);
        if(lines.equals("")){
            System.out.println("[EL REGISTRO NO FUE ENCONTRADO]");
        }else{
            String [] dato = lines.split(";");

            System.out.println("\n[REGISTRO ENCONTRADO]");
            System.out.println("[CEDULA]: "+dato[0]+
                               "\n[NOMBRE]: "+dato[1]+
                               "\n[SEXO]: "+dato[2]);
            
            if(dato[3].equals("true"))
            {
                System.out.println("\n[NO SE PUEDE ELIMINAR ESTE USUARIO. ESTE USUARIO HIZO UN PRESTAMO]");
            }else{
                System.out.print("Desea eliminar el registro SI(1) NO(2): ");
                i= sc.nextInt();
                if(i==1){
                    if(usu.exists()){
                        try{
                            BR = new BufferedReader(new FileReader(usu));
                            BW = new BufferedWriter(new FileWriter(newArc,true));
                            String line;
                            while(( line = BR.readLine())!=null){
                                if(!lines.equals(line)){
                                    BW.write(line+"\r\n");
                                }
                            }
                            BW.close();
                            BR.close();
                            usu.delete();
                            newArc.renameTo(usu);
                        
                            System.out.println("\n[USUARIO ELIMINADO]");
                        }catch(Exception e){
                            e.printStackTrace();
                        }
                    }else{
                        System.err.println("\n[EL ARCHIVO NO HA SIDO CREADO]");
                    }   
                }
            }
             
        }
    }
    
    public void EliminarPrestamo (String cod) //ELIMINAR PRESTAMO
    {
        String opc="2", linealib;
        String lines = SearchPrestamo(cod);
        if(lines.equals("")){
            System.out.println("[EL REGISTRO NO FUE ENCONTRADO]");
        }else{
            if(pres.exists()){
                
                try{
                    BR = new BufferedReader(new FileReader(pres));
                    BW = new BufferedWriter(new FileWriter(newArc,true));
                    String line;
                    while(( line = BR.readLine())!=null){
                        if(!lines.equals(line)){
                            BW.write(line+"\r\n");
                        }
                    }
                    BW.close();
                    BR.close();
                    pres.delete();
                    newArc.renameTo(pres);
                    
                    String [] datopres = lines.split(";");
                    Prestamo prest = new Prestamo();
                    prest.setCantlib(datopres[5]);
                    linealib = SearchLib(datopres[3]);
                    ModificarLibro(linealib,opc,prest);
                    System.out.println("\n[CAMBIOS REGISTRADOS]");
                }catch(Exception e){
                    e.printStackTrace();
                }
            }else{
                System.err.println("\n[EL ARCHIVO NO HA SIDO CREADO]");
         }        
        }
    }
    
    public void ListarUsuarios ()  //LISTAR USUARIOS
    {
        if(!usu.exists())
        {
            System.out.println("[NO HAY USUARIOS]");
        }else{
            try{
                BR = new BufferedReader(new FileReader(usu));
                String linea;
                
                while((linea = BR.readLine()) != null)
                {
                    String [] dato = linea.split(";");
                    System.out.println("\n[USUARIO]");
                    System.out.println("[CEDULA]: "+dato[0]+
                                       "\n[NOMBRE]: "+dato[1]+
                                       "\n[SEXO]: "+dato[2]);
                    System.out.println("--------------------------");
                }
                
                BR.close();
            }catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }
    
    public void ListarLibros ()  //LISTAR LIBROS
    {
        if(!lib.exists())
        {
            System.out.println("[NO HAY LIBROS]");
        }else{
            try{
                BR = new BufferedReader(new FileReader(lib));
                String linea;
                
               while ((linea = BR.readLine()) != null)
               {
                   String [] dato = linea.split(";");
                   System.out.println("\n[LIBRO]");
                   System.out.println("[CODIGO]: "+dato[0]+
                                      "\n[NOMBRE]: "+dato[1]+
                                      "\n[CATALOGO]: "+dato[2]+
                                      "\n[NUMERO DE PAGINAS]: "+dato[3]+
                                      "\n[NUMERO DE EJEMPLARES]: "+dato[4]);
                   System.out.println("----------------------------------");
               }
               BR.close();
            }catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }
    
    public void ListarPrestamo ()  //LISTAR PRESTAMOS
    {
        if(!pres.exists())
        {
            System.out.println("\n[El ARCHIVO NO SE HA CREADO / NO HAY PRESTAMOS]");
        }else{
            try{
                BR = new BufferedReader(new FileReader(pres));
                String linea;
                
               while ((linea = BR.readLine()) != null)
               {
                   String [] dato = linea.split(";");
                   System.out.println("\n[PRESTAMO]");
                   System.out.println("[CODIGO]: "+dato[0]+
                                      "\n[CEDULA DEL USUARIO]: "+dato[1]+
                                      "\n[NOMBRE DEL USUARIO]: "+dato[2]+
                                      "\n[CODIGO DEL LIBRO]: "+dato[3]+
                                      "\n[NOMBRE DEL LIBRO]: "+dato[4]+
                                      "\n[CANTIDAD DE LIBROS]: "+dato[5]);
                   System.out.println("----------------------------------");
               }
               BR.close();
            }catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }
    
    public void MostrarUsuario (String ced) //MOSTRAR EL USUARIO BUSCADO
    {
        if(!usu.exists())
        {
            System.out.println("\n[NO HAY USUARIOS]");
        }else{
            try{
                String linea = SearchUsu(ced);
                BR = new BufferedReader (new FileReader(usu));
                if(linea.equals(""))
                {
                    System.out.println("[EL REGISTRO NO FUE ENCONTRADO]");
                }else{
                    String line;
                    boolean sw=false;
                    while((line = BR.readLine()) != null && !sw)
                    {
                        if(line.equals(linea))
                        {
                            String [] dato = linea.split(";");
                            System.out.println("\n[REGISTRO ENCONTRADO]");
                            System.out.println("[CEDULA]: "+dato[0]+
                                               "\n[NOMBRE]: "+dato[1]+
                                               "\n[SEXO]: "+dato[2]);
                            sw=true;
                        }
                    }
                    BR.close();
                }
            }catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }
    
    public void Prestamo () //REALIZAR PRESTAMO
    {
        String ced,cod,lineausu,linealib,opc,opcver;  
        boolean sw=false;
        System.out.println("\n[REALIZAR PRESTAMO]");
        System.out.print("[CEDULA]: ");
        ced=sc.next();
        lineausu=SearchUsu(ced);
        if(lineausu.equals(""))
        {
            System.out.println("[EL REGISTRO NO FUE ENCONTRADO]");
        }else{
            String [] datousu = lineausu.split(";");
            System.out.println("\n[USUARIO]");
            System.out.println("[CEDULA]: "+datousu[0]+
                               "\n[NOMBRE]: "+datousu[1]+
                               "\n[SEXO]: "+datousu[2]);
            
            System.out.print("\n[CODIGO DEL LIBRO]: ");
            cod=sc.next();
            linealib=SearchLib(cod);
            
            if(linealib.equals(""))
            {
                System.out.println("\n[EL LIBRO NO FUE ENCONTRADO]");
            }else{
                
                String [] datolib = linealib.split(";");
                
                System.out.println("\n[LIBRO]");
                System.out.println("[CODIGO]: "+datolib[0]+
                                   "\n[NOMBRE]: "+datolib[1]+
                                   "\n[CATALOGO]: "+datolib[2]+
                                   "\n[NUMERO DE PAGINAS]: "+datolib[3]+
                                   "\n[NUMERO DE EJEMPLARES]: "+datolib[4]);   
                
                int aux = Integer.parseInt(datolib[4]);
                
                if(aux == 1)
                {
                    System.out.println("\n[SOLO HAY UN EJEMPLAR. PRESTAMO CANCELADO]");
                }else{
                    Prestamo pres = new Prestamo();                 
                    
                    do{
                        System.out.print("\n[CODIGO DEL PRESTAMO]: ");
                        pres.setIdpre(sc.next());
                        sw = VerificarId(pres.getIdpre(),opcver="3");
                    }while(sw != false);
                    
                    pres.setCedusup(datousu[0]);
                    pres.setNomusup(datousu[1]);
                    pres.setIdlibp(datolib[0]);
                    pres.setNomlibp(datolib[1]);
                    opc="1";
                    System.out.print("\n[CANTIDAD DEL LIBRO]: ");
                    pres.setCantlib(sc.next());

                    AgregarPrestamo(pres);
                    ModificarLibro(linealib,opc,pres);
                    if (datousu[3].equals("false"))
                    {
                        ModificarUsuario (lineausu);
                    }   
                }
                
            }
            
        }
    }
    
    public void Entregar () //ENTREGA
    {
        String cod;
        System.out.println("\n[ENTREGA]");
        System.out.print("[CODIGO DEL PRESTAMO]: ");
        cod=sc.next();
        EliminarPrestamo(cod);
 
        
    }
    
}
