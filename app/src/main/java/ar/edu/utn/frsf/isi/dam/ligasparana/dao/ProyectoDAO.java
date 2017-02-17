package ar.edu.utn.frsf.isi.dam.ligasparana.dao;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.io.File;


public class ProyectoDAO {
/*---------------------------------- Declaración de Variables ------------------------------------*/
    //_SQL_TAREAS_X_PROYECTO =  SELECT  tar._ID, tar.TAREA, tar.HORAS_PLANIFICADAS, tar.MINUTOS_TRABAJADOS, tar.FINALIZADA, tar.PRIORIDAD,
    //                                  pri.PRIORIDAD_ALIAS, tar.RESPONSABLE, usr.USUARIO
    //                          FROM    PROYECTO pry, USUARIOS usr, PRIORIDAD pri, TAREAS tar
    //                          WHERE   tar.PROYECTO    = pry._ID AND
    //                                  tar.RESPONSABLE = usr._ID AND
    //                                  tar.PRIORIDAD   = pri._ID AND
    //                                  tar.PROYECTO    = ?
    private static final String _SQL_MISPARTIDOS =
            "SELECT "
                + ProyectoDBMetadata.TABLA_MISPARTIDOS_ALIAS+"."+ ProyectoDBMetadata.TablaMisPartidosMetadata._ID+" as "+ ProyectoDBMetadata.TablaMisPartidosMetadata._ID+
            ", "+ ProyectoDBMetadata.TablaMisPartidosMetadata.LIGA+
            ", "+ ProyectoDBMetadata.TablaMisPartidosMetadata.CATEGORIA+
            ", "+ ProyectoDBMetadata.TablaMisPartidosMetadata.EQUIPO1+
            ", "+ ProyectoDBMetadata.TablaMisPartidosMetadata.EQUIPO2+
            ", "+ ProyectoDBMetadata.TablaMisPartidosMetadata.FECHA+
            ", "+ ProyectoDBMetadata.TablaMisPartidosMetadata.LUGAR+
            ", "+ ProyectoDBMetadata.TablaMisPartidosMetadata.NOTIFICAR+
            " FROM "
                + ProyectoDBMetadata.TABLA_MISPARTIDOS + " "+ ProyectoDBMetadata.TABLA_MISPARTIDOS_ALIAS;

    private static final String _SQL_MISPREFERENCIAS =
            "SELECT "
                + ProyectoDBMetadata.TABLA_MISPREFERENCIAS_ALIAS+"."+ ProyectoDBMetadata.TablaMisPreferenciasMetadata._ID+" as "+ ProyectoDBMetadata.TablaMisPreferenciasMetadata._ID+
            ", "+ ProyectoDBMetadata.TablaMisPreferenciasMetadata.LIGA+
            ", "+ ProyectoDBMetadata.TablaMisPreferenciasMetadata.CATEGORIA+
            " FROM "
                + ProyectoDBMetadata.TABLA_MISPREFERENCIAS + " "+ ProyectoDBMetadata.TABLA_MISPREFERENCIAS_ALIAS;

    private ProyectoOpenHelper dbHelper;    //Helper que proporciona las comprobaciones para acceder y el acceso mas35 la BdD
    private SQLiteDatabase db;              //BASE de DATOS!
    private Context contexto;

    /*------------------------------------ CONSTRUCTOR -------------------------------------------*/
    public ProyectoDAO(Context c){  //Solo inicializa el Helper
        this.dbHelper = new ProyectoOpenHelper(c);
        contexto = c;
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
                .Y se va mas35 utilizar para leer los valores de columna para cualquier fila actual.
       rawQuery(el select, (puede incluir) parametros posicionales) => Retorna un cursor que permite iterar sobre los resultados.*/
    public Cursor listaMisPartidos(){

    /*    Cursor cursorPry = db.rawQuery("SELECT "+ProyectoDBMetadata.TablaMisPartidosMetadata._ID+" FROM "+ProyectoDBMetadata.TABLA_MISPARTIDOS,null);
        Integer idPry= 0;
        String s[] = new String[cursorPry.getCount()];
        int aux = 0;
        if(cursorPry.moveToFirst()){
            do{
                idPry=cursorPry.getInt(0);
                s[aux]= idPry.toString();
                aux++;
            }while(cursorPry.moveToNext());
        }
        else {s[aux]=idPry.toString();}

        cursorPry.close();*/
        Cursor cursor = null;
        cursor = db.rawQuery(_SQL_MISPARTIDOS,null);  //new String[]{idPry.toString()}
     return cursor;
    }

    /*-------------------------------------- Notificar -------------------------------------------*/
    public void notificar(Integer idMisPartidos, String notificar){ //notificar: "TRUE" / "FALSE"
        //Establecemos los campos-valores a actualizar
        ContentValues valores = new ContentValues();    /* conjunto de pares clave/valor que son utilizados para insertar o actualizar una fila de datos. */
        valores.put(ProyectoDBMetadata.TablaMisPartidosMetadata.NOTIFICAR,notificar);
        SQLiteDatabase mydb =dbHelper.getWritableDatabase();
        mydb.update(ProyectoDBMetadata.TABLA_MISPARTIDOS, valores, "_id=?", new String[]{idMisPartidos.toString()});
    }

    /*---------------------------------- insertarPartido -----------------------------------------*/
/*    public void insertarPartido(Partido p){

        ContentValues aInsertar = new ContentValues();

        aInsertar.put(ProyectoDBMetadata.TablaMisPartidosMetadata._ID,p.getId());
        aInsertar.put(ProyectoDBMetadata.TablaMisPartidosMetadata.LIGA,p.getLiga());
        aInsertar.put(ProyectoDBMetadata.TablaMisPartidosMetadata.CATEGORIA,p.getCategoria());
        aInsertar.put(ProyectoDBMetadata.TablaMisPartidosMetadata.EQUIPO1,p.getEquipo1());
        aInsertar.put(ProyectoDBMetadata.TablaMisPartidosMetadata.EQUIPO2,p.getEquipo2());
        aInsertar.put(ProyectoDBMetadata.TablaMisPartidosMetadata.FECHA,p.getFecha());
        aInsertar.put(ProyectoDBMetadata.TablaMisPartidosMetadata.LUGAR,p.getLugar());
        aInsertar.put(ProyectoDBMetadata.TablaMisPartidosMetadata.NOTIFICAR,p.getNotificar());

        try {
            db.insert(ProyectoDBMetadata.TABLA_MISPARTIDOS, null, aInsertar);
        } catch (SQLiteException ex) {
            ex.printStackTrace();
        }
    }

    /*---------------------------------- actualizarPartido ---------------------------------------*/
 /*   public void actualizarPartido(Partido p){
        /**Establecemos los valores**/
/*        ContentValues aActualizar = new ContentValues();

        aActualizar.put(ProyectoDBMetadata.TablaMisPartidosMetadata._ID,p.getId());
        aActualizar.put(ProyectoDBMetadata.TablaMisPartidosMetadata.LIGA,p.getLiga());
        aActualizar.put(ProyectoDBMetadata.TablaMisPartidosMetadata.CATEGORIA,p.getCategoria());
        aActualizar.put(ProyectoDBMetadata.TablaMisPartidosMetadata.EQUIPO1,p.getEquipo1());
        aActualizar.put(ProyectoDBMetadata.TablaMisPartidosMetadata.EQUIPO2,p.getEquipo2());
        aActualizar.put(ProyectoDBMetadata.TablaMisPartidosMetadata.FECHA,p.getFecha());
        aActualizar.put(ProyectoDBMetadata.TablaMisPartidosMetadata.LUGAR,p.getLugar());
        aActualizar.put(ProyectoDBMetadata.TablaMisPartidosMetadata.NOTIFICAR,p.getNotificar());

        db.update(ProyectoDBMetadata.TABLA_MISPARTIDOS, aActualizar, ProyectoDBMetadata.TablaMisPartidosMetadata._ID + "=" + p.getId(), null);
    }

    /*----------------------------------- eliminar Partido ---------------------------------------*/
 /*   public void eliminarPartido(Partido p){

        db.delete(ProyectoDBMetadata.TABLA_MISPARTIDOS, ProyectoDBMetadata.TablaMisPartidosMetadata._ID + " = " + p.getId().toString(),null);
    }
*/
    /*--------------------------------- lista Preferencias ---------------------------------------*/
    public Cursor listaPreferencias(){

        Cursor cursor = null;
        cursor = db.rawQuery(_SQL_MISPREFERENCIAS,null);  //new String[]{idPry.toString()}
        return cursor;
    }

    /*------------------------------------ Actualizar Liga ---------------------------------------*/
    public void actualizarLiga(String idLiga){

        Integer idPref= 1;      //Siempre mantendremos una tabla de una fila, entonces id de pref siempre va a ser 1
        ContentValues valores = new ContentValues();

        valores.put(ProyectoDBMetadata.TablaMisPreferenciasMetadata.LIGA,idLiga);

        db.update(ProyectoDBMetadata.TABLA_MISPREFERENCIAS, valores, ProyectoDBMetadata.TABLA_MISPREFERENCIAS+"."+ProyectoDBMetadata.TablaMisPreferenciasMetadata._ID+" = ?", new String[]{idPref.toString()});
    }
    /*--------------------------------- Actualizar Categoria -------------------------------------*/
    public void actualizarCategoria(String idCategoria){

        Integer idPref= 1;      //Siempre mantendremos una tabla de una fila, entonces id de pref siempre va a ser 1
        ContentValues valores = new ContentValues();

        valores.put(ProyectoDBMetadata.TablaMisPreferenciasMetadata.CATEGORIA,idCategoria);

        db.update(ProyectoDBMetadata.TABLA_MISPREFERENCIAS, valores, ProyectoDBMetadata.TABLA_MISPREFERENCIAS+"."+ProyectoDBMetadata.TablaMisPreferenciasMetadata._ID+" = ?", new String[]{idPref.toString()});
    }


}
