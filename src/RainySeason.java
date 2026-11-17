import java.util.Random;

public class RainySeason extends Season {
    @Override public String getName() { return "RAINY"; }
    @Override public int getToolSurcharge() { return 0; } // ไม่เสียพลังงานเพิ่ม
    @Override public Weather forecastWeather(Random rng) {
        int roll = rng.nextInt(100);
        if (roll < 35) return Weather.STORM; 
        if (roll < 85) return Weather.RAINY; 
        return Weather.SUNNY;                
    }
}