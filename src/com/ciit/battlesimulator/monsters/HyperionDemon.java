package com.ciit.battlesimulator.monsters;
import com.ciit.battlesimulator.*;

import java.util.Random;

public class HyperionDemon extends Monster {
    GUI gui = new GUI();
    public HyperionDemon(){
        this.setName("Hyperion Demon");
        this.setHP(100);
        this.setDef(50);
        this.setmaxDef(50);
        this.setAtk(17);
        this.setMRes(50);
        this.setBRes(50);
        this.setSpeed(20);
        this.setcriticalDamage(20);
        this.setblightDamage(0);// Always starting at zero.
        this.setblightDuration(0);// Always starts at 0
        this.setMastery(30);
        this.setIsActionDone(false);
        this.sethasDoneSpecialAttack(false);
    }

    public void doAction(Player player){
        if (!this.getIsActionDone() && this.getHP() < this.getmaxHP() / 4) {
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

            try{
                Thread.sleep(1000);
            } catch (InterruptedException e){}
            System.out.printf("> Hyperion Demon is Attacking %s With %s Attack and %s Crit Damage\n",player.getName(), this.getAtk(), this.getcriticalDamage());
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e){}
            System.out.printf("Player Health:%s HP\n",player.getHP());
            System.out.printf("Player ATK:%s ATK\n",player.getAtk());
            System.out.printf("Player DEF:%s DEF\n",player.getDef());
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e){}
            if (player.getHP() <= 0){
                System.out.println("YOU DIED:");
                System.out.println("Damage Inflicted: ");

                var dmg = player.getHP() - this.getAtk();
                System.out.printf("%s Attacked %s With %s ATK dealing %s Damage.\n",this.getName(), player.getName(),this.getAtk(),dmg);
            }
            else{
                System.out.println("You Survived.");
                System.out.printf("You Have %s HP Left\n", player.getHP());
            }

            this.sethasDoneSpecialAttack(true);
        }
        else {
            System.out.printf("> %sHyperion Demon's The Might From The Gods Attack Failed%s\n", gui.ANSI_RED, gui.ANSI_RESET);
        }
        this.setIsActionDone(true);
    }
}
//[MATIAS] Logs Created the Hyperion Demon.
//[MATIAS] Logs Hyperion Demon Concept Finished.