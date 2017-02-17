package ar.edu.utn.frsf.isi.dam.ligasparana;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

public class FragmentFechas extends Fragment {

    ArrayList<String> listaDeFechas;
    Spinner spinerVw;
    View v;
    ArrayAdapter<String> adaptador;
    String[] fechas;

    public static FragmentFechas newInstance() {
        FragmentFechas fragment = new FragmentFechas();
        return fragment;
    }

    public FragmentFechas() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_fechas, container, false);

        spinerVw = (Spinner)v.findViewById(R.id.spiner_fechas);
        listaDeFechas = new ArrayList<String>();

        // Setea el Spinner con las fechas posibles, cargados en el recurso arrays.xml
        fechas = getResources().getStringArray(R.array.fechas_maxi); //elijo las fechas de categoria maxi, por azar

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
        //-------------------------------------Fin del Spinner------------------------------------//

        return v;

    }
}