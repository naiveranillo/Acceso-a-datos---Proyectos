/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Naiver Anillo
 */
public class Libro {
    
    private String nomlib,catlib;
    private int codlib,numpag,numejemp;

    public Libro() {
    }

    public String getNomlib() {
        return nomlib;
    }

    public int getCodlib() {
        return codlib;
    }

    public String getCatlib() {
        return catlib;
    }
  

    public int getNumpag() {
        return numpag;
    }

    public int getNumejemp() {
        return numejemp;
    }

    public void setNomlib(String nomlib) {
        this.nomlib = nomlib;
    }

    public void setCodlib(int codlib) {
        this.codlib = codlib;
    }

    public void setCatlib(String catlib) {
        this.catlib = catlib;
    }

    public void setNumpag(int numpag) {
        this.numpag = numpag;
    }

    public void setNumejemp(int numejemp) {
        this.numejemp = numejemp;
    }

    
    
    
}
