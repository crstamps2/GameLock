package com.company;

import java.util.Scanner;

public class GuessingDemo {
    private GameLock lock;

    public GuessingDemo(){
        this.lock = new GameLock(3);
    }

    public void run(){
        System.out.println("The starting display is: " + lock.getDisplay());
        int guess;
        while(0 != lock.getIncorrectGuessesLeft()){
            guess = (int)(Math.random() * 10);
            System.out.println("Your guess?: " + guess);
            lock.guessNumber(guess);
            System.out.println("The display is: " + lock.getDisplay());
            if(lock.isLockOpen()){
                System.out.println("Congratulations. You got it!");
                break;
            } else {
                if(0 != lock.getIncorrectGuessesLeft()){
                    System.out.println("Number of incorrect guesses left: " + lock.getIncorrectGuessesLeft());
                } else {
                    System.out.println("You ran out of guesses");
                }
            }
        }

    }
}
