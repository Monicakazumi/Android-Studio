package br.com.alfaumuarama.monicakazumifujiharufujibayashi;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class CalcularActivity extends AppCompatActivity {

    Button btnCalcular;
    EditText edtNota1, edtNota2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcular);

        edtNota1 = findViewById(R.id.edtNota1);
        edtNota2 = findViewById(R.id.edtNota2);

        btnCalcular = findViewById(R.id.btnCalcular);
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Boolean isValido = true;

                if (edtNota1.getText().toString() == null ||
                        edtNota1.getText().toString().trim().length() == 0){
                    isValido = false;
                    edtNota1.setError(getString(R.string.msg_erro_campo_vazio));
                }
                if (edtNota2.getText().toString() == null ||
                        edtNota2.getText().toString().trim().length() == 0){
                    isValido = false;
                    edtNota2.setError(getString(R.string.msg_erro_campo_vazio));
                }
                if(isValido) {
                    calcular();
                }
            }
        });
    }

    private void calcular(){
        double valorNota1 = Double.parseDouble(edtNota1.getText().toString());
        double valorNota2 = Double.parseDouble(edtNota2.getText().toString());
        if (valorNota1 == 0 || valorNota2 == 0){
            mostrarErro("Primeira Nota e Segunda Nota!");
        } else {
            double resultado = (valorNota1 + valorNota2) / 2;

            if (resultado >= 70.0) {
                mostrarMensagem( resultado + " - Você está APROVADO! ");
            } else {
                mostrarMensagem( resultado + " - Você está REPROVADO! ");
            }

        }
    }

    private void mostrarMensagem(String texto){
        Toast.makeText(this, texto, Toast.LENGTH_LONG).show();
        AlertDialog.Builder alerta = new AlertDialog.Builder(this);
        alerta.setTitle("A Média é: ");
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