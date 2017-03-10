package ar.edu.utn.frsf.isi.dam.ligasparana.Modelo;

import java.io.Serializable;

public class Usuario implements Serializable {

    private Integer id;
    private String nombre;
    private String correo;


    /*-ACA- Constructor de un Usuario*/
    public Usuario(String nombre, String correo){
        this.correo=correo;
        this.nombre = nombre;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId(){ return  id;}

    public String getNombre() {
        return nombre;
    }

    public void setNombre (String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

}
