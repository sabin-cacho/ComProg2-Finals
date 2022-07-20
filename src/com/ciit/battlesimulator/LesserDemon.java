package com.ciit.battlesimulator;

public class LesserDemon extends Monster{
    public LesserDemon() {
        this.setName("Lesser Demon");
        this.setHP(10);
        this.setMaxHP(10);
        this.setDef(2);
        this.setAtk(5);
        this.setMRes(0);
        this.setBRes(0);
        this.setSpeed(10);
        this.setcriticalDamage(2);
        this.setblightDamage(0); //always starts off as 0, gets changed by a method
        this.setblightDuration(0); //same here
        this.setMastery(3);
        this.setIsActionDone(false); //always starts off as false
    }
}