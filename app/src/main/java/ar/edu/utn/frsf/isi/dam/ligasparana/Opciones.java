package ar.edu.utn.frsf.isi.dam.ligasparana;


        import android.content.SharedPreferences;
        import android.media.Ringtone;
        import android.media.RingtoneManager;
        import android.net.Uri;
        import android.os.Bundle;
        import android.preference.Preference;
        import android.preference.PreferenceActivity;
        import android.preference.PreferenceManager;
        import android.preference.RingtonePreference;
        import android.widget.Toast;

public class Opciones extends PreferenceActivity implements SharedPreferences.OnSharedPreferenceChangeListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferencias);
    }

    @Override
    /*Se setea el Sub-Titulo (summary) con el valor que se cargo*/
    public void onSharedPreferenceChanged(SharedPreferences sharedPref, String key) {
        //boolean entro = false;
        if (key.equals("nombre_usuario")) {
            Preference connectionPref = findPreference(key);
            connectionPref.setSummary(sharedPref.getString(key, ""));
        }

        if (key.equals("email_usuario")) {
            Preference connectionPref = findPreference(key);
            connectionPref.setSummary(sharedPref.getString(key, ""));
        }

       /* ======================================================================================= */
        if (key.equals("ringtone_1")) {
            Toast.makeText(getApplicationContext(), "Ringtone guardado...", Toast.LENGTH_LONG).show();

            SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
            String strRingtonePreference = prefs.getString("ringtone_1", "DEFAULT_RINGTONE_URI");

            Uri ringtoneUri = Uri.parse(strRingtonePreference);
            Ringtone ringtone = RingtoneManager.getRingtone(getBaseContext(), ringtoneUri);
            String name = ringtone.getTitle(getBaseContext());

            Preference connectionPref = findPreference(key);
            connectionPref.setSummary(name);
        }
        /* ======================================================================================= */
    }

    protected void onResume() {
        super.onResume(); // Registrar escucha
        getPreferenceScreen().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
    }

    /*Observe que mas35 diferencia de onSharedPreferenceChanged, onPreferenceChange se llama antes de
    que se actualice la preferencia, por lo que debe utilizar el parámetro newValue para obtener los
     datos seleccionados en lugar de obtenerlos de la preferencia.*/

    /* @Override
    public boolean onPreferenceChange(Preference preference, Object newValue) {
        updateRingtoneSummary((RingtonePreference) preference, Uri.parse((String) newValue));
        return true;
    }
    private void updateRingtoneSummary(RingtonePreference preference, Uri ringtoneUri) {
        Ringtone ringtone = RingtoneManager.getRingtone(this, ringtoneUri);
        if (ringtone != null)
            preference.setSummary(ringtone.getTitle(this));
        else
            preference.setSummary("Silent");
    }*/

}