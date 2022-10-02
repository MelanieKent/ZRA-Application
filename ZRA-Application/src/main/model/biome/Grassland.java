package model.biome;

// Represents a grassland biome with a relevant name and introduction
public class Grassland extends Biome {

    private static final String GRASSLAND_INTRODUCTION = "Isn’t all of this lush grassland beautiful?! \n"
            + "It took the ZRA over 2 years to import all of this grass from various time periods!";

    // MODIFIES: this
    // EFFECTS: creates a new Grassland with an introduction
    public Grassland() {
        super("Grassland", GRASSLAND_INTRODUCTION);

    }
}
