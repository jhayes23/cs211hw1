public class Archer extends Player{
    public Archer(String name) {
        super(name, CLASSES.ARCHER);
    }

    @Override
    public void attack(Monster monster) {
        System.out.print(getName() + " fires flurry of arrows from a distance at "+ monster.getName()+"! ");
        System.out.println("The attack does 30 damage.");
        monster.takeDamage(30);
    }
}
