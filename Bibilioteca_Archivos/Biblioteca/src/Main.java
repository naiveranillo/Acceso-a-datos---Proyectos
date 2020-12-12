/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Naiver Anillo
 */
import java.util.*;
public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BibliotecaArchivos BlibArc = new BibliotecaArchivos();
        
        int opc=0;
        String ced="",opcver="";
        boolean sw=false;
        
        do{
            System.out.println("\n[MENU]"
                    + "\n1. Crear Usuario"
                    + "\n2. Crear Libro"
                    + "\n3. Modificar Usuario"
                    + "\n4. Eliminar Usuario"
                    + "\n5. Hacer Prestamo"
                    + "\n6. Entregar Libro"
                    + "\n7. Listar Usuarios"
                    + "\n8. Listar Libros"
                    + "\n9. Listar Prestamos Activos"
                    + "\n10. Buscar Usuario"
                    + "\n11. Salir");
            opc = sc.nextInt();
            
            switch(opc)
            {
                case 1:
                    Usuario usu = new Usuario();
                    System.out.println("\n[CREAR USUARIO]");
                    do{
                        System.out.print("[CEDULA]: ");
                        usu.setCed(sc.nextInt());
                        sw = BlibArc.VerificarId(Integer.toString(usu.getCed()),opcver="1");
                    }while(sw != false);
                    System.out.print("[NOMBRE]: ");
                    usu.setNom(sc.next());
                    System.out.print("[SEXO]: ");
                    usu.setSex(sc.next());
                   
                    BlibArc.AgregarUsuario(usu);
                    
                    System.out.println("\n[Usuario Registrado]");
                    
                break;
                
                case 2:
                    Libro lib = new Libro();
                    System.out.println("\n[CREAR LIBRO]");
                    do{
                        System.out.print("[CODIGO]: ");
                        lib.setCodlib(sc.nextInt());
                        sw = BlibArc.VerificarId(Integer.toString(lib.getCodlib()),opcver="2");
                    }while(sw != false);
                    System.out.print("[NOMBRE]: ");
                    sc.nextLine();
                    lib.setNomlib(sc.nextLine());
                    System.out.print("[CATALOGO]: ");
                    lib.setCatlib(sc.next());
                    System.out.print("[NUMERO DE PAGINAS]: ");
                    lib.setNumpag(sc.nextInt());
                    System.out.print("[NUMERO DE EJEMPLARES]: ");
                    lib.setNumejemp(sc.nextInt());
                    
                    BlibArc.AgregarLibro(lib);
                    
                    System.out.println("\n[Libro Registrado]");
                break;
                
                case 3:    
                    System.out.println("\n[MODIFICAR USUARIO]");
                    System.out.print("[CEDULA]: ");
                    ced=sc.next();
                    BlibArc.Modificar(ced);
                break;
                
                case 4:
                    System.out.println("\n[ELIMINAR USUARIO]");
                    System.out.print("[CEDULA]: ");
                    ced=sc.next();   
                    BlibArc.Eliminar(ced);
                break;
                
                case 5:   
                    BlibArc.Prestamo();
                break;
                
                case 6:
                    BlibArc.Entregar();
                break;
                
                case 7:
                    System.out.println("\n[LISTAR USUARIOS]\n");
                    BlibArc.ListarUsuarios();
                break;
                
                case 8:
                    System.out.println("\n[LISTAR LIBROS]\n");
                    BlibArc.ListarLibros();
                break;
                
                case 9:
                    BlibArc.ListarPrestamo();
                break;
                
                case 10:       
                    System.out.println("\n[BUSCAR USUARIO]");
                    System.out.print("[CEDULA]: ");
                    ced=sc.next();
                    BlibArc.MostrarUsuario(ced);
                break;
                
                case 11:
                    //PARA QUE NO ACTIVE EL DEFAULT
                break;
                
                default:
                    System.out.println("\n[OPCION INVALIDA]");
            }
        }while(opc != 11);
        
    }
}
