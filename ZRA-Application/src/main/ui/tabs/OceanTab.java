package ui.tabs;

import model.biome.Ocean;
import ui.ButtonNames;
import ui.ZRA;

import javax.swing.*;
import java.awt.*;


// Represents an "Ocean" tab within the ZRA application gui
public class OceanTab extends BiomeTab {

    private static final Color OCEAN_COLOR = new Color(18, 66, 89);
    private static final Ocean OCEAN = new Ocean();
    private static final String FILE_NAME = "./data/Ocean Image.jpg";

    // REQUIRES: ZRA controller that holds this tab
    // EFFECTS: constructs an Ocean tab with a given controller, ocean color, "Ocean" biome name,
    // ocean greeting, ocean button name, and an image file name
    public OceanTab(ZRA controller) {
        super(controller, OCEAN_COLOR, "Ocean", getOceanGreeting(), ButtonNames.EXPLORE_OCEAN, FILE_NAME);
    }

    // EFFECTS: creates a greeting for the top of the console
    private static JPanel getOceanGreeting() {
        JPanel oceanPanel = new JPanel(new GridLayout(2, 1));

        JLabel oceanGreeting1 = new JLabel(OCEAN.getIntro().substring(0, 35), JLabel.CENTER);
        oceanGreeting1.setFont(new Font("Pacifico", Font. BOLD, 22));
        oceanGreeting1.setForeground(OCEAN_COLOR);

        JLabel oceanGreeting2 = new JLabel(OCEAN.getIntro().substring(37, 118), JLabel.CENTER);
        oceanGreeting2.setFont(new Font("Pacifico", Font. BOLD, 22));
        oceanGreeting2.setForeground(OCEAN_COLOR);

        oceanPanel.add(oceanGreeting1);
        oceanPanel.add(oceanGreeting2);

        return oceanPanel;
    }

}
