package com.example.moodbeats;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private CustomView canvas = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Circle> circles = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            circles.add(new Circle());
        }

        for(int i = 0; i < 3; i++) {
            circles.get(i).draw();
        }

    }


}


