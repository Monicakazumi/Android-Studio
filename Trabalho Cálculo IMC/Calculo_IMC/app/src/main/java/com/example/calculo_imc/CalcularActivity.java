package com.example.calculo_imc;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class CalcularActivity extends AppCompatActivity {

    Button btnCalcular;
    EditText edtAltura, edtPeso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcular);

        edtAltura = findViewById(R.id.edtAltura);
        edtPeso = findViewById(R.id.edtPeso);

        btnCalcular = findViewById(R.id.btnCalcular);
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Boolean isValido = true;

                if (edtAltura.getText().toString() == null ||
                        edtAltura.getText().toString().trim().length() == 0){
                    isValido = false;
                    edtAltura.setError(getString(R.string.msg_erro_campo_vazio));
                }
                if (edtPeso.getText().toString() == null ||
                        edtPeso.getText().toString().trim().length() == 0){
                    isValido = false;
                    edtPeso.setError(getString(R.string.msg_erro_campo_vazio));
                }
                if(isValido) {
                    calcular();
                }
            }
        });
    }

    private void calcular(){
        double valorAltura = Double.parseDouble(edtAltura.getText().toString());
        double valorPeso = Double.parseDouble(edtPeso.getText().toString());
        if (valorAltura == 0 || valorPeso == 0){
            mostrarErro("Altura e Peso!");
        } else {
            double resultado = (valorPeso / (valorAltura * valorAltura));

            if (resultado < 18.5) {
                mostrarMensagem("Magreza!");
            }
            if ((resultado >= 18.5) && (resultado <= 24.9)) {
                mostrarMensagem("Normal!");
            }
            if ((resultado >= 25) && (resultado <= 29.9)) {
                mostrarMensagem("Sobrepeso!");
            }
            if ((resultado >= 30) && (resultado <= 39.9)) {
                mostrarMensagem("Obesidade!");
            }
            if (resultado >= 40) {
                mostrarMensagem("Obesidade Grave!");
            }
        }
    }

    private void mostrarMensagem(String texto){
        Toast.makeText(this, texto, Toast.LENGTH_LONG).show();
        AlertDialog.Builder alerta = new AlertDialog.Builder(this);
        alerta.setTitle("O Resultado é: ");
        alerta.setMessage(texto);
        alerta.setNeutralButton("OK", null);
        alerta.show();
    }

    private void mostrarErro(String texto){
        AlertDialog.Builder alerta = new AlertDialog.Builder(this);
        alerta.setTitle("Preencha corretamente os campos ");
        alerta.setMessage(texto);
        alerta.setNeutralButton("OK", null);
        alerta.show();
    }
}
