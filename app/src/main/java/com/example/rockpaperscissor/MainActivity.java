package com.example.rockpaperscissor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.transition.Slide;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        go to GameActivity.class when clicking on the button

        Button playButton = (Button)findViewById(R.id.button2);
        Button helpButton = (Button)findViewById(R.id.button3);
        Button bestScore = (Button)findViewById(R.id.button4);

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, GameActivity.class);
                startActivity(intent);
            }
        });

        helpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent helpButtonIntent = new Intent(MainActivity.this, OnBoardingScreen1.class);
                startActivity(helpButtonIntent);

                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_in_right);
            }
        });

        bestScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent bestScoreIntent = new Intent(MainActivity.this, bestScore.class);
                startActivity(bestScoreIntent);
            }
        });


    }

}