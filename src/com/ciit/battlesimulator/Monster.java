package com.ciit.battlesimulator;s
import java.util.Random;

public class Monster {
    public void doAction(Player player, Random rand){
        //where the monsters "AI" will go
        //basically a bunch of if statements that define what the monster will do
        //whether it be attack or heavy attack or whatever
    }

    public void attackPlayer(Player player){
        //basic attack
    }

    public void attackPlayerHeavy(Player player, Random rand){
        //heavy attack, deals additional damage that scales to the monster's current HP and Mastery
    }

    private int calculateSpeedDifference(Player player){
        //calculation for which party is faster, and returns the relevant crit damage and speed difference values
        return 0; //the 0 is a placeholder para di magalit si IDE
    }

    public void inflictBlightDamage(Player player){
        // checks if theres a blight currently inflicted on the player, and inflicts additional damage if there is
    }

    private void setMonster(int option){
        // should have a switch case that spawns a new monster by instantiating its class
    }
}
