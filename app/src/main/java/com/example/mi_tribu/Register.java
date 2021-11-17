package com.example.mi_tribu;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import com.google.android.material.textfield.TextInputLayout;

import java.util.Calendar;

public class Register extends AppCompatActivity {
    TextInputLayout til_name, til_date, til_email, til_pass, til_repeatpass;
    Button btn_accept;
    int mDay, mMonth, mYear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        til_name = findViewById(R.id.til_name);
        til_date = findViewById(R.id.til_date);
        til_email = findViewById(R.id.til_email);
        til_pass = findViewById(R.id.til_pass);
        til_repeatpass = findViewById(R.id.til_repeatpass);
        btn_accept = findViewById(R.id.btn_accept);

        final Calendar calendar = Calendar.getInstance();
        mDay = calendar.get(Calendar.DAY_OF_MONTH);
        mMonth = calendar.get(Calendar.MONTH);
        mYear = calendar.get(Calendar.YEAR);

        til_date.getEditText().setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                DatePickerDialog datePickerDialog = new DatePickerDialog(view.getContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        if(month+1>10){
                            if(day+1>10){
                                til_date.getEditText().setText(day+"/"+(month+1)+"/"+year);
                            }
                            else {
                                til_date.getEditText().setText("0"+day+"/"+(month+1)+"/"+year);
                            }
                        }
                        else {
                            if(day+1>10){
                                til_date.getEditText().setText(day+"/"+(month+1)+"/"+year);
                            }
                            else {
                                til_date.getEditText().setText(day+"/0"+(month+1)+"/"+year);
                            }
                        }
                    }
                }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });

        btn_accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                validarDatos();
            }
        });
    }

    //Validación campos
    private int validarDatos(){
        Validate validate = new Validate();
        int contador = 0;
        String name = til_name.getEditText().getText().toString();
        String date = til_date.getEditText().getText().toString();
        String email = til_email.getEditText().getText().toString();
        String pass = til_pass.getEditText().getText().toString();
        String repeatpass = til_repeatpass.getEditText().getText().toString();

        //Validar name
        if(validate.validarNulo(name)) {
            if (validate.validarNombre(name)) {
                til_name.setError(null);
            } else {
                til_name.setError(getString(R.string.error_name_wrongformat));
                contador++;
            }
        }

        else {
            til_name.setError(getString(R.string.error_text_null));
            contador++;
        }
        //Validar date
        if(validate.validarNulo(date)){
            til_date.setError(null);
        }
        else {
            til_date.setError(getString(R.string.error_text_null));
            contador++;
        }

        //Validar email
        if(validate.validarNulo(email)){
            if (validate.validarCorreo(email)) {
                til_email.setError(null);
            } else {
                til_email.setError(getString(R.string.error_mail_wrongformat));
                contador++;
            }
        }
        else {
            til_email.setError(getString(R.string.error_text_null));
            contador++;
        }

        //Validar pass
        if(validate.validarNulo(pass)){
            til_pass.setError(null);
        }
        else {
            til_pass.setError(getString(R.string.error_text_null));
            contador++;
        }

        //Validar repeatpass
        if(validate.validarNulo(repeatpass)){
            til_repeatpass.setError(null);
        }
        else {
            til_repeatpass.setError(getString(R.string.error_text_null));
            contador++;
        }

        if(repeatpass.equals(pass) && validate.validarNulo(repeatpass) && validate.validarNulo(pass)){
            til_repeatpass.setError(null);
            til_pass.setError(null);
        }
        else {
            if(validate.validarNulo(repeatpass) && validate.validarNulo(pass)){
                til_repeatpass.setError(getString(R.string.error_pass_not_same));
                til_pass.setError(getString(R.string.error_pass_not_same));
                contador++;
            }
        }

        return contador;

    }
}
