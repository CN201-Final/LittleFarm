/** The selected seeds cannot be planted in the current season. */
public class WrongSeasonException extends FarmException {
    private final String cropName;
    private final Season season;

    public WrongSeasonException(String cropName, Season season) {
        super("Cannot plant " + cropName + " during " + season.getName());
        this.cropName = cropName;
        this.season = season;
    }

    public String getCropName() {
        return cropName;
    }

    public Season getSeason() {
        return season;
    }
}
