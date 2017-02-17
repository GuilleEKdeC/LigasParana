package ar.edu.utn.frsf.isi.dam.ligasparana;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import ar.edu.utn.frsf.isi.dam.ligasparana.Modelo.Equipo;
import ar.edu.utn.frsf.isi.dam.ligasparana.Modelo.Liga;


public class FragmentEquipos extends Fragment {
    ArrayList<String> listaDeEquipos;
    ListView listVw;
    View v;
    ArrayAdapter<String> adaptador;



    /*----------------CONSTRUCTOR---------------*/
    public static FragmentEquipos newInstance() {
        FragmentEquipos fragment = new FragmentEquipos();
        return fragment;
    }

    public FragmentEquipos() {
     }


    /*---------------ON CREATE---------------------*/
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.fragment_equipos, container, false);

        listVw = (ListView)v.findViewById(R.id.lv_equipos);

        listaDeEquipos = new ArrayList<String>();

        cargarListaDeEquipos();
        adaptador = new ArrayAdapter<String>(getActivity().getBaseContext(), android.R.layout.simple_list_item_1, listaDeEquipos);

        listVw.setAdapter(adaptador);

        return v;

    }
    /*---------------------------------------------------------------------------------------------*/
    private void cargarListaDeEquipos() {

        for (int i=0; i< Equipo.EQUIPOS_MOCK.length ; i++) {
            listaDeEquipos.add(Equipo.EQUIPOS_MOCK[i].getNombre());
        }
    }
}