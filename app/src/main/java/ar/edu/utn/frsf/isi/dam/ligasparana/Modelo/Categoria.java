package ar.edu.utn.frsf.isi.dam.ligasparana.Modelo;


import ar.edu.utn.frsf.isi.dam.ligasparana.R;


public class Categoria {
//-------------------------------------------Variables--------------------------------------------//
    private Integer id;
    private String nombre;
    private int logotipo;

    //---------------------------------------Constructor------------------------------------------//
    public Categoria(){
    }

    public Categoria(Integer id, String nombre, int logotipo){
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
    public static final Categoria[] CATEGORIAS_MOCK= new Categoria[]{

        new Categoria(1,"Senior",R.drawable.mas34),
        new Categoria(2,"Maxi",R.drawable.mas40),
        new Categoria(3,"Super Maxi",R.drawable.mas46),
        new Categoria(4,"Master",R.drawable.mas55),
        new Categoria(5,"Super Master",R.drawable.mas55)
    };
}
