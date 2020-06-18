package com.personal.DonateApp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Logando extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button bt1 = (Button) findViewById(R.id.logar);


        //setar user e senha desejado
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editUser = findViewById(R.id.editUser);
                EditText editPass = findViewById(R.id.editPass);
                String user = editUser.getText().toString();
                String pass = editPass.getText().toString();
                if (user.equals("adm@doacao.com") && pass.equals("12345")){
                    Toast.makeText(Logando.this, "Login Realizado com sucesso", Toast.LENGTH_SHORT).show();
                    Intent intente = new Intent(Logando.this, Carregamento.class);
                    startActivity(intente);
                } else {
                    Toast.makeText(Logando.this, "User ou senha incorretos", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

//    public void logando(View view) {
//        EditText editUser = (EditText) findViewById(R.id.editUser);
//        EditText editPass = (EditText) findViewById(R.id.editPass);
//        String user = editUser.getText().toString();
//        String pass = editPass.getText().toString();
//        if (user.equals("adm@doacao.com") && pass.equals("123456")){
//            Toast.makeText(Logando.this, "Login Realizado com sucesso", Toast.LENGTH_SHORT).show();
//            Intent intente = new Intent(Logando.this, Carregamento.class);
//            startActivity(intente);
//        } else {
//            Toast.makeText(Logando.this, "User ou senha incorretos", Toast.LENGTH_LONG).show();
//        }
//    }
}
