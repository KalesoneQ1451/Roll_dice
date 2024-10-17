package com.example.roll_dice;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private TextView gra;
    private Button losowanie;
    private TextView kosc1;
    private TextView kosc2;
    private TextView kosc3;
    private TextView kosc4;
    private TextView kosc5;
    private TextView wynikLosu;
    private TextView wynikGry;
    private Button reset;
    private TextView iloscRzutow;
    private int liczbaRzutow;
    private int ilosc = 0;
    private int wynikGier = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        gra = findViewById(R.id.textView);
        losowanie = findViewById(R.id.losowanie);
        kosc1 = findViewById(R.id.kosc1);
        kosc2 = findViewById(R.id.kosc2);
        kosc3 = findViewById(R.id.kosc3);
        kosc4 = findViewById(R.id.kosc4);
        kosc5 = findViewById(R.id.kosc5);
        wynikLosu = findViewById(R.id.wynikLos);
        wynikGry = findViewById(R.id.wynikGry);
        iloscRzutow = findViewById(R.id.ileLos);
        reset = findViewById(R.id.reset);




        losowanie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rollDice();
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetGame();
            }
        });
    }
    public void rollDice(){
        Random rand = new Random();
        int[] rzut = new int[5];
        ilosc++;
        iloscRzutow.setText("Ile rzutów: " + ilosc);
        int sum = 0;
        for (int i = 0; i < 5; i++) {
            int liczba = rand.nextInt(6)+1;
            rzut[i] = liczba;
            sum += liczba;
        }
        updateScore(sum);
    }
    public void resetGame(){
        kosc1.setText("?");
        kosc2.setText("?");
        kosc3.setText("?");
        kosc4.setText("?");
        kosc5.setText("?");
        iloscRzutow.setText("Ile rzutów: 0");
        wynikGry.setText("Wynik gry: 0");
        wynikLosu.setText("Wynik tego losowania: 0");
    }
    public void updateScore(int newScore){
        wynikGier += newScore;
        wynikGry.setText("Wynik gry: " + wynikGier);
        wynikLosu.setText("Wynik tego losowania: " + newScore);
    }
}