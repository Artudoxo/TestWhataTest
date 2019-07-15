package com.liarkat.testwhatatest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Resultado extends AppCompatActivity {
    Button btnvolver;
    TextView txtvolver, txtmensaje;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);
        btnvolver = findViewById(R.id.btnvolver);

        btnvolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Volver();
            }
        });
    }

    public void Volver(){
        Intent volver = new Intent(this, MainActivity.class);
        startActivity(volver);
    }
}
