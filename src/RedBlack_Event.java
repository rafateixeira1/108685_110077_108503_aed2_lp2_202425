import edu.princeton.cs.algs4.*;

public class RedBlack_Event {
    private RedBlackBST<Integer, Event> events;

    public RedBlack_Event() {
        events = new RedBlackBST<>();
    }

    public void put(int id, Event eventObj) {
        events.put(id, eventObj);
    }

    public Event get(int id) {
        return events.get(id);
    }

    public boolean contains(int id) {
        return events.contains(id);
    }

    public void remove(int id) {
        events.delete(id);
    }

    public Iterable<Integer> keys() {
        return events.keys();
    }
}