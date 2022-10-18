package com.example.ps2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button butTrue;
    private Button butFalse;
    private Button butNext;
    private TextView question;

    private Question[] questions ={
            new Question(R.string.q1,false),
            new Question(R.string.q2,false),
            new Question(R.string.q3,true),
            new Question(R.string.q4,false),
            new Question(R.string.q5,true)};
    private int curQuestion=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.butTrue = findViewById(R.id.trueButton);
        this.butFalse = findViewById(R.id.falseButton);
        this.butNext = findViewById(R.id.nextButton);
        this.question = findViewById(R.id.question);
        this.setQuestion();

        butTrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(true);
            }
        });
        butFalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(false);
            }
        });
        butNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                curQuestion = (curQuestion+1)%questions.length;
                setQuestion();
            }
        });
    }

    private void checkAnswer(boolean userAnswer){
        if(userAnswer == questions[curQuestion].isTrueAnswer()){
            Toast.makeText(this, R.string.correct, Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, R.string.incorrect, Toast.LENGTH_SHORT).show();
        }
    }

    private void setQuestion(){
        question.setText(questions[curQuestion].getQuestionId());
    }
}