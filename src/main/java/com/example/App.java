package com.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App 
{
    public static int input;
    public static Scanner scanner = new Scanner(System.in);

    public static void levelSelect(){
        boolean correctInput = false;

        System.out.println("Please select a difficulty level");
        System.out.println("1. Easy (10 Chances");
        System.out.println("2. Medium (5 chances)");
        System.out.println("3. Hard (3 chances)\n");

        while(!correctInput){
            try {
                input = scanner.nextInt();
                correctInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Please choose a level 1, 2, or 3");
                scanner.next();
            }
        }

        switch(input){
            case 1:
                System.out.println("Level 1 (Easy) Choosen");
                level(1);
                break;
            case 2:
                System.out.println("Level 2 (Medium) Choosen");
                level(2);
                break;
            case 3:
                System.out.println("Level 3 (Hard) Choosen");
                level(3);
                break;
            default:
                System.out.println("Please choose a level 1, 2, or 3.");
                levelSelect();
                break;
        }
    }

    public static void game(int guesses, int ans){
        boolean correctInput = false;
        String newGame; 
        boolean boolInput = false;
        int count = 0;

        while (guesses > 1) {
            count++;
            System.out.print("Enter your guess: ");
            try {
                input = scanner.nextInt();
                if(input >= 100 || input <= 1){
                    System.out.println("Please choose a number between 1 and 100:");
                }else{correctInput = true;}
            } catch (InputMismatchException e) {
                System.out.println("Sorry please input a number between 1 and 100:");
                scanner.next();
            }
            if (ans > input) {
                System.out.println("Incorrect! The number is greater than " + input);
            } else if (ans < input) {
                System.out.println("Incorrect! The number is smaller than " + input);
            } else {
                guesses = 0;
                System.out.println("Correct! You guessed the correct number in " + count + " attempts.");
                System.out.println("Would you like to play again? ");
                System.out.println("Yes or No");
                newGame = scanner.next();
                switch (newGame.toLowerCase()) {
                    case "yes":
                        levelSelect();
                        break;
                    case "no":
                        break;
                //need to continue here over and over until yes or no
                    default:
                        System.out.println("Please enter Yes or No: ");
                        scanner.next();
                        break;
                }
            }
        }
    }

    public static void level(int level){
        int range = 100 - 1;
        int ans = (int)(Math.random() * range) + 1;
        System.out.println(ans);
        if(level == 1){
            game(10, ans);
        }
        if(level == 2){
            game(5, ans);
        }
        if(level == 3){
            game(3, ans);
        }
    }

    public static void main( String[] args )
    {
        System.out.println("Welcome to the Number Guessing Game");
        System.out.println("I'm thinking of a number between 1 and 100.");
        System.out.println("You will have different amount of guesses for each difficulty. \n");

        levelSelect();
        scanner.close();
    }
}