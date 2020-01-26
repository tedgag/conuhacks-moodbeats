package com.example.moodbeats;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button_Happy = findViewById(R.id.button_Happy);
        Button button_Chill = findViewById(R.id.button_Chill);
        Button button_Stressed = findViewById(R.id.button_Stressed);
        Button button_Sad = findViewById(R.id.button_Sad);

        //Button on click listeners
        button_Happy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               //Insert code here
            }
        });
        button_Chill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Insert code here
            }
        });
        button_Stressed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Insert code here
            }
        });
        button_Sad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               
            }
        });

    }



}
