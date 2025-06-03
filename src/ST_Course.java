import edu.princeton.cs.algs4.*;

public class ST_Course {
    private SeparateChainingHashST<Integer, Course> st;

    public ST_Course() {
        st = new SeparateChainingHashST<>();
    }

    public void put(int id, Course course) {
        st.put(id, course);
    }

    public Course get(int id) {
        return st.get(id);
    }

    public boolean contains(int id) {
        return st.contains(id);
    }

    public void remove(int id) {
        st.delete(id);
    }
    public Iterable<Integer> keys() {
        return st.keys();
    }
}
