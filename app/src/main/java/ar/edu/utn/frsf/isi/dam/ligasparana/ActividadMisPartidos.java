package ar.edu.utn.frsf.isi.dam.ligasparana;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import ar.edu.utn.frsf.isi.dam.ligasparana.dao.ProyectoDAO;


public class ActividadMisPartidos extends AppCompatActivity {

    private ListView lvPartidos;
    private ProyectoDAO proyectoDAO;
    private Cursor cursor;
    private MisPartidosCursorAdapter adaptador_misP;

   //   definición de variables para el adaptador sutituto
   //   private ArrayList<Partido> listaPartidos;
   //   private AdaptadorSustitutoMisPartidos adaptadorSustituto;

    /*------------------------------------- ON CREATE --------------------------------------------*/
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad_mis_partidos);

    //  definición de variables para el adaptador sutituto
    //  lvPartidos = (ListView) findViewById(R.id.lista_mis_partidos); //lvPartidos es el listView que se encuentra en el content_main
    //  listaPartidos = new ArrayList<Partido>();

        lvPartidos = (ListView) findViewById(R.id.lista_mis_partidos);
     }//Fin ON CREATE

    /*-------------------------------------- On Resume -------------------------------------------*/
    protected void onResume() {
        super.onResume();

    //  manejo de sqlite
        proyectoDAO = new ProyectoDAO(ActividadMisPartidos.this);
        proyectoDAO.open();
        cursor = proyectoDAO.listaTareas();
        adaptador_misP = new MisPartidosCursorAdapter(ActividadMisPartidos.this,cursor,proyectoDAO);
        lvPartidos.setAdapter(this.adaptador_misP);
    //  fin manejo sqlite

    //  manejo adaptador sustituto
    //  llamamos a un Inicializar lista partidos que cargue cada fila del cursor dentro de cada elemento Partido
    //  inicializarListaPartidos(cursor);
    //  adaptadorSustituto= new AdaptadorSustitutoMisPartidos(this.getBaseContext(),listaPartidos );//getApplicationContext(),Arrays.asList(jobs)     //era solo this
    //  lvPartidos.setAdapter(adaptadorSustituto);

    //Esto es mas que nada es a nivel de diseño con el objetivo de crear unas lineas mas anchas entre item y item
        lvPartidos.setDividerHeight(5);
    }

    /*-------------------------------------- On Pause --------------------------------------------*/
    protected void onPause() {
        super.onPause();
        if(cursor!=null) cursor.close();
        if(proyectoDAO!=null) proyectoDAO.close();
    }
    /*--------------------------------- inicializar Lista Partidos -------------------------------*/
/*    protected void inicializarListaPartidos(Cursor c){

        cursor.moveToFirst();
        int i =0;
        do{
            Partido p = new Partido();
            p.setId(cursor.getInt(0));
            p.setLiga(cursor.getInt(1));
            p.setCategoria(cursor.getInt(2));
            p.setEquipo1(cursor.getString(3));
            p.setEquipo2(cursor.getString(4));
            p.setFecha(cursor.getString(5));
            p.setLugar(cursor.getString(6));
            p.setNotificar(cursor.getString(7));
             listaPartidos[i] = new Partido(p.getId(),p.getLiga(),p.getCategoria(),p.getEquipo1(),p.getEquipo2(),p.getFecha(),p.getLugar(),p.getNotificar());
            i++;
            listaPartidos.add(p);
        }while (cursor.moveToNext());
        cursor.close();
    }*/

}

