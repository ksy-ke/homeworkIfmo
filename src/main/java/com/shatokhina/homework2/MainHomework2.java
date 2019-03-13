package com.shatokhina.homework2;

import com.shatokhina.homework2.task1.IncreasingSequence;
import com.shatokhina.homework2.task2.PositiveSequence;
import com.shatokhina.homework2.task3.DegreesOfNumber;
import com.shatokhina.homework2.task4.NaturalNumber;
import com.shatokhina.homework2.task5.FibonacciSequence;
import com.shatokhina.homework2.task6.RollOfTickets;
import com.shatokhina.homework2.task7.Watch;

public class MainHomework2 {
    public static void main(String[] args) {
        // task #1
        System.out.println("Task #1");
        IncreasingSequence increasingSequence = new IncreasingSequence(-3, 4, 1);
        for (int current : increasingSequence.getSequenceOrder()) {
            System.out.print(current + " ");
        }

        // task #2
        System.out.println("\n\nTask #2");
        new PositiveSequence(90, 5);

        // task #3
        System.out.println("\nTask #3");
        new DegreesOfNumber(2, 20);

        // task #4
        System.out.println("\n\nTask #4");
        int number = 11;
        NaturalNumber naturalNumber = new NaturalNumber(number);
        if (naturalNumber.isPrimeNumber()) {
            System.out.println("Natural number " + number + " is prime");
        } else {
            System.out.println("Natural number " + number + " is compound");
        }

        // task #5
        System.out.println("\nTask #5");
        int howMany = 11;
        FibonacciSequence fibonacciSequence = new FibonacciSequence(howMany);
        int[] fibonacci = fibonacciSequence.getSequence();
        for (int current : fibonacci)
            System.out.print(current + " ");

        // task #6
        System.out.println("\n\nTask #6");
        System.out.println("Amount of lucky tickets: " + RollOfTickets.luckyTickets());

        // task #7
        System.out.println("\nTask #7");
        System.out.println("In the day, the symmetrical time occurs " + Watch.symmetrical() + " times");
    }
}