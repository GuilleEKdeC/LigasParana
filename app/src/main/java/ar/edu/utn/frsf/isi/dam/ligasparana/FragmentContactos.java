package ar.edu.utn.frsf.isi.dam.ligasparana;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class FragmentContactos extends Fragment {

    View v;
    TextView telefono;
    Button btnLlamar, btnEnviarMail;

    /*----------------CONSTRUCTOR---------------*/
    public static FragmentContactos newInstance() {
        FragmentContactos fragment = new FragmentContactos();
        return fragment;
    }

    public FragmentContactos() {
    }


    /*---------------ON CREATE---------------------*/
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.fragment_contacto, container, false);
        btnLlamar = (Button) v.findViewById(R.id.buttonLlamar);
        btnEnviarMail = (Button) v.findViewById(R.id.buttonEmail);


        //Se asigna listener al botón llamar con el texto que ha introducido el usuario
        btnLlamar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                //Se parse el teléfono a URI
                Uri number =  Uri.parse("tel:+3434973676");

                //Se lanza el intent para llamada
                Intent callIntent = new Intent(Intent.ACTION_DIAL, number);
                startActivity(callIntent);
            }
        });

        btnEnviarMail.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Toast.makeText(getActivity().getBaseContext(), "Lo sentimos, NO hay conexión", Toast.LENGTH_LONG).show();
                //Se obtienen los campos introducidos por el usuario
            /*    final EditText destinatario = (EditText) v.findViewById(R.id.txtmailuser);
                String dest = destinatario.getText().toString();

                final EditText asunto = (EditText) findViewById(R.id.txtmailsubject);
                String asun = asunto.getText().toString();

                final EditText cuerpo = (EditText) findViewById(R.id.txtmailbody);
                String cuer = cuerpo.getText().toString();

                //Se crea el intent para envío demail
                Intent emailIntent = new Intent(Intent.ACTION_SEND);

                //Se añaden campos extras para enviar mail
                emailIntent.setType("text/plain");
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[] {dest});	//Destinatario
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, asun);				//Asunto
                emailIntent.putExtra(Intent.EXTRA_TEXT, cuer);					//Cuerpo mail

                //Se lanza la actividad
                startActivity(emailIntent);
         */  }
        });

        return v;
    }

    /*
//Se asigna listener al botón enviar mail

*/
}