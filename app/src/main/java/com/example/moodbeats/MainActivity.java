package com.example.moodbeats;

import androidx.appcompat.app.AppCompatActivity;
import android.media.MediaPlayer;
import android.widget.Button;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    MediaPlayer feeling;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        feeling = MediaPlayer.create(MainActivity.this, R.raw.slowdancing);
        feeling.start();
    }






}
