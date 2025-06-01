import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

public class DataLoader {

    public static void populateStudents(Manager manager) {
        manager.addStudent(new Student(1, "Ana Silva", 20));
        manager.addStudent(new Student(2, "Bruno Costa", 20));
        manager.addStudent(new Student(3, "Carla Martins", 21));
    }

    public static void populateProfessors(Manager manager) {
        manager.addProfessor(new Professor(100, "Dr. Rui Moreira", new ArrayList<>(), new ArrayList<>()));
        manager.addProfessor(new Professor(101, "Dra. Joana Lima", new ArrayList<>(), new ArrayList<>()));
    }

    public static void populateCourses(Manager manager) {
        manager.addCourse(new Course(10, "LP2"));
        manager.addCourse(new Course(11, "AED2"));
    }

    public static void populateSchoolClasses(Manager manager) {
        manager.addSchoolClass(new SchoolClass(20, "Turma A", new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>()));
        manager.addSchoolClass(new SchoolClass(21, "Turma B", new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>()));
    }

    public static void populateRooms(Manager manager) {
        SchoolClass turmaA = new SchoolClass(20, "Turma A", new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        SchoolClass turmaB = new SchoolClass(21, "Turma B", new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        manager.addRoom(new Classroom(300, turmaA, new ArrayList<>()));
        manager.addRoom(new Classroom(301, turmaB, new ArrayList<>()));
        manager.addRoom(new Classroom(302, null, new ArrayList<>()));
    }

    public static void populateEvents(Manager manager) {
        SchoolClass turmaA = new SchoolClass(20, "Turma A", new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        Classroom sala = new Classroom(300, turmaA, new ArrayList<>());
        manager.addEvent(new Event(500, "Aula LP2", DayOfWeek.MONDAY, LocalTime.of(9, 0), LocalTime.of(11, 0), "LP2", sala, turmaA.getId()));
    }

    public static void populateAll(Manager manager) {
        populateStudents(manager);
        populateProfessors(manager);
        populateCourses(manager);
        populateSchoolClasses(manager);
        populateRooms(manager);
        populateEvents(manager);
    }
}