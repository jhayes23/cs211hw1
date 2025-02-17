public class Monster {
    private int hp;
    private int power;
    private String name;
    private boolean dead;

    public Monster(String name){
        dead = false;
        hp = 50;
        power = 30;
        this.name = name;
    }

    public void attack(Player player){
        System.out.println(name + " charges into "+ player.getName() + " and does "+ power + " damage!");
        player.takeDmg(power);
    }

    public void takeDamage(int dmgTaken){
        hp -= dmgTaken;
        if(hp <= 0 ) dead = !dead;
    }
    public String getName(){return this.name;}

    public boolean isDead(){return dead;}
    @Override
    public String toString(){ return name + "  HP: " + hp;}
}
