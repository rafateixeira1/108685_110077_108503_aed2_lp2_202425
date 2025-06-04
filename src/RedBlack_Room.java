import edu.princeton.cs.algs4.*;

/**
 * Estrutura de dados baseada em árvore rubro-negra para armazenar e gerenciar salas (Classroom) por id.
 * Fornece operações básicas de inserção, remoção, busca e iteração sobre os ids das salas.
 */
public class RedBlack_Room {
    private RedBlackBST<Integer, Classroom> room;

    /**
     * Construtor que inicializa a árvore rubro-negra de salas.
     */
    public RedBlack_Room() {
        room = new RedBlackBST<>();
    }

    /**
     * Insere ou atualiza uma sala na árvore.
     * @param id Identificador da sala.
     * @param classroom Objeto Classroom a ser inserido.
     */
    public void put(int id, Classroom classroom) {
        room.put(id, classroom);
    }

    /**
     * Recupera uma sala pelo id.
     * @param id Identificador da sala.
     * @return A sala correspondente ou null se não existir.
     */
    public Classroom get(int id) {
        return room.get(id);
    }

    /**
     * Verifica se existe uma sala com o id fornecido.
     * @param id Identificador da sala.
     * @return true se existir, false caso contrário.
     */
    public boolean contains(int id) {
        return room.contains(id);
    }

    /**
     * Remove uma sala da árvore pelo id.
     * @param id Identificador da sala a ser removida.
     */
    public void remove(int id) {
        room.delete(id);
    }

    /**
     * Retorna um iterável com todos os ids das salas armazenadas.
     * @return Iterable de ids das salas.
     */
    public Iterable<Integer> keys() {
        return room.keys();
    }
}