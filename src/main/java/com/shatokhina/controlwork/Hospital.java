package com.shatokhina.controlwork;

import java.util.Map;
import java.util.Scanner;

public class Hospital {
    private static Administrator administrator = Administrator.getAdministrator();
    private static Scanner scanner = new Scanner(System.in);
    boolean isClose = false;

    public void open() {
        while (!isClose) {
            System.out.println("Enter your login: ");
            String login = scanner.nextLine();

            if (administrator.getDoctors().containsKey(login)) {
                if (login.equals("head")) openAsHeadDoctor();
                else openAsDoctor(login);
            } else openAsPatient(login);
        }
    }

    private void openAsDoctor(String login) {
        boolean isExit = false;
        while (!isExit) {
            System.out.println("Enter \"1\", if you want to see the records to you or " +
                    "\nenter \"0\", if you want to log out of your account: ");
            String command = scanner.nextLine();
            switch (command) {
                case "1":
                    administrator.getDoctors().get(login).viewRecords();
                    break;
                case "0":
                    isExit = true;
                    break;
                default:
                    System.out.println("There is no such command.");
            }
        }
    }

    private void openAsHeadDoctor() {
        boolean isExit = false;
        while (!isExit) {
            System.out.println("\nEnter \"1\", if you want to see the records of doctors or " +
                    "\nenter \"2\", if you want to see list of patient or " +
                    "\nenter \"0\", if you want to log out of your account: " +
                    "\nenter \"close\", if you want to close the hospital: ");
            String command = scanner.nextLine();
            switch (command) {
                case "1":
                    administrator.getDoctors().get("head").viewRecordsForHead();
                    break;
                case "2":
                    Map<String, Patient> patients = administrator.getPatients();
                    if (!patients.isEmpty())
                        patients.forEach((patientName, profile) -> System.out.println(patientName));
                    else System.out.println("Patient list is empty");
                    break;
                case "0":
                    isExit = true;
                    break;
                case "close":
                    isClose = true;
                    break;
                default:
                    System.out.println("There is no such command.");
            }
        }
    }

    private void openAsPatient(String login) {
        boolean isExit = false;
        Patient patient = administrator.authorizePatient(login);
        while (!isExit) {
            System.out.println("Enter \"1\", if you want to see your records to the doctors " +
                    "\nenter \"2\", if you want to make an appointment with a doctor " +
                    "\nenter \"0\", if you want to log out of your account: ");

            String command = scanner.nextLine();
            switch (command) {
                case "1":
                    patient.viewRecords();
                    break;
                case "2":
                    boolean isAppointment = administrator.makeAppointment(patient);
                    while (!isAppointment) {
                        System.out.println("Choose another doctor? Y/N");
                        if (scanner.nextLine().equals("Y")) isAppointment = administrator.makeAppointment(patient);
                        else return;
                    }
                    break;
                case "0":
                    isExit = true;
                    break;
                default:
                    System.out.println("There is no such command.");
            }
        }
    }

    public static void main(String[] args) {
        new Hospital().open();
    }
}