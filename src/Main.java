import java.time.LocalTime;
import java.time.DayOfWeek;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager();
        DataLoader.populateAll(manager);

        //manager.listStudents();
        //manager.ListProfs();
        //manager.listCourses();
        //manager.listRooms();
        //manager.listEvents();
        //manager.listSchoolClasses();
        //manager.listFreeRooms(DayOfWeek.MONDAY, LocalTime.of(9, 0), LocalTime.of(11, 0));
        //List<String> cursos = Arrays.asList("LP2", "AED2");
        //manager.printProfessorsByCourses(cursos);
        //manager.printSchoolClassesByProfessor(100);
        //manager.printSchoolClassesByProfessor(101);
        //manager.listAvailableOfficeHours(1,100);
        manager.searchRoomsByFloor(2);
        manager.searchRoomsBySockets(false);
    }
}