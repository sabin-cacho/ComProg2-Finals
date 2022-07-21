package com.ciit.battlesimulator;
import java.util.Random;

import static java.lang.String.valueOf;

public class Player implements IEntity{
    private Random rand = new Random();
    private GUI gui = new GUI();
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

    public Player() {
        this.setName("Player 1");
        this.setHP(20);
        this.setDef(5);
        this.setMaxHP(20);
        this.setAtk(5);
        this.setMRes(50);
        this.setBRes(50);
        this.setSpeed(12);
        this.setcriticalDamage(0);
        this.setblightDamage(0);
        this.setblightDuration(0);
        this.setMastery(69);//nice
        this.setIsActionDone(false);
    }

    public void doAction(Monster monster, Random rand, int action){
        switch(action){
            case 1:
                this.attackMonster(monster);
                this.isActionDone = true;
                break;
            case 2:
                this.useSpell(monster);
                this.isActionDone = true;
                break;
            case 3:
                System.out.println("-------------");
                System.out.println("Name: " + monster.getName());
                System.out.println("HP: " + monster.getHP());
                System.out.println("Def: " + monster.getDef());
                System.out.println("Atk: " + monster.getAtk());
                System.out.println("Magic Resistance: " + monster.getMRes());
                System.out.println("Blight Resistance:" + monster.getBRes());
                System.out.println("Speed: " + monster.getSpeed());
                System.out.println("Spell Mastery: " + monster.getMastery());
                System.out.println("-------------");
                this.isActionDone = false;
                break;
            case 4:
                System.out.println("-------------");
                System.out.println("Name: " + this.getName());
                System.out.println("HP: " + this.getHP());
                System.out.println("Def: " + this.getDef());
                System.out.println("Atk: " + this.getAtk());
                System.out.println("Magic Resistance: " + this.getMRes());
                System.out.println("Blight Resistance:" + this.getBRes());
                System.out.println("Speed: " + this.getSpeed());
                System.out.println("Spell Mastery: " + this.getMastery());
                System.out.println("-------------");
                this.isActionDone = false;
                break;
            default:
                System.out.println("Please enter a valid action.");
                this.doAction(monster, rand, gui.playerAction());
                this.isActionDone = false;

        }
    }

    public void attackMonster(Monster monster){
        Random rand = new Random();
        int dodgeChance = calculateDodgeChance(monster);
        int totalDmg = this.Atk + this.criticalDamage;
        int grossDmg = totalDmg - monster.getDef();

        if (rand.nextInt(100) > dodgeChance) {
            if (totalDmg > monster.getDef()) {
                monster.setHP(monster.getHP() - grossDmg);
                if (this.criticalDamage > 0) {
                    System.out.printf("> %sYou were faster than the monster and dealt %s additional damage!%s\n", GUI.ANSI_GREEN, valueOf(this.criticalDamage), GUI.ANSI_RESET);
                }
                System.out.printf("> You successfully hit the %s! You dealt %s damage. The %s's HP is now %s\n", monster.getName(), valueOf(grossDmg), monster.getName(), valueOf(monster.getHP()));
            }
            else {
                System.out.printf("> %sThe monster's defense is too high! You must reduce it\'s defense or use a spell that ignores the monster's defense.%s\n", GUI.ANSI_PURPLE, GUI.ANSI_RESET);
            }
        }
        else {
            System.out.printf("> %sOh no, the monster was too swift and dodged your attack!%s\n", GUI.ANSI_PURPLE, GUI.ANSI_RESET);
        }
    }
    public void useSpell(Monster monster){
        int successChance, blightChance;
        int choice = gui.chooseSpell();
        switch(choice){
            case 1:
                this.setHP(this.getHP() + 4);
                System.out.printf("> %sYou heal yourself for 4 HP, your HP is now %s%s\n", GUI.ANSI_GREEN, valueOf(this.HP), GUI.ANSI_RESET);
                break;
            case 2:
                successChance = rand.nextInt(1, 100);
                if (successChance >= monster.getMRes()) {
                    monster.setDef(monster.getDef() - this.Atk + (this.Atk * (this.Atk / Mastery)));
                    System.out.printf("> %sYou cast Shield Splitter, the monster's Def has dropped to %s%s\n", GUI.ANSI_GREEN, valueOf(monster.getDef()), GUI.ANSI_RESET);
                }
                else if (successChance <= monster.getMRes() && successChance > 5){
                    monster.setDef(monster.getDef() - this.Atk / Mastery);
                    System.out.printf("> %sYou cast Shield Splitter, but the partially %s resisted your spell. It's defense dropped to %s%s\n",GUI.ANSI_GREEN, monster.getName(), monster.getDef(), GUI.ANSI_RESET);
                }
                else {
                System.out.printf("> %sYou messed up in casting Shield Splitter, the %s has totally resisted your spell's effects!%s\n",GUI.ANSI_PURPLE, monster.getName(), GUI.ANSI_RESET);
                }
                break;
            case 3:
                this.Speed += this.Speed * (Mastery / 100);
                System.out.printf("> %sYou cast Fleet Footed Spell, your speed increased to %s%s\n", GUI.ANSI_GREEN, this.Speed, GUI.ANSI_RESET);
                break;
            case 4:
                successChance = rand.nextInt(1, 100);
                blightChance = rand.nextInt(1, 100);
                if (successChance >= monster.getMRes()) {
                    if (blightChance >= monster.getBRes()) {
                        monster.setHP(monster.getHP() - 2);
                        monster.setblightDamage(1);
                        monster.setblightDuration(3);
                        System.out.printf("> %sYou cast Fireball and successfully hit the %s. You dealt 2 damage and inflicted Fireblight. The monster's HP is now %s%s\n", GUI.ANSI_GREEN, monster.getName(), valueOf(monster.getHP()), GUI.ANSI_RESET);
                    }
                    else {
                        monster.setHP(monster.getHP() - 2);
                        System.out.printf("> You cast fireball and dealt 2 damage, but you weren't able to inflict Fireblight. The %s's HP is now %s\n", monster.getName(), monster.getHP());
                    }
                }
                else if (successChance <= monster.getMRes() && successChance > 5) {
                    if (blightChance >= monster.getBRes()) {
                        monster.setblightDamage(1);
                        monster.setblightDuration(3);
                        System.out.printf("> %sYou cast Fireball and the %s resisted the damage, but still got inflicted with Fireblight%s\n", GUI.ANSI_GREEN, monster.getName(), GUI.ANSI_RESET);
                    }
                    else {
                        System.out.printf("> %sYou cast fireball but the %s resisted both the damage and blight%s\n", GUI.ANSI_PURPLE, monster.getName(), GUI.ANSI_RESET);
                    }
                }
                else {
                    this.HP -= 1;
                    System.out.printf("> %sYou messed up the casting and hit yourself with the fireball, inflicting 1 damage%s\n", GUI.ANSI_RED, GUI.ANSI_RESET);
                }
                break;
        }
    }

    private int calculateDodgeChance(Monster monster){
        int speedDifference = monster.getSpeed() - this.Speed;
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

    @Override
    public String getName() {
        return name;
    }
    @Override
    public int getHP() {
        if (HP < 0) return 0;
        else return HP;
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
    public void setblightDamage(int blightDamage) {
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
