package com.personal.DonateApp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.scaledrone.lib.Listener;
import com.scaledrone.lib.Message;
import com.scaledrone.lib.Room;
import com.scaledrone.lib.RoomListener;
import com.scaledrone.lib.Scaledrone;

import java.util.Random;

public class Doacao extends AppCompatActivity {

    double valor,saldo = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doacao);

        TextView viewSaldo = (TextView)findViewById(R.id.txtSaldo);

        final EditText edtValor = (EditText)findViewById(R.id.edtxtValor);

        Button btnDoar = (Button)findViewById(R.id.btnDoar);
        Button btnDepositar = (Button)findViewById(R.id.btnDepositar);

        viewSaldo.setText("Saldo R$: "+saldo);

        btnDoar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edtValor.length() == 0){
                    edtValor.setError("Insira algum valor");
                }else{

                    valor = Double.parseDouble(edtValor.getText().toString());

                    if( saldo < valor || 0 >= saldo || valor <= 0){

                        Context context = getApplicationContext();

                        CharSequence text = "Saldo incompatível, deposite mais ! ";
                        int duration = Toast.LENGTH_LONG;

                        Toast toast = Toast.makeText(context, text, duration);
                        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                        toast.show();
                        edtValor.setText("");

                    }
                    else{
                        Context context = getApplicationContext();

                        CharSequence text = "Doação realizado com sucesso ! " + edtValor.getText();
                        int duration = Toast.LENGTH_LONG;

                        Toast toast = Toast.makeText(context, text, duration);
                        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                        toast.show();

                        saldo = (saldo - Double.parseDouble(edtValor.getText().toString()));

                        TextView viewSaldo = (TextView)findViewById(R.id.txtSaldo);
                        viewSaldo.setText("Saldo R$: "+saldo);
                        edtValor.setText("");

                    }

                }
            }
        });

        btnDepositar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edtValor.length() == 0){
                    edtValor.setError("Insira algum valor");
                }else{

                    valor = Double.parseDouble(edtValor.getText().toString());

                    Context context = getApplicationContext();

                    CharSequence text = "Deposito realizado com sucesso ! " + edtValor.getText();
                    int duration = Toast.LENGTH_LONG;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                    toast.show();

                    saldo = (saldo + Double.parseDouble(edtValor.getText().toString()));

                    TextView viewSaldo = (TextView)findViewById(R.id.txtSaldo);
                    viewSaldo.setText("Saldo R$: "+saldo);
                    edtValor.setText("");

                }
            }
        });

    }

}
