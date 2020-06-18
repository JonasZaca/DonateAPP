package com.personal.DonateApp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Intermedia extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intermedia);

        Button bt1 = (Button) findViewById(R.id.btDoar);
        Button bt2 = ( Button) findViewById(R.id.btChat);
        TextView view = (TextView) findViewById(R.id.textView);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intente = new Intent(Intermedia.this, Doacao.class);
                    startActivity(intente);

            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intente = new Intent(Intermedia.this, MainActivity.class);
                startActivity(intente);

            }
        });
    }

//    public void Doando(View view) {
//        Intent intente = new Intent(Intermedia.this, Doacao.class);
//            startActivity(intente);
//    }
//
//    public void ChatAberto(View view) {
//        Intent intente = new Intent(Intermedia.this, MainActivity.class);
//        startActivity(intente);
//    }
}
