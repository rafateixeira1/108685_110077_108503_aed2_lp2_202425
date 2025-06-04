import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.*;
import edu.princeton.cs.algs4.EdgeWeightedGraph;

/**
 * Classe utilitária responsável por popular e criar dados de exemplo para a aplicação universitária.
 * Fornece métodos para preencher o sistema com estudantes, professores, cursos, turmas, salas, eventos
 * e para criar o mapa do edifício da universidade.
 */
public class DataLoader {

    /**
     * Popula o sistema com estudantes associados às turmas existentes.
     * Cada estudante é criado manualmente e associado à turma correta.
     *
     * @param manager Instância do gerenciador que manipula os dados da universidade.
     */
    public static void populateStudents(Manager manager) {
        // Obter as turmas
        SchoolClass classA = Manager.getSchoolClassById(manager, 20);
        SchoolClass classB = Manager.getSchoolClassById(manager, 21);
        SchoolClass classC = Manager.getSchoolClassById(manager, 22);
        SchoolClass classD = Manager.getSchoolClassById(manager, 23);

        // Criar estudantes manualmente e associar à turma correta
        manager.addStudent(new Student(1, "Student 1", classA));
        manager.addStudent(new Student(2, "Student 2", classA));
        manager.addStudent(new Student(3, "Student 3", classA));
        manager.addStudent(new Student(4, "Student 4", classA));
        manager.addStudent(new Student(5, "Student 5", classA));

        manager.addStudent(new Student(6, "Student 6", classB));
        manager.addStudent(new Student(7, "Student 7", classB));
        manager.addStudent(new Student(8, "Student 8", classB));
        manager.addStudent(new Student(9, "Student 9", classB));
        manager.addStudent(new Student(10, "Student 10", classB));

        manager.addStudent(new Student(11, "Student 11", classC));
        manager.addStudent(new Student(12, "Student 12", classC));
        manager.addStudent(new Student(13, "Student 13", classC));
        manager.addStudent(new Student(14, "Student 14", classC));
        manager.addStudent(new Student(15, "Student 15", classC));

        manager.addStudent(new Student(16, "Student 16", classD));
        manager.addStudent(new Student(17, "Student 17", classD));
        manager.addStudent(new Student(18, "Student 18", classD));
        manager.addStudent(new Student(19, "Student 19", classD));
        manager.addStudent(new Student(20, "Student 20", classD));
    }

    /**
     * Popula o sistema com professores associados aos cursos e turmas existentes.
     * Cada professor é criado manualmente e associado aos cursos e turmas corretos.
     *
     * @param manager Instância do gerenciador que manipula os dados da universidade.
     */
    public static void populateProfessors(Manager manager) {
        // Obter cursos
        Course oop = Manager.getCourseById(manager, 10);
        Course dsa2 = Manager.getCourseById(manager, 11);
        Course db = Manager.getCourseById(manager, 12);
        Course os = Manager.getCourseById(manager, 13);
        Course poo = Manager.getCourseById(manager, 14);
        Course office = Manager.getCourseById(manager, 15);

        // Obter turmas
        SchoolClass classA = Manager.getSchoolClassById(manager, 20);
        SchoolClass classB = Manager.getSchoolClassById(manager, 21);
        SchoolClass classC = Manager.getSchoolClassById(manager, 22);
        SchoolClass classD = Manager.getSchoolClassById(manager, 23);

        // Professor 100
        Professor profA = new Professor(100, "Professor A");
        profA.addCourse(oop);
        profA.addCourse(dsa2);
        profA.addSchoolClass(classA);
        profA.addSchoolClass(classB);
        manager.addProfessor(profA);

        // Professor 101
        Professor profB = new Professor(101, "Professor B");
        profB.addCourse(dsa2);
        profB.addCourse(db);
        profB.addSchoolClass(classB);
        profB.addSchoolClass(classC);
        manager.addProfessor(profB);

        // Professor 102
        Professor profC = new Professor(102, "Professor C");
        profC.addCourse(db);
        profC.addCourse(os);
        profC.addSchoolClass(classC);
        profC.addSchoolClass(classD);
        manager.addProfessor(profC);

        // Professor 103
        Professor profD = new Professor(103, "Professor D");
        profD.addCourse(os);
        profD.addCourse(poo);
        profD.addSchoolClass(classD);
        profD.addSchoolClass(classA);
        manager.addProfessor(profD);

        // Professor 104
        Professor profE = new Professor(104, "Professor E");
        profE.addCourse(poo);
        profE.addCourse(oop);
        profE.addSchoolClass(classA);
        profE.addSchoolClass(classC);
        manager.addProfessor(profE);
    }

    /**
     * Popula o sistema com cursos disponíveis na universidade.
     * Cada curso é criado manualmente e adicionado ao gerenciador.
     *
     * @param manager Instância do gerenciador que manipula os dados da universidade.
     */
    public static void populateCourses(Manager manager) {
        manager.addCourse(new Course(10, "OOP"));
        manager.addCourse(new Course(11, "DSA2"));
        manager.addCourse(new Course(12, "DB"));
        manager.addCourse(new Course(13, "OS"));
        manager.addCourse(new Course(14, "POO"));
        manager.addCourse(new Course(15, "OfficeHours"));
    }

    /**
     * Popula o sistema com turmas disponíveis na universidade.
     * Cada turma é criada manualmente e adicionada ao gerenciador.
     *
     * @param manager Instância do gerenciador que manipula os dados da universidade.
     */
    public static void populateSchoolClasses(Manager manager) {
        manager.addSchoolClass(new SchoolClass(20, "Class A", new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>()));
        manager.addSchoolClass(new SchoolClass(21, "Class B", new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>()));
        manager.addSchoolClass(new SchoolClass(22, "Class C", new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>()));
        manager.addSchoolClass(new SchoolClass(23, "Class D", new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>()));
    }

    /**
     * Popula o sistema com salas de aula disponíveis na universidade.
     * Cada sala é criada manualmente e adicionada ao gerenciador.
     *
     * @param manager Instância do gerenciador que manipula os dados da universidade.
     */
    public static void populateRooms(Manager manager) {
        manager.addRoom(new Classroom(300, new ArrayList<>(), true, 1));
        manager.addRoom(new Classroom(301, new ArrayList<>(), false, 1));
        manager.addRoom(new Classroom(302, new ArrayList<>(), true, 2));
        manager.addRoom(new Classroom(303, new ArrayList<>(), false, 2));
        manager.addRoom(new Classroom(304, new ArrayList<>(), true, 3));
        manager.addRoom(new Classroom(305, new ArrayList<>(), false, 3));
    }

    /**
     * Popula o sistema com eventos associados às salas, turmas e professores.
     * Cada evento é criado com informações de horário, dia da semana e associado a um curso, sala, turma e professor.
     *
     * @param manager Instância do gerenciador que manipula os dados da universidade.
     */
    public static void populateEvents(Manager manager) {
        List<SchoolClass> classes = new ArrayList<>();
        for (int i = 20; i < 24; i++) {
            classes.add(Manager.getSchoolClassById(manager, i));
        }
        List<Classroom> rooms = new ArrayList<>();
        for (int i = 300; i < 306; i++) {
            rooms.add(Manager.getRoomById(manager, i));
        }
        List<Professor> professors = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            professors.add(Manager.getProfessorById(manager, 100 + i));
        }
        String[] courses = {"OOP", "DSA2", "DB", "OS", "POO"};
        int eventId = 500;
        for (Classroom room : rooms) {
            for (DayOfWeek day : DayOfWeek.values()) {
                if (day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY) continue;
                for (int e = 0; e < 3; e++) {
                    int courseIdx = (room.getId() + day.getValue() + e) % courses.length;
                    int classIdx = (room.getId() + day.getValue() + e) % classes.size();
                    int profIdx = (room.getId() + day.getValue() + e) % professors.size();
                    LocalTime start = LocalTime.of(8 + e * 2, 0);
                    LocalTime end = start.plusHours(1).plusMinutes(30);
                    manager.addEvent(new Event(eventId++, "Class " + courses[courseIdx], day, start, end, courses[courseIdx], room, classes.get(classIdx), professors.get(profIdx)));
                }
                int profIdx = (room.getId() + day.getValue()) % professors.size();
                manager.addEvent(new Event(eventId++, "Office Hours " + professors.get(profIdx).getName(), day, LocalTime.of(15, 0), LocalTime.of(16, 0), "OfficeHours", room, null, professors.get(profIdx)));
            }
        }
    }

    /**
     * Cria um mapa representando o edifício da universidade.
     * O mapa inclui pontos de interesse como entradas, corredores, salas e escadas,
     * e define as conexões entre eles usando arestas ponderadas.
     *
     * @return Um objeto BuildingMap contendo o grafo do edifício e os pontos de interesse.
     */
    public static BuildingMap createUniversityMap() {
        Map<Integer, MapPoint> points = new HashMap<>();
        int id = 0;

        // Exterior
        points.put(id, new MapPoint(id, 0, 0, "gate", "University gate", false)); // 0
        int gate = id++;
        points.put(id, new MapPoint(id, 30, 0, "entrance", "Building entrance", true)); // 1
        int entrance = id++;

        // Hall floor 0
        points.put(id, new MapPoint(id, 35, 0, "hall", "Entrance hall", true)); // 2
        int hall = id++;
        points.put(id, new MapPoint(id, 40, 0, "stairs", "Stairs to floor 1", true)); // 3
        int stairs = id++;

        // Stairs landing (intermediate point)
        points.put(id, new MapPoint(id, 40, 3, "stairsLanding", "Stairs landing", true)); // 4
        int stairsLanding = id++;

        // Floor 1 - U corridor
        points.put(id, new MapPoint(id, 40, 5, "corridor", "Start of U corridor", true)); // 5
        int corridorStart = id++;

        // Left side of U (4 rooms)
        int[] leftRooms = new int[4];
        for (int i = 0; i < 4; i++) {
            points.put(id, new MapPoint(id, 40, 8 + i * 3, "door", "Room " + (i+1) + " (left)", true));
            leftRooms[i] = id++;
        }

        // Base of U
        points.put(id, new MapPoint(id, 40, 20, "corridor", "Base of U", true)); // 10
        int baseU = id++;

        // Right side of U (4 rooms)
        int[] rightRooms = new int[4];
        for (int i = 0; i < 4; i++) {
            points.put(id, new MapPoint(id, 43, 20 - i * 3, "door", "Room " + (i+1) + " (right)", true));
            rightRooms[i] = id++;
        }

        // End of U (top right)
        points.put(id, new MapPoint(id, 43, 5, "corridor", "End of U corridor", true)); // 15
        int corridorEnd = id++;

        // Exterior stairs left (20m from entrance)
        points.put(id, new MapPoint(id, 20, 0, "stairs", "Left exterior stairs", false));
        int extStairsLeft = id++;
        // Exterior stairs right (20m from entrance, y=5 to match U top)
        points.put(id, new MapPoint(id, 20, 5, "stairs", "Right exterior stairs", false));
        int extStairsRight = id++;

        // Create graph
        EdgeWeightedGraph graph = new EdgeWeightedGraph(points.size());

        // Exterior and hall edges
        graph.addEdge(new MapEdge(gate, entrance, 30, 36, "exterior"));
        graph.addEdge(new MapEdge(entrance, hall, 5, 9, "interior"));
        graph.addEdge(new MapEdge(hall, stairs, 5, 9, "interior"));

        // Stairs to landing
        graph.addEdge(new MapEdge(stairs, stairsLanding, 3, 6, "stairs"));

        // Landing to base of U
        graph.addEdge(new MapEdge(stairsLanding, baseU, 2, 4, "corridor"));

        // Landing to corridor start (optional, if direct access exists)
        graph.addEdge(new MapEdge(stairsLanding, corridorStart, 2, 4, "corridor"));

        // Landing to first left and right room
        graph.addEdge(new MapEdge(stairsLanding, leftRooms[0], 4, 8, "corridor"));
        graph.addEdge(new MapEdge(stairsLanding, rightRooms[0], 4, 8, "corridor"));

        // Left side of U
        graph.addEdge(new MapEdge(baseU, leftRooms[3], 3, 5, "corridor"));
        for (int i = 3; i > 0; i--) {
            graph.addEdge(new MapEdge(leftRooms[i], leftRooms[i-1], 3, 5, "corridor"));
        }
        graph.addEdge(new MapEdge(leftRooms[0], corridorStart, 3, 5, "corridor"));

        // Base of U to right side
        graph.addEdge(new MapEdge(baseU, rightRooms[0], 3, 5, "corridor"));
        for (int i = 0; i < 3; i++) {
            graph.addEdge(new MapEdge(rightRooms[i], rightRooms[i+1], 3, 5, "corridor"));
        }
        graph.addEdge(new MapEdge(rightRooms[3], corridorEnd, 3, 5, "corridor"));

        // Close the U
        graph.addEdge(new MapEdge(corridorEnd, corridorStart, 5, 9, "corridor"));

        // Exterior stairs to U tips
        graph.addEdge(new MapEdge(gate, extStairsLeft, 20, 24, "exterior"));
        graph.addEdge(new MapEdge(extStairsLeft, leftRooms[0], 8, 12, "exterior stairs"));

        graph.addEdge(new MapEdge(gate, extStairsRight, 20, 24, "exterior"));
        graph.addEdge(new MapEdge(extStairsRight, rightRooms[3], 8, 12, "exterior stairs"));

        return new BuildingMap(graph, points);
    }

    /**
     * Popula todos os dados necessários para a aplicação universitária.
     * Chama métodos para preencher cursos, turmas, salas, estudantes, professores e eventos.
     *
     * @param manager Instância do gerenciador que manipula os dados da universidade.
     */
    public static void populateAll(Manager manager) {
        populateCourses(manager);
        populateSchoolClasses(manager);
        populateRooms(manager);
        populateStudents(manager);
        populateProfessors(manager);
        populateEvents(manager);
    }
}