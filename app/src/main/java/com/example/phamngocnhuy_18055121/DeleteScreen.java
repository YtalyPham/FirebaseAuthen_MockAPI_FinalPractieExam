package com.example.phamngocnhuy_18055121;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class DeleteScreen extends AppCompatActivity {
    public String id="";
    public Button btnCancel,btnYes;
    String url = "https://60ade6ee80a61f0017331e32.mockapi.io/studentThi/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_screen);
        id=getIntent().getStringExtra("id");

        btnYes=findViewById(R.id.btnYesS4);
        btnCancel=findViewById(R.id.btnCancelS4);

        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DeleteApi(url);
                recreate();
                startActivity(new Intent(DeleteScreen.this, ShowInfoScreen.class));
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DeleteScreen.this, ShowInfoScreen.class));
            }
        });

    }
    private void DeleteApi(String url){
        StringRequest stringRequest = new StringRequest(
                Request.Method.DELETE, url + '/'+ id.trim(), new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(DeleteScreen.this, "Successfully", Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(DeleteScreen.this, "Error by Post data! " +id, Toast.LENGTH_SHORT).show();
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(DeleteScreen.this);
        requestQueue.add(stringRequest);
    }
}