package ui.tabs;

import ui.ZRA;

import javax.swing.*;
import java.awt.*;

// Represents an abstract tab with a controller
public abstract class Tab extends JPanel {

    private final ZRA controller;

    // REQUIRES: ZRA controller that holds this tab
    // EFFECTS: creates a new tab with a given controller
    public Tab(ZRA controller) {
        this.controller = controller;
    }

    // EFFECTS: creates and returns row with button included
    public JPanel formatButtonRow(JButton b) {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.add(b);

        return panel;
    }

    // EFFECTS: returns the ZRA controller for this tab
    public ZRA getController() {
        return controller;
    }
}
