package persistence;

import model.RoboAnimal;
import model.ZooForRoboAnimals;
import model.biome.Biome;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

// Represents a JSONReader that reads myZRA from JSON data stored in file
// note: methods in this class are inspired by methods in JsonSerializationDemo
public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads myZRA from file and returns it, throws IOException if an error occurs reading data from file
    public ZooForRoboAnimals read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseZra(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }
        return contentBuilder.toString();
    }

    // EFFECTS: parses zra from JSON object and returns it
    private ZooForRoboAnimals parseZra(JSONObject jsonObject) {
        String name = jsonObject.getString("zraName");
        ZooForRoboAnimals zra = new ZooForRoboAnimals(name);
        addAttractions(zra, jsonObject);
        return zra;
    }

    // MODIFIES: zra
    // EFFECTS: parses attractions from JSON Object and adds them to zra
    private void addAttractions(ZooForRoboAnimals zra, JSONObject jsonObject) {
        JSONArray jsonArray1 = jsonObject.getJSONArray("biomes");
        JSONArray jsonArray2 = jsonObject.getJSONArray("roboanimals");

        for (Object json : jsonArray1) {
            JSONObject nextBiome = (JSONObject) json;
            addBiome(zra, nextBiome);
        }

        for (Object json : jsonArray2) {
            JSONObject nextRoboAnimal = (JSONObject) json;
            addRoboAnimal(zra, nextRoboAnimal);
        }
    }

    // MODIFIES: zra
    // EFFECTS: parses RoboAnimal from JSON object and adds it to workroom
    private void addBiome(ZooForRoboAnimals zra, JSONObject jsonObject) {
        String name = jsonObject.getString("biomeName");
        String introduction = jsonObject.getString("introduction");

        Biome biome = new Biome(name, introduction);
        zra.addBiome(biome);
    }

    // MODIFIES: zra
    // EFFECTS: parses RoboAnimal from JSON object and adds it to workroom
    private void addRoboAnimal(ZooForRoboAnimals zra, JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        String biome = jsonObject.getString("biome");
        int length = jsonObject.getInt("length");
        String coolFact = jsonObject.getString("coolFact");

        RoboAnimal roboAnimal = new RoboAnimal(name, biome, length, coolFact);
        zra.addRoboAnimal(roboAnimal);
    }

}
