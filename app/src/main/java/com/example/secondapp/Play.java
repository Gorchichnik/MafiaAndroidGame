package com.example.secondapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

public class Play extends AppCompatActivity {

    private Button btnPlusPeople, btnMinusPeople, btnPlusMafia, btnMinusMafia, btnStart, btnStandart, btnAdvanced, btnNext;
    private TextView textPeople, textMafia, peopleNum, mafiaNum, masterTxt;

    private CheckBox cbMaster;

    private boolean mode;

    public static int mafia = 1, people = 5;
    public static int VacantPlace = 3;
    public static boolean[] ifMasterIsRandom = {false, false, false, false, false, false, false, false, false, false};;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play2);

        btnPlusPeople = (Button)findViewById(R.id.button_people_plus);
        btnMinusPeople = (Button)findViewById(R.id.button_people_minus);
        btnPlusMafia = (Button)findViewById(R.id.button_mafia_plus);
        btnMinusMafia = (Button)findViewById(R.id.button_mafia_minus);
        btnStart = (Button)findViewById(R.id.play);
        btnStandart = (Button)findViewById(R.id.standart_mode);
        btnAdvanced = (Button)findViewById(R.id.advanced_mode);
        btnNext = (Button)findViewById(R.id.play);



        cbMaster = (CheckBox)findViewById(R.id.checkBox2);



        peopleNum = (TextView)findViewById(R.id.people_num);
        mafiaNum = (TextView)findViewById(R.id.mafia_num);
        textPeople = (TextView)findViewById(R.id.people);
        textMafia = (TextView)findViewById(R.id.mafia);
        masterTxt = (TextView)findViewById(R.id.master);
        Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/second.ttf");
        textPeople.setTypeface(tf);
        textMafia.setTypeface(tf);
        peopleNum.setTypeface(tf);
        mafiaNum.setTypeface(tf);
        masterTxt.setTypeface(tf);
        Typeface tf1 = Typeface.createFromAsset(getAssets(), "fonts/third.ttf");

        btnStart.setTypeface(tf1);
        btnStandart.setTypeface(tf1);
        btnAdvanced.setTypeface(tf1);


        ListenerOnButton();

        ListenerOnChekBox();
    }

    private void ListenerOnChekBox() {
        cbMaster.setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if(cbMaster.isChecked()){
                            ifMasterIsRandom[0] = true;
                        }else{
                            ifMasterIsRandom[0] = false;
                        }
                    }
                }
        );




    }


    public void CheckingCheckBoxes() {
        Fragment frog = getSupportFragmentManager().findFragmentById(R.id.fragment2);
        ifMasterIsRandom[1] = ((CheckBox) frog.getView().findViewById(R.id.checkBox_detective)).isChecked();
        ifMasterIsRandom[2] = ((CheckBox) frog.getView().findViewById(R.id.checkBox_doctor)).isChecked();
        ifMasterIsRandom[3] =  ((CheckBox) frog.getView().findViewById(R.id.checkBox_woman)).isChecked();
        ifMasterIsRandom[4] = ((CheckBox) frog.getView().findViewById(R.id.checkBox_don)).isChecked();
        ifMasterIsRandom[5] = ((CheckBox) frog.getView().findViewById(R.id.checkBox_maniac)).isChecked();
        ifMasterIsRandom[6] = ((CheckBox) frog.getView().findViewById(R.id.checkBox_lawer)).isChecked();
        ifMasterIsRandom[7] = ((CheckBox) frog.getView().findViewById(R.id.checkBox_news)).isChecked();
        ifMasterIsRandom[8] = ((CheckBox) frog.getView().findViewById(R.id.checkBox_studant)).isChecked();
        ifMasterIsRandom[9] = ((CheckBox) frog.getView().findViewById(R.id.checkBox_wolf)).isChecked();
    }
    private void ListenerOnButton() {
        btnNext.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if(mode)
                        CheckingCheckBoxes();
                        Intent intent = new Intent(".Choice");
                        startActivity(intent);
                    }
                }
        );
        btnPlusPeople.setOnClickListener(

                new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        peopleNum.setText(Integer.toString(Integer.parseInt(peopleNum.getText().toString()) + 1));
                        VacantPlace++;
                        people++;


                    }
                }

        );

        btnMinusPeople.setOnClickListener(

                new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        if (Integer.parseInt(peopleNum.getText().toString())>5)
                        if(VacantPlace!=0){
                            VacantPlace--;
                            peopleNum.setText(Integer.toString(Integer.parseInt(peopleNum.getText().toString()) - 1));
                            people--;
                        }
                    }
                }

        );



        btnPlusMafia.setOnClickListener(

                new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        if(VacantPlace!=0 && 3*(Integer.parseInt(mafiaNum.getText().toString()))<= Integer.parseInt(peopleNum.getText().toString())-1) {
                            mafiaNum.setText(Integer.toString(Integer.parseInt(mafiaNum.getText().toString()) + 1));
                            VacantPlace--;
                            mafia++;
                        }
                    }
                }

        );

        btnMinusMafia.setOnClickListener(

                new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        if(Integer.parseInt(mafiaNum.getText().toString())!=1){
                            mafiaNum.setText(Integer.toString(Integer.parseInt(mafiaNum.getText().toString()) - 1));
                            VacantPlace++;
                            mafia--;
                        }
                    }
                }

        );
    }

    public void Change (View view) {
        Fragment fragment= null;

        switch (view.getId()) {
            case R.id.standart_mode:
                mode = false;
                fragment = new BlankFragment1();
                break;

            case R.id.advanced_mode:
                mode = true;
                fragment = new BlankFragment2();
                break;
        }

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragment2, fragment);
        ft.commit();

    }
}
