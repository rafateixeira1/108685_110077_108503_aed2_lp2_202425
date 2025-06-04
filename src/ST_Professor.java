import edu.princeton.cs.algs4.*;

/**
 * Classe de tabela de símbolos para armazenar e gerenciar objetos Professor.
 * Utiliza uma tabela de dispersão com encadeamento separado.
 */
import edu.princeton.cs.algs4.*;

public class ST_Professor {
    private SeparateChainingHashST<Integer, Professor> st;

    /**
     * Construtor da classe ST_Professor.
     * Inicializa a tabela de símbolos.
     */
    public ST_Professor() {
        st = new SeparateChainingHashST<>();
    }

    /**
     * Adiciona um professor à tabela de símbolos.
     * @param id Identificador do professor.
     * @param professor Objeto Professor a ser adicionado.
     */
    public void put(int id, Professor professor) {
        st.put(id, professor);
    }

    /**
     * Obtém um professor pelo seu identificador.
     * @param id Identificador do professor.
     * @return Objeto Professor correspondente ou null se não encontrado.
     */
    public Professor get(int id) {
        return st.get(id);
    }

    /**
     * Verifica se existe um professor com o identificador fornecido.
     * @param id Identificador do professor.
     * @return true se existir, false caso contrário.
     */
    public boolean contains(int id) {
        return st.contains(id);
    }

    /**
     * Remove um professor da tabela de símbolos.
     * @param id Identificador do professor a ser removido.
     */
    public void remove(int id) {
        st.delete(id);
    }

    /**
     * Retorna um iterável com todos os identificadores de professores armazenados.
     * @return Iterable de inteiros com os IDs dos professores.
     */
    public Iterable<Integer> keys() {
        return st.keys();
    }
}