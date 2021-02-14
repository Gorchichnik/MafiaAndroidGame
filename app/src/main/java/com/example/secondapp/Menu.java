package com.example.secondapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Menu extends AppCompatActivity {

    private Button btnPlay, btnRules,  btnExit;
    private TextView mafia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        btnPlay = (Button)findViewById(R.id.play);
        btnRules = (Button)findViewById(R.id.rules);
        btnExit = (Button)findViewById(R.id.exit);
        mafia = (TextView)findViewById(R.id.textView);
        Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/second.ttf");
        mafia.setTypeface(tf);
        Typeface tf1 = Typeface.createFromAsset(getAssets(), "fonts/third.ttf");
        btnPlay.setTypeface(tf1);
        btnRules.setTypeface(tf1);
        btnExit.setTypeface(tf1);

        ListenerOnButton();
    }
    private void ListenerOnButton() {
        btnPlay.setOnClickListener(

                new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(".Play");
                        startActivity(intent);
                    }
                }

        );

    }
}
