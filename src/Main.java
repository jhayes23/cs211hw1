import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {

        //Homework 2 Tests

        // M2 USING FACTORY
        Player player1 = PlayerFactory.createPlayer("Warrior", "Hero");
        Player player2 = PlayerFactory.createPlayer("Archer", "HawkEye");
        Player player3 = PlayerFactory.createPlayer("Mage", "Olive");
        Player player4 = PlayerFactory.createPlayer("Thief", "Shadow");
        Player player5 = PlayerFactory.createPlayer("Warrior", "Grom");
        Player player6 = PlayerFactory.createPlayer("Archer", "Falcon");
        Player player7 = PlayerFactory.createPlayer("Mage", "Eldric");
        Player player8 = PlayerFactory.createPlayer("Thief", "Ghost");

        System.out.println("Testing Leaderboard sorting based only on name: ");
        Player.leaderboard();

        player1.setLevel(10);
        player2.setLevel(10);
        player3.setLevel(13);
        player4.setLevel(12);
        player5.setLevel(16);
        player6.setLevel(9);
        player7.setLevel(11);
        player8.setLevel(12);

        System.out.println("\nTesting Leaderboard sorting based on both level and name: ");
        Player.leaderboard();

//        Homework 1 Tests
//        ArrayList<Player> party = new ArrayList<>();
//        Player player1 = new Warrior("Gabbs");
//        Player player2 = new Archer("HawkEye");
//        Player player3 = new Mage("Olive");
//        Player player4 = new Thief("Shadow");
//        party.forEach( (character) -> {
//            System.out.println(character);
//
//            if(character instanceof Warrior warrior){
//                warrior.taunt();
//            }else if (character instanceof Mage mage) {
//                mage.buff();
//            }
//            else if (character instanceof Thief thief) {
//                thief.sneak();
//            }
//            character.attack();
//            System.out.println();
//        });
    }
}