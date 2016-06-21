package com.example.borris.ruskiroolay;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

/**
 * Created by Borris on 6/8/2016.
 */
public class GamePlay extends AppCompatActivity implements View.OnClickListener{

    int enemy1Chamber;
    Button one;
    Button two;
    Button three;
    ImageView enemyImage;
    ImageView playerImage;
    TextView scoreTitle;
    String enemy;
    boolean cont;
    int position=88;
    EditText userInput;

    MediaPlayer spin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_play);


        Intent i = this.getIntent();
        enemy = i.getStringExtra("enemy");

        enemyImage = (ImageView) findViewById(R.id.enemyImage);
        playerImage=(ImageView) findViewById(R.id.behind);

        one =(Button) findViewById(R.id.helpButton);
        two =(Button) findViewById(R.id.startButton);
        three =(Button) findViewById(R.id.leaderboardButton);

        one.setOnClickListener(null);
        two.setOnClickListener(null);
        three.setOnClickListener(this);

        one.setVisibility(View.VISIBLE);
        two.setVisibility(View.VISIBLE);
        one.setText("");
        two.setText("");
        three.setText("START");

        scoreTitle = (TextView) findViewById(R.id.roundsTitle);
        scoreTitle.setText("Rounds = "+EnemySelect.scoreRounds + "\n Enemies = "+EnemySelect.scoreEnemies);


        if(enemy.equals("ian")){
            enemyImage.setImageResource(R.drawable.ian2);
        }
        if(enemy.equals("sarah")){
            enemyImage.setImageResource(R.drawable.sarah2);
        }
        if(enemy.equals("josh")){
            enemyImage.setImageResource(R.drawable.josh2);
        }


        spin = MediaPlayer.create(this, R.raw.pistol_spin);


    }


    @Override
    public void onClick(View v) {

        two.setOnClickListener(null);
        three.setOnClickListener(null);
        one.setOnClickListener(null);

        Button b = (Button)v;
        String buttonText = String.valueOf(b.getText());

            if (buttonText.equals("NEXT") || buttonText.equals("START")) {


                    Random rn = new Random();
                    enemy1Chamber = rn.nextInt(6 - 1 + 1) + 1;


                gameRound();
            }
        else{
        if(buttonText.equals("SPIN")||buttonText.equals("FIRE")){

            Random rn = new Random();
            enemy1Chamber = rn.nextInt(6 - 1 + 1) + 1;

            MediaPlayer spin = MediaPlayer.create(this, R.raw.pistol_spin);
            if (buttonText.equals("SPIN")) {
                spin.start();

                one.setOnClickListener(this);
                two.setOnClickListener(this);
            }
            if(buttonText.equals("FIRE")) {

                playerRound();
            }

        }

            }
    }



    public void gameRound() {


        switch (enemy) {

            case "ian":
                enemyImage.setImageResource(R.drawable.iangun2);
                break;
            case "sarah":
                enemyImage.setImageResource(R.drawable.sarahgun2);
                break;
            case "josh":
                enemyImage.setImageResource(R.drawable.joshgun2);
                break;

        }


        MediaPlayer spin = MediaPlayer.create(this, R.raw.pistol_spin);
        spin.start();

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {



                if (enemy1Chamber == 1) {

                    cont = true;
Log.i("cont1", ""+cont);
                    final MediaPlayer bang = MediaPlayer.create(getApplicationContext(), R.raw.pistol_bang);


                    switch (enemy) {
                        case "ian":
                            enemyImage.setImageResource(R.drawable.ianblast2);
                            bang.start();
                            break;
                        case "sarah":
                            enemyImage.setImageResource(R.drawable.sarahblast2);
                            bang.start();
                            break;
                        case "josh":
                            enemyImage.setImageResource(R.drawable.joshblast2);
                            bang.start();
                            break;
                    }

                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            //Do something after 3000ms

                            MediaPlayer surviver = MediaPlayer.create(getApplicationContext(), R.raw.surviver);

                            switch (enemy) {
                                case "ian":
                                    enemyImage.setImageResource(R.drawable.iandead2);
                                    surviver.start();

                                    break;
                                case "sarah":
                                    enemyImage.setImageResource(R.drawable.sarahdead2);
                                    surviver.start();
                                    break;
                                case "josh":
                                    enemyImage.setImageResource(R.drawable.joshdead2);
                                    surviver.start();
                                    break;
                            }


                            one.setOnClickListener(null);
                            two.setOnClickListener(null);
                            three.setOnClickListener(null);

                            //three.setText("NEXT ENEMY");
                            AlertDialog.Builder builder = new AlertDialog.Builder(GamePlay.this);
                            builder.setTitle("Killer!");
                            builder.setMessage("Congratulations, please press continue when you are ready to select a new enemy");
                            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int num) {

                                    //String message = "some message text";
                                    //Intent intentBack = new Intent();

                                    setResult(1);
                                    finish();
                                }

                            });

                            builder.setCancelable(false);

                            try {
                                builder.show();
                            } catch (Exception e) {
                                Log.i("bugproblem", e.toString());
                            }


                        }


                    }, 1000);


                    /**
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            finish();
                        }
                    }, 3000);

                     **/




                } else {

                    EnemySelect.scoreRounds++;
                    cont = false;
                    final MediaPlayer click = MediaPlayer.create(getApplicationContext(), R.raw.pistol_click);
                    final MediaPlayer spin = MediaPlayer.create(getApplicationContext(), R.raw.pistol_spin);

                    Log.i("cont2", ""+cont);
                    switch (enemy) {
                        case "ian":
                            enemyImage.setImageResource(R.drawable.iangunclick2);
                            click.start();
                            break;
                        case "sarah":
                            enemyImage.setImageResource(R.drawable.sarahgunclick2);
                            click.start();
                            break;
                        case "josh":
                            enemyImage.setImageResource(R.drawable.joshgunclick2);
                            click.start();
                            break;
                    }

                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            switch (enemy) {
                                case "ian":
                                    enemyImage.setImageResource(R.drawable.ian2);
                                    break;
                                case "sarah":
                                    enemyImage.setImageResource(R.drawable.sarah2);
                                    break;
                                case "josh":
                                    enemyImage.setImageResource(R.drawable.josh2);
                                    break;
                            }
                        }
                    }, 750);

                    handler.postDelayed(new Runnable() {
                        @Override
                       public void run() {





                         //   handler.postDelayed(new Runnable() {
                          //      @Override
                           //     public void run() {
                                    playerImage.setImageResource(R.drawable.behindgun2);

                            spin.start();

                                    one.setText("SPIN");
                                    two.setText("FIRE");
                                    three.setText("");
                                    one.setVisibility(View.VISIBLE);
                                    two.setVisibility(View.VISIBLE);
                                    three.setOnClickListener(null);
                                    one.setOnClickListener(GamePlay.this);
                                    two.setOnClickListener(GamePlay.this);

                           //     }}, 400);

                        }
                    }, 1000);




                }


            }
        }, 1000);

        Log.i("cont3", ""+cont);
       // handler.postDelayed(new Runnable() {
     //       @Override
     //       public void run() {
                //this just pauses the return??
    //        }
   //     }, 1000);

    }


    public void playerRound(){


        final MediaPlayer spin = MediaPlayer.create(this, R.raw.pistol_spin);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {


                if (enemy1Chamber == 1) {

                    cont = true;
                    Log.i("cont1", ""+cont);
                    final MediaPlayer bang = MediaPlayer.create(getApplicationContext(), R.raw.pistol_bang);


                    playerImage.setImageResource(R.drawable.behindblast2);
                    bang.start();

                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            //Do something after 3000ms

                            MediaPlayer surviver = MediaPlayer.create(getApplicationContext(), R.raw.deid);


                                    surviver.start();


                            one.setOnClickListener(null);
                            two.setOnClickListener(null);
                            three.setOnClickListener(null);

                            //three.setText("NEXT ENEMY");

// Restore preferences
                            SharedPreferences settings = getSharedPreferences("prefs_name", 0);
                            // SharedPreferences.Editor prefEditor = settings.edit();
                            //prefEditor.clear().commit();

                            int score1 = settings.getInt("score1save", 30);
                            int score2 = settings.getInt("score2save", 10);
                            int score3 = settings.getInt("score3save", 6);
                            int score4 = settings.getInt("score4save", 2);
                            int score5 = settings.getInt("score5save", 1);
                            int score6 = settings.getInt("score6save", 0);

                            if(EnemySelect.scoreEnemies>score1){
                                position=1;
                            }else {
                                if (EnemySelect.scoreEnemies > score2) {
                                    position = 2;
                                }else {
                                    if (EnemySelect.scoreEnemies > score3) {

                                        position = 3;
                                    }else {
                                        if (EnemySelect.scoreEnemies > score4) {

                                            position = 4;
                                        }else {
                                            if (EnemySelect.scoreEnemies > score5) {

                                                position = 5;
                                            }else {
                                                if (EnemySelect.scoreEnemies > score6) {

                                                    position = 6;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                                // prefEditor.commit();
                            if(position!=88) {
                                userInput = new EditText(GamePlay.this);
                                userInput.setHint("Enter Name...");
                                AlertDialog.Builder builder = new AlertDialog.Builder(GamePlay.this);
                                builder.setTitle("\"Ya Dancer! Ye've hit the scoreboards!\"");
                                builder.setView(userInput);
                                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int num) {



                                            Intent i = new Intent();
                                        Bundle e = new Bundle();
                                        e.putInt("position", position);
                                        e.putString("username", userInput.getText().toString().toUpperCase());
                                        i.putExtras(e);
                                        Log.i("issueissue", ""+position);
                                         //   i.putExtra("position", position);
                                        //i.putExtra("username", userInput.getText().toString().toUpperCase());
                                            setResult(3, i);
                                            finish();

                                        }
                                });

                                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int num) {
                                        dialog.cancel();
                                    }
                                });
                                builder.setCancelable(false);

                                try {
                                    builder.show();
                                } catch (Exception e) {
                                    Log.i("bugproblem", e.toString());
                                }
                            }

                            else {

                                AlertDialog.Builder builder = new AlertDialog.Builder(GamePlay.this);
                                builder.setTitle("THAT'S YOU DEID!");
                                builder.setMessage("\nBetter luck next time?\n");
                                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int num) {

                                        setResult(2);
                                        finish();

                                    }

                                });

                                builder.setCancelable(false);

                                try {
                                    builder.show();
                                } catch (Exception e) {
                                    Log.i("bugproblem", e.toString());
                                }

                            }
                        }


                    }, 1000);


                    /**
                     handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                    finish();
                    }
                    }, 3000);

                     **/




                } else {

                    scoreTitle.setText("Rounds = "+EnemySelect.scoreRounds + "\n Enemies = "+EnemySelect.scoreEnemies);


                    cont = false;
                    final MediaPlayer click = MediaPlayer.create(getApplicationContext(), R.raw.pistol_click);



                            playerImage.setImageResource(R.drawable.behindgunclick2);
                            click.start();

                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            playerImage.setImageResource(R.drawable.behind2);


                            switch (enemy) {
                                case "ian":
                                    enemyImage.setImageResource(R.drawable.iangun2);
                                    break;
                                case "sarah":
                                    enemyImage.setImageResource(R.drawable.sarahgun2);
                                    break;
                                case "josh":
                                    enemyImage.setImageResource(R.drawable.joshgun2);
                                    break;
                            }

                            one.setText("");
                            two.setText("");
                            three.setText("NEXT");
                            one.setOnClickListener(null);
                            two.setOnClickListener(null);
                            three.setOnClickListener(GamePlay.this);
                        }
                    }, 750);


                }


            }
        }, 250);

        Log.i("cont3", ""+cont);
        // handler.postDelayed(new Runnable() {
        //       @Override
        //       public void run() {
        //this just pauses the return??
        //        }
        //     }, 1000);



    }

    public void quitAction(){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("QUIT?");
        builder.setMessage("Are you sure you want to walk away?");
        builder.setPositiveButton("I am a coward", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int num) {

                final MediaPlayer bang = MediaPlayer.create(getApplicationContext(), R.raw.pistol_bang);
                bang.start();
                setResult(2);
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

}
