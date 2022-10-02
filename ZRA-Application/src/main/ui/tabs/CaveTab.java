package ui.tabs;

import model.biome.Cave;
import ui.ButtonNames;
import ui.ZRA;

import javax.swing.*;
import java.awt.*;


// Represents a "Cave" tab within the ZRA application gui
// Inspired by methods in the ReportTab class in the SmartHome application
public class CaveTab extends BiomeTab {

    private static final Color CAVE_COLOR = new Color(112, 58, 20);
    private static final Cave CAVE = new Cave();
    private static final String FILE_NAME = "./data/Cave Image.jpg";

    // REQUIRES: ZRA controller that holds this tab
    // EFFECTS: constructs a Cave tab with a given controller, cave color, "Cave" biome name,
    // cave greeting, cave button name, and an image file name
    public CaveTab(ZRA controller) {
        super(controller, CAVE_COLOR, "Cave", getCaveGreeting(), ButtonNames.EXPLORE_CAVE, FILE_NAME);
    }

    // EFFECTS: creates a greeting for the top of the console
    private static JPanel getCaveGreeting() {
        JPanel cavePanel = new JPanel();
        JLabel caveGreeting = new JLabel(CAVE.getIntro(), JLabel.CENTER);
        caveGreeting.setFont(new Font("Pacifico", Font. BOLD, 24));
        caveGreeting.setForeground(CAVE_COLOR);

        cavePanel.add(caveGreeting);

        return cavePanel;
    }

}
