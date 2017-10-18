package com.company;


import java.lang.reflect.Array;
import java.util.Arrays;

public class GameLock {
    private int[] dials;
    private int[] goodGuesses = new int[0];
    private int incorrectGuesses = 3;

    public GameLock(int numOfDials) {
        this.dials = new int[numOfDials];
        for(int i=0; i<dials.length; i++){
            dials[i] = (int)(Math.random() * 10);
        }
        this.goodGuesses = new int[numOfDials];
    }

    public GameLock(int[] combination){
        this.dials = combination;
        this.goodGuesses = new int[dials.length];
    }

    public void guessNumber(int number){
        boolean matchFound = false;
        for(int i = 0; i< dials.length; i++){
            if(dials[i] == number){
                goodGuesses[i] = number;
                matchFound = true;
            }
        }
        if(!matchFound){
            incorrectGuesses--;
        }
    }

    public String getDisplay(){
        String combination = "";
        for(int i=0; i < dials.length; i++){
            boolean match = false;
            for(int j=0; j<goodGuesses.length; j++){
                if(dials[i] == goodGuesses[j]){
                    match = true;
                    break;
                }
            }
            if(match){
                combination += dials[i] + " ";
            } else {
                combination += "- ";
            }
        }
        return combination;
    }

    public int getIncorrectGuessesLeft(){
        return incorrectGuesses;
    }

    public boolean isLockOpen(){
        if (this.dials == null) {
            return false;
        }
        if (this.goodGuesses == null) {
            return false;  // already know 'a' isn't null
        }
        if (this.dials.length != this.goodGuesses.length) {
            return false;
        }
        for (int i = 0; i < this.dials.length; i++) {
            if (this.dials[i] != this.goodGuesses[i]) {
                return false;
            }
        }
        return true;
    }

}
