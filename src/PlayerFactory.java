public class PlayerFactory {
    // M2 USING FACTORY
    public static Player createPlayer(String type, String name){
        return switch (type.toLowerCase()) {
            case "warrior" -> new Warrior(name);
            case "archer" -> new Archer(name);
            case "mage" -> new Mage(name);
            case "thief" -> new Thief(name);
            default -> throw new IllegalArgumentException(type + " is an invalid Player type.");
        };
    }
}
