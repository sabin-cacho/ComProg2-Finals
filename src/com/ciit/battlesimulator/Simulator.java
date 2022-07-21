package com.ciit.battlesimulator;
import com.ciit.battlesimulator.monsters.EmperorDemon;
import com.ciit.battlesimulator.monsters.HyperionDemon;
import com.ciit.battlesimulator.monsters.LesserDemon;
import com.ciit.battlesimulator.monsters.SuccubusDemon;

import java.util.Random;

public class Simulator {
    GUI gui = new GUI();
    Player player = new Player();
    Random rand = new Random();

    public Simulator(){
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

            System.out.println("Press Enter key to continue...");
            try { System.in.read();
            } catch(Exception e) {}
        }
        while(monster.getHP() > 0 && player.getHP() > 0);

        if (monster.getHP() <= 0) {
            System.out.println("Congratulations");
            System.out.println("You beat the monster.");
        } else {
            System.out.println("You died.");
            System.out.println("Try again!");
        }
    }

    private Monster spawnMonster(){
        int option = gui.spawnMonster();
        switch(option) {
            case 1:
                LesserDemon lesserDemon = new LesserDemon();
                return lesserDemon;
            case 2:
                SuccubusDemon succubusDemon = new SuccubusDemon();
                return succubusDemon;
            case 3:
                EmperorDemon emperorDemon = new EmperorDemon();
                return emperorDemon;
            case 4:
                HyperionDemon hyperionDemon = new HyperionDemon();
                return hyperionDemon;
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
                System.out.printf("> The %s took %s Blight Damage\n", monster.getName(), monster.getblightDamage());
            }
            if (player.getblightDuration() > 0) {
                player.setHP(player.getHP() - player.getblightDamage());
                player.setblightDuration(player.getblightDuration() - 1);
            }
        }
    }
}
