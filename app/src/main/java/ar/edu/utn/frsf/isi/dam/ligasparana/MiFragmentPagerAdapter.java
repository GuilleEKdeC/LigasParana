package ar.edu.utn.frsf.isi.dam.ligasparana;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

public class MiFragmentPagerAdapter extends FragmentPagerAdapter /*implements FragmentResultados.OnArticuloSelectedListener*/{


    final int PAGE_COUNT = 9;

    private Context c;
//    private MiFragmentPagerAdapter.OnFragmentSelectedListener listenerFragment;
    private String tabTitles[] =
            new String[] {"Novedades","Fechas","Resultados","Posiciones","Goleadores","Arbitros","Equipos","Torneos Anteriores","Contacto"};

    public MiFragmentPagerAdapter(FragmentManager fm){
        super(fm);
    }

    @Override
    public int getCount(){
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment f = null;
        switch(position) {
            case 0:
                f = FragmentNovedades.newInstance();
                break;
            case 1:
                f = FragmentFechas.newInstance();
                break;
            case 2:
                f = FragmentResultados.newInstance();
                break;
            case 3:
                f = FragmentPosiciones.newInstance();
                break;
            case 4:
                f = FragmentGoleadores.newInstance();
                break;
            case 5:
                f = FragmentArbitros.newInstance();
                break;
            case 6:
                f = FragmentEquipos.newInstance();
                break;
            case 7:
                f = FragmentTorneosAnteriores.newInstance();
                break;
            case 8:
                f = FragmentContactos.newInstance();
                break;
        }

        return f;
    }


    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position];
    }

}