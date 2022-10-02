package persistence;

import model.RoboAnimal;
import model.ZooForRoboAnimals;
import model.biome.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

// Tests JsonReader constructor and methods
public class JsonReaderTest extends JsonTest {

    JsonReader readerTest;

    @Test
    void testJsonReaderNonExistentFile() {
        readerTest = new JsonReader("./data/nonExistentFile.json");
        try {
            ZooForRoboAnimals zra = readerTest.read();
            fail("IOException not thrown");
        } catch (IOException e) {
            // Great, do nothing!
        }
    }

    @Test
    void testJsonReaderEmptyZRA() {
        readerTest = new JsonReader("./data/testJsonReaderEmptyZRA.json");
        try {
            ZooForRoboAnimals zra = readerTest.read();
            assertEquals("MyEmptyZRA", zra.getName());
            assertTrue(zra.getRoboAnimals().isEmpty());
            assertTrue(zra.getBiomes().isEmpty());
            // Great, do nothing!
        } catch (IOException e) {
            fail("Threw IOException");
        }
    }

    @Test
    void testJsonReaderGeneralZRA() {
        readerTest = new JsonReader("./data/testJsonReaderGeneralZRA.json");
        try {
            ZooForRoboAnimals zra = readerTest.read();
            assertEquals("MyZRA", zra.getName());
            List<Biome> biomes = zra.getBiomes();
            List<RoboAnimal> roboAnimals = zra.getRoboAnimals();
            assertEquals(2, biomes.size());
            assertEquals(2, roboAnimals.size());

            Cave c = new Cave();
            Ocean o = new Ocean();

            checkBiome("Cave", c.getIntro(), biomes.get(0));
            checkBiome("Ocean", o.getIntro(), biomes.get(1));

            checkRoboAnimal("Sam", "Ocean", 4, "He loves to swim!", roboAnimals.get(0));
            checkRoboAnimal("TomCat", "Cave", 80, "He loves to hunt!", roboAnimals.get(1));
            // Great, do nothing!
        } catch (IOException e) {
            fail("Threw IOException");
        }
    }

}
