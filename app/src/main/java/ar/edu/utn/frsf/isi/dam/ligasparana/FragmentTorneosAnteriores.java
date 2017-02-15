package ar.edu.utn.frsf.isi.dam.ligasparana;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class FragmentTorneosAnteriores extends Fragment {

    /*----------------CONSTRUCTOR---------------*/
    public static FragmentTorneosAnteriores newInstance() {
        FragmentTorneosAnteriores fragment = new FragmentTorneosAnteriores();
        return fragment;
    }

    public FragmentTorneosAnteriores() {
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
        return inflater.inflate(R.layout.fragment_torneos_anteriores, container, false);
    }
}