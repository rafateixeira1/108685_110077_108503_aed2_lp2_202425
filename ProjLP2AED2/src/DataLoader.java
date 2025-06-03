import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;

public class DataLoader {

    public static void populateStudents(Manager manager) {
        populateSchoolClasses(manager);

        // Usar o método estático da classe Manager
        manager.addStudent(new Student(1, "Ana Silva", Manager.getSchoolClassById(manager, 20)));
        manager.addStudent(new Student(2, "Bruno Costa", Manager.getSchoolClassById(manager, 20)));
        manager.addStudent(new Student(3, "Carla Martins", Manager.getSchoolClassById(manager, 21)));
    }

    public static void populateProfessors(Manager manager) {
        Course lp2 = Manager.getCourseById(manager, 10);
        Course aed2 = Manager.getCourseById(manager, 11);
        SchoolClass turmaA = Manager.getSchoolClassById(manager, 20);
        SchoolClass turmaB = Manager.getSchoolClassById(manager, 21);
        Professor A = new Professor(101, "Dra. Joana Lima");
        Professor B = new Professor(100, "Dr. Rui Moreira");
        A.addCourse(lp2);
        A.addSchoolClass(turmaA);
        A.addSchoolClass(turmaB);
        B.addCourse(aed2);
        B.addSchoolClass(turmaA);

        manager.addProfessor(A);
        manager.addProfessor(B);
    }

    public static void populateCourses(Manager manager) {
        manager.addCourse(new Course(10, "LP2"));
        manager.addCourse(new Course(11, "AED2"));
        manager.addCourse(new Course(99, "Atendimento"));
    }

    public static void populateSchoolClasses(Manager manager) {
        manager.addSchoolClass(new SchoolClass(20, "Turma A", new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>()));
        manager.addSchoolClass(new SchoolClass(21, "Turma B", new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>()));
    }

    public static void populateRooms(Manager manager) {
        // Criar salas apenas com id e lista de eventos
        manager.addRoom(new Classroom(300, new ArrayList<>()));
        manager.addRoom(new Classroom(301, new ArrayList<>()));
        manager.addRoom(new Classroom(302, new ArrayList<>()));
    }

    public static void populateEvents(Manager manager) {
        // Obter uma turma e uma sala existentes usando os métodos estáticos
        SchoolClass turmaA = Manager.getSchoolClassById(manager, 20);
        SchoolClass turmaB = Manager.getSchoolClassById(manager, 21);
        Classroom sala = Manager.getRoomById(manager, 300);
        Professor professor = Manager.getProfessorById(manager, 100);
        Professor professor2 = Manager.getProfessorById(manager, 101);

        // Criar evento com todos os parâmetros necessários
        manager.addEvent(new Event(500, "Aula LP2", DayOfWeek.MONDAY,
                LocalTime.of(10, 0), LocalTime.of(12, 0),
                "LP2", sala, turmaA, professor));

        manager.addEvent(new Event(501, "Aula AED2", DayOfWeek.MONDAY,
                LocalTime.of(12, 30), LocalTime.of(14, 0),
                "AED2", sala, turmaB, professor2));

        manager.addEvent(new Event(600, "Atendimento Prof. Rui", DayOfWeek.TUESDAY,
                LocalTime.of(14, 0), LocalTime.of(15, 0),
                "Atendimento", sala, null, professor));
    }

    public static void populateAll(Manager manager) {
        populateCourses(manager);
        populateSchoolClasses(manager);
        populateRooms(manager);
        populateStudents(manager);
        populateProfessors(manager);
        populateEvents(manager);
    }
}