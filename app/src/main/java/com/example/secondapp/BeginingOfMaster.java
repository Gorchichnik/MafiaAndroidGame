package com.example.secondapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import static com.example.secondapp.R.color.colorDay;


public class BeginingOfMaster extends AppCompatActivity {

    private Button btn, btnMenu;
    private ImageView Image;
    private boolean stayNight = true, firstNight = true, GoTimer = false;
    private int way1 = 1,way2 = 0, order;
    public static  int howMany;

    public static Character[] characters;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_begining_of_master);

        btn = (Button)findViewById(R.id.city_sleep);
        btnMenu = (Button)findViewById(R.id.button3);
        Image = (ImageView)findViewById(R.id.imageView3);

        CreateCharacter();
        ButtonListener();

    }

    public void CreateCharacter() {
        howMany = Play.mafia;

        for(int i = 1; i<10; i++) {
            if(Play.ifMasterIsRandom[i]) {
                howMany++;
            }
        }
        characters = new Character[howMany];
        int n = 0;
        for(int i = 0; i < Play.mafia; i++) {
            characters[n] = new Character("Мафия","кто-то",null);

            n++;
        }


        for(int i = 1; i<10; i++) {
            if(Play.ifMasterIsRandom[i]) {
                switch (i) {
                    case 1:
                        characters[n] = new Character("Детектив",null,null);
                        break;
                    case 2:
                        characters[n] = new Character("Доктор",null,null);
                        break;
                    case 3:
                        characters[n] = new Character("Любовница",null,null);
                        break;
                    case 4:
                        characters[n] = new Character("Дон",null,null);
                        break;
                    case 5:
                        characters[n] = new Character("Маньяк",null,null);
                        break;
                    case 6:
                        characters[n] = new Character("Адвокат",null,null);
                        break;
                    case 7:
                        characters[n] = new Character("Журналист",null,null);
                        break;
                    case 8:
                        characters[n] = new Character("Студент",null,null);
                        break;
                    case 9:
                        characters[n] = new Character("Оборотень",null,null);
                        break;

                }
                n++;
            }
        }
    }

    public void MafiaMeeting() {
        for(int i = 0; i< Play.mafia; i++) {
            SomeFragment(i+1);
        }
        order = Play.mafia;
        if(howMany!=Play.mafia)
            btn.setText("Просыпается " + characters[Play.mafia].who);
        else {
            btn.setText("Город просыпается");
            stayNight = false;
        }
    }

    public void SomeFragment(int i) {
        switch (i) {
            case 1:
                Fragment fragment1 = new MafiaMeeting();

                FragmentManager fm1 = getSupportFragmentManager();
                FragmentTransaction ft1 = fm1.beginTransaction();
                ft1.replace(R.id.fragment4, fragment1);
                ft1.commit();
                break;
            case 2:
                Fragment fragment2 = new MafiaMeeting2();

                FragmentManager fm2 = getSupportFragmentManager();
                FragmentTransaction ft2 = fm2.beginTransaction();
                ft2.replace(R.id.fragment, fragment2);
                ft2.commit();
                break;
            case 3:
                Fragment fragment3 = new MafiaMeeting3();

                FragmentManager fm3 = getSupportFragmentManager();
                FragmentTransaction ft3 = fm3.beginTransaction();
                ft3.replace(R.id.fragment3, fragment3);
                ft3.commit();
                break;
            case 4:
                Fragment fragment4 = new MafiaMeeting4();

                FragmentManager fm4 = getSupportFragmentManager();
                FragmentTransaction ft4 = fm4.beginTransaction();
                ft4.replace(R.id.fragment5, fragment4);
                ft4.commit();
                break;
            case 5:
                Fragment fragment5 = new MafiaMeeting5();

                FragmentManager fm5 = getSupportFragmentManager();
                FragmentTransaction ft5 = fm5.beginTransaction();
                ft5.replace(R.id.fragment6, fragment5);
                ft5.commit();
                break;
            case 6:
                Fragment fragment6 = new MafiaMeeting6();

                FragmentManager fm6 = getSupportFragmentManager();
                FragmentTransaction ft6 = fm6.beginTransaction();
                ft6.replace(R.id.fragment7, fragment6);
                ft6.commit();
        }
    }

    public void WriteMafiaNames() {
        for(int i = 0; i < Play.mafia; i++) {
            WriteNameFromSome(i+1);
        }
    }

    public void WriteNameFromSome(int i) {
        switch (i) {
            case 1:
                Fragment frog1 = getSupportFragmentManager().findFragmentById(R.id.fragment4);
                characters[0] = new Character(characters[0].who, ((EditText) frog1.getView().findViewById(R.id.editTextmafia)).getText().toString(),null);
                break;
            case 2:
                Fragment frog2 = getSupportFragmentManager().findFragmentById(R.id.fragment);
                characters[1] = new Character(characters[1].who, ((EditText) frog2.getView().findViewById(R.id.editTextmafia)).getText().toString(),null);
                break;
            case 3:
                Fragment frog3 = getSupportFragmentManager().findFragmentById(R.id.fragment3);
                characters[2] = new Character(characters[2].who, ((EditText) frog3.getView().findViewById(R.id.editTextmafia)).getText().toString(),null);
                break;
            case 4:
                Fragment frog4 = getSupportFragmentManager().findFragmentById(R.id.fragment5);
                characters[3] = new Character(characters[3].who, ((EditText) frog4.getView().findViewById(R.id.editTextmafia)).getText().toString(),null);
                break;
            case 5:
                Fragment frog5 = getSupportFragmentManager().findFragmentById(R.id.fragment6);
                characters[4] = new Character(characters[4].who, ((EditText) frog5.getView().findViewById(R.id.editTextmafia)).getText().toString(),null);
                break;
            case 6:
                Fragment frog6 = getSupportFragmentManager().findFragmentById(R.id.fragment7);
                characters[5] = new Character(characters[5].who, ((EditText) frog6.getView().findViewById(R.id.editTextmafia)).getText().toString(),null);
                break;
        }
    }

    public void ClearAllMeetings() {
        for(int i = 2; i < Play.mafia + 1; i++) {
            switch (i) {
                case 2:
                    Fragment fragment2 = new BlankFragmentRealyBlank();

                    FragmentManager fm2 = getSupportFragmentManager();
                    FragmentTransaction ft2 = fm2.beginTransaction();
                    ft2.replace(R.id.fragment, fragment2);
                    ft2.commit();
                    break;
                case 3:
                    Fragment fragment3 = new BlankFragmentRealyBlank();

                    FragmentManager fm3 = getSupportFragmentManager();
                    FragmentTransaction ft3 = fm3.beginTransaction();
                    ft3.replace(R.id.fragment3, fragment3);
                    ft3.commit();
                    break;
                case 4:
                    Fragment fragment4 = new BlankFragmentRealyBlank();

                    FragmentManager fm4 = getSupportFragmentManager();
                    FragmentTransaction ft4 = fm4.beginTransaction();
                    ft4.replace(R.id.fragment5, fragment4);
                    ft4.commit();
                    break;
                case 5:
                    Fragment fragment5 = new BlankFragmentRealyBlank();

                    FragmentManager fm5 = getSupportFragmentManager();
                    FragmentTransaction ft5 = fm5.beginTransaction();
                    ft5.replace(R.id.fragment6, fragment5);
                    ft5.commit();
                    break;
                case 6:
                    Fragment fragment6 = new BlankFragmentRealyBlank();

                    FragmentManager fm6 = getSupportFragmentManager();
                    FragmentTransaction ft6 = fm6.beginTransaction();
                    ft6.replace(R.id.fragment7, fragment6);
                    ft6.commit();
            };
        }

    }
    public void SomeOneMeeting() {
        if(order==Play.mafia) {
            WriteMafiaNames();
            ClearAllMeetings();
            if (order + 1 == howMany) {
                btn.setText("Просыпается город");
                stayNight = false;
            } else {
                btn.setText("Просыпается " + characters[order+1].who);
            }


        }else {
            Fragment frog1 = getSupportFragmentManager().findFragmentById(R.id.fragment4);
            characters[order - 1] = new Character(characters[order - 1].who, ((EditText) frog1.getView().findViewById(R.id.editTextmafia)).getText().toString(),null);
            if (order + 1 == howMany) {
                btn.setText("Просыпается город");
                stayNight = false;
            } else {
                btn.setText("Просыпается " + characters[order+1].who);
            }

        }

        Fragment frog = getSupportFragmentManager().findFragmentById(R.id.fragment4);
        ((TextView) frog.getView().findViewById(R.id.textView2)).setText(characters[order].who);
        ((EditText) frog.getView().findViewById(R.id.editTextmafia)).setText("");



    }
    public void SomeOnePlay() {
        switch (way2) {
            case 0:
                btn.setText("Просыпается мафия");
                Image.setImageResource(R.drawable.night_town);
                btnMenu.setTextColor(getResources().getColor(colorDay));

                LinearLayout view = findViewById(R.id.lay_out);
                view.setBackgroundResource(R.color.colorNight);

                Fragment fragment = new BlankFragmentNight();

                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.fragment4, fragment);
                ft.commit();


                way2++;
                break;
            case 1:


                Fragment fragment1 = new PlayMafia();

                FragmentManager fm1 = getSupportFragmentManager();
                FragmentTransaction ft1 = fm1.beginTransaction();
                ft1.replace(R.id.fragment4, fragment1);
                ft1.commit();

                way2++;
                order = Play.mafia;
                if(howMany!=Play.mafia)
                    btn.setText("Просыпается "+characters[order].who);
                else {
                    btn.setText("Просыпается город");
                    stayNight = false;
                }
                break;
            case 2:
                if(order+1!=howMany) {
                    btn.setText("Просыпается "+characters[order+1].who);
                    Fragment frog = getSupportFragmentManager().findFragmentById(R.id.fragment4);
                    characters[order - 1] = new Character(characters[order - 1].who,characters[order - 1].name,((EditText) frog.getView().findViewById(R.id.editText)).getText().toString());
                    if(characters[order].who=="Любовница") {
                        ((TextView) frog.getView().findViewById(R.id.textView3)).setText("Напиши, кого выбрала " + characters[order].who);
                    }else {
                        ((TextView) frog.getView().findViewById(R.id.textView3)).setText("Напиши, кого выбрал " + characters[order].who);
                    }
                    ((EditText) frog.getView().findViewById(R.id.editText)).setText("");

                } else{
                    btn.setText("Просыпается город");
                    Fragment frog = getSupportFragmentManager().findFragmentById(R.id.fragment4);
                    characters[order - 1] = new Character(characters[order - 1].who,characters[order - 1].name,((EditText) frog.getView().findViewById(R.id.editText)).getText().toString());
                    if(characters[order].who=="Любовница") {
                        ((TextView) frog.getView().findViewById(R.id.textView3)).setText("Напиши, кого выбрала " + characters[order].who);
                    }else {
                        ((TextView) frog.getView().findViewById(R.id.textView3)).setText("Напиши, кого выбрал " + characters[order].who);
                    }
                    ((EditText) frog.getView().findViewById(R.id.editText)).setText("");
                    stayNight = false;
                }
                order++;

        }
    }
    public void ButtonListener() {
        btn.setOnClickListener(
                new View.OnClickListener() {
                    @SuppressLint("ResourceAsColor")
                    @Override
                    public void onClick(View v) {
                        if(GoTimer) {
                            btn.setText("Город засыпает");
                            Image.setImageResource(R.drawable.day_town);
                            btnMenu.setTextColor(R.color.colorNight);

                            LinearLayout view = findViewById(R.id.lay_out);
                            view.setBackgroundResource(colorDay);

                            Fragment fragment = new MyTimer();

                            FragmentManager fm = getSupportFragmentManager();
                            FragmentTransaction ft = fm.beginTransaction();
                            ft.replace(R.id.fragment4, fragment);
                            ft.commit();
                            GoTimer = false;
                            stayNight = true;
                        } else {
                            if (stayNight) {

                                if (firstNight) {
                                    switch (way1) {
                                        case 1:
                                            btn.setText("Просыпается мафия");
                                            Image.setImageResource(R.drawable.night_town);
                                            btnMenu.setTextColor(R.color.colorDay);

                                            LinearLayout view = findViewById(R.id.lay_out);
                                            view.setBackgroundResource(R.color.colorNight);

                                            Fragment fragment = new BlankFragmentNight();

                                            FragmentManager fm = getSupportFragmentManager();
                                            FragmentTransaction ft = fm.beginTransaction();
                                            ft.replace(R.id.fragment4, fragment);
                                            ft.commit();
                                            way1++;
                                            break;
                                        case 2:
                                            MafiaMeeting();
                                            way1++;
                                            break;
                                        case 3:
                                            SomeOneMeeting();
                                            order++;
                                            break;

                                    }

                                } else {
                                    SomeOnePlay();

                                }

                            } else {
                                if (firstNight) {
                                    if (howMany == Play.mafia) {
                                        WriteMafiaNames();
                                        ClearAllMeetings();
                                    } else {
                                        Fragment frog1 = getSupportFragmentManager().findFragmentById(R.id.fragment4);
                                        characters[howMany - 1] = new Character(characters[howMany - 1].who, ((EditText) frog1.getView().findViewById(R.id.editTextmafia)).getText().toString(), null);
                                    }
                                    btn.setText("Город засыпает");
                                    Image.setImageResource(R.drawable.day_town);
                                    btnMenu.setTextColor(R.color.colorNight);

                                    LinearLayout view = findViewById(R.id.lay_out);
                                    view.setBackgroundResource(colorDay);

                                    Fragment fragment = new BlankFragmentDay();

                                    FragmentManager fm = getSupportFragmentManager();
                                    FragmentTransaction ft = fm.beginTransaction();
                                    ft.replace(R.id.fragment4, fragment);
                                    ft.commit();

                                    stayNight = true;
                                    firstNight = false;
                                } else {
                                    Fragment frog = getSupportFragmentManager().findFragmentById(R.id.fragment4);
                                    characters[order - 1] = new Character(characters[order - 1].who, characters[order - 1].name, ((EditText) frog.getView().findViewById(R.id.editText)).getText().toString());
                                    btn.setText("Обсуждение");
                                    Image.setImageResource(R.drawable.day_town);
                                    btnMenu.setTextColor(R.color.colorNight);

                                    LinearLayout view = findViewById(R.id.lay_out);
                                    view.setBackgroundResource(colorDay);

                                    Fragment fragment = new Result();

                                    FragmentManager fm = getSupportFragmentManager();
                                    FragmentTransaction ft = fm.beginTransaction();
                                    ft.replace(R.id.fragment4, fragment);
                                    ft.commit();
                                    GoTimer = true;
                                }

                            }
                        }
                    }
                }
        );
        btnMenu.setOnClickListener(
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
