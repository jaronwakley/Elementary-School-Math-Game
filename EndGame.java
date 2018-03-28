package com.example.jaron.mathfun;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class EndGame extends AppCompatActivity
{

    private Settings settings = Settings.getInstance();
    TextView title;
    TextView scoreText;
    TextView highScore;
    Button mainMenu;
    Button playAgain;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        Intent intent = getIntent();
        setContentView(R.layout.activity_end_game);
        int score = intent.getIntExtra("score", 0);
        boolean passed = intent.getBooleanExtra("passed", false);
        title = (TextView)findViewById(R.id.end_game_title);
        scoreText = (TextView)findViewById(R.id.score);
        highScore = (TextView)findViewById(R.id.high_score);
        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/FreeJemmy.ttf");
        title.setTypeface(font);
        scoreText.setTypeface(font);
        highScore.setTypeface(font);
        mainMenu = (Button)findViewById(R.id.go_to_main_menu);
        playAgain = (Button)findViewById(R.id.go_to_level_select);
        Context context = getApplicationContext();
        SharedPreferences sharedPref = context.getSharedPreferences("mathBalloonsStorage", 0);
        SharedPreferences.Editor editor = sharedPref.edit();
        if(settings.language == 1)
        {
            mainMenu.setText("Menú");
            playAgain.setText("Jugar de Nuevo");
        }
        else if(settings.language == 2)
        {
            mainMenu.setText("Menu");
            playAgain.setText("Jogar de Novo");
        }
        if(passed == true)
        {
            if(settings.language == 1)
            {
                title.setText("Nivel Cumplido");
            }
            else if(settings.language == 2)
            {
                title.setText("Nível Cumprido");
            }
            else
            {
                title.setText("Level Complete!");
            }
        }
        else
        {
            if(settings.language == 1)
            {
                title.setText("Fin de Juego");
            }
            else if(settings.language == 2)
            {
                title.setText("Fim de Jogo");
            }
            else
            {
                title.setText("Game Over");
            }
        }
        setScore(score);
        if(settings.level == 1)
        {
            if(score > settings.one)
            {
                settings.one = score;
                editor.putInt("one", score);
                highScoreText();
            }
            if(passed == true)
            {
                settings.levelTwo = true;
                editor.putBoolean("levelTwo", true);
            }
            setHighScore(settings.one);
            editor.apply();
        }
        else if(settings.level == 2)
        {
            if(score > settings.two)
            {
                settings.two = score;
                editor.putInt("two", score);
                highScoreText();
            }
            if(passed == true)
            {
                settings.levelThree = true;
                editor.putBoolean("levelThree", true);
            }
            setHighScore(settings.two);
            editor.apply();
        }
        else if(settings.level == 3)
        {
            if(score > settings.three)
            {
                settings.three = score;
                editor.putInt("three", score);
                highScoreText();
            }
            if(passed == true)
            {
                settings.levelFour = true;
                editor.putBoolean("levelFour", true);
            }
            setHighScore(settings.three);
            editor.apply();
        }
        else if(settings.level == 4)
        {
            if(score > settings.four)
            {
                settings.four = score;
                editor.putInt("four", score);
                highScoreText();
            }
            if(passed == true)
            {
                settings.levelFive = true;
                editor.putBoolean("levelFive", true);
            }
            setHighScore(settings.four);
            editor.apply();
        }
        else if(settings.level == 5)
        {
            if(score > settings.five)
            {
                settings.five = score;
                editor.putInt("five", score);
                highScoreText();
            }
            if(passed == true)
            {
                settings.levelSix = true;
                editor.putBoolean("levelSix", true);
            }
            setHighScore(settings.five);
            editor.apply();
        }
        else if(settings.level == 6)
        {
            if(score > settings.six)
            {
                settings.six = score;
                editor.putInt("six", score);
                highScoreText();
            }
            if(passed == true)
            {
                settings.levelSeven = true;
                editor.putBoolean("levelSeven", true);
            }
            setHighScore(settings.six);
            editor.apply();
        }
        else if(settings.level == 7)
        {
            if(score > settings.seven)
            {
                settings.seven = score;
                editor.putInt("seven", score);
                highScoreText();
            }
            if(passed == true)
            {
                settings.levelEight = true;
                editor.putBoolean("levelEight", true);
            }
            setHighScore(settings.seven);
            editor.apply();
        }
        else if(settings.level == 8)
        {
            if(score > settings.eight)
            {
                settings.eight = score;
                editor.putInt("eight", score);
                highScoreText();
            }
            if(passed == true)
            {
                settings.levelNine = true;
                editor.putBoolean("levelNine", true);
            }
            setHighScore(settings.eight);
            editor.apply();
        }
        else if(settings.level == 9)
        {
            if(score > settings.nine)
            {
                settings.nine = score;
                editor.putInt("nine", score);
                highScoreText();
            }
            if(passed == true)
            {
                settings.levelTen = true;
                editor.putBoolean("levelTen", true);
            }
            setHighScore(settings.nine);
            editor.apply();
        }
        else if(settings.level == 10)
        {
            if(score > settings.ten)
            {
                settings.ten = score;
                editor.putInt("ten", score);
                highScoreText();
            }
            if(passed == true)
            {
                settings.levelEleven = true;
                editor.putBoolean("levelEleven", true);
            }
            setHighScore(settings.ten);
            editor.apply();
        }
        else if(settings.level == 11)
        {
            if(score > settings.eleven)
            {
                settings.eleven = score;
                editor.putInt("eleven", score);
                highScoreText();
            }
            if(passed == true)
            {
                settings.levelTwelve = true;
                editor.putBoolean("levelTwelve", true);
            }
            setHighScore(settings.eleven);
            editor.apply();
        }
        else if(settings.level == 12)
        {
            if(score > settings.twelve)
            {
                settings.twelve = score;
                editor.putInt("twelve", score);
                highScoreText();
            }
            if(passed == true)
            {
                settings.lastLevel = true;
                editor.putBoolean("lastLevel", true);
            }
            setHighScore(settings.twelve);
            editor.apply();
        }
        else if(settings.level == 13)
        {
            if(score > settings.last)
            {
                settings.last = score;
                editor.putInt("last", score);
                highScoreText();
            }
            setHighScore(settings.last);
            editor.apply();
        }
        mainMenu.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(getBaseContext(), MainActivity.class);
                startActivity(intent);
            }
        });
        playAgain.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(getBaseContext(), LevelSelect.class);
                startActivity(intent);
            }
        });
    }

    void highScoreText()
    {
        if(settings.language == 1)
        {
            title.setText("¡Ganaste la Mejor Puntación!");
        }
        else if(settings.language == 2)
        {
            title.setText("Ganhou a Melhor Pontuação!");
        }
        else
        {
            title.setText("You beat the High Score!");
        }
    }

    void setScore(int score)
    {
        if(settings.language == 1)
        {
            scoreText.setText("Puntación: " + score);
        }
        else if(settings.language == 2)
        {
            scoreText.setText("Pontuação: " + score);
        }
        else
        {
            scoreText.setText("Score: " + score);
        }
    }

    void setHighScore(int number)
    {
        if(settings.language == 1)
        {
            highScore.setText("Mejor Puntación: " + number);
        }
        else if(settings.language == 2)
        {
            highScore.setText("Melhor Pontuação: " + number);
        }
        else
        {
            highScore.setText("High Score: " + number);
        }
    }

    @Override
    public void onBackPressed()
    {
        //Doesn't allow the user to re-enter the game.
    }
}
