package ui.tabs;

import model.ZooForRoboAnimals;
import persistence.JsonReader;
import persistence.JsonWriter;
import ui.ButtonNames;
import ui.ZRA;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;

// Represents a "Welcome" tab within the ZRA application gui
// Inspired by methods in the HomeTab class in the SmartHome application
public class WelcomeTab extends Tab {

    public static final Color WELCOME_COLOR = new Color(80, 80, 80);
    private static final String WELCOME_GREETING_1 = "Hello, time traveler!! \\(^-^)/";
    private static final String WELCOME_GREETING_2 = "Welcome to the ZRA, the world’s first Zoo for Robotic Animals!";

    private JLabel greeting1;
    private JLabel greeting2;
    private static final String JSON_STORE = "./data/myZRA.json";
    private ZooForRoboAnimals zra;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    private JPanel buttonRow;

    // REQUIRES: ZRA controller that holds this tab
    // EFFECTS: constructs a WELCOME tab for console with "Load" and "Save" buttons and a greeting
    public WelcomeTab(ZRA controller) {
        super(controller);
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);

        this.zra = controller.getZra();

        setLayout(new GridLayout(3, 1));

        add(welcomeGreeting());
        add(new JLabel(new ImageIcon("./data/Mini ZRA Splash Screen.jpg")));
        placeLoadButton();
        placeSaveButton();
    }

    // EFFECTS: creates a JPanel for the greeting at the top of the console
    private JPanel welcomeGreeting() {
        JPanel greetingPanel = new JPanel();

        greeting1 = new JLabel(WELCOME_GREETING_1, JLabel.CENTER);
        greeting1.setFont(new Font("Pacifico", Font.BOLD, 28));
        greeting1.setForeground(WELCOME_COLOR);
        greetingPanel.add(greeting1);

        greeting2 = new JLabel(WELCOME_GREETING_2, JLabel.CENTER);
        greeting2.setFont(new Font("Pacifico", Font.BOLD, 28));
        greeting2.setForeground(WELCOME_COLOR);
        greetingPanel.add(greeting2);

        return greetingPanel;
    }

    // MODIFIES: this, ZRA
    // EFFECTS: creates and places Load button that updates application when clicked, displays file loaded successfully
    // message when successful, displays error message otherwise
    private void placeLoadButton() {
        JButton load = new JButton(ButtonNames.LOAD.getName());
        load.setFont(new Font("Pacifico", Font.BOLD, 24));
        load.setForeground(WELCOME_COLOR);
        buttonRow = formatButtonRow(load);
        buttonRow.setSize(WIDTH, HEIGHT / 6);

        load.addActionListener(e -> {
            try {
                ZooForRoboAnimals newZRA = jsonReader.read();
                zra.setRoboAnimals(newZRA.getRoboAnimals());
                greeting1.setText("");
                greeting2.setText("Loaded " + zra.getName() + " from " + JSON_STORE + "!");
            } catch (IOException io) {
                greeting2.setText("Unable to read file: " + JSON_STORE + "!");
            }
        });
        this.add(buttonRow);
    }

    // MODIFIES: this, ZRA
    // EFFECTS: creates and places Save button that updates application when clicked, displays file saved successfully
    // message when successful, displays error message otherwise
    private void placeSaveButton() {
        JButton save = new JButton(ButtonNames.SAVE.getName());
        save.setFont(new Font("Pacifico", Font.BOLD, 24));
        save.setForeground(WELCOME_COLOR);
        buttonRow.add(save);
        buttonRow.setSize(WIDTH, HEIGHT / 6);

        save.addActionListener(e -> {
            try {
                jsonWriter.open();
                jsonWriter.write(zra);
                jsonWriter.close();
                greeting1.setText("");
                greeting2.setText("Saved " + zra.getName() + " to " + JSON_STORE + "!");
            } catch (FileNotFoundException fnf) {
                greeting2.setText("Unable to find file: " + JSON_STORE + "!");
            }
        });
        this.add(buttonRow);
    }

}
