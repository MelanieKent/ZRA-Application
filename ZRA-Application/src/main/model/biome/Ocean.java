package model.biome;

// Represents an ocean biome with a relevant name and introduction
public class Ocean extends Biome {

    private static final String OCEAN_INTRODUCTION = "Wow, aren’t the depths mesmerizing! \n"
            + "Our oceans here at the ZRA are more than 50 miles across and almost 2 miles deep!";

    // MODIFIES: this
    // EFFECTS: creates a new Ocean with an introduction
    public Ocean() {
        super("Ocean", OCEAN_INTRODUCTION);

    }
}
