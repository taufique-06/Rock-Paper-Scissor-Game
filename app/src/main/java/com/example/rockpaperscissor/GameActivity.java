package com.example.rockpaperscissor;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class GameActivity extends AppCompatActivity {
//    All variables starts here

    ImageButton imageButtonOne,imageButtonTwo,imageButtonThree;
    ImageView questionMarkImage, questionMarkImageTwo;
    Button reset,helpButton;
    TextView playerText, computerText, t;
    public static int playerWon = 0;
    public static int computerWon = 0;
    String computerWonText = "Computer Won! Better luck for next time!";
    String playerWonText = "Congratulations! You Won";

    //    Ends here
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        imageButtonOne = (ImageButton) findViewById(R.id.imageButton);
        imageButtonTwo = (ImageButton) findViewById(R.id.imageButton2);
        imageButtonThree = (ImageButton) findViewById(R.id.imageButton4);
        questionMarkImageTwo = (ImageView) findViewById(R.id.imageView2);
        reset = (Button) findViewById(R.id.button6);

//        When clicking first-button
        imageButtonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                questionMarkImageTwo.setImageDrawable(getResources().getDrawable(R.drawable.rock));
                computerMove();
            }
        });

//        When clicking second-button
        imageButtonTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                questionMarkImageTwo.setImageDrawable(getResources().getDrawable(R.drawable.paper));
                computerMove();
            }
        });

//        When clicking third-button
        imageButtonThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                questionMarkImageTwo.setImageDrawable(getResources().getDrawable(R.drawable.scissors));
                computerMove();
            }
        });

//        When clicking reset button

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetScore();
            }
        });

//        When clicking need help button


    }

    //    Creating ComputerMove() for getting computer's Input starts here
    public void computerMove() {
        questionMarkImage = (ImageView) findViewById(R.id.imageView);
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

//    Ends here

//    findWinner() decides whether computer won or the player starts here

    public void findWinner(int number) {

        imageButtonOne = (ImageButton) findViewById(R.id.imageButton);
        imageButtonTwo = (ImageButton) findViewById(R.id.imageButton2);
        imageButtonThree = (ImageButton) findViewById(R.id.imageButton4);
        playerText = (TextView) findViewById(R.id.textView6);
        computerText = (TextView) findViewById(R.id.textView7);
//        t = (TextView) findViewById(R.id.textView12);
        if (imageButtonOne.isPressed()) {

            if (number == 0) {

//                t.setText("Ooops! It is a draw");
                showToast("Ooops! It is a draw");
            }

            if (number == 1) {
//                t.setText(computerWonText);
                showToast(computerWonText);
//                Toast.makeText(GameActivity.this, text, Toast.LENGTH_LONG).show();
                computerWon++;
                computerText.setText("Player Two's Total Score: " + computerWon);
            }

            if (number == 2) {
//                t.setText(playerWonText);
                showToast(playerWonText);
                playerWon++;
                playerText.setText("Player One's Total Score: " + playerWon);
            }



        } else if (imageButtonTwo.isPressed()) {
            if (number == 0) {
//                t.setText(playerWonText);
                showToast(playerWonText);
                playerWon++;
                playerText.setText("Player One's Total Score: " + playerWon);
            }

            if (number == 1) {
//                t.setText("Ooops! It is a draw");
                showToast("Ooops! It is a draw");
            }

            if (number == 2) {
//                t.setText(computerWonText);
                showToast(computerWonText);
                computerWon++;
                computerText.setText("Player Two's Total Score: " + computerWon);
            }
        } else if (imageButtonThree.isPressed()) {
            if (number == 0) {
//                t.setText(computerWonText);
                showToast(computerWonText);
                computerWon++;
                computerText.setText("Player Two's Total Score: " + computerWon);
            }

            if (number == 1) {
//                t.setText(playerWonText);
                showToast(playerWonText);
                playerWon++;
                playerText.setText("Player One's Total Score: " + playerWon);
            }

            if (number == 2) {
//                t.setText("Ooops! It is a draw");
                showToast("Ooops! It is a draw");
            }
        }

    }

//    Ends here

//    resetScore() reset the score starts here

    public void resetScore()
    {
        questionMarkImageTwo = (ImageView) findViewById(R.id.imageView2);
        questionMarkImage = (ImageView) findViewById(R.id.imageView);
        playerText = (TextView) findViewById(R.id.textView6);
        computerText = (TextView) findViewById(R.id.textView7);
        playerWon = 0;
        computerWon = 0;
        playerText.setText("Player One's Total Score: " + playerWon);
        computerText.setText("Player Two's Total Score: " + computerWon);
        questionMarkImage.setImageDrawable(getResources().getDrawable(R.drawable.question));
        questionMarkImageTwo.setImageDrawable(getResources().getDrawable(R.drawable.question));
    }

//    Ends here



    private void showToast(String text){

        LayoutInflater inflater = getLayoutInflater();
        View layoutForPlayer = inflater.inflate(R.layout.custom_toast, (ViewGroup)findViewById(R.id.custom_toast_o));
        View layoutForComputer = inflater.inflate(R.layout.custom_toast_computer, (ViewGroup)findViewById(R.id.custom_toast_computer));
        View layoutForDraw = inflater.inflate(R.layout.custom_toast_draw, (ViewGroup)findViewById(R.id.custom_toast_draw));

        if (text == "Ooops! It is a draw")
        {
            customToast(layoutForDraw);
        }
        else if(text == "Congratulations! You Won")
        {
            customToast(layoutForPlayer);
            creatingSound();
        }
        else
        {
            customToast(layoutForComputer);
            creatingSound();
        }

    }


    private void creatingSound()
    {
        MediaPlayer mediaplayer = MediaPlayer.create(GameActivity.this, R.raw.win);
        mediaplayer.setOnCompletionListener(mediaPlayer -> {
            mediaPlayer.reset();
            mediaPlayer.release();
        });
        mediaplayer.start();
    }


    private void customToast(View layout)
    {
        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 220);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.show();
    }

}
