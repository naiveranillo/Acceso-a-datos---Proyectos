/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author NaiAnillo
 */
public class Sede {
    private String nombre;
    private String cod;
    private String dir;
    private int numtel;
    private int cantsal;

    public Sede() {
        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public int getNumtel() {
        return numtel;
    }

    public void setNumtel(int numtel) {
        this.numtel = numtel;
    }

    public int getCantsal() {
        return cantsal;
    }

    public void setCantsal(int cantsal) {
        this.cantsal = cantsal;
    }
    
    
    
}
