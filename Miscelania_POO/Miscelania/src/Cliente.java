/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Estudiantes
 */
public class Cliente {
    private int ced;
    private String nom;

    public int getCed() {
        return ced;
    }

    public String getNom() {
        return nom;
    }

    public void setCed(int ced) {
        this.ced = ced;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "\n[CLIENTE]" 
                + "\nCedula: " + ced 
                + "\nNombre: " + nom;
    }
    
    
}
