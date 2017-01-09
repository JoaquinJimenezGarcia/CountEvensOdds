package com.joaquinjimenezgarcia;

import java.text.DecimalFormat;

public class Main {

    public static void main(String[] args) {

        final int SIZE = 100;
        final int ARRAY [] = new int[SIZE];
        final int MAXIMUM = 99;
        final int MINIMUM = 0;

        fillArray(ARRAY, MAXIMUM, MINIMUM);
        printArray(ARRAY);
        printCountTens(MAXIMUM, MINIMUM, ARRAY);
        countEvensOdds(ARRAY, SIZE);

    }

    static void fillArray(int arrayFilled[], int limitMaximum, int limitMinimum){
        for (int i = 0; i < arrayFilled.length ; i++) {
            arrayFilled[i] = (int)(Math.random()*limitMaximum+limitMinimum);
        }
    }

    static void printArray(int printedArray[]){
        int lineUp = 0;

        System.out.println("NUMBERS");
        System.out.println("=======");
        for (int i = 0; i < printedArray.length; i++) {
            System.out.printf(" %2d", printedArray[i]);
            lineUp++;

            if (lineUp==10){
                System.out.println();
                lineUp = 0;
            }
        }
        System.out.println();
    }

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

    static void countEvensOdds(int arrayEvensOdds[], int total){
        DecimalFormat decimals = new DecimalFormat("0.00");

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
