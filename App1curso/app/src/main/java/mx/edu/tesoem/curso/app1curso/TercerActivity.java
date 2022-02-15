package mx.edu.tesoem.curso.app1curso;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import Objetos.Datos;

public class TercerActivity extends AppCompatActivity {

    TextView lblnombre, lbledad,lblcorreo;
    Button btnresultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tercer);

        Datos datos = getIntent().getParcelableExtra("datosparce");

        lblnombre = findViewById(R.id.lblnombre);
        lbledad = findViewById(R.id.lbledad);
        lblcorreo = findViewById(R.id.lblcorreo);
        btnresultado = findViewById(R.id.btnresultado);

        lblnombre.setText(datos.getNombre());
        lbledad.setText(String.valueOf(datos.getEdad()));
        lblcorreo.setText(datos.getCorreo());

        btnresultado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("valor", "cadena de regreso");
                setResult(Activity.RESULT_OK,intent);
                finish();
            }
        });

    }
}