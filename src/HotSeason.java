import java.util.Random;

public class HotSeason extends Season {
    @Override public String getName() { return "HOT"; }
    @Override public int getToolSurcharge() { return 1; } // หน้าร้อนทำงานเหนื่อยขึ้น
    @Override public Weather forecastWeather(Random rng) {
        if (rng.nextInt(100) < 15) return Weather.RAINY;
        return Weather.SUNNY; 
    }
}