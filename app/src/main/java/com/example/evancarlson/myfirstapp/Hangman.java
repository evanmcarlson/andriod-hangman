package com.example.evancarlson.myfirstapp;

import java.util.Random;

public class Hangman {

    public String randomPhrase() {
        // list of possible phrases
        String phraseList[] = {"university", "white pants", "los angeles", "backpack", "adventure", "european", "purple afro", "late night", "snacking", "filipino"};

        // choose phrase by random
        Random random = new Random();
        int x = random.nextInt(10);
        return phraseList[x];
    }

    public StringBuilder generateHiddenPhrase(String phrase) {
        // hide the phrase
        int i = 0;
        StringBuilder sb = new StringBuilder();

        while (i < phrase.length()) {
            if (Character.isLetter(phrase.charAt(i))) {
                sb.append("*");
            }
            else {
                sb.append(phrase.charAt(i));
            }
            i++;
        }
        return sb;
    }

    public int processGuess(String phrase, StringBuilder hiddenPhrase, char guess, int misses) {
        // check guess against the phrase
        int q = 0;
        boolean isInPhrase = false;
        while (q < phrase.length()) {
            if (guess == phrase.charAt(q)) {
                hiddenPhrase.setCharAt(q, guess);
                isInPhrase = true;
            }
            q++;
        }

        if (isInPhrase == false) {
            misses++;
        }

        return misses;
    }
}