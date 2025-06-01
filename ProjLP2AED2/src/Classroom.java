import java.util.*;

public class Classroom {
    private int id;
    private SchoolClass turma;
    private List<Event> events;

    public Classroom(int id, SchoolClass turma, List<Event> events) {
        this.id = id;
        this.turma = turma;
        this.events = events;
    }

    public int getId() {
        return id;
    }

    public SchoolClass getTurma() {
        return turma;
    }

    public void setTurma(SchoolClass turma) {
        this.turma = turma;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }
}