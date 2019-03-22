package com.shatokhina.controlwork;

import java.util.*;

import static java.util.Objects.requireNonNull;

public class Administrator {
    private static Set<String> doctors = new HashSet<>();
    private Set<String> patients = new HashSet<>();
    private Map<Record, String> visits = new HashMap<>();

    static {
        doctors.add("head");
        doctors.add("therapist");
        doctors.add("surgeon");
        doctors.add("neurologist");
    }

    public void registration(String login) {
        requireNonNull(login);
        patients.add(login);
    }

    public static Set<String> getDoctors() { return doctors; }

    public Map<Record, String> getVisits() { return visits; }
}