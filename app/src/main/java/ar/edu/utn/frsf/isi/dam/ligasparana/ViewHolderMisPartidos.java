package ar.edu.utn.frsf.isi.dam.ligasparana;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

//Esta clase se usa para almacenar los TextView, la ImageView y el CheckBox de una vista y es donde esta el "truco" para que las vistas se guarden
public class ViewHolderMisPartidos {

    ImageView iv_liga = null;
    TextView tv_categoria = null;
    TextView tv_equipos = null;
    TextView tv_fecha = null;
    TextView tv_lugar = null;
    CheckBox cb_notificar = null;

    ViewHolderMisPartidos(View base) {

        this.iv_liga = (ImageView) base.findViewById(R.id.iv_liga);
        this.tv_categoria = (TextView) base.findViewById(R.id.tv_categoria);
        this.tv_equipos = (TextView) base.findViewById((R.id.tv_equipos));
        this.tv_fecha = (TextView) base.findViewById(R.id.tv_fecha);
        this.tv_lugar = (TextView) base.findViewById(R.id.tv_lugar);
        this.cb_notificar = (CheckBox) base.findViewById(R.id.cb_notificar);
    }

    //---------------------------------------Gets y Sets------------------------------------------//
    public CheckBox getCb_notificar() {        return cb_notificar;    }

    public void setCb_notificar(CheckBox cb_notificar) {        this.cb_notificar = cb_notificar;    }

    public TextView getTv_lugar() {        return tv_lugar;    }

    public void setTv_lugar(TextView tv_lugar) {        this.tv_lugar = tv_lugar;    }

    public TextView getTv_fecha() {        return tv_fecha;    }

    public void setTv_fecha(TextView tv_fecha) {        this.tv_fecha = tv_fecha;    }

    public TextView getTv_equipos() {        return tv_equipos;    }

    public void setTv_equipos(TextView tv_equipos) {        this.tv_equipos = tv_equipos;    }

    public ImageView getIv_liga() {        return iv_liga;    }

    public void setIv_liga(ImageView iv_liga) {        this.iv_liga = iv_liga;    }

    public TextView getTv_categoria() {        return tv_categoria;    }

    public void setTv_categoria(TextView tv_categoria) {        this.tv_categoria = tv_categoria;    }
}
