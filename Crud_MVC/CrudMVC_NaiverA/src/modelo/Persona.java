/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Naiver Anillo
 */
public class Persona {
    public String Nombre;
    public String Sexo;
    public String cedula;
    

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getSexo() {
        return Sexo;
    }

    public void setSexo(String Sexo) {
        this.Sexo = Sexo;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
   
    public Persona(){
        Nombre="";
        Sexo="";
        cedula="";
    }
    public String toString(){
        return this.getNombre()+" - "+this.getCedula()+" - "+this.getSexo();
    }
}
