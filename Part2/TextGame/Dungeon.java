package Part2.TextGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Dungeon {
    Player player;
    List<Enemy> enemies;
    List<Item> items;
    List<Item> droppedItems;
    int level;

    public Dungeon(Player player) {
        this.player = player;
        this.enemies = new ArrayList<>();
        this.items = new ArrayList<>();
        this.droppedItems = new ArrayList<>();
        this.level = 1;
        initializeLevel();
    }

    private void initializeLevel() {
        // Clear Previous level
        enemies.clear();
        items.clear();
        player.health=80;

        Random random = new Random();
        for (int i = 0; i < level * 2; i++) {
            enemies.add(new Enemy("Goblin", 30 + level * 10, 5 + level * 2));
        }

        items.add(new Item("Health Potion"));
        items.add(new Item("Sword"));
        items.add(new Item("LongBow"));
    }

    public void displayStatus(){
        System.out.println("\nPlayer Health:"+player.health);
        System.out.println("Player Level:"+player.level);
        System.out.println("Player XP:"+player.currentXP + "/"+player.xpToNextLevel);
        System.out.println("Enemies");
        for (Enemy enemy:enemies){
            System.out.println("- "+enemy.name+"(Health:"+enemy.health +")");
        }
    }

    public void processCommand(String command) {
        switch (command) {
            case "move":
                System.out.println("You move to a new location.");
                break;
            case "attack":
                if (!enemies.isEmpty()) {
                    player.attack(enemies.getFirst());
                    if (enemies.getFirst().health <= 0) {
                        System.out.println("You defeated the " + enemies.getFirst().name + "!");
                        int xp = enemies.getFirst().giveXP();
                        player.gainXP(xp);
                        droppedItems.add(enemies.getFirst().dropItem());
                        enemies.removeFirst();
                        if (enemies.isEmpty()) {
                            System.out.println("All enemies defeated! Here are the dropped items added to your inventory:");
                            for (Item items : droppedItems){
                                System.out.println(items);
                            }
                            for (Item items : droppedItems){
                                player.addItem(items);
                            }
                            levelUp();
                        }
                    } else {
                        enemies.getFirst().attack(player);
                    }
                } else {
                    System.out.println("No enemies left to attack.");
                }
                break;
            case "pickup":
                if (!items.isEmpty()) {
                    player.addItem(items.getFirst());
                    items.removeFirst();
                } else {
                    System.out.println("No items left to pick up.");
                }
                break;
            case "inventory":
                player.showInventory();
                break;
            default:
                System.out.println("Unknown command.");
        }
    }

    public void levelUp() {
        level++;
        System.out.println("Level Up! You are now at dungeon level " + level);
        initializeLevel();
    }
}
