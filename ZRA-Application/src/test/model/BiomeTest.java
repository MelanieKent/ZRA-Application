package model;

import model.biome.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

// Tests Biome constructor and methods, and those of its subclasses
class BiomeTest {

    Biome cave;
    Biome grassland;
    Biome ocean;
    Biome tropic;

    @BeforeEach
    public void setup() {
        cave = new Cave();
        grassland =  new Grassland();
        ocean = new Ocean();
        tropic = new Tropic();
    }

    @Test
    public void testCave() {
        assertEquals("Cave", cave.getName());
        assertEquals("I can barely see anything! If only humans used echolocation…", cave.getIntro());
    }

    @Test
    public void testGrassland() {
        assertEquals("Grassland", grassland.getName());
        assertEquals("Isn’t all of this lush grassland beautiful?! \n"
                        + "It took the ZRA over 2 years to import all of this grass from various time periods!",
                grassland.getIntro());
    }

    @Test
    public void testOcean() {
        assertEquals("Ocean", ocean.getName());
        assertEquals("Wow, aren’t the depths mesmerizing! \n"
                        + "Our oceans here at the ZRA are more than 50 miles across and almost 2 miles deep!",
                ocean.getIntro());
    }

    @Test
    public void testTropic() {
        assertEquals("Tropic", tropic.getName());
        assertEquals("It's so humid here! \n"
                + "Thanks to our industry leading humidifiers here at the ZRA, all of our robotic animals enjoy "
                + "an artificial environment superior to the real thing! \n"
                + "Make sure to stay hydrated!", tropic.getIntro());
    }

    @Test
    public void testGetBiomeIntro() {
        assertEquals("I can barely see anything! If only humans used echolocation…", cave.getIntro());
        assertEquals("Isn’t all of this lush grassland beautiful?! \n"
                + "It took the ZRA over 2 years to import all of this grass from various time periods!",
                grassland.getIntro());
        assertEquals("Wow, aren’t the depths mesmerizing! \n"
                + "Our oceans here at the ZRA are more than 50 miles across and almost 2 miles deep!",
                ocean.getIntro());
        assertEquals("It's so humid here! \n"
                + "Thanks to our industry leading humidifiers here at the ZRA, all of our robotic animals enjoy "
                + "an artificial environment superior to the real thing! \n"
                + "Make sure to stay hydrated!", tropic.getIntro());
    }

}