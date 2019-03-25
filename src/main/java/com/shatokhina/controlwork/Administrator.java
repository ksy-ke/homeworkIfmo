package com.shatokhina.controlwork;

import com.shatokhina.controlwork.doctors.Doctor;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static java.util.Objects.requireNonNull;

public class Administrator {
    private final static Administrator ADMINISTRATOR = new Administrator();
    private Map<String, Doctor> doctors = new HashMap<>();
    private Map<String, Patient> patients = new HashMap<>();
    private Map<LocalDateTime, Patient> recordsToTherapist = new HashMap<>();
    private Map<LocalDateTime, Patient> recordsToSurgeon = new HashMap<>();
    private Map<LocalDateTime, Patient> recordsToNeurologist = new HashMap<>();

    private Administrator() {
        doctors.put("head", new Doctor("head"));
        doctors.put("therapist", new Doctor("therapist"));
        doctors.put("surgeon", new Doctor("surgeon"));
        doctors.put("neurologist", new Doctor("neurologist"));
    }

    public void authorizePatient(String login) {
        requireNonNull(login);
        patients.put(login, patients.computeIfAbsent(login, Patient::new));
    }

    public static Administrator getAdministrator() { return ADMINISTRATOR; }

    public Map<String, Doctor> getDoctors() { return doctors; }

    public Map<String, Patient> getPatients() { return patients; }

    public Map<LocalDateTime, Patient> getRecordsToTherapist() { return recordsToTherapist; }

    public Map<LocalDateTime, Patient> getRecordsToSurgeon() { return recordsToSurgeon; }

    public Map<LocalDateTime, Patient> getRecordsToNeurologist() { return recordsToNeurologist; }
}