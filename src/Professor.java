import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Representa um professor na universidade.
 * Um professor pode lecionar várias disciplinas (Course), estar associado a várias turmas (SchoolClass)
 * e ter uma lista de eventos (Event) atribuídos.
 */
public class Professor extends Person implements Serializable {
    private ArrayList<Course> courses;
    private ArrayList<SchoolClass> SchoolClasses;
    private List<Event> events;

    /**
     * Construtor completo do Professor.
     *
     * @param id            Identificador único do professor.
     * @param name          Nome do professor.
     * @param courses       Lista de disciplinas lecionadas pelo professor.
     * @param schoolClasses Lista de turmas associadas ao professor.
     * @param events        Lista de eventos atribuídos ao professor.
     */
    public Professor(int id, String name, ArrayList<Course> courses, ArrayList<SchoolClass> schoolClasses, List<Event> events) {
        super(id, name);
        this.setCourses(courses);
        setSchoolClasses(schoolClasses);
        this.setEvents(events);
    }

    /**
     * Construtor do Professor apenas com id e nome.
     * Inicializa as listas de cursos, turmas e eventos vazias.
     *
     * @param id   Identificador único do professor.
     * @param name Nome do professor.
     */
    public Professor(int id, String name) {
        super(id, name);
        setCourses(new ArrayList<>());
        setSchoolClasses(new ArrayList<>());
        setEvents(new ArrayList<>());
    }

    /**
     * Adiciona um curso à lista de cursos do professor, se ainda não estiver presente.
     *
     * @param course Curso a ser adicionado.
     */
    public void addCourse(Course course) {
        if (course != null && !this.getCourses().contains(course)) {
            this.getCourses().add(course);
        }
    }

    /**
     * Adiciona uma turma à lista de turmas do professor, se ainda não estiver presente.
     *
     * @param schoolClass Turma a ser adicionada.
     */
    public void addSchoolClass(SchoolClass schoolClass) {
        if (schoolClass != null && !this.getSchoolClasses().contains(schoolClass)) {
            this.getSchoolClasses().add(schoolClass);
        }
    }

    /**
     * Adiciona um evento à lista de eventos do professor, se ainda não estiver presente.
     *
     * @param event Evento a ser adicionado.
     */
    public void addEvent(Event event) {
        if (event != null && !this.getEvents().contains(event)) {
            this.getEvents().add(event);
        }
    }

    /**
     * Obtém a lista de cursos lecionados pelo professor.
     *
     * @return Lista de cursos.
     */
    public ArrayList<Course> getCourses() {
        return courses;
    }

    /**
     * Define a lista de cursos lecionados pelo professor.
     *
     * @param courses Nova lista de cursos.
     */
    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }

    /**
     * Obtém a lista de turmas associadas ao professor.
     *
     * @return Lista de turmas.
     */
    public ArrayList<SchoolClass> getSchoolClasses() {
        return SchoolClasses;
    }

    /**
     * Define a lista de turmas associadas ao professor.
     *
     * @param schoolClasses Nova lista de turmas.
     */
    public void setSchoolClasses(ArrayList<SchoolClass> schoolClasses) {
        SchoolClasses = schoolClasses;
    }

    /**
     * Obtém a lista de eventos atribuídos ao professor.
     *
     * @return Lista de eventos.
     */
    public List<Event> getEvents() {
        return events;
    }

    /**
     * Define a lista de eventos atribuídos ao professor.
     *
     * @param events Nova lista de eventos.
     */
    public void setEvents(List<Event> events) {
        this.events = events;
    }
}