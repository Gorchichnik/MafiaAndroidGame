package com.example.secondapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.core.view.GestureDetectorCompat;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Choice extends Activity implements GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {
    //Создаем переменные для нашей анимации
    //private Animation logoAnim ;

    private ImageView logoImage;

    private TextView text1, text2;

    private GestureDetectorCompat gd;

    private int[] Arr;

    private int condition = 2;

//    private Play p = new Play();
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice);

        text1 = (TextView)findViewById(R.id.GamerText);
        text2 = (TextView)findViewById(R.id.AnotationText);
        logoImage = (ImageView)findViewById(R.id.CardOfRoleplay);

        //init();
        getTheArray();
        shuffleArray(Arr);


        gd = new GestureDetectorCompat(this,this);
        gd.setOnDoubleTapListener(this);

    }

    @Override
    public boolean onTouchEvent (MotionEvent event) {
        gd.onTouchEvent(event);
        return super.onTouchEvent(event);

    }

    public void GoToNext() {
        Intent intent = new Intent(".BeginingOfMaster");
        startActivity(intent);
    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void Run() {
        if(condition == Arr.length*2 + 1) {
            GoToNext();
        }else {
            if (condition % 2 == 0) {
                if(condition/2 == Arr.length) {
                    text1.setText("Ты последний");
                    text2.setText("Нажми ещё раз и передай устройство Ведущему");
                }else {
                    text2.setText("Нажми ещё раз и передай следующему игроку");
                }
                switch (Arr[condition / 2 - 1]) {
                    case 1:
                        logoImage.setImageResource(R.drawable.master);
                        break;
                    case 2:
                        logoImage.setImageResource(R.drawable.tuz2detective);
                        break;
                    case 3:
                        logoImage.setImageResource(R.drawable.tuz2doctor);
                        break;
                    case 4:
                        logoImage.setImageResource(R.drawable.tuz2woman);
                        break;
                    case 5:
                        logoImage.setImageResource(R.drawable.tuz2don);
                        break;
                    case 6:
                        logoImage.setImageResource(R.drawable.tuz2maniac);
                        break;
                    case 7:
                        logoImage.setImageResource(R.drawable.tuz2lawer);
                        break;
                    case 8:
                        logoImage.setImageResource(R.drawable.tuz2news);
                        break;
                    case 9:
                        logoImage.setImageResource(R.drawable.tuz2studant);
                        break;
                    case 10:
                        logoImage.setImageResource(R.drawable.tuz2wolf);
                        break;
                    case 11:
                        logoImage.setImageResource(R.drawable.tuzmafia);
                        break;
                    case 12:
                        logoImage.setImageResource(R.drawable.tuz2ordinary);
                        break;
                }
                condition++;

            } else {
                text1.setText("Игрок " + ((condition + 1) / 2));
                text2.setText("Нажмите, чтобы посмотреть свою роль");
                logoImage.setImageResource(R.drawable.tuz2);
                condition++;
            }
        }


    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    static void shuffleArray(int[] ar)
    {
        // If running on Java 6 or older, use `new Random()` on RHS here
        Random rnd = ThreadLocalRandom.current();
        for (int i = ar.length - 1; i > 0; i--)
        {
            int index = rnd.nextInt(i + 1);
            // Simple swap
            int a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
    }

    public void getTheArray() {
        //задаётся размер массива: если выбрали первую галочку, то размер массива будет равен
        //колличеству игроков
        if(Play.ifMasterIsRandom[0]){
            Arr = new int[Play.people];
        }else {
            Arr = new int[Play.people -1];
        }


        int WhatIsNextIndexForMafia =0;
        int k = 0;
        for(int i = 0; i<Arr.length; i++) {
            //Идёт перебор массива, поочерёдно присваеются все значения массива
            boolean shouldIGetOut = false;
            for(int j = k; j< Play.ifMasterIsRandom.length; j++) {
                if(Play.ifMasterIsRandom[j]) {
                    Arr[i] = j+1;
                    k = j+1;
                    break;
                }
                if(j == Play.ifMasterIsRandom.length -1) {
                    shouldIGetOut = true;
                }
            }

            if(shouldIGetOut) {
                WhatIsNextIndexForMafia = i;
                break;
            }
        }


        int maf = Play.mafia;
        do {
            Arr[WhatIsNextIndexForMafia] = 11;
            WhatIsNextIndexForMafia++;
            maf--;
        } while (maf!=0);

        int pep = Play.VacantPlace;
        if(pep !=0) {
            do {
                Arr[WhatIsNextIndexForMafia] = 12;
                WhatIsNextIndexForMafia++;
                pep--;
            } while (pep!=0);
        }


    }

//    private void init()
//    {
//// Загружаем анимации в переменные
//        logoAnim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.animation2);
////Запускаем анимацию
//        logoImage.startAnimation(logoAnim);
//
//    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        finish();
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {

        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        return false;
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        return false;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public boolean onDoubleTap(MotionEvent e) {
        Run();
        return false;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {

        return false;
    }
}
