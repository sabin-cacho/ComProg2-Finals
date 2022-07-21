package com.ciit.battlesimulator.monsters;
import com.ciit.battlesimulator.Monster;
import com.ciit.battlesimulator.Player;

import java.util.Random;

public class HyperionDemon extends Monster {
    public HyperionDemon(){
        this.setName("Hyperion Demon");
        this.setHP(100);
        this.setDef(50);
        this.setmaxDef(50);
        this.setAtk(17);
        this.setMRes(10);
        this.setBRes(10);
        this.setSpeed(20);
        this.setcriticalDamage(20);
        this.setblightDamage(0);// Always starting at zero.
        this.setblightDuration(0);// Always starts at 0
        this.setMastery(30);
        this.setIsActionDone(false);
        this.sethasDoneSpecialAttack(false);
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
        int chance = rand.nextInt(10);

        if (chance % 2 == 0){
            System.out.println("> Hyperion Demon Has Possessed The Might From The Gods");
            int hpAmount = player.getHP();
            player.setHP(hpAmount / 2);

            this.setAtk(this.getAtk()*2);
            this.setcriticalDamage(5);

            int amount = player.getHP();
            player.setHP(amount - this.getAtk());

            this.setAtk(17);
            this.setcriticalDamage(20);

            this.sethasDoneSpecialAttack(true);
        }
        else {
            System.out.println("Hyperion Demon's The Might From The Gods Attack Failed");
        }
        this.sethasDoneSpecialAttack(true);
        this.setIsActionDone(true);
    }
}
//[MATIAS] Logs Created the Hyperion Demon.
//[MATIAS] Logs Hyperion Demon Concept Finished.