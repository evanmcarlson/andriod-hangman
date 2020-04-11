package com.example.evancarlson.myfirstapp;

import android.content.Intent;
import android.support.annotation.DrawableRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;
import java.util.Scanner;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class Activity2 extends AppCompatActivity {

    public Hangman hangman;
    public String phrase;
    public StringBuilder hiddenPhrase;
    public int misses = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        this.hangman = new Hangman();
        this.phrase = hangman.randomPhrase();
        this.hiddenPhrase = hangman.generateHiddenPhrase(phrase);
        TextView displayHidden = (TextView) findViewById(R.id.hiddenPhrase);
        displayHidden.setText(hiddenPhrase);
    }

    public void onButtonClick(View view) {
        Button b = (Button) view;   // view is the UI component on which the event occurred.
        EditText editText = (EditText) findViewById(R.id.editText);
        if (editText.getText().length() > 0) {
            char guess = editText.getText().toString().charAt(0);
            misses = hangman.processGuess(phrase, hiddenPhrase, guess, misses);

            TextView displayHidden = (TextView) findViewById(R.id.hiddenPhrase);
            displayHidden.setText(hiddenPhrase);
        }

        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        if (misses == 1) {
            imageView.setImageResource(R.drawable.hang1);
        }
        else if (misses == 2) {
            imageView.setImageResource(R.drawable.hang2);
        }
        else if (misses == 3) {
            imageView.setImageResource(R.drawable.hang3);
        }
        else if (misses == 4) {
            imageView.setImageResource(R.drawable.hang4);
        }
        else if (misses == 5) {
            imageView.setImageResource(R.drawable.hang5);
        }
    }

//    public boolean isValid(char guess) {
//        boolean validated = false;
//
//        while (validated == false) {
//            if (Character.isLetter(guess)) {
//                validated = true;
//            }
//            else {
//                System.out.println("The character you entered is not valid. Please enter letters only.");
//                System.out.print("Enter a guess: ");
//                //guess = scanner.next().charAt(0);
//            }
//        }
//        return true;
//    }

}