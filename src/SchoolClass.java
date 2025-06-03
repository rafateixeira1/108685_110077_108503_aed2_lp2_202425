import java.util.*;

public class SchoolClass {
    private int id;
    private String name;
    private ArrayList<Student> students;
    private ArrayList<Professor> professors;
    private ArrayList<Event> events;
    private ArrayList<Course> courses;

    public SchoolClass(int id, String name, ArrayList<Student> students, ArrayList<Professor> professors, ArrayList<Event> events, ArrayList<Course> courses) {
        this.setId(id);
        this.setName(name);
        this.setStudents(students);
        this.setProfessors(professors);
        this.setEvent(events);
        this.setCourses(courses);
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

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public ArrayList<Professor> getProfessors() {
        return professors;
    }

    public void setProfessors(ArrayList<Professor> professors) {
        this.professors = professors;
    }

    public ArrayList<Event> getEvent() {
        return events;
    }

    public void setEvent(ArrayList<Event> events) {
        this.events = events;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }
}