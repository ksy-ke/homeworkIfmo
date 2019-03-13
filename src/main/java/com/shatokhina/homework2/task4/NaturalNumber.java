package com.shatokhina.homework2.task4;

/*
Проверьте, является ли натуральное число — простым.
*/

public class NaturalNumber {
    private final int naturalNumber;

    public NaturalNumber(int naturalNumber) { this.naturalNumber = naturalNumber; }

    public boolean isPrimeNumber() {
        boolean isSimple = true;
        if (naturalNumber == 1 || naturalNumber == 2) { return isSimple; }
        for (int divider = 2; divider <= Math.sqrt(naturalNumber); divider++) {
            if (naturalNumber % divider == 0) {
                isSimple = false;
                break;
            }
        }
        return isSimple;
    }
}
