package ar.edu.utn.frsf.isi.dam.ligasparana;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;


public class ConfirmacionDialogFragment extends DialogFragment implements DialogInterface.OnClickListener{


    //La actividad debe gestionar el listener
    private ConfirmacionDialogFragmentListener listener;

    //Constructor: ventana estática de diálogo -------------------------------------------------------
    public static ConfirmacionDialogFragment newInstance(String titulo){

        ConfirmacionDialogFragment frag = new ConfirmacionDialogFragment();

        //Leemos los argumentos que pasa la Actividad que lo contiene
        Bundle args = new Bundle();
        args.putString("titulo",titulo);
        frag.setArguments(args);
        return frag;
    }//Fin - constructor

    //Definimos el listener con los 2 métodos de callback que debe definir la Actividad----------------
    public interface ConfirmacionDialogFragmentListener{
        public void onPositiveClick();
        public void onNegativeClick();
    }

    //Método para establecer el listener anterior desde al Actividad-----------------------------------
    public void setConfirmacionDialogFragmentListener(ConfirmacionDialogFragmentListener listener){
        this.listener = listener;
    }

    //Evento que se lanza cuando se crea la ventana de diálogo
    public Dialog onCreateDialog(Bundle savedInstanceState){
        String titulo = getArguments().getString("titulo");
        // Creamos el típico diálogo del tipo AlertDialog con el título
        return new AlertDialog.Builder(getActivity())
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle(titulo)
                .setPositiveButton(android.R.string.ok,this)
                .setNegativeButton(android.R.string.cancel,this)
                .create();
    }

    // Evento que sucede cuando el usuario hace click en un botón ya que se está implementando el
    // método DialogInterface.OnClickListener
    public void onClick(DialogInterface dialog, int which){

            switch (which){
                case DialogInterface.BUTTON_POSITIVE:
                    listener.onPositiveClick();
                    break;
                default:
                    listener.onNegativeClick();
            }
    }

}

