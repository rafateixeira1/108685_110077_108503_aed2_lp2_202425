import edu.princeton.cs.algs4.*;

public class ST_Student {
    private SeparateChainingHashST<Integer, Student> st;

    public ST_Student() {
        st = new SeparateChainingHashST<>();
    }
    public void put(int id, Student student) {
        st.put(id, student);
    }
    public Student get(int id) {
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
