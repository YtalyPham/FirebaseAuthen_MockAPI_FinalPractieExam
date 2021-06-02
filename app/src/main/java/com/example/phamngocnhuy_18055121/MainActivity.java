package com.example.phamngocnhuy_18055121;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    private Button btnShowStudentS2,btnLogoutS2,btnAddStudentS2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnShowStudentS2=findViewById(R.id.btnShowStudentS2);
        btnAddStudentS2=findViewById(R.id.btnAddStudentS2);
        btnLogoutS2=findViewById(R.id.btnLogoutS2);

        btnShowStudentS2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ShowInfoScreen.class));
            }
        });

        btnAddStudentS2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AddScreen.class));
            }
        });

        btnLogoutS2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(MainActivity.this, LoginScreen.class));
            }
        });

    }
}