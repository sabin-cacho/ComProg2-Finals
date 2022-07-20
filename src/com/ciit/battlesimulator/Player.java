package com.ciit.battlesimulator;
import java.util.Random;

public class Player implements IEntity{
    public Player(){

    }

    public void doAction(Monster monster, Random rand, int action){
        //method for calling the players action methods
    }

    public void attackMonster(Monster monster){
        //basic attack
    }
    public void useSpell(Monster monster, Random rand){
        //method for using spells
    }
    public void inflictBlightDamage(Monster monster, Random rand){
        // checks if theres a blight currently inflicted on the player, and inflicts additional damage if there is
    }

    private int calculateSpeedDifference(Monster monster){
        //calculation for which party is faster, and returns the relevant crit damage and speed difference values
        return 0; //the 0 is a placeholder para di magalit si IDE
    }
}
