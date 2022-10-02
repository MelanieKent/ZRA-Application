package persistence;

import org.json.JSONObject;

// Represents an interface for objects that can be returned as JSON objects
// note: methods in this interface are inspired by methods in JsonSerializationDemo
public interface Writable {

    // EFFECTS: returns this as a JSON object
    JSONObject toJsonObject();

}
