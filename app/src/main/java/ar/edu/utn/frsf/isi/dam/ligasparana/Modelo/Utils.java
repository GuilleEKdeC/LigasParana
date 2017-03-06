package ar.edu.utn.frsf.isi.dam.ligasparana.Modelo;

import java.util.Calendar;


public class Utils {
    public static Calendar getTimeAfterInSecs(int secs) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.SECOND,secs);
        return cal;
    }

}
