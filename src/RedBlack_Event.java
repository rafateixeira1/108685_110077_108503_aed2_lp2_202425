import edu.princeton.cs.algs4.*;

/**
 * Estrutura de dados baseada em árvore rubro-negra para armazenar e gerenciar eventos (Event) por id.
 * Fornece operações básicas de inserção, remoção, busca e iteração sobre os ids dos eventos.
 */
public class RedBlack_Event {
    private RedBlackBST<Integer, Event> events;

    /**
     * Construtor que inicializa a árvore rubro-negra de eventos.
     */
    public RedBlack_Event() {
        events = new RedBlackBST<>();
    }

    /**
     * Insere ou atualiza um evento na árvore.
     * @param id Identificador do evento.
     * @param eventObj Objeto Event a ser inserido.
     */
    public void put(int id, Event eventObj) {
        events.put(id, eventObj);
    }

    /**
     * Recupera um evento pelo id.
     * @param id Identificador do evento.
     * @return O evento correspondente ou null se não existir.
     */
    public Event get(int id) {
        return events.get(id);
    }

    /**
     * Verifica se existe um evento com o id fornecido.
     * @param id Identificador do evento.
     * @return true se existir, false caso contrário.
     */
    public boolean contains(int id) {
        return events.contains(id);
    }

    /**
     * Remove um evento da árvore pelo id.
     * @param id Identificador do evento a ser removido.
     */
    public void remove(int id) {
        events.delete(id);
    }

    /**
     * Retorna um iterável com todos os ids dos eventos armazenados.
     * @return Iterable de ids dos eventos.
     */
    public Iterable<Integer> keys() {
        return events.keys();
    }
}