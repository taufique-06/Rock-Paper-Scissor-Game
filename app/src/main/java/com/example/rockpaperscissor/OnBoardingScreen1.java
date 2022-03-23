package com.example.rockpaperscissor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.transition.Fade;
import android.transition.TransitionInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class OnBoardingScreen1 extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_boarding_screen1);
        Button nextButton = (Button) findViewById(R.id.button);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentokok = new Intent(OnBoardingScreen1.this, OnBoardingScreen2.class);
                startActivity(intentokok);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_in_right);

            }
        });


    }

//    @Override
//    public void finish() {
//        super.finish();
//        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
//    }





}