package com.shatokhina.controlwork;

import java.time.LocalDateTime;
import java.util.Optional;

public class Patient {
    private final String login;
    private LocalDateTime recordToTherapist;
    private LocalDateTime recordToSurgeon;
    private LocalDateTime recordToNeurologist;

    public Patient(String login) { this.login = login; }

    void viewRecords() {
        System.out.println("Record to therapist " + (recordToTherapist != null ? recordToTherapist : " is missing"));
        System.out.println("Record to surgeon " + (recordToSurgeon != null ? recordToSurgeon : " is missing"));
        System.out.println("Record to neurologist " + (recordToNeurologist != null ? recordToNeurologist : " is missing"));
    }

    public void setRecord(String doc, LocalDateTime dateTime) {
        switch (doc) {
            case "neurologist":
                recordToNeurologist = dateTime;
                break;
            case "therapist":
                recordToTherapist = dateTime;
                break;
            case "surgeon":
                recordToSurgeon = dateTime;
                break;
            default:
                throw new IllegalStateException();
        }
    }

    public String getLogin() { return login; }

    public Optional<LocalDateTime> getRecordToTherapist() {
        if (recordToTherapist != null && recordToTherapist.isBefore(LocalDateTime.now())) recordToTherapist = null;
        return Optional.ofNullable(recordToTherapist);
    }

    public Optional<LocalDateTime> getRecordToSurgeon() {
        if (recordToSurgeon != null && recordToSurgeon.isBefore(LocalDateTime.now())) recordToSurgeon = null;
        return Optional.ofNullable(recordToSurgeon);
    }

    public Optional<LocalDateTime> getRecordToNeurologist() {
        if (recordToNeurologist != null && recordToNeurologist.isBefore(LocalDateTime.now())) recordToNeurologist = null;
        return Optional.ofNullable(recordToNeurologist);
    }
}