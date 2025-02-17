public class Warrior extends Player{
    public Warrior(String name) {
        super(name, CLASSES.WARRIOR);
    }

    @Override
    public void attack(Monster monster) {
        System.out.print(getName() + " swings their sword toward the "+ monster.getName()+"! ");
        System.out.println(" The attack does 30 damage.");
        monster.takeDamage(30);
    }

    public void taunt(){
        System.out.println( getName() + " teases enemy monsters!");
    }
}
