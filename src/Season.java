import java.util.Random;

public abstract class Season {
    public static final Season HOT = new HotSeason();
    public static final Season RAINY = new RainySeason();
    public static final Season COLD = new ColdSeason();

    public static final Season[] VALUES = { HOT, RAINY, COLD };

    public abstract String getName();

    public abstract int getToolSurcharge();

    public abstract Weather forecastWeather(Random rng);

}