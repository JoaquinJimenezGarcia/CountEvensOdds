package com.joaquinjimenezgarcia;

import java.text.DecimalFormat;

public class Main {

    public static void main(String[] args) {

        final int SIZE = 100; // Size of the Array
        final int ARRAY [] = new int[SIZE]; // Empty array for fill with the random number
        final int MAX = 99; // Max limit of the number generated
        final int MIN = 0; // Min limit of the nomber generated

        fillArray(ARRAY, MAX, MIN);
        printArray(ARRAY);
        printCountTens(MAX, MIN, ARRAY);
        countEvensOdds(ARRAY, SIZE);

    }

    /**
     * Fill the array with random values (min-max)
     * @param arrayFilled
     * @param limitMax
     * @param limitMin
     */
    static void fillArray(int arrayFilled[], int limitMax, int limitMin){
        for (int i = 0; i < arrayFilled.length ; i++) {
            arrayFilled[i] = (int)(Math.random()*limitMax+limitMin);
        }
    }

    /**
     * Print the array with the random numbers (10 per line)
     * @param printedArray
     */
    static void printArray(int printedArray[]){
        System.out.println("NUMBERS");
        System.out.println("=======");
        for (int i = 0; i < printedArray.length; i++) {
            System.out.printf(" %2d", printedArray[i]);

            // Change the line when it has 10 numbers
            if ((i+1)%10 == 0){
                System.out.println();
            }
        }
        System.out.println();
    }

    /**
     * Count and print how many numbers are per tens
     * @param maxNumber
     * @param minNumber
     * @param arrayCount
     */
    static void printCountTens(int maxNumber, int minNumber, int arrayCount[]){
        System.out.println("COUNT");
        System.out.println("=====");

        int initNumber = 0, finalNumber = 9;
        int quantity;

        while(finalNumber<=maxNumber){
            quantity = 0;

            for (int i = 0; i < arrayCount.length ; i++) {
                if(arrayCount[i]>=initNumber && arrayCount[i]<=finalNumber){
                    quantity++;
                }
            }

            System.out.println(initNumber+"..."+finalNumber+": " + quantity + " numbers");
            initNumber += 10;
            finalNumber +=10;
        }
        System.out.println();
    }

    /**
     * Count the porcentage of evens and odds and print it
     * @param arrayEvensOdds
     * @param total
     */
    static void countEvensOdds(int arrayEvensOdds[], int total){
        DecimalFormat decimals = new DecimalFormat("0.00"); // Indicates how many decimals

        int evens = 0, odds = 0;
        final double porcentageEvens, porcentageOdds;

        System.out.println("EVENS VS ODDS");
        System.out.println("=============");

        for (int i = 0; i < arrayEvensOdds.length ; i++) {
            if(arrayEvensOdds[i]%2==0){
                evens++;
            }else{
                odds++;
            }
        }

        porcentageEvens = (double) evens/total*100;
        porcentageOdds = (double) odds/total*100;

        System.out.println(evens + " evens [" + decimals.format(porcentageEvens) +"%]");
        System.out.println(odds + " odds [" + decimals.format(porcentageOdds) + "%]" );
    }
}