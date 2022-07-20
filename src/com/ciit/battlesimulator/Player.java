package com.ciit.battlesimulator;
import java.util.Random;

import static java.lang.String.valueOf;

public class Player implements IEntity{
    private Random rand;
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

    public void doAction(Monster monster, Random rand, int action){
        switch(action){
            case 1: attackMonster(monster);
            break;
        }
    }

    public void attackMonster(Monster monster){
        int dodgeChance = calculateDodgeChance(monster);
        int totalDamage = this.Atk + this.criticalDamage;
        int grossDmg = totalDamage - monster.getDef();

        if (rand.nextInt(100) > dodgeChance) {
            if (totalDamage > monster.getDef()) {
                monster.setHP(totalDamage - monster.getDef());
                if (this.criticalDamage > 0) {
                    System.out.printf("> You were faster than the monster and dealt %s additional damage!", valueOf(this.criticalDamage));
                }
                System.out.printf("> You successfully hit the %s! You dealt %s damage. The %s's HP is now %s", monster.getName(), valueOf(grossDmg), monster.getName(), valueOf(monster.getHP()));
            }
            else {
                System.out.print("> The monster's defense is too high! You must reduce it\'s defense or use a spell that ignores the monster's defense.");
            }
        }
        else {
            System.out.println("> Oh no, the monster was too swift and dodged your attack!");
        }
    }
    public void useSpell(Monster monster, Random rand){
        //method for using spells
    }
    public void inflictBlightDamage(Monster monster, Random rand){
        // checks if theres a blight currently inflicted on the player, and inflicts additional damage if there is
    }

    private int calculateDodgeChance(Monster monster){
        //calculation for which party is faster, and returns the relevant crit damage and speed difference values
        return 0; //the 0 is a placeholder para di magalit si IDE
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
}
