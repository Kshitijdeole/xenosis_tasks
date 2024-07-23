package Part2.TextGame;

import java.util.Scanner;

public class DungeonCrawlerGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your player name: ");
        String playerName=scanner.nextLine();

        System.out.println("Choose your class ( 1 for Melee, 2 for Ranged):");
        int playerClassChoice = scanner.nextInt();
        scanner.nextLine();

        Player player;
        if(playerClassChoice ==1){
            player = new MeleePlayer(playerName);
        }else {
            player = new RangedPlayer(playerName);
        }

        Dungeon dungeon = new Dungeon(player);

        System.out.println("Welcome to the dungeon, " + playerName + "!");
        System.out.println("Commands: move, attack, pickup, inventory");

        while (player.health > 0) {
            dungeon.displayStatus();
            System.out.print("\nEnter command: ");
            String command = scanner.nextLine();
            dungeon.processCommand(command);

            if (player.health <= 0) {
                System.out.println("Game Over! You have been defeated.");
                break;
            }
        }

        scanner.close();
    }
}
