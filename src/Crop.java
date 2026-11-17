import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Set;

/** Shared crop growth. Each subclass supplies its seasons, prices and produce. */
public abstract class Crop {
    private final Set<Season> growingSeasons;
    private int daysGrown = 0;

    protected Crop(Set<Season> growingSeasons) {
        if (growingSeasons.isEmpty()) {
            throw new IllegalArgumentException("A crop must grow in at least one season");
        }
        this.growingSeasons = Set.copyOf(growingSeasons);
    }

    public boolean canGrowIn(Season season) {
        return growingSeasons.contains(season);
    }

    public abstract String getName();
    public abstract int getDaysToMature();
    public abstract int getSeedPrice();
    public abstract int getSellPrice();

    /** Draws the ripe produce; (cx, cy) is the base of the plant's stem. */
    protected abstract void drawProduce(Graphics2D g, int cx, int cy);

    public void grow() {
        if (!isMature()) daysGrown++;
    }

    public boolean isMature() { return daysGrown >= getDaysToMature(); }
    public int getDaysGrown() { return daysGrown; }

    protected void setDaysGrown(int days) {
        daysGrown = days;
    }

    /** One line for the shop, describing anything special about this crop. */
    public String getNote() {
        return "One harvest, then the plot is free again.";
    }

    /** Called when the crop is picked. @return true if the plant stays in the ground to fruit again */
    public boolean pick() {
        return false;
    }

    /** (x, y) is the top-left corner of the tile. */
    public void draw(Graphics2D g, int x, int y) {
        int cx = x + Farm.TILE / 2, cy = y + 22;
        if (daysGrown == 0) {   // just seeds in the ground
            g.setColor(new Color(235, 220, 160));
            g.fillOval(cx - 6, cy - 2, 4, 4);
            g.fillOval(cx + 2, cy - 1, 4, 4);
            return;
        }
        int leaf = isMature() ? 10 : 4 + 6 * daysGrown / getDaysToMature();
        g.setColor(new Color(60, 150, 60));
        g.drawLine(cx, cy, cx, cy - leaf);
        g.setColor(new Color(80, 180, 70));
        g.fillOval(cx - leaf, cy - leaf, leaf, leaf / 2 + 3);
        g.fillOval(cx, cy - leaf, leaf, leaf / 2 + 3);
        if (isMature()) drawProduce(g, cx, cy);
    }
}
