package ui.tabs;

import model.ZooForRoboAnimals;
import ui.ButtonNames;
import ui.TimeCreator;
import ui.ZRA;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Represents a "Discover" tab within the ZRA application gui
// Inspired by methods in the ReportTab class in the SmartHome application
public class DiscoverTab extends Tab {

    private static final Color DISCOVER_COLOR = WelcomeTab.WELCOME_COLOR;
    private static final String DISCOVER_GREETING_1 = "We have a large variety of robo-animals here at the ZRA! "
            + "\\(^-^)/";
    private static final String DISCOVER_GREETING_2 = "Their names and preferred biomes can be found below! ";

    private JScrollPane discoverPane;
    private JTextArea discoverText;
    private JLabel discoverMessage;
    private JLabel firstDiscoverGreeting;
    private JLabel secondDiscoverGreeting;
    private ZooForRoboAnimals zra;
    private TimeCreator timeCreator;

    // REQUIRES: ZRA controller that holds this tab
    // EFFECTS: creates a DISCOVER tab with greeting and a list of RoboAnimals and their respective biomes
    public DiscoverTab(ZRA controller) {
        super(controller);

        this.zra = controller.getZra();
        this.timeCreator = new TimeCreator();

        placeGreeting();

        JPanel discoverBlock = new JPanel(new GridLayout(2, 1));
        discoverBlock.setSize(ZRA.WIDTH - (ZRA.WIDTH / 5), ZRA.HEIGHT - (ZRA.HEIGHT / 5));
        discoverMessage = new JLabel("");
        discoverMessage.setFont(new Font("Pacifico", Font. BOLD, 18));
        discoverMessage.setForeground(DISCOVER_COLOR);

        discoverPane = new JScrollPane(new JTextArea(15, 28));
        discoverText = new JTextArea("", 15, 28);
        discoverText.setFont(new Font("Pacifico", Font. BOLD, 20));
        discoverText.setForeground(DISCOVER_COLOR);
        discoverText.setVisible(true);

        discoverBlock.add(discoverMessage);
        discoverBlock.add(discoverPane);
        discoverPane.setViewportView(discoverText);

        add(discoverBlock);

        placeRefreshListingButton();
    }

    // MODIFIES: this
    // EFFECTS: creates and places greeting at top of console
    private void placeGreeting() {
        firstDiscoverGreeting = new JLabel(DISCOVER_GREETING_1, JLabel.CENTER);
        firstDiscoverGreeting.setSize(WIDTH, HEIGHT / 8);
        firstDiscoverGreeting.setFont(new Font("Pacifico", Font. BOLD, 24));
        firstDiscoverGreeting.setForeground(DISCOVER_COLOR);

        secondDiscoverGreeting = new JLabel(DISCOVER_GREETING_2, JLabel.CENTER);
        secondDiscoverGreeting.setSize(WIDTH, HEIGHT / 8);
        secondDiscoverGreeting.setFont(new Font("Pacifico", Font. BOLD, 24));
        secondDiscoverGreeting.setForeground(DISCOVER_COLOR);

        this.add(firstDiscoverGreeting);
        this.add(secondDiscoverGreeting);
    }

    // MODIFIES: this
    // EFFECTS: adds a "Refresh Listing" button that prints current RoboAnimals and their respective biomes in the ZRA
    private void placeRefreshListingButton() {
        JButton refreshListing = new JButton(ButtonNames.REFRESH_LISTING.getName());
        refreshListing.setFont(new Font("Pacifico", Font. BOLD, 20));
        refreshListing.setForeground(DISCOVER_COLOR);
        JPanel buttonRow = formatButtonRow(refreshListing);
        buttonRow.setSize(WIDTH, HEIGHT / 12);

        refreshListing.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String buttonPressed = e.getActionCommand();
                if (buttonPressed.equals(ButtonNames.REFRESH_LISTING.getName())) {
                    timeCreator.updateCurrentTime();
                    String message = "Last updated: " + timeCreator.getCurrentTime();
                    discoverMessage.setText(message);
                    discoverText.setText(listRoboAnimalsInZRA());
                    discoverPane.setViewportView(discoverText);
                }
            }
        });
        this.add(buttonRow);
    }

    // EFFECTS: returns a string consisting of all the RoboAnimals and their respective biomes in the ZRA
    private String listRoboAnimalsInZRA() {
        String s = "";
        for (String roboAnimalAndBiome : zra.getRoboAnimalsAndBiomes()) {
            s += roboAnimalAndBiome + "\n";
        }
        return s;
    }

}
