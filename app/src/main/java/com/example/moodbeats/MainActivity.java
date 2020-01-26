package com.example.moodbeats;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.MediaPlayer;
import android.util.DisplayMetrics;
import android.widget.Button;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    MediaPlayer feeling;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        Button button_Chill = findViewById(R.id.button_Chill);
        Button button_Stressed = findViewById(R.id.button_Stressed);
        Button button_Sad = findViewById(R.id.button_Sad);
        Button button_ldb = findViewById(R.id.button_leaderboard);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        Circle.setScreenHeight(displayMetrics.heightPixels);
        Circle.setScreenWidth(displayMetrics.widthPixels);


        button_Stressed.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, GameActivity.class);
                intent.putExtra("Mood","Stressed");
                startActivity(intent);
                finish();
            }
        });
        button_Sad.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, GameActivity.class);
                intent.putExtra("Mood","Sad");
                startActivity(intent);
                finish();
            }
        });

        Button buttonHappy= (Button)findViewById(R.id.button_Happy);
        buttonHappy.setOnClickListener(new View.OnClickListener()
        {   public void onClick(View view)
            {
                Intent intent = new Intent(MainActivity.this, GameActivity.class);
                intent.putExtra("Mood","Happy");
                startActivity(intent);
                finish();
            }
        });

        button_Chill.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, GameActivity.class);
                intent.putExtra("Mood","Chill");
                startActivity(intent);
                finish();
            }
        });

        button_ldb.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Toast toast = Toast.makeText(getApplicationContext(), "Coming Soon", Toast.LENGTH_SHORT);
                toast.show();
            }
        });

        feeling = MediaPlayer.create(MainActivity.this, R.raw.slowdancing);
        feeling.start();
    }






}

