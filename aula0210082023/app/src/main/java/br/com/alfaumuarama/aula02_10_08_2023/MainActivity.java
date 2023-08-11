package br.com.alfaumuarama.aula02_10_08_2023;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Objetos
    Button botaoCalcular;
    EditText edtEtanol, edtGasolina;

    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //aqui que diz para o Java qual a tela (XML) ela vai controlar
        setContentView(R.layout.activity_main);

        //findViewById vem de herança de AppCompatActivity - ae pegamos o caminho do botão - pasta res - id - edtEtanol
        //vinculando os campos do XML com os objetos do JAVA
        edtEtanol = findViewById(R.id.edtEtanol);
        edtGasolina = findViewById(R.id.edtGasolina);
        botaoCalcular = findViewById(R.id.btnCalcular);

        //criando um listener para "ouvir" o click do botao
        botaoCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calcular();
            }
        });

    }

    private void calcular(){
        double valorEtanol = Double.parseDouble(edtEtanol.getText().toString());
        double valorGasolina = Double.parseDouble(edtGasolina.getText().toString());

        double resultado = valorEtanol / valorGasolina;

        if(resultado <= 0.7){
            //melhor etanol
            mostrarMensagem("Melhor abastecer com Etanol!");

        } else{
            //melhor gasolina
            mostrarMensagem("Melhor abastecer com Gasolina!");
        }
    }

    private void mostrarMensagem(String texto){
        //Criando uma mensagem do tipo Toast (alerta na tela)
        Toast.makeText(this, texto, Toast.LENGTH_LONG).show();

        //Criando uma mensagem do tipo modal
        AlertDialog.Builder alerta = new AlertDialog.Builder(this);

        //adicionando um título no alerta(dialog)
        alerta.setTitle("Resultado");

        //adicionando uma mensalem no alerta(dialog)
        alerta.setMessage(texto);

        //adicionando um botão de OK para fechar a mensagem
        alerta.setNeutralButton("OK", null);

        //exibindo o alerta(dialog) na tela
        alerta.show();
    }
}