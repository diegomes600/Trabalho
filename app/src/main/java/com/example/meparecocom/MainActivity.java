package com.example.meparecocom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText edtNome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNome = findViewById(R.id.edtNome);
    }

    public void onClick(View view) {
        String nome = edtNome.getText().toString();

        if (!nome.equals("")) {
            Intent abrirTelaAnalise = new Intent(getApplicationContext(), Tela_Analise.class);
            abrirTelaAnalise.putExtra("nome", nome);
            startActivity(abrirTelaAnalise);
        }
    }
}
