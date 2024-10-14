package com.example.practicatema1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Recuperar el botón de la vista
        Button btnIniciar = findViewById(R.id.buttonIniciar);
        EditText editTextNombre = findViewById(R.id.editTextNombre);
        EditText editTextPass = findViewById(R.id.editTextPassword);
        //Añadir un OnClickListener al elemento
        btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Si el usuario y contraseña es admin
                if(editTextNombre.getText().toString().equals("admin") && editTextPass.getText().toString().equals("admin")) {
                    Intent intent = new Intent(Login.this, LoginCorrecto.class);
                    startActivity(intent);
                }
                else{
                    //Toast de datos incorrectos
                    Toast.makeText(Login.this, "Datos incorrectos", Toast.LENGTH_SHORT).show();
                }
            }
});
    }
}