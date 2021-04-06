package com.scollon.mentalmath;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class Levels extends AppCompatActivity {
TextView tv_test;
    TextView tv1, tv2, wynikGracza, tvtv, pukty, poziom;
    char choice, cho;
    Integer wyn;
    Button zatwierdź, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0, btndot, delete, hint;
    Helper helper = new Helper();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levels);
        //tv_test = findViewById(R.id.tv_dziala);
        Intent i = getIntent();
        final Integer numer = i.getIntExtra("poziom", 0);

        poziom = findViewById(R.id.poziom);
        tv1 = findViewById(R.id.equasion);
        tv2 = findViewById(R.id.wynik);
        pukty = findViewById(R.id.punkciki);
        hint = findViewById(R.id.hint);
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

        tv1.setText(dzialnie(numer));
        poziom.setText("level: " + numer.toString());
        final String PrawWynik = wynik(numer);
        final Float wyniczek = Float.parseFloat(PrawWynik);


        DataBase dataBase = new DataBase(Levels.this, 1);
        if (dataBase.getRowCount() != 0) {
            Long liczba = dataBase.getRowCount();
            Helper newest = dataBase.getOne(liczba);
            Integer wynik = newest.getId();


            pukty.setText("points: " + wynik);
        } else {
            pukty.setText("points: 0");
        }


        hint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                tv2.setText(PrawWynik);

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

                    if (wyngrapraw == wyniczek) {
                        Toast.makeText(Levels.this, "brawo", Toast.LENGTH_SHORT).show();


                        DataBase dataBase = new DataBase(Levels.this, 1);
                        if (dataBase.getRowCount() != 0) {
                            Long liczba = dataBase.getRowCount();

                            Helper newest = dataBase.getOne(liczba);
                            Integer wynik = newest.getId();

                            //  I messed up the id and points order so getIt returns points and getPoints returns the id :))))
                            //  I need some coffee
                            Toast.makeText(Levels.this, wynik.toString(), Toast.LENGTH_SHORT).show();


                            int nowyWynik = wynik + 5;

                            try {
                                helper = new Helper(nowyWynik, -1);
                                Toast.makeText(Levels.this, "50%", Toast.LENGTH_SHORT).show();


                            } catch (Exception e) {
                                Toast.makeText(Levels.this, "0%", Toast.LENGTH_SHORT).show();

                            }

                            boolean succes = dataBase.addOne(helper);


                        } else if (dataBase.getRowCount() == 0) {
                            Toast.makeText(Levels.this, "pierwszy wynik", Toast.LENGTH_SHORT).show();

                            try {
                                Helper pierwszy = new Helper(2, -1);
                                Toast.makeText(Levels.this, "wkładany pierwszy", Toast.LENGTH_SHORT).show();
                                boolean succes = dataBase.addOne(pierwszy);

                            } catch (Exception e) {
                                Toast.makeText(Levels.this, "0%", Toast.LENGTH_SHORT).show();

                            }


                        }
                        if(numer == 10){
                            Intent i = new Intent(Levels.this, menu.class);
                            startActivity(i);
                        }else {
                            finish();
                            Intent i = getIntent();
                            i.putExtra("poziom", numer + 1);
                            startActivity(i);
                        }


                    }
                    else {
                        Toast.makeText(Levels.this, "śmieć", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {

                    Toast.makeText(Levels.this, "enter a valid number", Toast.LENGTH_SHORT).show();
                }


            }
        });

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

    public String dzialnie (Integer Num) {
        String dzial = "";
        switch (Num) {
            case 1:
                dzial = "8-3*3";
            break;
            case 2:
                dzial = "6*3+1";
            break;
            case 3:
                dzial = "0+2*42";
            break;
            case 4:
                dzial = "94-25+1";
            break;
            case 5:
                dzial = "2*3:2";
            break;
            case 6:
                dzial = "7:7*7";
            break;
            case 7:
                dzial = "9*3:2+8";
            break;
            case 8:
                dzial = "6+6*2";
            break;
            case 9:
                dzial = "9*2+2*3+4*0";
            break;
            case 10:
                dzial = "(9*2+4:2-1)*0";
           break;

        }
        return dzial;
    }

    public String wynik (Integer Num) {
        String dzial = "";
        switch (Num) {
            case 1:
                dzial = "-1";
                break;
            case 2:
                dzial = "19";
                break;
            case 3:
                dzial = "84";
                break;
            case 4:
                dzial = "70";
                break;
            case 5:
                dzial = "3";
                break;
            case 6:
                dzial = "7";
                break;
            case 7:
                dzial = "21,5";
                break;
            case 8:
                dzial = "18";
                break;
            case 9:
                dzial = "24";
                break;
            case 10:
                dzial = "0";
                break;

        }
        return dzial;
    }

}