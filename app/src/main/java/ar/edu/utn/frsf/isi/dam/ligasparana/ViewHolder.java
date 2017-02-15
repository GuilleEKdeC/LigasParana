package ar.edu.utn.frsf.isi.dam.ligasparana;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

//Esta clase se usa para almacenar los TextView, la ImageView y el CheckBox de una vista y es donde esta el "truco" para que las vistas se guarden
public class ViewHolder {
    //---------------------------------------Variables--------------------------------------------//
    TextView tv_nombre = null;
    ImageView iv_logo = null;

    //---------------------------------------Constructor------------------------------------------//
    ViewHolder(View base) {
        this.tv_nombre = (TextView) base.findViewById(R.id.tv_descripcion);
        this.iv_logo = (ImageView) base.findViewById(R.id.iv_logo);
    }

    //---------------------------------------Gets y Sets------------------------------------------//
    public TextView getLiga() {
        return tv_nombre;
    }
    public void setLiga(TextView liga) {
        this.tv_nombre = liga;
    }
    public ImageView getLogo() {
        return iv_logo;
    }
    public void setLogo(ImageView logo) {
        this.iv_logo = logo;
    }
}
