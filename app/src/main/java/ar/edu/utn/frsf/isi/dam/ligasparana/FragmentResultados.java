package ar.edu.utn.frsf.isi.dam.ligasparana;

import android.app.Activity;
import android.content.Context;
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

public class FragmentResultados extends Fragment {

    private Spinner spinner;
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
    View v;
    private ListView lv_resultados;

    /*--------------------------------- new Instance ---------------------------------------------*/
    public static FragmentResultados newInstance() {
        FragmentResultados fragment = new FragmentResultados();
        return fragment;
    }

    /*----------------------------------- fragments Resultados -----------------------------------*/
    public FragmentResultados() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_resultados, container, false);
        //spinerVw = (Spinner) v.findViewById(R.id.sp_resultados);

        bt_f1 = (Button) v.findViewById(R.id.bt_res_fecha1);
        bt_f2 = (Button) v.findViewById(R.id.bt_res_fecha2);
        bt_f3 = (Button) v.findViewById(R.id.bt_res_fecha3);
        bt_f4 = (Button) v.findViewById(R.id.bt_res_fecha4);
        bt_f5 = (Button) v.findViewById(R.id.bt_res_fecha5);
        bt_f6 = (Button) v.findViewById(R.id.bt_res_fecha6);
        bt_f7 = (Button) v.findViewById(R.id.bt_res_fecha7);
        bt_f8 = (Button) v.findViewById(R.id.bt_res_fecha8);
        bt_f9 = (Button) v.findViewById(R.id.bt_res_fecha9);
        bt_f10 = (Button) v.findViewById(R.id.bt_res_fecha10);
        bt_f11 = (Button) v.findViewById(R.id.bt_res_fecha11);
        bt_f12 = (Button) v.findViewById(R.id.bt_res_fecha12);

        /*-----------------------------------------------*/
        bt_f1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(getActivity().getBaseContext(), "Clickie FECHA 1", Toast.LENGTH_SHORT).show();            }
        });
        /*-----------------------------------------------*/
        bt_f2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(getActivity().getBaseContext(), "Clickie FECHA 2", Toast.LENGTH_SHORT).show();            }
        });
        /*-----------------------------------------------*/
        bt_f3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(getActivity().getBaseContext(), "Clickie FECHA 3", Toast.LENGTH_SHORT).show();            }
        });
        /*-----------------------------------------------*/
        bt_f4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(getActivity().getBaseContext(), "Clickie FECHA 4", Toast.LENGTH_SHORT).show();            }
        });
        /*-----------------------------------------------*/
        bt_f5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(getActivity().getBaseContext(), "Clickie FECHA 5", Toast.LENGTH_SHORT).show();            }
        });
        /*-----------------------------------------------*/
        bt_f6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(getActivity().getBaseContext(), "Clickie FECHA 6", Toast.LENGTH_SHORT).show();            }
        });
        /*-----------------------------------------------*/
        bt_f7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(getActivity().getBaseContext(), "Clickie FECHA 7", Toast.LENGTH_SHORT).show();            }
        });
        /*-----------------------------------------------*/
        bt_f8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(getActivity().getBaseContext(), "Clickie FECHA 8", Toast.LENGTH_SHORT).show();            }
        });
        /*-----------------------------------------------*/
        bt_f9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(getActivity().getBaseContext(), "Clickie FECHA 9", Toast.LENGTH_SHORT).show();            }
        });
        /*-----------------------------------------------*/
        bt_f10.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(getActivity().getBaseContext(), "Clickie FECHA 10", Toast.LENGTH_SHORT).show();            }
        });
        /*-----------------------------------------------*/
        bt_f11.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(getActivity().getBaseContext(), "Clickie FECHA 11", Toast.LENGTH_SHORT).show();            }
        });
        /*-----------------------------------------------*/
        bt_f12.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(getActivity().getBaseContext(), "Clickie FECHA 12", Toast.LENGTH_SHORT).show();            }
        });

        // Setea el Spinner con las fechas posibles, cargados en el recurso arrays.xml
     /* fechas = getResources().getStringArray(R.array.fechas_maxi); //elijo las fechas de categoria maxi, por azar
        adaptador = new ArrayAdapter<String>(getActivity().getBaseContext(), android.R.layout.simple_spinner_dropdown_item, fechas);
        spinerVw.setAdapter(adaptador);

        spinerVw.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
     */
        return v;

    }
}









