package ar.edu.utn.frsf.isi.dam.ligasparana.Modelo;


public class Arbitro {
//-------------------------------------------Variables--------------------------------------------//
    private Integer id;
    private String nombre;

    //---------------------------------------Constructor------------------------------------------//
    public Arbitro(){
    }

    public Arbitro(Integer id, String nombre){
        this();
        this.id=id;
        this.nombre=nombre;
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

    /*--------------------------Vector con ARBITROS------------------------------*/
    public static final Arbitro[] ARBITROS_MOCK= new Arbitro[]{
            new Arbitro(1,"ALMADA Marcelo"),
            new Arbitro(2,"BARZOLA Jesus Maria"),
            new Arbitro(3,"CORONEL Hector"),
            new Arbitro(4,"GOMEZ Horacio"),
            new Arbitro(5,"SANCHEZ Jose"),
            new Arbitro(6,"TABORDA Rolando"),
            new Arbitro(7,"MONTERO Jose"),
            new Arbitro(8,"STEGMAN Javier"),
            new Arbitro(9,"VILLANUEVA Jose A."),
            new Arbitro(10,"ZAPATA Luis Domingo")
};


}
