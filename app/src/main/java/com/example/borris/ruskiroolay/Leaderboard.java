package com.example.borris.ruskiroolay;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Borris on 6/11/2016.
 */
public class Leaderboard extends AppCompatActivity implements View.OnClickListener {

    String legend1, legend2, legend3,legend4, legend5, legend6;
    int score1, score2, score3, score4, score5, score6;
    TextView t1;
    TextView t2;
    TextView t3;
    TextView t4;
    TextView t5;
    TextView t6;
    TextView p1;
    TextView p2;
    TextView p3;
    TextView p4;
    TextView p5;
    TextView p6;
    String switchString;
    int switchInt;

    Button exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.leaderboard_display);

        t1 = (TextView) findViewById(R.id.pos1);
        t2 = (TextView) findViewById(R.id.pos2);
        t3 = (TextView) findViewById(R.id.pos3);
        t4 = (TextView) findViewById(R.id.pos4);
        t5 = (TextView) findViewById(R.id.pos5);
        t6 = (TextView) findViewById(R.id.pos6);

        p1 = (TextView) findViewById(R.id.score1);
        p2 = (TextView) findViewById(R.id.score2);
        p3 = (TextView) findViewById(R.id.score3);
        p4 = (TextView) findViewById(R.id.score4);
        p5 = (TextView) findViewById(R.id.score5);
        p6 = (TextView) findViewById(R.id.score6);

        Button exit = (Button) findViewById(R.id.startButton);
        exit.setOnClickListener(this);


        if(getIntent().getExtras()!=null){

            SharedPreferences settings = getSharedPreferences("prefs_name", 0);
            SharedPreferences.Editor prefEditor = settings.edit();

            int position = getIntent().getExtras().getInt("position");
            int score = getIntent().getExtras().getInt("score");
            String username = getIntent().getExtras().getString("username");

            switch(position){
                case 1:
                    switchString = settings.getString("legend5save", "JOHN DOE");
                    switchInt = settings.getInt("score5save", 1);
                    prefEditor.putString("legend6save", switchString);
                    prefEditor.putInt("score6save", switchInt);
                    switchString = settings.getString("legend4save", "YER DA");
                    switchInt = settings.getInt("score4save", 2);
                    prefEditor.putString("legend5save", switchString);
                    prefEditor.putInt("score5save", switchInt);
                    switchString = settings.getString("legend3save", "B1ll");
                    switchInt = settings.getInt("score3save", 6);
                    prefEditor.putString("legend4save", switchString);
                    prefEditor.putInt("score4save", switchInt);
                    switchString = settings.getString("legend2save", "YER DA");
                    switchInt = settings.getInt("score2save", 10);
                    prefEditor.putString("legend3save", switchString);
                    prefEditor.putInt("score3save", switchInt);
                    switchString = settings.getString("legend1save", "WALKEN");
                    switchInt = settings.getInt("score1save", 30);
                    prefEditor.putString("legend2save", switchString);
                    prefEditor.putInt("score2save", switchInt);

                    prefEditor.putString("legend1save", username);
                    prefEditor.putInt("score1save", score);
                    t1.setBackgroundColor(Color.BLUE);
                    p1.setBackgroundColor(Color.BLUE);
                    break;
                case 2:
                    switchString = settings.getString("legend5save", "JOHN DOE");
                    switchInt = settings.getInt("score5save", 1);
                    prefEditor.putString("legend6save", switchString);
                    prefEditor.putInt("score6save", switchInt);
                    switchString = settings.getString("legend4save", "YER DA");
                    switchInt = settings.getInt("score4save", 2);
                    prefEditor.putString("legend5save", switchString);
                    prefEditor.putInt("score5save", switchInt);
                    switchString = settings.getString("legend3save", "B1ll");
                    switchInt = settings.getInt("score3save", 6);
                    prefEditor.putString("legend4save", switchString);
                    prefEditor.putInt("score4save", switchInt);
                    switchString = settings.getString("legend2save", "YER DA");
                    switchInt = settings.getInt("score2save", 10);
                    prefEditor.putString("legend3save", switchString);
                    prefEditor.putInt("score3save", switchInt);

                    prefEditor.putString("legend2save", username);
                    prefEditor.putInt("score2save", score);
                    t2.setBackgroundColor(Color.BLUE);
                    p2.setBackgroundColor(Color.BLUE);
                    break;
                case 3:
                    switchString = settings.getString("legend5save", "JOHN DOE");
                    switchInt = settings.getInt("score5save", 1);
                    prefEditor.putString("legend6save", switchString);
                    prefEditor.putInt("score6save", switchInt);
                    switchString = settings.getString("legend4save", "YER DA");
                    switchInt = settings.getInt("score4save", 2);
                    prefEditor.putString("legend5save", switchString);
                    prefEditor.putInt("score5save", switchInt);
                    switchString = settings.getString("legend3save", "B1ll");
                    switchInt = settings.getInt("score3save", 6);
                    prefEditor.putString("legend4save", switchString);
                    prefEditor.putInt("score4save", switchInt);

                    prefEditor.putString("legend3save", username);
                    prefEditor.putInt("score3save", score);
                    t3.setBackgroundColor(Color.BLUE);
                    p3.setBackgroundColor(Color.BLUE);
                    break;
                case 4:
                    switchString = settings.getString("legend5save", "JOHN DOE");
                    switchInt = settings.getInt("score5save", 1);
                    prefEditor.putString("legend6save", switchString);
                    prefEditor.putInt("score6save", switchInt);
                    switchString = settings.getString("legend4save", "YER DA");
                    switchInt = settings.getInt("score4save", 2);
                    prefEditor.putString("legend5save", switchString);
                    prefEditor.putInt("score5save", switchInt);

                    prefEditor.putString("legend4save", username);
                    prefEditor.putInt("score4save", score);
                    t4.setBackgroundColor(Color.BLUE);
                    p4.setBackgroundColor(Color.BLUE);
                    break;
                case 5:
                    switchString = settings.getString("legend5save", "JOHN DOE");
                    switchInt = settings.getInt("score5save", 1);
                    prefEditor.putString("legend6save", switchString);
                    prefEditor.putInt("score6save", switchInt);


                    prefEditor.putString("legend5save", username);
                    prefEditor.putInt("score5save", score);
                    t5.setBackgroundColor(Color.BLUE);
                    p5.setBackgroundColor(Color.BLUE);
                    break;
                case 6:

                    prefEditor.putString("legend6save", username);
                    prefEditor.putInt("score6save", score);
                    t6.setBackgroundColor(Color.BLUE);
                    p6.setBackgroundColor(Color.BLUE);
                    break;

            }


            prefEditor.commit();

        }

        // Restore preferences
        SharedPreferences settings = getSharedPreferences("prefs_name", 0);
        // SharedPreferences.Editor prefEditor = settings.edit();
        //prefEditor.clear().commit();
        legend1 = settings.getString("legend1save", "WALKEN");
        legend2 = settings.getString("legend2save", "YER DA");
        legend3 = settings.getString("legend3save", "B1LL");
        legend4 = settings.getString("legend4save", "YER DA");
        legend5 = settings.getString("legend5save", "JOHN DOE");
        legend6 = settings.getString("legend6save", "YER DA");
        score1 = settings.getInt("score1save", 30);
        score2 = settings.getInt("score2save", 10);
        score3 = settings.getInt("score3save", 6);
        score4 = settings.getInt("score4save", 2);
        score5 = settings.getInt("score5save", 1);
        score6 = settings.getInt("score6save", 0);

        // prefEditor.commit();

        t1.setText(legend1);
        t2.setText(legend2);
        t3.setText(legend3);
        t4.setText(legend4);
        t5.setText(legend5);
        t6.setText(legend6);

        p1.setText(""+score1);
        p2.setText(""+score2);
        p3.setText(""+score3);
        p4.setText(""+score4);
        p5.setText(""+score5);
        p6.setText(""+score6);

    }


    @Override
    protected void onStop(){
        super.onStop();

        SharedPreferences settings = getSharedPreferences("prefs_name", 0);
        SharedPreferences.Editor prefEditor = settings.edit();
        prefEditor.clear().commit();
        prefEditor.putString("legend1save", legend1);
        prefEditor.putString("legend2save", legend2);
        prefEditor.putString("legend3save", legend3);
        prefEditor.putString("legend4save", legend4);
        prefEditor.putString("legend5save", legend5);
        prefEditor.putString("legend6save", legend6);

        prefEditor.putInt("score1save", score1);
        prefEditor.putInt("score2save", score2);
        prefEditor.putInt("score3save", score3);
        prefEditor.putInt("score4save", score4);
        prefEditor.putInt("score5save", score5);
        prefEditor.putInt("score6save", score6);

        prefEditor.commit();
    }


    @Override
    public void onClick(View v) {
        setResult(4);
        finish();
    }
}
