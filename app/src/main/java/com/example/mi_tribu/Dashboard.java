package com.example.mi_tribu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.text.Normalizer;

public class Dashboard extends AppCompatActivity {
    private Button btn_prueba;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        btn_prueba = findViewById(R.id.btn_prueba);

        btn_prueba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), Form_sales.class);
                startActivity(intent);
            }
        });
    }
}