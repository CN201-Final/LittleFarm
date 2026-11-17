import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Set;

public class Turnip extends Crop {
    public Turnip() {
        super(Set.of(Season.HOT, Season.COLD));
    }

    @Override public String getName() { return "Turnip"; }
    @Override public int getDaysToMature() { return 3; }
    @Override public int getSeedPrice() { return 20; }
    @Override public int getSellPrice() { return 60; }

    @Override
    protected void drawProduce(Graphics2D g, int cx, int cy) {
        g.setColor(new Color(245, 240, 235));
        g.fillOval(cx - 7, cy - 4, 14, 11);
        g.setColor(new Color(170, 80, 170));
        g.fillArc(cx - 7, cy - 4, 14, 11, 20, 140);
    }
}
