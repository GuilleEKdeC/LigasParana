package ar.edu.utn.frsf.isi.dam.ligasparana;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.StringTokenizer;

import ar.edu.utn.frsf.isi.dam.ligasparana.Modelo.Liga;
import ar.edu.utn.frsf.isi.dam.ligasparana.dao.ProyectoDAO;
import ar.edu.utn.frsf.isi.dam.ligasparana.dao.ProyectoDBMetadata;

public class ActividadLiga extends AppCompatActivity {
    /**********************************
     * Declaración de Variables
     ************************************/
    //Se crea una objeto tipo ListView
    private ListView listVw;
    private ArrayList<Liga> listaLigas;
    private AdaptadorDeLigas adaptador;
    private Context contexto;
    private Intent intActCat;
    private ProyectoDAO myDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.o_2_actividad_ligas);
        contexto=getBaseContext();

        listVw = (ListView) findViewById(R.id.lista_ligas);

        listaLigas = new ArrayList<Liga>();

        cargarListaDeLigas();

        //Se define un nuevo adaptador de tipo AdaptadorOfLaboral donde se le pasa como argumentos el contexto de la actividad y el arraylist de los trabajos
        adaptador = new AdaptadorDeLigas(this, listaLigas);

        //Se establece el adaptador en la Listview
        listVw.setAdapter(adaptador);

        //Esto es mas que nada es mas35 nivel de diseño con el objetivo de crear unas lineas mas anchas entre item y item
        listVw.setDividerHeight(3);

        Toast.makeText(this, "Seleccione su LIGA Favorita", Toast.LENGTH_LONG).show();

        /*----------------------------------------------------------------------------------------*/
        listVw.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                myDao = new ProyectoDAO(ActividadLiga.this);
                myDao.open();
                myDao.actualizarLiga(String.valueOf(listaLigas.get(position).getId()));
                finish();
            }
        });

    }//Fin-On Create

   /*---------------------------------------------------------------------------------------------*/
   private void cargarListaDeLigas() {

        for (int i=0; i< Liga.LIGAS_MOCK.length ; i++) {
            listaLigas.add(Liga.LIGAS_MOCK[i]);
        }
    }
}
