package ar.edu.utn.frsf.isi.dam.ligasparana;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad_mapa);
        SupportMapFragment mapFragment = (SupportMapFragment)
                getSupportFragmentManager()
                        .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap map) {
        mapa = map;
        mapa.moveCamera( CameraUpdateFactory.newLatLngZoom(new LatLng(-31.780638,-60.452317) , 14.0f) );

        //moverA(double Lat, double Lng);  //En un futuro se usara esta funcion, para localizar las distintas ligas. HOY tenemos solo una.

        mapa.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        mapa.getUiSettings().setZoomControlsEnabled(true);
        mapa.addMarker(new MarkerOptions()
                .position(new LatLng(-31.780638, -60.452317))
                .title("Liga de Veteranos")
                .snippet("Complejo O. Chapino - Av. Jorge Newbery 5000"));

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

    private void moverA(double Lat, double Lng)
    {
        LatLng latlng = new LatLng(Lat, Lng);

        CameraPosition camPos = new CameraPosition.Builder()
                .target(latlng)   //Centramos el mapa en Madrid
                .zoom(2)         //Establecemos el zoom en 19
               // .bearing(0)      //Establecemos la orientación con el noreste arriba
                //.tilt(0)         //Bajamos el punto de vista de la cámara 70 grados
                .build();

        CameraUpdate camUpd3 =
                CameraUpdateFactory.newCameraPosition(camPos);

        mapa.animateCamera(camUpd3);
    }
}
