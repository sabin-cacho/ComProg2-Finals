package com.ciit.battlesimulator;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        char[] ch = null;
        Scanner replay = new Scanner(System.in);
        MainMenu menu = new MainMenu();
        do {

            menu.displayMenu();

            System.out.print("Would you like to play again? (Y/N): ");

            ch = replay.nextLine().toCharArray();
        } while(Character.toLowerCase(ch[0]) == 'y');

        menu.exit();
        replay.close();
    }

}
