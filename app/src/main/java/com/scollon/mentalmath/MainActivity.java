package com.scollon.mentalmath;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tv1, tv2;
    char plus = '+', minus = '-', times = '*', choice, cho;
    Integer wyn;
    EditText wynikGracza;
    Button zatwierdź;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1 = findViewById(R.id.equasion);
        tv2 = findViewById(R.id.wynik);
        wynikGracza = findViewById(R.id.EtNum);
        zatwierdź = findViewById(R.id.button);



        Integer randomInt = (int)(10.0 * Math.random());
        Integer randomInt2 = (int)(10.0 * Math.random());
        Integer randomInt3 = (int)(3 * Math.random());
        cho = wyb(randomInt3);

        final Integer PrawWynik = wynik(randomInt,randomInt2,cho);
        String Num = randomInt.toString();
        String Num2 = randomInt2.toString();
        tv1.setText(Num + cho + Num2+ "=?");
        tv2.setText(PrawWynik.toString());

        zatwierdź.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String wyngra = wynikGracza.getText().toString();
                int wyngrapraw = Integer.parseInt(wyngra);

                if(wyngrapraw == PrawWynik){
                    Toast.makeText(MainActivity.this, "brawo", Toast.LENGTH_SHORT).show();
                    finish();
                    startActivity(getIntent());
                }else{
                    Toast.makeText(MainActivity.this, "śmieć", Toast.LENGTH_SHORT).show();
                }



            }
        });


    }
    public char wyb(Integer rand){
        switch (rand){
            case 0:
                choice = '+';
                break;
            case 1:
                choice = '-';
                break;
            case 2:
                choice = '*';
                break;

        }
        return choice;
    }

    public Integer wynik (Integer var1, Integer var2, char znak){

        switch (znak){
            case '+':
                wyn = var1 + var2;
                break;
            case '-':
                wyn = var1 - var2;
                break;
            case '*':
                wyn = var1 * var2;
                break;

        }
        return wyn;
    }
}