import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/** Days run from 06:00 to midnight; the clock moves on ten minutes every two real seconds. */
public class GameClock {
    private static final int DAY_START = 6 * 60;    // in minutes after midnight
    private static final int DAY_END = 24 * 60;
    private static final int DUSK = 18 * 60;
    private static final int TICKS_PER_STEP = 120;
    private static final int MINUTES_PER_STEP = 10;
    private static final int FORECAST_DAYS = 3;

    private int day = 1;
    private int minutes = DAY_START;
    private int ticks = 0;
    private Weather weather = Weather.SUNNY;   // day 1 is always fine
    private Season season = Season.HOT;
    private final List<Weather> forecast = new ArrayList<>();

    public GameClock() {
        initForecast(new Random());
    }

    /** Populates the 3-day upcoming forecast list (days +1, +2, +3). */
    public void initForecast(Random rng) {
        forecast.clear();
        for (int i = 1; i <= FORECAST_DAYS; i++) {
            forecast.add(Weather.forecast(rng, seasonForDay(day + i)));
        }
    }

    /** Helper to determine which season a given day number falls into (changes every 10 days). */
    public static Season seasonForDay(int targetDay) {
        Season[] seasons = Season.values();
        int index = ((targetDay - 1) / 10) % seasons.length;
        return seasons[index];
    }

    public void tick() {
        if (++ticks >= TICKS_PER_STEP) {
            ticks = 0;
            minutes += MINUTES_PER_STEP;
        }
    }

    public boolean isMidnight() { return minutes >= DAY_END; }

    public void nextDay(Random rng) {
        day++;
        minutes = DAY_START;
        ticks = 0;
        season = seasonForDay(day);

        if (forecast.isEmpty()) {
            initForecast(rng);
        }
        // Shift: index 0 becomes today's weather, and day + 3 is added at the end
        weather = forecast.remove(0);
        forecast.add(Weather.forecast(rng, seasonForDay(day + FORECAST_DAYS)));
    }

    public int getDay() { return day; }
    public int getMinutes() { return minutes; }
    public Weather getWeather() { return weather; }
    public void setWeather(Weather weather) { this.weather = weather; }
    public Season getSeason() { return season; }
    public void setSeason(Season season) { this.season = season; }

    /** Index 0 = tomorrow, Index 1 = in 2 days, Index 2 = in 3 days. */
    public List<Weather> getForecast() {
        return Collections.unmodifiableList(forecast);
    }

    public void setForecast(List<Weather> savedForecast) {
        forecast.clear();
        forecast.addAll(savedForecast);
        while (forecast.size() < FORECAST_DAYS) {
            forecast.add(Weather.forecast(new Random(), seasonForDay(day + forecast.size() + 1)));
        }
    }

    public void setDay(int day) {
        if (day < 1) throw new IllegalArgumentException("day must be at least 1, not " + day);
        this.day = day;
        this.season = seasonForDay(day);
    }

    /** How dark the evening is: 0 until 18:00, rising to 160 by 22:00. */
    public int darkness() {
        if (minutes < DUSK) return 0;
        return Math.min(160, (minutes - DUSK) * 160 / (4 * 60));
    }

    public String timeText() {
        return String.format("%02d:%02d", minutes / 60, minutes % 60);
    }
}
