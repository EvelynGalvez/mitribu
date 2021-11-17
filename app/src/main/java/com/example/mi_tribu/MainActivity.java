package com.example.mi_tribu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {
    private TextInputLayout til_user, til_pass;
    private Button btn_login, btn_register, btn_accept;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        til_user = findViewById(R.id.til_user);
        til_pass = findViewById(R.id.til_password);
        btn_login = findViewById(R.id.btn_login);
        btn_register = findViewById(R.id.btn_register);
        btn_accept = findViewById(R.id.btn_accept);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = til_user.getEditText().getText().toString();
                String pass = til_pass.getEditText().getText().toString();
                Toast.makeText(MainActivity.this, "User: "+user+ "Pass: "+pass, Toast.LENGTH_SHORT).show();
            }
        });

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), Register.class);
                startActivity(intent);
            }
        });

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Validate validate = new Validate();
                String user = til_user.getEditText().getText().toString();
                String pass = til_pass.getEditText().getText().toString();
                validarDatos();
                if(validarDatos() == 0) {
                    Intent intent = new Intent(view.getContext(), Dashboard.class);
                    startActivity(intent);
                }



            }



        });
    }

    //Validación campos
    private int validarDatos(){
        Validate validate = new Validate();
        int contador = 0;
        String user = til_user.getEditText().getText().toString();
        String pass = til_pass.getEditText().getText().toString();
        if(validate.validarNulo(user)) {
            if (validate.validarCorreo(user)) {
                til_user.setError(null);
            } else {
                til_user.setError(getString(R.string.error_mail_wrongformat));
                contador++;
            }
        }
        else {
            til_user.setError(getString(R.string.error_mail_null));
            contador++;
        }
        if(validate.validarNulo(pass)){
                til_pass.setError(null);
            }
            else {
                til_pass.setError(getString(R.string.error_pass_null));
                contador++;
            }
        return contador;

    }

}