package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
        Random rand = new Random();


        String[] enemies = {"Skeleton", "zombie", "Warrior", "Assassin"};
        int maxEnemyHealth = 100;
        int enemyAttackDamage = 25;

        int health = 100;
        int playerDamage = 50;
        int numHealthPots = 3;
        int healthPotionHealAmount = 30;
        int healthPotionDropChance = 50; // percentage

        boolean running = true;

        System.out.println("Welcome to the dungeon");

        GAME:
        while (running) {
            System.out.println("-------------------------------------------------------------------------------------");

            int enemyHealth = rand.nextInt(maxEnemyHealth);
            String enemy = enemies[rand.nextInt(enemies.length)];

            System.out.println("\t# " + enemy + " has appeared! #\n");

            while (enemyHealth > 0) {

                System.out.println("\tYour HP " + health);
                System.out.println("\t" + enemy + "'s HP: " + enemyHealth);
                System.out.println("\n\tWhat would you like to do?");
                System.out.println("\t1. Attack");
                System.out.println("\t2. Drink potion");
                System.out.println("\t3. Run!");

                String input = in.nextLine();

                if(input.equals("1")) {
                    int damageDealt = rand.nextInt(playerDamage);
                    int damageTaken = rand.nextInt(enemyAttackDamage);

                    enemyHealth -= damageDealt;
                    health -= damageTaken;

                    System.out.println("\t> You strike the " + enemy + " for " +damageDealt + " damage.");
                    System.out.println("\t> You receive " + damageTaken + " in retaliation! " );
                    if (health < 1) {
                        System.out.println("\t> You died! You're mortal soul is stripped from your corpse!");
                        break;

                    }
                }
                else if(input.equals("2")) {
                    if(numHealthPots > 0) {
                        health += healthPotionHealAmount;
                        numHealthPots --;
                        System.out.println("\tYou drink a health potion, healing yourself for " + healthPotionHealAmount
                         "." + "\n\t> You now have " + health + " HP."
                             + "\n\t> You have " + numHealthPots + " health potions left\n");
                    }
                    else {
                        System.out.println("\t> You have no health potions left! Defeat enemies to get more");
                    }

                }
                else if(input.equals("3")) {

                }
                else {

                }
            }


        }
    }
}
