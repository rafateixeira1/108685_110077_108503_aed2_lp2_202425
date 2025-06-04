import java.util.*;
import java.io.*;

/**
 * Representa uma turma na universidade.
 * Uma turma pode ter alunos, professores, eventos e cursos associados.
 */
public class SchoolClass implements Serializable {
    private int id;
    private String name;
    private ArrayList<Student> students;
    private ArrayList<Professor> professors;
    private ArrayList<Event> events;
    private ArrayList<Course> courses;

    /**
     * Construtor completo da turma.
     * @param id Identificador único da turma.
     * @param name Nome da turma.
     * @param students Lista de alunos da turma.
     * @param professors Lista de professores da turma.
     * @param events Lista de eventos associados à turma.
     * @param courses Lista de cursos da turma.
     */
    public SchoolClass(int id, String name, ArrayList<Student> students, ArrayList<Professor> professors, ArrayList<Event> events, ArrayList<Course> courses) {
        this.setId(id);
        this.setName(name);
        this.setStudents(students);
        this.setProfessors(professors);
        this.setEvent(events);
        this.setCourses(courses);
    }

    /**
     * Construtor que inicializa apenas com id e nome.
     * @param id Identificador da turma.
     * @param name Nome da turma.
     */
    public SchoolClass(int id, String name) {
        this(id, name, new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
    }

    /**
     * Obtém o identificador da turma.
     * @return id da turma.
     */
    public int getId() {
        return id;
    }

    /**
     * Define o identificador da turma.
     * @param id Novo id da turma.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtém o nome da turma.
     * @return Nome da turma.
     */
    public String getName() {
        return name;
    }

    /**
     * Define o nome da turma.
     * @param name Novo nome da turma.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Obtém a lista de alunos da turma.
     * @return Lista de alunos.
     */
    public ArrayList<Student> getStudents() {
        return students;
    }

    /**
     * Define a lista de alunos da turma.
     * @param students Nova lista de alunos.
     */
    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    /**
     * Obtém a lista de professores da turma.
     * @return Lista de professores.
     */
    public ArrayList<Professor> getProfessors() {
        return professors;
    }

    /**
     * Define a lista de professores da turma.
     * @param professors Nova lista de professores.
     */
    public void setProfessors(ArrayList<Professor> professors) {
        this.professors = professors;
    }

    /**
     * Obtém a lista de eventos da turma.
     * @return Lista de eventos.
     */
    public ArrayList<Event> getEvent() {
        return events;
    }

    /**
     * Define a lista de eventos da turma.
     * @param events Nova lista de eventos.
     */
    public void setEvent(ArrayList<Event> events) {
        this.events = events;
    }

    /**
     * Obtém a lista de cursos da turma.
     * @return Lista de cursos.
     */
    public ArrayList<Course> getCourses() {
        return courses;
    }

    /**
     * Define a lista de cursos da turma.
     * @param courses Nova lista de cursos.
     */
    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }
}