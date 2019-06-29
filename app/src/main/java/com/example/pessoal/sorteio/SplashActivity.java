package com.example.pessoal.sorteio;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ProgressBar;

public class SplashActivity extends AppCompatActivity {

    //variável fixa para definir o tempo o progressBar
    static final int TIMER = 5000;
    boolean ativa;

    //Declarando as variáveis recipientes
    ProgressBar barra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //fazendo a ligação com os elementos da view
        barra = findViewById(R.id.progressBar);

        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(getBaseContext(), MainActivity.class));
                finish();
            }
        }, 5000);

        final Thread timerThread = new Thread(){
            @Override
            public void run(){
                ativa = true;
                try{
                    int espere = 0;
                    while(ativa && (espere < TIMER)){
                        sleep(250);
                        if(ativa){
                            espere += 300;
                            updateProgress(espere);
                        }
                    }
                } catch (InterruptedException e){
                    //caso erro!!!

                }
            }

        };

        timerThread.start();
    }

    public void updateProgress(final int tempoDecorrido){
        if(null != barra){
            final int progresso = barra.getMax() * tempoDecorrido / TIMER;
            barra.setProgress(progresso);
        }
    }
}
