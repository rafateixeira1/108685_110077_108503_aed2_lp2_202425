import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.*;

public class DataLoader {

    public static void populateStudents(Manager manager) {
        // 4 turmas
        for (int turmaId = 20; turmaId < 24; turmaId++) {
            for (int i = 1; i <= 5; i++) {
                int studentId = (turmaId - 20) * 5 + i;
                manager.addStudent(new Student(studentId, "Aluno " + studentId, Manager.getSchoolClassById(manager, turmaId)));
            }
        }
    }

    public static void populateProfessors(Manager manager) {
        List<Course> courses = new ArrayList<>();
        for (int i = 10; i < 16; i++) {
            courses.add(Manager.getCourseById(manager, i));
        }
        for (int i = 0; i < 5; i++) {
            Professor prof = new Professor(100 + i, "Professor " + (char)('A' + i));
            prof.addCourse(courses.get(i));
            prof.addCourse(courses.get((i + 1) % courses.size()));
            prof.addSchoolClass(Manager.getSchoolClassById(manager, 20 + i % 4));
            prof.addSchoolClass(Manager.getSchoolClassById(manager, 20 + (i + 1) % 4));
            manager.addProfessor(prof);
        }
    }

    public static void populateCourses(Manager manager) {
        manager.addCourse(new Course(10, "LP2"));
        manager.addCourse(new Course(11, "AED2"));
        manager.addCourse(new Course(12, "BD"));
        manager.addCourse(new Course(13, "SO"));
        manager.addCourse(new Course(14, "POO"));
        manager.addCourse(new Course(15, "Atendimento"));
    }

    public static void populateSchoolClasses(Manager manager) {
        manager.addSchoolClass(new SchoolClass(20, "Turma A", new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>()));
        manager.addSchoolClass(new SchoolClass(21, "Turma B", new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>()));
        manager.addSchoolClass(new SchoolClass(22, "Turma C", new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>()));
        manager.addSchoolClass(new SchoolClass(23, "Turma D", new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>()));
    }

    public static void populateRooms(Manager manager) {
        manager.addRoom(new Classroom(300, new ArrayList<>(), true, 1));
        manager.addRoom(new Classroom(301, new ArrayList<>(), false, 1));
        manager.addRoom(new Classroom(302, new ArrayList<>(), true, 2));
        manager.addRoom(new Classroom(303, new ArrayList<>(), false, 2));
        manager.addRoom(new Classroom(304, new ArrayList<>(), true, 3));
        manager.addRoom(new Classroom(305, new ArrayList<>(), false, 3));
    }

    public static void populateEvents(Manager manager) {
        List<SchoolClass> turmas = new ArrayList<>();
        for (int i = 20; i < 24; i++) {
            turmas.add(Manager.getSchoolClassById(manager, i));
        }
        List<Classroom> salas = new ArrayList<>();
        for (int i = 300; i < 306; i++) {
            salas.add(Manager.getRoomById(manager, i));
        }
        List<Professor> profs = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            profs.add(Manager.getProfessorById(manager, 100 + i));
        }
        String[] ucs = {"LP2", "AED2", "BD", "SO", "POO"};
        int eventId = 500;
        for (Classroom sala : salas) {
            for (DayOfWeek day : DayOfWeek.values()) {
                if (day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY) continue;
                for (int e = 0; e < 3; e++) {
                    int ucIdx = (sala.getId() + day.getValue() + e) % ucs.length;
                    int turmaIdx = (sala.getId() + day.getValue() + e) % turmas.size();
                    int profIdx = (sala.getId() + day.getValue() + e) % profs.size();
                    LocalTime start = LocalTime.of(8 + e * 2, 0);
                    LocalTime end = start.plusHours(1).plusMinutes(30);
                    manager.addEvent(new Event(eventId++, "Aula " + ucs[ucIdx], day, start, end, ucs[ucIdx], sala, turmas.get(turmaIdx), profs.get(profIdx)));
                }
                int profIdx = (sala.getId() + day.getValue()) % profs.size();
                manager.addEvent(new Event(eventId++, "Atendimento " + profs.get(profIdx).getName(), day, LocalTime.of(15, 0), LocalTime.of(16, 0), "Atendimento", sala, null, profs.get(profIdx)));
            }
        }
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