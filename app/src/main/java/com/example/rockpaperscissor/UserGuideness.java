package com.example.rockpaperscissor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Color;
import android.os.Bundle;

import com.ramotion.paperonboarding.PaperOnboardingFragment;
import com.ramotion.paperonboarding.PaperOnboardingPage;

import java.util.ArrayList;

public class UserGuideness extends AppCompatActivity {

    private FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_guideness);

        fragmentManager = getSupportFragmentManager();
        final PaperOnboardingFragment paperOnboardingFragment = PaperOnboardingFragment.newInstance(getDataforOnboarding());
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.frame_layout, paperOnboardingFragment);

        // all the changes are committed
        fragmentTransaction.commit();
    }


    private ArrayList<PaperOnboardingPage> getDataforOnboarding()
    {
        PaperOnboardingPage source = new PaperOnboardingPage("Gfg", "Welcome to GeeksForGeeks", Color.parseColor("#ffb174"),R.drawable.rock, R.drawable.question);
        PaperOnboardingPage source1 = new PaperOnboardingPage("Practice", "Practice questions from all topics", Color.parseColor("#22eaaa"),R.drawable.paper, R.drawable.question);
        PaperOnboardingPage source2 = new PaperOnboardingPage("", " ", Color.parseColor("#ee5a5a"),R.drawable.scissors, R.drawable.rock);

        ArrayList<PaperOnboardingPage> elements = new ArrayList<>();

        elements.add(source);
        elements.add(source1);
        elements.add(source2);
        return elements;
    }
}