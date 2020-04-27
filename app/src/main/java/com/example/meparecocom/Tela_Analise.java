package com.example.meparecocom;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

public class Tela_Analise extends AppCompatActivity {

    TextView txtPareceCom;
    ArrayList<String> imagens = new ArrayList<String>();
    ImageView fotoPessoa;
    ImageView fotoSorteada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela__analise);

        txtPareceCom = findViewById(R.id.txtPareceCom);

        imagens.add("angelina");
        imagens.add("caixao");
        imagens.add("deadpool");
        imagens.add("mia");
        imagens.add("terry");

        fotoPessoa = findViewById(R.id.imgPessoa);
        fotoSorteada = findViewById(R.id.imgSorteada);
        txtPareceCom.setText("");
    }

    public void sorteiaImagem(){
        String nome = getIntent().getStringExtra("nome");

        Random random = new Random();
        int max = 5;
        int numSorteado = random.nextInt(max);

        this.encontrarImagem(numSorteado);
        txtPareceCom.setText(nome + " você separece com " + imagens.get(numSorteado));
    }

    public void onFotoClick(View view){
        Intent capturarFoto = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(capturarFoto, 1);
    }

    public void encontrarImagem(int num){
        switch (num) {
            case 0:
                fotoSorteada.setImageDrawable(getResources().getDrawable(R.drawable.angelina));
                break;
            case 1:
                fotoSorteada.setImageDrawable(getResources().getDrawable(R.drawable.caixao));
                break;
            case 2:
                fotoSorteada.setImageDrawable(getResources().getDrawable(R.drawable.deadpool));
                break;
            case 3:
                fotoSorteada.setImageDrawable(getResources().getDrawable(R.drawable.mia));
                break;
            case 4:
                fotoSorteada.setImageDrawable(getResources().getDrawable(R.drawable.terry));
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 1 && resultCode == RESULT_OK){
            Bitmap img = (Bitmap) data.getExtras().get("data");
            fotoPessoa.setImageBitmap(img);
            this.sorteiaImagem();
        }
    }
}
