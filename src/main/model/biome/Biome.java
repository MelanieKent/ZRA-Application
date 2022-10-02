package model.biome;

import org.json.JSONObject;
import persistence.Writable;

// Represents an abstract biome
public class Biome implements Writable {

    protected String introduction;
    protected String name;

    // EFFECTS: constructs new biome with given name and introduction
    public Biome(String name, String introduction) {
        this.name = name;
        this.introduction = introduction;
    }

    // EFFECTS: returns a description of the given biome
    public String getIntro() {
        return introduction;
    }

    public String getName() {
        return name;
    }

    @Override
    public JSONObject toJsonObject() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("biomeName", name);
        jsonObject.put("introduction", introduction);
        return jsonObject;
    }

}
