package com.ciit.battlesimulator;
import java.util.Random;

public class Simulator {
    GUI gui = new GUI();
    Monster monster = new Monster();
    Player player = new Player();
    Random rand = new Random();
    int monsterChoice;

    public Simulator(){
        battleLoop(monster, player, rand);
    }

    public void battleLoop(Monster monster, Player player, Random rand){
        do {
            player.doAction(monster, rand, gui.doAction());
            if (player.getIsActionDone()) monster.doAction(player, rand);
            System.out.println(" ");

        }
        while(monster.getHP() > 0 && player.getHP() > 0);
    }
}
//wait iniisip ko pa kung pano gagana yung simulator class
