package com.example.phamngocnhuy_18055121;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ShowInfoScreen extends AppCompatActivity {
    Button btnBack;

    RecyclerView reView;
    RecyclerAdapter adapter;

    RecyclerView.LayoutManager layoutManager;
    ArrayList<Student> list = new ArrayList<>();
    String url = "https://60ade6ee80a61f0017331e32.mockapi.io/studentThi/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_info_screen);
        GetArrayJson(url);
        btnBack=findViewById(R.id.btnBackS3);
        reView=findViewById(R.id.reView);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ShowInfoScreen.this, MainActivity.class));
            }
        });

    }
    private void GetArrayJson(String url){
        JsonArrayRequest jsonArrayRequest =
                new JsonArrayRequest(url,
                        new Response.Listener<JSONArray>() {
                            @Override
                            public void onResponse(JSONArray response) {

                                for(int i=0; i<response.length(); i++){
                                    try {
                                        JSONObject object = (JSONObject) response.get(i);
                                        Student s = new Student();
                                        s.setId(object.getString("id"));
                                        s.setName(object.getString("name"));
                                        s.setClasshoc(object.getString("class"));
                                        s.setStatus(object.getString("status"));
                                        s.setWorkingAt(object.getString("working"));
                                        list.add(s);
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                }

                                adapter = new RecyclerAdapter(list,ShowInfoScreen.this);
                                reView.setAdapter(adapter);
                                reView.setLayoutManager(new GridLayoutManager(ShowInfoScreen.this,1));
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(ShowInfoScreen.this, "Error by get Json Array!", Toast.LENGTH_SHORT).show();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonArrayRequest);
    }
}