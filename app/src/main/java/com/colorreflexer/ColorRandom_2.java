package com.colorreflexer;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class ColorRandom_2 extends AppCompatActivity {

    private Button color;
    private TextView time;
    private TextView points;
    int colorText, textColor, pointsEarned = 0;
    int t = 59;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_random_2);
        delayer();
    }

    public void randomize() {
        color = findViewById(R.id.colorText);
        Random rand = new Random();
        String[] colors = new String[]{"RED", "BLUE", "GREEN", "BLACK", "YELLOW"};
        colorText = rand.nextInt(5);
        textColor = rand.nextInt(5);
        color.setText(colors[colorText]);
        changeTextColor(textColor);
    }

    private void changeTextColor(int choice) {
        color = findViewById(R.id.colorText);
        switch (choice) {
            case 0 : color.setBackgroundColor(Color.RED);
                break;
            case 1 : color.setBackgroundColor(Color.BLUE);
                break;
            case 2 : color.setBackgroundColor(Color.GREEN);
                break;
            case 3 : color.setBackgroundColor(Color.BLACK);
                break;
            case 4 : color.setBackgroundColor(Color.YELLOW);
                break;
        }
    }

    void delayer() {
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                time = findViewById(R.id.showTime);
                if (t < 0) return;
                time.setText(Integer.toString(t));
                randomize();
                delayer();
                t--;
            }
        }, 1000);
    }

    public void managePoints(View view) {
        if (t < 0) return;
        points = findViewById(R.id.showPoints);
        if (colorText == textColor)
            pointsEarned++;
        else
            pointsEarned--;
        points.setText(Integer.toString(pointsEarned));
    }
}