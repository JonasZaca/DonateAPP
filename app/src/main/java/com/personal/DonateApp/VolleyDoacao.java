package com.personal.DonateApp;

import android.content.Context;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class VolleyDoacao {

//    public void resquestDoacao(View v) {
//        RequestQueue queue = Volley.newRequestQueue(v.getContext());
//        String url ="http://localhost:8080/doacaoFinanceiras";
//        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
//                new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String response) {
//                        tratarResposta(response);
//                    }
//                },
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        tratarErro(error.getMessage());
//                    }
//                });
//        queue.add(stringRequest);
//    }

//    private void tratarResposta(String json) {
//        try {
//            List<Doacao> doacoes = new ArrayList<>();
//            JSONArray array = (JSONArray) new JSONTokener(json).nextValue();
//            for (int i = 0; i < array.length(); i++) {
//                JSONObject obj = array.getJSONObject(i);
//                Doacao c = new Doacao();
//                c.setId(obj.getInt("id"));
//                c.setTipoDoacao(obj.getString("tipoDoacao"));
//                c.setValor(Double.valueOf(obj.getString("valor")));
//                c.setQtdProduto(Long.valueOf(obj.getString("qtdProduto")));
//                c.setTipoProduto(obj.getString("tipoProduto"));
//                doacoes.add(c);
//            }
//
//            ListView listView = findViewById(R.id.listaClient);
//            final ArrayAdapter adapter = new ArrayAdapter(this,
//                    android.R.layout.simple_list_item_checked, clientes);
//            listView.setAdapter(adapter);
//            listView.setChoiceMode(listView.CHOICE_MODE_MULTIPLE);
//        } catch (Exception ex) {
//            tratarErro(ex.getMessage());
//        }
//    }

//    private void tratarErro(String message, View v) {
//        Toast.makeText(v.getContext(), message, Toast.LENGTH_LONG);
//    }


    public void enviarServidor(Doacao cliente, View v) throws Exception {

        JSONObject obj = new JSONObject();
        obj.put("id", cliente.getId());
        obj.put("tipoDoacao", cliente.getTipoDoacao());
        obj.put("valor", cliente.getValor());
        obj.put("qtdProduto", cliente.getQtdProduto());
        obj.put("tipoProduto", cliente.getTipoProduto());

        final String json = obj.toString();

        RequestQueue queue = Volley.newRequestQueue(v.getContext());
        String url ="http://192.168.1.101:8080/doacaoFinanceiras";
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                //Recebimento
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        tratarOK();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        System.out.println(error.getMessage());
                    }
                })
        {
            //Envio do JSON
            @Override
            public String getBodyContentType() {
                return "application/json; charset=utf-8";
            }
            @Override
            public byte[] getBody() throws AuthFailureError {
                try {
                    return json.getBytes("utf-8");
                } catch (UnsupportedEncodingException uee) {
                    VolleyLog.wtf("Unsupported Encoding. Bytes of %s using %s", json, "utf-8");
                    throw new AuthFailureError("ERRO");
                }
            }
        };
        queue.add(stringRequest);
    }

    private void tratarErro(String mensagemErro) throws Exception {
        throw new Exception("ERRO");
    }

    private void tratarOK() {
//        finish();
    }

}
