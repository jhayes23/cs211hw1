import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Player user;
        int choice;
        Scanner sc = new Scanner(System.in);
        Player player1 = PlayerFactory.createPlayer("Warrior", "Hero");
        Player player2 = PlayerFactory.createPlayer("Archer", "HawkEye");
        Player player3 = PlayerFactory.createPlayer("Mage", "Olive");
        Player player4 = PlayerFactory.createPlayer("Thief", "Shadow");
        // M3 USING COMPARATOR
        ArrayList<Player> party = new ArrayList<>();
        Collections.addAll(party, player1, player2, player3, player4);
        party.sort(Player.JOB_COMPARATOR);
        System.out.println("Job comparator testing.");
        party.forEach(System.out::println);


        System.out.println("\n\n\n");
        System.out.println("Choose a class by entering a number 1 - 4.");
        System.out.println("Warrior: 1\t Archer: 2\t Mage: 3\t Thief: 4");
        while (true) {
            if (sc.hasNextInt()) {
                choice = sc.nextInt();
                if (choice == 1 || choice == 2 || choice ==3 || choice == 4) break;
            } else {
                sc.next();
            }
            System.out.println("Invalid input. Please enter between 1 and 4.");
        }

        while (true) {
            System.out.print("Please enter a character name:");
            String newPlayerName = sc.next().trim();
            if (Player.players.stream()
                    .noneMatch(player -> player.getName().equals(newPlayerName))) {
                System.out.println("Welcome, " + newPlayerName +"!");
                user = PlayerFactory.createPlayer(Player.CLASSES.values()[choice - 1].toString(), newPlayerName);
                break;
            }
            System.out.println("Name already taken, please choose another.");
        }
        System.out.println("A wild boar spawned from thin air! Prepare for battle!");
        Monster wildBoar = new Monster("Wild Boar");

        while (!user.isDead() && !wildBoar.isDead()) {
            System.out.println(user.battleInfo());
            System.out.println(wildBoar);

            System.out.println("Enter a number:");
            System.out.println("   Attack: 1");
            System.out.println("   Use Potion: 2");

            while (true) {
                if (sc.hasNextInt()) {
                    choice = sc.nextInt();
                    if (choice == 1 || choice == 2) break;
                } else {
                    sc.next();
                }
                System.out.println("Invalid input. Please enter 1 or 2.");
            }

            if (choice == 1) {
                user.attack(wildBoar);
            } else {
                user.drinkHpPotion(25);
            }

            if (!wildBoar.isDead()) {
                wildBoar.attack(user);
            }
        }

        if (!user.isDead()) {
            System.out.println("You defeated the Wild Boar!");
        } else {
            System.out.println("You have died in battle. :(");
        }

}
    }

