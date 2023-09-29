package com.example.calculo_imc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import org.jetbrains.annotations.Nullable;

public class MainActivity extends AppCompatActivity {

    Button btnTelaCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnTelaCalcular = findViewById(R.id.btnTelaCalcular);
        btnTelaCalcular.setOnClickListener(new View.OnClickListener() {
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