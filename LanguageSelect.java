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

public class LanguageSelect extends AppCompatActivity
{

    private Settings settings = Settings.getInstance();
    Button english;
    Button spanish;
    Button portuguese;
    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_language_select);
        //getSupportActionBar().hide();
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        title = (TextView)findViewById(R.id.language_select_prompt);
        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/FreeJemmy.ttf");
        title.setTypeface(font);
        english = (Button)findViewById(R.id.english_button);
        english.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                settings.language = 0;
                Intent intent = new Intent(getBaseContext(), MainActivity.class);
                startActivity(intent);
            }
        });
        spanish = (Button)findViewById(R.id.spanish_button);
        spanish.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                settings.language = 1;
                Intent intent = new Intent(getBaseContext(), MainActivity.class);
                startActivity(intent);
            }
        });
        portuguese = (Button)findViewById(R.id.portuguese_button);
        portuguese.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                settings.language = 2;
                Intent intent = new Intent(getBaseContext(), MainActivity.class);
                startActivity(intent);
            }
        });
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
