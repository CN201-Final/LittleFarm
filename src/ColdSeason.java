import java.util.Random;

public class ColdSeason extends Season {
    @Override public String getName() { return "COLD"; }
    @Override public int getToolSurcharge() { return 0; } // ไม่เสียพลังงานเพิ่ม
    @Override public Weather forecastWeather(Random rng) {
        if (rng.nextInt(100) < 30) return Weather.RAINY;
        return Weather.SUNNY; 
    }
}