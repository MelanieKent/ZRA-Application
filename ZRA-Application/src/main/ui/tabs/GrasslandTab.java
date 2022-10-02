package ui.tabs;

import model.biome.Grassland;
import ui.ButtonNames;
import ui.ZRA;

import javax.swing.*;
import java.awt.*;

// Represents a "Grassland" tab within the ZRA application gui
public class GrasslandTab extends BiomeTab {

    private static final Color GRASSLAND_COLOR = new Color(134, 106, 9);
    private static final Grassland GRASSLAND = new Grassland();
    private static final String FILE_NAME = "./data/Grassland Image.jpg";

    // REQUIRES: ZRA controller that holds this tab
    // EFFECTS: constructs a Grassland tab with a given controller, grassland color, "Grassland" biome name,
    // grassland greeting, grassland button name, and an image file name
    public GrasslandTab(ZRA controller) {
        super(controller, GRASSLAND_COLOR, "Grassland", getGrasslandGreeting(), ButtonNames.EXPLORE_GRASSLAND,
                FILE_NAME);
    }

    // EFFECTS: creates a greeting for the top of the console
    private static JPanel getGrasslandGreeting() {
        JPanel grasslandPanel = new JPanel(new GridLayout(3, 1));

        JLabel grasslandGreeting1 = new JLabel(GRASSLAND.getIntro().substring(0, 43), JLabel.CENTER);
        grasslandGreeting1.setFont(new Font("Pacifico", Font. BOLD, 22));
        grasslandGreeting1.setForeground(GRASSLAND_COLOR);

        JLabel grasslandGreeting2 = new JLabel(GRASSLAND.getIntro().substring(46, 129), JLabel.CENTER);
        grasslandGreeting2.setFont(new Font("Pacifico", Font. BOLD, 22));
        grasslandGreeting2.setForeground(GRASSLAND_COLOR);

        grasslandPanel.add(grasslandGreeting1);
        grasslandPanel.add(grasslandGreeting2);

        return grasslandPanel;
    }

}
