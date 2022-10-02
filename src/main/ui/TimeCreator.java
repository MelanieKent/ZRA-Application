package ui;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

// Represents a TimeCreator that gets and returns the current time
public class TimeCreator {

    private SimpleDateFormat timeFormat;
    private Date currentDate;
    private String currentTime;

    // MODIFIES: this
    // EFFECTS: creates a new DateCreator with a current time and a time format: HH:mm:ss
    public TimeCreator() {
        currentDate = Calendar.getInstance().getTime();
        timeFormat = new SimpleDateFormat("HH:mm:ss");
    }

    // MODIFIES: this
    // EFFECTS: updates current time in format: HH:mm:ss
    public void updateCurrentTime() {
        currentDate = Calendar.getInstance().getTime();
    }

    // EFFECTS: returns a string consisting of the current time in format: HH:mm:ss
    public String getCurrentTime() {
        currentTime = timeFormat.format(currentDate);
        return currentTime;
    }

}
