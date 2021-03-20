package com.scollon.mentalmath;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class menu extends AppCompatActivity {
Button endless;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        endless = findViewById(R.id.endless);

    endless.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i =  new Intent(menu.this, MainActivity.class);
            startActivity(i);
        }
    });

    }
}