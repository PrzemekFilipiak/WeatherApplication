package com.sda.weather;

import java.util.Scanner;

public class UserInterface {

    private final EntryController entryController;

    public UserInterface(EntryController entryController) {
        this.entryController = entryController;
    }

    public void run() {
        System.out.println("Aplikacja jest uruchomiona\n");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Witaj w aplikacji pogoda, co chcesz zrobić?");
            System.out.println("1. Wybierz miasto");
            System.out.println("2. Wyswietl dane pogodowe");
            System.out.println("0. Zamknij aplikację");

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    createEntry();
                    break;
                case 2:
                    System.out.println("Pogoda");
                    break;
                case 0:
                    return;
            }
        }
    }
/*Dodatkowo w ramach zadania użytkownik powinien zadbać o odpowiednią walidację:
• długość i szerokość geograficzna zgodnie z wartościami geograficznymi
(szerokość: -90 -> S, 90 -> N, długość: -180 -> W, 180 -> E)
• nazwa miasta – nie może być pusta
• nazwa kraju – nie może być pusta
• region – opcjonalny*/

    private void createEntry() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj nazwę miasta\n" +
                "• długość i szerokość geograficzną\n" +
                "• region\n" +
                "• nazwę kraju:");
        String content = scanner.nextLine();
        // POST: /entry
        String request = String.format("{\"content\":\"%s\"}", content);
        System.out.println("Wysylany json: " + request);
        String response = entryController.createEntry(request);
        System.out.println("Odpowiedz z serwera: " + response);
    }
}
