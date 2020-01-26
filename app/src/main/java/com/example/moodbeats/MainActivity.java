package com.example.moodbeats;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        Button button_Chill = findViewById(R.id.button_Chill);
        Button button_Stressed = findViewById(R.id.button_Stressed);
        Button button_Sad = findViewById(R.id.button_Sad);

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

        Button buttonHappy= (Button)findViewById(R.id.button_Happy);
        buttonHappy.setOnClickListener(new View.OnClickListener()
        {   public void onClick(View view)
            {
                Intent intent = new Intent(MainActivity.this, GameActivity.class);
                startActivity(intent);
                finish();
            }
        });
            @Override
        button_Chill.setOnClickListener(new View.OnClickListener() {
    }



}
