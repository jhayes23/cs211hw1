public class Warrior extends Player{
    public Warrior(String name) {
        super(name, "Warrior");
    }

    @Override
    public void attack() {
        System.out.println(getName() + " swings their sword toward the enemy.");
    }

    public void taunt(){
        System.out.println( getName() + " teases enemy monsters!");
    }
}
