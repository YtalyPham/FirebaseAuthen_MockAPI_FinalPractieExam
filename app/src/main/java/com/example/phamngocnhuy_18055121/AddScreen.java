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

public class AddScreen extends AppCompatActivity {
    public Button btnSave,btnCancel;
    public EditText eName,eClass,eStatus,eWorking;
    String url = "https://60ade6ee80a61f0017331e32.mockapi.io/studentThi/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_screen);

        btnSave=findViewById(R.id.btnCreateS6);
        btnCancel=findViewById(R.id.btnBackS6);

        eName=findViewById(R.id.eNameS6);
        eClass=findViewById(R.id.eClassS6);
        eStatus=findViewById(R.id.eStatusS6);
        eWorking=findViewById(R.id.eWorkingS6);

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AddScreen.this, MainActivity.class));
            }
        });
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PostApi(url);
                startActivity(new Intent(AddScreen.this, MainActivity.class));
            }
        });

    }
    private void PostApi(String url){
        StringRequest stringRequest = new StringRequest(
                Request.Method.POST,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        Toast.makeText(AddScreen.this, "Successfully", Toast.LENGTH_SHORT).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(AddScreen.this, "Error by Post data!", Toast.LENGTH_SHORT).show();
                    }
                })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                HashMap<String, String>
                        params = new HashMap<>();
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