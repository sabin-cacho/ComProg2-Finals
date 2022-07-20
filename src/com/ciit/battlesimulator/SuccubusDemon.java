package com.ciit.battlesimulator;
import java.util.Random;


public class SuccubusDemon extends Monster {
    public SuccubusDemon(){
        this.setName("Akira Demon");
        this.setHP(15);
        this.setMaxHP(25);
        this.setDef(15);
        this.setAtk(7);
        this.setMRes(3);
        this.setBRes(5);
        this.setSpeed(12);
        this.setcriticalDamage(10);
        this.setblightDamage(0);// Always starts off from 0.
        this.setblightDuration(0);// Always starts off from 0.
        this.setMastery(3);
        this.setIsActionDone(false);
    }

    public void hyperAttack(Player player){
        Random rand = new Random();
        int chance = rand.nextInt(10);

        if (chance % 2 == 0){
            System.out.println("Akira Demon Has Possessed The Hyper Attack");
            Thread.sleep(3000);
            int amount = player.getHP();
            player.setHP(amount / 2);

        }
        else{
            System.out.println("Akira Demon's Hyper Attack Failed");
        }
    }
}
//[MATIAS] Logs Created The Akira Demon.