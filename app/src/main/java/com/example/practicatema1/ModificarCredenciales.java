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

public class ModificarCredenciales extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_modificar_credenciales);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        //Guardar cambios
        Button btnGuardar = findViewById(R.id.buttonGuardar);
        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Recuperar textos
                EditText nuevoNombre = findViewById(R.id.editTextNuevoNombre);
                EditText nuevaPass = findViewById(R.id.editTextNuevaPass);
                // Obtener los nuevos valores introducidos por el usuario
                String nuevoNombreValor = nuevoNombre.getText().toString();
                String nuevaPassValor = nuevaPass.getText().toString();

                // Crear un intent para devolver los datos a la primera actividad
                Intent intentNuevo = new Intent(ModificarCredenciales.this, LoginCorrecto.class);
                intentNuevo.putExtra("Nombre", nuevoNombreValor);
                intentNuevo.putExtra("pass", nuevaPassValor);

                //Toast para asegurar los cambios
                Toast.makeText(ModificarCredenciales.this, "Credenciales modificadas", Toast.LENGTH_SHORT).show();
                // Devolver los datos a la primera actividad
                setResult(RESULT_OK, intentNuevo);
                finish();
            }
        });
    }
}

