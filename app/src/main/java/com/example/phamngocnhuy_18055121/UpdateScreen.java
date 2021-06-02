package com.example.phamngocnhuy_18055121;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class UpdateScreen extends AppCompatActivity {
    public String id="",name,classhoc,status,working;
    public Button btnSave,btnCancel;
    public EditText eName,eClass,eStatus,eWorking;
    String url = "https://60ade6ee80a61f0017331e32.mockapi.io/studentThi/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_screen);

        btnSave=findViewById(R.id.btnSaveS5);
        btnCancel=findViewById(R.id.btnBackS5);

        eName=findViewById(R.id.eNameS5);
        eClass=findViewById(R.id.eClassS5);
        eStatus=findViewById(R.id.eStatusS5);
        eWorking=findViewById(R.id.eWorkingAtS5);

        id=getIntent().getStringExtra("id");
        name=getIntent().getStringExtra("name");
        classhoc=getIntent().getStringExtra("classhoc");
        status=getIntent().getStringExtra("status");
        working=getIntent().getStringExtra("working");

        eName.setText(name);
        eClass.setText(classhoc);
        eStatus.setText(status);
        eWorking.setText(working);


        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UpdateScreen.this, ShowInfoScreen.class));
            }
        });


        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UpdateApi(url);
                startActivity(new Intent(UpdateScreen.this, ShowInfoScreen.class));
            }
        });



    }
    private void UpdateApi(String url){
        StringRequest stringRequest = new StringRequest(
                Request.Method.PUT, url + '/' + id, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Toast.makeText(UpdateScreen.this, "Successfully", Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(UpdateScreen.this, "Error by Post data!", Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> params = new HashMap<>();
                params.put("name", eName.getText().toString().trim());
                params.put("class", eClass.getText().toString().trim());
                params.put("status", eStatus.getText().toString().trim());
                params.put("working", eWorking.getText().toString().trim());
                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}