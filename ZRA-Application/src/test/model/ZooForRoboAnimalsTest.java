package model;

import model.biome.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

// Tests ZooForRoboAnimals constructor and methods
public class ZooForRoboAnimalsTest {

    ZooForRoboAnimals zraTest;

    RoboAnimal roboAnimal1;
    RoboAnimal roboAnimal2;
    RoboAnimal roboAnimal3;
    RoboAnimal roboAnimal4;

    Biome cave;
    Biome grassland;
    Biome ocean;
    Biome tropic;

    @BeforeEach
    public void setup() {
        zraTest = new ZooForRoboAnimals("ZRA Test");

        roboAnimal1 = new RoboAnimal("One", "Cave", 10, "Nice!");
        roboAnimal2 = new RoboAnimal("Two", "Grassland", 5, "Cool!");
        roboAnimal3 = new RoboAnimal("Three", "Ocean", 8000, "Neat!");
        roboAnimal4 = new RoboAnimal("Four", "Tropic", 1, "OMG!");

        cave = new Cave();
        grassland =  new Grassland();
        ocean = new Ocean();
        tropic = new Tropic();
    }

    @Test
    public void testConstructor() {
        assertEquals("ZRA Test", zraTest.getName());
        assertTrue(zraTest.currentRoboAnimals.isEmpty());
        assertTrue(zraTest.availableBiomes.isEmpty());
    }

    @Test
    public void testGetRoboAnimalNames() {
        List<String> roboAnimalNames = new ArrayList<>();
        roboAnimalNames.add("One");
        roboAnimalNames.add("Two");
        roboAnimalNames.add("Three");
        roboAnimalNames.add("Four");

        zraTest.addRoboAnimal(roboAnimal1);
        zraTest.addRoboAnimal(roboAnimal2);
        zraTest.addRoboAnimal(roboAnimal3);
        zraTest.addRoboAnimal(roboAnimal4);

        assertEquals(roboAnimalNames, zraTest.getRoboAnimalNames());
    }

    @Test
    public void testGetRoboAnimalsAndBiomes() {
        List<String> attractions = new ArrayList<>();
        attractions.add("One - located in: Cave");
        attractions.add("Two - located in: Grassland");

        zraTest.addRoboAnimal(roboAnimal1);
        zraTest.addRoboAnimal(roboAnimal2);

        assertEquals(attractions, zraTest.getRoboAnimalsAndBiomes());
    }

    @Test
    public void testGetRoboAnimalsInBiome() {
        List<RoboAnimal> roboAnimalsInCave = new ArrayList<>();
        List<RoboAnimal> roboAnimalsInOcean = new ArrayList<>();

        roboAnimalsInCave.add(roboAnimal1);
        roboAnimalsInOcean.add(roboAnimal3);

        zraTest.addRoboAnimal(roboAnimal1);
        zraTest.addRoboAnimal(roboAnimal2);
        zraTest.addRoboAnimal(roboAnimal3);
        zraTest.addRoboAnimal(roboAnimal4);

        assertEquals(roboAnimalsInCave, zraTest.getRoboAnimalsInBiome("Cave"));
        assertEquals(roboAnimalsInOcean, zraTest.getRoboAnimalsInBiome("Ocean"));
    }

    @Test
    public void testListAllRoboAttributes() {
        List<String> allRoboAttributes = new ArrayList<>(0);

        allRoboAttributes.add("Two");
        allRoboAttributes.add("Grassland");
        allRoboAttributes.add("5");
        allRoboAttributes.add("Cool!");
        allRoboAttributes.add("Four");
        allRoboAttributes.add("Tropic");
        allRoboAttributes.add("1");
        allRoboAttributes.add("OMG!");

        zraTest.addRoboAnimal(roboAnimal2);
        zraTest.addRoboAnimal(roboAnimal4);

        assertEquals(allRoboAttributes, zraTest.listAllRoboAttributes());
    }

    @Test
    public void testGetRoboAnimals() {
        List<RoboAnimal> roboAnimals = new ArrayList<>();
        roboAnimals.add(roboAnimal1);
        roboAnimals.add(roboAnimal2);
        roboAnimals.add(roboAnimal3);

        zraTest.addRoboAnimal(roboAnimal1);
        zraTest.addRoboAnimal(roboAnimal2);
        zraTest.addRoboAnimal(roboAnimal3);

        assertEquals(roboAnimals, zraTest.getRoboAnimals());
    }

    @Test
    public void testAddRoboAnimal() {
        List<RoboAnimal> roboAnimals = new ArrayList<>();
        roboAnimals.add(roboAnimal1);
        roboAnimals.add(roboAnimal2);
        roboAnimals.add(roboAnimal3);

        zraTest.addRoboAnimal(roboAnimal1);
        zraTest.addRoboAnimal(roboAnimal2);
        zraTest.addRoboAnimal(roboAnimal3);

        assertEquals(roboAnimals, zraTest.getRoboAnimals());
    }

    @Test
    public void testAddBiome() {
        List<Biome> biomes = new ArrayList<>();

        biomes.add(cave);
        biomes.add(grassland);
        biomes.add(ocean);
        biomes.add(tropic);

        zraTest.addBiome(cave);
        zraTest.addBiome(grassland);
        zraTest.addBiome(ocean);
        zraTest.addBiome(tropic);

        assertEquals(biomes, zraTest.availableBiomes);
    }

    @Test
    public void testSetRoboAnimals() {
        zraTest.addRoboAnimal(roboAnimal1);
        zraTest.addRoboAnimal(roboAnimal2);

        assertEquals(2, zraTest.getRoboAnimals().size());
        assertTrue(zraTest.getRoboAnimals().contains(roboAnimal1));
        assertTrue(zraTest.getRoboAnimals().contains(roboAnimal2));

        List<RoboAnimal> roboAnimals = new ArrayList<>();
        roboAnimals.add(roboAnimal3);
        roboAnimals.add(roboAnimal4);

        zraTest.setRoboAnimals(roboAnimals);

        assertEquals(2, zraTest.getRoboAnimals().size());
        assertTrue(zraTest.getRoboAnimals().contains(roboAnimal3));
        assertTrue(zraTest.getRoboAnimals().contains(roboAnimal4));
    }

}


