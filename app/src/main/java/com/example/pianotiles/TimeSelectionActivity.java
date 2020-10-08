package com.example.pianotiles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class TimeSelectionActivity extends AppCompatActivity {
    Button ContButton;
    RadioGroup rgtime;
    RadioButton rbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_selection);

        rgtime=(RadioGroup)findViewById(R.id.rgtime);
        ContButton=(Button)findViewById(R.id.cont);

        ContButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int radioId=rgtime.getCheckedRadioButtonId();
                rbtn=(RadioButton)findViewById(radioId);
                String ts=rbtn.getText().toString();
                Intent intent=new Intent(TimeSelectionActivity.this,MainActivity.class);
                intent.putExtra("ts",ts);
                startActivity(intent);
            }
        });
    }
}
