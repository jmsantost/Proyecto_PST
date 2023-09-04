package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.TextView;

import androidx.core.view.WindowCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.myapplication.databinding.ActivityMain2Binding;

public class MainActivity2 extends AppCompatActivity {
    private TextView nombreEspecieTextView, temperaturaGradosTextView, incubacionTextView, sensorTV;
    private BluetoothManager bluetoothManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        nombreEspecieTextView = findViewById(R.id.nombreEspecie);
        temperaturaGradosTextView = findViewById(R.id.temperaturaGrados);
        incubacionTextView = findViewById(R.id.incubacion);

        // Obtén los datos enviados desde la actividad principal
        Intent intent = getIntent();
        String especie = intent.getStringExtra("especie");
        int temperatura = intent.getIntExtra("temperatura", 0);
        int incubacionDias = intent.getIntExtra("incubacionDias", 0);
        // Configura los valores en las vistas
        nombreEspecieTextView.setText(especie);
        temperaturaGradosTextView.setText(String.valueOf(temperatura) + " °C");
        incubacionTextView.setText(String.valueOf(incubacionDias) + " días");

    }

    public void volver(View view) {

        finish();
    }
}