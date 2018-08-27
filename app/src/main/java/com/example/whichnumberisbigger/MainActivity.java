package com.example.whichnumberisbigger;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button leftButton;
    Button rightButton;
    TextView taskText;
    TextView scoreDisplay;
    int int1;
    int int2;
    int score;
    String scoreText;
    String message;
    public static final int MAX_NUM = 1001;
    ConstraintLayout mainLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        leftButton = findViewById(R.id.main_button_left);
        rightButton = findViewById(R.id.main_button_right);
        taskText = findViewById(R.id.main_textview_task);
        scoreDisplay = findViewById(R.id.main_textview_score);
        mainLayout = findViewById(R.id.main_constraint_layout);
        score = 0;
        int1 = 0;
        int2 = 0;
        scoreText = getResources().getString(R.string.scorecolon);
        genNums();
        message = "";
        leftButton.setText(String.valueOf(int2));
        rightButton.setText(String.valueOf(int1));

    }

    public void genNums(){
        int1 = (int) (Math.random() * MAX_NUM);
        int rand = (int) (Math.random() * MAX_NUM);
        while(rand == int1){
            rand = (int) (Math.random() * MAX_NUM);
        }
        int2 = rand;
        rightButton.setText(String.valueOf(int1));
        leftButton.setText(String.valueOf(int2));
    }
    public void buttonAction(boolean button){
        if((!button&&(int1 > int2) || (button&&(int1 < int2)))) {
                score--;
                message = ":(";
                mainLayout.setBackgroundColor(getResources().getColor(R.color.lightRed));
        }
        else{
            score++;
            message = "Correct!";
            mainLayout.setBackgroundColor(getResources().getColor(R.color.lightGreen));

        }
        Toast.makeText(this, message,
                Toast.LENGTH_SHORT).show();
        genNums();
        scoreDisplay.setText(scoreText + score);
    }
    public void LeftButtonClick(View view) {
        buttonAction(false);

    }

    public void RightButtonClick(View view) {
        buttonAction(true);
    }
}

