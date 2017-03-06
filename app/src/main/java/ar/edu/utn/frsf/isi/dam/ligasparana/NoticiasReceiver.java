package ar.edu.utn.frsf.isi.dam.ligasparana;

import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.support.v4.app.NotificationCompat;

import java.util.Calendar;

import ar.edu.utn.frsf.isi.dam.ligasparana.Modelo.Utils;

public class NoticiasReceiver extends BroadcastReceiver {
    @Override
    /* onReceive método que se ejecutará cada vez que se produzca el evento al que este suscrito nuestro broadcast receiver.*/
    public void onReceive(Context context, Intent intent) {
        /*CANCELAMOS alarmas existentes*/
        cancelRepeatingAlarm(context);
        sendNotificacion(context,"Sección en Reparación!");
    }

    /*REPETIR ALARMA*/
    public void sendRepeatingAlarm(Context context){
        Calendar cal = Utils.getTimeAfterInSecs(1);
        Intent intent = new Intent(context,NoticiasReceiver.class); //Obtener un intent para invocar al receptor
        PendingIntent pi = getDistinctPendingIntent(context,intent,2);
        AlarmManager am = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);/*Programar la alarma, una que se repita*/
        am.setRepeating(AlarmManager.RTC,cal.getTimeInMillis(),(5*10),pi);//AlarmManager.RTC para lanzar la alarma cuando el dispositivo se “despierte”.
    }

    /*CANCELAR ALARMA*/
    public void cancelRepeatingAlarm(Context context){
        Intent intent = new Intent(context, NoticiasReceiver.class);//Usar el intent usado para invocar PendientesReceiver
        PendingIntent sender = PendingIntent.getBroadcast(context, 2, intent, 0); // construimos un “PendingIntent” apropiado para “broadcast”
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        alarmManager.cancel(sender); /*Cancelar la alarma*/
    }

    /*Enviando la notificación*/
    private void sendNotificacion(Context context,String message){
        String ns = Context.NOTIFICATION_SERVICE;
        NotificationManager nm = (NotificationManager) context.getSystemService(ns);
        //Intent intent = new Intent(context,ActividadPrincipal.class);
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        String strRingtonePreference = prefs.getString("ringtone_1", "DEFAULT_RINGTONE_URI");
        Uri defaultSoundUri = Uri.parse(strRingtonePreference);
        //PendingIntent pi = PendingIntent.getActivity(context,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context.getApplicationContext())
                //.setContentIntent(pi)
                .setSmallIcon(android.R.drawable.stat_sys_warning)
                .setContentTitle("Atención")
                .setContentText(message)
                .setAutoCancel(true)
                .setSound(defaultSoundUri)
                .setTicker("Ligas Paraná");
        nm.notify(1,mBuilder.build());
    }

    /*Usado en el medoto sendRepeatingAlarm()*/
    protected PendingIntent getDistinctPendingIntent(Context context,Intent intent, int requestId){
        return PendingIntent.getBroadcast(context,requestId,intent,0);
    }
}
