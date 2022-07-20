package com.ciit.battlesimulator;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        char[] ch = null;
        Scanner replay = new Scanner(System.in);

        do {
            MainMenu menu = new MainMenu();
            menu.displayMenu();

            System.out.print("Would you like to play again? (Y/N): ");
            System.out.print(""); //fixes the scanner
            ch = replay.nextLine().toCharArray();
            replay.close();
        } while(Character.toLowerCase(ch[0]) == 'y');

        replay.close();
    }

}
