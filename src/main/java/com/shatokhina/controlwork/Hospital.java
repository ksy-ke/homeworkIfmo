package com.shatokhina.controlwork;

import com.shatokhina.controlwork.doctors.Neurologist;
import com.shatokhina.controlwork.doctors.Surgeon;
import com.shatokhina.controlwork.doctors.Therapist;

import java.util.Scanner;

public class Hospital {

    private static Administrator administrator = new Administrator();
    private static Scanner scanner = new Scanner(System.in);

    public void open() {
        System.out.println("Введите логин: ");
        String login = scanner.nextLine();

        boolean isDoctor = false;
        for (String i : Administrator.getDoctors()) {
            if (login.equals(i)) {
                isDoctor = true;
                if (login.equals("head")) openHowHead();
                else openHowDoctor(login);
            }
        }

        if (!isDoctor) {
            administrator.registration(login);
            openHowPatient(login);
        }
    }

    private void openHowHead() {

    }

    private void openHowDoctor(String login) {
        switch (login){
            case "neurologist":
                new Neurologist().viewRecords(administrator);
            case "therapist":
                new Therapist().viewRecords(administrator);
            case "surgeon":
                new Surgeon().viewRecords(administrator);
        }
    }

    private void openHowPatient(String login) {

    }
}
