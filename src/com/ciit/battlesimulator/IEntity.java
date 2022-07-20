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

    public void setName();
    public void setHP();
    public void setmaxHP();
    public void setDef();
    public void setAtk();
    public void setMRes();
    public void setBRes();
    public void setSpeed();
    public void setcriticalDamage();
    public void setblightDamage();
    public void setblightDuration();
    public void setMastery();
    public void setIsActionDone();
}
