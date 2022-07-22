package com.ciit.battlesimulator;

import com.ciit.battlesimulator.monsters.HyperionDemon;
import com.ciit.battlesimulator.UnitTesting;

import java.util.Scanner;

import static java.lang.String.valueOf;

public class MainMenu {
    GUI gui = new GUI();

    public void displayMenu() {
        Scanner menuChoice = new Scanner(System.in);
        String[] options = {"Start", "Credits", "Exit"};
        for (int i = 0; i < options.length; i++){
            System.out.printf("%s - %s\n", valueOf(i+1), options[i]);
        }
        System.out.printf("%s%sEnter your choice here:%s ", GUI.ANSI_WHITE_BG, GUI.ANSI_BLACK, GUI.ANSI_RESET);
        HyperionDemon hyperion = new HyperionDemon();

        int option = menuChoice.nextInt();
        switch(option) {
            case 1:
                runSimulator();
                break;
            case 2:
                showAbout();
                displayMenu();
                break;
            case 3:
                exit();
                break;
            case 4:
                UnitTesting.UnitTest(hyperion);

                break;
            default:
                System.out.println("Please enter a valid option.");
                displayMenu();
                break;
        }
    }

    public void runSimulator() {
        Simulator sim = new Simulator();
    }

    public void showAbout() {
        String[] credits = {"Nate Florendo", "Kyle Matias", "Sabin Cacho"};
        System.out.println("This is about us...");
        for (int i = 0; i < credits.length; i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {}
            System.out.println("Programmed by: " + credits[i]);
        }
        System.out.println("To be submitted to Mr. Raphael Alampay");
    }

    public void exit() {
        System.out.println("Goodbye!");
        System.exit(0);
    }
}
//[MATIAS] logs adding temporary test case in switch statement (will delete later)[].