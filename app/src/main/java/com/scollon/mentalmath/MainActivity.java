package com.scollon.mentalmath;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView tv1, tv2, wynikGracza, tvtv, pukty;
    char choice, cho;
    Integer wyn;
    Button zatwierdź, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0, btndot, delete, add;
    Helper helper = new Helper();

    int a = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1 = findViewById(R.id.equasion);
        tv2 = findViewById(R.id.wynik);
        pukty = findViewById(R.id.punkciki);

        add = findViewById(R.id.adddd);
        tvtv = findViewById(R.id.tvtv);
        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btndot = findViewById(R.id.btndot);
        wynikGracza = findViewById(R.id.EtNum);
        zatwierdź = findViewById(R.id.button);
        delete = findViewById(R.id.btnDelete);

        Integer randomInt = (int) (10.0 * Math.random());
        Integer randomInt2 = (int) (10.0 * Math.random());
        Integer randomInt3 = (int) (3 * Math.random());
        cho = wyb(randomInt3);

        final Integer PrawWynik = wynik(randomInt, randomInt2, cho);
        String Num = randomInt.toString();
        String Num2 = randomInt2.toString();
        tv1.setText(Num + cho + Num2 + "=?");


        DataBase dataBase = new DataBase(MainActivity.this, 1);
        if (dataBase.getRowCount() != 0) {
            Long liczba = dataBase.getRowCount();
            Helper newest = dataBase.getOne(liczba);
            Integer wynik = newest.getId();


            pukty.setText("points: " + wynik);
        } else {
            pukty.setText("points: 0");
        }

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                tv2.setText(PrawWynik.toString());

            }
        });


        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!wynikGracza.getText().toString().isEmpty()) {
                    String nowy = wynikGracza.getText().toString();
                    String nowszy = removeLastChar(nowy);
                    wynikGracza.setText(nowszy);
                } else {
                    wynikGracza.setText("-");
                }

            }
        });


        zatwierdź.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    String wyngra = wynikGracza.getText().toString();

                    int wyngrapraw = Integer.parseInt(wyngra);

                    if (wyngrapraw == PrawWynik) {
                        Toast.makeText(MainActivity.this, "brawo", Toast.LENGTH_SHORT).show();


                        DataBase dataBase = new DataBase(MainActivity.this, 1);
                        if (dataBase.getRowCount() != 0) {
                            Long liczba = dataBase.getRowCount();

                            Helper newest = dataBase.getOne(liczba);
                            Integer wynik = newest.getId();

                            //  I messed up the id and points order so getIt returns points and getPoints returns the id :))))
                            //  I need some coffee
                            Toast.makeText(MainActivity.this, wynik.toString(), Toast.LENGTH_SHORT).show();


                            int nowyWynik = wynik + 2;

                            try {
                                helper = new Helper(nowyWynik, -1);
                                Toast.makeText(MainActivity.this, "50%", Toast.LENGTH_SHORT).show();


                            } catch (Exception e) {
                                Toast.makeText(MainActivity.this, "0%", Toast.LENGTH_SHORT).show();

                            }

                            boolean succes = dataBase.addOne(helper);


                        } else if (dataBase.getRowCount() == 0) {
                            Toast.makeText(MainActivity.this, "pierwszy wynik", Toast.LENGTH_SHORT).show();

                            try {
                                Helper pierwszy = new Helper(2, -1);
                                Toast.makeText(MainActivity.this, "wkładany pierwszy", Toast.LENGTH_SHORT).show();
                                boolean succes = dataBase.addOne(pierwszy);

                            } catch (Exception e) {
                                Toast.makeText(MainActivity.this, "0%", Toast.LENGTH_SHORT).show();

                            }


                        }
                        finish();
                        startActivity(getIntent());
                    } else {
                        Toast.makeText(MainActivity.this, "śmieć", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {

                    Toast.makeText(MainActivity.this, "enter a valid number", Toast.LENGTH_SHORT).show();
                }


            }
        });

    }

    public char wyb(Integer rand) {
        switch (rand) {
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

    public Integer wynik(Integer var1, Integer var2, char znak) {

        switch (znak) {
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

    public static String removeLastChar(String s) {
        return (s == null) ? null : s.replaceAll(".$", "");
    }

    public void ClickMuch(View v){
        switch(v.getId()){

            case R.id.btn1:
                String nowy = wynikGracza.getText().toString();
                wynikGracza.setText(nowy + "1");
                break;
            case R.id.btn2:
                String nowy1 = wynikGracza.getText().toString();
                wynikGracza.setText(nowy1 + "2");
                break;
            case R.id.btn3:
                String nowy2 = wynikGracza.getText().toString();
                wynikGracza.setText(nowy2 + "3");
                break;
            case R.id.btn4:
                String nowy3 = wynikGracza.getText().toString();
                wynikGracza.setText(nowy3 + "4");
                break;
            case R.id.btn5:
                String nowy4 = wynikGracza.getText().toString();
                wynikGracza.setText(nowy4 + "5");
                break;
            case R.id.btn6:
                String nowy5 = wynikGracza.getText().toString();
                wynikGracza.setText(nowy5 + "6");
                break;
            case R.id.btn7:
                String nowy6 = wynikGracza.getText().toString();
                wynikGracza.setText(nowy6 + "7");
                break;
            case R.id.btn8:
                String nowy7 = wynikGracza.getText().toString();
                wynikGracza.setText(nowy7 + "8");
                break;
            case R.id.btn9:
                String nowy8 = wynikGracza.getText().toString();
                wynikGracza.setText(nowy8 + "9");
                break;
            case R.id.btn0:
                String nowy0 = wynikGracza.getText().toString();
                wynikGracza.setText(nowy0 + "0");
                break;
            case R.id.btndot:
                if(!wynikGracza.getText().toString().isEmpty()){
                    String nowy00 = wynikGracza.getText().toString();
                    wynikGracza.setText(nowy00 + ",");}
                else
                    break;
        }

    }




}
