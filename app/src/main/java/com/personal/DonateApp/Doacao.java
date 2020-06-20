package com.personal.DonateApp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Doacao extends AppCompatActivity {

    RadioGroup radioGroup;

    RadioButton radioButton;

    Button btnDoar;

    EditText edtValor;
    EditText edtDescri;

    Double valor;
    int selecao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doacao);

        edtValor = findViewById(R.id.edtValor);
        edtDescri = findViewById(R.id.edtDescri);

        radioGroup = findViewById(R.id.radioGroup);

        btnDoar = findViewById(R.id.btnDoar);

        edtValor.setEnabled(false);
        edtDescri.setEnabled(false);
        selecao = 0;

    }

    public void checkButton(View v){

        int radioId = radioGroup.getCheckedRadioButtonId();

        radioButton = findViewById(radioId);

        if(radioId == 2131165321){
            edtValor.setEnabled(true);
            edtDescri.setEnabled(false);
            edtValor.setHint("Valor:");
            edtDescri.setHint("");
            selecao = 1;
        }

        if(radioId == 2131165322){
            edtValor.setEnabled(true);
            edtDescri.setEnabled(true);
            edtValor.setHint("Quantidade:");
            edtDescri.setHint("Qual produto você vai doar:");
            selecao = 2;
        }

    }

    public void clickButton(View v){

        btnDoar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(selecao == 0){

                    Context context1 = getApplicationContext();

                    CharSequence text1 = "Selecione uma opção de doação !";
                    int duration1 = Toast.LENGTH_LONG;

                    Toast toast1 = Toast.makeText(context1, text1, duration1);
                    toast1.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                    toast1.show();

                    edtValor.setText("");
                    edtDescri.setText("");

                }
                else if(edtValor.length() == 0){
                    edtValor.setError("Insira algum valor valido !");
                }
                else if(Double.parseDouble(edtValor.getText().toString()) == 0){
                    edtValor.setError("Insira algum valor valido !");
                }
                else if(edtDescri.length() == 0 && selecao == 2){
                    edtDescri.setError("Descreva o qu você vai doar !");
                }
                else{

                    Context context = getApplicationContext();

                    CharSequence text = "Doação realizada com sucesso !";
                    int duration = Toast.LENGTH_LONG;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                    toast.show();

                    edtValor.setText("");
                    edtDescri.setText("");

                }
            }
        });

    }

}
