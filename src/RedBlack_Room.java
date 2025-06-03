import edu.princeton.cs.algs4.*;

public class RedBlack_Room {
    private RedBlackBST<Integer, Classroom> room;

    public RedBlack_Room() {
        room = new RedBlackBST<>();
    }

    public void put(int id, Classroom classroom) {
        room.put(id, classroom);
    }

    public Classroom get(int id) {
        return room.get(id);
    }

    public boolean contains(int id) {
        return room.contains(id);
    }

    public void remove(int id) {
        room.delete(id);
    }

    public Iterable<Integer> keys() {
        return room.keys();
    }
}