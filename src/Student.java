import java.util.*;

public class Student extends Person {
    private SchoolClass schoolClass;
    private ArrayList<Course> courses;

    public Student(int id, String name, SchoolClass schoolClass, ArrayList<Course> courses) {
        super(id, name);
        this.setSchoolClass(schoolClass);
        this.setCourses(courses);
    }

    public Student(int id, String name, SchoolClass schoolClass) {
        this(id, name, schoolClass, new ArrayList<>());
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }

    public SchoolClass getSchoolClass() {
        return schoolClass;
    }

    public void setSchoolClass(SchoolClass schoolClass) {
        this.schoolClass = schoolClass;
    }
}