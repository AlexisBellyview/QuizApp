package com.wtmk.alexis.quizapp;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;



public class MainPage extends AppCompatActivity {

    private TextView mQuestions;
    private Button mCorrectAnswer;
    private Button mFirstWrong;
    private Button mSecondWrong;
    private QuestionBank mQuestionBank = new QuestionBank();
    int RLA;
    int RRA;
    int wrongTwo;
    int wrongOne;
    int answer;
    private Button mSubmitButton;
    private ConstraintLayout mLayOut;
    private PrettyColors mPrettyColors = new PrettyColors();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        mQuestions = (TextView) findViewById(R.id.questions);
        mFirstWrong = (Button) findViewById(R.id.buttonTwo);
        mSecondWrong = (Button) findViewById(R.id.buttonThree);
        mCorrectAnswer = (Button) findViewById(R.id.buttonOne);
        mSubmitButton = (Button) findViewById(R.id.submitButton);
        RLA = mQuestionBank.getRandomLAdder();
        RRA = mQuestionBank.getRandomRAdder();
        answer = mQuestionBank.getAnswer(RLA, RRA);
        wrongOne = mQuestionBank.getWrongAnswerOne(RLA, RRA);
        wrongTwo = mQuestionBank.getWrongAnswerTwo(RLA, RRA);
        mQuestions.setText(RLA + " + " + RRA + " =  ?");
        mCorrectAnswer.setText(answer + "");
        mFirstWrong.setText(wrongOne + "");
        mSecondWrong.setText(wrongTwo + "");
        mLayOut = (ConstraintLayout) findViewById(R.id.QuizUI);


        final View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mSubmitButton.setText(answer+"   submit?");




            }
        };

        final View.OnClickListener wrongOneListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mSubmitButton.setText(wrongOne+"   submit?");




            }
        };

        final View.OnClickListener wrongTwoListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mSubmitButton.setText(wrongTwo+"   submit?");




            }
        };

        View.OnClickListener submitListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String correctAnswer = (String) mSubmitButton.getText();
                int rightAnswer = Integer.parseInt(correctAnswer.replaceAll("[\\D]",""));
                checkCorrect(rightAnswer);
                RLA = mQuestionBank.getRandomLAdder();
                RRA = mQuestionBank.getRandomRAdder();
                answer = mQuestionBank.getAnswer(RLA, RRA);
                wrongOne = mQuestionBank.getWrongAnswerOne(RLA, RRA);
                wrongTwo = mQuestionBank.getWrongAnswerTwo(RLA, RRA);
                mQuestions.setText(RLA + " + " + RRA + " =  ?");
                mCorrectAnswer.setText(answer + "");
                mFirstWrong.setText(wrongOne + "");
                mSecondWrong.setText(wrongTwo + "");

            }
        };

        mCorrectAnswer.setOnClickListener(listener);
        mFirstWrong.setOnClickListener(wrongOneListener);
        mSecondWrong.setOnClickListener(wrongTwoListener);
        mSubmitButton.setOnClickListener(submitListener);


    }

    private void checkCorrect(int check){
        int mCheck = check;
        int color = mPrettyColors.getColor();
        if (mCheck == answer){
            Toast.makeText(MainPage.this, "Correct", Toast.LENGTH_SHORT).show();
            mLayOut.setBackgroundColor(color);

        } else {
            Toast.makeText(MainPage.this, "Try Again", Toast.LENGTH_SHORT).show();
        }


    }




}







