package ar.edu.utn.frsf.isi.dam.ligasparana.Modelo;


public class Equipo {
//-------------------------------------------Variables--------------------------------------------//
    private Integer id;
    private String nombre;
    private Integer id_liga ;
    private Integer id_categoria;

    //---------------------------------------Constructor------------------------------------------//
    public Equipo(){
    }

    public Equipo(Integer id, String nombre, Integer id_liga, Integer id_categoria){
        this();
        this.id=id;
        this.nombre=nombre;
        this.id_liga=id_liga;
        this.id_categoria=id_categoria;
    }
    //---------------------------------------Gets y Sets------------------------------------------//

    public Integer getId() {
        return id;
    }

    public void setId(Integer id){
        this.id=id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre=nombre;
    }

    public Integer getIdLiga() { return this.id_liga;  }

    public void setIdLiga(Integer id_liga){ this.id_liga=id_liga;  }

    public Integer getIdCategoria() { return this.id_categoria;  }

    public void setIdCategoria(Integer id_categoria){ this.id_categoria=id_categoria;  }


/*--------------------------Vector con EQUIPOS de nuestra APP------------------------------*/
    public static final Equipo[] EQUIPOS_MOCK= new Equipo[]{
            new Equipo(1,"AGRUPACION SANTOS",1,1),
            new Equipo(2,"MUTUAL CIRCULO",1,1),
            new Equipo(3,"VETERANOS ALEGRIA",1,1),
            new Equipo(4,"VETERANOS DE CULTURAL",1,1),
            new Equipo(5,"VETERANO DE LOS CEIBOS",1,1),
            new Equipo(6,"VETERANOS DE ORO VERDE",1,1),
            new Equipo(7,"VETERANOS DE PARACAO",1,1),
            new Equipo(8,"VETERANOS DE PATRONATO",1,1),
            new Equipo(9,"VETERANOS DE SAN DIEGO",1,1),
            new Equipo(10,"VETERANOS DE SEGUI",1,1),

            new Equipo(11,"AGRUPACION J W",1,2),
            new Equipo(12,"AGRUPACION LA ROCA",1,2),
            new Equipo(13,"AGRUPACION MARACANA",1,2),
            new Equipo(14,"AGRUPACION SENIORS",1,2),
            new Equipo(15,"VETERANOS DE MAIPU",1,2),
            new Equipo(16,"VETERANOS DE ORO VERDE",1,2),
            new Equipo(17,"VETERANOS DE PATRONATO",1,2),
            new Equipo(18,"VETERANOS DE SAN CAYETANO",1,2),
            new Equipo(19,"VETERANOS DE SEGUI",1,2),
            new Equipo(20,"VETERANOS DE TIRUO FEDERAL",1,2),

            new Equipo(21,"VETERANOS LOS AMIGOS",1,3),
            new Equipo(22,"MUTUAL CASINO",1,3),
            new Equipo(23,"VETERANOS DE ALEGRIA",1,3),
            new Equipo(24,"VETERANOS DE ATRAA III",1,3),
            new Equipo(25,"VETERANOS DE B. GRANDE",1,3),
            new Equipo(26,"VETERANOS DE C.A.T.SA",1,3),
            new Equipo(27,"VETERANOS DE CERRITO",1,3),
            new Equipo(28,"VETERANOS DE CULTURAL",1,3),
            new Equipo(29,"VETERANOS DE LOS CEIBOS",1,3),
            new Equipo(30,"VETERANOS DE MAIPU",1,3),
            new Equipo(31,"VETERANOS DE PARACAO",1,3),
            new Equipo(32,"VETERANOS DE PARANA",1,3),
            new Equipo(33,"VETERANOS DE SAN DIEGO",1,3),
            new Equipo(34,"VETERANOS UNIDOS",1,3),

            new Equipo(35,"AGRUPACION LA ROCA",1,4),
            new Equipo(36,"VETERANOS ALEGRIA",1,4),
            new Equipo(37,"VETERANOS AMISTAD",1,4),
            new Equipo(38,"VETERANOS DE LA SALLE",1,4),
            new Equipo(39,"VETERANOS DE LOS AROMOS",1,4),
            new Equipo(40,"VETERANOS DE LOS CEIBOS",1,4),
            new Equipo(41,"VETERANOS DE MAIPU",1,4),
            new Equipo(42,"VETERANOS DE ORO VERDE",1,4),
            new Equipo(43,"VETERANOS DE PARANA",1,4),
            new Equipo(44,"VETERANOS DE PATRONATO",1,4),
            new Equipo(45,"VETERANOS DE SAN BENITO",1,4),
            new Equipo(46,"VETERANOS DE TIRUO FEDERAL",1,4),

            new Equipo(47,"VETERANOS DE ATRAA III",1,5),
            new Equipo(48,"VETERANOS DE B. GRANDE",1,5),
            new Equipo(49,"VETERANOS DE C.A.T.SA",1,5),
            new Equipo(50,"VETERANOS DE CERRITO",1,5),
            new Equipo(51,"VETERANOS DE LOS AROMOS",1,5),
            new Equipo(52,"VETERANOS DE PARACAO",1,5),
            new Equipo(53,"VETERANOS DE SAN DIEGO",1,5),
            new Equipo(54,"VETERANOS DE SAN MARTIN",1,5),
            new Equipo(55,"VETERANOS DE UNIVERSITARIO",1,5),
            new Equipo(56,"VETERANOS UNIDOS",1,5)
};


}
