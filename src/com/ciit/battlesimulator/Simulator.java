package com.ciit.battlesimulator;
import java.util.Random;

public class Simulator {
    GUI gui = new GUI();
    Player player = new Player();
    Random rand = new Random();

    public Simulator(){
        battleLoop(spawnMonster(), player);
    }

    public void battleLoop(Monster monster, Player player){
        System.out.println("Battle Phase: ");
        gui.spawnMonster();
        do {
            player.doAction(monster, rand, gui.playerAction());
            if (player.getIsActionDone()) monster.doAction(player);
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

    public Monster spawnMonster(){
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
}