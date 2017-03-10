package ar.edu.utn.frsf.isi.dam.ligasparana.Modelo;


import ar.edu.utn.frsf.isi.dam.ligasparana.R;


public class Liga {
//-------------------------------------------Variables--------------------------------------------//
    private Integer id;
    private String nombre;
    private int logotipo;

    //---------------------------------------Constructor------------------------------------------//
    public Liga(){
    }

    public Liga(Integer id, String nombre, int logotipo){
        this();
        this.id=id;
        this.nombre=nombre;
        this.logotipo=logotipo;
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

    public int getImagenLogo() { return logotipo;  }

    public void setImagenLogo(int logotipo){ this.logotipo=logotipo;  }


/*--------------------------Vector con las ligas de nuestra APP------------------------------*/
    public static final Liga[] LIGAS_MOCK= new Liga[]{
            new Liga(1,"Liga de Veteranos de Paraná",R.drawable.logoliga1),
            new Liga(2,"Liga Amistad",R.drawable.logoliga2),
            new Liga(3,"Liga del Parque",R.drawable.logoliga3),
            new Liga(4,"Club InterProfesional",R.drawable.logoliga4),
            new Liga(5,"Ceberpa",R.drawable.logoliga5),
            new Liga(6,"Liga Alto del Paracao",R.drawable.logoliga6),
            new Liga(7,"Liga Río Paraná",R.drawable.logoliga7),
            new Liga(8,"Quinta Quinodoz",R.drawable.logoliga8),
            new Liga(9,"Liga La Redonda",R.drawable.logoliga9),
            new Liga(10,"Liga La Vuelta",R.drawable.logoliga10)
    };


}
