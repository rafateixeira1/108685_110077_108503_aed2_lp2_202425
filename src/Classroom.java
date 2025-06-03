import java.util.ArrayList;

public class Classroom {
    private int id;
    private ArrayList<Event> events;
    private boolean sockets; // true se tem tomadas, false se não tem
    private int floor;

    public Classroom(int id, ArrayList<Event> events, boolean sockets, int floor) {
        this.setId(id);
        this.setEvents(events);
        this.setSockets(sockets);
        this.setFloor(floor);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Event> getEvents() {
        return events;
    }

    public void setEvents(ArrayList<Event> events) {
        this.events = events;
    }

    public boolean hasSockets() {
        return isSockets();
    }

    public void setSockets(boolean sockets) {
        this.sockets = sockets;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public boolean isSockets() {
        return sockets;
    }
}