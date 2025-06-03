import edu.princeton.cs.algs4.*;
public class ST_SchoolClass {
    private SeparateChainingHashST<Integer, SchoolClass> st;

    public ST_SchoolClass() {
        st = new SeparateChainingHashST<>();
    }

    public void put(int id, SchoolClass cls) {
        st.put(id, cls);
    }

    public SchoolClass get(int id) {
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
