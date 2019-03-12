package com.shatokhina.notForHomework.dishwasher;

public class Main {
    public static void main(String[] args) {
        Dishwasher dishwasher = new Dishwasher(3, 4.7);
        Dishwasher.Remained remainders = dishwasher.wash();

        int remainderPlate = remainders.getPlate();
        double remainderCleanser = remainders.getCleanser();

        if (remainders.getPlate() == 0) {
            System.out.println("\nEventually cleanser left: " + remainderCleanser);
        } else {
            System.out.println("\nEventually plate left: " + remainderPlate);
        }
    }
}
