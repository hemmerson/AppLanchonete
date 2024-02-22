package com.example.app_lanchonete;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ActivityCafe extends AppCompatActivity {

    private EditText editTextQuantidadeCafe;
    private Button buttonAdicionar;
    private Double valores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cafe);

        editTextQuantidadeCafe = findViewById(R.id.editTextCafe);
        buttonAdicionar = findViewById(R.id.buttonAdicionar);

        Intent intent = getIntent();
        if (intent != null) {
            valores = intent.getDoubleExtra("valores", 0);
            int quantidade = (int)(valores / 2.5);
            editTextQuantidadeCafe.setText(String.valueOf(quantidade));
        }

        buttonAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calcular();
            }
        });
    }//onCreate

    private void calcular() {
        int unidade = Integer.parseInt(editTextQuantidadeCafe.getText().toString());
        double total = unidade * 2.5;
        Intent intent = new Intent(ActivityCafe.this, MainActivity.class);
        intent.putExtra("total", total);
        startActivity(intent);
    }//calcular
}