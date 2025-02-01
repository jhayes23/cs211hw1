public class Archer extends Player{
    public Archer(String name) {
        super(name);
        className = "Archer";
    }

    @Override
    public void attack() {
        System.out.println(getName() + " fires flurry of arrows from a distance.");
    }
}
