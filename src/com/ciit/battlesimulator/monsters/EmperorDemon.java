package com.ciit.battlesimulator.monsters;
import com.ciit.battlesimulator.*;
import java.util.Random;


public class EmperorDemon extends Monster {
    GUI gui = new GUI();
    public EmperorDemon(){
        this.setName("Emperor Demon");
        this.setHP(50);
        this.setDef(30);
        this.setmaxDef(30);
        this.setAtk(8);
        this.setMRes(40);
        this.setBRes(80);
        this.setSpeed(15);
        this.setcriticalDamage(12);
        this.setblightDamage(0);// Always starts off at 0.
        this.setblightDuration(0);// Always starts off at 0.
        this.setMastery(30);
        this.setIsActionDone(false);
    }

    public void doAction(Player player){
        if (!this.getIsActionDone() && this.getHP() < this.getmaxHP() / 2) {
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
            System.out.println("Emperor Demon Has Possessed The Darkness Smother");
            this.setAtk(this.getAtk()*2);
            this.setcriticalDamage(0);

            int amount = player.getHP();
            player.setHP(amount - this.getAtk());

            int hpAmount = player.getHP();
            player.setHP(hpAmount / 2);

            this.setAtk(this.getAtk()*2);
            this.setcriticalDamage(5);

            try{
                Thread.sleep(1000);
            } catch (InterruptedException e){}
            System.out.printf("> Emperor Demon is Attacking %s With %s Attack and %s Crit Damage\n",player.getName(), this.getAtk(), this.getcriticalDamage());
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

            this.sethasDoneSpecialAttack(true);
        }
        else{
            System.out.printf("> %sEmperor Demon's Darkness Smother Attack Failed%s\n", gui.ANSI_RED, gui.ANSI_RESET);
        }

        this.setIsActionDone(true);
    }
}
//[MATIAS] Logs Created the Emperor Demon.
