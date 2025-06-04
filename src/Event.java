import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.LocalTime;

/**
 * Representa um evento na universidade.
 * Um evento pode estar associado a uma sala, turma e professor,
 * além de conter informações sobre o horário e o curso relacionado.
 */
public class Event implements Serializable {
    private int id;
    private String name;
    private DayOfWeek dayOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;
    private String uc; // Unidade Curricular
    private Classroom classroom;
    private SchoolClass classes;
    private Professor professorid;

    /**
     * Construtor completo para a classe Event.
     *
     * @param id Identificador único do evento.
     * @param name Nome do evento.
     * @param dayOfWeek Dia da semana em que o evento ocorre.
     * @param startTime Hora de início do evento.
     * @param endTime Hora de término do evento.
     * @param uc Unidade Curricular associada ao evento.
     * @param classroom Sala onde o evento ocorre.
     * @param classes Turma associada ao evento.
     * @param professorid Professor responsável pelo evento.
     */
    public Event(int id, String name, DayOfWeek dayOfWeek, LocalTime startTime, LocalTime endTime, String uc, Classroom classroom, SchoolClass classes, Professor professorid) {
        this.setId(id);
        this.setName(name);
        this.setDayOfWeek(dayOfWeek);
        this.setStartTime(startTime);
        this.setEndTime(endTime);
        this.setUc(uc);
        this.setClassroom(classroom);
        this.setClasses(classes);
        this.setProfessorid(professorid);
    }

    /**
     * Obtém o identificador do evento.
     *
     * @return O identificador do evento.
     */
    public int getId() {
        return id;
    }

    /**
     * Define o identificador do evento.
     *
     * @param id Novo identificador do evento.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtém o nome do evento.
     *
     * @return O nome do evento.
     */
    public String getName() {
        return name;
    }

    /**
     * Define o nome do evento.
     *
     * @param name Novo nome do evento.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Obtém o dia da semana em que o evento ocorre.
     *
     * @return O dia da semana do evento.
     */
    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    /**
     * Define o dia da semana do evento.
     *
     * @param dayOfWeek Novo dia da semana do evento.
     */
    public void setDayOfWeek(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    /**
     * Obtém a hora de início do evento.
     *
     * @return A hora de início do evento.
     */
    public LocalTime getStartTime() {
        return startTime;
    }

    /**
     * Define a hora de início do evento.
     *
     * @param startTime Nova hora de início do evento.
     */
    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    /**
     * Obtém a hora de término do evento.
     *
     * @return A hora de término do evento.
     */
    public LocalTime getEndTime() {
        return endTime;
    }

    /**
     * Define a hora de término do evento.
     *
     * @param endTime Nova hora de término do evento.
     */
    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    /**
     * Obtém a Unidade Curricular associada ao evento.
     *
     * @return A Unidade Curricular do evento.
     */
    public String getUc() {
        return uc;
    }

    /**
     * Define a Unidade Curricular do evento.
     *
     * @param uc Nova Unidade Curricular do evento.
     */
    public void setUc(String uc) {
        this.uc = uc;
    }

    /**
     * Obtém a sala onde o evento ocorre.
     *
     * @return A sala do evento.
     */
    public Classroom getClassroom() {
        return classroom;
    }

    /**
     * Define a sala do evento.
     *
     * @param classroom Nova sala do evento.
     */
    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }

    /**
     * Obtém a turma associada ao evento.
     *
     * @return A turma do evento.
     */
    public SchoolClass getClasses() {
        return classes;
    }

    /**
     * Define a turma do evento.
     *
     * @param classes Nova turma do evento.
     */
    public void setClasses(SchoolClass classes) {
        this.classes = classes;
    }

    /**
     * Obtém o professor responsável pelo evento.
     *
     * @return O professor do evento.
     */
    public Professor getProfessorid() {
        return professorid;
    }

    /**
     * Define o professor responsável pelo evento.
     *
     * @param professorid Novo professor do evento.
     */
    public void setProfessorid(Professor professorid) {
        this.professorid = professorid;
    }
}