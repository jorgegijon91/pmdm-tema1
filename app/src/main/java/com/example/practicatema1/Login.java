package com.example.practicatema1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Login extends AppCompatActivity {

    private  String NOMBRE_USUARIO = "admin";  // Valor por defecto
    private  String CONTRASENA = "admin";     // Valor por defecto

    ActivityResultLauncher<Intent> credenciales = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                    Intent data = result.getData();

                    // Obtener los nuevos valores del intent
                    String nombre = data.getStringExtra("Nombre");
                    String pass = data.getStringExtra("pass");
                    //Atualizar credenciales
                    if (nombre != null && pass != null) {
                        NOMBRE_USUARIO = nombre;
                        CONTRASENA = pass;
                    }

                }
            });
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
                //Guardamos nombre y pass en un String
                String nombreUsuaro= editTextNombre.getText().toString();
                String passUsuario= editTextPass.getText().toString();

                //Lanzar el intent si los datos de nombre y contraseña son correctos
                if (nombreUsuaro.equals(NOMBRE_USUARIO) && passUsuario.equals(CONTRASENA))  {
                    Intent intent = new Intent(Login.this, LoginCorrecto.class);
                    intent.putExtra("Nombre", editTextNombre.getText().toString());
                    intent.putExtra("pass", editTextPass.getText().toString());
                    startActivity(intent);
                }
                else{
                    //Toast de datos incorrectos
                    Toast.makeText(Login.this, "Datos incorrectos", Toast.LENGTH_SHORT).show();
                }
            }
});

        //Botón para las credenciales
        Button btnCredenciales = findViewById(R.id.buttonModificar);
        btnCredenciales.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(Login.this, ModificarCredenciales.class);
                credenciales.launch(intent2);
            }
        });
    }
}