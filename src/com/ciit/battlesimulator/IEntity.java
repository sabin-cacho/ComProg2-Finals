package com.ciit.battlesimulator;

public interface IEntity {
    public String Name = "";
    public int HP = 0;
    public int maxHP = 0;
    public int Def = 0;
    public int Atk = 0;
    public int MRes = 0;
    public int BRes = 0;
    public int Speed = 0;
    public int criticalDamage = 0;
    public int blightDamage = 0;
    public int blightDuration = 0;
    public int Mastery = 0;
    public boolean isActionDone = false;
}
