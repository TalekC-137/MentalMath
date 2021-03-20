package com.scollon.mentalmath;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView tv1, tv2, wynikGracza;
    char choice, cho;
    Integer wyn;
    Button zatwierdź, btn1, btn2, btn3, btn4, btn5, btn6,btn7,btn8,btn9,btn0,btndot, delete, add;
    Helper helper = new Helper();
    ListView lv_customerList;
    int a = 5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1 = findViewById(R.id.equasion);
        tv2 = findViewById(R.id.wynik);
        lv_customerList = findViewById(R.id.lv_customer_List);
        add = findViewById(R.id.adddd);
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

        Integer randomInt = (int)(10.0 * Math.random());
        Integer randomInt2 = (int)(10.0 * Math.random());
        Integer randomInt3 = (int)(3 * Math.random());
        cho = wyb(randomInt3);

        final Integer PrawWynik = wynik(randomInt,randomInt2,cho);
        String Num = randomInt.toString();
        String Num2 = randomInt2.toString();
        tv1.setText(Num + cho + Num2+ "=?");
        tv2.setText(PrawWynik.toString());


        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nowy = wynikGracza.getText().toString();
                wynikGracza.setText(nowy + "0");
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nowy = wynikGracza.getText().toString();
                wynikGracza.setText(nowy + "1");
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nowy = wynikGracza.getText().toString();
                wynikGracza.setText(nowy + "2");
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nowy = wynikGracza.getText().toString();
                wynikGracza.setText(nowy + "3");
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nowy = wynikGracza.getText().toString();
                wynikGracza.setText(nowy + "4");
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nowy = wynikGracza.getText().toString();
                wynikGracza.setText(nowy + "5");
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nowy = wynikGracza.getText().toString();
                wynikGracza.setText(nowy + "6");
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nowy = wynikGracza.getText().toString();
                wynikGracza.setText(nowy + "7");
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nowy = wynikGracza.getText().toString();
                wynikGracza.setText(nowy + "8");
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nowy = wynikGracza.getText().toString();
                wynikGracza.setText(nowy + "9");

            }
        });
        btndot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nowy = wynikGracza.getText().toString();
                wynikGracza.setText(nowy + ",");
            }
        });



        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

try {
    helper = new Helper(a, -1);
    Toast.makeText(MainActivity.this, "50%", Toast.LENGTH_SHORT).show();


}catch (Exception e){
    Toast.makeText(MainActivity.this, "0%", Toast.LENGTH_SHORT).show();

}
DataBase dataBase =  new DataBase(MainActivity.this, 1);
boolean succes = dataBase.addOne(helper);

                List<Helper> everyone = dataBase.getEveryone();
                ArrayAdapter customerArrayAdapter = new ArrayAdapter<Helper>(MainActivity.this, android.R.layout.simple_list_item_1, everyone);
                lv_customerList.setAdapter(customerArrayAdapter);
            }
        });



        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nowy = wynikGracza.getText().toString();
                String nowszy = removeLastChar(nowy);
                wynikGracza.setText(nowszy);

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
                     finish();
                     startActivity(getIntent());
                 } else {
                     Toast.makeText(MainActivity.this, "śmieć", Toast.LENGTH_SHORT).show();
                 }
             }catch(Exception e){

                 Toast.makeText(MainActivity.this, "enter a valid number", Toast.LENGTH_SHORT).show();
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

    public static String removeLastChar(String s) {
        return (s == null) ? null : s.replaceAll(".$", "");
    }
}