import java.util.*;

public class Professor extends Person {
    private ArrayList <Course> courses;
    private ArrayList <SchoolClass> SchoolClasses;
    private List <Event> events;

    public Professor(int id, String name, ArrayList<Course> courses, ArrayList<SchoolClass> schoolClasses, List<Event> events) {
        super(id, name);
        this.setCourses(courses);
        setSchoolClasses(schoolClasses);
        this.setEvents(events);
    }

    public Professor(int id, String name) {
        super(id, name);
        setCourses(new ArrayList<>());
        setSchoolClasses(new ArrayList<>());
        setEvents(new ArrayList<>());
    }

    public void addCourse(Course course) {
        if (course != null && !this.getCourses().contains(course)) {
            this.getCourses().add(course);
        }
    }

    public void addSchoolClass(SchoolClass schoolClass) {
        if (schoolClass != null && !this.getSchoolClasses().contains(schoolClass)) {
            this.getSchoolClasses().add(schoolClass);
        }
    }

    public void addEvent(Event event) {
        if (event != null && !this.getEvents().contains(event)) {
            this.getEvents().add(event);
        }
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }

    public ArrayList<SchoolClass> getSchoolClasses() {
        return SchoolClasses;
    }

    public void setSchoolClasses(ArrayList<SchoolClass> schoolClasses) {
        SchoolClasses = schoolClasses;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }
}
