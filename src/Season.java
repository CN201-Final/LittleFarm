public enum Season {
    HOT(0),   
    RAINY(35),   
    COLD(0);     

    private final int stormChance;

    Season(int stormChance) {
        this.stormChance = stormChance;
    }

    public int getStormChance() {
        return stormChance;
    }
}