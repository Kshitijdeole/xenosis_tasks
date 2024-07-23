package Part2.TextGame;

import java.util.ArrayList;
import java.util.List;

public abstract class Player {
    String name;
    int health;
    int attackPower;
    int level;
    int currentXP;
    int xpToNextLevel;
    List<Item> inventory;

    public Player(String name) {
        this.name = name;
        this.level=1;
        this.currentXP=0;
        this.xpToNextLevel=100;
        this.inventory = new ArrayList<>();
    }

    public abstract void attack(Enemy enemy);

    public void addItem(Item item){
        inventory.add(item);
        System.out.println("You picked up a"+item.name+".");
    }

    public void showInventory() {
        System.out.println("Inventory");
        for (Item item : inventory) {
            System.out.println("- " + item.name);
        }
    }
    public void gainXP(int xp){
        this.currentXP+=xp;
        System.out.println("you gained"+xp+"XP");
        if (this.currentXP>=xpToNextLevel){
            levelUP();
        }
    }
    private void levelUP(){
        level++;
        this.attackPower+=5;
        this.health+=10;
        this.currentXP-=xpToNextLevel;
        this.xpToNextLevel+=100;
        System.out.println("you leveled up!! you are now level"+this.level+".");
    }
}
