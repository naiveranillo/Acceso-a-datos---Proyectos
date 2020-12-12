/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Estudiantes
 */
public class Producto {
    private int cod;
    private String nom;
    private double precio;

    public int getCod() {
        return cod;
    }

    public String getNom() {
        return nom;
    }

    public double getPrecio() {
        return precio;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "\n[PRODUCTO]" 
                + "\nCodigo: " + cod 
                + "\nNombre: " + nom 
                + "\nPrecio: " + precio;
    }
    
    
}
