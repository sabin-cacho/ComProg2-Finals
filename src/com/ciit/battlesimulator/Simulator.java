package com.ciit.battlesimulator;
import com.ciit.battlesimulator.monsters.EmperorDemon;
import com.ciit.battlesimulator.monsters.HyperionDemon;
import com.ciit.battlesimulator.monsters.LesserDemon;
import com.ciit.battlesimulator.monsters.SuccubusDemon;
import com.ciit.battlesimulator.playerclasses.Assassin;
import com.ciit.battlesimulator.playerclasses.Druid;
import com.ciit.battlesimulator.playerclasses.Mage;
import com.ciit.battlesimulator.playerclasses.Warrior;

import java.util.Random;

public class Simulator {
    GUI gui = new GUI();
    Player player = new Player();
    Random rand = new Random();

    public Simulator(){
        player = selectClass();
        battleLoop(spawnMonster(), player);
    }

    private void battleLoop(Monster monster, Player player){
        do {
            System.out.println("\nBattle Phase: ");
            System.out.printf("Player  HP: %s  Def: %s ", player.getHP(), player.getDef());
            System.out.printf("\nMonster HP: %s  Def: %s \n", monster.getHP(), monster.getDef());

            player.doAction(monster, rand, gui.playerAction());
            if (monster.getHP() <= 0) break;
            if (player.getIsActionDone()) monster.doAction(player);
            applyBlightDamage(player, monster);
            monster.setIsActionDone(false);

            System.out.println("Press Enter key to continue...");
            try { System.in.read();
            } catch(Exception e) {}
        }
        while(monster.getHP() > 0 && player.getHP() > 0);

        if (monster.getHP() <= 0) {
            System.out.printf("%s%sCongratulations%s\n", GUI.ANSI_GREEN_BG, GUI.ANSI_BLACK, GUI.ANSI_RESET);
            System.out.printf("%s%sYou beat the monster.%s\n", GUI.ANSI_GREEN_BG, GUI.ANSI_BLACK, GUI.ANSI_RESET);
        } else {
            System.out.printf("%s%sYou died.%s\n", GUI.ANSI_RED_BG, GUI.ANSI_BLACK, GUI.ANSI_RESET);
            System.out.printf("%s%sTry again!%s\n", GUI.ANSI_RED_BG, GUI.ANSI_BLACK, GUI.ANSI_RESET);
        }
    }

    private Player selectClass(){
        int option = gui.selectClass();
        switch(option) {
            case 1:
                return new Warrior();
            case 2:
                return new Mage();
            case 3:
                return new Assassin();
            case 4:
                return new Druid();
            default:
                System.out.println("Please enter a valid option.");
                selectClass();
        }
        return null;
    }

    private Monster spawnMonster(){
        int option = gui.spawnMonster();
        switch(option) {
            case 1:
                return new LesserDemon();
            case 2:
                return new SuccubusDemon();
            case 3:
                return new EmperorDemon();
            case 4:
                return new HyperionDemon();
            default:
                System.out.println("Please enter a valid option.");
                spawnMonster();
        }
        return null;
    }
    
    private void applyBlightDamage(Player player, Monster monster){
        if(player.getIsActionDone() && monster.getIsActionDone()) {
            if (monster.getblightDuration() > 0) {
                monster.setHP(monster.getHP() - monster.getblightDamage());
                monster.setblightDuration(monster.getblightDuration() - 1);
                System.out.printf("> %sThe %s took %s Blight Damage%s\n", GUI.ANSI_GREEN, monster.getName(), monster.getblightDamage(), GUI.ANSI_RESET);
            }
            if (player.getblightDuration() > 0) {
                player.setHP(player.getHP() - player.getblightDamage());
                player.setblightDuration(player.getblightDuration() - 1);
            }
        }
    }
}
