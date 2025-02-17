public class Thief extends Player{
    public Thief(String name) {
        super(name, CLASSES.THIEF);
    }

    @Override
    public void attack(Monster monster) {
        System.out.print(getName() + " stabbed the " + monster.getName()+" from behind! ");
        System.out.println("The attack does 30 damage.");
        monster.takeDamage(30);
    }

    public void sneak() {
        System.out.println(getName() + " vanished out of sight!");
    }
}
