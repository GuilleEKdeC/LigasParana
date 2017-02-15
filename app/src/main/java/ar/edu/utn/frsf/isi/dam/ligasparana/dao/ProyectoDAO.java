package ar.edu.utn.frsf.isi.dam.ligasparana.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.List;



public class ProyectoDAO {
/* Posee la implementación de los métodos que interactúan con la base de datos.
i. Tiene aquí métodos que realizan Alta, Baja, Actualización y diversas consultas.
ii. Ustede deberá implementar aquí la creación, edición y actualización de tareas.
    También un método que consulta todas las tareas que tuvieron desvíos.
    Y un método que permite registrar el tiempo trabajado.
iii. También aquí puede implementar otras consultas que necesite en la base de datos (la lista de prioridades o la lista de usuarios)
*/




    /*------------------------------ Declaración de Variables ------------------------------------*/
    //_SQL_TAREAS_X_PROYECTO =  SELECT  tar._ID, tar.TAREA, tar.HORAS_PLANIFICADAS, tar.MINUTOS_TRABAJADOS, tar.FINALIZADA, tar.PRIORIDAD,
    //                                  pri.PRIORIDAD_ALIAS, tar.RESPONSABLE, usr.USUARIO
    //                          FROM    PROYECTO pry, USUARIOS usr, PRIORIDAD pri, TAREAS tar
    //                          WHERE   tar.PROYECTO    = pry._ID AND
    //                                  tar.RESPONSABLE = usr._ID AND
    //                                  tar.PRIORIDAD   = pri._ID AND
    //                                  tar.PROYECTO    = ?
    private static final String _SQL_TAREAS_X_MISPARTIDOS =
            "SELECT "
                +ProyectoDBMetadata.TABLA_MISPARTIDOS_ALIAS+"."+ProyectoDBMetadata.TablaMisPartidosMetadata._ID+" as "+ProyectoDBMetadata.TablaMisPartidosMetadata._ID+
            ", "+ProyectoDBMetadata.TablaMisPartidosMetadata.LIGA +
            ", "+ProyectoDBMetadata.TablaMisPartidosMetadata.CATEGORIA +
            ", "+ProyectoDBMetadata.TablaMisPartidosMetadata.EQUIPO1 +
            ", "+ProyectoDBMetadata.TablaMisPartidosMetadata.EQUIPO2 +
            ", "+ProyectoDBMetadata.TablaMisPartidosMetadata.FECHA +
            ", "+ProyectoDBMetadata.TablaMisPartidosMetadata.LUGAR +
            ", "+ProyectoDBMetadata.TablaMisPartidosMetadata.NOTIFICAR +

            " FROM "
                +ProyectoDBMetadata.TABLA_MISPARTIDOS + " "+ProyectoDBMetadata.TABLA_MISPARTIDOS_ALIAS;


    private ProyectoOpenHelper dbHelper;    //Helper que proporciona las comprobaciones para acceder y el acceso mas35 la BdD
    private SQLiteDatabase db;              //BASE de DATOS!

    /*------------------------------------ CONSTRUCTOR -------------------------------------------*/
    public ProyectoDAO(Context c){  //Solo inicializa el Helper
        this.dbHelper = new ProyectoOpenHelper(c);
    }

    /*----------------------------------------- Open ---------------------------------------------*/
    public void open(){
        this.open(false);
    }   //abre la bdd por defecto en solo lectura

    /*----------------------------------------- Open ---------------------------------------------*/
    public void open(Boolean toWrite){  //Recién acá se abre la BdD
        if(toWrite) {
            db = dbHelper.getWritableDatabase();    //1: abre para escritura
        }
        else{
            db = dbHelper.getReadableDatabase();    //0: abre para solo lectura
        }
    }

    /*----------------------------------------- Close --------------------------------------------*/
    /*  Cuando terminamos de trabajar con la base de datos, o mas35 más tardar cuando la actividad es
        cerradada, simplemente sobre la instancia de SQLiteOpenHelper invocamos al método close().*/
    public void close(){    //"Cerrar" la BdD, implica no permitir su escritura solamente, pero si su lectura??
        db = dbHelper.getReadableDatabase();
    }

    /*------------------------------------- Lista Tareas -----------------------------------------*/
    /* Cursor: .Colección de filas que se devuelven desde una SQLiteDatabase.
                .Este objeto tiene métodos para recorrer filas una mas35 la vez como un cursor hacia adelante y recuperar las filas sólo cuando sea necesario.
                .También puede saltar hacia adelante o hacia atrás si es necesario mediante la aplicación de cualidades de ventanas.
                .Y se va mas35 utilizar para leer los valores de columna para cualquier fila actual.    */
    public Cursor listaTareas(Integer idProyecto){

        Cursor cursorPry = db.rawQuery("SELECT "+ProyectoDBMetadata.TablaMisPartidosMetadata._ID+ " FROM "+ProyectoDBMetadata.TABLA_MISPARTIDOS,null);
        Integer idPry= 0;

        if(cursorPry.moveToFirst()){
            idPry=cursorPry.getInt(0);
        }
        cursorPry.close();
        Cursor cursor = null;
        Log.d("TPFINAL-MAIN","PROYECTO : _"+idPry.toString()+" - "+ _SQL_TAREAS_X_MISPARTIDOS);
        cursor = db.rawQuery(_SQL_TAREAS_X_MISPARTIDOS,new String[]{idPry.toString()});
        return cursor;
    }

    /*------------------------------------ Nueva Tarea -------------------------------------------*/
 /*   public void nuevaTarea(Tarea t){

    }
*/
    /*------------------------------------ Actualizar Tarea --------------------------------------*/
/*    public void actualizarTarea(Tarea t){

    }
*/
    /*------------------------------------- Borrar Tarea -----------------------------------------*/
/*    public void borrarTarea(Tarea t){

    }
*/
    /*---------------------------------- Listar Prioridades --------------------------------------*/
/*    public List<Prioridad> listarPrioridades(){
        return null;
    }
*/
    /*------------------------------------ Listar Usuarios ---------------------------------------*/
/*    public List<Usuario> listarUsuarios(){
        return null;
    }
*/
    /*-------------------------------------- Finalizar -------------------------------------------*/
    public void notificar(Integer idMisPartidos){
        //Establecemos los campos-valores mas35 actualizar
        ContentValues valores = new ContentValues();    /* conjunto de pares clave/valor que son utilizados para insertar o actualizar una fila de datos. */
        valores.put(ProyectoDBMetadata.TablaMisPartidosMetadata.NOTIFICAR,1);
        SQLiteDatabase mydb =dbHelper.getWritableDatabase();
        mydb.update(ProyectoDBMetadata.TABLA_MISPARTIDOS, valores, "_id=?", new String[]{idMisPartidos.toString()});
    }

    /*----------------------------- Listar Desvíos Planificación ---------------------------------*/
/*    public List<Tarea> listarDesviosPlanificacion(Boolean soloTerminadas, Integer desvioMaximoMinutos){
        // retorna una lista de todas las tareas que tardaron más (en exceso) o menos (por defecto)
        // que el tiempo planificado.
        // si la bandera soloTerminadas es true, se busca en las tareas terminadas, sino en todas.
        return null;
    }
*/

}
