package com.example.myapplication;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;
import java.lang.CharSequence;
import android.widget.ArrayAdapter;
import android.widget.Spinner;


import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {
    private RadioGroup radioGroupAccountType;
    private EditText editTextEmail, editTextPassword, editTextConfirmPassword;
    private Spinner spinnerCity;
    private Button buttonCreateAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2_login);
        // Initialiser les vues
        radioGroupAccountType = findViewById(R.id.radioGroup2);
        editTextEmail = findViewById(R.id.editTextText2);
        editTextPassword = findViewById(R.id.editTextText3);
        editTextConfirmPassword = findViewById(R.id.editTextText4);
        spinnerCity = findViewById(R.id.spinner);
        buttonCreateAccount = findViewById(R.id.button2);

        // Ajouter un écouteur de clic au bouton "Créer un compte"
        buttonCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createAccount();
            }
        });
    }

    private void createAccount() {
        // Obtenir le type de compte sélectionné
        int selectedRadioButtonId = radioGroupAccountType.getCheckedRadioButtonId();
        RadioButton selectedRadioButton = findViewById(selectedRadioButtonId);
        String accountType = selectedRadioButton.getText().toString();

        // Obtenir l'e-mail, le mot de passe, la confirmation du mot de passe et la ville
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString();
        String confirmPassword = editTextConfirmPassword.getText().toString();
        String city = spinnerCity.getSelectedItem().toString();
        // Valider l'e-mail, le mot de passe et la confirmation du mot de passe
        if (email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            Toast.makeText(this, "Veuillez remplir tous les champs", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!password.equals(confirmPassword)) {
            Toast.makeText(this, "Les mots de passe ne correspondent pas",
                    Toast.LENGTH_SHORT).show();
            return;
        }

        // Effectuer d'autres validations si nécessaire

        // Si tout est valide, procéder à la création du compte
        // Ici, vous pouvez implémenter votre logique de création de compte

        // Par exemple, pour la démonstration, afficher un message toast avec les détails du compte
        String message = "Type de compte: " + accountType + "\n" +
                "E-mail: " + email + "\n" +
                "Ville: " + city + "\n" +
                "Mot de passe: " + password;
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();

        Spinner citySpinner = findViewById(R.id.spinner);
        //Liste des villes
        String[] cities_array = {"Casablanca","Agadir","Fes","Meknes","Assila"};
        //Adapter pour les options du Spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource
                (this,R.array.cities_array,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//Liaison de l'adapter au Spinner
        citySpinner.setAdapter(adapter);
    }}