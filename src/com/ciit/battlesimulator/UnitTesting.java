package com.ciit.battlesimulator;

import com.ciit.battlesimulator.monsters.HyperionDemon;
import com.ciit.battlesimulator.Player;

import javax.swing.text.html.HTMLDocument;
import java.sql.SQLOutput;

public class UnitTesting extends HyperionDemon{


        public static void UnitTest(Monster HyperionDemon){
                Player player = new Player();
                System.out.println("This is For The Hyperion Monster");
                System.out.println("Hyperion Demon Stats:");
                System.out.printf("Health:%s HP\n",HyperionDemon.getHP());
                System.out.printf("Attack:%s ATK\n", HyperionDemon.getAtk());
                System.out.printf("Defense:%s DEF:\n", HyperionDemon.getDef());
                System.out.println("This is the Player Stats:");
                player.setHP(100);
                System.out.printf("Player Health:%s HP\n",player.getHP());
                System.out.printf("Player ATK:%s ATK\n",player.getAtk());
                System.out.printf("Player DEF:%s DEF\n",player.getDef());
                System.out.println("This is the Attack Message: \n");
                System.out.println("Base Stats:");
                HyperionDemon.setAtk(17);
                HyperionDemon.setcriticalDamage(20);
                System.out.printf("> Hyperion Demon is Attacking You With %s Attack and %s Crit Damage\n",HyperionDemon.getAtk(), HyperionDemon.getcriticalDamage());
                System.out.println("Buffed Stats:");
                int hpAmount = player.getHP();
                player.setHP(hpAmount / 2);

                HyperionDemon.setAtk(HyperionDemon.getAtk()*2);
                HyperionDemon.setcriticalDamage(5);

                int amount = player.getHP();
                player.setHP(amount - HyperionDemon.getAtk());

                System.out.printf("> Hyperion Demon is Attacking You With %s Attack and %s Crit Damage\n",HyperionDemon.getAtk(), HyperionDemon.getcriticalDamage());
                System.out.printf("Player Health:%s HP\n",player.getHP());
                System.out.printf("Player ATK:%s ATK\n",player.getAtk());
                System.out.printf("Player DEF:%s DEF\n",player.getDef());

                if (player.getHP() <= 0){
                        System.out.println("YOU DIED:");
                        System.out.println("Damage Inflicted: ");

                        var dmg = player.getHP() - HyperionDemon.getAtk();
                        System.out.printf("%s Attacked %s With %s ATK dealing %s Damage.\n",HyperionDemon.getName(), player.getName(),HyperionDemon.getAtk(),dmg);
                }
                else{
                        System.out.println("You Survived.");
                        System.out.printf("You Have %s HP Left\n", player.getHP());
                }



        }

}
