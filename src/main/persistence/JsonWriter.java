package persistence;

import model.ZooForRoboAnimals;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

// Represents a JSONWriter that writes JSON representation of zra to file
// note: methods in this class are inspired by methods in JsonSerializationDemo
public class JsonWriter {
    private static final int TAB = 4;
    private PrintWriter printWriter;
    private String destinationFile;

    // EFFECTS: constructs JsonWriter to write destination file
    public JsonWriter(String destinationFile) {
        this.destinationFile = destinationFile;
    }

    // MODIFIES: this
    // EFFECTS: opens print writer, throws FileNotFoundException if destination file cannot be opened for writing
    public void open() throws FileNotFoundException {
        printWriter = new PrintWriter(new File(destinationFile));
    }

    // MODIFIES: this
    // EFFECTS: writes JSON representation of ZooForRoboticAnimals to file
    public void write(ZooForRoboAnimals zra) {
        JSONObject jsonObject = zra.toJsonObject();
        saveToFile(jsonObject.toString(TAB));
    }

    // MODIFIES: this
    // EFFECTS: closes writer
    public void close() {
        printWriter.close();
    }

    // MODIFIES: this
    // EFFECTS: writes string to file
    private void saveToFile(String jsonObject) {
        printWriter.print(jsonObject);
    }

}
