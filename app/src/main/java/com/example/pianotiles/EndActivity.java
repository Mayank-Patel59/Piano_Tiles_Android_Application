package com.example.pianotiles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class EndActivity extends AppCompatActivity {

    TextView tvscore;
    TextView tvhscore;
    TextView greet;
    Button home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);

        tvscore = (TextView) findViewById(R.id.tvscore);
        tvhscore = (TextView) findViewById(R.id.tvhscore);
        greet = (TextView) findViewById(R.id.greet);

        Intent intent=getIntent();
        String cs = intent.getStringExtra("currentScore");
        String bs = intent.getStringExtra("bestScore");
        boolean isTop = intent.getBooleanExtra("isTop",false);
//        String greet = isTop ?"Congratulations!!" + "\n" + "You are the new High Scorer." : " ";
        tvscore.setText("Your Score: " + cs);
        tvhscore.setText("Best Score:" + bs);

        if(isTop)
            greet.setVisibility(TextView.VISIBLE);

        home = findViewById(R.id.home);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(EndActivity.this,HomePage.class);
                startActivity(intent);
            }
        });
    }
}
