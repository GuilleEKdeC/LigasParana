package ar.edu.utn.frsf.isi.dam.ligasparana;
import android.*;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.location.Location;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;

import android.preference.PreferenceManager;
import android.provider.Settings;
import android.provider.SyncStateContract;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
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
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;

import ar.edu.utn.frsf.isi.dam.ligasparana.Modelo.Categoria;
import ar.edu.utn.frsf.isi.dam.ligasparana.Modelo.Liga;
import ar.edu.utn.frsf.isi.dam.ligasparana.Modelo.Usuario;
import ar.edu.utn.frsf.isi.dam.ligasparana.dao.ProyectoDAO;
import ar.edu.utn.frsf.isi.dam.ligasparana.dao.ProyectoDBMetadata;

public class ActividadPrincipal extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{


    private ProyectoDAO proyectoDAO;
    private Intent bienvenida;
    private Intent ligas;
    private Intent categoria;
    private Cursor cursor;
    private long mLastPress = 0;	// Cuándo se pulsó atrás por última vez
    private long mTimeLimit = 2000;	// Límite de tiempo entre pulsaciones, en ms
    private ViewPager viewPager;
    private MiFragmentPagerAdapter fadapter;
    private Usuario usuario;
    private String nombreUsuario;
    private String correoUsuario;
    private TextView textUsuario;
    private TextView textEmail;
    private TextView textLigaSeleccionada;
    private TextView textCategoriaSeleccionada;
    private String noticiaPush;
    private String usuarioPush;
    private String tituloPush;
    private String ligaSeleccionada;
    private String categoriaSeleccionada;

    /*------------------------------------- ON CREATE --------------------------------------------*/
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.o_4_actividad_principal);

        //  manejo de sqlite para controlar la existencia de las elecciones de LIGA y CATEGORÍA ----
        proyectoDAO = new ProyectoDAO(ActividadPrincipal.this);
        proyectoDAO.open();
        cursor = proyectoDAO.listaPreferencias();
        if(cursor.moveToFirst()){   //si hay filas en el cursor
            if(cursor.getInt(cursor.getColumnIndex(ProyectoDBMetadata.TablaMisPreferenciasMetadata.CATEGORIA)) == 0){       // Si aún no se eligió CATEGORÏA
                categoria = new Intent(ActividadPrincipal.this,ActividadCategoria.class);                             // Comenzar la actividad de seleccionar CATEGORÍA
                startActivity(categoria);
            }
            if(cursor.getInt(cursor.getColumnIndex(ProyectoDBMetadata.TablaMisPreferenciasMetadata.LIGA)) == 0){            // Si aún no se eligió LIGA
            //   ligas = new Intent().setClass(ActividadPrincipal.this, ActividadLiga.class);                    // Comenzar la actividad de seleccionar LIGA
                ligas = new Intent(ActividadPrincipal.this,ActividadLiga.class);
                startActivity(ligas);
            }
        }
        else{
           // Toast.makeText(getBaseContext(), "VACIO", Toast.LENGTH_LONG).show();
        }

        bienvenida = new Intent(ActividadPrincipal.this,ActividadPantallaBienvenida.class);
        startActivity(bienvenida);
        // fin manejo sqlite -----------------------------------------------------------------------

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        if(getIntent().hasExtra("title") && getIntent().hasExtra("noticia") && getIntent().hasExtra("usuario")){
            SharedPreferences.Editor editor = prefs.edit();
            tituloPush = getIntent().getStringExtra("title");
            noticiaPush = getIntent().getStringExtra("noticia");
            usuarioPush = getIntent().getStringExtra("usuario");

            editor.putString("title", tituloPush);
            editor.putString("noticia", noticiaPush);
            editor.putString("usuario", usuarioPush);
            editor.commit();
        }

        nombreUsuario = prefs.getString("nombre_usuario","USUARIO");
        correoUsuario = prefs.getString("email_usuario","email@usuario.com");
        ligaSeleccionada = "Liga de Veteranos";//setear con el valor de la BD de SQLite
        categoriaSeleccionada = "Senior"; //setear con el valor de la BD de SQLite

        usuario = new Usuario(nombreUsuario,correoUsuario); /*Creamos el usuario*/
        /*=========================================================================================*/

        //Tabs + ViewPager
        Toolbar toolbarFrag = (Toolbar) findViewById(R.id.appbar); //toolbar   //appbar
        setSupportActionBar(toolbarFrag);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        //Establecer el PageAdapter del componente ViewPager
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        fadapter = new MiFragmentPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(fadapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.appbartabs);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        tabLayout.setupWithViewPager(viewPager);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout); //Crea una nueva variable DrawerLayout (contenedor de nuestro "contenido Principal" y de nuestro "navegador"), el activity_main.xml

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbarFrag, R.string.navigation_drawer_open, R.string.navigation_drawer_close){//Compatibiliza el Drawer Layout con la barra de acciones (Toolbar)
            /*******************Agregado*******************/
           public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                getSupportActionBar().setTitle("Después de cerrar el Navegador (ManiActivity)");//cambia el título mas35 la toolbar
                invalidateOptionsMenu(); //indica a Android que los contenidos del menú han cambiado y que el menú debe ser redibujado. Crea una llamada al método onPrepareOptionsMenú
            }

            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getSupportActionBar().setTitle("Antes de abrir el Navegador (ManiActivity)"); //cambia el título mas35 la toolbar
                invalidateOptionsMenu(); //indica a Android que los contenidos del menú han cambiado y que el menú debe ser redibujado. Crea una llamada al método onPrepareOptionsMenú
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

        textUsuario = (TextView)header.findViewById(R.id.textV_usuario);
        textEmail = (TextView)header.findViewById(R.id.textV_correo);
         /*=========================================================================================*/
        textCategoriaSeleccionada = (TextView) header.findViewById(R.id.textV_categoria);
        textLigaSeleccionada = (TextView) header.findViewById(R.id.textV_liga);

        textUsuario.setText(nombreUsuario);
        textEmail.setText(correoUsuario);
        textCategoriaSeleccionada.setText(ligaSeleccionada);
        textLigaSeleccionada.setText(categoriaSeleccionada);
    }//Fin ON CREATE
/*
    /*-------------------------------------- On Resume -------------------------------------------*/
    protected void onResume() {
        super.onResume();

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        if(getIntent().hasExtra("title") && getIntent().hasExtra("noticia") && getIntent().hasExtra("usuario")){
            SharedPreferences.Editor editor = prefs.edit();
            tituloPush = getIntent().getStringExtra("title");
            noticiaPush = getIntent().getStringExtra("noticia");
            usuarioPush = getIntent().getStringExtra("usuario");

            editor.putString("title", tituloPush);
            editor.putString("noticia", noticiaPush);
            editor.putString("usuario", usuarioPush);
            editor.commit();
        }

        // Seteamos los valores de las preferencias ----------------------------------------
        // Manejo de sqlite para extraer la LIGA y CATEGORÍA ----
        proyectoDAO = new ProyectoDAO(ActividadPrincipal.this);
        proyectoDAO.open();

        Integer idLiga = proyectoDAO.getLiga();
        if(idLiga == 0){ ligaSeleccionada = "Sin Liga";}
        else { ligaSeleccionada = Liga.LIGAS_MOCK[idLiga-1].getNombre();}

        Integer idCategoria = proyectoDAO.getCategoría();
        if(idCategoria == 0){ categoriaSeleccionada = "Sin Categoría";}
        else { categoriaSeleccionada = Categoria.CATEGORIAS_MOCK[idCategoria-1].getNombre();}

        nombreUsuario = prefs.getString("nombre_usuario","La Cholito");
        correoUsuario = prefs.getString("email_usuario","email@usuario.com");

        /*Seteamos Datos del usuario*/
        usuario.setNombre(nombreUsuario);
        usuario.setCorreo(correoUsuario);

        /*Seteo nuevamente los datos del usuario, por si se cambio las configuraciones*/
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view); //Crea una nueva variable NavigationView, tomando como referencia la definida en activity_main.xml.
        navigationView.setNavigationItemSelectedListener(this); //le setea un listener
        View header=navigationView.getHeaderView(0);

        textUsuario = (TextView)header.findViewById(R.id.textV_usuario);
        textEmail = (TextView)header.findViewById(R.id.textV_correo);
        textLigaSeleccionada = (TextView)header.findViewById(R.id.textV_liga);
        textCategoriaSeleccionada = (TextView)header.findViewById(R.id.textV_categoria);

        textUsuario.setText(nombreUsuario);
        textEmail.setText(correoUsuario);
        textLigaSeleccionada.setText(ligaSeleccionada);
        textCategoriaSeleccionada.setText(categoriaSeleccionada);
    }

    /*--------------------------------- enviar Notificación -----------------------------------*/
        private void enviarNotificacion(){
        NoticiasReceiver activarAlarma = new NoticiasReceiver();
        activarAlarma.sendRepeatingAlarm(ActividadPrincipal.this);
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
            startActivity(new Intent(ActividadPrincipal.this,Opciones.class));
            return true;
        }
        //Si selecciono AYUDA
        if (id == R.id.ayuda) {
            Toast.makeText(getBaseContext(), "Clickee AYUDA", Toast.LENGTH_LONG).show();
            //Inicio la actividad que me va a levantar el Preferencias.xml
            //  startActivity(new Intent(MainActivity.this,AyudaActivity.class));
            return true;
        }
        //Si selecciono ACERCA DE
        if (id == R.id.Acerca_de) {
            Toast.makeText(getBaseContext(), "Acerca de...", Toast.LENGTH_LONG).show();
            enviarNotificacion(); //Esto lanza una notificacion con alarmManager
            return true;
        }
        return super.onOptionsItemSelected(item);
    }// FIN on Options Item Selected


    /*---------------------- on Navigation Item Selected (listener del Navegador)-----------------*/
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        switch (id){
            case R.id.nav_liga:
                Intent mainIntent = new Intent().setClass(ActividadPrincipal.this, ActividadLiga.class);                    // Comenzar la actividad de seleccionar LIGA
                startActivity(mainIntent);
                break;
            case R.id.nav_Categoria:
                Intent intActCat= new Intent(ActividadPrincipal.this,ActividadCategoria.class);                             // Comenzar la actividad de seleccionar CATEGORÍA
                startActivity(intActCat.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP));
                break;
            case R.id.nav_equipo:
                Toast.makeText(getBaseContext(), "Clickee Equipo", Toast.LENGTH_LONG).show();
                break;
            case R.id.nav_misPartidos:
                Toast.makeText(getBaseContext(), "Clickee MisPartidos", Toast.LENGTH_LONG).show();
                Intent imP = new Intent(ActividadPrincipal.this,ActividadMisPartidos.class);
                startActivity(imP);
                break;
            case R.id.nav_localizar:
                //Intent mapa = new Intent(ActividadPrincipal.this,Localizar.class);
                Intent mapa = new Intent(ActividadPrincipal.this,ActividadMapas.class);
                startActivity(mapa);
                Toast.makeText(getBaseContext(), "Mi Posición: ¡Esta en Reparación!", Toast.LENGTH_LONG).show();

                break;
            case R.id.nav_perfil:
                Toast.makeText(getBaseContext(), "Clickee Perfil", Toast.LENGTH_LONG).show();
                startActivity(new Intent(ActividadPrincipal.this,Opciones.class));
                break;

        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);//Cierra el NavigationView
        return true;//Devuelve TRUE en caso de que fue usado y FALSO en caso contrario
    }

    /*----------------------------------- on Back Pressed ----------------------------------------*/
    public void onBackPressed() {

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {

            if (mLastPress>mTimeLimit) {
                super.onBackPressed();
                return;
            } else {
                Toast.makeText(this,"Presiona nuevamente para salir", Toast.LENGTH_SHORT).show();
            }
            mLastPress = System.currentTimeMillis();
        }
    }

/*    @Override
    public void onFragmentSelected(Context c, String s) {
        Toast.makeText(this, "En Principal, spinner RESULTADOS", Toast.LENGTH_LONG).show();
    }
*/
    /*-------------------------------------- On Pause --------------------------------------------*/
    protected void onPause() {
        super.onPause();
        if(cursor!=null) cursor.close();
        if(proyectoDAO!=null) proyectoDAO.close();
    }
}