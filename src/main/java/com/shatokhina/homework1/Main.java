package com.shatokhina.homework1;

import com.shatokhina.homework1.task1.Parallelepiped;
import com.shatokhina.homework1.task2.GardenPlot;
import com.shatokhina.homework1.task3.Oval;
import com.shatokhina.homework1.task4.NearestIdentifier;
import com.shatokhina.homework1.task5.QuadraticEquation;
import com.shatokhina.homework1.task6.Tally;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        // for task #1
        System.out.println("Task #1");
        Parallelepiped parallelepiped = new Parallelepiped(23, 53, 93);
        System.out.println("Area = " + parallelepiped.area());
        if (parallelepiped.isWidth()) {
            System.out.println("Width greater than length");
        } else {
            System.out.println("Length greater than width");
        }

        // for task #2
        System.out.println("\n Task #2");
        GardenPlot gardenPlot = new GardenPlot(50, 20);
        System.out.println("Not occupied " + gardenPlot.remainderArea(15, 20) + " meters squared");

        // for task #3
        System.out.println("\n Task #3");
        Oval big = Oval.ofDecimeters(35);
        Oval small = Oval.ofCentimeters(600);
        System.out.println("Area oval ring " + big.minus(small) + " centimeters squared");

        // for task #4
        System.out.println("\n Task #4");
        final double base = 10;
        final double first = 8.5;
        final double second = 11.45;
        NearestIdentifier nearestIdentifier = new NearestIdentifier(base);
        System.out.println("Nearest to " + base + " between " + first + " and " + second +
                "  -> " + nearestIdentifier.nearest(first, second));

        // for task #5
        System.out.println("\n Task #5");
        QuadraticEquation quadraticEquation = new QuadraticEquation(-1, -2, 15);
        Optional<Double> firstRoot = quadraticEquation.getSquareRoot1();
        Optional<Double> secondRoot = quadraticEquation.getSquareRoot2();
        if (secondRoot.isPresent()) {
            System.out.println("quadratic roots: " + firstRoot.get() + " and " + secondRoot.get());
        } else if (firstRoot.isPresent()) {
            System.out.println("quadratic root: " + firstRoot.get());
        } else {
            System.out.println("no square roots");
        }

        // for task #6
        System.out.println("\n Task #6");
        int baseNum = 795;
        Tally tally = new Tally(baseNum);
        System.out.println("In " + baseNum + " max numeric is " + tally.findMax());
    }
}