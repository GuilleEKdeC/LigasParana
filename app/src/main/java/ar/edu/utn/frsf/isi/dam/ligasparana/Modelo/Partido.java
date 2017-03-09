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
    private String hora;
    private String lugar;
    private String notificar;

    //---------------------------------------Constructor------------------------------------------//
    public Partido() {
    }

    public Partido(Integer id, Integer lig, Integer cat, String e1, String e2, String f, String h, String l, String not) {
        this();
        this.id = id;
        this.liga = lig;
        this.categoria = cat;
        this.equipo1 = e1;
        this.equipo2 = e2;
        this.fecha = f;
        this.hora = h;
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

    public String getHora() {        return hora;    }

    public void setHora(String fecha) {        this.hora = hora;    }

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

   // Partido(Integer id, Integer lig, Integer cat, String e1, String e2, String f, String h, String l, String not)
    public static final Partido[] PARTIDOS_MOCK= new Partido[]{
           new Partido(1, 1, 1, "AGRUPACION SANTOS", "MUTUAL CIRCULO", "Fecha 1", "15:00", "Patronato-C1", "FALSE"),
           new Partido(2, 1, 1, "AGRUPACION SANTOS", "VETERANOS ALEGRIA", "Fecha 2", "15:00", "Patronato-C1", "FALSE"),
           new Partido(3, 1, 1, "AGRUPACION SANTOS", "VETERANOS DE CULTURAL", "Fecha 3", "15:00", "Patronato-C2", "FALSE"),
           new Partido(4, 1, 1, "AGRUPACION SANTOS", "VETERANO DE LOS CEIBOS", "Fecha 4", "15:00", "Patronato-C2", "FALSE"),
           new Partido(5, 1, 1, "AGRUPACION SANTOS", "VETERANOS DE ORO VERDE", "Fecha 5", "15:00", "Patronato-C1", "FALSE"),
           new Partido(6, 1, 1, "AGRUPACION SANTOS", "VETERANOS DE PARACAO", "Fecha 7", "15:00", "Paracao-C2", "FALSE"),
           new Partido(7, 1, 1, "AGRUPACION SANTOS", "VETERANOS DE PATRONATO", "Fecha 11", "15:00", "Paracao-C1", "FALSE"),
           new Partido(8, 1, 1, "AGRUPACION SANTOS", "VETERANOS DE SAN DIEGO", "Fecha 6", "15:00", "Paracao-C2", "FALSE"),
           new Partido(9, 1, 1, "AGRUPACION SANTOS", "VETERANOS DE SEGUI", "Fecha 10", "15:00", "Paracao-C1", "FALSE"),
           new Partido(10, 1, 1, "MUTUAL CIRCULO", "VETERANOS ALEGRIA", "Fecha 3", "16:00", "OroVerde-C1", "FALSE"),
           new Partido(11, 1, 1, "MUTUAL CIRCULO", "VETERANOS DE CULTURAL", "Fecha 2", "16:00", "OroVerde-C3", "FALSE"),
           new Partido(12, 1, 1, "MUTUAL CIRCULO", "VETERANO DE LOS CEIBOS", "Fecha 5", "16:00", "OroVerde-C2", "FALSE"),
           new Partido(13, 1, 1, "MUTUAL CIRCULO", "VETERANOS DE ORO VERDE", "Fecha 4", "16:00", "OroVerde-C2", "FALSE"),
           new Partido(14, 1, 1, "MUTUAL CIRCULO", "VETERANOS DE PARACAO", "Fecha 10", "17:00", "OroVerde-C3", "FALSE"),
           new Partido(15, 1, 1, "MUTUAL CIRCULO", "VETERANOS DE PATRONATO", "Fecha 9", "15:00", "OroVerde-C1", "FALSE"),
           new Partido(16, 1, 1, "VETERANOS ALEGRIA", "VETERANOS DE CULTURAL", "Fecha 1", "17:00", "Chapino-C1", "FALSE"),
           new Partido(17, 1, 1, "VETERANOS ALEGRIA", "VETERANO DE LOS CEIBOS", "Fecha 6", "16:00", "Chapino-C2", "FALSE"),
           new Partido(18, 1, 1, "VETERANOS ALEGRIA", "VETERANOS DE ORO VERDE", "Fecha 11", "17:00", "Chapino-C3", "FALSE"),
           new Partido(19, 1, 1, "VETERANOS ALEGRIA", "VETERANOS DE PARACAO", "Fecha 12", "17:00", "Chapino-C1", "FALSE"),
           new Partido(20, 1, 1, "VETERANOS ALEGRIA", "VETERANOS DE PATRONATO", "Fecha 5", "17:00", "Chapino-C2", "FALSE"),
           new Partido(21, 1, 1, "VETERANOS DE CULTURAL", "VETERANO DE LOS CEIBOS", "Fecha 11", "17:30", "Chapino-C3", "FALSE"),
           new Partido(22, 1, 1, "VETERANOS DE CULTURAL", "VETERANOS DE ORO VERDE", "Fecha 12", "15:00", "Paraná-C1", "FALSE"),
           new Partido(23, 1, 1, "VETERANOS DE CULTURAL", "VETERANOS DE PARACAO", "Fecha 6", "17:00", "Paraná-C1", "FALSE"),
           new Partido(24, 1, 1, "VETERANOS DE CULTURAL", "VETERANOS DE PATRONATO", "Fecha 8", "15:00", "Paraná-C2", "FALSE"),
           new Partido(25, 1, 1, "VETERANO DE LOS CEIBOS", "VETERANOS DE ORO VERDE", "Fecha 1", "16:00", "Paraná-C1", "FALSE"),
           new Partido(26, 1, 1, "VETERANO DE LOS CEIBOS", "VETERANOS DE PARACAO", "Fecha 2", "17:30", "Paraná-C2", "FALSE"),
           new Partido(27, 1, 1, "VETERANO DE LOS CEIBOS", "VETERANOS DE PATRONATO", "Fecha 7", "16:00", "BajadaG-C1", "FALSE"),
           new Partido(28, 1, 1, "VETERANOS DE ORO VERDE", "VETERANOS DE PARACAO", "Fecha 8", "16:00", "BajadaG-C2", "FALSE"),
           new Partido(29, 1, 1, "VETERANOS DE ORO VERDE", "VETERANOS DE PATRONATO", "Fecha 6", "17:30", "BajadaG-C1", "FALSE"),
           new Partido(30, 1, 1, "VETERANOS DE PARACAO", "VETERANOS DE PATRONATO", "Fecha 5", "17:30", "BajadaG-C2", "FALSE")
   };

}
