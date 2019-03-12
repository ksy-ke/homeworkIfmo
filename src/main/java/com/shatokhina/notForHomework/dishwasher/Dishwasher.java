package com.shatokhina.notForHomework.dishwasher;

/*
Задать количество тарелок и количество моющего средства.
Моющее средство расходуется из расчета 0,5 на одну тарелку.
В цикле выводить сколько моющего средства осталось после мытья каждой тарелки
В конце вывести, сколько тарелок осталось, когда моющее средство закончилось или наоборот.
*/

import java.util.AbstractMap.SimpleEntry;

public class Dishwasher {
    private final int plate;
    private final double cleanser;

    public Dishwasher(int plate, double cleanser) {
        if (plate < 0 || cleanser < 0) { throw new IllegalArgumentException(); }
        this.plate = plate;
        this.cleanser = cleanser;
    }

    public Remained wash() {
        int currentPlate = plate;
        double currentCleanser = cleanser;
        while (currentPlate > 0 && currentCleanser >= 0.5) {
            currentCleanser -= 0.5;
            currentPlate--;
            System.out.println("Remainder of cleanser: " + currentCleanser);
        }
        return new Remained(currentPlate, currentCleanser);
    }

    public static final class Remained {
        private final int plate;
        private final double cleanser;

        private Remained(int plate, double cleanser) {
            this.plate = plate;
            this.cleanser = cleanser;
        }

        public int getPlate() { return plate; }

        public double getCleanser() { return cleanser; }
    }
}