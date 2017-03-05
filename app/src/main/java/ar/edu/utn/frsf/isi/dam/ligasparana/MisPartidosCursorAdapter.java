package ar.edu.utn.frsf.isi.dam.ligasparana;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;
import org.w3c.dom.Text;
import ar.edu.utn.frsf.isi.dam.ligasparana.Modelo.Categoria;
import ar.edu.utn.frsf.isi.dam.ligasparana.Modelo.Liga;
import ar.edu.utn.frsf.isi.dam.ligasparana.dao.ProyectoDAO;
import ar.edu.utn.frsf.isi.dam.ligasparana.dao.ProyectoDBMetadata;


public class MisPartidosCursorAdapter extends CursorAdapter {

    /*----------------------------- Declaración de Variables -------------------------------------*/
    private LayoutInflater inflador;
    private ProyectoDAO myDao;
    private Context contexto;

    /*------------------------------------ CONSTRUCTOR -------------------------------------------*/
    /*(ActividadPrincipal.this,cursor,proyectoDAO)*/
    public MisPartidosCursorAdapter(Context context, Cursor c, ProyectoDAO dao) {
        super(context, c, false);
        this.myDao = dao;
        this.contexto = context;
    }

    /*-------------------------------------- New View --------------------------------------------*/
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {

        inflador = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View vista = inflador.inflate(R.layout.fila_mispartidos, viewGroup, false);
        return vista;
    }

    /*------------------------------------- Bind View --------------------------------------------*/
    public void bindView(View view, final Context context, final Cursor cursor) {
        Integer categoria = null;

        ImageView iv_liga = (ImageView) view.findViewById(R.id.iv_liga);
        TextView tv_categoria = (TextView) view.findViewById(R.id.tv_categoria);
        TextView tv_equipos = (TextView) view.findViewById((R.id.tv_equipos));
        TextView tv_fecha = (TextView) view.findViewById(R.id.tv_fecha);
        TextView tv_lugar = (TextView) view.findViewById(R.id.tv_lugar);
        CheckBox cb_notificar = (CheckBox) view.findViewById(R.id.cb_notificar);

        int liga = cursor.getInt(cursor.getColumnIndex(ProyectoDBMetadata.TablaMisPartidosMetadata.LIGA));
        iv_liga.setImageResource(Liga.LIGAS_MOCK[liga].getImagenLogo());

        categoria = (cursor.getColumnIndex(ProyectoDBMetadata.TablaMisPartidosMetadata.CATEGORIA));
        tv_categoria.setText(Categoria.CATEGORIAS_MOCK[categoria].getNombre());
        tv_equipos.setText((cursor.getString(cursor.getColumnIndex(ProyectoDBMetadata.TablaMisPartidosMetadata.EQUIPO1)))
                            +"  "+"vs"+"  "+(cursor.getString(cursor.getColumnIndex(ProyectoDBMetadata.TablaMisPartidosMetadata.EQUIPO2))));
        tv_fecha.setText((cursor.getString(cursor.getColumnIndex(ProyectoDBMetadata.TablaMisPartidosMetadata.FECHA))));
        tv_lugar.setText((cursor.getString(cursor.getColumnIndex(ProyectoDBMetadata.TablaMisPartidosMetadata.LUGAR))));
        if (((cursor.getString(cursor.getColumnIndex(ProyectoDBMetadata.TablaMisPartidosMetadata.NOTIFICAR)))).equals("TRUE")){
            cb_notificar.setChecked(true);
        }
        else {cb_notificar.setChecked(false);}


        /*-------------------------------- listenner Notificar -----------------------------------*/
        //para conocer el id de la fila o la posición en un evento previamente lo asignamos al tag del componente.
        cb_notificar.setTag(cursor.getInt(cursor.getColumnIndex("_id")));  //setea en el tag el int del _id
        cb_notificar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                final Integer idPartido = (Integer) view.getTag();        //obtiene el _id de la fila del cursor anteriormente seteado
                String notificar = "FALSE";
                if(((CheckBox)view).isChecked()){ notificar = "TRUE"; }
                myDao = new ProyectoDAO(contexto);
                myDao.open();
                myDao.notificar(idPartido,notificar);
                handlerRefresh.sendEmptyMessage(1);
            }
        });
    }//Fin Bind View

    /*-------------------------------------- Handler ---------------------------------------------*/
    Handler handlerRefresh = new Handler(Looper.getMainLooper()) {
        @Override
        public void handleMessage(Message inputMessage) {
            MisPartidosCursorAdapter.this.changeCursor(myDao.listaMisPartidos());
        }
    };

}

