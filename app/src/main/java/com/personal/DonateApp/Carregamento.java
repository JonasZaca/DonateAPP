package com.personal.DonateApp;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Handler;

public class Carregamento extends AppCompatActivity {

    private ProgressBar progressBarAnimation;
    private ObjectAnimator progressAnimator;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.carregamento);

        init();

        progressAnimator.setDuration(5000);

        progressAnimator.start();


        progressAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                Toast.makeText(getBaseContext(),"Entrando",Toast.LENGTH_SHORT).show();
                progressBarAnimation.setVisibility(View.GONE);
                proximaTela();
            }
        });


    }

    //necessario alterar a proxima tela pois vai entrar intent nova
    private void proximaTela() {
        Intent intent = new Intent(this, Intermedia.class);
        startActivity(intent);
    }

    private void init(){
        progressBarAnimation = findViewById(R.id.progressBar);
        progressAnimator = ObjectAnimator.ofInt(progressBarAnimation,"progress",0,100);
    }

}
