/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Naiver Anillo
 */
public class Usuario {
    private String nom,sex;
    private int ced;
    private boolean nolib=false;

    public Usuario() {
    }

    public String getNom() {
        return nom;
    }

    public String getSex() {
        return sex;
    }

    public int getCed() {
        return ced;
    }

    public boolean isNolib() {
        return nolib;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setCed(int ced) {
        this.ced = ced;
    }

    public void setNolib(boolean nolib) {
        this.nolib = nolib;
    }

    

    
    
    
}
