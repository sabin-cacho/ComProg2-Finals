package com.ciit.battlesimulator;

import static java.lang.String.valueOf;

public class MainMenu {
    Simulator game = new Simulator();
    GUI gui = new GUI();

    public void displayMenu() {
        String[] options = {"Start", "Credits", "Exit"};
        for (int i = 0; i < options.length; i++){
            System.out.printf("%s - %s\n", valueOf(i+1), options[i]);
        }
        System.out.println();


    }

    public void runSimulator() {
        System.out.println();
        Simulator sim = new Simulator();
    }

    public void showAbout() {
        //shows the about page
    }

    public void exit() {
        //exits the program
    }
}
