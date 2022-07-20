package com.ciit.battlesimulator;
import java.util.Random;
import static java.lang.String.*;
import java.lang.Math;

public class Monster implements IEntity {
    private String name;
    private int HP;
    private int maxHP;
    private int Def;
    private int Atk;
    private int MRes;
    private int BRes;
    private int Speed;
    private int criticalDamage;
    private int blightDamage;
    private int blightDuration;
    private int Mastery;
    private boolean isActionDone;
    private Random rand = new Random();
    private boolean hasDoneSpecialAttack;



    public void doAction(Player player){
        boolean isActionDone = false;
        boolean isBracing = false;

        boolean isLowHP = this.HP > this.maxHP / 2 ? false : true;
        int defBuff = 0;

        if (player.getDef() >= this.Atk && !isLowHP) {
            useMonsterEffect(player, 1);
            isActionDone = true;
        }
        else if (!isActionDone && !isLowHP) {
            attackPlayer(player);
            isActionDone = true;
        }
        else {
            if (!isBracing) {
                defBuff = this.Def * (this.Mastery / 100);
                this.Def += defBuff;

                System.out.printf("The %s is bracing for your next attack! It's DEF has increased by %s", this.name, valueOf(defBuff));
                isBracing = true;
            }
            else {
                this.Def -= defBuff;

                System.out.printf("The %s is no longer bracing. It's DEF is back to %s.", this.name, valueOf(defBuff));
            }
        }
    }

    public void attackPlayer(Player player){
        int dodgeChance = this.calculateDodgeChance(player);
        int totalDmg = this.Atk + this.criticalDamage;
        int grossDmg = totalDmg - player.getDef();

        if (rand.nextInt(1, 101) > dodgeChance) {
            if (totalDmg > player.getDef()) {
                player.setHP(totalDmg - player.getDef());
                System.out.printf("> The {0} attacked you, dealing {1} damage. Your HP is now {2}\n", this.getName(), totalDmg - player.getDef(), player.getHP());
            }
            else {
                System.out.printf("> The {0} tried to attack you!\n", this.getName());
                System.out.println("> Your defense was high enough to block the monster's attack!\n");
            }
        }
    }

    public void specialAttack(Player player, int omegalul){
        //heavy attack, deals additional damage that scales to the monster's current HP and Mastery
    }

    private int calculateDodgeChance(Player player){
        int speedDifference = player.getSpeed() - this.Speed;
        this.criticalDamage = this.Atk + (this.Atk * (Math.abs(speedDifference) / 100));

        if (speedDifference >= 15) {
            this.criticalDamage = 0;
            return 99;
        }
        else if (speedDifference >= 10 && speedDifference < 15) {
            this.criticalDamage = 0;
            return 75;
        }
        else if (speedDifference >= 5 && speedDifference < 10) {
            this.criticalDamage = 0;
            return 50;
        }
        else if (speedDifference > 0 && speedDifference < 5) {
            this.criticalDamage = 0;
            return 25;
        }
        else if (speedDifference == 0) {
            return 0;
        }
        else if (speedDifference < 0 && speedDifference > -5) {
            return -25;
        }
        else if (speedDifference <= -5 && speedDifference > -10) {
            return -50;
        }
        else if (speedDifference <= -10 && speedDifference > -15) {
            return -75;
        }
        else {
            return -99;
        }
    }

    private void useMonsterEffect(Player player, int action) { // basically the monster's version of spells, didnt have enough time to add more
        switch (action){
            case 1:
                int defShred = this.Mastery / player.getDef();
                player.setDef(defShred);
                System.out.printf("> The {0} attacked your armor, reducing your DEF by {1}. Your DEF is now {2}", this.name, valueOf(defShred), player.getDef());
                break;
        }
    }

    public void inflictBlightDamage(Player player){
        // checks if theres a blight currently inflicted on the player, and inflicts additional damage if there is
        if (player.getblightDuration() > 0) {
            player.setHP(player.getHP() - player.getblightDamage());
            player.setblightDuration(player.getblightDuration() - 1);
        }
    }

    @Override
    public String getName() {
        return name;
    }
    @Override
    public int getHP() {
        return HP;
    }
    @Override
    public int getmaxHP() {
        return maxHP;
    }
    @Override
    public int getDef() {
        return Def;
    }
    @Override
    public int getAtk() {
        return Atk;
    }
    @Override
    public int getMRes() {
        return MRes;
    }
    @Override
    public int getBRes() {
        return BRes;
    }
    @Override
    public int getSpeed() {
        return Speed;
    }
    @Override
    public int getcriticalDamage() {
        return criticalDamage;
    }
    @Override
    public int getblightDamage() {
        return blightDamage;
    }
    @Override
    public int getblightDuration() {
        return blightDuration;
    }
    @Override
    public int getMastery() {
        return Mastery;
    }
    @Override
    public boolean getIsActionDone() {
        return isActionDone;
    }
    public boolean gethasDoneSpecialAttack() {
        return hasDoneSpecialAttack;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public void setHP(int HP) {
        this.HP = HP;
    }
    @Override
    public void setMaxHP(int maxHP) {
        this.maxHP = maxHP;
    }
    @Override
    public void setDef(int Def) {
        this.Def = Def;
    }
    @Override
    public void setAtk(int Atk) {
        this.Atk = Atk;
    }
    @Override
    public void setMRes(int MRes) {
        this.MRes = MRes;
    }
    @Override
    public void setBRes(int BRes) {
        this.BRes = BRes;
    }
    @Override
    public void setSpeed(int Speed) {
        this.Speed = Speed;
    }
    @Override
    public void setcriticalDamage(int CriticalDamage) {
        this.criticalDamage = CriticalDamage;
    }
    @Override
    public void setblightDamage(int BlightDamage) {
        this.blightDamage = blightDamage;
    }
    @Override
    public void setblightDuration(int BlightDuration) {
        this.blightDuration = BlightDuration;
    }
    @Override
    public void setMastery(int Mastery) {
        this.Mastery = Mastery;
    }
    @Override
    public void setIsActionDone(boolean isActionDone) {
        this.isActionDone = isActionDone;
    }
    public void sethasDoneSpecialAttack(boolean hasDoneSpecialAttack) {
        this.hasDoneSpecialAttack = hasDoneSpecialAttack;
    }
}
//Logs Purple Derp Is here