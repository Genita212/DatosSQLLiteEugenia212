package ejt.edu.tesoem.genita212.itic.datossqlliteeugenia212;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void iragrega(View v){
        Intent intent= new Intent(this,AgregarActivity.class);
        startActivity(intent);
        finish();
    }
}
