package ui.tabs;

import model.RoboAnimal;
import model.ZooForRoboAnimals;
import ui.ButtonNames;
import ui.TimeCreator;
import ui.ZRA;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Represents an abstract biome tab within the ZRA application gui
public abstract class BiomeTab extends Tab {

    protected ZooForRoboAnimals zra;
    protected TimeCreator timeCreator;
    protected JLabel biomeMessage;
    protected JScrollPane biomePane;
    protected JTextArea biomeText;

    // EFFECTS: constructs an abstract biome tab with a given controller, color, biome name, biome greeting,
    // biome button name, and an image file name
    public BiomeTab(ZRA controller, Color color, String biomeName, JPanel biomeGreeting, ButtonNames buttonName,
                    String fileName) {
        super(controller);

        this.zra = controller.getZra();
        this.timeCreator =  new TimeCreator();

        JPanel biomeBlock = new JPanel(new GridLayout(3, 1));
        biomeBlock.setSize(ZRA.WIDTH - (ZRA.WIDTH / 5), ZRA.HEIGHT - (ZRA.HEIGHT / 5));
        biomeMessage = new JLabel("");
        biomeMessage.setFont(new Font("Pacifico", Font. BOLD, 18));
        biomeMessage.setForeground(WelcomeTab.WELCOME_COLOR);

        biomePane = new JScrollPane(new JTextArea(11, 34));
        biomeText = new JTextArea("", 11, 34);
        biomeText.setFont(new Font("Pacifico", Font. BOLD, 20));
        biomeText.setForeground(color);
        biomeText.setVisible(true);

        biomeBlock.add(biomeMessage);
        biomeBlock.add(biomePane);
        biomePane.setViewportView(biomeText);

        add(biomeGreeting);
        add(new JLabel(new ImageIcon(fileName)));
        add(biomeBlock);

        placeRefreshButton(color, biomeName, buttonName);
    }

    // MODIFIES: this
    // EFFECTS: adds a "Refresh Listing" button that prints a list of the current RoboAnimals in the given biome
    private void placeRefreshButton(Color color, String biomeName, ButtonNames buttonName) {
        JButton refreshListing = new JButton(buttonName.getName());
        refreshListing.setFont(new Font("Pacifico", Font. BOLD, 20));
        refreshListing.setForeground(color);
        JPanel buttonRow = formatButtonRow(refreshListing);
        buttonRow.setSize(WIDTH, HEIGHT / 12);

        refreshListing.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String buttonPressed = e.getActionCommand();
                if (buttonPressed.equals(buttonName.getName())) {
                    timeCreator.updateCurrentTime();
                    String message = "Last updated: " + timeCreator.getCurrentTime();
                    biomeMessage.setText(message);
                    biomeText.setText(listRoboAnimalsInBiome(biomeName));
                    biomePane.setViewportView(biomeText);
                }
            }
        });
        this.add(buttonRow);
    }

    // EFFECTS: returns a string consisting of all the RoboAnimals in the given biome
    private String listRoboAnimalsInBiome(String biomeName) {
        String s = "";
        for (RoboAnimal roboAnimal : zra.getRoboAnimalsInBiome(biomeName)) {
            s += roboAnimal.getName() + " \\(^-^)/" + ": \n" + roboAnimal.getName() + " can grow up to "
                        + roboAnimal.getLength() + " cm in length! \n" + roboAnimal.getCoolFact() + "\n\n";
        }
        return s;
    }

}
