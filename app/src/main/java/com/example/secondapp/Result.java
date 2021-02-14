package com.example.secondapp;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class Result extends Fragment {

    TextView text;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_result,  null);

        text = (TextView)v.findViewById(R.id.textView6);

        IfNull();
        WriteResult();

        return v;
    }

    public void IfNull() {
        for(int i = Play.mafia - 1; i < BeginingOfMaster.howMany; i++) {
            if(BeginingOfMaster.characters[i].alive.length()!=0) {
                BeginingOfMaster.characters[i] = new Character(BeginingOfMaster.characters[i].who,BeginingOfMaster.characters[i].name,"выбрал " + BeginingOfMaster.characters[i].alive);
            }else  {
                BeginingOfMaster.characters[i] = new Character(BeginingOfMaster.characters[i].who,BeginingOfMaster.characters[i].name," никокого не выбрал" );
            }
        }
    }
    public void WriteResult(){
        int i  = BeginingOfMaster.howMany - Play.mafia + 1;
        for(int j = 0; j < i; j++) {
            text.setText( "Игрок " + BeginingOfMaster.characters[Play.mafia-1+j].name + "(" +BeginingOfMaster.characters[Play.mafia-1+j].who+") "+BeginingOfMaster.characters[Play.mafia-1+j].alive);
        }
    }
}