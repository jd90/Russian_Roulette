package com.example.borris.ruskiroolay;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button help;
    Button start;
    Button leader;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final MediaPlayer buttonSound = MediaPlayer.create(MainActivity.this, R.raw.pistol_intro);
        final Animation animRotate = AnimationUtils.loadAnimation(this, R.anim.anim_rotate);
        ImageView imageRotate = (ImageView) findViewById(R.id.roolay_logo);
        imageRotate.startAnimation(animRotate);
        buttonSound.start();

        start = (Button) findViewById(R.id.startButton);
        help = (Button) findViewById(R.id.helpButton);
        leader = (Button) findViewById(R.id.leaderboardButton);
        start.setTag("start");
        help.setTag("help");
        leader.setTag("leader");
        start.setOnClickListener(this);
        help.setOnClickListener(this);
        leader.setOnClickListener(this);

        EnemySelect.scoreEnemies=0;
        EnemySelect.scoreRounds=0;

    }

    @Override
    public void onClick(View v) {

        String viewTag = String.valueOf(v.getTag());

        switch(viewTag){

            case "help":
                Intent startIntent = new Intent(this, Help.class);
                startActivity(startIntent);

                break;

            case "start":

                startIntent = new Intent(this, EnemySelect.class);
                startActivity(startIntent);

                break;

            case "leader":

                startIntent = new Intent(this, Leaderboard.class);
                startActivity(startIntent);

                break;
        }

    }
}
