package ejt.edu.tesoem.genita212.itic.datossqlliteeugenia212.Base_de_datos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import ejt.edu.tesoem.genita212.itic.datossqlliteeugenia212.Base_de_datos.DatosHelper.*;

public class DatosConexion {
    private SQLiteDatabase basededatos;
    private DatosHelper datosHelper;

    public DatosConexion(Context context){
        datosHelper= DatosHelper.getInstance(context);
    }

    public void open(){
        basededatos=datosHelper.getWritableDatabase();
    }

    public void close(){
        basededatos.close();
    }

    public String[] llenargridview(){
        String[] datos;
        int columna=4;
        Cursor cursor= basededatos.rawQuery("select * from "+DatosHelper.tablaDatos.TABLA,null);
        if(cursor.getCount()<=0){
            datos= new String[4];
            datos[0]=tablaDatos.COLUMNA_ID;
            datos[1]=tablaDatos.COLUMNA_NOMBRE;
            datos[2]=tablaDatos.COLUMNA_EDAD;
            datos[3]=tablaDatos.COLUMNA_CORREO;

        }else{
            datos=new String[(cursor.getCount()*4)+4];
            datos[0]=tablaDatos.COLUMNA_ID;
            datos[1]=tablaDatos.COLUMNA_NOMBRE;
            datos[2]=tablaDatos.COLUMNA_EDAD;
            datos[3]=tablaDatos.COLUMNA_CORREO;
            cursor.moveToFirst();
            while(!cursor.isAfterLast()){
                datos[columna]=String.valueOf(cursor.getInt(0));
                datos[columna+1]=cursor.getString(1);
                datos[columna+2]=String.valueOf(cursor.getInt(2));
                datos[columna+3]=cursor.getString(3);
                columna+=4;
                cursor.moveToNext();
            }
        }
        return datos;
    }

    public boolean insertar(ContentValues contentValues){
        boolean estado= true;
        basededatos.isOpen();
        int resultadoconsulta=(int)basededatos.insert(tablaDatos.TABLA,null,contentValues);
        if(!(resultadoconsulta==1)) estado=false;
      //  basededatos.close();
        return estado;
    }

    public boolean actualizar(ContentValues contentValues, String[] condicion){
        boolean estado=true;
        basededatos.isOpen();
        int resultadoconsulta=(int) basededatos.update(tablaDatos.TABLA,contentValues,tablaDatos.COLUMNA_ID+"=?",condicion);
        if(!(resultadoconsulta==1))estado=false;
        basededatos.close();
        return estado;
    }

    public boolean eliminar(String[] condicion){
        boolean estado=true;
        basededatos.isOpen();
        int resultadoconsulta=(int) basededatos.delete(tablaDatos.TABLA,tablaDatos.COLUMNA_ID+"=?",condicion);
        if(!(resultadoconsulta==1)) estado=false;
        basededatos.close();
        return estado;
    }
}