package com.example.jaron.mathfun;

/**
 * Created by Jaron on 9/26/2017.
 */

public class Settings
{
    private static Settings instance = new Settings();
    public static Settings getInstance()
    {
        return instance;
    }

    private Settings()
    {
    }

    int language = 0;//0 = English, 1 = Spanish, 2 = Portuguese.
    int level = 0;
    boolean levelTwo;//Whether or not the level is locked.
    boolean levelThree;
    boolean levelFour;
    boolean levelFive;
    boolean levelSix;
    boolean levelSeven;
    boolean levelEight;
    boolean levelNine;
    boolean levelTen;
    boolean levelEleven;
    boolean levelTwelve;
    boolean lastLevel;
    int one;//Scores
    int two;
    int three;
    int four;
    int five;
    int six;
    int seven;
    int eight;
    int nine;
    int ten;
    int eleven;
    int twelve;
    int last;

}
