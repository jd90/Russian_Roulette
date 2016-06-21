package com.example.borris.ruskiroolay;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Borris on 6/12/2016.
 */
public class Help extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.help);


        Button b = (Button) findViewById(R.id.startButton);
        b.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        finish();

    }
}
