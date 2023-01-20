package com.example.admindashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class login extends AppCompatActivity {
    TextView username,password;
    Button loginButton,signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        loginButton = findViewById(R.id.loginButton);
        signup=findViewById(R.id.regisButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (username.getText().toString().equals("ibrahim75") && password.getText().toString().equals("1234")) {
                    Toast.makeText(login.this, "Login Successful!", Toast.LENGTH_SHORT).show();
                    Intent regisIntent=new Intent (login.this,MainActivity.class);
                    startActivity(regisIntent);
                } else {
                    Toast.makeText(login.this, "Login Failed!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent regisIntent=new Intent (login.this,registration.class);
                startActivity(regisIntent);
            }
        });
    }
}