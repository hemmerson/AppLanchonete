package com.example.app_lanchonete;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ImageView imageViewCafe;
    private ImageView imageViewBolo;
    private Button buttonCalcular;
    private TextView textViewResultado;
    private double valores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageViewCafe = findViewById(R.id.imageViewCoffee);
        imageViewBolo = findViewById(R.id.imageViewCake);
        buttonCalcular = findViewById(R.id.buttonCalcular);
        textViewResultado = findViewById(R.id.textViewResultado);

        Intent intent = getIntent();
        if (intent != null){
            double valor = intent.getDoubleExtra("total",0);
            valores = valores + valor;
        }
    }

    public void escolher(View view){
        Intent intent = null;
        if (R.id.imageViewCoffee == view.getId()){
            intent = new Intent(MainActivity.this, ActivityCafe.class);
            if (valores != 0){
                intent.putExtra("valores", valores);
            }
            startActivity(intent);
        }
        if (R.id.imageViewCake == view.getId()){}
        if (R.id.buttonCalcular == view.getId()){
            textViewResultado.setText(String.valueOf(valores));
        }
    }
}