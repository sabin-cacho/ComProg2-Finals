package com.ciit.battlesimulator;

public interface IEntity {
    public String getName();
    public int getHP();
    public int getmaxHP();
    public int getDef();
    public int getAtk();
    public int getMRes();
    public int getBRes();
    public int getSpeed();
    public int getcriticalDamage();
    public int getblightDamage();
    public int getblightDuration();
    public int getMastery();
    public boolean getIsActionDone();

    public void setName(String name);
    public void setHP(int HP);
    public void setmaxHP(int maxHP);
    public void setDef(int Def);
    public void setAtk(int Atk);
    public void setMRes(int MRes);
    public void setBRes(int BRes);
    public void setSpeed(int Speed);
    public void setcriticalDamage(int CriticalDamage);
    public void setblightDamage(int BlightDamage);
    public void setblightDuration(int BlightDuration);
    public void setMastery(int Mastery);
    public void setIsActionDone(boolean isActionDone);
}
