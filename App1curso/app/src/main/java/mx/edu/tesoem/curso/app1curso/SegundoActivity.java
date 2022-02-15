package mx.edu.tesoem.curso.app1curso;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class SegundoActivity extends AppCompatActivity {

    TextView txtsaludo,lblnum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segundo);

        Bundle parametros = getIntent().getExtras();
        String cadena = parametros.getString("nombre");
        int numero = parametros.getInt("numero");

        Log.i("numeros", "que valor se recibe: " + numero);

        txtsaludo = findViewById(R.id.txtsaludo);
        lblnum = findViewById(R.id.txtnumero);

        txtsaludo.setText(cadena);
        lblnum.setText(String.valueOf(numero));
    }
}