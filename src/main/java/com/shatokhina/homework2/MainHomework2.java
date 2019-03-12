package com.shatokhina.homework2;

import com.shatokhina.homework2.task1.IncreasingSequence;
import com.shatokhina.homework2.task3.DegreesOfNumber;
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

        // task #3
        System.out.println("\n\nTask #3");
        new DegreesOfNumber(2, 20);

        // task #6
        System.out.println("\n\nTask #6");
        System.out.println("Amount of lucky tickets: " + RollOfTickets.luckyTickets());

        // task #7
        System.out.println("\nTask #7");
        System.out.println(Watch.symmetrical());
    }
}