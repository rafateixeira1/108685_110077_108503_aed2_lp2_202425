import edu.princeton.cs.algs4.*;

/**
 * Estrutura de dados baseada em tabela de dispersão (hash table) para armazenar e gerenciar cursos (Course) por id.
 * Fornece operações básicas de inserção, remoção, busca e iteração sobre os ids dos cursos.
 */
public class ST_Course {
    private SeparateChainingHashST<Integer, Course> st;

    /**
     * Construtor que inicializa a tabela de dispersão de cursos.
     */
    public ST_Course() {
        st = new SeparateChainingHashST<>();
    }

    /**
     * Insere ou atualiza um curso na tabela.
     * @param id Identificador do curso.
     * @param course Objeto Course a ser inserido.
     */
    public void put(int id, Course course) {
        st.put(id, course);
    }

    /**
     * Recupera um curso pelo id.
     * @param id Identificador do curso.
     * @return O curso correspondente ou null se não existir.
     */
    public Course get(int id) {
        return st.get(id);
    }

    /**
     * Verifica se existe um curso com o id fornecido.
     * @param id Identificador do curso.
     * @return true se existir, false caso contrário.
     */
    public boolean contains(int id) {
        return st.contains(id);
    }

    /**
     * Remove um curso da tabela pelo id.
     * @param id Identificador do curso a ser removido.
     */
    public void remove(int id) {
        st.delete(id);
    }

    /**
     * Retorna um iterável com todos os ids dos cursos armazenados.
     * @return Iterable de ids dos cursos.
     */
    public Iterable<Integer> keys() {
        return st.keys();
    }
}