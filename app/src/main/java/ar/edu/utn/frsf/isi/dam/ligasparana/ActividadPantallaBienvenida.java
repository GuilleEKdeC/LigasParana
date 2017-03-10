package ar.edu.utn.frsf.isi.dam.ligasparana;

import java.util.Timer;
import java.util.TimerTask;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Window;

public class ActividadPantallaBienvenida extends Activity {

    // Set de la duración de la Pantalla de Bienvenida ("splash screen")
    private static final long SPLASH_SCREEN_DELAY = 1500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set orientación vertical
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        // Ocultar Titul Bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.o_1_actividad_bienvenida);


        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                finish();
            }
        };

        // Simular el proceso de carga
        Timer timer = new Timer();
        timer.schedule(task, SPLASH_SCREEN_DELAY);
        //finish();
    }

}