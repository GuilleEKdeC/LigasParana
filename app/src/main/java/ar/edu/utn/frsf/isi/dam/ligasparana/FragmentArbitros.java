package ar.edu.utn.frsf.isi.dam.ligasparana;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class FragmentArbitros extends Fragment {

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
        return inflater.inflate(R.layout.fragment_arbitros, container, false);
    }
}