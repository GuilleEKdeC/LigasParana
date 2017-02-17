package ar.edu.utn.frsf.isi.dam.ligasparana.Modelo;

/**
 * Created by mdominguez on 06/10/16.
 */
public class Partido {

    //-------------------------------------------Variables--------------------------------------------//
    private Integer id;
    private Integer liga;
    private Integer categoria;
    private String equipo1;
    private String equipo2;
    private String fecha;
    private String lugar;
    private String notificar;

    //---------------------------------------Constructor------------------------------------------//
    public Partido() {
    }

    public Partido(Integer id, Integer lig, Integer cat, String e1, String e2, String f, String l, String not) {
        this();
        this.id = id;
        this.liga = lig;
        this.categoria = cat;
        this.equipo1 = e1;
        this.equipo2 = e2;
        this.fecha = f;
        this.lugar = l;
        this.notificar = not;
    }

    //---------------------------------------Gets y Sets------------------------------------------//
    public String getNotificar() {   return notificar;    }

    public void setNotificar(String notificar) {        this.notificar = notificar;    }

    public String getLugar() {        return lugar;    }

    public void setLugar(String lugar) {        this.lugar = lugar;    }

    public String getFecha() {        return fecha;    }

    public void setFecha(String fecha) {        this.fecha = fecha;    }

    public String getEquipo2() {        return equipo2;    }

    public void setEquipo2(String equipo2) {        this.equipo2 = equipo2;    }

    public String getEquipo1() {        return equipo1;    }

    public void setEquipo1(String equipo1) {        this.equipo1 = equipo1;    }

    public Integer getCategoria() {        return categoria;    }

    public void setCategoria(Integer categoria) {        this.categoria = categoria;    }

    public Integer getLiga() {        return liga;    }

    public void setLiga(Integer liga) {        this.liga = liga;    }

    public Integer getId() {        return id;    }

    public void setId(Integer id) {        this.id = id;    }
}
