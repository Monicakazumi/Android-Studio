package br.com.alfaumuarama.monicakazumifujiharufujibayashi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnNotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNotas = findViewById(R.id.btnNotas);
        btnNotas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirTelaCalcular();
            }
        });
    }

    private void abrirTelaCalcular(){
        Intent telaCalcular = new Intent(MainActivity.this, CalcularActivity.class);
        startActivity(telaCalcular);
    }
}