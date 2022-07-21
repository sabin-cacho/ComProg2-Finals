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

    public void battleLoop(Monster monster, Player player){
        do {
            System.out.println("Battle Phase: ");
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

//ayon ok na, pero pag sa ibang class okay naman, try mo nalang gawa ng isang useless na class tas don yun titehahahahhah
//gawa ka tite class
// HAHAHHAHA
//g gago
//fuck PE
//tite
//POTAENA, Ayoko na sa PE
//PUTA Siya