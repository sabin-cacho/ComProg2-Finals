package com.ciit.battlesimulator;

import java.sql.SQLOutput;
import java.util.Scanner;

import static java.lang.String.valueOf;

public class GUI {
    //ansi escape codes for changing text color
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    //ansi escape codes for changing bg color
    public static final String ANSI_BLACK_BG = "\u001B[40m";
    public static final String ANSI_RED_BG = "\u001B[41m";
    public static final String ANSI_GREEN_BG = "\u001B[42m";
    public static final String ANSI_YELLOW_BG = "\u001B[43m";
    public static final String ANSI_BLUE_BG = "\u001B[44m";
    public static final String ANSI_PURPLE_BG = "\u001B[45m";
    public static final String ANSI_CYAN_BG = "\u001B[46m";
    public static final String ANSI_WHITE_BG = "\u001B[47m";
    public int spawnMonster(){
        int choice = 0;
        Scanner in = new Scanner(System.in);
        System.out.println("Choose a monster to spawn:");
        String[] monsters = {"Lesser Demon", "Akira Demon", "Emperor Demon", "Hyperion Demon"};
        for (int i = 0; i < monsters.length; i++){
            System.out.printf("%s - %s\n", valueOf(i+1), monsters[i]);
        }
        System.out.printf("%s%sEnter your choice here: %s", ANSI_WHITE_BG, ANSI_BLACK, ANSI_RESET);
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
        String[] options = {"Attack the monster", "Use a spell", "Check the monster's stats", "Check your stats"};
        for (int i = 0; i < options.length; i++){
            System.out.printf("%s - %s\n", valueOf(i+1), options[i]);
        }
        System.out.printf("%s%sEnter your choice here: %s", ANSI_WHITE_BG, ANSI_BLACK, ANSI_RESET);
        choice = in.nextInt();
        return choice;
    }

    public int chooseSpell(){
        int choice = 0;
        Scanner in = new Scanner(System.in);
        System.out.println("Choose a spell to cast:");
        String[] spells = {"Healing Spell", "Shield Splitter", "Fleetfooted Spell", "Fireball"};
        String[] spellDesc = {"Heals 4 HP.", "Reduces enemy's DEF.", "Increases your speed.", "Cast a fireball that ignores the enemy's DEF, deals 2 damage, and has a chance to inflict Fireblight."};
        for (int i = 0; i < spells.length; i++){
            System.out.printf("%s - %s: %s\n", valueOf(i+1), spells[i], spellDesc[i]);
        }
        System.out.printf("%s%sEnter your choice here: %s", ANSI_WHITE_BG, ANSI_BLACK, ANSI_RESET);
        choice = in.nextInt();
        return choice;
    }
}
//[MATIAS]Logs Finished Akira Demon Monster (SuccubusDemon.Java)
//[MATIAS]Logs Adding 2 More Monsters to GUI Method.
//[MATIAS]Logs Added Emperor Demon and Hyperion Demon To Monster GUI.

