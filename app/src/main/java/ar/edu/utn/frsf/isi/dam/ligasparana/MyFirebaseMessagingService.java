package ar.edu.utn.frsf.isi.dam.ligasparana;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyFirebaseMessagingService extends FirebaseMessagingService {
    private static final String LOGTAG = "android-fcm";

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {

        if ((remoteMessage.getNotification() != null) && (remoteMessage.getData() != null)) {

            String titulo = remoteMessage.getNotification().getTitle();
            String texto = remoteMessage.getNotification().getBody();
            String usuario = remoteMessage.getData().get("usuario");
            String noticia = remoteMessage.getData().get("noticia");

            Log.d(LOGTAG, "NOTIFICACION RECIBIDA");
            Log.d(LOGTAG, "Título: " + titulo);
            Log.d(LOGTAG, "Texto: " + texto);
            Log.d(LOGTAG, "DATOS RECIBIDOS");
            Log.d(LOGTAG, "Usuario: " + remoteMessage.getData().get("usuario"));
            Log.d(LOGTAG, "Noticia: " + remoteMessage.getData().get("noticia"));

            //Opcional: mostramos la notificación en la barra de estado
            showNotification(titulo, texto, usuario, noticia);
        }
    }

    private void showNotification(String title, String text, String usuario, String noticia) {

        /*===============================================================================================*/
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        String strRingtonePreference = prefs.getString("ringtone_1", "DEFAULT_RINGTONE_URI");
        Uri defaultSoundUri = Uri.parse(strRingtonePreference);
         /*==============================================================================================*/

        NotificationCompat.Builder notificationBuilder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(android.R.drawable.stat_sys_warning)
                        .setContentTitle(title)
                        .setContentText(text)
                        .setAutoCancel(true)
                        .setSound(defaultSoundUri)
                        .setTicker("Ligas Paraná");

        Intent intent = new Intent(MyFirebaseMessagingService.this,ActividadPrincipal.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("title", title);
        intent.putExtra("description", text);
        intent.putExtra("usuario", usuario);
        intent.putExtra("noticia", noticia);


        PendingIntent contIntent = PendingIntent.getActivity(
                MyFirebaseMessagingService.this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);

        notificationBuilder.setContentIntent(contIntent);

        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        notificationManager.notify(0, notificationBuilder.build());
    }

}
