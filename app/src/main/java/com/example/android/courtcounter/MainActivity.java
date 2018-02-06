package com.example.android.courtcounter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnItemSelectedListener {
    int scoreTeamA = 0;
    int scoreTeamB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);

        //Spinner element
        Spinner spinnerA = (Spinner) findViewById (R.id.spinnerA);
        Spinner spinnerB = (Spinner) findViewById (R.id.spinnerB);

        //Spinner click listener
        spinnerA.setOnItemSelectedListener (this);
        spinnerB.setOnItemSelectedListener (this);

        //Spinner Drop down elements
        List<String> teams = new ArrayList<> ();
        final boolean add = teams.add ("Houston Rockets");
        final boolean add1 = teams.add ("Boston Celtics");
        final boolean add2 = teams.add ("Oklahoma City Thunder");
        final boolean add3 = teams.add ("New York Knicks");
        final boolean add4 = teams.add ("Golden State Warriors");
        final boolean add5 = teams.add ("Cleveland Cavaliers");
        final boolean add6 = teams.add ("None Selected");

        //Creating adapter for spinner
        final String [] list = {"None Selected", "Houston Rockets", "Boston Celtics", "Oklahoma City Thunder", "New York Knicks", "Golden State Warriors", "Cleveland Cavaliers"};

        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, teams);
        spinnerA.setAdapter(spinnerArrayAdapter);
        spinnerB.setAdapter(spinnerArrayAdapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        //On selecting a spinner item
        String item = parent.getItemAtPosition (position).toString ();

        //Showing selected spinner item
        Toast.makeText (parent.getContext (), "Selected: " + item, Toast.LENGTH_LONG).show ();
    }

    public void onNothingSelected(AdapterView<?> arg0) {
        //TODO Auto-generated method stub
    }


    /**
     * Increase the score for Team A by 1 point.
     */
    public void addOneForTeamA(View view) {
        scoreTeamA = scoreTeamA + 1;
        displayForTeamA(scoreTeamA);
    }

    /**
     * Increase the score for Team A by 2 points.
     */
    public void addTwoForTeamA(View view) {
        scoreTeamA = scoreTeamA + 2;
        displayForTeamA(scoreTeamA);
    }

    /**
     * Increase the score for Team A by 3 points..
     */
    public void addThreeForTeamA(View view) {
        scoreTeamA = scoreTeamA + 3;
        displayForTeamA(scoreTeamA);
    }
    public void resetScore(View view) {
        displayForTeamA (0);
        displayForTeamB (0);
        scoreTeamA = 0;
        scoreTeamB = 0;

    }
    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }
    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    public void addOneForTeamB(View view) {
        scoreTeamB = scoreTeamB + 1;
        displayForTeamB (scoreTeamB);
    }

    public void addTwoForTeamB(View view) {
        scoreTeamB = scoreTeamB + 2;
        displayForTeamB (scoreTeamB);
    }
    public void addThreeForTeamB(View view) {
        scoreTeamB = scoreTeamB + 3;
        displayForTeamB (scoreTeamB);
    }
}
