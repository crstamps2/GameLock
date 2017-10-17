package com.company;

import java.util.Scanner;

public class InteractiveGuessingGame {
    private Scanner scanner;

    public InteractiveGuessingGame(){
        this.scanner = new Scanner(System.in);
    }

    public void run(){
        String keepGoing = "y";
        while(keepGoing.equals("y")){
            System.out.println("Enter the number of dials on the lock: ");
            String answer = scanner.next();
            GameLock game = new GameLock(Integer.parseInt(answer));
            while(game.isLockOpen() || game.getIncorrectGuessesLeft() == 0) {
                System.out.println("Enter the number you would like to guess: ");
                answer = scanner.next();
                System.out.println("The current display is: " + game.getDisplay());
                System.out.println("The number of incorrect guesses left is: " + game.getIncorrectGuessesLeft());
                if (game.isLockOpen()) {
                    System.out.println("Congratulations. You got it!");
                    System.out.println("Would you like to try another lock (y/n)?");
                    keepGoing = scanner.next();
                } else {
                    if (0 == game.getIncorrectGuessesLeft()) {
                        System.out.println("You ran out of guesses");
                        System.out.println("Would you like to try another lock (y/n)?");
                    }
                }
            }
        }
        System.out.println("Goodbye!");
    }
}
