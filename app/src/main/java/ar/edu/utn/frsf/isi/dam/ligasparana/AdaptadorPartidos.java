package ar.edu.utn.frsf.isi.dam.ligasparana;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import ar.edu.utn.frsf.isi.dam.ligasparana.Modelo.Partido;


//Esta clase extiende de ArrayAdapter para poder personalizarla a nuestro gusto
public class AdaptadorPartidos extends ArrayAdapter<Partido> {

    Context contexto;
    ArrayList<Partido> partidos;
    LayoutInflater inflater;
    String cancha;

    /*----------------------------------- Constructor --------------------------------------------*/
    //Constructor del AdaptadorDias donde se le pasaran por parametro el contexto de la aplicacion y el ArrayList de los Partidos
    public AdaptadorPartidos(Context context, ArrayList<Partido> partidos) {
        //Llamada al constructor de la clase superior donde requiere el contexto, el layout y el arraylist
        super(context, R.layout.fila_fechas, partidos);/*R.layout.row*//*o 0*/
        inflater= LayoutInflater.from(context);/*context*/
        this.contexto = context;
        this.partidos = partidos;
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
            // inflater = contexto.getLayoutInflater();  //para cuando context es una activity
            //LayoutInflater inflater= LayoutInflater.from(this.getContext());
            //LayoutInflater inflater= LayoutInflater.from(contexto);
           // item = inflater.inflate(R.layout.fila_mispartidos, null);
            item = inflater.inflate(R.layout.fila_fechas, parent, false);

            //item = inflater.inflate(contexto, R.layout.fila_mispartidos, this);

            //Creamos un nuevo viewholder que se almacenara en el tag de la vista
            viewholder = new ViewHolderPartidos(item);

            //Ahora si, guardamos en el tag de la vista el objeto vistaitem
            item.setTag(viewholder);

        } else {
            //En caso de que la vista sea ya reutilizable se recupera el objeto VistaItem almacenada en su tag
            viewholder = (ViewHolderPartidos) item.getTag();
        }

       /* viewholder.tv_equipoa.setText(R.string.equipoa_prueba);
        viewholder.tv_equipob.setText(R.string.equipob_prueba);
        viewholder.tv_hora.setText(R.string.hora_prueba);
        viewholder.tv_lugar.setText(R.string.lugar_prueba);
        viewholder.iv_iconomapa.setImageResource(R.drawable.iconomapas);*/

        //Se cargan los datos desde el ArrayList
        viewholder.tv_equipoa.setText(partidos.get(position).getEquipo1());
        viewholder.tv_equipob.setText(partidos.get(position).getEquipo2());
        viewholder.tv_hora.setText(partidos.get(position).getHora());
        viewholder.tv_lugar.setText(partidos.get(position).getLugar());
        viewholder.iv_iconomapa.setImageResource(R.drawable.iconomapas);


         //Implementamos el método OnLongClickListener que capturará la opción laboral seleccionada
        item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancha = partidos.get(position).getLugar();
                cancha = cancha.substring(0,cancha.length()-3);
Toast.makeText(contexto, "Cancha:"+cancha, Toast.LENGTH_SHORT).show();
                Thread hiloMapa = new Thread(new Runnable() {
                    public void run() {



                Intent mapa = new Intent(contexto,ActividadMapas.class);
                switch(cancha) {
                    case "Patronato":
                        mapa.putExtra("Latitud",-31.742945);
                        mapa.putExtra("Longitud",-60.508737);
                        mapa.putExtra("Título","Patronato");
                        mapa.putExtra("Dirección","Padre Bartolomé Grella 874, Paraná");
                        break;
                    case "OroVerde":
                        mapa.putExtra("Latitud",-31.821282);
                        mapa.putExtra("Longitud",-60.514467);
                        mapa.putExtra("Título","OroVerde");
                        mapa.putExtra("Dirección","El Trebol, Oro Verde, Entre Ríos");
                        break;
                    case "Paracao":
                        mapa.putExtra("Latitud",-31.769972);
                        mapa.putExtra("Longitud",-60.533009);
                        mapa.putExtra("Título","Paracao");
                        mapa.putExtra("Dirección","Juan Baez 745 -748, 3100 Paraná");
                        break;
                    case "Paraná":
                        mapa.putExtra("Latitud",-31.746394);
                        mapa.putExtra("Longitud",-60.515724);
                        mapa.putExtra("Título","Paraná");
                        mapa.putExtra("Dirección","José Ruperto Pérez 273, Paraná");
                        break;
                    case "Chapino":
                        mapa.putExtra("Latitud",-31.780638);
                        mapa.putExtra("Longitud",-60.452317);
                        mapa.putExtra("Título","Chapino");
                        mapa.putExtra("Dirección","Av. Jorge Newbery s/n");
                        break;
                    case "BajadaG":
                        mapa.putExtra("Latitud",-31.711557);
                        mapa.putExtra("Longitud",-60.558824);
                        mapa.putExtra("Título","BajadaG");
                        mapa.putExtra("Dirección","Av. Larramendi 2783");
                        break;
                }
                contexto.startActivity(mapa);
                    }
                });//fin-hilo
                hiloMapa.start();
            }
        });/* setOnLongClickListener(new View.OnLongClickListener(){
            @Override
            public boolean onLongClick(View v) {

                Toast.makeText(contexto, "Long Clicked", Toast.LENGTH_SHORT).show();
                return true;
            }
                //Se notifica al adaptador de que el ArrayList que tiene asociado ha sufrido cambios (forzando asi a ir al metodo getView())
     /*           adaptador.notifyDataSetChanged();*/
 /*       });
*/
        //Se devuelve ya la vista nueva o reutilizada que ha sido dibujada
        return (item);
    }

}
