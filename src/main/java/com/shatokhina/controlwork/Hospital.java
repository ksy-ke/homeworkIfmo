package com.shatokhina.controlwork;

import java.util.Scanner;

public class Hospital {
    private static Administrator administrator = Administrator.getAdministrator();
    private static Scanner scanner = new Scanner(System.in);

    public void open() {
        System.out.println("Введите логин: ");
        String login = scanner.nextLine();

        if (administrator.getDoctors().containsKey(login)) {
            openAsDoctor(login);
        } else administrator.authorizePatient(login);
    }

    private void openAsDoctor(String login) {
        System.out.println("Enter \"view\", if you want to see the records to you: ");
        String command = scanner.nextLine();
        if (command.equals("view")) {
            administrator.getDoctors().get(login).viewRecords();
        }
    }
}