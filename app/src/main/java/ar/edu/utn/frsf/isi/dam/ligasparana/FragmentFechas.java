package ar.edu.utn.frsf.isi.dam.ligasparana;

import android.app.PendingIntent;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.StringTokenizer;

import ar.edu.utn.frsf.isi.dam.ligasparana.Modelo.Equipo;
import ar.edu.utn.frsf.isi.dam.ligasparana.Modelo.Partido;
import ar.edu.utn.frsf.isi.dam.ligasparana.dao.ProyectoDAO;

public class FragmentFechas extends Fragment {

    ArrayList<Partido> listaDePartidos;
    Spinner spinerVw;
    View v;
    AdaptadorPartidos adaptadorPartidos;
    ArrayAdapter<String> adaptadorFechas;
    String[] fechas;
    ListView listVw;
    ProyectoDAO proyectoDAO;
    private Button bt_f1;
    private Button bt_f2;
    private Button bt_f3;
    private Button bt_f4;
    private Button bt_f5;
    private Button bt_f6;
    private Button bt_f7;
    private Button bt_f8;
    private Button bt_f9;
    private Button bt_f10;
    private Button bt_f11;
    private Button bt_f12;
    private TextView fecha;

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

        // manejo de sqlite para conocer las elecciones de LIGA y CATEGORÍA
/*        proyectoDAO = new ProyectoDAO(getActivity().getApplicationContext());
        proyectoDAO.open();
        Integer idCat = proyectoDAO.getCategoría();
*/
        listVw = (ListView) v.findViewById(R.id.lv_fechas);
        listaDePartidos = new ArrayList<Partido>();

        fecha = (TextView) v.findViewById(R.id.tv_fecha_fecha);

        bt_f1 = (Button) v.findViewById(R.id.bt_fecha_fecha1);
        bt_f2 = (Button) v.findViewById(R.id.bt_fecha_fecha2);
        bt_f3 = (Button) v.findViewById(R.id.bt_fecha_fecha3);
        bt_f4 = (Button) v.findViewById(R.id.bt_fecha_fecha4);
        bt_f5 = (Button) v.findViewById(R.id.bt_fecha_fecha5);
        bt_f6 = (Button) v.findViewById(R.id.bt_fecha_fecha6);
        bt_f7 = (Button) v.findViewById(R.id.bt_fecha_fecha7);
        bt_f8 = (Button) v.findViewById(R.id.bt_fecha_fecha8);
        bt_f9 = (Button) v.findViewById(R.id.bt_fecha_fecha9);
        bt_f10 = (Button) v.findViewById(R.id.bt_fecha_fecha10);
        bt_f11 = (Button) v.findViewById(R.id.bt_fecha_fecha11);
        bt_f12 = (Button) v.findViewById(R.id.bt_fecha_fecha12);

        /*-----------------------------------------------*/
        bt_f1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                listaDePartidos.clear();
                cargarListaDePartidos("Fecha 1");        /* cargarListaDePartidos((String) parentView.getItemAtPosition(position));*/
                fecha.setText("'Fecha 1' - 11:03:2017");
                adaptadorPartidos = new AdaptadorPartidos(getActivity().getSupportFragmentManager(),getActivity().getBaseContext(),listaDePartidos);
                listVw.setAdapter(adaptadorPartidos);
                //Esto es mas que nada es a nivel de diseño con el objetivo de crear unas lineas mas anchas entre item y item
                listVw.setDividerHeight(5);}
        });
        /*-----------------------------------------------*/
        bt_f2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                listaDePartidos.clear();
                cargarListaDePartidos("Fecha 2");        /* cargarListaDePartidos((String) parentView.getItemAtPosition(position));*/
                fecha.setText("'Fecha 2' - 12:03:2017");
                adaptadorPartidos = new AdaptadorPartidos(getActivity().getSupportFragmentManager(),getActivity().getBaseContext(),listaDePartidos);
                listVw.setAdapter(adaptadorPartidos);
                //Esto es mas que nada es a nivel de diseño con el objetivo de crear unas lineas mas anchas entre item y item
                listVw.setDividerHeight(5);}
        });
        /*-----------------------------------------------*/
        bt_f3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                listaDePartidos.clear();
                cargarListaDePartidos("Fecha 3");        /* cargarListaDePartidos((String) parentView.getItemAtPosition(position));*/
                fecha.setText("'Fecha 3' - 18:03:2017");
                adaptadorPartidos = new AdaptadorPartidos(getActivity().getSupportFragmentManager(),getActivity().getBaseContext(),listaDePartidos);
                listVw.setAdapter(adaptadorPartidos);
                //Esto es mas que nada es a nivel de diseño con el objetivo de crear unas lineas mas anchas entre item y item
                listVw.setDividerHeight(5);}
        });
        /*-----------------------------------------------*/
        bt_f4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                listaDePartidos.clear();
                cargarListaDePartidos("Fecha 4");        /* cargarListaDePartidos((String) parentView.getItemAtPosition(position));*/
                fecha.setText("'Fecha 4' - 19:03:2017");
                adaptadorPartidos = new AdaptadorPartidos(getActivity().getSupportFragmentManager(),getActivity().getBaseContext(),listaDePartidos);
                listVw.setAdapter(adaptadorPartidos);
                //Esto es mas que nada es a nivel de diseño con el objetivo de crear unas lineas mas anchas entre item y item
                listVw.setDividerHeight(5);}
        });
        /*-----------------------------------------------*/
        bt_f5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                listaDePartidos.clear();
                cargarListaDePartidos("Fecha 5");        /* cargarListaDePartidos((String) parentView.getItemAtPosition(position));*/
                fecha.setText("'Fecha 5' - 25:03:2017");
                adaptadorPartidos = new AdaptadorPartidos(getActivity().getSupportFragmentManager(),getActivity().getBaseContext(),listaDePartidos);
                listVw.setAdapter(adaptadorPartidos);
                //Esto es mas que nada es a nivel de diseño con el objetivo de crear unas lineas mas anchas entre item y item
                listVw.setDividerHeight(5);}
        });
        /*-----------------------------------------------*/
        bt_f6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                listaDePartidos.clear();
                cargarListaDePartidos("Fecha 6");        /* cargarListaDePartidos((String) parentView.getItemAtPosition(position));*/
                fecha.setText("'Fecha 6' - 26:03:2017");
                adaptadorPartidos = new AdaptadorPartidos(getActivity().getSupportFragmentManager(),getActivity().getBaseContext(),listaDePartidos);
                listVw.setAdapter(adaptadorPartidos);
                //Esto es mas que nada es a nivel de diseño con el objetivo de crear unas lineas mas anchas entre item y item
                listVw.setDividerHeight(5);}
        });
        /*-----------------------------------------------*/
        bt_f7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                listaDePartidos.clear();
                cargarListaDePartidos("Fecha 7");        /* cargarListaDePartidos((String) parentView.getItemAtPosition(position));*/
                fecha.setText("'Fecha 7' - 01:04:2017");
                adaptadorPartidos = new AdaptadorPartidos(getActivity().getSupportFragmentManager(),getActivity().getBaseContext(),listaDePartidos);
                listVw.setAdapter(adaptadorPartidos);
                //Esto es mas que nada es a nivel de diseño con el objetivo de crear unas lineas mas anchas entre item y item
                listVw.setDividerHeight(5);}
        });
        /*-----------------------------------------------*/
        bt_f8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                listaDePartidos.clear();
                cargarListaDePartidos("Fecha 8");        /* cargarListaDePartidos((String) parentView.getItemAtPosition(position));*/
                fecha.setText("'Fecha 8' - 02:04:2017");
                adaptadorPartidos = new AdaptadorPartidos(getActivity().getSupportFragmentManager(),getActivity().getBaseContext(),listaDePartidos);
                listVw.setAdapter(adaptadorPartidos);
                //Esto es mas que nada es a nivel de diseño con el objetivo de crear unas lineas mas anchas entre item y item
                listVw.setDividerHeight(5);}
        });
        /*-----------------------------------------------*/
        bt_f9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                listaDePartidos.clear();
                cargarListaDePartidos("Fecha 9");        /* cargarListaDePartidos((String) parentView.getItemAtPosition(position));*/
                fecha.setText("'Fecha 9' - 08:04:2017");
                adaptadorPartidos = new AdaptadorPartidos(getActivity().getSupportFragmentManager(),getActivity().getBaseContext(),listaDePartidos);
                listVw.setAdapter(adaptadorPartidos);
                //Esto es mas que nada es a nivel de diseño con el objetivo de crear unas lineas mas anchas entre item y item
                listVw.setDividerHeight(5);}
        });
        /*-----------------------------------------------*/
        bt_f10.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                listaDePartidos.clear();
                cargarListaDePartidos("Fecha 10");        /* cargarListaDePartidos((String) parentView.getItemAtPosition(position));*/
                fecha.setText("'Fecha 10' - 09:04:2017");
                adaptadorPartidos = new AdaptadorPartidos(getActivity().getSupportFragmentManager(),getActivity().getBaseContext(),listaDePartidos);
                listVw.setAdapter(adaptadorPartidos);
                //Esto es mas que nada es a nivel de diseño con el objetivo de crear unas lineas mas anchas entre item y item
                listVw.setDividerHeight(5);}
        });
        /*-----------------------------------------------*/
        bt_f11.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                listaDePartidos.clear();
                cargarListaDePartidos("Fecha 11");        /* cargarListaDePartidos((String) parentView.getItemAtPosition(position));*/
                fecha.setText("'Fecha 11' - 15:04:2017");
                adaptadorPartidos = new AdaptadorPartidos(getActivity().getSupportFragmentManager(),getActivity().getBaseContext(),listaDePartidos);
                listVw.setAdapter(adaptadorPartidos);
                //Esto es mas que nada es a nivel de diseño con el objetivo de crear unas lineas mas anchas entre item y item
                listVw.setDividerHeight(5);}
        });
        /*-----------------------------------------------*/
        bt_f12.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                listaDePartidos.clear();
                cargarListaDePartidos("Fecha 12");        /* cargarListaDePartidos((String) parentView.getItemAtPosition(position));*/
                fecha.setText("'Fecha 12' - 16:04:2017");
                adaptadorPartidos = new AdaptadorPartidos(getActivity().getSupportFragmentManager(),getActivity().getBaseContext(),listaDePartidos);
                listVw.setAdapter(adaptadorPartidos);
                //Esto es mas que nada es a nivel de diseño con el objetivo de crear unas lineas mas anchas entre item y item
                listVw.setDividerHeight(5);}
        });


        // fin manejo sqlite
    /*    switch (idCat){// Setea el Spinner con las fechas posibles, cargados en el recurso arrays.xml
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

       // Manejo del Spinner de las fechas disponibles ------------------------//
        spinerVw = (Spinner) v.findViewById(R.id.sp_fechas_fechas);
        adaptadorFechas = new ArrayAdapter<String>(getActivity().getBaseContext(), android.R.layout.simple_spinner_dropdown_item, fechas);
        spinerVw.setAdapter(adaptadorFechas);

        // Listener Spinner
        spinerVw.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

             public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {

 /*             listVw = (ListView) v.findViewById(R.id.lv_fechas);
                listaDePartidos = new ArrayList<Partido>();*/
 /*             cargarListaDePartidos("FECHA 1");*/
               // cargarListaDePartidos((String) parentView.getItemAtPosition(position));
//Toast.makeText(getActivity().getApplicationContext(), "Size partidos: "+listaDePartidos.size(), Toast.LENGTH_LONG).show();
/*              adaptadorPartidos = new AdaptadorPartidos(getActivity().getBaseContext(),listaDePartidos);
                listVw.setAdapter(adaptadorPartidos);
                //Esto es mas que nada es a nivel de diseño con el objetivo de crear unas lineas mas anchas entre item y item
                listVw.setDividerHeight(5);
           }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {  }

        });*/// Fin Listener
        //----------------------------- Fin del Spinner -----------------------//

        return v;

    }

    /*---------------------------------------------------------------------------------------------*/
    private void cargarListaDePartidos(String fecha) {

        for (int i = 0; i< Partido.PARTIDOS_MOCK.length; i++) {
            if(Partido.PARTIDOS_MOCK[i].getFecha().equals(fecha)){
                listaDePartidos.add(Partido.PARTIDOS_MOCK[i]);
            }
        }
    }
}
