package ar.edu.utn.frsf.isi.dam.ligasparana;

import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.Projection;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class ActividadMapas extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mapa;
    Double latitud;
    Double longitud;
    String titulo;
    String direccion;
    private Button btnOpciones;
    private int mapaSeteado=0;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad_mapa);

        SupportMapFragment mapFragment = (SupportMapFragment)
                getSupportFragmentManager()
                        .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        btnOpciones = (Button)findViewById(R.id.btnOpciones);
        btnOpciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cambiarOpciones();
            }
        });
        Intent intent_mapa = getIntent();

        longitud=intent_mapa.getExtras().getDouble("Longitud");
        latitud=intent_mapa.getExtras().getDouble("Latitud");

        //Toast.makeText(this, "Long:"+longitud+" Lat:"+latitud, Toast.LENGTH_SHORT).show();

        titulo = intent_mapa.getStringExtra("Título");
        direccion = intent_mapa.getStringExtra("Dirección");
        // Fin manejo del Intent
    }


    @Override
    public void onMapReady(GoogleMap map) {
        mapa = map;
        LatLng latlng = new LatLng(longitud,latitud);
        //moverA(latitud,longitud,titulo,direccion);
        CameraUpdate camUpd1 =
                CameraUpdateFactory
                        .newLatLngZoom(latlng, 17);
        mapa.moveCamera(camUpd1);

        mapa.addMarker(new MarkerOptions()
                .position(latlng)
                .title(titulo)
                .snippet(direccion));

        mapa.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        mapa.getUiSettings().setZoomControlsEnabled(true);
        mapa.getUiSettings().setMapToolbarEnabled(false);

/*
        mapa.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            public void onMapClick(LatLng point) {
                Projection proj = mapa.getProjection();
                Point coord = proj.toScreenLocation(point);

                Toast.makeText(
                        ActividadMapas.this,
                        "Click\n" +
                                "Lat: " + point.latitude + "\n" +
                                "Lng: " + point.longitude + "\n" +
                                "X: " + coord.x + " - Y: " + coord.y,
                        Toast.LENGTH_SHORT).show();
            }
        });
   */
    }

 /*  private void moverA(Double Lat, Double Lng, String titulo, String dir) {
       LatLng latlng = new LatLng(Lat, Lng);

       CameraUpdate camUpd1 =
               CameraUpdateFactory
                       .newLatLngZoom(latlng, 17);

       mapa.addMarker(new MarkerOptions()
               .position(latlng)//new LatLng(Lat,Lng))
               .title(titulo)
               .snippet(dir));

       mapa.moveCamera(camUpd1);
   }

/*
        CameraPosition camPos = new CameraPosition.Builder()
                .target(latlng)   //Centramos el mapa en en el lugar que queremos
                .zoom(17)         //Establecemos el zoom en 17
                .build();

        CameraUpdate camUpd3 =
                CameraUpdateFactory.newCameraPosition(camPos);

        mapa.animateCamera(camUpd3);
        mapa.addMarker(new MarkerOptions()
                .position(latlng)//new LatLng(Lat,Lng))
                .title(titulo)
                .snippet(dir));
   }
 */
 private void cambiarOpciones()
 {
     if(mapaSeteado==1){
         mapa.setMapType(GoogleMap.MAP_TYPE_NORMAL);
         mapa.getUiSettings().setZoomControlsEnabled(true);
         mapaSeteado = 0;
     }
     else{
         mapa.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
         mapa.getUiSettings().setZoomControlsEnabled(true);
         mapaSeteado = 1;
     }
 }
}
