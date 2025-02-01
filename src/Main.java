import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Player> party = new ArrayList<>();
        Player player1 = new Warrior("Gabbs");
        Player player2 = new Archer("HawkEye");
        Player player3 = new Mage("Olive");
        Player player4 = new Thief("Shadow");

        party.add(player1);
        party.add(player2);
        party.add(player3);
        party.add(player4);

        for(Player character : party){
            System.out.println(character.toString());

            if(character instanceof Warrior warrior){
                warrior.taunt();
            }else if (character instanceof Mage mage) {
                mage.buff();
            }
            else if (character instanceof Thief thief) {
                thief.sneak();
            }
            character.attack();
            System.out.println();
        }

    }
}