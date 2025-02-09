import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public abstract class Player implements Comparable<Player> {
    private final String name;
    private int health;
    private int mana;
    private int level;
    private final String className;
    private static ArrayList<Player> players = new ArrayList<>(); // M2 HOMEWORK STATIC

    public Player(String name, String className){
        this.name = name;
        this.health = 100;
        this.mana = 100;
        this.level = 1;
        this.className = className;
        players.add(this);
    }
    public abstract void attack();

    public String getClassName(){return className;}
    public int getHealth(){return this.health;}
    public int getLevel(){return this.level;}
    public String getName(){return this.name;}
    public int getMana(){return this.mana;}

    public boolean setHealth(int number){
        if(number < 0) return false;
        this.health = number;
        return true;
    }

    public boolean setLevel(int number){
        if(number < 1) return false;
        this.level = number;
        return true;
    }

    public boolean setMana(int number){
        if(number < 0 )return false;
        this.mana = number;
        return true;
    }

    // M2 HOMEWORK STATIC
    public static void leaderboard(){
        Collections.sort(players);
        players.forEach(System.out::println);
    }
    @Override
    public int compareTo(Player otherPlayer){
        if(otherPlayer == null || this.level > otherPlayer.level) return -1;
        return this.level < otherPlayer.level ? 1 : name.compareTo(otherPlayer.name);
    }

    @Override
    public boolean equals(Object otherObject){
        if(this == otherObject) return true;
        if (otherObject instanceof Player other){
            return Objects.equals(this.name, other.name)
                    && this.level == other.level
                    && Objects.equals(this.className, other.className);
        }
        return false;
    }

    @Override
    public String toString(){
        return "Name: "+ this.name + " Level:" + this.level + " Class:" + className;
    }

}
