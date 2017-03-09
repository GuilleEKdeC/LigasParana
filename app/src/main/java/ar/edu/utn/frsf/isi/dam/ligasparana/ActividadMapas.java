package ar.edu.utn.frsf.isi.dam.ligasparana;

import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class ActividadMapas extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mapa;
    private Intent intent_mapa;
    double latitud;
    double longitud;
    String titulo;
    String direccion;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad_mapa);
        Toast.makeText(this, "En MAPA!!!", Toast.LENGTH_SHORT).show();
        SupportMapFragment mapFragment = (SupportMapFragment)
                getSupportFragmentManager()
                        .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        intent_mapa = getIntent();
        intent_mapa.getDoubleExtra("Latitud",latitud);
        intent_mapa.getDoubleExtra("Longitud",longitud);
        titulo = intent_mapa.getStringExtra("Título");
        direccion = intent_mapa.getStringExtra("Dirección");


  /*      latitud = -31.742945;
        longitud = -60.508737;
        titulo = "Patronato";
        direccion = "Padre Bartolomé Grella 874, Paraná";*/
    }


//    @Override
    public void onMapReady(GoogleMap map) {
        mapa = map;

        moverA(latitud,longitud,titulo,direccion);  //En un futuro se usara esta funcion, para localizar las distintas ligas. HOY tenemos solo una.

        mapa.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        mapa.getUiSettings().setZoomControlsEnabled(true);


        mapa.getUiSettings().setMapToolbarEnabled(false);
//Evento click en el marcador
        /*
        mapa.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                Toast.makeText(
                        MainActivity.this,
                        "Marcador pulsado:\n" +
                                marker.getTitle(),
                        Toast.LENGTH_SHORT).show();

                return true;
            }
        });
        */


    }

    private void moverA(double Lat, double Lng, String titulo, String dir)
    {
        LatLng latlng = new LatLng(Lat,Lng);

        CameraPosition camPos = new CameraPosition.Builder()
                .target(latlng)   //Centramos el mapa en Madrid
                .zoom(17)         //Establecemos el zoom en 17
               // .bearing(0)      //Establecemos la orientación con el noreste arriba
                //.tilt(0)         //Bajamos el punto de vista de la cámara 70 grados
                .build();

        CameraUpdate camUpd3 =
                CameraUpdateFactory.newCameraPosition(camPos);

        mapa.animateCamera(camUpd3);
        mapa.addMarker(new MarkerOptions()
                .position(new LatLng(Lat,Lng))
                .title(titulo)
                .snippet(dir));
    }
}
