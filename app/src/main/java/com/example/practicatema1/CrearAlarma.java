package com.example.practicatema1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CrearAlarma extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_crear_alarma);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });




        //Recuperar el botón de la alarma
        Button buttonAlarma = findViewById(R.id.buttonCrearAlarma);
        buttonAlarma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Recuperar el texto de la vista
                EditText textoNombre = findViewById(R.id.editTextNombreAlarma);
                EditText textoHora = findViewById(R.id.editTextHora);
                EditText textoMinutos = findViewById(R.id.editTextMinutos);

                //Recuperar el editText
                String mensaje = textoNombre.getText().toString();
                int hora = Integer.parseInt(textoHora.getText().toString());
                int minutos = Integer.parseInt(textoMinutos.getText().toString());
                //Intent alarma
                Intent intentAlarma = new Intent(AlarmClock.ACTION_SET_ALARM)
                        .putExtra(AlarmClock.EXTRA_MESSAGE, mensaje)
                        .putExtra(AlarmClock.EXTRA_HOUR, hora)
                        .putExtra(AlarmClock.EXTRA_MINUTES, minutos);
                //Si el mensaje no esta vacío y la hora y minutos están en rango correcto, comenzar
                if(mensaje.isEmpty() || hora < 0 || hora > 23 || minutos < 0 || minutos > 59){
                    //Toast de datos incorrectos
                    Toast.makeText(CrearAlarma.this, "Datos incorrectos", Toast.LENGTH_SHORT).show();
                }
                startActivity(intentAlarma);




        }
    });
    }
}