/** The starter game runs through three ten-day seasons. */
public enum Season {
    HOT, RAINY, COLD;

    private static final int DAYS_PER_SEASON = 10;

    public static Season fromDay(int day) {
        if (day < 1) throw new IllegalArgumentException("day must be at least 1");
        if (day <= DAYS_PER_SEASON) return HOT;
        if (day <= 2 * DAYS_PER_SEASON) return RAINY;
        return COLD;
    }
}
