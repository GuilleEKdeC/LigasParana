package ar.edu.utn.frsf.isi.dam.ligasparana;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import ar.edu.utn.frsf.isi.dam.ligasparana.dao.ProyectoDAO;

public class FragmentFechas extends Fragment {

    ArrayList<String> listaDeFechas;
    Spinner spinerVw;
    View v;
    ArrayAdapter<String> adaptador;
    String[] fechas;
    private ProyectoDAO proyectoDAO;
    private Cursor cursor;

    /*---------------------------------- CONSTRUCTOR ---------------------------------------------*/
    public static FragmentFechas newInstance() {
        FragmentFechas fragment = new FragmentFechas();
        return fragment;
    }

    /*---------------------------------- CONSTRUCTOR ---------------------------------------------*/
    public FragmentFechas() {
        // Required empty public constructor
    }

    /*------------------------------------ ON CREATE ---------------------------------------------*/
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
    }
    /*---------------------------------- on Create View ------------------------------------------*/
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.fragment_fechas, container, false);

        // Manejo del Spinner de las fechas disponibles ------------------------//
        spinerVw = (Spinner) v.findViewById(R.id.spiner_fechas);
        listaDeFechas = new ArrayList<String>();

        // manejo de sqlite para conocer las elecciones de LIGA y CATEGORÍA
        proyectoDAO = new ProyectoDAO(getActivity().getApplicationContext());
        proyectoDAO.open();
        Integer idCat = proyectoDAO.getCategoría();
Toast.makeText(getActivity().getApplicationContext(), "FRAGMENT - Id Categoría: "+idCat, Toast.LENGTH_LONG).show();
        // fin manejo sqlite
        switch (idCat){// Setea el Spinner con las fechas posibles, cargados en el recurso arrays.xml
            case 1:
                fechas = getResources().getStringArray(R.array.fechas_senior);
                break;
            case 2:
                fechas = getResources().getStringArray(R.array.fechas_maxi);
                break;
            case 3:
                fechas = getResources().getStringArray(R.array.fechas_superMaxi);
                break;
            case 4:
                fechas = getResources().getStringArray(R.array.fechas_master);
                break;
            case 5:
                fechas = getResources().getStringArray(R.array.fechas_superMaster);
                break;
        }

        adaptador = new ArrayAdapter<String>(getActivity().getBaseContext(), android.R.layout.simple_spinner_dropdown_item, fechas);
        spinerVw.setAdapter(adaptador);

        // Listener Spinner
        spinerVw.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                /*
                //Guardamos en una variable la Categoría seleccionada
                nameCategoria = (String) spinerVw.getItemAtPosition(position);
                spinerVw.clearFocus();
                categoria.setId(Categoria.CATEGORIAS_MOCK[0].getIdOf(nameCategoria));
                categoria.setDescripcion(nameCategoria);
                */
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {  }

        });// Fin Listener
        //----------------------------- Fin del Spinner -----------------------//

        return v;

    }

    /*-------------------------------------- get Adaptador ---------------------------------------*/
    public ArrayAdapter<String> getAdaptador(){
        return this.adaptador;
    }
}
/*
public class FragmentEquipos extends Fragment {
    ArrayList<String> listaDeEquipos;
    ListView listVw;
    View v;
    ArrayAdapter<String> adaptador;






    /*---------------------------------------------------------------------------------------------*/
 /*   private void cargarListaDeEquipos() {

        for (int i=0; i< Equipo.EQUIPOS_MOCK.length ; i++) {
            listaDeEquipos.add(Equipo.EQUIPOS_MOCK[i].getNombre());
        }
    }
}
 */