package com.example.myapplication;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    EditText emailEditText, passwordEditText;
    Button loginButton;
    CheckBox rememberCheckbox;
    TextView footerText;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailEditText = findViewById(R.id.email_edittext);
        passwordEditText = findViewById(R.id.password_edittext);
        loginButton = findViewById(R.id.login_button);
        rememberCheckbox = findViewById(R.id.remember_checkbox);
        footerText = findViewById(R.id.register_link);

        loginButton.setOnClickListener(v -> {
            String email = emailEditText.getText().toString();
            String password = passwordEditText.getText().toString();
            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(LoginActivity.this, "Veuillez remplir tous les champs", Toast.LENGTH_SHORT).show();
            } else {
                // Vérification de l'email et du mot de passe
                if (email.equals("votre@email.com") && password.equals("votremotdepasse")) {
                    // Connectez-vous avec succès, vous pouvez naviguer vers l'activité suivante
                    Toast.makeText(LoginActivity.this, "Connexion réussie", Toast.LENGTH_SHORT).show();
                    // Ici, vous pouvez ajouter du code pour naviguer vers l'activité suivante
                } else {
                    Toast.makeText(LoginActivity.this, "Email ou mot de passe incorrect", Toast.LENGTH_SHORT).show();
                }
            }
        });
        footerText.setOnClickListener(v -> {
            // Naviguez vers l'activité d'inscription
            // Ici, vous pouvez ajouter du code pour naviguer vers l'activité d'inscription
            Toast.makeText(LoginActivity.this, "Naviguer vers l'écran d'inscription", Toast.LENGTH_SHORT).show();
   });
}
}