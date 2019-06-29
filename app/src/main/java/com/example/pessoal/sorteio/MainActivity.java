package com.example.pessoal.sorteio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int aleatorio;

    //Declarando as variáveis recipientes
    EditText inicio;
    EditText fim;
    Button btnSorteio;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //fazendo a ligação com os elementos da view
        inicio = findViewById(R.id.v1_edit);
        fim = findViewById(R.id.v2_edit);
        btnSorteio = findViewById(R.id.btnResultado);
        result = findViewById(R.id.tvResultado);

        //método disparado pelo click do botão
        btnSorteio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //validação para caso os campos estejam vazios, é feita antes de tentar obter os dados
                if(inicio.getText().toString().trim().equals("") || fim.getText().toString().trim().equals("")){

                    //Toast serve para exibir msg rápidas e temporais no rodapé do aparelho
                    Toast.makeText(MainActivity.this,"Valores Incorretos",Toast.LENGTH_LONG).show();
                    result.setText(getResources().getString(R.string.res));

                }else{

                    int num1 = Integer.parseInt(inicio.getText().toString());
                    int num2 = Integer.parseInt(fim.getText().toString());

                    Random r = new Random();
                    aleatorio = r.nextInt((num2 - num1)+ 1) + num1;
                    String ale = Integer.toString(aleatorio);
                    result.setText(ale);
                }
            }
        });
    }

    //método para INFLAR o menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    //Verifica qual item do menu foi selecionado
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_sobre:
                Intent i = new Intent(MainActivity.this, SobreActivity.class);
                startActivity(i);

                //Toast.makeText(this,"Desenvolvido Por WES", Toast.LENGTH_LONG).show();
        }

        return super.onOptionsItemSelected(item);
    }
}
