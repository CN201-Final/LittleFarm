import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

public class TvScreen implements Screen {
    private final GamePanel game;
    private final Screen previous;
    private final GameClock clock;

    public TvScreen(GamePanel game, Screen previous, GameClock clock) {
        this.game = game;
        this.previous = previous;
        this.clock = clock;
    }

    @Override
    public void keyPressed(int code) {
        if (code == KeyEvent.VK_ESCAPE || code == KeyEvent.VK_SPACE || code == KeyEvent.VK_ENTER) {
            game.setScreen(previous);
        }
    }

    @Override
    public void draw(Graphics2D g) {
        previous.draw(g);
        Ui.dim(g, 170);

        int width = 500, height = 300;
        int left = (Ui.WIDTH - width) / 2, top = 100;
        
        Ui.paper(g, left, top, width, height);
        Ui.centered(g, "WEATHER FORECAST", 26, top + 45, Ui.INK);

        String seasonName = clock.getSeason().name();
        Ui.centered(g, "SEASON: " + seasonName, 16, top + 75, new Color(40, 130, 50));
        
        g.setColor(new Color(200, 180, 150));
        g.drawLine(left + 40, top + 95, left + width - 40, top + 95);

        String[] labels = {"TODAY", "TOMORROW", "DAY AFTER"};
        int[] xOffsets = {60, 200, 340};

        for (int i = 0; i < 3; i++) {
            int colX = left + xOffsets[i];
            Weather w = clock.getForecast(i);

            g.setFont(Ui.font(16));
            g.setColor(Ui.WOOD);
            g.drawString(labels[i], colX + 15, top + 110);

            w.drawIcon(g, colX + 35, top + 140); 

            g.setFont(Ui.font(14));
            g.setColor(Ui.INK);
            g.drawString(w.getLabel(), colX + 25, top + 190);
            
            g.setColor(w.getChance() > 30 ? new Color(60, 120, 200) : Ui.WOOD);
            g.drawString("Rain: " + w.getChance() + "%", colX + 10, top + 215);
        }

        Ui.centered(g, "press ESC or SPACE to turn off", 12, top + height - 20, new Color(150, 140, 120));
    }
}