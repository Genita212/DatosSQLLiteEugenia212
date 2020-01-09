package ejt.edu.tesoem.genita212.itic.datossqlliteeugenia212.Base_de_datos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.security.interfaces.DSAKey;

public class DatosHelper extends SQLiteOpenHelper {
    private static DatosHelper datosHelper=null;
    private static String NOMBREDB= "bdAgenda7T11";
    private static int VERSION_DB=1;

    public static  class tablaDatos{
      public static String TABLA="tbAgenda";
      public static String COLUMNA_ID="Id";
      public static String COLUMNA_NOMBRE="Nombre";
      public static String COLUMNA_EDAD="Edad";
      public static String COLUMNA_CORREO="Correo";
    }
    public static final String CONSULTA_CREAR_TABLA="create table "+tablaDatos.TABLA+ "("+
                tablaDatos.COLUMNA_ID+" integer not null primary key autoincrement," +
                tablaDatos.COLUMNA_NOMBRE+" varchar," +
                tablaDatos.COLUMNA_EDAD+" integer," +
                tablaDatos.COLUMNA_CORREO+"varchar);";

    public static final String CONSULTA_ELIMINAR_TABLA="drop table if exists "+tablaDatos.TABLA;

    public static DatosHelper getInstance(Context context){
        if (datosHelper==null){
            datosHelper=new DatosHelper(context.getApplicationContext());
        }
        return datosHelper;
    }

    public DatosHelper(Context context){
        super(context,NOMBREDB,null,VERSION_DB);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CONSULTA_CREAR_TABLA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(CONSULTA_ELIMINAR_TABLA);
        onCreate(db);
    }
}
