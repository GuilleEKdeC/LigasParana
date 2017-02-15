package ar.edu.utn.frsf.isi.dam.ligasparana;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class FragmentNovedades extends Fragment {

    /*----------------CONSTRUCTOR---------------*/
    public static FragmentNovedades newInstance() {
        FragmentNovedades fragment = new FragmentNovedades();
        return fragment;
    }

    public FragmentNovedades() {
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
        return inflater.inflate(R.layout.fragment_novedades, container, false);
    }
}