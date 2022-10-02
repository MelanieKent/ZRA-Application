package ui;

import model.Event;
import model.EventLog;
import model.RoboAnimal;
import model.ZooForRoboAnimals;
import model.biome.*;
import ui.tabs.*;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

// runs the Zoo for Robotic Animals application with a gui
// Inspired by methods in the SmartHomeUI class in the SmartHome application
public class ZRA extends JFrame {

    public static final int WELCOME_TAB_INDEX = 0;
    public static final int DISCOVER_TAB_INDEX = 1;
    public static final int CAVE_TAB_INDEX = 2;
    public static final int GRASSLAND_TAB_INDEX = 3;
    public static final int OCEAN_TAB_INDEX = 4;
    public static final int TROPIC_TAB_INDEX = 5;
    public static final int DONATE_TAB_INDEX = 6;

    public static final int WIDTH = 1000;
    public static final int HEIGHT = 1080;
    private ZooForRoboAnimals zra;
    private JTabbedPane sidebar;

    public static final String ASH_NAME = "AshOwl";
    public static final String BOLT_NAME = "BoltButterfly";
    public static final String BRUNO_NAME = "BrunoBat";
    public static final String OMEGA_NAME = "OmegaOrca";
    public static final String QUANTUM_NAME = "QuantumKiwi";
    public static final String RADION_NAME = "RadionFrog";
    public static final String SLICER_NAME = "SlicerSalamander";
    public static final String SPUTNIK_NAME = "SputnikShark";
    public static final String TURBO_NAME = "TurboTurtle";
    public static final String ZEON_NAME = "ZeonZebra";

    public static final String ASH_FACT = "It is one of the smallest known robo-animals, but make no mistake, it "
            + "is a fierce nocturnal predator! \nIt has a GPS installed behind its eyes so that it can "
            + "precisely navigate the grasslands! \nNow that's no small feat!";
    public static final String BOLT_FACT = "Did you know that it is the oldest known robo-animal? \nIt was "
            + "originally designed for military use! But now we get to observe it here! \nA little piece of history "
            + "for you!";
    public static final String BRUNO_FACT = "Its large frame allows it to produce an absurdly loud echolocation "
            + "sound. \nIf you need earplugs at any point, let us know!";
    public static final String OMEGA_FACT = "Did you know that it can shoot laser beams from its blowhole? "
            + "\nHow cool!";
    public static final String QUANTUM_FACT = "It emits large amounts of energy, but it is completely safe to humans.\n"
            + "If you need to charge a device, you know where to go!";
    public static final String RADION_FACT = "While it may seem big for a frog, RadionFrog prefers the larger frame to "
            + "scare off predators! \nJust make sure you do not touch it. It is poisonous!";
    public static final String SLICER_FACT = "It is a little rough around the edges, but it is super friendly! "
            + "\nIf you place it in a case, its makes a great pet!";
    public static final String SPUTNIK_FACT = "It is a master nocturnal hunter, so be sure not to get "
            + "too close to the edge. \nWatch your step!";
    public static final String TURBO_FACT = "Did you know that it is the fastest marine robo-animal to date? \n"
            + "Make sure you don’t blink or you may miss it!";
    public static final String ZEON_FACT = "It is a very shy creature, so make sure to whisper! \nShhhh…";

    public static void main(String[] args) throws IOException {
        JWindow splashScreen = new JWindow();
        splashScreen.setBounds(10, 10, WIDTH, HEIGHT);

        splashScreen.add(new JLabel(new ImageIcon("./data/ZRA Splash Screen.jpg")));

        splashScreen.setVisible(true);
        try {
            Thread.sleep(2400);
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
        splashScreen.setVisible(false);
        splashScreen.dispose();

        new ZRA();
    }

    // MODIFIES: this
    // EFFECTS: creates ZRA, loads RoboAnimals, Biomes, displays sidebar and tabs
    private ZRA() {
        super("ZRA Console");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        printEventLogUponClose();

        zra = new ZooForRoboAnimals("MyZRA");
        loadRoboAnimals(zra);
        loadBiomes(zra);

        sidebar = new JTabbedPane();
        sidebar.setTabPlacement(JTabbedPane.LEFT);

        loadTabs();
        add(sidebar);

        setVisible(true);
    }

    // EFFECTS: prints the event log of user activities to the console when application is closed
    private void printEventLogUponClose() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                for (Event next : EventLog.getInstance()) {
                    Event event = next;
                    System.out.println(event.getDate() + " --- " + event.getDescription());
                }
                System.exit(0);
            }
        });
    }

    // EFFECTS: returns ZRA object controlled by this UI
    public ZooForRoboAnimals getZra() {
        return zra;
    }

    // MODIFIES: this
    // EFFECTS: loads RoboAnimals into the ZRA
    private static void loadRoboAnimals(ZooForRoboAnimals zra) {
        RoboAnimal ashOwl = new RoboAnimal(ASH_NAME, "Grassland", 5, ASH_FACT);
        RoboAnimal boltButterfly = new RoboAnimal(BOLT_NAME, "Tropic", 2, BOLT_FACT);
        RoboAnimal brunoBat = new RoboAnimal(BRUNO_NAME, "Cave", 4000, BRUNO_FACT);
        RoboAnimal omegaOrca = new RoboAnimal(OMEGA_NAME, "Ocean", 200000, OMEGA_FACT);
        RoboAnimal quantumKiwi = new RoboAnimal(QUANTUM_NAME, "Tropic", 10, QUANTUM_FACT);
        RoboAnimal radionFrog = new RoboAnimal(RADION_NAME, "Tropic", 1000, RADION_FACT);
        RoboAnimal slicerSalamander = new RoboAnimal(SLICER_NAME, "Cave", 10, SLICER_FACT);
        RoboAnimal sputnikShark = new RoboAnimal(SPUTNIK_NAME, "Ocean", 80000, SPUTNIK_FACT);
        RoboAnimal turboTurtle = new RoboAnimal(TURBO_NAME, "Ocean", 2000, TURBO_FACT);
        RoboAnimal zeonZebra = new RoboAnimal(ZEON_NAME, "Grassland", 5000, ZEON_FACT);

        zra.addRoboAnimal(ashOwl);
        zra.addRoboAnimal(boltButterfly);
        zra.addRoboAnimal(brunoBat);
        zra.addRoboAnimal(omegaOrca);
        zra.addRoboAnimal(quantumKiwi);
        zra.addRoboAnimal(radionFrog);
        zra.addRoboAnimal(slicerSalamander);
        zra.addRoboAnimal(sputnikShark);
        zra.addRoboAnimal(turboTurtle);
        zra.addRoboAnimal(zeonZebra);
    }

    // MODIFIES: this
    // EFFECTS: loads biomes into the ZRA
    private static void loadBiomes(ZooForRoboAnimals zra) {
        Biome c = new Cave();
        Biome g = new Grassland();
        Biome o = new Ocean();
        Biome t = new Tropic();

        zra.addBiome(c);
        zra.addBiome(g);
        zra.addBiome(o);
        zra.addBiome(t);
    }

    // MODIFIES: this
    // EFFECTS: adds WELCOME tab, DISCOVER tab, Cave tab, Grassland Tab, Ocean tab, Tropic tab, and DONATE tab
    private void loadTabs() {
        JPanel welcomeTab = new WelcomeTab(this);
        JPanel discoverTab = new DiscoverTab(this);
        JPanel caveTab = new CaveTab(this);
        JPanel grasslandTab = new GrasslandTab(this);
        JPanel oceanTab = new OceanTab(this);
        JPanel tropicTab = new TropicTab(this);
        JPanel donateTab = new DonateTab(this);

        sidebar.add(welcomeTab, WELCOME_TAB_INDEX);
        sidebar.setTitleAt(WELCOME_TAB_INDEX, "WELCOME");
        sidebar.add(discoverTab, DISCOVER_TAB_INDEX);
        sidebar.setTitleAt(DISCOVER_TAB_INDEX, "DISCOVER");
        sidebar.add(caveTab, CAVE_TAB_INDEX);
        sidebar.setTitleAt(CAVE_TAB_INDEX, "Cave");
        sidebar.add(grasslandTab, GRASSLAND_TAB_INDEX);
        sidebar.setTitleAt(GRASSLAND_TAB_INDEX, "Grassland");
        sidebar.add(oceanTab, OCEAN_TAB_INDEX);
        sidebar.setTitleAt(OCEAN_TAB_INDEX, "Ocean");
        sidebar.add(tropicTab, TROPIC_TAB_INDEX);
        sidebar.setTitleAt(TROPIC_TAB_INDEX, "Tropic");
        sidebar.add(donateTab, DONATE_TAB_INDEX);
        sidebar.setTitleAt(DONATE_TAB_INDEX, "DONATE");
    }

    // EFFECTS: returns sidebar of this UI
    public JTabbedPane getTabbedPane() {
        return sidebar;
    }

}
