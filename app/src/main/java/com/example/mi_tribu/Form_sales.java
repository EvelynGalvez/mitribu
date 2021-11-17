package com.example.mi_tribu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Form_sales extends AppCompatActivity {
    private Button btn_send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_sales);
        btn_send = findViewById(R.id.btn_send);


    }
}