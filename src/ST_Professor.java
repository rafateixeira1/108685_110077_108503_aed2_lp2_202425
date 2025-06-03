import edu.princeton.cs.algs4.*;

public class ST_Professor {
    private SeparateChainingHashST<Integer, Professor> st;

    public ST_Professor() {
        st = new SeparateChainingHashST<>();
    }

    public void put(int id, Professor professor) {
        st.put(id, professor);
    }

    public Professor get(int id) {
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
