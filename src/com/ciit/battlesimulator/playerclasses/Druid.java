package com.ciit.battlesimulator.playerclasses;

import com.ciit.battlesimulator.GUI;
import com.ciit.battlesimulator.Monster;
import com.ciit.battlesimulator.Player;

import java.util.Random;

import static java.lang.String.valueOf;

public class Druid extends Player {
    private Random rand = new Random();
    private GUI gui = new GUI();
    private String name;

    public Druid(){
        this.setName("Druid");
        this.setMRes(15);
    }
    public void useSpell(Monster monster){
        int successChance, blightChance;
        int choice = gui.chooseSpell();
        switch(choice){
            case 1:
                this.setHP(this.getHP() + 8);
                System.out.printf("> You heal yourself for 4 HP and an additional 4 HP, your HP is now %s\n", valueOf(this.getHP()));
                break;
            case 2:
                successChance = rand.nextInt(1, 100);
                if (successChance >= monster.getMRes()) {
                    monster.setDef(monster.getDef() - this.getAtk() + (this.getAtk() * (this.getAtk() / this.getMastery())));
                    System.out.printf("> You cast Shield Splitter, the monster's Def has dropped to %s\n", valueOf(monster.getDef()));
                }
                else if (successChance <= monster.getMRes() && successChance > 5){
                    monster.setDef(monster.getDef() - this.getAtk() / this.getMastery());
                    System.out.printf("> You cast Shield Splitter, but the partially %s resisted your spell. It's defense dropped to %s\n", monster.getName(), monster.getDef());
                }
                else {
                    System.out.printf("> You messed up in casting Shield Splitter, the %s has totally resisted your spell's effects!\n", monster.getName());
                }
                break;
            case 3:
                this.setSpeed(this.getSpeed() + (this.getSpeed() * (this.getMastery() / 100)));
                System.out.printf("> You cast Fleet Footed Spell, your speed increased to %s\n", this.getSpeed());
                break;
            case 4:
                successChance = rand.nextInt(1, 100);
                blightChance = rand.nextInt(1, 100);
                if (successChance >= monster.getMRes()) {
                    if (blightChance >= monster.getBRes()) {
                        monster.setHP(monster.getHP() - 2);
                        monster.setblightDamage(1);
                        monster.setblightDuration(3);
                        System.out.printf("> You cast Fireball and successfully hit the %s. You dealt 2 damage and inflicted Fireblight. The monster's HP is now %s\n", monster.getName(), valueOf(monster.getHP()));
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
                        System.out.printf("> You cast Fireball and the {0} resisted the damage, but still got inflicted with Fireblight\n", monster.getName());
                    }
                    else {
                        System.out.printf("> You cast fireball but the {0} resisted both the damage and blight\n", monster.getName());
                    }
                }
                else {
                    this.setHP(getHP() -1);
                    System.out.printf("> You messed up the casting and hit yourself with the fireball, inflicting 1 damage\n");
                }
                break;
        }
    }
}
