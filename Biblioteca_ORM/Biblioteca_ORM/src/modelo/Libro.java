package modelo;
// Generated 13/06/2020 03:50:46 AM by Hibernate Tools 4.3.1



/**
 * Libro generated by hbm2java
 */
public class Libro  implements java.io.Serializable {


     private Integer id;
     private String nombre;
     private String codIsbn;
     private String codEjemp;
     private String categoria;
     private String disponibilidad;

    public Libro() {
    }

    public Libro(String nombre, String codIsbn, String codEjemp, String categoria, String disponibilidad) {
       this.nombre = nombre;
       this.codIsbn = codIsbn;
       this.codEjemp = codEjemp;
       this.categoria = categoria;
       this.disponibilidad = disponibilidad;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getCodIsbn() {
        return this.codIsbn;
    }
    
    public void setCodIsbn(String codIsbn) {
        this.codIsbn = codIsbn;
    }
    public String getCodEjemp() {
        return this.codEjemp;
    }
    
    public void setCodEjemp(String codEjemp) {
        this.codEjemp = codEjemp;
    }
    public String getCategoria() {
        return this.categoria;
    }
    
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    public String getDisponibilidad() {
        return this.disponibilidad;
    }
    
    public void setDisponibilidad(String disponibilidad) {
        this.disponibilidad = disponibilidad;
    }




}


