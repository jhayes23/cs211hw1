public class Mage extends Player{

    public Mage(String name) {
        super(name);
        className = "Mage";
    }

    @Override
    public void attack() {
        System.out.println(getName() + " casts a powerful spell with their staff.");
    }

    public void buff(){
        if(setHealth(getHealth() * 2) && setMana(getMana() * 2)){
            System.out.println(getName() +  " has increased their health and mana substantially!");
        }
    }
}
