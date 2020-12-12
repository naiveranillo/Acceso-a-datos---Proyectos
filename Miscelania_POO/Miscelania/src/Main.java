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
    
    static Scanner sc = new Scanner(System.in);
    static ArrayList <Cliente> ListaC = new ArrayList();
    static ArrayList <String> Cantidad = new ArrayList();
    static ArrayList <Producto> ListaP = new ArrayList();
    static ArrayList <String> ListProd = new ArrayList();
    static ArrayList <Compras> ListComp = new ArrayList();
    
    
    
    public static void main(String[] args) {
        
        int opc;
        
        do{
            System.out.println("\n[MENU]"
                    + "\n1. Crear Cliente"
                    + "\n2. Crear Producto"
                    + "\n3. Hacer Compra"
                    + "\n4. Lista de Clientes"
                    + "\n5. Lista de Productos"
                    + "\n6. Lista de Compras"
                    + "\n7. Salir");
            opc=sc.nextInt();

            switch(opc)
            {
                case 1:
                    CrearCliente();
                break;

                case 2:
                    CrearProducto();
                break;

                case 3:
                    if(ListaC.isEmpty() || ListaP.isEmpty())
                    {
                        System.out.println("\n[NO HAY CLIENTES / NO HAY PRODUCTOS]");
                    }else{
                        Compra();
                    }     
                break;

                case 4:
                    if(ListaC.isEmpty())
                    {
                        System.out.println("\n[NO HAY CLIENTES]");
                    }else{
                        for (Cliente C: ListaC)
                        {
                            System.out.println(C.toString());
                        }
                    }   
                break;

                case 5:
                    if(ListaP.isEmpty())
                    {
                        System.out.println("\n[NO HAY PRODUCTOS]");
                    }else{
                        for (Producto P: ListaP)
                        {
                            System.out.println(P.toString());
                        }
                    }  
                break;

                case 6:
                    if(ListComp.isEmpty())
                    {
                        System.out.println("\n[NO HAY COMPRAS]");
                    }else{
                        for (Compras CP: ListComp)
                        {
                            System.out.println(CP.toString());
                        }
                    }
                break;

                case 7:
                    //SALIDA DEL PROGRAMA, PARA QUE NO ACTIVE EL DEFAULT
                break;

                default: 
                    System.out.println("\n[OPCION INVALIDA]");
            }
        
        }while(opc != 7);
        
        
        
    }
    
    static void CrearCliente()
    {
        Cliente cli = new Cliente();
        boolean sw = false;
  
        do
        {
            sw = false;
            System.out.println("\n[CREAR USUARIO]");
            System.out.print("Cedula: ");
            cli.setCed(sc.nextInt());  
            
            for (Cliente C: ListaC)
            {
                if(C.getCed() == cli.getCed())
                {
                    sw = true;
                    System.out.println("\n[LA CEDULA YA EXISTE, INGRESE OTRA]");
                }
            }
        }while(sw == true);
        
        System.out.print("Nombre: ");
        cli.setNom(sc.next());
        
        ListaC.add(cli);
    }
    
    static void CrearProducto()
    {
        Producto prod = new Producto();
        boolean sw = false;
        
        do{
            sw = false;
            System.out.println("\n[CREAR PRODUCTO]");
            System.out.print("Codigo: ");
            prod.setCod(sc.nextInt());
            
            for (Producto P: ListaP)
            {
                if(P.getCod() == prod.getCod())
                {
                    sw = true;
                    System.out.println("\n[EL CODIGO DEL PRODUCTO YA EXISTE, INGRESE OTRA]");
                }
            }

        }while(sw == true);
        
        System.out.print("Nombre: ");
        prod.setNom(sc.next());
        System.out.print("Precio: ");
        prod.setPrecio(sc.nextDouble());
        
        ListaP.add(prod);
    }
    
    static Cliente BuscarCliente(int ced)
    {
        Iterator It = ListaC.iterator();
        Cliente cli = new Cliente();
        boolean sw=false;
        while(It.hasNext() && !sw)
        {
            cli = (Cliente)It.next();
            
            if(cli.getCed()==ced)
            {
                sw=true;
            }
        }
        
        if(sw)
        {
            return cli;
        }else{
            return cli=null;
        }
    }
    
    
    static Producto BuscarProducto(int cod)
    {
        Iterator It = ListaP.iterator();
        Producto pro = new Producto();
        Cliente cli = new Cliente();
        boolean sw=false;
        while(It.hasNext() && !sw)
        {
            pro = (Producto)It.next();
            
            if(pro.getCod()==cod)
            {
                sw=true;
            }
        }
        
        if(sw)
        {
            return pro;
        }else{
            return pro=null;
        }
    }
    
    static void Compra()
    {
        Cliente cli = new Cliente();
        Producto pro = new Producto();
        Compras comp = new Compras();
        int cod=0, ced=0, cant=0;
        double monto=0;
        boolean sw=false,sw2=false;
        int exit=1;
        
        while (!sw)
        {
            cli = null;
            System.out.print("\nCedula del Cliente: ");
            ced=sc.nextInt();
            cli=BuscarCliente(ced);
            
            if (cli != null)
            {
                sw=true;
            }else{
                System.out.println("[CEDULA NO ENCONTRADA, INTENTELO DE NUEVO]");
            }
        }
        
        
        System.out.println("\n[INICIAR COMPRA]");
        
        while (exit != 0)
        {
            sw2=false;
            sw=false;
            while(!sw2)
            {             
                System.out.print("Codigo del Producto: ");
                cod=sc.nextInt();
                pro=BuscarProducto(cod);
                
                if(pro != null)
                {
                    sw2=true;
                }else{
                    System.out.println("\n[PRODUCTO NO ENCONTRADA, INTENTELO DE NUEVO]\n");
                }     
            }
            
            System.out.println("\nCuantas unidades desea?: ");
            cant=sc.nextInt();
            
            ListProd.add(pro.getNom());
            Listar(cant);
            
            monto=(pro.getPrecio()*cant)+monto;
            
            System.out.println("\nQuieres seguir comprando? [SI:1 | NO:0] : ");
            exit=sc.nextInt();

        }
        
        comp.setCodcli(cli.getCed());
        comp.setNomCli(cli.getNom());
        comp.setMonto(monto);
        
        ListComp.add(comp);
        
        ListProd.clear();
        Cantidad.clear();
    }
         
    static void Listar(int cant)
    {
        
        Cantidad.add(Integer.toString(cant));
        int i;
        System.out.println("\n[LISTA DE LA COMPRA]");
        for (i=0; i<ListProd.size(); i++)
        {  
            System.out.println(Cantidad.get(i)+" "+ListProd.get(i));
        }
    }
    
}
