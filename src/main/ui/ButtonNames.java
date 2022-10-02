package ui;

// Enumeration for all the button names within the ZRA gui
// Inspired by the enumeration within the SmartHome application
public enum ButtonNames {

    LOAD("Load"),
    SAVE("Save"),
    REFRESH_LISTING("Refresh Listing"),
    SUBMIT("Submit!"),
    RESET("Reset"),
    CAVE("Cave"),
    GRASSLAND("Grassland"),
    OCEAN("Ocean"),
    TROPIC("Tropic"),
    EXPLORE_CAVE("Explore the cave!"),
    EXPLORE_GRASSLAND("Explore the grassland!"),
    EXPLORE_OCEAN("Explore the ocean!"),
    EXPLORE_TROPIC("Explore the tropic!");

    private final String name;

    ButtonNames(String name) {
        this.name = name;
    }

    // EFFECTS: returns the name of this button
    public String getName() {
        return name;
    }

}
