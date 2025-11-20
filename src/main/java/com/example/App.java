package com.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App 
{
    public static int input;
    public static Scanner scanner = new Scanner(System.in);

    public static void levelSelect(int level){
        
    }

    public static void main( String[] args )
    {
        System.out.println("Welcome to the Number Guessing Game");
        System.out.println("I'm thinking of a number between 1 and 100.");
        System.out.println("You will have different amount of guesses for each difficulty. \n");

        System.out.println("Please select a difficulty level");
        System.out.println("1. Easy (10 Chances");
        System.out.println("2. Medium (5 chances)");
        System.out.println("3. Hard (3 chances)\n");

        try {
            input = scanner.nextInt();
            levelSelect(input);
        } catch (InputMismatchException e) {
            System.out.println("Please choose a level 1, 2, or 3");
        }
    }
}
