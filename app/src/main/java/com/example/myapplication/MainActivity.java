package com.example.myapplication;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText titreEditText, contratEditText, descriptionEditText, villeEditText;
    private Spinner categorieSpinner;

    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.annonce);

        // Initialize Views
        titreEditText = findViewById(R.id.editTextText3);
        contratEditText = findViewById(R.id.editTextText4);
        descriptionEditText = findViewById(R.id.editTextText5);
        villeEditText = findViewById(R.id.Spinner);

        categorieSpinner = findViewById(R.id.imagesTypeSpinner);
        ArrayAdapter<CharSequence> categorieAdapter = ArrayAdapter.createFromResource(this,
                R.array.tabcat, android.R.layout.simple_spinner_item);
        categorieAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        categorieSpinner.setAdapter(categorieAdapter);

        Spinner secteurSpinner = findViewById(R.id.Spinner1);
        // Set up your spinner with appropriate data

        Button suivantButton = findViewById(R.id.button);
        suivantButton.setOnClickListener(v -> {
            // Perform action when "Suivant" button is clicked
            validateForm();
        });
    }

    private void validateForm() {
        // Validation logic for your form fields
        String titre = titreEditText.getText().toString();
        String contrat = contratEditText.getText().toString();
        String description = descriptionEditText.getText().toString();
        String ville = villeEditText.getText().toString();
        String categorie = categorieSpinner.getSelectedItem().toString();

        // You can add your validation logic here
        // For example, check if any of the required fields are empty
        if (titre.isEmpty() || contrat.isEmpty() || description.isEmpty() || ville.isEmpty()) {
            Toast.makeText(this, "Veuillez remplir tous les champs obligatoires", Toast.LENGTH_SHORT).show();
            return;
        }

        // If form is valid, you can proceed further
        // For now, let's just display a toast indicating successful validation
        Toast.makeText(this, "Formulaire valide. Vous pouvez procéder.", Toast.LENGTH_SHORT).show();
    }
}

