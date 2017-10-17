package com.company;



public class GameLock {
    private int[] dials;
    private int[] goodGuesses = new int[0];
    private int incorrectGuesses = 3;

    public GameLock(int numOfDials) {
        this.dials = new int[numOfDials];
        for(int i=0; i<dials.length; i++){
            dials[i] = (int)(Math.random() * 10);
        }
    }

    public GameLock(int[] combination){
        this.dials = combination;
    }

    public void guessNumber(int number){
        boolean matchFound = false;
        int[] array = new int[goodGuesses.length + 1];
        for(int dial : dials){
            if(dial == number){
                System.arraycopy(goodGuesses, 0, array, 0, goodGuesses.length);
                array[goodGuesses.length] = number;
                matchFound = true;
                break;
            }
        }
        if(matchFound){
            goodGuesses = array;
        } else {
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
        return this.dials.length == this.goodGuesses.length;
    }

}
