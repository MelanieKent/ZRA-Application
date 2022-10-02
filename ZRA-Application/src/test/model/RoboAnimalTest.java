package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

// Tests RoboAnimal constructor and methods
public class RoboAnimalTest {

    RoboAnimal roboAnimal1;
    RoboAnimal roboAnimal2;
    RoboAnimal roboAnimal3;
    RoboAnimal roboAnimal4;

    @BeforeEach
    public void setup() {
        roboAnimal1 = new RoboAnimal("One", "cave", 10, "Nice!");
        roboAnimal2 = new RoboAnimal("Two", "grassland", 5, "Cool!");
        roboAnimal3 = new RoboAnimal("Three", "ocean", 8000, "Neat!");
        roboAnimal4 = new RoboAnimal("Four", "tropic", 1, "OMG!");
    }

    @Test
    public void testRoboAnimal() {
        assertEquals("One", roboAnimal1.getName());
        assertEquals("Two", roboAnimal2.getName());

        assertEquals("ocean", roboAnimal3.getBiome());
        assertEquals("tropic", roboAnimal4.getBiome());

        assertEquals(10, roboAnimal1.getLength());
        assertEquals(5, roboAnimal2.getLength());

        assertEquals("Neat!", roboAnimal3.getCoolFact());
        assertEquals("OMG!", roboAnimal4.getCoolFact());
    }

    @Test
    public void testGetName(){
        assertEquals("Three", roboAnimal3.getName());
        assertEquals("Four", roboAnimal4.getName());
    }

    @Test
    public void testGetBiome(){
        assertEquals("cave", roboAnimal1.getBiome());
        assertEquals("grassland", roboAnimal2.getBiome());
    }

    @Test
    public void testGetLength(){
        assertEquals(8000, roboAnimal3.getLength());
        assertEquals(1, roboAnimal4.getLength());
    }

    @Test
    public void testGetCoolFact(){
        assertEquals("Nice!", roboAnimal1.getCoolFact());
        assertEquals("Cool!", roboAnimal2.getCoolFact());
    }

}
