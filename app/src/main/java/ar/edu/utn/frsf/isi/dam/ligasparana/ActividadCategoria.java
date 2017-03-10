package ar.edu.utn.frsf.isi.dam.ligasparana;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;
import ar.edu.utn.frsf.isi.dam.ligasparana.Modelo.Categoria;
import ar.edu.utn.frsf.isi.dam.ligasparana.dao.ProyectoDAO;


public class ActividadCategoria extends AppCompatActivity{
    /**********************************
     * Declaración de Variables
     ************************************/
    //Se crea una objeto tipo ListView
    private ListView listVw;
    private ArrayList<Categoria> listaCategorias;
    private AdaptadorDeCategorias adaptador;
    private Context contexto;
    private Intent intentCategoria;
    private Intent intentDatosCategoria;
    private String idLiga;
    private ProyectoDAO myDao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.o_3_actividad_categ);

        // Manejo del Intent
        intentCategoria = getIntent();
        idLiga = intentCategoria.getStringExtra("idLiga");
        // Fin manejo del Intent

        contexto=getBaseContext();

        listVw = (ListView) findViewById(R.id.lista_categorias);

        listaCategorias = new ArrayList<Categoria>();

        cargarListaDeCategorias();

        //Se define un nuevo adaptador donde se le pasa como argumentos el contexto de la actividad y el arraylist de las Categorias
        adaptador = new AdaptadorDeCategorias(this, listaCategorias);

        //Se establece el adaptador en la Listview
        listVw.setAdapter(adaptador);

        //Esto es mas que nada es mas35 nivel de diseño con el objetivo de crear unas lineas mas anchas entre item y item
        listVw.setDividerHeight(3);

        Toast.makeText(this, "Seleccione su CATEGORÍA Favorita", Toast.LENGTH_LONG).show();

        /*----------------------------------------------------------------------------------------*/
        listVw.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                myDao = new ProyectoDAO(ActividadCategoria.this);
                myDao.open();
                myDao.actualizarCategoria(String.valueOf(listaCategorias.get(position).getId()));
                finish();
            }
        });
    }//Fin-On Create

    private void cargarListaDeCategorias() {

        for (int i=0; i< Categoria.CATEGORIAS_MOCK.length ; i++) {
            listaCategorias.add(Categoria.CATEGORIAS_MOCK[i]);
        }
    }
}
