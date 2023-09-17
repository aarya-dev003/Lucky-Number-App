package com.example.luckynumberapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class LuckyNumberActivity extends AppCompatActivity {
    TextView welcome, luckyNumber;
    Button share;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lucky_number);

        welcome = findViewById(R.id.textView2);
        luckyNumber = findViewById(R.id.luckyNumber);
        share = findViewById(R.id.shareBtn);

        Intent i = getIntent();

        String userName = i.getStringExtra("name");

        int randomNumber = generateRandomNumber();

        luckyNumber.setText(""+randomNumber);

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareData(userName, randomNumber);
            }
        });



    }

    public int generateRandomNumber(){
        Random random = new Random();
        int random_Number = random.nextInt(1000);
        return random_Number;
    }

    public void shareData(String user_Name, int randomNumber){

//        Implicit intent

        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");

        String number = String.valueOf(randomNumber);

        i.putExtra(Intent.EXTRA_SUBJECT, user_Name + " got lucky today!");
        i.putExtra(Intent.EXTRA_TEXT, "His lucky Number is " + number);

        startActivity(Intent.createChooser(i, "Choose a Platform"));

    }

}