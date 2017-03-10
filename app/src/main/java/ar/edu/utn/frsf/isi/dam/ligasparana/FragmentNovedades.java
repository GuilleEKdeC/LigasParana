package ar.edu.utn.frsf.isi.dam.ligasparana;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class FragmentNovedades extends Fragment {
    TextView tv_cuerpo, tv_titulo;
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
        /*=========================================================================================*/
        View v = inflater.inflate(R.layout.fragment_novedades, container, false);

        //Obteniendo la instancia del TextView
        tv_titulo = (TextView)v.findViewById(R.id.tv_titulo);
        tv_cuerpo = (TextView)v.findViewById(R.id.tv_cuerpo);


        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getContext());

        tv_titulo.setText(prefs.getString("title","Noticias de la Semana"));
        tv_cuerpo.setText(prefs.getString("noticia","Actualmente no hay nuevas novedades")+". \n\n\t\t\t\t\t"+prefs.getString("usuario","Atte. la Comisión Directiva"));


        return v;
        /*=========================================================================================*/
    }
}