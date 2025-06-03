import java.util.*;

public class Classroom {
    private int id;
    private List<Event> events;

    public Classroom(int id, List<Event> events) {
        this.id = id;
        this.events = events;
    }

    public int getId() {
        return id;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }
}