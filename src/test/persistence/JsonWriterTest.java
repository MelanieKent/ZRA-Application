package persistence;

import model.RoboAnimal;
import model.ZooForRoboAnimals;
import model.biome.Cave;
import model.biome.Ocean;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

// Tests JsonWriter constructor and methods
public class JsonWriterTest extends JsonTest {

    JsonWriter writerTest;
    ZooForRoboAnimals zraTest;

    @Test
    void testJsonWriterInvalidFile() {
        try {
            zraTest = new ZooForRoboAnimals("MyZRA");
            writerTest = new JsonWriter("./data/my\0illegal:fileName.json");
            writerTest.open();
            fail("IOException not thrown");
        } catch (IOException e) {
            // Great, do nothing!
        }
    }

    @Test
    void testJsonWriterEmptyZRA() {
        try {
            zraTest = new ZooForRoboAnimals("MyZRA");
            writerTest = new JsonWriter("./data/testJsonWriterEmptyZRA.json");
            writerTest.open();
            writerTest.write(zraTest);
            writerTest.close();

            JsonReader readerTest = new JsonReader("./data/testJsonWriterEmptyZRA.json");
            zraTest = readerTest.read();
            assertEquals("MyZRA", zraTest.getName());
            assertTrue(zraTest.getBiomes().isEmpty());
            assertTrue(zraTest.getRoboAnimals().isEmpty());
            // Great, do nothing!
        } catch (IOException e) {
            fail("Threw IOException");
        }
    }

    @Test
    void testJsonWriterGeneralZRA() {
        try {
            zraTest = new ZooForRoboAnimals("MyZRA");

            Cave c = new Cave();
            Ocean o = new Ocean();
            RoboAnimal bill = new RoboAnimal("Bill", "Ocean", 8, "He loves to swim!");
            RoboAnimal tomCat = new RoboAnimal("TomCat", "Cave", 24, "He loves to hunt!");

            zraTest.addBiome(c);
            zraTest.addBiome(o);
            zraTest.addRoboAnimal(bill);
            zraTest.addRoboAnimal(tomCat);

            writerTest = new JsonWriter("./data/testJsonWriterGeneralZRA.json");
            writerTest.open();
            writerTest.write(zraTest);
            writerTest.close();

            JsonReader readerTest = new JsonReader("./data/testJsonWriterGeneralZRA.json");
            zraTest = readerTest.read();
            assertEquals("MyZRA", zraTest.getName());
            assertEquals(2, zraTest.getBiomes().size());
            assertEquals(2, zraTest.getRoboAnimals().size());

            checkBiome("Cave", c.getIntro(), zraTest.getBiomes().get(0));
            checkBiome("Ocean", o.getIntro(), zraTest.getBiomes().get(1));
            checkRoboAnimal("Bill", "Ocean", 8, "He loves to swim!", zraTest.getRoboAnimals().get(0));
            checkRoboAnimal("TomCat", "Cave", 24, "He loves to hunt!", zraTest.getRoboAnimals().get(1));
            // Great, do nothing!
        } catch (IOException e) {
            fail("Threw IOException");
        }
    }

}
