package com.example.mi_tribu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {
    private TextInputLayout til_user, til_pass;
    private Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        til_user = findViewById(R.id.til_user);
        til_pass = findViewById(R.id.til_password);
        btn_login = findViewById(R.id.btn_login);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = til_user.getEditText().getText().toString();
                String pass = til_pass.getEditText().getText().toString();
                Toast.makeText(MainActivity.this, "User: "+user+ "Pass: "+pass, Toast.LENGTH_SHORT).show();
            }
        });
    }
}