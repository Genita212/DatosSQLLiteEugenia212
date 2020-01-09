package ejt.edu.tesoem.genita212.itic.datossqlliteeugenia212;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import ejt.edu.tesoem.genita212.itic.datossqlliteeugenia212.Base_de_datos.DatosConexion;

public class AgregarActivity extends AppCompatActivity {
    EditText nombre,edad,correo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar);

        nombre=findViewById(R.id.txtNombre);
        edad=findViewById(R.id.txtEdad);
        correo=findViewById(R.id.txtCorreo);
    }

    public void registrar(View v){
        ContentValues contentValues=new ContentValues();
        DatosConexion datosConexion=new DatosConexion(this);
        datosConexion.open();

        contentValues.put("Nombre ",nombre.getText().toString());
        contentValues.put("Edad ",edad.getText().toString());
        contentValues.put("Correo ",correo.getText().toString());

        if(datosConexion.insertar(contentValues))
            Toast.makeText(this,"Se agrego el dato... ",Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this,"No se pudo agregar el dato ",Toast.LENGTH_SHORT).show();
        datosConexion.close();
    }
    public void iragrega(View v){
        Intent intent= new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}
