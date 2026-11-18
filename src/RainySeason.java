import java.util.Random;

public class RainySeason extends Season {
    @Override public String getName() { return "RAINY"; }
    @Override public int getToolSurcharge() { return 0; } 
    @Override public Weather forecastWeather(Random rng) {
        int roll = rng.nextInt(100);
        if (roll < 40) return Weather.STORM; 
        if (roll < 85) return Weather.RAINY; 
        return Weather.SUNNY;                
    }
}