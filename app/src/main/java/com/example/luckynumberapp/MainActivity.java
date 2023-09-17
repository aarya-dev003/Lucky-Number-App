package com.example.luckynumberapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txt;
    EditText nameOfUser;
    Button findLuckyNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameOfUser = findViewById(R.id.name);
        findLuckyNumber = findViewById(R.id.find);
        txt = findViewById(R.id.textView);

        String user_name = nameOfUser.getText().toString();

        findLuckyNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), LuckyNumberActivity.class);

                i.putExtra("name" , user_name);

                startActivity(i);
            }
        });


    }
}