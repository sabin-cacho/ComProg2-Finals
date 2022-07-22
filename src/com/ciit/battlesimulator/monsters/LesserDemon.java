package com.ciit.battlesimulator.monsters;

import com.ciit.battlesimulator.GUI;
import com.ciit.battlesimulator.Monster;
import com.ciit.battlesimulator.Player;

import java.util.Random;

public class LesserDemon extends Monster {
    GUI gui = new GUI();
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
        Random rand = new Random();
        int attackChance = rand.nextInt(1, 10);

        if (!this.getIsActionDone() && this.getHP() > this.getmaxHP() / 2) {
            if (attackChance % 2 == 0){
                specialAttack(player);
            }
            else specialAttack(player, 4);
        }
        else{
            super.doAction(player);
        }
    }

    public void specialAttack(Player player){
        int quickAttackDmg = 2;
        player.setHP(player.getHP() - quickAttackDmg);
        System.out.printf("> %sThe %s does a quick attack, it is too fast to dodge. It deals %s damage, leaving you with %s HP%s\n", GUI.ANSI_RED, this.getName(), quickAttackDmg, player.getHP(), GUI.ANSI_RESET);

        this.sethasDoneSpecialAttack(true);
        this.setIsActionDone(true);
    }

    public void specialAttack(Player player, int duration){
        Random rand = new Random();
        int successChance = rand.nextInt(1, 100);

        if (successChance >= player.getBRes()){
            player.setblightDamage(2);
            player.setblightDuration(4);
            System.out.printf("> %sThe %s wounded you and caused Bleed, you will take %s damage for the next %s turns%s\n", GUI.ANSI_RED, this.getName(), player.getblightDamage(), player.getblightDuration(), GUI.ANSI_RESET);
        }
        else {
            System.out.printf("> %sThe %s tried to wound you, but you resisted the blight.%s\n", GUI.ANSI_PURPLE, this.getName(), GUI.ANSI_RESET);
        }

        this.sethasDoneSpecialAttack(true);
        this.setIsActionDone(true);
    }
}