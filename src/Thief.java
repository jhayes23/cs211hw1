public class Thief extends Player{
    public Thief(String name) {
        super(name);
        className = "Thief";
    }

    @Override
    public void attack() {
        System.out.println(getName() + " stabbed the enemy from behind.");
    }

    public void sneak() {
        System.out.println(getName() + " vanished out of sight!");
    }
}
