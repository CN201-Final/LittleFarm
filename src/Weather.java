import java.awt.Color;
import java.awt.Graphics2D;

/** Each kind of weather carries its own odds and effects, so adding a STORM means adding one constant. */
public enum Weather {
    SUNNY("Sunny", "A fine sunny day", 15, false),
    RAINY("Rainy", "Rain today - no need to water", 85, true),
    STORM("Storm", "STORM WARNING: Heavy rain and wind!", 40, true);

    private final String label;
    private final String morningText;
    private final int chance;            
    private final boolean watersCrops;

    Weather(String label, String morningText, int chance, boolean watersCrops) {
        this.label = label;
        this.morningText = morningText;
        this.chance = chance;
        this.watersCrops = watersCrops;
    }

    public String getLabel() { return label; }
    public String getMorningText() { return morningText; }
    public boolean watersCrops() { return watersCrops; }
    public int getChance() { return chance; }

    /** A small icon about 20 pixels across, with (x, y) its top-left corner. */
    public void drawIcon(Graphics2D g, int x, int y) {
        switch (this) {
            case SUNNY:
                g.setColor(new Color(255, 210, 60));
                g.fillOval(x + 4, y + 4, 12, 12);
                for (int i = 0; i < 8; i++) {
                    double a = i * Math.PI / 4;
                    g.drawLine(x + 10 + (int) (8 * Math.cos(a)), y + 10 + (int) (8 * Math.sin(a)),
                               x + 10 + (int) (10 * Math.cos(a)), y + 10 + (int) (10 * Math.sin(a)));
                }
                break;
            case RAINY:
                g.setColor(new Color(190, 200, 215));
                g.fillOval(x, y + 4, 12, 10);
                g.fillOval(x + 6, y + 1, 14, 13);
                g.setColor(new Color(110, 170, 255));
                for (int i = 0; i < 3; i++) g.drawLine(x + 4 + i * 6, y + 16, x + 2 + i * 6, y + 20);
                break;
            case STORM:
                g.setColor(new Color(90, 95, 105));
                g.fillOval(x, y + 4, 12, 10);
                g.fillOval(x + 6, y + 1, 14, 13);
                
                g.setColor(new Color(255, 220, 50));
                int[] xPoints = {x + 12, x + 8, x + 13, x + 10}; 
                int[] yPoints = {y + 10, y + 16, y + 15, y + 22};
                g.drawPolyline(xPoints, yPoints, 4);
                
                g.setColor(new Color(80, 120, 200));
                for (int i = 0; i < 4; i++) g.drawLine(x + 2 + i * 5, y + 16, x + 1 + i * 5, y + 22);
                break;
        }
    }
}