/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Estudiantes
 */
public class Compras {
    
    private int codcli;
    private String NomCli;
    private double monto;

    public int getCodcli() {
        return codcli;
    }
    
    public String getNomCli() {
        return NomCli;
    }

    public double getMonto() {
        return monto;
    }

    public void setCodcli(int codcli) {
        this.codcli = codcli;
    }

    
    public void setNomCli(String NomCli) {
        this.NomCli = NomCli;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    @Override
    public String toString() {
        return "\n[COMPRAS"
                + "\nCedula: " + codcli
                + "\nNombre del Cliente: " + NomCli 
                + "\nMonto: " + monto;
    }

    
    
    
}
