package model;

import model.biome.Biome;
import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;
import java.util.List;

// Represents a zoo having an empty list of robotic animals and an empty list of biomes
// note: ZRA is short for Zoo for Robotic Animals
public class ZooForRoboAnimals implements Writable {

    protected List<RoboAnimal> currentRoboAnimals;
    protected List<Biome> availableBiomes;
    protected String name;

    // MODIFIES: this
    // EFFECTS: constructs a new ZRA with no RoboAnimals and no Biomes
    public ZooForRoboAnimals(String name) {
        this.name = name;
        this.currentRoboAnimals = new ArrayList<>();
        this.availableBiomes = new ArrayList<>();
    }

    // REQUIRES: List must not be empty
    // EFFECTS: returns a List of the names of the RoboAnimals in the ZRA
    public List<String> getRoboAnimalNames() {
        List<String> names = new ArrayList<>();
        for (RoboAnimal ra : getRoboAnimals()) {
            String name = ra.getName();
            names.add(name);
        }
        return names;
    }

    // REQUIRES: List must not be empty
    // EFFECTS: returns a List of strings comprising of "<name> - located in: <biome>" of all RoboAnimals in the ZRA
    public List<String> getRoboAnimalsAndBiomes() {
        List<String> attractions = new ArrayList<>();
        for (RoboAnimal ra : currentRoboAnimals) {
            String name = ra.getName();
            String biome = ra.getBiome();
            String nameAndBiomoe = name + " - located in: " + biome;
            attractions.add(nameAndBiomoe);
        }
        return attractions;
    }

    // REQUIRES: List must not be empty
    // EFFECTS: returns a List of the RoboAnimals in the biome with the given name, adds this biome visitation to the
    // event log
    public List<RoboAnimal> getRoboAnimalsInBiome(String biomeName) {
        EventLog.getInstance().logEvent(new Event("VISITATION: " + biomeName + " was visited!"));
        List<RoboAnimal> roboAnimalsInBiome = new ArrayList<>();
        for (RoboAnimal ra : currentRoboAnimals) {
            String biome = ra.getBiome();
            if (biome.equals(biomeName)) {
                roboAnimalsInBiome.add(ra);
            }
        }
        return roboAnimalsInBiome;
    }

    // REQUIRES: List must not be empty
    // EFFECTS: returns a List of the name, followed by the biome, then the length (as a string), then
    // the cool fact of the RoboAnimals in the ZRA (name1, biome1, length1, coolFact1, name2, biome2, length2,
    // coolFact2, ...)
    public List<String> listAllRoboAttributes() {
        List<RoboAnimal> roboAnimals = getRoboAnimals();
        List<String> attributes = new ArrayList<>();

        for (RoboAnimal roboAnimal : roboAnimals) {
            attributes.add(roboAnimal.getName());
            attributes.add(roboAnimal.getBiome());
            attributes.add(Integer.toString(roboAnimal.getLength()));
            attributes.add(roboAnimal.getCoolFact());
        }
        return attributes;
    }

    // EFFECTS: returns name of the given ZRA
    public String getName() {
        return name;
    }

    // REQUIRES: List must not be empty
    // EFFECTS: returns a List of the biomes in the ZRA
    public List<Biome> getBiomes() {
        return this.availableBiomes;
    }

    // REQUIRES: List must not be empty
    // EFFECTS: returns a List of the RoboAnimals in the ZRA
    public List<RoboAnimal> getRoboAnimals() {
        return this.currentRoboAnimals;
    }

    // REQUIRES: the given RoboAnimal must not already exist in currentRoboAnimals
    // MODIFIES: this
    // EFFECTS: adds the given RoboAnimal to the ZRA, adds this addition event to the event log
    public void addRoboAnimal(RoboAnimal roboAnimal) {
        EventLog.getInstance().logEvent(new Event("ADDITION: " + roboAnimal.getName()
                + " was added to the ZRA!"));
        currentRoboAnimals.add(roboAnimal);
    }

    // REQUIRES: given Biome must not already exist in availableBiomes
    // MODIFIES: this
    // EFFECTS: adds the given Biome to the ZRA
    public void addBiome(Biome biome) {
        availableBiomes.add(biome);
    }

    @Override
    public JSONObject toJsonObject() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("zraName", name);
        jsonObject.put("biomes", biomesToJson());
        jsonObject.put("roboanimals", roboAnimalsToJson());
        return jsonObject;
    }

    // EFFECTS: returns biomes in this zra as a JSON array
    private JSONArray biomesToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Biome b : availableBiomes) {
            jsonArray.put(b.toJsonObject());
        }

        return jsonArray;
    }

    // EFFECTS: returns roboAnimals in this zra as a JSON array
    private JSONArray roboAnimalsToJson() {
        JSONArray jsonArray = new JSONArray();

        for (RoboAnimal ra : currentRoboAnimals) {
            jsonArray.put(ra.toJsonObject());
        }

        return jsonArray;
    }

    // MODIFIES: this
    // EFFECTS: set currentRoboAnimals to the given List of RoboAnimals
    public void setRoboAnimals(List<RoboAnimal> roboAnimals) {
        this.currentRoboAnimals = roboAnimals;
    }

}
