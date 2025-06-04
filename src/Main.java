import java.time.LocalTime;
import java.time.DayOfWeek;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager();
        DataLoader.populateAll(manager);

        BuildingMap buildingMap = DataLoader.createUniversityMap();

        buildingMap.printGraphInfo();

        buildingMap.printShortestPathByDistance(0, 6);
        buildingMap.printShortestPathByTime(1, 8);
        buildingMap.printShortestPathAvoidingPoints(0, 12, Set.of(2, 11));
        buildingMap.printIsConnected(null);
        buildingMap.printIsConnected(Set.of(2,3,4,7));

        Set<Integer> subgrafo = Set.of(2, 3, 4, 5);

        buildingMap.printIsConnected(subgrafo);

// Calcular o caminho mais curto dentro do subgrafo, evitando os restantes
        int inicio = 2, fim = 5;
        Set<Integer> proibidos = new HashSet<>(buildingMap.getPoints().keySet());
        proibidos.removeAll(subgrafo);
        buildingMap.printShortestPathAvoidingPoints(inicio, fim, proibidos);

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
        //manager.searchRoomsByFloor(2);
        //manager.searchRoomsBySockets(false);

        manager.loadSchoolClassesFromFile("schoolclasses.txt");
        manager.loadEventsFromFile("events.txt");
        manager.loadClassroomsFromFile("rooms.txt");
        manager.loadCoursesFromFile("courses.txt");
        manager.loadProfessorsFromFile("professors.txt");
        manager.loadStudentsFromFile("students.txt");

        manager.loadSchoolClassesFromBinary("schoolclasses_data.bin");
        manager.loadEventsFromBinary("events_data.bin");
        manager.loadClassroomsFromBinary("rooms_data.bin");
        manager.loadCoursesFromBinary("courses_data.bin");
        manager.loadProfessorsFromBinary("professors_data.bin");
        manager.loadStudentsFromBinary("students.bin");

        manager.exportStudentsToFile("students.txt");
        manager.exportProfessorsToFile("professors.txt");
        manager.exportCoursesToFile("courses.txt");
        manager.exportRoomsToFile("rooms.txt");
        manager.exportEventsToFile("events.txt");
        manager.exportSchoolClassesToFile("schoolclasses.txt");
        manager.exportFreeRoomsToFile("freerooms.txt", DayOfWeek.MONDAY, LocalTime.of(9, 0), LocalTime.of(11, 0));
        manager.exportSearchHistory("search_history.txt");

        manager.exportStudentsToBinary("students.bin");
        manager.exportProfessorsToBinary("professors_data.bin");
        manager.exportCoursesToBinary("courses_data.bin");
        manager.exportRoomsToBinary("rooms_data.bin");
        manager.exportEventsToBinary("events_data.bin");
        manager.exportSchoolClassesToBinary("schoolclasses_data.bin");
        manager.exportFreeRoomsToBinary("freerooms_data.bin", DayOfWeek.MONDAY, LocalTime.of(9, 0), LocalTime.of(11, 0));
        manager.exportSearchHistoryBinary("search_history.bin");

    }
}