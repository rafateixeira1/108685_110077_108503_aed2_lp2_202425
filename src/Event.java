import java.time.DayOfWeek;
import java.time.LocalTime;

public class Event {
    private int id;
    private String name;
    private DayOfWeek dayOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;
    private String uc;
    private Classroom classroom;
    private SchoolClass classes; // id da turma
    private Professor professorid;

    public Event(int id, String name, DayOfWeek dayOfWeek, LocalTime startTime, LocalTime endTime, String uc, Classroom classroom, SchoolClass classes,Professor professorid) {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public String getUc() {
        return uc;
    }

    public void setUc(String uc) {
        this.uc = uc;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }

    public SchoolClass getClasses() {
        return classes;
    }

    public void setClasses(SchoolClass classes) {
        this.classes = classes;
    }

    public Professor getProfessorid() {
        return professorid;
    }

    public void setProfessorid(Professor professorid) {
        this.professorid = professorid;
    }
}