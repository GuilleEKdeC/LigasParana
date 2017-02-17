package ar.edu.utn.frsf.isi.dam.ligasparana;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

import ar.edu.utn.frsf.isi.dam.ligasparana.Modelo.Partido;


//Esta clase extiende de ArrayAdapter para poder personalizarla a nuestro gusto
public class AdaptadorSustitutoMisPartidos extends ArrayAdapter<Partido> {

    Context contexto;
    //Activity contexto;
   // Partido[] partidos;
    ArrayList<Partido> partidos;
    LayoutInflater inflater;

    /*----------------------------------- Constructor --------------------------------------------*/
    //Constructor del AdaptadorDias donde se le pasaran por parametro el contexto de la aplicacion y el ArrayList de los Partidos
    public AdaptadorSustitutoMisPartidos(/*Activity context*/Context context, ArrayList<Partido> partidos) {
        //Llamada al constructor de la clase superior donde requiere el contexto, el layout y el arraylist
        super(context, R.layout.fila_mispartidos, partidos);/*R.layout.row*//*o 0*/
       // inflater= LayoutInflater.from(context);/*context*/
        this.contexto = context;
        this.partidos = partidos;
    }

    /*-------------------------------------- Get View --------------------------------------------*/
    //Este metodo es el que se encarga de dibujar cada Item de la lista y se invoca cada vez que se
    //necesita mostrar un nuevo item. En el se pasan parámetros como la posicion del elemento mostrado,
    //la vista (View) del elemento mostrado y el conjunto de vistas.
    public View getView(int position, View convertView, ViewGroup parent) {

        View item = convertView;
        //Creamos esta variable para almacenar posteriormente en el, la vista que ha dibujado
        ViewHolderMisPartidos viewholder;

        //Si se decide que no existe una vista reutilizable para el proximo item entra en la condicion.
        //De este modo tambien ahorramos tener que volver a generar vistas
        if (item == null) {

            //Obtenemos una referencia de Inflater para poder inflar el diseño
             inflater =(LayoutInflater) contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            // inflater = contexto.getLayoutInflater();  //para cuando context es una activity
           // LayoutInflater inflater= LayoutInflater.from(this.getContext());
           // item = inflater.inflate(R.layout.fila_mispartidos, null);
            item = inflater.inflate(R.layout.fila_mispartidos, parent, false);

            //item = inflater.inflate(contexto, R.layout.fila_mispartidos, this);

            //Creamos un nuevo viewholder que se almacenara en el tag de la vista
            viewholder = new ViewHolderMisPartidos(item);

            //Ahora si, guardamos en el tag de la vista el objeto vistaitem
            item.setTag(viewholder);

        } else {
            //En caso de que la vista sea ya reutilizable se recupera el objeto VistaItem almacenada en su tag
            viewholder = (ViewHolderMisPartidos) item.getTag();
        }


        viewholder.iv_liga.setImageResource(R.drawable.logoliga6);
        viewholder.tv_categoria.setText(R.string.categoria_prueba);
        viewholder.tv_equipos.setText(R.string.equipos_prueba);
        viewholder.tv_fecha.setText(R.string.fecha_prueba);
        viewholder.tv_lugar.setText(R.string.lugar_prueba);
        viewholder.cb_notificar.setChecked(false);



        //Se cargan los datos desde el ArrayList
        /*viewholder.iv_liga.setImageResource(partidos.get(position).getLiga());
        viewholder.tv_categoria.setText(partidos.get(position).getCategoria());
        viewholder.tv_equipos.setText(partidos.get(position).getEquipo1()+"  "+"vs"+"  "+partidos.get(position).getEquipo2());
        viewholder.tv_fecha.setText(partidos.get(position).getFecha());
        viewholder.tv_lugar.setText(partidos.get(position).getLugar());
        if(partidos.get(position).getNotificar().equals("TRUE")){
            viewholder.cb_notificar.setChecked(true); }
        else{
            viewholder.cb_notificar.setChecked(false);
        }
*/
 /*        //Implementamos el método OnLongClickListener que capturará la opción laboral seleccionada
        item.setOnLongClickListener(new View.OnLongClickListener(){
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
