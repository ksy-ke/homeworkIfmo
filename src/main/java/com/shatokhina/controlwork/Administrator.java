package com.shatokhina.controlwork;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

import static java.util.Collections.*;
import static java.util.Objects.requireNonNull;

public class Administrator {
    private final static Administrator ADMINISTRATOR = new Administrator();
    private Map<String, Doctor> doctors = new HashMap<>();
    private Map<String, Patient> patients = new HashMap<>();
    private Map<LocalDateTime, Patient> recordsToTherapist = new HashMap<>();
    private Map<LocalDateTime, Patient> recordsToSurgeon = new HashMap<>();
    private Map<LocalDateTime, Patient> recordsToNeurologist = new HashMap<>();
    private Scanner scanner = new Scanner(System.in);


    private Administrator() {
        doctors.put("head", new Doctor("head"));
        doctors.put("therapist", new Doctor("therapist"));
        doctors.put("surgeon", new Doctor("surgeon"));
        doctors.put("neurologist", new Doctor("neurologist"));
    }

    public Patient authorizePatient(String login) {
        requireNonNull(login);
        return patients.put(login, patients.computeIfAbsent(login, Patient::new));
    }

    public boolean makeAppointment(Patient patient) {
        System.out.println("Enter the doctor’s specialization you want to make an appointment for : ");
        String doc = scanner.nextLine();
        while (!getDoctors().containsKey(doc) || doc.equals("head")) {
            System.out.println("There is no such doctor in the hospital, enter another: ");
            doc = scanner.nextLine();
        }

        if (!checkRecord(doc, patient)) {
            LocalDateTime dateTime = collectedDateTime();

            while (!isBusy(doc, dateTime, patient).equals(patient)) {
                System.out.println("This time is busy, enter another");
                dateTime = collectedDateTime();
            }

            patient.setRecord(doc, dateTime);
            return true;
        } else return false;
    }

    public static Administrator getAdministrator() { return ADMINISTRATOR; }

    public Map<String, Doctor> getDoctors() { return doctors; }

    public Map<String, Patient> getPatients() { return patients; }

    public Map<LocalDateTime, Patient> getRecordsToTherapist() {
        recordsToTherapist.entrySet().removeIf(records -> records.getKey().isBefore(LocalDateTime.now()));
        return recordsToTherapist;
    }

    public Map<LocalDateTime, Patient> getRecordsToSurgeon() {
        recordsToSurgeon.entrySet().removeIf(records -> records.getKey().isBefore(LocalDateTime.now()));
        return recordsToSurgeon;
    }

    public Map<LocalDateTime, Patient> getRecordsToNeurologist() {
        recordsToNeurologist.entrySet().removeIf(records -> records.getKey().isBefore(LocalDateTime.now()));
        return recordsToNeurologist;
    }

    private boolean checkRecord(String doc, Patient patient) {
        switch (doc) {
            case "neurologist":
                return patient.getRecordToNeurologist().map(this::tellIfPresent).orElse(false);
            case "therapist":
                return patient.getRecordToTherapist().map(this::tellIfPresent).orElse(false);
            case "surgeon":
                return patient.getRecordToSurgeon().map(this::tellIfPresent).orElse(false);
            default:
                throw new IllegalStateException();
        }
    }

    private boolean tellIfPresent(LocalDateTime dateTime) {
        System.out.println("You are already registered to this doctor on " + dateTime);
        return true;
    }

    private Patient isBusy(String doc, LocalDateTime requested, Patient patient) {
        switch (doc) {
            case "neurologist":
                return recordsToNeurologist.computeIfAbsent(requested, dateTime -> patient);
            case "therapist":
                return recordsToTherapist.computeIfAbsent(requested, dateTime -> patient);
            case "surgeon":
                return recordsToSurgeon.computeIfAbsent(requested, dateTime -> patient);
            default:
                throw new IllegalStateException();
        }
    }

    private LocalDateTime collectedDateTime() {
        LocalDate localDate = null;
        LocalTime localTime = null;
        boolean check = false;

        do {
            System.out.println("To make an appointment with a doctor, you need to enter the date in the format YYYY-MM-DD: ");
            String inputDate = scanner.nextLine();
            try {
                localDate = LocalDate.parse(inputDate, DateTimeFormatter.ISO_LOCAL_DATE);
                check = localDate.isAfter(LocalDate.now());
                if (!check) System.out.println("This date can not be recorded");
            } catch (DateTimeParseException e) {
                System.out.println("Incorrect format date");
            }
        } while (!check);

        check = false;
        do {
            System.out.println("Working hours from 8 to 20 hours. Reception of a new patient occurs every 20 minutes, i.e. at 00, 20, 40 minutes. \n" +
                    "Enter the desired reception time in the format HH:MM :");
            String inputTime = scanner.nextLine();
            try {
                localTime = LocalTime.parse(inputTime, DateTimeFormatter.ISO_LOCAL_TIME);
                int hour = localTime.getHour();
                int minute = localTime.getMinute();
                if (hour < 20 && hour > 8) {
                    if (minute == 20 || minute == 40 || minute == 0) {
                        check = true;
                    }
                } else System.out.println("This time can not be recorded");
            } catch (DateTimeParseException e) {
                System.out.println("Incorrect format time");
            }
        } while (!check);

        return LocalDateTime.of(localDate, localTime);
    }
}