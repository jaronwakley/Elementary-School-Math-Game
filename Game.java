package com.example.jaron.mathfun;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class Game extends AppCompatActivity
{

    private Settings settings = Settings.getInstance();
    EditText answer;
    TextView points;
    ImageView middleBalloon;
    TextView middleQuestion;
    ImageView leftBalloon;
    TextView leftQuestion;
    ImageView rightBalloon;
    TextView rightQuestion;
    int middleSound;
    int leftSound;
    int rightSound;
    final int LEVEL_ONE_DURATION = 30000;
    final int LEVEL_TWO_DURATION = 30000;
    final int LEVEL_THREE_DURATION = 30000;
    final int LEVEL_FOUR_DURATION = 30000;
    final int LEVEL_FIVE_DURATION = 30000;
    final int LEVEL_SIX_DURATION = 30000;
    final int LEVEL_SEVEN_DURATION = 30000;
    final int LEVEL_EIGHT_DURATION = 30000;
    final int LEVEL_NINE_DURATION = 30000;
    final int LEVEL_TEN_DURATION = 30000;
    final int LEVEL_ELEVEN_DURATION = 30000;
    final int LEVEL_TWELVE_DURATION = 30000;
    //You'll have the last level speed up as the time goes on.

    Random random = new Random();
    final int BALLOONMOVEMENT = -700;
    int firstAnswer = 0;
    int secondAnswer = 0;
    int thirdAnswer = 0;
    int currentPoints = 0;
    long timeLeftOne;
    long timeLeftTwo;
    long timeLeftThree;
    TextView firstHiddenTimer;
    TextView secondHiddenTimer;
    TextView thirdHiddenTimer;
    TextView gameTimer;
    CountDownTimer f;
    CountDownTimer se;
    CountDownTimer t;
    CountDownTimer g;
    CountDownTimer a;
    MediaPlayer pop;
    MediaPlayer pop_1;
    MediaPlayer explode;
    MediaPlayer cork;
    MediaPlayer bubble;
    MediaPlayer bubble_1;
    MediaPlayer bubble_2;
    MediaPlayer boing;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_game);
        //getSupportActionBar().hide();
        pop = MediaPlayer.create(Game.this, R.raw.pop);
        pop_1 = MediaPlayer.create(Game.this, R.raw.pop_1);
        explode = MediaPlayer.create(Game.this, R.raw.explosion);
        cork = MediaPlayer.create(Game.this, R.raw.cork);
        bubble = MediaPlayer.create(Game.this, R.raw.bubble1);
        bubble_1 = MediaPlayer.create(Game.this, R.raw.bubble4);
        bubble_2 = MediaPlayer.create(Game.this, R.raw.bubble5);
        boing = MediaPlayer.create(Game.this, R.raw.boing);
        answer = (EditText)findViewById(R.id.answer);
        gameTimer = (TextView)findViewById(R.id.game_timer);
        points = (TextView)findViewById(R.id.points);
        middleBalloon = (ImageView)findViewById(R.id.middle_balloon);
        middleQuestion = (TextView)findViewById(R.id.middle_question);
        leftBalloon = (ImageView)findViewById(R.id.left_balloon);
        leftQuestion = (TextView)findViewById(R.id.left_question);
        rightBalloon = (ImageView)findViewById(R.id.right_balloon);
        rightQuestion = (TextView)findViewById(R.id.right_question);
        firstHiddenTimer = (TextView)findViewById(R.id.first_hidden_timer);
        secondHiddenTimer = (TextView)findViewById(R.id.second_hidden_timer);
        thirdHiddenTimer = (TextView)findViewById(R.id.third_hidden_timer);
        startGeneralTimer();
        answer.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                if(a != null)
                {
                    a.cancel();
                }
                if(!s.toString().equals(""))
                {
                    startAnswerTimer();
                }
                if(firstAnswer != 0 && s.toString().equals(String.valueOf(firstAnswer)))
                {
                    if(a != null)
                    {
                        a.cancel();
                    }
                    sound(middleSound);
                    System.out.println("middle");
                    middleBalloon.setVisibility(View.INVISIBLE);
                    middleQuestion.setVisibility(View.INVISIBLE);
                    int otherPoints = firstAnswer;
                    firstAnswer = 0;
                    CharSequence timeLeftChars = firstHiddenTimer.getText();
                    String timeLeftString = timeLeftChars.toString();
                    int timeLeft;
                    if(timeLeftString.equals(""))
                    {
                        System.out.println("IT CAME HERE!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                        timeLeft = 0;
                    }
                    else
                    {
                        timeLeft = Integer.parseInt(timeLeftString);
                    }
                    f.cancel();
                    currentPoints = currentPoints + ((timeLeft / 500) + otherPoints) * (((settings.level + settings.level - 1) / 3) + 1);
                    points.setText(String.valueOf(currentPoints));
                }
                if(secondAnswer != 0 && s.toString().equals(String.valueOf(secondAnswer)))
                {
                    if(a != null)
                    {
                        a.cancel();
                    }
                    sound(leftSound);
                    System.out.println("left");
                    leftBalloon.setVisibility(View.INVISIBLE);
                    leftQuestion.setVisibility(View.INVISIBLE);
                    int otherPoints = secondAnswer;
                    secondAnswer = 0;
                    CharSequence timeLeftChars = secondHiddenTimer.getText();
                    String timeLeftString = timeLeftChars.toString();
                    int timeLeft;
                    if(timeLeftString.equals(""))
                    {
                        System.out.println("IT CAME HERE!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                        timeLeft = 0;
                    }
                    else
                    {
                        timeLeft = Integer.parseInt(timeLeftString);
                    }
                    se.cancel();
                    currentPoints = currentPoints + ((timeLeft / 500) + otherPoints) * (((settings.level + settings.level - 1) / 3) + 1);
                    points.setText(String.valueOf(currentPoints));
                }
                if(thirdAnswer != 0 && s.toString().equals(String.valueOf(thirdAnswer)))
                {
                    if(a != null)
                    {
                        a.cancel();
                    }
                    sound(rightSound);
                    System.out.println("right");
                    rightBalloon.setVisibility(View.INVISIBLE);
                    rightQuestion.setVisibility(View.INVISIBLE);
                    int otherPoints = thirdAnswer;
                    thirdAnswer = 0;
                    CharSequence timeLeftChars = thirdHiddenTimer.getText();
                    String timeLeftString = timeLeftChars.toString();
                    int timeLeft;
                    if(timeLeftString.equals(""))
                    {
                        System.out.println("IT CAME HERE!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                        timeLeft = 0;
                    }
                    else
                    {
                        timeLeft = Integer.parseInt(timeLeftString);
                    }
                    t.cancel();
                    currentPoints = currentPoints + ((timeLeft / 500) + otherPoints) * (((settings.level + settings.level - 1) / 3) + 1);
                    points.setText(String.valueOf(currentPoints));
                }
            }

            @Override
            public void afterTextChanged(Editable s)
            {

            }
        });
        if(settings.level == 1)
        {
            levelOne();
        }
        else if(settings.level == 2)
        {
            levelTwo();
        }
        else if(settings.level == 3)
        {
            levelThree();
        }
        else if(settings.level == 4)
        {
            levelFour();
        }
        else if(settings.level == 5)
        {
            levelFive();
        }
        else if(settings.level == 6)
        {
            levelSix();
        }
        else if(settings.level == 7)
        {
            levelSeven();
        }
        else if(settings.level == 8)
        {
            levelEight();
        }
        else if(settings.level == 9)
        {
            levelNine();
        }
        else if(settings.level == 10)
        {
            levelTen();
        }
        else if(settings.level == 11)
        {
            levelEleven();
        }
        else if(settings.level == 12)
        {
            levelTwelve();
        }
        else if(settings.level == 13)
        {
            lastLevel();
        }
    }
    void levelOne()
    {
        levelAdd(1, LEVEL_ONE_DURATION);
        levelAdd(1, LEVEL_ONE_DURATION);
        points.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                answer.setText("");
                levelAdd(1, LEVEL_ONE_DURATION);
            }

            @Override
            public void afterTextChanged(Editable s)
            {

            }
        });
    }


    void levelTwo()
    {
        levelAdd(2, LEVEL_TWO_DURATION);
        levelAdd(2, LEVEL_TWO_DURATION);
        points.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                answer.setText("");
                levelAdd(2, LEVEL_TWO_DURATION);
            }

            @Override
            public void afterTextChanged(Editable s)
            {

            }
        });
    }

    void levelThree()
    {
        levelAdd(3, LEVEL_TWO_DURATION);
        levelAdd(3, LEVEL_TWO_DURATION);
        points.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                answer.setText("");
                levelAdd(3, LEVEL_THREE_DURATION);
            }

            @Override
            public void afterTextChanged(Editable s)
            {

            }
        });
    }
    void levelFour()
    {
        levelAdd(4, LEVEL_FOUR_DURATION);
        levelAdd(4, LEVEL_FOUR_DURATION);
        points.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                answer.setText("");
                levelAdd(4, LEVEL_FOUR_DURATION);
            }

            @Override
            public void afterTextChanged(Editable s)
            {

            }
        });
    }
    void levelFive()
    {
        levelAdd(5, LEVEL_FIVE_DURATION);
        levelAdd(5, LEVEL_FIVE_DURATION);
        points.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                answer.setText("");
                levelAdd(5, LEVEL_FIVE_DURATION);
            }

            @Override
            public void afterTextChanged(Editable s)
            {

            }
        });
    }
    void levelSix()
    {
        levelAdd(6, LEVEL_SIX_DURATION);
        levelAdd(6, LEVEL_SIX_DURATION);
        points.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                answer.setText("");
                levelAdd(6, LEVEL_SIX_DURATION);
            }

            @Override
            public void afterTextChanged(Editable s)
            {

            }
        });
    }
    void levelSeven()
    {
        levelAdd(7, LEVEL_SEVEN_DURATION);
        levelAdd(7, LEVEL_SEVEN_DURATION);
        points.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                answer.setText("");
                levelAdd(7, LEVEL_SEVEN_DURATION);
            }

            @Override
            public void afterTextChanged(Editable s)
            {

            }
        });
    }
    void levelEight()
    {
        levelAdd(8, LEVEL_EIGHT_DURATION);
        levelAdd(8, LEVEL_EIGHT_DURATION);
        points.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                answer.setText("");
                levelAdd(8, LEVEL_EIGHT_DURATION);
            }

            @Override
            public void afterTextChanged(Editable s)
            {

            }
        });
    }
    void levelNine()
    {
        levelAdd(9, LEVEL_NINE_DURATION);
        levelAdd(9, LEVEL_NINE_DURATION);
        points.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                answer.setText("");
                levelAdd(9, LEVEL_NINE_DURATION);
            }

            @Override
            public void afterTextChanged(Editable s)
            {

            }
        });
    }
    void levelTen()
    {
        levelAdd(10, LEVEL_TEN_DURATION);
        levelAdd(10, LEVEL_TEN_DURATION);
        points.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                answer.setText("");
                levelAdd(10, LEVEL_TEN_DURATION);
            }

            @Override
            public void afterTextChanged(Editable s)
            {

            }
        });
    }

    void levelEleven()
    {
        levelAdd(11, LEVEL_ELEVEN_DURATION);
        levelAdd(11, LEVEL_ELEVEN_DURATION);
        points.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                answer.setText("");
                levelAdd(11, LEVEL_ELEVEN_DURATION);
            }

            @Override
            public void afterTextChanged(Editable s)
            {

            }
        });
    }

    void levelTwelve()
    {
        levelAdd(12, LEVEL_TWELVE_DURATION);
        levelAdd(12, LEVEL_TWELVE_DURATION);
        points.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                answer.setText("");
                levelAdd(12, LEVEL_TWELVE_DURATION);
            }

            @Override
            public void afterTextChanged(Editable s)
            {

            }
        });
    }

    void lastLevel()
    {
        g.cancel();
        lastLevelAdd();//The speed will change on this level
        points.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                answer.setText("");
                lastLevelAdd();
            }

            @Override
            public void afterTextChanged(Editable s)
            {

            }
        });
    }

    void levelAdd(int level, int speed)
    {
        int balloonColor = random.nextInt(7);
        int balloonPosition;
        if(firstAnswer == 0 && secondAnswer == 0 && thirdAnswer == 0)
        {
            balloonPosition = random.nextInt(3);
        }
        else
        {
            balloonPosition = random.nextInt(2);
            if(firstAnswer != 0)
            {
                balloonPosition++;
            }
            else if(secondAnswer != 0)
            {
                if(balloonPosition == 1)
                {
                    balloonPosition++;
                }
            }
        }
        int order = random.nextInt(2);
        int firstNumber;
        int secondNumber;
        if(order == 0)
        {
            firstNumber = level;
            secondNumber = random.nextInt(12) + 1;
        }
        else
        {
            firstNumber = random.nextInt(12) + 1;
            secondNumber = level;
        }
        setBalloon(balloonPosition, balloonColor, firstNumber, secondNumber, speed);
        setAnswer(balloonPosition, firstNumber, secondNumber);
    }

    void lastLevelAdd()
    {
        int balloonColor = random.nextInt(7);
        int balloonPosition = random.nextInt(3);
        int order = random.nextInt(2);
        int firstNumber;
        int secondNumber;
        if(order == 0)
        {
            firstNumber = random.nextInt(12) + 1;;
            secondNumber = random.nextInt(12) + 1;
        }
        else
        {
            firstNumber = random.nextInt(12) + 1;
            secondNumber = random.nextInt(12) + 1;;
        }
        int speed = 20000;
        if(currentPoints < 5000)
        {
            speed = 20000;
        }
        else if(currentPoints < 6000)
        {
            speed = 19000;
        }
        else if(currentPoints < 7000)
        {
            speed = 18000;
        }
        else if(currentPoints < 8000)
        {
            speed = 17000;
        }
        else if(currentPoints < 9000)
        {
            speed = 16000;
        }
        else if(currentPoints < 10000)
        {
            speed = 15000;
        }
        else if(currentPoints < 11000)
        {
            speed = 14000;
        }
        else if(currentPoints < 12000)
        {
            speed = 13000;
        }
        else if(currentPoints < 13000)
        {
            speed = 12000;
        }
        else if(currentPoints < 14000)
        {
            speed = 11000;
        }
        else if(currentPoints < 15000)
        {
            speed = 10000;
        }
        else if(currentPoints < 16000)
        {
            speed = 9000;
        }
        else if(currentPoints < 17000)
        {
            speed = 8000;
        }
        else if(currentPoints < 18000)
        {
            speed = 7000;
        }
        else if(currentPoints < 19000)
        {
            speed = 6000;
        }
        else if(currentPoints < 20000)
        {
            speed = 5000;
        }
        else if(currentPoints < 22000)
        {
            speed = 4000;
        }
        else if(currentPoints < 25000)
        {
            speed = 3000;
        }
        else if(currentPoints < 30000)
        {
            speed = 2500;
        }
        else
        {
            speed = 2000;
        }
        System.out.println("Speed = " + speed);
        setBalloon(balloonPosition, balloonColor, firstNumber, secondNumber, speed);
        setAnswer(balloonPosition, firstNumber, secondNumber);
    }

    void setBalloonColor(ImageView balloon, int color)
    {
        System.out.println(color);
        if(color == 0)
        {
            balloon.setImageResource(R.drawable.balloon_yellow);
        }
        else if(color == 1)
        {
            balloon.setImageResource(R.drawable.balloon_orange);
        }
        else if(color == 2)
        {
            balloon.setImageResource(R.drawable.balloon_red);
        }
        else if(color == 3)
        {
            balloon.setImageResource(R.drawable.balloon_green);
        }
        else if(color == 4)
        {
            balloon.setImageResource(R.drawable.balloon_blue);
        }
        else if(color == 5)
        {
            balloon.setImageResource(R.drawable.balloon_purple);
        }
        else if(color == 6)
        {
            balloon.setImageResource(R.drawable.balloon_pink);
        }
    }

    void setBalloon(int balloonPosition, int balloonColor, int firstNumber, int secondNumber, int speed)
    {
        System.out.println("position = " + balloonPosition);
        System.out.println("color = " + balloonColor);
        System.out.println("first = " + firstNumber);
        System.out.println("second = " + secondNumber);
        System.out.println("speed = " + speed);
        if(balloonPosition == 0)
        {
            timeLeftOne = speed / 2;//You can change this into a parameter as well as the level speed.
            middleBalloon.setVisibility(View.VISIBLE);
            middleQuestion.setVisibility(View.VISIBLE);
            middleQuestion.setText(String.valueOf(firstNumber) + "X" + String.valueOf(secondNumber));
            middleSound = balloonColor;
            setBalloonColor(middleBalloon, balloonColor);
            middleBalloon.setY(490);
            middleQuestion.setY(570);
            middleBalloon.animate().translationY(BALLOONMOVEMENT).setDuration(speed);
            middleQuestion.animate().translationY(BALLOONMOVEMENT).setDuration(speed);
            f = new CountDownTimer(timeLeftOne, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    firstHiddenTimer.setText( "" + millisUntilFinished);
                }
                public void onFinish()
                {
                    if(firstAnswer != 0)
                    {
                        g.cancel();
                        if(se != null)
                        {
                            se.cancel();
                        }
                        if(t != null)
                        {
                            t.cancel();
                        }
                        if(a != null)
                        {
                            a.cancel();
                        }
                        System.out.println("Lost with the middle balloon");
                        terminateLevel(false);
                    }
                }
            }.start();
        }
        else if(balloonPosition == 1)
        {
            timeLeftTwo = speed / 2;
            leftBalloon.setVisibility(View.VISIBLE);
            leftQuestion.setVisibility(View.VISIBLE);
            leftQuestion.setText(String.valueOf(firstNumber) + "X" + String.valueOf(secondNumber));
            leftSound = balloonColor;
            setBalloonColor(leftBalloon, balloonColor);
            leftBalloon.setY(490);
            leftQuestion.setY(570);
            leftBalloon.animate().translationY(BALLOONMOVEMENT).setDuration(speed);
            leftQuestion.animate().translationY(BALLOONMOVEMENT).setDuration(speed);
            se = new CountDownTimer(timeLeftTwo, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    secondHiddenTimer.setText( "" + millisUntilFinished);
                }
                public void onFinish()
                {
                    if(secondAnswer != 0)
                    {
                        g.cancel();
                        if(f != null)
                        {
                            f.cancel();
                        }
                        if(t != null)
                        {
                            t.cancel();
                        }
                        if(a != null)
                        {
                            a.cancel();
                        }
                        System.out.println("Lost with the left balloon");
                        terminateLevel(false);
                    }
                }
            }.start();
        }
        else if(balloonPosition == 2)
        {
            timeLeftThree = speed / 2;
            rightBalloon.setVisibility(View.VISIBLE);
            rightQuestion.setVisibility(View.VISIBLE);
            rightQuestion.setText(String.valueOf(firstNumber) + "X" + String.valueOf(secondNumber));
            rightSound = balloonColor;
            setBalloonColor(rightBalloon, balloonColor);
            rightBalloon.setY(490);
            rightQuestion.setY(570);
            rightBalloon.animate().translationY(BALLOONMOVEMENT).setDuration(speed);
            rightQuestion.animate().translationY(BALLOONMOVEMENT).setDuration(speed);
            t = new CountDownTimer (timeLeftThree, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    thirdHiddenTimer.setText( "" + millisUntilFinished);
                }
                public void onFinish()
                {
                    if(thirdAnswer != 0)
                    {
                        g.cancel();
                        if(f != null)
                        {
                            f.cancel();
                        }
                        if(se != null)
                        {
                            se.cancel();
                        }
                        if(a != null)
                        {
                            a.cancel();
                        }
                        System.out.println("Lost with the right balloon");
                        terminateLevel(false);
                    }
                }
            }.start();
        }
    }

    void setAnswer(int position, int first, int second)
    {
        if(position == 0)
        {
            firstAnswer = first * second;
        }
        else if(position == 1)
        {
            secondAnswer = first * second;
        }
        else if(position == 2)
        {
            thirdAnswer = first * second;
        }
        System.out.println("1 = " + firstAnswer);
        System.out.println("2 = " + secondAnswer);
        System.out.println("3 = " + thirdAnswer);
    }

    void terminateLevel(boolean passed)
    {
        //Pass the score in
        //Pass in whether they passed the level or not
        Intent intent = new Intent(getBaseContext(), EndGame.class);
        intent.putExtra("score", currentPoints);
        intent.putExtra("passed", passed);
        startActivity(intent);
    }

    void startGeneralTimer()
    {
        int time = 60000;
        if(settings.level == 1)
        {
            time = 30000;
        }
        g = new CountDownTimer(time, 1000)//Move this timer so it can be a general timer for the level.
        {
            public void onTick(long millisUntilFinished)
            {
                if(millisUntilFinished < 6000)
                {
                    gameTimer.setTextColor(getResources().getColor(R.color.red));
                    gameTimer.setTextSize(45);
                }
                gameTimer.setText("" + millisUntilFinished / 1000);
            }
            public void onFinish()
            {
                if(f != null)
                {
                    f.cancel();
                }
                if(se != null)
                {
                    se.cancel();
                }
                if(t != null)
                {
                    t.cancel();
                }
                terminateLevel(true);
            }
        }.start();
    }

    void startAnswerTimer()
    {
        int time = 1500;
        a = new CountDownTimer(time, 1000)
        {
            public void onTick(long millisUntilFinished)
            {

            }
            public void onFinish()
            {
                answer.setText("");
                boing.start();
                //Maybe make a wrong sound here.
            }
        }.start();
    }

    /*
    public void sound(int balloonSound)
    {
        if(balloonSound == 0)
        {
            pop.start();
        }
        else if(balloonSound == 1)
        {
            pop_1.start();
        }
        else if(balloonSound == 2)
        {
            explode.start();
        }
        else if(balloonSound == 3)
        {
            cork.start();
        }
        else if(balloonSound == 4)
        {
            bubble.start();
        }
        else if(balloonSound == 5)
        {
            bubble_1.start();
        }
        else
        {
            bubble_2.start();
        }
    }
    */

    public void sound(int balloonSound)
    {
        if(balloonSound == 0)
        {
            pop_1.start();
        }
        else if(balloonSound == 1)
        {
            pop_1.start();
        }
        else if(balloonSound == 2)
        {
            pop_1.start();
        }
        else if(balloonSound == 3)
        {
            pop_1.start();
        }
        else if(balloonSound == 4)
        {
            pop_1.start();
        }
        else if(balloonSound == 5)
        {
            pop_1.start();
        }
        else
        {
            pop_1.start();
        }
    }


    @Override
    public void onBackPressed()
    {
        //Doesn't allow the user to exit the game.
        //Make it keep the keyboard
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(answer, 0);
    }
}
