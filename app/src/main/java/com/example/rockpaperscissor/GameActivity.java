package com.example.rockpaperscissor;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class GameActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        ImageButton imageButtonOne = (ImageButton) findViewById(R.id.imageButton);
        ImageButton imageButtonTwo = (ImageButton) findViewById(R.id.imageButton2);
        ImageButton imageButtonThree = (ImageButton) findViewById(R.id.imageButton4);
        ImageView questionMarkImageTwo = (ImageView) findViewById(R.id.imageView2);

        imageButtonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                questionMarkImageTwo.setImageDrawable(getResources().getDrawable(R.drawable.rock));
                computerMove();

            }
        });

        imageButtonTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                questionMarkImageTwo.setImageDrawable(getResources().getDrawable(R.drawable.paper));
                computerMove();
            }
        });

        imageButtonThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                questionMarkImageTwo.setImageDrawable(getResources().getDrawable(R.drawable.scissors));
                computerMove();
            }
        });
    }


    //    Creating ComputerMove() for getting computer's Input
    public void computerMove() {
        ImageView questionMarkImage = (ImageView) findViewById(R.id.imageView);
        int random = new Random().nextInt(3);
        switch (random) {
            case 0:
                questionMarkImage.setImageDrawable(getResources().getDrawable(R.drawable.rock));
                findWinner(random);
                break;
            case 1:
                questionMarkImage.setImageDrawable(getResources().getDrawable(R.drawable.paper));
                findWinner(random);
                break;
            case 2:
                questionMarkImage.setImageDrawable(getResources().getDrawable(R.drawable.scissors));
                findWinner(random);
                break;
        }
    }

    public void findWinner(int number) {
        ImageButton imageButtonOne = (ImageButton) findViewById(R.id.imageButton);
        ImageButton imageButtonTwo = (ImageButton) findViewById(R.id.imageButton2);
        ImageButton imageButtonThree = (ImageButton) findViewById(R.id.imageButton4);
        TextView playerText = (TextView) findViewById(R.id.textView6);
        TextView computerText = (TextView) findViewById(R.id.textView7);
        int playerWon = 0;
        int computerWon = 0;

        if (imageButtonOne.isPressed()) {
            if (number == 0) {
                Toast.makeText(GameActivity.this, "Ooops! It is a draw", Toast.LENGTH_LONG).show();
            }

            if (number == 1) {
                Toast.makeText(GameActivity.this, "Computer Won! Better luck for next time!", Toast.LENGTH_LONG).show();
                computerWon++;
                computerText.setText("Player Two's Total Score: " + computerWon);
            }

            if (number == 2) {
                Toast.makeText(GameActivity.this, "Congratulations! You Won", Toast.LENGTH_LONG).show();
                playerWon++;
                playerText.setText("Player One's Total Score: " + playerWon);
            }



        } else if (imageButtonTwo.isPressed()) {
            if (number == 0) {
                Toast.makeText(GameActivity.this, "Congratulations! You Won", Toast.LENGTH_LONG).show();
                playerWon++;
                playerText.setText("Player One's Total Score: " + playerWon);
            }

            if (number == 1) {
                Toast.makeText(GameActivity.this, "Ooops! It is a draw", Toast.LENGTH_LONG).show();
            }

            if (number == 2) {
                Toast.makeText(GameActivity.this, "Computer Won! Better luck for next time!", Toast.LENGTH_LONG).show();
                computerWon++;
                computerText.setText("Player Two's Total Score: " + computerWon);
            }
        } else if (imageButtonThree.isPressed()) {
            if (number == 0) {
                Toast.makeText(GameActivity.this, "Computer Won! Better luck for next time!", Toast.LENGTH_LONG).show();
                computerWon = computerWon +1;
                computerText.setText("Player Two's Total Score: " + computerWon);
            }

            if (number == 1) {
                Toast.makeText(GameActivity.this, "Congratulations! You Won", Toast.LENGTH_LONG).show();
                playerWon = playerWon + 1;
                playerText.setText("Player One's Total Score: " + playerWon);
            }

            if (number == 2) {
                Toast.makeText(GameActivity.this, "Ooops! It is a draw", Toast.LENGTH_LONG).show();
            }
        }


    }
}
