import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        String startingWord = (args.length > 0) ? args[0] : "hot";
        Season startingSeason = SeasonFactory.create(startingWord);
        // Swing is single-threaded: build the window on its event thread
        SwingUtilities.invokeLater(() -> {
            GamePanel panel = new GamePanel(startingSeason);
            JFrame frame = new JFrame("Little Farm - CN201");
            frame.add(panel);
            frame.pack();
            frame.setResizable(true);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
            panel.requestFocusInWindow();
            panel.start();
        });
    }
}
