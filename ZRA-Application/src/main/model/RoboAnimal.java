package model;

import org.json.JSONObject;
import persistence.Writable;

// Represents a robotic animal having a name, biome, length, and a cool fact
public class RoboAnimal implements Writable {

    protected String name;
    protected String biome;
    protected int length;
    protected String coolFact;

    // MODIFIES: this
    // EFFECTS: constructs a RoboAnimal with a given name, biome, length (in cm) and cool fact
    public RoboAnimal(String name, String biome, int length, String coolFact) {
        this.name = name;
        this.biome = biome;
        this.length = length;
        this.coolFact = coolFact;
    }

    // EFFECTS: returns the name of the given RoboAnimal
    public String getName() {
        return name;
    }

    // EFFECTS: returns the name of the biome of the given RoboAnimal
    public String getBiome() {
        return biome;
    }

    // EFFECTS: returns the length of the given RoboAnimal
    public int getLength() {
        return length;
    }

    // EFFECTS: returns the cool fact about the RoboAnimal
    public String getCoolFact() {
        return coolFact;
    }

    @Override
    public JSONObject toJsonObject() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", name);
        jsonObject.put("biome", biome);
        jsonObject.put("length", length);
        jsonObject.put("coolFact", coolFact);
        return jsonObject;
    }

}