package com.shatokhina.homework9.personTask;

public enum Company {
    GILLETTE, SECRET, COLGATE, LIPTON, NESCAFE, JACOBS, ORBIT, SAFEGUARD, LONDA, LENOR, FAIRY;

    public static Company getCompany(int number) {
        for (Company company : values())
            if (number == company.ordinal()) return company;
        throw new AssertionError("Wrong ordinal: " + number);
    }
}