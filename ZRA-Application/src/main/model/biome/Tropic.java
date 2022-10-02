package model.biome;

// Represents a tropic biome with a relevant name and introduction
public class Tropic extends Biome {

    private static final String TROPIC_INTRODUCTION = "It's so humid here! \n"
            + "Thanks to our industry leading humidifiers here at the ZRA, all of our robotic animals enjoy "
            + "an artificial environment superior to the real thing! \n"
            + "Make sure to stay hydrated!";

    // MODIFIES: this
    // EFFECTS: creates a new Tropic with an introduction
    public Tropic() {
        super("Tropic", TROPIC_INTRODUCTION);

    }
}
