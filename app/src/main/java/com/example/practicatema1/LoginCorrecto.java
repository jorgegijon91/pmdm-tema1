package com.example.practicatema1;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginCorrecto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login_correcto);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Recuperar nombre de la actividad Login
        String nombre = getIntent().getStringExtra("Nombre");
        //Recuperar el texto de la vista
        TextView textoBienvenido = findViewById(R.id.textBienvenido);
        //Settear el texto
        textoBienvenido.setText("Bienvenido: " + nombre);

        //Recuperar el imageButton
        ImageButton imageWeb = findViewById(R.id.imageButton);


        imageWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent actionView y le pasamos la url
                Intent intentUrl = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.tutorialspoint.com/android/android_intents_filters.htm"));
                startActivity(intentUrl);

            }
        });

        //Recuperar el botón de alarma
        Button alarma = findViewById(R.id.buttonAlarma);

        alarma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Pasar a otra actividad
                Intent intent3 = new Intent(LoginCorrecto.this, CrearAlarma.class);
                startActivity(intent3);
            }
        });
    }
}

