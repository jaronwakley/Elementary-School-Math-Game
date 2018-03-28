package com.example.jaron.mathfun;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LevelSelect extends AppCompatActivity
{

    private Settings settings = Settings.getInstance();
    TextView title;
    Button one;
    Button two;
    Button three;
    Button four;
    Button five;
    Button six;
    Button seven;
    Button eight;
    Button nine;
    Button ten;
    Button eleven;
    Button twelve;
    Button lastLevel;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_level_select);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        title = (TextView)findViewById(R.id.level_select_prompt);
        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/FreeJemmy.ttf");
        title.setTypeface(font);
        lastLevel = (Button)findViewById(R.id.last_level);
        if(settings.language == 1)
        {
            title.setText("Elige un Nivel:");
            lastLevel.setText("El Último Nivel");
        }
        else if(settings.language == 2)
        {
            title.setTextSize(38);
            title.setText("Escolhe um Nível:");
            lastLevel.setText("O Último Nível");
        }
        one = (Button)findViewById(R.id.level_one);
        one.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                settings.level = 1;
                startGame();
            }
        });
        two = (Button)findViewById(R.id.level_two);
        two.setEnabled(settings.levelTwo);
        if(settings.levelTwo == false)
        {
            two.setBackgroundColor(getResources().getColor(R.color.dark_gray));
        }
        two.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                settings.level = 2;
                startGame();
            }
        });
        three = (Button)findViewById(R.id.level_three);
        three.setEnabled(settings.levelThree);
        if(settings.levelThree == false)
        {
            three.setBackgroundColor(getResources().getColor(R.color.dark_gray));
        }
        three.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                settings.level = 3;
                startGame();
            }
        });
        four = (Button)findViewById(R.id.level_four);
        four.setEnabled(settings.levelFour);
        if(settings.levelFour == false)
        {
            four.setBackgroundColor(getResources().getColor(R.color.dark_gray));
        }
        four.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                settings.level = 4;
                startGame();
            }
        });
        five = (Button)findViewById(R.id.level_five);
        five.setEnabled(settings.levelFive);
        if(settings.levelFive == false)
        {
            five.setBackgroundColor(getResources().getColor(R.color.dark_gray));
        }
        five.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                settings.level = 5;
                startGame();
            }
        });
        six = (Button)findViewById(R.id.level_six);
        six.setEnabled(settings.levelSix);
        if(settings.levelSix == false)
        {
            six.setBackgroundColor(getResources().getColor(R.color.dark_gray));
        }
        six.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                settings.level = 6;
                startGame();
            }
        });
        seven = (Button)findViewById(R.id.level_seven);
        seven.setEnabled(settings.levelSeven);
        if(settings.levelSeven == false)
        {
            seven.setBackgroundColor(getResources().getColor(R.color.dark_gray));
        }
        seven.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                settings.level = 7;
                startGame();
            }
        });
        eight = (Button)findViewById(R.id.level_eight);
        eight.setEnabled(settings.levelEight);
        if(settings.levelEight == false)
        {
            eight.setBackgroundColor(getResources().getColor(R.color.dark_gray));
        }
        eight.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                settings.level = 8;
                startGame();
            }
        });
        nine = (Button)findViewById(R.id.level_nine);
        nine.setEnabled(settings.levelNine);
        if(settings.levelNine == false)
        {
            nine.setBackgroundColor(getResources().getColor(R.color.dark_gray));
        }
        nine.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                settings.level = 9;
                startGame();
            }
        });
        ten = (Button)findViewById(R.id.level_ten);
        ten.setEnabled(settings.levelTen);
        if(settings.levelTen == false)
        {
            ten.setBackgroundColor(getResources().getColor(R.color.dark_gray));
        }
        ten.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                settings.level = 10;
                startGame();
            }
        });
        eleven = (Button)findViewById(R.id.level_eleven);
        eleven.setEnabled(settings.levelEleven);
        if(settings.levelEleven == false)
        {
            eleven.setBackgroundColor(getResources().getColor(R.color.dark_gray));
        }
        eleven.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                settings.level = 11;
                startGame();
            }
        });
        twelve = (Button)findViewById(R.id.level_twelve);
        twelve.setEnabled(settings.levelTwelve);
        if(settings.levelTwelve == false)
        {
            twelve.setBackgroundColor(getResources().getColor(R.color.dark_gray));
        }
        twelve.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                settings.level = 12;
                startGame();
            }
        });
        lastLevel.setEnabled(settings.lastLevel);
        if(settings.lastLevel == false)
        {
            lastLevel.setBackgroundColor(getResources().getColor(R.color.dark_gray));
        }
        lastLevel.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                settings.level = 13;
                startGame();
            }
        });

    }

    public void startGame()
    {
        Intent intent = new Intent(getBaseContext(), Game.class);
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem)
    {
        int id = menuItem.getItemId();
        if(menuItem != null && id == android.R.id.home)
        {
            Intent intent = new Intent(getBaseContext(), MainActivity.class);
            startActivity(intent);
        }
        return true;
    }

}
