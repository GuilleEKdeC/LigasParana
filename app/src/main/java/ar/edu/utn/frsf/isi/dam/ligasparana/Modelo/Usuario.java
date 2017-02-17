package ar.edu.utn.frsf.isi.dam.ligasparana.Modelo;

import android.net.Uri;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mdominguez on 22/09/16.
 */
public class Usuario implements Serializable {

    private Integer id;
    private String nombre;
    private String correo;

    private Uri Ringstone;


    /*-ACA- Constructor de un Usuario*/
    public Usuario(String nombre, String correo, Uri Ringstone){
        this.correo=correo;
        this.nombre = nombre;
        this.Ringstone = Ringstone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public Uri getRignton() {
        return Ringstone;
    }

    public void setRingstone(Uri ringstone) {
        Ringstone = ringstone;
    }

    public Uri getRingstone() {return Ringstone; }

}
