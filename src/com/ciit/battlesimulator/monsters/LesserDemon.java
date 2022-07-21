package com.ciit.battlesimulator.monsters;

import com.ciit.battlesimulator.Monster;
import com.ciit.battlesimulator.Player;

import java.util.Random;

public class LesserDemon extends Monster {
    public LesserDemon() {
        this.setName("Lesser Demon");
        this.setHP(10);
        this.setMaxHP(10);
        this.setDef(2);
        this.setmaxDef(2);
        this.setAtk(5);
        this.setMRes(0);
        this.setBRes(0);
        this.setSpeed(10);
        this.setcriticalDamage(2);
        this.setblightDamage(0); //always starts off as 0, gets changed by a method
        this.setblightDuration(0); //same here
        this.setMastery(30);
        this.setIsActionDone(false); //always starts off as false
    }

    public void doAction(Player player){
        if (!this.getIsActionDone() && this.getHP() > this.getmaxHP() / 2) {
            specialAttack(player);
        }
        else{
            super.doAction(player);
        }
    }

    public void specialAttack(Player player){
        Random rand = new Random();
        int successChance = rand.nextInt(1, 100);
        int blightChance = rand.nextInt(1, 100);

        if (successChance >= player.getBRes()){
            player.setblightDamage(2);
            player.setblightDuration(4);
            System.out.printf("The %s wounded you and caused Bleed, you will take %s damage for the next %s turns\n", this.getName(), player.getblightDamage(), player.getblightDuration());
        }
        else {
            System.out.printf("The %s tried to wound you, but you resisted the blight.\n", this.getName());
        }

        this.setIsActionDone(true);
    }
}