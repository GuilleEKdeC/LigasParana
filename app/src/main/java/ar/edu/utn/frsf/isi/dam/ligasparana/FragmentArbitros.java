package ar.edu.utn.frsf.isi.dam.ligasparana;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import ar.edu.utn.frsf.isi.dam.ligasparana.Modelo.Arbitro;
import ar.edu.utn.frsf.isi.dam.ligasparana.Modelo.Equipo;


public class FragmentArbitros extends Fragment {

    ArrayList<String> listaDeArbitros;
    ListView listVw;
    View v;
    ArrayAdapter<String> adaptador;

    /*----------------CONSTRUCTOR---------------*/
    public static FragmentArbitros newInstance() {
        FragmentArbitros fragment = new FragmentArbitros();
        return fragment;
    }

    public FragmentArbitros() {
        // Required empty public constructor
    }


    /*---------------ON CREATE---------------------*/
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_arbitros, container, false);

        listVw = (ListView)v.findViewById(R.id.lv_arbitros);
        listaDeArbitros = new ArrayList<String>();

        cargarListaDeArbitros();
        adaptador = new ArrayAdapter<String>(getActivity().getBaseContext(), android.R.layout.simple_list_item_1, listaDeArbitros);

        listVw.setAdapter(adaptador);

        return v;

    }
    /*---------------------------------------------------------------------------------------------*/
    private void cargarListaDeArbitros() {

        for (int i = 0; i< Arbitro.ARBITROS_MOCK.length ; i++) {
            listaDeArbitros.add(Arbitro.ARBITROS_MOCK[i].getNombre());
        }
    }

}