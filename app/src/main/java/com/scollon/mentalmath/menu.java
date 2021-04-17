package com.scollon.mentalmath;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class menu extends AppCompatActivity {
Button endless;
Button lvl1, lvl2, lvl3, lvl4, lvl5, lvl6, lvl7, lvl8, lvl9, lvl10, endless2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        endless = findViewById(R.id.endless);
        lvl1 = findViewById(R.id.lvl1);
        lvl2 = findViewById(R.id.lvl2);
        lvl3 = findViewById(R.id.lvl3);
        lvl4 = findViewById(R.id.lvl4);
        lvl5 = findViewById(R.id.lvl5);
        lvl6 = findViewById(R.id.lvl6);
        lvl7 = findViewById(R.id.lvl7);
        lvl8 = findViewById(R.id.lvl8);
        lvl9 = findViewById(R.id.lvl9);
        lvl10 = findViewById(R.id.lvl10);
        endless2 = findViewById(R.id.endless2);



    endless.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i =  new Intent(menu.this, MainActivity.class);
            startActivity(i);
        }
    });
endless2.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent i = new Intent(menu.this, endless2.class);
        startActivity(i);
    }
});
    }
    public void Klik(View v){
        switch (v.getId()){
            case R.id.lvl1:
                Intent i = new Intent(this, Levels.class);
                i.putExtra("poziom", 1);
                startActivity(i);
                break;
            case R.id.lvl2:
                Intent i2 = new Intent(this, Levels.class);
                i2.putExtra("poziom", 2);
                startActivity(i2);
                break;
            case R.id.lvl3:
                Intent i3 = new Intent(this, Levels.class);
                i3.putExtra("poziom", 3);
                startActivity(i3);
                break;
            case R.id.lvl4:
                Intent i4 = new Intent(this, Levels.class);
                i4.putExtra("poziom", 4);
                startActivity(i4);
                break;
            case R.id.lvl5:
                Intent i5 = new Intent(this, Levels.class);
                i5.putExtra("poziom", 5);
                startActivity(i5);
                break;
            case R.id.lvl6:
                Intent i6 = new Intent(this, Levels.class);
                i6.putExtra("poziom", 6);
                startActivity(i6);
                break;
            case R.id.lvl7:
                Intent i7 = new Intent(this, Levels.class);
                i7.putExtra("poziom", 7);
                startActivity(i7);
                break;
            case R.id.lvl8:
                Intent i8 = new Intent(this, Levels.class);
                i8.putExtra("poziom", 8);
                startActivity(i8);
                break;
            case R.id.lvl9:
                Intent i9 = new Intent(this, Levels.class);
                i9.putExtra("poziom", 9);
                startActivity(i9);
                break;
            case R.id.lvl10:
                Intent i10 = new Intent(this, Levels.class);
                i10.putExtra("poziom", 10);
                startActivity(i10);
                break;
        }

    }
}