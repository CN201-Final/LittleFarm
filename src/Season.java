public enum Season {
    HOT("Hot", "The heat drains your energy as you work."),
    RAINY("Rainy", "A storm threatens to ruin your crops."),
    COLD("Cold", "It's freezing! Good thing strawberries love the cold.");

    private final String label;
    private final String description;

    Season(String label, String description) {
        this.label = label;
        this.description = description;
    }

    public String getLabel() {
        return label;
    }

    public String getDescription() {
        return  description;
    }

    public int getStormChance() {
        return this == RAINY ? 50 : 10;
    }
}
