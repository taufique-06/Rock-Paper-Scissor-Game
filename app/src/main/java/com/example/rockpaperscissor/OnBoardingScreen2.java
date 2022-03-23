package com.example.rockpaperscissor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import com.ramotion.paperonboarding.PaperOnboardingFragment;
import com.ramotion.paperonboarding.PaperOnboardingPage;

import java.util.ArrayList;

public class OnBoardingScreen2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_boarding_screen2);

        FragmentManager fragmentManager = getSupportFragmentManager();

        // new instance is created and data is took from an
        // array list known as getDataonborading
        final PaperOnboardingFragment paperOnboardingFragment = PaperOnboardingFragment.newInstance(getDataforOnboarding());
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        // fragmentTransaction method is used
        // do all the transactions or changes
        // between different fragments
        fragmentTransaction.add(R.id.frame_layout, paperOnboardingFragment);

        // all the changes are committed
        fragmentTransaction.commit();
    }

    private ArrayList<PaperOnboardingPage> getDataforOnboarding() {

        // the first string is to show the main title ,
        // second is to show the message below the
        // title, then color of background is passed ,
        // then the image to show on the screen is passed
        // and at last icon to navigate from one screen to other
        PaperOnboardingPage source = new PaperOnboardingPage("Choose between Rock, Paper, and Scissors.", "", Color.parseColor("#ffb174"), R.drawable.rock_paper_scissors, R.drawable.one);
        PaperOnboardingPage source1 = new PaperOnboardingPage("Rules", "Rock beats scissors, paper beats rock and scissors beat paper", Color.parseColor("#17a2b8"),R.drawable.rules, R.drawable.two);
        PaperOnboardingPage source2 = new PaperOnboardingPage("Interested to know the Highest Score?", "On the front page, click on the Best Score button.", Color.parseColor("#7c69ef"),R.drawable.enjoy, R.drawable.three);

        // array list is used to store
        // data of onbaording screen
        ArrayList<PaperOnboardingPage> elements = new ArrayList<>();

        // all the sources(data to show on screens)
        // are added to array list
        elements.add(source);
        elements.add(source1);
        elements.add(source2);
        return elements;
    }




}