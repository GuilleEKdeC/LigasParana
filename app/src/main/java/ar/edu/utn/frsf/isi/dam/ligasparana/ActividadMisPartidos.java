package ar.edu.utn.frsf.isi.dam.ligasparana;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import ar.edu.utn.frsf.isi.dam.ligasparana.dao.ProyectoDAO;


public class ActividadMisPartidos extends AppCompatActivity {

    private ListView lvPartidos;
    private ProyectoDAO proyectoDAO;
    private Cursor cursor;
    private MisPartidosCursorAdapter adaptador_misP;

   //   definición de variables para el adaptador sutituto
   //   private ArrayList<Partido> listaPartidos;
   //   private AdaptadorSustitutoMisPartidos adaptadorSustituto;

    /*------------------------------------- ON CREATE --------------------------------------------*/
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad_mis_partidos);

    //  definición de variables para el adaptador sutituto
    //  lvPartidos = (ListView) findViewById(R.id.lista_mis_partidos); //lvPartidos es el listView que se encuentra en el content_main
    //  listaPartidos = new ArrayList<Partido>();

        lvPartidos = (ListView) findViewById(R.id.lista_mis_partidos);

        //Registramos la lista de "Mis partidos" para un menú contextual
        registerForContextMenu(lvPartidos);

     }//Fin ON CREATE

    /*-------------------------------------- On Resume -------------------------------------------*/
    protected void onResume() {
        super.onResume();

    //  manejo de sqlite
        proyectoDAO = new ProyectoDAO(ActividadMisPartidos.this);
        proyectoDAO.open();
        cursor = proyectoDAO.listaMisPartidos();
        adaptador_misP = new MisPartidosCursorAdapter(ActividadMisPartidos.this,cursor,proyectoDAO);
        lvPartidos.setAdapter(this.adaptador_misP);
        //Registramos la lista de "Mis partidos" para un menú contextual
        registerForContextMenu(lvPartidos);
    //  fin manejo sqlite

    //  manejo adaptador sustituto
    //  llamamos a un Inicializar lista partidos que cargue cada fila del cursor dentro de cada elemento Partido
    //  inicializarListaPartidos(cursor);
    //  adaptadorSustituto= new AdaptadorSustitutoMisPartidos(this.getBaseContext(),listaPartidos );//getApplicationContext(),Arrays.asList(jobs)     //era solo this
    //  lvPartidos.setAdapter(adaptadorSustituto);

    //Esto es mas que nada es a nivel de diseño con el objetivo de crear unas lineas mas anchas entre item y item
        lvPartidos.setDividerHeight(5);
    }

    /*-------------------------------------- On Pause --------------------------------------------*/
    protected void onPause() {
        super.onPause();
        if(cursor!=null) cursor.close();
        if(proyectoDAO!=null) proyectoDAO.close();
    }
    /*--------------------------------- inicializar Lista Partidos -------------------------------*/
/*    protected void inicializarListaPartidos(Cursor c){

        cursor.moveToFirst();
        int i =0;
        do{
            Partido p = new Partido();
            p.setId(cursor.getInt(0));
            p.setLiga(cursor.getInt(1));
            p.setCategoria(cursor.getInt(2));
            p.setEquipo1(cursor.getString(3));
            p.setEquipo2(cursor.getString(4));
            p.setFecha(cursor.getString(5));
            p.setLugar(cursor.getString(6));
            p.setNotificar(cursor.getString(7));
             listaPartidos[i] = new Partido(p.getId(),p.getLiga(),p.getCategoria(),p.getEquipo1(),p.getEquipo2(),p.getFecha(),p.getLugar(),p.getNotificar());
            i++;
            listaPartidos.add(p);
        }while (cursor.moveToNext());
        cursor.close();
    }*/

    /*------------------------------- On Create Context Menú -------------------------------------*/
/*    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(contextMenu,view,menuInfo);

        MenuInflater inflater = getMenuInflater();
        // inflater.inflate(R.menu.menu_context_borrar_partido_favorito,contextMenu);
        if(view.getId() == R.id.lista_mis_partidos){
            AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
            contextMenu.setHeaderTitle("Menú contextual");
            //contextMenu.setHeaderTitle(lvPartidos.getAdapter().getItem(info.position).toString());
            inflater.inflate(R.menu.menu_context_borrar_partido_favorito,contextMenu);
            Toast.makeText(ActividadMisPartidos.this, "En menu contextual", Toast.LENGTH_LONG).show();
        }
    }

    /*------------------------------- On Context Item Selected -----------------------------------*/
/*    public boolean onContextItemSelected(MenuItem item){

        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()){
            case R.id.borrar_partidoFavorito:
                Toast.makeText(ActividadMisPartidos.this, "Clickie BORRAR MI PARTIDO", Toast.LENGTH_LONG).show();
                //return true;
                break;
            case R.id.cancelar_borrarPartidoFavorito:
                Toast.makeText(ActividadMisPartidos.this, "Clickie CANCELAR borrar mi partido", Toast.LENGTH_LONG).show();
                //return true;
                break;
            default:
                Toast.makeText(ActividadMisPartidos.this, "Clickie en otro lado", Toast.LENGTH_LONG).show();
                // return super.onContextItemSelected(item);
                break;
        }
        return true;

    }
*/
}

