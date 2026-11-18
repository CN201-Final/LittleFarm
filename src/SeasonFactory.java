public class SeasonFactory {
    public static Season create(String word) {
        if (word == null) {
            throw new IllegalArgumentException("Season cannot be null. (hot, rainy, cold)");
        }
        return switch (word.toLowerCase()) {
            case "hot"   -> new HotSeason();
            case "rainy" -> new RainySeason();
            case "cold"  -> new ColdSeason();
            default      -> throw new IllegalArgumentException(
                "Unknown season: '" + word + "'."
            );
        };
    }
}