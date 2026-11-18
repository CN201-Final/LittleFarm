import java.util.Random;

public abstract class Season {
    public static final Season HOT = new HotSeason();
    public static final Season RAINY = new RainySeason();
    public static final Season COLD = new ColdSeason();

    public static final Season[] VALUES = { HOT, RAINY, COLD };

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Season other))
            return false;
        return this.getName().equals(other.getName());
    }

    @Override
    public int hashCode() {
        return getName().hashCode();
    }

    public abstract String getName();

    public abstract int getToolSurcharge();

    public abstract Weather forecastWeather(Random rng);

}