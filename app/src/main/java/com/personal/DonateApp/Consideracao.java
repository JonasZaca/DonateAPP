package com.personal.DonateApp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class Consideracao extends AppCompatActivity {

    TextView  txtConsidera;
    TextView txtNome1;
    TextView txtNome2;
    TextView txtNome3;
    TextView txtNome4;
    TextView txtNome5;
    TextView txtNome6;
    ImageView imageView;
    Button btnVolta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.consideracao);

        txtConsidera = findViewById(R.id.txtConsidera);
        txtNome1 = findViewById(R.id.txtNome1);
        txtNome2 = findViewById(R.id.txtNome2);
        txtNome3 = findViewById(R.id.txtNome3);
        txtNome4 = findViewById(R.id.txtNome4);
        txtNome5 = findViewById(R.id.txtNome5);
        txtNome6 = findViewById(R.id.txtNome6);
        imageView = findViewById(R.id.imageView);
        btnVolta = findViewById(R.id.btnVolta);
    }

    public void voltarTela1(View view) {
        Intent intentVolta = new Intent(getApplicationContext(), Intermedia.class);
        startActivity(intentVolta);
    }
}
