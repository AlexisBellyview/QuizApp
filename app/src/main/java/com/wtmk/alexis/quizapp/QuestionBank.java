package com.wtmk.alexis.quizapp;


import java.util.Random;

public class QuestionBank {
    private int randomLAdder;
    private int randomRAdder;
    private int randomAnswer;
    private int wrongAnswerOne;
    private int wrongAnswerTwo;
    private Random rand = new Random();


    public int getRandomLAdder(){
        randomLAdder = rand.nextInt(20);
        return randomLAdder;

    }

    public int getRandomRAdder(){
        randomRAdder = rand.nextInt(20);
        return randomRAdder;

    }

    public int getAnswer(int left, int right){
        randomAnswer = left + right;
        return randomAnswer;

    }

    public int getWrongAnswerOne(int left, int right){
        wrongAnswerOne =  left + right +2;
        return wrongAnswerOne;

    }

    public int getWrongAnswerTwo(int left, int right){
        wrongAnswerTwo = left + right -2;
        return  wrongAnswerTwo;


    }


}
