import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;

public abstract class Player implements Comparable<Player> {
    private final String name;
    private int level;
    private int health;
    private int mana;
    public  enum  CLASSES{WARRIOR , ARCHER , MAGE, THIEF}
    private CLASSES className;
    private Stats charStats;
    private boolean dead;
    public static final ArrayList<Player> players = new ArrayList<>();

    public static final Comparator<Player> JOB_COMPARATOR = new JobComparator();

    private static class JobComparator implements Comparator<Player>{
        @Override
        public int compare(Player p1, Player p2){
            if(p1.className.equals(p2.className)) return p1.compareTo(p2);
            return p1.className.toString().compareTo(p2.className.toString());
        }
    }
    public Player(String name, CLASSES classChosen){
        this.name = name;
        this.level = 1;
        this.className = classChosen;
        health = 55;
        dead = false;
        charStats = new Stats();
        players.add(this);
    }
    public abstract void attack(Monster monster);
    public String getClassName(){return className.toString();}
    public int getLevel(){return this.level;}
    public String getName(){return this.name;}
    public int getHealth(){return this.health;}
    public int getMana(){return this.mana;}

    public boolean setHealth(int number){
        if(number < 0) return false;
        this.health = number;
        return true;
    }

    public boolean takeDmg(int dmgTaken){
        this.health -= dmgTaken;
        if (health <0){
            dead = !dead;
            return true;
        }
        return false;
    }
    public void levelUp(){
        level++;
        this.health += 50;
        this.mana += 100;
        charStats.incrementAbilityPoints(1);
    }

    public boolean setLevel(int number){
        if(number < this.level ) return false;
        int diff = level - number;
        this.level = number;
        this.health += 50 * diff;
        this.mana += 100 * diff;
        charStats.incrementAbilityPoints(diff);
        return true;
    }

    public boolean setMana(int number){
        if(number < 0 )return false;
        this.mana = number;
        return true;
    }
    public boolean isDead(){return dead;}
    public void drinkHpPotion(int recoveryAmt){this.health +=recoveryAmt; }

    // M2 HOMEWORK STATIC
    public static void getLeaderboard(){
        Collections.sort(Player.players);
        Player.players.forEach(System.out::println);
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
    public Stats displayStats(){return this.charStats;}
    public String battleInfo(){ return "Name: " + name + " HP: "+ health;}
}
