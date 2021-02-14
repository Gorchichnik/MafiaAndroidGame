package com.example.secondapp;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;


public class MyTimer extends Fragment {


    static Button btnStart;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_my_timer,  null);

        btnStart = (Button)v.findViewById(R.id.button4);



        btnStart.setText("старт");
        OnButtonListener();

        return v;
    }

    public void OnButtonListener() {
        btnStart.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(".Menu");
                        startActivity(intent);
                    }
                }
        );
    }





}