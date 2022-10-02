package model.biome;

// Represents a cave biome with a relevant name and introduction
public class Cave extends Biome {

    private static final String CAVE_INTRODUCTION = "I can barely see anything! If only humans used echolocation…";

    // MODIFIES: this
    // EFFECTS: creates a new Cave with an introduction
    public Cave() {
        super("Cave", CAVE_INTRODUCTION);

    }

}
