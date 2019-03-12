package com.shatokhina.homework2.task7;

public class Watch {
    public static int symmetrical() {
        int count = 0;
        for (int hour = 0; hour < 24; hour++) {
            switch (hour % 10) {
                case 6:
                case 7:
                case 8:
                case 9:
                    break;
                default:
                    count++;
                    break;
            }
        }
        return count;
    }
}
