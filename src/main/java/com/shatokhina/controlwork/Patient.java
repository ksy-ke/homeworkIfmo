package com.shatokhina.controlwork;

import java.time.LocalDateTime;

public class Patient {
    private final String login;
    private LocalDateTime recordToTherapist;
    private LocalDateTime recordToSurgeon;
    private LocalDateTime recordToNeurologist;

    public Patient(String login) { this.login = login; }

    public String getLogin() { return login; }

    public void recordToTherapist() {

    }

    public void recordToSurgeon() {

    }

    public void recordToNeurologist() {

    }
}
