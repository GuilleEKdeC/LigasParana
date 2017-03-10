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

    /*------------------------------------- ON CREATE --------------------------------------------*/
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad_mis_partidos);

        lvPartidos = (ListView) findViewById(R.id.lista_mis_partidos);
     }//Fin ON CREATE

    /*-------------------------------------- On Resume -------------------------------------------*/
    protected void onResume() {
        super.onResume();

    //  manejo de sqlite
        proyectoDAO = new ProyectoDAO(ActividadMisPartidos.this);
        proyectoDAO.open();
        cursor = proyectoDAO.listaMisPartidos();
        adaptador_misP = new MisPartidosCursorAdapter(getSupportFragmentManager(),ActividadMisPartidos.this,cursor,proyectoDAO);
        lvPartidos.setAdapter(this.adaptador_misP);
    //  fin manejo sqlite
    //Esto es mas que nada es a nivel de diseño con el objetivo de crear unas lineas mas anchas entre item y item
        lvPartidos.setDividerHeight(5);
    }

    /*-------------------------------------- On Pause --------------------------------------------*/
    protected void onPause() {
        super.onPause();
        if(cursor!=null) cursor.close();
        if(proyectoDAO!=null) proyectoDAO.close();
    }
}

