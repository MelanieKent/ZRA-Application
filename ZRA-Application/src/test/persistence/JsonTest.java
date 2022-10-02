package persistence;

import model.RoboAnimal;
import model.biome.Biome;

import static org.junit.jupiter.api.Assertions.assertEquals;

// Superclass to other JSON tests, tests methods on JSON objects
public class JsonTest {

    protected void checkBiome(String name, String introduction, Biome biome) {
        assertEquals(name, biome.getName());
        assertEquals(introduction, biome.getIntro());
    }

    protected void checkRoboAnimal(String name, String biome, int length, String coolFact, RoboAnimal roboAnimal) {
      assertEquals(name, roboAnimal.getName());
      assertEquals(biome, roboAnimal.getBiome());
      assertEquals(length, roboAnimal.getLength());
      assertEquals(coolFact, roboAnimal.getCoolFact());
    }

}
