package com.ciit.battlesimulator;
import java.util.Random;

public class Simulator {
    GUI gui = new GUI();
    Monster monster = new Monster();
    Player player = new Player();
    Random rand = new Random();
    int monsterChoice;

    public Simulator(){


        battleLoop(monster, player);
    }

    public void battleLoop(Monster monster, Player player){
        System.out.println("Battle Phase: ");
        gui.spawnMonster();
        do {
            player.doAction(monster, rand, gui.doAction() + 1);
            if (player.getIsActionDone()) monster.doAction(player);
            System.out.println("Press Enter key to continue...");
            try { System.in.read();
            } catch(Exception e) {}
        }
        while(monster.getHP() > 0 && player.getHP() > 0);


    }
}