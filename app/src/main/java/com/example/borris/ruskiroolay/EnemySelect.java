package com.example.borris.ruskiroolay;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by Borris on 6/7/2016.
 */
public class EnemySelect extends AppCompatActivity implements View.OnClickListener {


    ImageView ian;
    ImageView sarah;
    ImageView josh;
    Button quit;

    static int scoreRounds=0;
    static int scoreEnemies=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enemy_select);


        ian = (ImageView) findViewById(R.id.ian);
        sarah = (ImageView) findViewById(R.id.sarah);
        josh = (ImageView) findViewById(R.id.josh);
        ian.setOnClickListener(this);
        sarah.setOnClickListener(this);
        josh.setOnClickListener(this);
        ian.setTag("ian");
        sarah.setTag("sarah");
        josh.setTag("josh");

        quit = (Button) findViewById(R.id.returnButton);
        quit.setTag("QUIT");
        quit.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        String tag = String.valueOf(v.getTag());

        if(tag.equals("QUIT")){


            quitAction();

        }else {





            // switch(id){

            //     case "ian":


            Intent intentGame = new Intent(this, GamePlay.class);
            intentGame.putExtra("enemy", tag);
            startActivityForResult(intentGame, 0);
            //          break;
            //      case "sarah":

            //          break;
            //      case "josh":

            //             break;

            //     }

        }
    }


    public void quitAction(){

        AlertDialog.Builder builder = new AlertDialog.Builder(EnemySelect.this);
        builder.setTitle("QUIT?");
        builder.setMessage("Are you sure you want to walk away?");
        builder.setPositiveButton("I am a coward", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int num) {

                final MediaPlayer bang = MediaPlayer.create(getApplicationContext(), R.raw.pistol_bang);
                bang.start();
                finish();

            }

        });

        builder.setCancelable(true);

        try {
            builder.show();
        } catch (Exception e) {
            Log.i("bugproblem", e.toString());
        }
    }

    @Override
    public void onBackPressed(){

        quitAction();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        //if(data!=null) {
      //      data.getExtras().getString("profileName");
      //  }

        if (resultCode == 1) {

            scoreEnemies++;
            scoreRounds++;

        }
        else{
            if(resultCode ==2){

                scoreEnemies=0;
                scoreRounds=0;
                finish();
            }
            else {
                if (resultCode == 3) {
                    int score = scoreEnemies;

                    int position = data.getExtras().getInt("position");
                    String username = data.getExtras().getString("username");

                    Intent ii = new Intent(this, Leaderboard.class);
                    Bundle b = new Bundle();
                    b.putInt("position", position);
                    b.putString("username", username);
                    b.putInt("score", score);
                   // ii.putExtra("position", position);
                    ii.putExtras(b);
                    startActivityForResult(ii, 0);

                    scoreEnemies = 0;
                    scoreRounds = 0;
                    finish();
                } else {
                    if (resultCode == 4) {

                        scoreEnemies = 0;
                        scoreRounds = 0;
                        finish();
                    }
                }

            }

        }
    }

}