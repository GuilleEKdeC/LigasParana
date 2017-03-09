package ar.edu.utn.frsf.isi.dam.ligasparana;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
/*

public class ConfirmaciónDialogFragment extends DialogFragment implements DialogInterface.OnClickListener{


        */    //La actividad debe gestionar el listener
//    private ConfirmaciónDialogFragmentListener listener;

    //Constructor: ventana estática de diálogo
/*    public

    boolean agregar;

 /*   public Dialog onCreateDialog(Bundle savedInstanceState) {

        agregar = false;

        AlertDialog.Builder builder =
                new AlertDialog.Builder(getActivity());

        builder.setMessage("¿Desea agregar el partido a 'Mis Partidos' favoritos?")
                .setTitle("Confirmacion")
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener()  {
                    public void onClick(DialogInterface dialog, int id) {
                        getTargetFragment().onActivityResult(getTargetRequestCode(), resultCode, getActivity().getIntent())
                        dialog.cancel();
                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        return builder.create();
    }

    public boolean getAgregar(){
        return agregar;
    }
}*/