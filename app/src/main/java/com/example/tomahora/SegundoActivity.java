package com.example.tomahora;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TimePicker;

import java.util.Calendar;

public class SegundoActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnFecha, btnHora, btnAtras;
    EditText eFecha, eHora;
    private int dia, mes, ano, hora, minutos;
    private Spinner spinner1, spiner2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segundo);
        btnFecha=(Button)findViewById(R.id.btnFecha);
        btnHora=(Button)findViewById(R.id.btnHora);
        btnAtras=(Button)findViewById(R.id.btnAtras);
        eFecha=(EditText)findViewById(R.id.eFecha);
        eHora=(EditText)findViewById(R.id.eHora);
        btnFecha.setOnClickListener(this);
        btnHora.setOnClickListener(this);
        btnAtras.setOnClickListener(this);
        spinner1=(Spinner)findViewById(R.id.spinner1);
        spiner2=(Spinner)findViewById(R.id.spinner2);

        String [] opciones1 = {"Cardiologia","Nutriologia","Pediatria","Reumatologia","Ginecologia","Radiologia"};
        String [] opciones2 = {"Centro Santiago-Centro","Centro Vina","Centro Providencia","Centro Las Condes"};
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opciones1);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opciones2);
        spinner1.setAdapter(adapter1);
        spiner2.setAdapter(adapter2);

        btnAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SegundoActivity.this,confirmar.class);
                startActivity(i);
            }
        });



    }

    @Override
    public void onClick(View v) {
        if (v == btnFecha) {
            final Calendar c = Calendar.getInstance();
            dia = c.get(Calendar.DAY_OF_MONTH);
            mes = c.get(Calendar.MONTH);
            ano = c.get(Calendar.YEAR);
            DatePickerDialog datePickerDialog= new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    eFecha.setText(dayOfMonth+"/"+(month+1)+"/"+year);

                }

            }
            ,dia,mes,ano);
            datePickerDialog.show();
        }

        if(v==btnHora)
        {
            final Calendar c= Calendar.getInstance();
            hora=c.get(Calendar.HOUR_OF_DAY);
            minutos=c.get(Calendar.MINUTE);
            TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    eHora.setText(hourOfDay+":"+minute);

                }
            },hora,minutos,false);
            timePickerDialog.show();

        }


    }
}
