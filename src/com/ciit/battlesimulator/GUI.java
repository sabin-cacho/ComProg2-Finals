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
        String[] options = {"Attack the monster", "Use a spell", "Check the monster's stats", "Check your stats"};
        for (int i = 0; i < options.length; i++){
            System.out.printf("%s - %s\n", valueOf(i+1), options[i]);
        }
        System.out.print("Enter your choice here: ");
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
        System.out.print("Enter your choice here: ");
        choice = in.nextInt();
        return choice;
    }
}
//[MATIAS]Logs Finished Akira Demon Monster (SuccubusDemon.Java)
//[MATIAS]Logs Adding 2 More Monsters to GUI Method.
//[MATIAS]Logs Added Emperor Demon and Hyperion Demon To Monster GUI.
