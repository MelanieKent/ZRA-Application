package ui.tabs;

import model.RoboAnimal;
import model.ZooForRoboAnimals;
import ui.ButtonNames;
import ui.ZRA;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.text.html.HTMLDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Represents a "Donate" tab within the ZRA application gui
// Inspired by methods in the SettingsTab class in the SmartHome application
public class DonateTab extends Tab {

    private static final Color DONATE_COLOR = WelcomeTab.WELCOME_COLOR;
    private static final String BEEP_BOOP_GREETING = "Beep boop! \\(^-^)/";
    private static final String DONATE_TEXT = "Follow the directions below to donate a robotic animal of your own!";
    private static final String ERROR_MESSAGE = "Sorry, an error occurred during your donation! Please try again!";
    private static final String SPACER = " ";

    private static final int COLS_IN_ROW = 4;
    private static final int ROW_HEIGHT = 100;
    private static final int NUMBER_OF_TICKS = 2;
    private static final int LEFT_PADDING = 70;
    private static final int BOTTOM_PADDING = 5;
    private static final int TOP = SwingConstants.TOP;
    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 10000;

    private ZooForRoboAnimals zra;
    private String userName;
    private String userBiome;
    private int userlength;
    private String userFact;
    private Border border;
    private GridLayout rowLayout;
    private JLabel initialGreeting;
    private JLabel donateMessage;
    private JTextField nameTextField;
    private JTextField coolFactTextField;
    private JSlider lengthSlider;

    // REQUIRES: ZRA controller that holds this tab
    // EFFECTS: constructs a DONATE tab for console with a greeting, text field for entering a name,
    // buttons for biome selection, slider for length, a text field for entering a cool fact, and a "Submit" and
    // "Reset" button
    public DonateTab(ZRA controller) {
        super(controller);

        this.zra = controller.getZra();

        border = BorderFactory.createEmptyBorder(0, LEFT_PADDING, BOTTOM_PADDING, 0);
        rowLayout = new GridLayout(1, COLS_IN_ROW);

        initialGreeting = new JLabel(BEEP_BOOP_GREETING);
        initialGreeting.setFont(new Font("Pacifico", Font.BOLD, 28));
        initialGreeting.setForeground(DONATE_COLOR);
        add(initialGreeting);

        donateMessage = new JLabel(DONATE_TEXT);
        donateMessage.setFont(new Font("Pacifico", Font.BOLD, 26));
        donateMessage.setForeground(DONATE_COLOR);
        add(donateMessage);

        JPanel headerRow = new JPanel(rowLayout);
        headerRow.setPreferredSize(new Dimension(ZRA.WIDTH - LEFT_PADDING, ROW_HEIGHT));

        add(nameSetUp());
        add(biomeSetUp());
        add(lengthSetUp());
        add(coolFactSetUp());
        add(createSubmissionButton());
        add(createResetButton());
    }

    // EFFECTS: returns a JPanel with instructions to enter a name, a text box for name submission and an empty spacer
    public JPanel nameSetUp() {
        JPanel row = new JPanel(rowLayout);
        row.setPreferredSize(new Dimension(ZRA.WIDTH, ROW_HEIGHT));
        row.setBorder(border);

        JLabel name = new JLabel("Name:");
        name.setFont(new Font("Pacifico", Font.BOLD, 18));
        name.setForeground(DONATE_COLOR);
        name.setVerticalAlignment(TOP);

        JLabel spacer = new JLabel(SPACER);

        row.add(name);
        row.add(makeNameSubmissionTextBox());
        row.add(spacer);

        return row;
    }

    // EFFECTS: returns a JPanel with instructions to select a biome, check boxes to select a biome,
    // and an empty spacer
    public JPanel biomeSetUp() {
        JPanel row = new JPanel(rowLayout);
        row.setPreferredSize(new Dimension(ZRA.WIDTH, ROW_HEIGHT));
        row.setBorder(border);

        JLabel name = new JLabel("Biome:");
        name.setVerticalAlignment(TOP);
        name.setFont(new Font("Pacifico", Font.BOLD, 18));
        name.setForeground(DONATE_COLOR);

        JLabel spacer = new JLabel(SPACER);

        row.add(name);
        row.add(makeBiomeSubmissionCheckBoxes());
        row.add(spacer);
        return row;
    }

    // EFFECTS: returns a JPanel with instructions to choose a length, a slider for selecting the length,
    // and an empty spacer
    public JPanel lengthSetUp() {
        JPanel row = new JPanel(rowLayout);
        row.setPreferredSize(new Dimension(ZRA.WIDTH, ROW_HEIGHT));
        row.setBorder(border);

        JLabel name = new JLabel("Length (in cm):");
        name.setVerticalAlignment(TOP);
        name.setFont(new Font("Pacifico", Font.BOLD, 18));
        name.setForeground(DONATE_COLOR);

        JLabel spacer = new JLabel(SPACER);

        row.add(name);
        row.add(makeLengthSubmissionSlider());
        row.add(spacer);

        return row;
    }

    // EFFECTS: returns a JPanel with instructions to enter a cool fact, a text box for cool fact submission,
    // and an empty spacer
    public JPanel coolFactSetUp() {
        JPanel row = new JPanel(rowLayout);
        row.setPreferredSize(new Dimension(ZRA.WIDTH, ROW_HEIGHT));
        row.setBorder(border);

        JLabel name = new JLabel("Cool fact (one sentence):");
        name.setVerticalAlignment(TOP);
        name.setFont(new Font("Pacifico", Font.BOLD, 20));
        name.setForeground(DONATE_COLOR);

        JLabel spacer = new JLabel(SPACER);

        row.add(name);
        row.add(makeCoolFactSubmissionTextBox());
        row.add(spacer);

        return row;
    }

    // EFFECTS: returns a JPanel with a JTextField submission box for the name of the user's RoboAnimal
    public JPanel makeNameSubmissionTextBox() {
        JPanel nameSubmissionBlock = new JPanel(new GridLayout(2, 1));

        nameTextField = new JTextField(new HTMLDocument(), "", 1);
        nameTextField.setFont(new Font("Pacifico", Font.BOLD, 20));
        nameTextField.setForeground(DONATE_COLOR);

        nameSubmissionBlock.add(nameTextField);

        return nameSubmissionBlock;
    }

    // EFFECTS: returns a JPanel with check boxes that the user can use to select a biome for their RoboAnimal
    public JPanel makeBiomeSubmissionCheckBoxes() {
        JRadioButton caveButton = new JRadioButton(ButtonNames.CAVE.getName());
        caveButton.setForeground(DONATE_COLOR);
        JRadioButton grasslandButton = new JRadioButton(ButtonNames.GRASSLAND.getName());
        grasslandButton.setForeground(DONATE_COLOR);
        JRadioButton oceanButton = new JRadioButton(ButtonNames.OCEAN.getName());
        oceanButton.setForeground(DONATE_COLOR);
        JRadioButton tropicButton = new JRadioButton(ButtonNames.TROPIC.getName());
        tropicButton.setForeground(DONATE_COLOR);

        ButtonGroup buttons = new ButtonGroup();

        buttons.add(caveButton);
        buttons.add(grasslandButton);
        buttons.add(oceanButton);
        buttons.add(tropicButton);

        caveButton.addActionListener(new BiomeListener("Cave"));
        grasslandButton.addActionListener(new BiomeListener("Grassland"));
        oceanButton.addActionListener(new BiomeListener("Ocean"));
        tropicButton.addActionListener(new BiomeListener("Tropic"));

        JPanel biomeButtons = new JPanel();
        biomeButtons.add(caveButton);
        biomeButtons.add(grasslandButton);
        biomeButtons.add(oceanButton);
        biomeButtons.add(tropicButton);

        return biomeButtons;
    }

    // EFFECTS: returns a JPanel with a JSlider to be used to select the length of the user's RoboAnimal
    public JSlider makeLengthSubmissionSlider() {
        lengthSlider = new JSlider(MIN_LENGTH, MAX_LENGTH, MAX_LENGTH / 2);
        lengthSlider.setMajorTickSpacing(Math.round((MAX_LENGTH - MIN_LENGTH)) / NUMBER_OF_TICKS);
        lengthSlider.setFont(new Font("Pacifico", Font.BOLD, 18));
        lengthSlider.setForeground(DONATE_COLOR);
        lengthSlider.setPaintTicks(true);
        lengthSlider.setPaintLabels(true);
        lengthSlider.addChangeListener(new SliderListener(lengthSlider));

        return lengthSlider;
    }

    // EFFECTS: returns a JPanel with a JTextField submission box for the cool fact about that user's RoboAnimal
    public JPanel makeCoolFactSubmissionTextBox() {
        JPanel coolFactSubmissionBlock = new JPanel(new GridLayout(1, 1));

        coolFactTextField = new JTextField(new HTMLDocument(), "", 1);
        coolFactTextField.setFont(new Font("Pacifico", Font.BOLD, 20));
        coolFactTextField.setForeground(DONATE_COLOR);

        coolFactSubmissionBlock.add(coolFactTextField);

        return coolFactSubmissionBlock;
    }

    // EFFECTS: returns a JPanel with a "Submit" button to submit the user's RoboAnimal,
    // this button adds the given RoboAnimal to the ZRA and confirms the donation if the user's donation was successful,
    // does nothing and reports an error message if the name or the cool fact is an empty string, or the biome is null
    public JPanel createSubmissionButton() {
        JPanel submissionButtonBlock = new JPanel(new GridLayout(2, 1));

        JButton submission = new JButton(ButtonNames.SUBMIT.getName());
        submission.setFont(new Font("Pacifico", Font.BOLD, 24));
        submission.setForeground(DONATE_COLOR);

        submission.addActionListener(e -> {

            userName = nameTextField.getText();
            userFact = coolFactTextField.getText();

            if ((userName.isEmpty()) || (userBiome == null) || (userFact.isEmpty())) {
                donateMessage.setText(ERROR_MESSAGE);
            } else {
                RoboAnimal userRoboAnimal = new RoboAnimal(userName, userBiome, userlength, userFact);
                zra.addRoboAnimal(userRoboAnimal);
                initialGreeting.setText("Thank you for donating " + userName + " to the ZRA!");
                donateMessage.setText("We hope it will love the " + userBiome + "!");
            }
        });

        submissionButtonBlock.add(submission);

        return submissionButtonBlock;
    }

    // EFFECTS: returns a JPanel with a "Reset" button that displays the DONATE_TEXT message,
    // resets nameTextField and coolFactTextField to an empty string
    public JPanel createResetButton() {
        JPanel resetButtonBlock = new JPanel(new GridLayout(2, 1));

        JButton reset = new JButton(ButtonNames.RESET.getName());
        reset.setFont(new Font("Pacifico", Font.BOLD, 24));
        reset.setForeground(DONATE_COLOR);

        reset.addActionListener(e -> {
            initialGreeting.setText(BEEP_BOOP_GREETING);
            donateMessage.setText(DONATE_TEXT);
            nameTextField.setText("");
            coolFactTextField.setText("");
        });

        resetButtonBlock.add(reset);

        return resetButtonBlock;
    }

    // Represents an ActionListener for selecting a biome for the user's RoboAnimal
    private class BiomeListener implements ActionListener {

        String givenBiome;

        // EFFECTS: creates a BiomeListener with a given biome
        public BiomeListener(String s) {
            this.givenBiome = s;
        }

        // MODIFIES: this
        // EFFECTS: sets userBiome equal to the given biome
        @Override
        public void actionPerformed(ActionEvent e) {
            userBiome = this.givenBiome;
        }
    }

    // Represents a ChangeListener for choosing a length for the user's RoboAnimal
    private class SliderListener implements ChangeListener {

        JSlider slider;

        // EFFECTS: creates a SliderListener with a given JSlider
        public SliderListener(JSlider lengthSlider) {
            this.slider = lengthSlider;
        }

        // MODIFIES: this
        // EFFECTS: sets userLength equal to the value of the given slider
        @Override
        public void stateChanged(ChangeEvent e) {
            userlength = slider.getValue();
        }
    }

}
