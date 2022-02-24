package com.example.scorekeeper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int score1 = 0;    // score keeper variable for team 1
    private int score2 = 0;     // score keeper variable for team 2

    private TextView mScoreText1;
    private TextView mScoreText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mScoreText1 = findViewById(R.id.score1);
        mScoreText2 = findViewById(R.id.score2);

    }

    // minus icon clicked but for which team to short out that we used switch
    public void deceaseScore(View view) {

        switch(view.getId()) {

            case R.id.decreaseTeam1: score1--;
                mScoreText1.setText(String.valueOf(score1));
                break;

            case R.id.decreaseTeam2: score2--;
                mScoreText2.setText(String.valueOf(score2));
        }
    }

    public void increaseScore(View view) {

        switch(view.getId()) {

            case R.id.increaseTeam1: score1++;
                mScoreText1.setText(String.valueOf(score1));
                break;

            case R.id.increaseTeam2: score2++;
                mScoreText2.setText(String.valueOf(score2));
        }
    }
}