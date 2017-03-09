package ar.edu.utn.frsf.isi.dam.ligasparana;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

//Esta clase se usa para almacenar los TextView, la ImageView y el CheckBox de una vista y es donde esta el "truco" para que las vistas se guarden
public class ViewHolderPartidos {

    TextView tv_equipoa = null;
    TextView tv_equipob = null;
    TextView tv_hora = null;
    TextView tv_lugar = null;
    ImageButton ib_iconomapa = null;

    ViewHolderPartidos(View base) {

        this.tv_equipoa = (TextView) base.findViewById(R.id.tv_fechas_equipoa);
        this.tv_equipob = (TextView) base.findViewById((R.id.tv_fechas_equipob));
        this.tv_hora = (TextView) base.findViewById(R.id.tv_fechas_horario);
        this.tv_lugar = (TextView) base.findViewById(R.id.tv_fechas_lugar);
        this.ib_iconomapa = (ImageButton) base.findViewById(R.id.ib_fechas_iconomapa);
    }

    //---------------------------------------Gets y Sets------------------------------------------//
    public TextView getTv_equipoa() {
        return tv_equipoa;
    }

    public TextView getTv_equipob() {
        return tv_equipob;
    }

    public TextView getTv_hora() {
        return tv_hora;
    }

    public TextView getTv_lugar() {
        return tv_lugar;
    }

    public ImageButton getIv_iconomapa() {
        return ib_iconomapa;
    }

    public void setTv_equipoa(TextView tv_equipoa) {
        this.tv_equipoa = tv_equipoa;
    }

    public void setTv_equipob(TextView tv_equipob) {
        this.tv_equipob = tv_equipob;
    }

    public void setTv_hora(TextView tv_hora) {
        this.tv_hora = tv_hora;
    }

    public void setTv_lugar(TextView tv_lugar) {
        this.tv_lugar = tv_lugar;
    }

    public void setIv_iconomapa(ImageButton ib_iconomapa) {
        this.ib_iconomapa = ib_iconomapa;
    }

}
