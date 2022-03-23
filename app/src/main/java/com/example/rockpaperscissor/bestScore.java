package com.example.rockpaperscissor;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Date;
import java.text.SimpleDateFormat;
public class bestScore extends AppCompatActivity {
    TextView showDate;
    TextView playerScore;

    TextView computerScore;
    int playerHighestScore = GameActivity.playerWon;
    int computerHighestScore = GameActivity.computerWon;
    int playerCurrentScore = playerHighestScore;
    int computerCurrentScore = computerHighestScore;
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_best_score);
        playerScore = (TextView) findViewById(R.id.textView14);
        computerScore = (TextView) findViewById(R.id.textView15);
        showDate = (TextView) findViewById(R.id.textView13);
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
        String str = formatter.format(date);
        showDate.setText("Till: " + str);

        if (playerHighestScore > playerCurrentScore)
        {
            playerScore.setText("Player Highest Score is: " + playerHighestScore);
        }
        else
        {
            playerScore.setText("Player Highest Score is: " + playerCurrentScore);
        }


        if (computerHighestScore > computerCurrentScore)
        {
            computerScore.setText("Computer Highest Score is: " + computerHighestScore);
        }
        else
        {
            computerScore.setText("Computer Highest Score is: " + computerCurrentScore);
        }
    }



}