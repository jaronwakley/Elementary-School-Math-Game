package com.example.jaron.mathfun;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity
{

    private Settings settings = Settings.getInstance();
    TextView title;
    Button start;
    Button highScores;
    Button languageSelect;
    ImageView yellowBalloon;
    ImageView orangeBalloon;
    ImageView redBalloon;
    ImageView greenBalloon;
    ImageView blueBalloon;
    ImageView purpleBalloon;
    ImageView pinkBalloon;
    ImageView yellowBalloon_1;
    ImageView orangeBalloon_1;
    ImageView redBalloon_1;
    ImageView greenBalloon_1;
    ImageView blueBalloon_1;
    ImageView purpleBalloon_1;
    ImageView pinkBalloon_1;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        //Keep language settings in internal storage.
        super.onCreate(savedInstanceState);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_main);
        //MediaPlayer ring= MediaPlayer.create(MainActivity.this, R.raw.ring);
        //ring.start();
        Context context = getApplicationContext();
        //getSupportActionBar().hide();
        SharedPreferences sharedPref = context.getSharedPreferences("mathBalloonsStorage", 0);
        SharedPreferences.Editor editor = sharedPref.edit();
        //Saved game upload
        settings.levelTwo =  sharedPref.getBoolean("levelTwo", false);
        settings.levelThree =  sharedPref.getBoolean("levelThree", false);
        settings.levelFour =  sharedPref.getBoolean("levelFour", false);
        settings.levelFive =  sharedPref.getBoolean("levelFive", false);
        settings.levelSix =  sharedPref.getBoolean("levelSix", false);
        settings.levelSeven =  sharedPref.getBoolean("levelSeven", false);
        settings.levelEight =  sharedPref.getBoolean("levelEight", false);
        settings.levelNine =  sharedPref.getBoolean("levelNine", false);
        settings.levelTen =  sharedPref.getBoolean("levelTen", false);
        settings.levelEleven =  sharedPref.getBoolean("levelEleven", false);
        settings.levelTwelve =  sharedPref.getBoolean("levelTwelve", false);
        settings.lastLevel = sharedPref.getBoolean("lastLevel", false);
        settings.one = sharedPref.getInt("one", 0);
        settings.two = sharedPref.getInt("two", 0);
        settings.three = sharedPref.getInt("three", 0);
        settings.four = sharedPref.getInt("four", 0);
        settings.five = sharedPref.getInt("five", 0);
        settings.six = sharedPref.getInt("six", 0);
        settings.seven = sharedPref.getInt("seven", 0);
        settings.eight = sharedPref.getInt("eight", 0);
        settings.nine = sharedPref.getInt("nine", 0);
        settings.ten = sharedPref.getInt("ten", 0);
        settings.eleven = sharedPref.getInt("eleven", 0);
        settings.twelve = sharedPref.getInt("twelve", 0);
        settings.last = sharedPref.getInt("last", 0);
        editor.apply();
        title = (TextView)findViewById(R.id.title_main_menu);
        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/FreeJemmy.ttf");
        title.setTypeface(font);
        if(settings.language == 1)
        {
            System.out.println("Spanish");
            title.setTextSize(52);
            title.setText("¡Globos de Matemática!");
        }
        else if(settings.language == 2)
        {
            System.out.println("Portuguese");
            title.setTextSize(52);
            title.setText("Balões de Matemática!");
        }
        else
        {
            System.out.println("English");
        }
        start = (Button)findViewById(R.id.start_main_menu);
        if(settings.language == 1)
        {
            System.out.println("Spanish");
            start.setTextSize(80);
            start.setText("Iniciar");
        }
        else if(settings.language == 2)
        {
            System.out.println("Portuguese");
            start.setTextSize(60);
            start.setText("Começar");
        }
        start.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //Jumps to the level select activity here.
                Intent intent = new Intent(getBaseContext(), LevelSelect.class);
                startActivity(intent);
            }
        });
        highScores = (Button)findViewById(R.id.high_scores_main_menu);
        if(settings.language == 1)
        {
            System.out.println("Spanish");
            highScores.setText("Mejores Puntaciones");
        }
        else if(settings.language == 2)
        {
            System.out.println("Portuguese");
            highScores.setText("Pontuações Máximas");
        }
        highScores.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //Jumps to the high scores activity here.
                Intent intent = new Intent(getBaseContext(), HighScores.class);
                startActivity(intent);
            }
        });
        languageSelect = (Button)findViewById(R.id.languages_main_menu);
        languageSelect.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //Jumps to the language select activity here.
                Intent intent = new Intent(getBaseContext(), LanguageSelect.class);
                startActivity(intent);
            }
        });
        greenBalloon = (ImageView)findViewById(R.id.green_balloon);
        greenBalloon.animate().translationY(-2000).setDuration(20000);
        redBalloon = (ImageView)findViewById(R.id.red_balloon);
        redBalloon.animate().translationY(-2000).setDuration(20000);
        yellowBalloon = (ImageView)findViewById(R.id.yellow_balloon);
        yellowBalloon.animate().translationY(-2000).setDuration(20000);
        purpleBalloon = (ImageView)findViewById(R.id.purple_balloon);
        purpleBalloon.animate().translationY(-2000).setDuration(20000);
        orangeBalloon = (ImageView)findViewById(R.id.orange_balloon);
        orangeBalloon.animate().translationY(-2000).setDuration(20000);
        pinkBalloon = (ImageView)findViewById(R.id.pink_balloon);
        pinkBalloon.animate().translationY(-2000).setDuration(20000);
        blueBalloon = (ImageView)findViewById(R.id.blue_balloon);
        blueBalloon.animate().translationY(-2000).setDuration(20000);
        greenBalloon_1 = (ImageView)findViewById(R.id.green_balloon_1);
        greenBalloon_1.animate().translationY(-2000).setDuration(40000);
        redBalloon_1 = (ImageView)findViewById(R.id.red_balloon_1);
        redBalloon_1.animate().translationY(-2000).setDuration(40000);
        yellowBalloon_1 = (ImageView)findViewById(R.id.yellow_balloon_1);
        yellowBalloon_1.animate().translationY(-2000).setDuration(40000);
        purpleBalloon_1 = (ImageView)findViewById(R.id.purple_balloon_1);
        purpleBalloon_1.animate().translationY(-2000).setDuration(40000);
        orangeBalloon_1 = (ImageView)findViewById(R.id.orange_balloon_1);
        orangeBalloon_1.animate().translationY(-2000).setDuration(40000);
        pinkBalloon_1 = (ImageView)findViewById(R.id.pink_balloon_1);
        pinkBalloon_1.animate().translationY(-2000).setDuration(40000);
        blueBalloon_1 = (ImageView)findViewById(R.id.blue_balloon_1);
        blueBalloon_1.animate().translationY(-2000).setDuration(40000);
    }
}

