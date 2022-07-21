package com.ciit.battlesimulator.playerclasses;

import com.ciit.battlesimulator.Player;

public class Assassin extends Player {
    public Assassin(){
        this.setName("Assassin");
        this.setSpeed(this.getSpeed()+10);
    }
}
