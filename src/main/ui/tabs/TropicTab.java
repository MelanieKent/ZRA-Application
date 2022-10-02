package ui.tabs;

import model.biome.Tropic;
import ui.ButtonNames;
import ui.ZRA;

import javax.swing.*;
import java.awt.*;

// Represents a "Tropic" tab within the ZRA application gui
public class TropicTab extends BiomeTab {

    private static final Color TROPIC_COLOR = new Color(84, 127, 48);
    private static final Tropic TROPIC = new Tropic();
    private static final String FILE_NAME = "./data/Tropic Image.jpg";

    // REQUIRES: ZRA controller that holds this tab
    // EFFECTS: constructs a Tropic tab with a given controller, tropic color, "Tropic" biome name,
    // tropic greeting, tropic button name, and an image file name
    public TropicTab(ZRA controller) {
        super(controller, TROPIC_COLOR, "Tropic", getTropicGreeting(), ButtonNames.EXPLORE_TROPIC,
                FILE_NAME);
    }

    // EFFECTS: creates a greeting for the top of the console
    private static JPanel getTropicGreeting() {
        JPanel tropicPanel = new JPanel(new GridLayout(3, 1));

        JLabel tropicGreeting1 = new JLabel(TROPIC.getIntro().substring(0, 19), JLabel.CENTER);
        tropicGreeting1.setFont(new Font("Pacifico", Font. BOLD, 22));
        tropicGreeting1.setForeground(TROPIC_COLOR);

        JLabel tropicGreeting2 = new JLabel(TROPIC.getIntro().substring(20, 80), JLabel.CENTER);
        tropicGreeting2.setFont(new Font("Pacifico", Font. BOLD, 22));
        tropicGreeting2.setForeground(TROPIC_COLOR);

        JLabel tropicGreeting3 = new JLabel(TROPIC.getIntro().substring(81, 167), JLabel.CENTER);
        tropicGreeting3.setFont(new Font("Pacifico", Font. BOLD, 22));
        tropicGreeting3.setForeground(TROPIC_COLOR);

        tropicPanel.add(tropicGreeting1);
        tropicPanel.add(tropicGreeting2);
        tropicPanel.add(tropicGreeting3);

        return tropicPanel;
    }

}
