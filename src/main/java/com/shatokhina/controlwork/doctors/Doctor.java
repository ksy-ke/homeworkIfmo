package com.shatokhina.controlwork.doctors;

import com.shatokhina.controlwork.Administrator;
import com.shatokhina.controlwork.Patient;

import java.time.LocalDateTime;
import java.util.Map;

public class Doctor {
    private final String login;

    public Doctor(String login) { this.login = login; }

    public void viewRecords() {
        Administrator administrator = Administrator.getAdministrator();
        Map<LocalDateTime, Patient> records;

        switch (login) {
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

        records.forEach((dateTime, patient) -> System.out.println(dateTime + " patient: " + patient.getLogin()));
    }
}