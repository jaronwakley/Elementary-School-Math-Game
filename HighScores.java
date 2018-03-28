package com.example.jaron.mathfun;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class HighScores extends AppCompatActivity
{

    private Settings settings = Settings.getInstance();
    TextView title;
    TextView oneText;
    TextView twoText;
    TextView threeText;
    TextView fourText;
    TextView fiveText;
    TextView sixText;
    TextView sevenText;
    TextView eightText;
    TextView nineText;
    TextView tenText;
    TextView elevenText;
    TextView twelveText;
    TextView lastText;
    TextView scoreOne;
    TextView scoreTwo;
    TextView scoreThree;
    TextView scoreFour;
    TextView scoreFive;
    TextView scoreSix;
    TextView scoreSeven;
    TextView scoreEight;
    TextView scoreNine;
    TextView scoreTen;
    TextView scoreEleven;
    TextView scoreTwelve;
    TextView scoreLast;
    Button back;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_high_scores);
        title = (TextView)findViewById(R.id.high_scores_title);
        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/FreeJemmy.ttf");
        title.setTypeface(font);
        oneText = (TextView)findViewById(R.id.high_score_one);
        twoText = (TextView)findViewById(R.id.high_score_two);
        threeText = (TextView)findViewById(R.id.high_score_three);
        fourText = (TextView)findViewById(R.id.high_score_four);
        fiveText = (TextView)findViewById(R.id.high_score_five);
        sixText = (TextView)findViewById(R.id.high_score_six);
        sevenText = (TextView)findViewById(R.id.high_score_seven);
        eightText = (TextView)findViewById(R.id.high_score_eight);
        nineText = (TextView)findViewById(R.id.high_score_nine);
        tenText = (TextView)findViewById(R.id.high_score_ten);
        elevenText = (TextView)findViewById(R.id.high_score_eleven);
        twelveText = (TextView)findViewById(R.id.high_score_twelve);
        lastText = (TextView)findViewById(R.id.high_score_last_level);
        scoreOne = (TextView)findViewById(R.id.score_one);
        scoreTwo = (TextView)findViewById(R.id.score_two);
        scoreThree = (TextView)findViewById(R.id.score_three);
        scoreFour = (TextView)findViewById(R.id.score_four);
        scoreFive = (TextView)findViewById(R.id.score_five);
        scoreSix = (TextView)findViewById(R.id.score_six);
        scoreSeven = (TextView)findViewById(R.id.score_seven);
        scoreEight = (TextView)findViewById(R.id.score_eight);
        scoreNine = (TextView)findViewById(R.id.score_nine);
        scoreTen = (TextView)findViewById(R.id.score_ten);
        scoreEleven = (TextView)findViewById(R.id.score_eleven);
        scoreTwelve = (TextView)findViewById(R.id.score_twelve);
        scoreLast = (TextView)findViewById(R.id.score_last_level);
        back = (Button)findViewById(R.id.back);
        System.out.println("!!!!!!!!!!!!!!!!!!");
        System.out.println(settings.one);
        System.out.println("??????????????????");
        scoreOne.setText(String.valueOf(settings.one));
        scoreTwo.setText(String.valueOf(settings.two));
        scoreThree.setText(String.valueOf(settings.three));
        scoreFour.setText(String.valueOf(settings.four));
        scoreFive.setText(String.valueOf(settings.five));
        scoreSix.setText(String.valueOf(settings.six));
        scoreSeven.setText(String.valueOf(settings.seven));
        scoreEight.setText(String.valueOf(settings.eight));
        scoreNine.setText(String.valueOf(settings.nine));
        scoreTen.setText(String.valueOf(settings.ten));
        scoreEleven.setText(String.valueOf(settings.eleven));
        scoreTwelve.setText(String.valueOf(settings.twelve));
        scoreLast.setText(String.valueOf(settings.last));

        if(settings.language == 1)
        {
            title.setTextSize(40);
            title.setText("Mejores Puntaciones");
            oneText.setText("Nivel 1:");
            twoText.setText("Nivel 2:");
            threeText.setText("Nivel 3:");
            fourText.setText("Nivel 4:");
            fiveText.setText("Nivel 5:");
            sixText.setText("Nivel 6:");
            sevenText.setText("Nivel 7:");
            eightText.setText("Nivel 8:");
            nineText.setText("Nivel 9:");
            tenText.setText("Nivel 10:");
            elevenText.setText("Nivel 11:");
            twelveText.setText("Nivel 12:");
            lastText.setText("Último Nivel:");
            back.setText("Volver");
        }
        else if(settings.language == 2)
        {
            title.setTextSize(40);
            title.setText("Pontuações Máximas");
            oneText.setText("Nível 1:");
            twoText.setText("Nível 2:");
            threeText.setText("Nível 3:");
            fourText.setText("Nível 4:");
            fiveText.setText("Nível 5:");
            sixText.setText("Nível 6:");
            sevenText.setText("Nível 7:");
            eightText.setText("Nível 8:");
            nineText.setText("Nível 9:");
            tenText.setText("Nível 10:");
            elevenText.setText("Nível 11:");
            twelveText.setText("Nível 12:");
            lastText.setText("Último Nivel:");
            back.setText("Voltar");
        }
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        back.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(getBaseContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        /*
        Button reset = (Button)findViewById(R.id.reset);
        reset.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Context context = getApplicationContext();
                SharedPreferences sharedPref = context.getSharedPreferences("mathBalloonsStorage", 0);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putInt("one", 0);
                editor.putInt("two", 0);
                editor.putInt("three", 0);
                editor.putInt("four", 0);
                editor.putInt("five", 0);
                editor.putInt("six", 0);
                editor.putInt("seven", 0);
                editor.putInt("eight", 0);
                editor.putInt("nine", 0);
                editor.putInt("ten", 0);
                editor.putInt("eleven", 0);
                editor.putInt("twelve", 0);
                editor.putInt("last", 0);
                editor.putBoolean("levelTwo", false);
                editor.putBoolean("levelThree", false);
                editor.putBoolean("levelFour", false);
                editor.putBoolean("levelFive", false);
                editor.putBoolean("levelSix", false);
                editor.putBoolean("levelSeven", false);
                editor.putBoolean("levelEight", false);
                editor.putBoolean("levelNine", false);
                editor.putBoolean("levelTen", false);
                editor.putBoolean("levelEleven", false);
                editor.putBoolean("levelTwelve", false);
                editor.putBoolean("lastLevel", false);


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
                settings.lastLevel =  sharedPref.getBoolean("lastLevel", false);
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
                Intent intent = new Intent(getBaseContext(), MainActivity.class);
                startActivity(intent);
            }
        });
        */
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem)
    {
        int id = menuItem.getItemId();
        if(menuItem != null && id == android.R.id.home)
        {
            finish();
        }
        return true;
    }

}
