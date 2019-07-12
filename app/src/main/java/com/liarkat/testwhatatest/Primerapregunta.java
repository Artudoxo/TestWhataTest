package com.liarkat.testwhatatest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Primerapregunta extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primerapregunta);
    }

    public void right(View button)
    {
        startActivity(new Intent(this, MainActivity.class));
        overridePendingTransition(R.anim.right_in, R.anim.right_out);
    }
}
