package com.shatokhina.controlwork;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Scanner;

public class Doctor {
    private final String login;
    private String docForView;

    public Doctor(String login) { this.login = docForView = login; }

    public void viewRecords() {
        Map<LocalDateTime, Patient> records;
        Administrator administrator = Administrator.getAdministrator();

        switch (docForView) {
            case "neurologist":
                records = administrator.getRecordsToNeurologist();
                break;
            case "therapist":
                records = administrator.getRecordsToTherapist();
                break;
            case "surgeon":
                records = administrator.getRecordsToSurgeon();
                break;
            default:
                throw new IllegalStateException();
        }

        if (!records.isEmpty()) {
            records.forEach((dateTime, patient) ->
                    System.out.println(dateTime + " patient: " + patient.getLogin()));
        } else System.out.println("No records");
    }

    void viewRecordsForHead() {
        boolean isContinues = true;
        Scanner scanner = new Scanner(System.in);
        Administrator administrator = Administrator.getAdministrator();

        while (isContinues) {
            System.out.println("Enter the doctor’s specialization whose records you want to see: ");
            String doc = scanner.nextLine();
            while (!administrator.getDoctors().containsKey(doc) || doc.equals("head")) {
                System.out.println("There is no such doctor in the hospital, enter another: ");
                doc = scanner.nextLine();
            }
            docForView = doc;
            viewRecords();

            System.out.println("\nSee another doctor's records? Y/N");
            if (scanner.nextLine().equalsIgnoreCase("N")) isContinues = false;
        }
    }
}