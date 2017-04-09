package com.wtmk.alexis.quizapp;

import android.graphics.Color;

import java.util.Random;

public class PrettyColors {

    public String[] mColors = {
            "#7da3a1", // light blue
            "#34675c", // dark blue
            "#86ac41", // mauve
            "#324851", // red

    };

    public int getColor(){

        String color;
        //Randomly select RLA fact
        Random randomGenerator = new Random();
        int randomNumber = randomGenerator.nextInt(mColors.length);
        color = mColors[randomNumber];
        int colorAsInt = Color.parseColor(color);
        return colorAsInt;


    }

}