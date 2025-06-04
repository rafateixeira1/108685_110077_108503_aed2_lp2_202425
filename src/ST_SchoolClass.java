import edu.princeton.cs.algs4.*;
/**
 * Estrutura de dados para armazenar e gerenciar objetos SchoolClass usando uma tabela de dispersão.
 * Fornece métodos para inserir, obter, verificar existência, remover e iterar sobre as turmas.
 */
public class ST_SchoolClass {
    private SeparateChainingHashST<Integer, SchoolClass> st;

    /**
     * Construtor da estrutura de dados para turmas.
     * Inicializa a tabela de dispersão.
     */
    public ST_SchoolClass() {
        st = new SeparateChainingHashST<>();
    }

    /**
     * Insere ou atualiza uma turma na tabela.
     * @param id Identificador da turma.
     * @param schoolClass Objeto SchoolClass a ser inserido.
     */
    public void put(int id, SchoolClass schoolClass) {
        st.put(id, schoolClass);
    }

    /**
     * Obtém uma turma pelo seu identificador.
     * @param id Identificador da turma.
     * @return Objeto SchoolClass correspondente ou null se não existir.
     */
    public SchoolClass get(int id) {
        return st.get(id);
    }

    /**
     * Verifica se uma turma existe na tabela.
     * @param id Identificador da turma.
     * @return true se existir, false caso contrário.
     */
    public boolean contains(int id) {
        return st.contains(id);
    }

    /**
     * Remove uma turma da tabela pelo seu identificador.
     * @param id Identificador da turma a ser removida.
     */
    public void remove(int id) {
        st.delete(id);
    }

    /**
     * Retorna um iterável com todos os identificadores de turmas armazenados.
     * @return Iterable de inteiros com os IDs das turmas.
     */
    public Iterable<Integer> keys() {
        return st.keys();
    }
}