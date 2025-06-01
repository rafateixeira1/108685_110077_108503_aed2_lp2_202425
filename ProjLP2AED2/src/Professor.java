import java.util.*;

public class Professor extends Person {
    private ArrayList <Course> courses;
    private List <Event> events;

    public Professor(int id, String name, ArrayList<Course> courses, List<Event> events) {
        super(id, name);
        this.setCourses(courses);
        this.setEvents(events);
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }
}
