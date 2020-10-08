package com.example.pianotiles;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.SharedPreferences;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    
    ImageView   iv_11,iv_12,iv_13,
                iv_21,iv_22,iv_23,
                iv_31,iv_32,iv_33,
                iv_41,iv_42,iv_43,
                iv_51,iv_52,iv_53;

    Button b_play;

    TextView tv_time,tv_score,tv_best;

    Random r;

    int rockLocationRow1,rockLocationRow2,rockLocationRow3,rockLocationRow4,rockLocationRow5;

    int frameImage,AfterClickImage,tapImage,emptyImage,red;

    int currentScore;
    
    int bestScore;
    
    int timeSelected;
    
    String Stime;

    CountDownTimer timer;
    
    boolean isTop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent it=getIntent();
        Stime = it.getStringExtra("ts");
        timeSelected = Integer.parseInt(Stime);
        timeSelected *=  1000;

        SharedPreferences preferences=getSharedPreferences("PREFS",0);
        bestScore=preferences.getInt(Stime,0);

        iv_11 = (ImageView)findViewById(R.id.iv_11);
        iv_12 = (ImageView)findViewById(R.id.iv_12);
        iv_13 = (ImageView)findViewById(R.id.iv_13);

        iv_21 = (ImageView)findViewById(R.id.iv_21);
        iv_22 = (ImageView)findViewById(R.id.iv_22);
        iv_23 = (ImageView)findViewById(R.id.iv_23);

        iv_31 = (ImageView)findViewById(R.id.iv_31);
        iv_32 = (ImageView)findViewById(R.id.iv_32);
        iv_33 = (ImageView)findViewById(R.id.iv_33);

        iv_41 = (ImageView)findViewById(R.id.iv_41);
        iv_42 = (ImageView)findViewById(R.id.iv_42);
        iv_43 = (ImageView)findViewById(R.id.iv_43);

        iv_51 = (ImageView)findViewById(R.id.iv_51);
        iv_52 = (ImageView)findViewById(R.id.iv_52);
        iv_53 = (ImageView)findViewById(R.id.iv_53);

        iv_11.setEnabled(false);
        iv_12.setEnabled(false);
        iv_13.setEnabled(false);
        iv_21.setEnabled(false);
        iv_22.setEnabled(false);
        iv_23.setEnabled(false);
        iv_31.setEnabled(false);
        iv_32.setEnabled(false);
        iv_33.setEnabled(false);
        iv_41.setEnabled(false);
        iv_42.setEnabled(false);
        iv_43.setEnabled(false);
        iv_51.setEnabled(false);
        iv_52.setEnabled(false);
        iv_53.setEnabled(false);

        b_play=(Button)findViewById(R.id.b_play);

        tv_score=(TextView)findViewById(R.id.tv_score);
        tv_score.setText("SCORE: "+currentScore);

        tv_best=(TextView)findViewById(R.id.tv_best);
        tv_best.setText("BEST: "+bestScore);

        tv_time=(TextView)findViewById(R.id.tv_time);
        tv_time.setText("TIME: "+millisToTime(timeSelected));

        r = new Random();

        loadImages();

        timer=new CountDownTimer(timeSelected,1000)
        {
            @Override
            public void onTick(long millisUntilFinished)
            {
                tv_time.setText("TIME: "+millisToTime(millisUntilFinished));
            }
            @Override
            public void onFinish()
            {
                endGame();
            }
        };

        iv_41.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(rockLocationRow4==1)
                {
                    continueGame();
                }
                else
                {
                    iv_41.setImageResource(red);
                    endGame();
                }
            }
        });

        iv_42.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(rockLocationRow4==2)
                {
                    continueGame();
                }
                else
                {
                    iv_42.setImageResource(red);
                    endGame();
                }
            }
        });

        iv_43.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(rockLocationRow4==3)
                {
                    continueGame();
                }
                else
                {
                    iv_43.setImageResource(red);
                    endGame();
                }
            }
        });
        iv_11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv_11.setImageResource(red);
                endGame();
            }
        });
        iv_12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv_12.setImageResource(red);
                endGame();
            }
        });
        iv_13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv_13.setImageResource(red);
                endGame();
            }
        });
        iv_21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv_21.setImageResource(red);
                endGame();
            }
        });
        iv_22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv_22.setImageResource(red);
                endGame();
            }
        });
        iv_23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv_23.setImageResource(red);
                endGame();
            }
        });
        iv_31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv_31.setImageResource(red);
                endGame();
            }
        });
        iv_32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv_32.setImageResource(red);
                endGame();
            }
        });
        iv_33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv_33.setImageResource(red);
                endGame();
            }
        });

        iv_51.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv_51.setImageResource(red);
                endGame();
            }
        });

        iv_52.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv_52.setImageResource(red);
                endGame();
            }
        });

        iv_53.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv_53.setImageResource(red);
                endGame();
            }
        });

        b_play.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                initGame();
            }
        });
    }

    private void initGame()
    {
        iv_11.setEnabled(true);
        iv_12.setEnabled(true);
        iv_13.setEnabled(true);
        iv_21.setEnabled(true);
        iv_22.setEnabled(true);
        iv_23.setEnabled(true);
        iv_31.setEnabled(true);
        iv_32.setEnabled(true);
        iv_33.setEnabled(true);
        iv_41.setEnabled(true);
        iv_42.setEnabled(true);
        iv_43.setEnabled(true);
        iv_51.setEnabled(true);
        iv_52.setEnabled(true);
        iv_53.setEnabled(true);

        b_play.setVisibility(View.INVISIBLE);

        currentScore=0;
        tv_score.setText("SCORE: "+currentScore);

        timer.start();

        //row5

        //row4
        rockLocationRow4=1;
        iv_41.setImageResource(tapImage);

        //row3
        rockLocationRow3=r.nextInt(3)+1;
        setRockLocation(rockLocationRow3,3);

        //row2
        rockLocationRow2=r.nextInt(3)+1;
        setRockLocation(rockLocationRow2,2);

        //row1
        rockLocationRow1=r.nextInt(3)+1;
        setRockLocation(rockLocationRow1,1);
    }

    private void setRockLocation(int place,int row)
    {
        if(row==1)
        {
            iv_11.setImageResource(emptyImage);
            iv_12.setImageResource(emptyImage);
            iv_13.setImageResource(emptyImage);

            switch(place)
            {
                case 1:
                    iv_11.setImageResource(frameImage);
                    break;
                case 2:
                    iv_12.setImageResource(frameImage);
                    break;
                case 3:
                    iv_13.setImageResource(frameImage);
                    break;
            }
        }
        if(row==2)
        {
            iv_21.setImageResource(emptyImage);
            iv_22.setImageResource(emptyImage);
            iv_23.setImageResource(emptyImage);

            switch(place)
            {
                case 1:
                    iv_21.setImageResource(frameImage);
                    break;
                case 2:
                    iv_22.setImageResource(frameImage);
                    break;
                case 3:
                    iv_23.setImageResource(frameImage);
                    break;
            }
        }
        if(row==3)
        {
            iv_31.setImageResource(emptyImage);
            iv_32.setImageResource(emptyImage);
            iv_33.setImageResource(emptyImage);

            switch(place)
            {
                case 1:
                    iv_31.setImageResource(frameImage);
                    break;
                case 2:
                    iv_32.setImageResource(frameImage);
                    break;
                case 3:
                    iv_33.setImageResource(frameImage);
                    break;
            }
        }
        if(row==4)
        {
            iv_41.setImageResource(emptyImage);
            iv_42.setImageResource(emptyImage);
            iv_43.setImageResource(emptyImage);

            switch(place)
            {
                case 1:
                    iv_41.setImageResource(tapImage);
                    break;
                case 2:
                    iv_42.setImageResource(tapImage);
                    break;
                case 3:
                    iv_43.setImageResource(tapImage);
                    break;
            }
        }
        if(row==5)
        {
            iv_51.setImageResource(emptyImage);
            iv_52.setImageResource(emptyImage);
            iv_53.setImageResource(emptyImage);

            switch(place)
            {
                case 1:
                    iv_51.setImageResource(AfterClickImage);
                    break;
                case 2:
                    iv_52.setImageResource(AfterClickImage);
                    break;
                case 3:
                    iv_53.setImageResource(AfterClickImage);
                    break;
            }
        }
    }

    private void continueGame()
    {
        //row5
        rockLocationRow5=rockLocationRow4;
        setRockLocation(rockLocationRow5,5);

        //row4
        rockLocationRow4=rockLocationRow3;
        setRockLocation(rockLocationRow4,4);

        //row3
        rockLocationRow3=rockLocationRow2;
        setRockLocation(rockLocationRow3,3);

        //row2
        rockLocationRow2=rockLocationRow1;
        setRockLocation(rockLocationRow2,2);

        //row1
        rockLocationRow1=r.nextInt(3)+1;
        setRockLocation(rockLocationRow1,1);

        currentScore++;
        tv_score.setText("SCORE: "+currentScore);


    }

    
    private void endGame()
    {
        timer.cancel();
        tv_time.setText("TIME: "+millisToTime(0));
        if(currentScore>bestScore)
        {
            bestScore=currentScore;
            tv_best.setText("BEST: "+bestScore);

            SharedPreferences preferences1=getSharedPreferences("PREFS",0);
            SharedPreferences.Editor editor=preferences1.edit();
            editor.putInt(Stime,bestScore);
            editor.apply();
            isTop = true;

        }
        Intent intent=new Intent(MainActivity.this,EndActivity.class);
        intent.putExtra("currentScore",currentScore+"");
        intent.putExtra("bestScore",bestScore+"");
        intent.putExtra("isTop", isTop);
        startActivity(intent);
    }

    private int millisToTime(long millis)
    {
        return (int)millis/1000;
    }

    private void loadImages()
    {
        frameImage=R.drawable.frame;
        AfterClickImage=R.drawable.done;
        tapImage=R.drawable.tap;
        emptyImage=R.drawable.tile;
        red = R.drawable.red2;
    }
}
