package com.ciit.battlesimulator;
import java.util.Random;


public class EmperorDemon extends Monster {
    public EmperorDemon(){
        this.setName("Emperor Demon");
        this.setHP(50);
        this.setDef(30);
        this.setAtk(8);
        this.setMRes(5);
        this.setBRes(8);
        this.setSpeed(15);
        this.setcriticalDamage(12);
        this.setblightDamage(0);// Always starts off at 0.
        this.setblightDuration(0);// Always starts off at 0.
        this.setMastery(3);
        this.setIsActionDone(false);
    }

    public void DarknessSmother(Player player){
        Random rand = new Random();
        int chance = rand.nextInt(10);

        if (chance % 2 == 0){
            System.out.println("Emperor Demon Has Possessed The Darkness Smother");
            this.setAtk(this.getAtk()*2);
            this.setcriticalDamage(0);

            int amount = player.getHP();
            player.setHP(amount - this.getAtk());

            this.setAtk(8);
            this.setcriticalDamage(12);

        }
        else{
            System.out.println("Emperor Demon's Darkness Smother Attack Failed");
        }
    }

}

