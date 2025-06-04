import edu.princeton.cs.algs4.*;

/**
 * Estrutura de dados para armazenar e gerenciar objetos Student usando uma tabela de dispersão.
 * Fornece métodos para inserir, obter, verificar existência, remover e iterar sobre os estudantes.
 */
public class ST_Student {
    private SeparateChainingHashST<Integer, Student> st;

    /**
     * Construtor da estrutura de dados para estudantes.
     * Inicializa a tabela de dispersão.
     */
    public ST_Student() {
        st = new SeparateChainingHashST<>();
    }

    /**
     * Insere ou atualiza um estudante na tabela.
     * @param id Identificador do estudante.
     * @param student Objeto Student a ser inserido.
     */
    public void put(int id, Student student) {
        st.put(id, student);
    }

    /**
     * Obtém um estudante pelo seu identificador.
     * @param id Identificador do estudante.
     * @return Objeto Student correspondente ou null se não existir.
     */
    public Student get(int id) {
        return st.get(id);
    }

    /**
     * Verifica se um estudante existe na tabela.
     * @param id Identificador do estudante.
     * @return true se existir, false caso contrário.
     */
    public boolean contains(int id) {
        return st.contains(id);
    }

    /**
     * Remove um estudante da tabela pelo seu identificador.
     * @param id Identificador do estudante a ser removido.
     */
    public void remove(int id) {
        st.delete(id);
    }

    /**
     * Retorna um iterável com todos os identificadores de estudantes armazenados.
     * @return Iterable de inteiros com os IDs dos estudantes.
     */
    public Iterable<Integer> keys() {
        return st.keys();
    }
}
