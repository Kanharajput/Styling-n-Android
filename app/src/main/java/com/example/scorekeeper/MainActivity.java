package com.example.scorekeeper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int mscore1 = 0;    // score keeper variable for team 1
    private int mscore2 = 0;     // score keeper variable for team 2

    private TextView mScoreText1;
    private TextView mScoreText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mScoreText1 = findViewById(R.id.score1);
        mScoreText2 = findViewById(R.id.score2);

        // getting the save value
        if(savedInstanceState != null) {
            mscore1 = savedInstanceState.getInt("score_1");
            mscore2 = savedInstanceState.getInt("score_2");

            // set the saved value to views
            mScoreText1.setText(String.valueOf(mscore1));
            mScoreText2.setText(String.valueOf(mscore2));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu,menu);

        // checking which mode is applied
        int nightMode = AppCompatDelegate.getDefaultNightMode();

        if(nightMode == AppCompatDelegate.MODE_NIGHT_YES) {    // niht mode in theme
            menu.findItem(R.id.change_mode).setTitle(R.string.day_mode);   // so button show day mode text
        }

        else {
            menu.findItem(R.id.change_mode).setTitle(R.string.night_mode);
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {

        // saving the state for variables score1 and score2
        outState.putInt("score_1", mscore1);
        outState.putInt("score_2",mscore2);
        super.onSaveInstanceState(outState);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId() == R.id.change_mode) {   // clicked on night mode button

            // the current theme have nightMode inbuild only we have to use
            int nightMode = AppCompatDelegate.getDefaultNightMode();

            // set the theme by checking which theme right now is working
            if(nightMode == AppCompatDelegate.MODE_NIGHT_YES) {            //  if already night mode then remove it
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            }

            else {       // if not night mode then apply night mode
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            }
            // recreate the activity so changes may applied
            recreate();            // we have to save instance as we are recreating the acitivity
        }
        return true;
    }

    // minus icon clicked but for which team to short out that we used switch
    public void deceaseScore(View view) {

        switch(view.getId()) {

            case R.id.decreaseTeam1: mscore1--;
                mScoreText1.setText(String.valueOf(mscore1));
                break;

            case R.id.decreaseTeam2: mscore2--;
                mScoreText2.setText(String.valueOf(mscore2));
        }
    }

    public void increaseScore(View view) {

        switch(view.getId()) {

            case R.id.increaseTeam1: mscore1++;
                mScoreText1.setText(String.valueOf(mscore1));
                break;

            case R.id.increaseTeam2: mscore2++;
                mScoreText2.setText(String.valueOf(mscore2));
        }
    }
}