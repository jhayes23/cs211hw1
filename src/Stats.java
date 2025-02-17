import java.util.EnumMap;
import java.util.Map;

public class Stats {
    // M3 HOMEWORK ENUM USE
    private final Map<StatType, Integer> stats;
    private int abilityPoints;

    // M3 HOMEWORK ENUM
    public enum StatType {
        STRENGTH("STR", "Determines the physical power, responsible for the amount of damage inflicted on enemies."),
        DEXTERITY("DEX", "Determines the chance of inflicting damage onto enemies"),
        INTELLIGENCE("INT", "Determines the amount of magical power and mana power."),
        LUCK("LUK", "Determines the chance at evading damage and landing critical blows.");
        private String shortCode;
        private String description;

        private StatType(String shortCode, String description) {
            this.shortCode = shortCode;
            this.description = description;
        }

        public String getShortCode() {
            return shortCode;
        }

        public String getDescription() {
            return description;
        }
    }

    public Stats() {
        this(1);
    }

    public Stats(int level) {
        level = Math.max(level, 1);
        stats = new EnumMap<>(StatType.class);
        stats.put(StatType.STRENGTH, 10);
        stats.put(StatType.DEXTERITY, 10);
        stats.put(StatType.INTELLIGENCE, 10);
        stats.put(StatType.LUCK, 10);
        abilityPoints = level * 5;
    }

    public int getAbilityPoints() {
        return abilityPoints;
    }

    public void incrementAbilityPoints(int levelsGained) {
        if (levelsGained > 0) this.abilityPoints += levelsGained * 5;

    }

    public int getStat(StatType statType) {
        return stats.getOrDefault(statType, 0);
    }

    public boolean increaseStat(StatType statType, int byPoints) {
        if (byPoints > abilityPoints) {
            System.out.println("Not enough ability points available!");
            return false;
        }
        stats.put(statType, stats.get(statType) + byPoints);
        return true;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Stats:\n");
        for (Map.Entry<StatType, Integer> entry : stats.entrySet()) {
            stringBuilder.append("   ").append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
        }
        return stringBuilder.toString();
    }
}