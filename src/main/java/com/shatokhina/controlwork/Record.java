package com.shatokhina.controlwork;

import java.time.LocalDateTime;

public class Record {
    private String patient;
    private LocalDateTime date;

    public Record(String patient, LocalDateTime date) {
        this.patient = patient;
        this.date = date;
    }

    public String getPatient() { return patient; }

    public LocalDateTime getDate() { return date; }
}
