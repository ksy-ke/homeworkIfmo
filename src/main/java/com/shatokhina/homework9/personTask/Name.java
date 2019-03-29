package com.shatokhina.homework9.personTask;

public enum Name {
    AMELIA, AVA, CHARLIE, EMILY, JACK, JAMES, JACOB, JESSICA, OLIVER, OLIVIA, HARRY, ISLA, THOMAS,
    POPPY, OSCAR, ISABELLA, WILLIAM, SOPHIE, MIA, GEORGE;

    public static Name getName(int number) {
        for (Name name : values())
            if (number == name.ordinal()) return name;
        throw new AssertionError("Wrong ordinal: " + number);
    }
}