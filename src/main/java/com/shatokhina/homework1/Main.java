package com.shatokhina.homework1;

import com.shatokhina.homework1.task1.Parallelepiped;
import com.shatokhina.homework1.task2.GardenPlot;
import com.shatokhina.homework1.task3.OvalRing;

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
        System.out.println("\n" + "Task #2");
        GardenPlot gardenPlot = new GardenPlot();
        System.out.println("Not occupied " + gardenPlot.getRemainder() + " meters squared");

        // for task #3
        System.out.println("\n" + "Task #3");
        OvalRing ovalRing = new OvalRing();
        System.out.println("Area oval ring " + ovalRing.getOvalRing() + " centimeters squared");

        // for task #4
        System.out.println("\n" + "Task #4");

    }
}