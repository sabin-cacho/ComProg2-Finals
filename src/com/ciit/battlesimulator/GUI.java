package com.ciit.battlesimulator;

import java.sql.SQLOutput;
import java.util.Scanner;

import static java.lang.String.valueOf;

public class GUI {
    public int spawnMonster(){
        int choice = 0;
        Scanner in = new Scanner(System.in);
        System.out.println("Choose a monster to spawn:");
        String[] monsters = {"Lesser Demon", "Akira Demon", "Emperor Demon", "Hyperion Demon"};
        for (int i = 0; i < monsters.length; i++){
            System.out.printf("%s - %s\n", valueOf(i+1), monsters[i]);
        }
        System.out.print("Enter your choice here: ");
        choice = in.nextInt();
        return choice;
    }

    public int selectClass(){
        return 0;
    }

    public int playerAction(){
        int choice = 0;
        Scanner in = new Scanner(System.in);

        System.out.println("What action would you like to take?");
        String[] options = {"Attack the monster", "Use a spell", "Check your stats", "Check the monster's stats"};
        for (int i = 0; i < options.length; i++){
            System.out.printf("%s - %s\n", valueOf(i+1), options[i]);
        }
        System.out.print("Enter your choice here: ");
        choice = in.nextInt();
        return choice;
    }
}
//[MATIAS]Logs Finished Akira Demon Monster (SuccubusDemon.Java)
//[MATIAS]Logs Adding 2 More Monsters to GUI Method.
//[MATIAS]Logs Added Emperor Demon and Hyperion Demon To Monster GUI.
