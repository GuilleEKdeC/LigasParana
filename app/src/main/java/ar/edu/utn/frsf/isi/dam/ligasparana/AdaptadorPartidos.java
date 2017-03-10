package ar.edu.utn.frsf.isi.dam.ligasparana;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.NotificationCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Toast;
import java.util.ArrayList;
import ar.edu.utn.frsf.isi.dam.ligasparana.Modelo.Partido;
import ar.edu.utn.frsf.isi.dam.ligasparana.ConfirmacionDialogFragment.ConfirmacionDialogFragmentListener;


//Esta clase extiende de ArrayAdapter para poder personalizarla a nuestro gusto
public class AdaptadorPartidos extends ArrayAdapter<Partido>{

    final FragmentManager fragmentManager;
    Context contexto;
    ArrayList<Partido> partidos;
    LayoutInflater inflater;
    String cancha;
    ConfirmacionDialogFragmentListener listener;
    View partido;

    /*----------------------------------- Constructor --------------------------------------------*/
    //Constructor del AdaptadorDias donde se le pasaran por parametro el contexto de la aplicacion y el ArrayList de los Partidos
    public AdaptadorPartidos(FragmentManager fragmentManager, Context context, ArrayList<Partido> partidos) {
        //Llamada al constructor de la clase superior donde requiere el contexto, el layout y el arraylist
        super(context, R.layout.fila_fechas, partidos);
        inflater= LayoutInflater.from(context);
        this.contexto = context;
        this.partidos = partidos;
        this.fragmentManager = fragmentManager;
        this.listener = new ConfirmacionDialogFragmentListener() {
            @Override
            public void onPositiveClick() {
                Toast.makeText(contexto, "AGREGAR", Toast.LENGTH_SHORT).show();
                //ACA SE INSERTA EL PARTIDO A LA BASE DE DATOS
            }

            @Override
            public void onNegativeClick() {
                Toast.makeText(contexto, "CANCELAR", Toast.LENGTH_SHORT).show();
            }
        };
    }

    /*-------------------------------------- Get View --------------------------------------------*/
    //Este metodo es el que se encarga de dibujar cada Item de la lista y se invoca cada vez que se
    //necesita mostrar un nuevo item. En el se pasan parámetros como la posicion del elemento mostrado,
    //la vista (View) del elemento mostrado y el conjunto de vistas.
    public View getView(final int position, View convertView, ViewGroup parent) {

        View item = convertView;
        //Creamos esta variable para almacenar posteriormente en el, la vista que ha dibujado
        ViewHolderPartidos viewholder;

        //Si se decide que no existe una vista reutilizable para el proximo item entra en la condicion.
        //De este modo tambien ahorramos tener que volver a generar vistas
        if (item == null) {

            //Obtenemos una referencia de Inflater para poder inflar el diseño
            inflater =(LayoutInflater) contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            item = inflater.inflate(R.layout.fila_fechas, parent, false);

            //Creamos un nuevo viewholder que se almacenara en el tag de la vista
            viewholder = new ViewHolderPartidos(item);

            //Ahora si, guardamos en el tag de la vista el objeto vistaitem
            item.setTag(viewholder);

        } else {
            //En caso de que la vista sea ya reutilizable se recupera el objeto VistaItem almacenada en su tag
            viewholder = (ViewHolderPartidos) item.getTag();
        }

        //Se cargan los datos desde el ArrayList
        viewholder.tv_equipoa.setText(partidos.get(position).getEquipo1());
        viewholder.tv_equipob.setText(partidos.get(position).getEquipo2());
        viewholder.tv_hora.setText(partidos.get(position).getHora());
        viewholder.tv_lugar.setText(partidos.get(position).getLugar());
        viewholder.ib_iconomapa.setImageResource(R.drawable.iconomapas);

        // Seteo del listenner del Mapa ---------------------------------------
        viewholder.ib_iconomapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancha = partidos.get(position).getLugar();
                cancha = cancha.substring(0,cancha.length()-3);
                Toast.makeText(contexto, "Cancha:"+cancha, Toast.LENGTH_SHORT).show();
                Intent mapa = new Intent(v.getContext(),ActividadMapas.class);
                switch(cancha) {
                    case "Patronato":
                        mapa.putExtra("Longitud",-31.742698);
                        mapa.putExtra("Latitud", -60.509079);
                        mapa.putExtra("Título","Patronato");
                        mapa.putExtra("Dirección","Padre Bartolomé Grella 874, Paraná");
                        break;
                    case "OroVerde":
                        mapa.putExtra("Longitud",-31.821282);
                        mapa.putExtra("Latitud",-60.514467);
                        mapa.putExtra("Título","OroVerde");
                        mapa.putExtra("Dirección","El Trebol, Oro Verde, Entre Ríos");
                        break;
                    case "Paracao":
                        mapa.putExtra("Longitud",-31.769972);
                        mapa.putExtra("Latitud",-60.533009);
                        mapa.putExtra("Título","Paracao");
                        mapa.putExtra("Dirección","Juan Baez 745 -748, 3100 Paraná");
                        break;
                    case "Paraná":
                        mapa.putExtra("Longitud",-31.746394);
                        mapa.putExtra("Latitud",-60.515724);
                        mapa.putExtra("Título","Paraná");
                        mapa.putExtra("Dirección","José Ruperto Pérez 273, Paraná");
                        break;
                    case "Chapino":
                        mapa.putExtra("Longitud",-31.780638);
                        mapa.putExtra("Latitud",-60.452317);
                        mapa.putExtra("Título","Complejo O. Chapino");
                        mapa.putExtra("Dirección","Av. Jorge Newbery s/n");
                        break;
                    case "BajadaG":
                        mapa.putExtra("Longitud",-31.711557);
                        mapa.putExtra("Latitud",-60.558824);
                        mapa.putExtra("Título","Bajada Grande");
                        mapa.putExtra("Dirección","Av. Larramendi 2783");
                        break;
                }
                v.getContext().startActivity(mapa);
            }
        });
        // Fin listenner Mapa -------------------------------------------------

                // Seteo del listenner sobre partido, para incorporarlo al listado "MisPartidos"
       item.setOnLongClickListener(new View.OnLongClickListener() {
           @Override
           public boolean onLongClick(View v) {
               partido = v;
               //creamos el fragmento
               ConfirmacionDialogFragment confirmacionDialog = ConfirmacionDialogFragment.newInstance("Desea AGREGAR el partido a sus 'Partidos Favorítos' ?");
               //definimos los listener
               confirmacionDialog.setConfirmacionDialogFragmentListener(listener);
               //mostramos la ventana de diálogo
               confirmacionDialog.show(fragmentManager,null);
               return false;
           }
       });

        //Se notifica al adaptador de que el ArrayList que tiene asociado ha sufrido cambios (forzando asi a ir al metodo getView())
       //adaptador.notifyDataSetChanged();

        //Se devuelve ya la vista nueva o reutilizada que ha sido dibujada
        return (item);
    }
}
