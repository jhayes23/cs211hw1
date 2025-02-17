public class Mage extends Player{

    public Mage(String name) {
        super(name, CLASSES.MAGE);
    }

    @Override
    public void attack(Monster monster) {
        System.out.print(getName() + " casts a powerful spell directed at " + monster.getName()+"! ");
        System.out.println("The spell does 30 damage.");
        monster.takeDamage(30);
    }

    public void buff(){
        if(setHealth(getHealth() * 2) && setMana(getMana() * 2)){
            System.out.println(getName() +  " has increased their health and mana substantially!");
        }
    }
}
