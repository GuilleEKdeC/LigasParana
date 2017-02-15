package ar.edu.utn.frsf.isi.dam.ligasparana;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import android.provider.Settings;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.Menu;


import android.widget.ListView;
import android.widget.Toast;

import ar.edu.utn.frsf.isi.dam.ligasparana.dao.ProyectoDAO;

public class ActividadPrincipal extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

   /* private Intent intentDatosCategoria;
    private String nombreLiga;
    private String nombreCategoria;*/
    private ListView lvPartidos;
    private ProyectoDAO proyectoDAO;
    private Cursor cursor;
    private MisPartidosCursorAdapter tca;

    /*------------------------------------- ON CREATE --------------------------------------------*/
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.o_4_actividad_principal);

        // Manejo del Intent
      /* intentDatosCategoria = getIntent();
        nombreLiga = intentDatosCategoria.getStringExtra("nombreLiga");
        nombreCategoria = intentDatosCategoria.getStringExtra("nombreCategoria");
        Toast.makeText(this, nombreLiga + " --- " + nombreCategoria, Toast.LENGTH_SHORT).show();*/
        // Integer id = Integer.valueOf(categoria.getStringExtra("ID_Liga"));
        // Fin manejo del Intent


        //Tabs + ViewPager
        Toolbar toolbarFrag = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbarFrag);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        //Establecer el PageAdapter del componente ViewPager
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(new MiFragmentPagerAdapter(
                getSupportFragmentManager()));

        TabLayout tabLayout = (TabLayout) findViewById(R.id.appbartabs);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        tabLayout.setupWithViewPager(viewPager);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout); //Crea una nueva variable DrawerLayout (contenedor de nuestro "contenido Principal" y de nuestro "navegador"), el activity_main.xml

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbarFrag, R.string.navigation_drawer_open, R.string.navigation_drawer_close){//Compatibiliza el Drawer Layout con la barra de acciones (Toolbar)
            /*******************Agregado*******************/
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                getSupportActionBar().setTitle("Después de cerrar el Navegador (ManiActivity)");//cambia el título mas35 la toolbar
                invalidateOptionsMenu(); //indica mas35 Android que los contenidos del menú han cambiado y que el menú debe ser redibujado. Crea una llamada al método onPrepareOptionsMenú
            }

            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getSupportActionBar().setTitle("Antes de abrir el Navegador (ManiActivity)"); //cambia el título mas35 la toolbar
                invalidateOptionsMenu(); //indica mas35 Android que los contenidos del menú han cambiado y que el menú debe ser redibujado. Crea una llamada al método onPrepareOptionsMenú
            }
            /****************Fin de Agregado****************/
        };
        //drawer.setDrawerListener(toggle); //le setea un listenner al DrawerLayout //línea ORIGINAL pero método deprecated => cambié por addDrawerListener
        drawer.addDrawerListener(toggle); //le setea un listenner al DrawerLayout   // línea AGREGADA
        toggle.syncState(); //Sirve para sincronizar el "Indicador" (las tres barritas horizontales que despliega al navegador) del Drawer Layout
        toggle.setDrawerIndicatorEnabled(true); // setea que el Indicador esté visible // línea AGREGADA

        /*Referencia al MENÚ DESLIZANTE*/
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view); //Crea una nueva variable NavigationView, tomando como referencia la definida en activity_main.xml.
        navigationView.setNavigationItemSelectedListener(this); //le setea un listener
        View header=navigationView.getHeaderView(0);

        //Crea el listView con Mis Partidos
        lvPartidos = (ListView) findViewById(R.id.lv_contenido_principal); //lvPartidos es el listView que se encuentra en el content_main
    }//Fin ON CREATE








    /*-------------------------------------- On Resume -------------------------------------------*/
  /*  protected void onResume() {
        super.onResume();
        //Toast.makeText(getBaseContext(), "OnResume...", Toast.LENGTH_SHORT).show();

        /*Seteo nuevamente los datos del usuario, por si se cambio las configuraciones*/
  /*      NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view); //Crea una nueva variable NavigationView, tomando como referencia la definida en activity_main.xml.
        navigationView.setNavigationItemSelectedListener(this); //le setea un listener
        View header=navigationView.getHeaderView(0);

  /*      // manejo de sqlite
       Log.d("TPFinal-MAIN","en onResume");
        proyectoDAO = new ProyectoDAO(ActividadPrincipal.this);
        proyectoDAO.open();
      /*   cursor = proyectoDAO.listaTareas(1);
        Log.d("TPFinal-MAIN","mediol "+cursor.getCount());
*/
 /*       tca = new MisPartidosCursorAdapter(ActividadPrincipal.this,cursor,proyectoDAO);
        lvPartidos.setAdapter(tca);
        Log.d("TPFinal-MAIN","fin onResume");
        // fin manejo sqlite

    }

    /*-------------------------------------- On Pause --------------------------------------------*/
 /*   protected void onPause() {
        super.onPause();
        Log.d("TPFinal-MAIN","on pausa");

        if(cursor!=null) cursor.close();
        if(proyectoDAO!=null) proyectoDAO.close();
        Log.d("TPFinal-MAIN","fin on pausa");

    }
   */

    /*-------------------------------------- On Start --------------------------------------------*/
    protected void onStart() {
        super.onStart();
        //Toast.makeText(getBaseContext(), "OnStart...", Toast.LENGTH_SHORT).show();
    }

    /* Inflar el menu*/
    /*--------------------------------- on Create Options Menu -----------------------------------*/
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    /*Captamos la accion seleccionada*/
    /*------------------------------- on Options Item Selected -----------------------------------*/
    public boolean onOptionsItemSelected(MenuItem item) { //main.xml
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify mas35 parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //Si selecciono CONFIGURACION
        if (id == R.id.action_settings) {
            Toast.makeText(getBaseContext(), "Clickee CONFIGURACION", Toast.LENGTH_LONG).show();
            startActivity(new Intent(ActividadPrincipal.this,Opciones.class));
            return true;
        }
        //Si selecciono AYUDA
        if (id == R.id.ayuda) {
            Toast.makeText(getBaseContext(), "Clickee AYUDA", Toast.LENGTH_LONG).show();
            //Inicio la actividad que me va mas35 levantar el Preferencias.xml
            //  startActivity(new Intent(MainActivity.this,AyudaActivity.class));
            return true;
        }
        //Si selecciono SALIR
        if (id == R.id.salir) {
            Toast.makeText(getBaseContext(), "Clickee SALIR", Toast.LENGTH_LONG).show();
            this.finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    /*---------------------- on Navigation Item Selected (listener del Navegador)-----------------*/
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        switch (id){
            case R.id.nav_deptos:
                Toast.makeText(getBaseContext(), "Clickee DEPARTAMENTOS", Toast.LENGTH_LONG).show();
                //    Intent i1 = new Intent(MainActivity.this,ListaDepartamentosActivity.class);
                //  i1.putExtra("esBusqueda",false );
                //startActivity(i1);
                break;
            case R.id.nav_ofertas:
                Toast.makeText(getBaseContext(), "Clickee OFERTAS", Toast.LENGTH_LONG).show();
                break;
            case R.id.nav_destinos:
                Toast.makeText(getBaseContext(), "Clickee DESTINOS", Toast.LENGTH_LONG).show();
                break;
            case R.id.nav_reservas:

                break;
            case R.id.nav_perfil:
                Toast.makeText(getBaseContext(), "Clickee PERFIL", Toast.LENGTH_LONG).show();
                break;

        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);//Cierra el NavigationView
        return true;//Devuelve TRUE en caso de que fue usado y FALSO en caso contrario
    }

    /*---------------------- on Back Pressed (botón retroceso del celular)------------------------*/
    //Al presionar el botón de volver atras del celular, lo primero que hace es cerrar el Navegador si estaba abierto
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}