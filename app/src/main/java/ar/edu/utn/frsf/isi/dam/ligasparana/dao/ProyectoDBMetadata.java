package ar.edu.utn.frsf.isi.dam.ligasparana.dao;

import android.provider.BaseColumns;

/* Estructura de la BdD y de las Tablas */
public class ProyectoDBMetadata {
/*tiene metadatos que permiten referenciar en String a campos de la base de datos.*/

    public static final int VERSION_DB = 8;
    public static final String NOMBRE_DB= "tpfinal.db";

    public static final String TABLA_MISPARTIDOS= "MISPARTIDOS";
    public static final String TABLA_MISPARTIDOS_ALIAS= "mp";
    public static final String TABLA_MISPREFERENCIAS= "MISPREFERENCIAS";
    public static final String TABLA_MISPREFERENCIAS_ALIAS= "mpr";


    public static class TablaMisPartidosMetadata implements BaseColumns {
        public static final String LIGA = "LIGA";
        public static final String CATEGORIA = "CATEGORIA";
        public static final String EQUIPO1 ="EQUIPO1";
        public static final String EQUIPO2 ="EQUIPO2";
        public static final String FECHA ="FECHA";  /*formato "YYYY-MM-DD HH:MM:SS.SSS".*/
        public static final String LUGAR ="LUGAR";
        public static final String NOTIFICAR = "NOTIFICAR";
    }

    public static class TablaMisPreferenciasMetadata implements BaseColumns {
        public static final String LIGA = "LIGA";
        public static final String CATEGORIA = "CATEGORIA";
    }
}
