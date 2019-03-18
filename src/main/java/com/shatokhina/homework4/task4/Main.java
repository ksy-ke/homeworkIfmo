package com.shatokhina.homework4.task4;

public class Main {
    public static void main(String[] args) {
        Cat lucifer = new Cat("Lucifer", 9, 1, 10);
        Cat gor = new Cat("Gor", 11, 7, 7);
        if (lucifer.fight(gor)) {
            System.out.println("Lucifer win");
        } else {
            System.out.println("Gor win");
        }
    }
}
