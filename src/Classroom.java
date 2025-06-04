import java.io.Serializable;
import java.util.ArrayList;

/**
 * Representa uma sala de aula na universidade.
 * Armazena informações sobre eventos, tomadas e piso.
 */
public class Classroom implements Serializable {
    private int id;
    private ArrayList<Event> events;
    private boolean sockets;
    private int floor;

    /**
     * Construtor completo da sala de aula.
     * @param id Identificador da sala.
     * @param events Lista de eventos associados à sala.
     * @param sockets Indica se a sala possui tomadas.
     * @param floor Piso onde a sala está localizada.
     */
    public Classroom(int id, ArrayList<Event> events, boolean sockets, int floor) {
        this.setId(id);
        this.setEvents(events);
        this.setSockets(sockets);
        this.setFloor(floor);
    }

    /**
     * Construtor que inicializa a sala apenas com o id.
     * @param id Identificador da sala.
     */
    public Classroom(int id) {
        this(id, new ArrayList<>(), false, 0);
    }

    /**
     * Obtém o identificador da sala.
     * @return id da sala.
     */
    public int getId() {
        return id;
    }

    /**
     * Define o identificador da sala.
     * @param id Novo id da sala.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtém a lista de eventos associados à sala.
     * @return Lista de eventos.
     */
    public ArrayList<Event> getEvents() {
        return events;
    }

    /**
     * Define a lista de eventos da sala.
     * @param events Nova lista de eventos.
     */
    public void setEvents(ArrayList<Event> events) {
        this.events = events;
    }

    /**
     * Verifica se a sala possui tomadas.
     * @return true se possui tomadas, false caso contrário.
     */
    public boolean hasSockets() {
        return sockets;
    }

    /**
     * Define se a sala possui tomadas.
     * @param sockets true se possui tomadas, false caso contrário.
     */
    public void setSockets(boolean sockets) {
        this.sockets = sockets;
    }

    /**
     * Obtém o piso onde a sala está localizada.
     * @return Número do piso.
     */
    public int getFloor() {
        return floor;
    }

    /**
     * Define o piso da sala.
     * @param floor Novo piso.
     */
    public void setFloor(int floor) {
        this.floor = floor;
    }
}