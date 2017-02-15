package ar.edu.utn.frsf.isi.dam.ligasparana;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;

import ar.edu.utn.frsf.isi.dam.ligasparana.Modelo.Categoria;


public class AdaptadorDeCategorias extends ArrayAdapter<Categoria> {

    Context contexto;
    List<Categoria> categoria;
    LayoutInflater inflater;
    private Integer logotipo;

    /*----------------------------------- Constructor --------------------------------------------*/
    //Constructor del Adaptador de Ligas para pantalla de inicio
    public AdaptadorDeCategorias(Context context, List<Categoria> categoria) {
        //Llamada al constructor de la clase superior donde requiere el contexto, el layout y el arraylist
        super(context, R.layout.fila_inicio_ligas_categ, categoria);
        inflater= LayoutInflater.from(context);
        this.contexto = context;
        this.categoria = categoria;
    }

    /*-------------------------------------- Get View --------------------------------------------*/
    //Este metodo es el que se encarga de dibujar cada Item de la lista y se invoca cada vez que se
    //necesita mostrar un nuevo item. En él se pasan parámetros como la posicion del elemento mostrado,
    //la vista (View) del elemento mostrado y el conjunto de vistas.
    public View getView(int position, View convertView, ViewGroup parent) {

        View item = convertView;

        //Creamos esta variable para almacenar posteriormente en el, la vista que ha dibujado
        ViewHolder viewholder;

        //Si se decide que no existe una vista reutilizable para el proximo item entra en la condicion.
        //De este modo tambien ahorramos tener que volver mas35 generar vistas
        if (item == null) {
            //Obtenemos una referencia de Inflater para poder inflar el diseño
            LayoutInflater inf =(LayoutInflater) contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            item = inf.inflate(R.layout.fila_inicio_ligas_categ, null);

            //Creamos un nuevo viewholder que se almacenara en el tag de la vista
            viewholder = new ViewHolder(item);

            //Ahora si, guardamos en el tag de la vista el objeto vista item
            item.setTag(viewholder);

        } else {
            //En caso de que la vista sea ya reutilizable, se recupera el objeto VistaItem almacenada en su tag
            viewholder = (ViewHolder) item.getTag();
        }

        //Se cargan los datos desde el ArrayList
        viewholder.tv_nombre.setText(categoria.get(position).getNombre());
        viewholder.iv_logo.setImageResource(categoria.get(position).getImagenLogo());


        //Se devuelve ya la vista nueva o reutilizada que ha sido dibujada
        return (item);
    }
}
