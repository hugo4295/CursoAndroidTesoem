package mx.edu.tesoem.curso.app1curso;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import Objetos.Datos;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn1, btn2;
    EditText txtnombre,txtedad;

    ActivityResultLauncher<Intent> ResultadoActividad = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            if (result.getResultCode() == Activity.RESULT_OK){
                Toast.makeText(MainActivity.this, "Se termino la actividad de forma correcta...", Toast.LENGTH_SHORT).show();
                Intent datos = result.getData();
                String cadena = datos.getStringExtra("valor");
                Toast.makeText(MainActivity.this, "se regreso el contenido: " + cadena, Toast.LENGTH_LONG).show();
            } else if (result.getResultCode() == Activity.RESULT_CANCELED){
                Toast.makeText(MainActivity.this, "Se cancelo la actividad", Toast.LENGTH_SHORT).show();
            }
        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.btnLanzap1);
        btn2 = findViewById(R.id.btnLanzap2);

        txtnombre = findViewById(R.id.txtnombre);
        txtedad = findViewById(R.id.txtedad);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Presionaste el boton 1", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this,SegundoActivity.class);
                intent.putExtra("nombre",txtnombre.getText().toString());
                intent.putExtra("numero", Integer.parseInt(txtedad.getText().toString()));
                startActivity(intent);
            }
        });

        btn2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnLanzap2: btn2lanza();
                break;
        }
    }

    private void btn2lanza(){

        Datos datos = new Datos();
        datos.setNombre("Victor hugo");
        datos.setEdad(45);
        datos.setCorreo("personal@personal.com");
        Intent intent = new Intent(this, TercerActivity.class);
        intent.putExtra("datosparce",datos);
        ResultadoActividad.launch(intent);
    }
}