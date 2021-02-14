package com.example.secondapp;


import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.graphics.Typeface;


public class BlankFragment2 extends Fragment {

        private CheckBox cbDetective, cbDoctor, cbWoman, cbDon, cbManiac, cbLawer, cbNews, cbStudant, cbWolf, lastChek;

    private  Play p = new Play();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View v = inflater.inflate(R.layout.fragment_blank_fragment2,  null);

        cbDetective = (CheckBox)v.findViewById(R.id.checkBox_detective);
        cbDoctor = (CheckBox)v.findViewById(R.id.checkBox_doctor);
        cbWoman = (CheckBox)v.findViewById(R.id.checkBox_woman);
        cbDon = (CheckBox)v.findViewById(R.id.checkBox_don);
        cbManiac = (CheckBox)v.findViewById(R.id.checkBox_maniac);
        cbLawer = (CheckBox)v.findViewById(R.id.checkBox_lawer);
        cbNews = (CheckBox)v.findViewById(R.id.checkBox_news);
        cbStudant = (CheckBox)v.findViewById(R.id.checkBox_studant);
        cbWolf = (CheckBox)v.findViewById(R.id.checkBox_wolf);

        CheckBoxListener();


        return v;
    }



//    public void CheckingCheckBoxes() {
//        p.ifMasterIsRandom[1] = cbDetective.isChecked();
//        p.ifMasterIsRandom[2] = cbDoctor.isChecked();
//        p.ifMasterIsRandom[3] = cbWoman.isChecked();
//        p.ifMasterIsRandom[4] = cbDon.isChecked();
//        p.ifMasterIsRandom[5] = cbManiac.isChecked();
//        p.ifMasterIsRandom[6] = cbLawer.isChecked();
//        p.ifMasterIsRandom[7] = cbNews.isChecked();
//        p.ifMasterIsRandom[8] = cbStudant.isChecked();
//        p.ifMasterIsRandom[9] = cbWolf.isChecked();
//    }



    private void CheckBoxListener() {
        cbDetective.setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if (cbDetective.isChecked()) {
//                            p.ifMasterIsRandom[1] = true;
                            if(p.VacantPlace!=0){
                                lastChek = cbDetective;
                                p.VacantPlace--;
                            }else {
                                lastChek.setChecked(false);
                                lastChek = cbDetective;
                                p.VacantPlace=0;
                            }
                        } else {
//                            p.ifMasterIsRandom[1] = false;
                            p.VacantPlace++;
                        }
                    }
                }
        );
        cbDoctor.setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if (cbDoctor.isChecked()) {
                            if(p.VacantPlace!=0){
                                lastChek = cbDoctor;
                                p.VacantPlace--;
                            }else {
                                lastChek.setChecked(false);
                                lastChek = cbDoctor;
                                p.VacantPlace=0;
                            }
                        } else {

                            p.VacantPlace++;
                        }
                    }
                }
        );

        cbWoman.setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if (cbWoman.isChecked()) {
                            if(p.VacantPlace!=0){
                                lastChek = cbWoman;
                                p.VacantPlace--;
                            }else {
                                lastChek.setChecked(false);
                                lastChek = cbWoman;
                                p.VacantPlace=0;
                            }
                        } else {
                            p.VacantPlace++;
                        }
                    }
                }
        );

        cbDon.setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if (cbDon.isChecked()) {
                            if(p.VacantPlace!=0){
                                lastChek = cbDon;
                                p.VacantPlace--;
                            }else {
                                lastChek.setChecked(false);
                                lastChek = cbDon;
                                p.VacantPlace=0;
                            }
                        } else {
                            p.VacantPlace++;
                        }
                    }
                }
        );

        cbManiac.setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if (cbManiac.isChecked()) {
                            if(p.VacantPlace!=0){
                                lastChek = cbManiac;
                                p.VacantPlace--;
                            }else {
                                lastChek.setChecked(false);
                                lastChek = cbManiac;
                                p.VacantPlace=0;
                            }
                        } else {
                            p.VacantPlace++;
                        }
                    }
                }
        );

        cbStudant.setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if (cbStudant.isChecked()) {
                            if(p.VacantPlace!=0){
                                lastChek = cbStudant;
                                p.VacantPlace--;
                            }else {
                                lastChek.setChecked(false);
                                lastChek = cbStudant;
                                p.VacantPlace=0;
                            }
                        } else {
                            p.VacantPlace++;
                        }
                    }
                }
        );

        cbLawer.setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if (cbLawer.isChecked()) {
                            if(p.VacantPlace!=0){
                                lastChek = cbLawer;
                                p.VacantPlace--;
                            }else {
                                lastChek.setChecked(false);
                                lastChek = cbLawer;
                                p.VacantPlace=0;
                            }
                        } else {
                            p.VacantPlace++;
                        }
                    }
                }
        );

        cbNews.setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if (cbNews.isChecked()) {
                            if(p.VacantPlace!=0){
                                lastChek = cbNews;
                                p.VacantPlace--;
                            }else {
                                lastChek.setChecked(false);
                                lastChek = cbNews;
                                p.VacantPlace=0;
                            }
                        } else {
                            p.VacantPlace++;
                        }
                    }
                }
        );
        cbWolf.setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if (cbWolf.isChecked()) {
                            if(p.VacantPlace!=0){
                                lastChek = cbWolf;
                                p.VacantPlace--;
                            }else {
                                lastChek.setChecked(false);
                                lastChek = cbWolf;
                                p.VacantPlace=0;
                            }
                        } else {
                            p.VacantPlace++;
                        }
                    }
                }
        );
    }
};
