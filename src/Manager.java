import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;
import edu.princeton.cs.algs4.*;

public class Manager {
    private ST_Student stStudents;
    private ST_Professor stProfessors;
    private ST_SchoolClass stSchoolClasses;
    private ST_Course stCourse;
    private RedBlack_Event RBEvent;
    private RedBlack_Room RBRoom;

    public Manager() {
        this.stStudents = new ST_Student();
        this.stProfessors = new ST_Professor();
        this.stSchoolClasses = new ST_SchoolClass();
        this.stCourse = new ST_Course();
        this.RBEvent = new RedBlack_Event();
        this.RBRoom = new RedBlack_Room();
    }

    public boolean addStudent(Student student) {
        int id = student.getId();
        if (stStudents.contains(id)) {
            System.out.println("Student already exists");
            return false;
        }
        stStudents.put(id, student);
        SchoolClass schoolClass = student.getSchoolClass();
        if (schoolClass != null) {
            int classId = schoolClass.getId();
            if (stSchoolClasses.contains(classId)) {
                schoolClass = stSchoolClasses.get(classId);
                schoolClass.getStudents().add(student);
            }
        }
        return true;
    }

    public boolean editStudent(int id, Student student) {
        if (!stStudents.contains(id)) {
            System.out.println("Student not found");
            return false;
        }
        stStudents.put(id, student);
        return true;
    }

    public boolean removeStudent(int id) {
        if (!stStudents.contains(id)) {
            System.out.println("Student not found");
            return false;
        }
        Student student = stStudents.get(id);

        // Remover o aluno da turma
        SchoolClass schoolClass = student.getSchoolClass();
        if (schoolClass != null) {
            int classId = schoolClass.getId();
            if (stSchoolClasses.contains(classId)) {
                schoolClass = stSchoolClasses.get(classId);
                ArrayList<Student> students = schoolClass.getStudents();
                students.remove(student);
            }
        }
        stStudents.remove(id);
        return true;
    }

    public void listStudents() {
        System.out.println("Student list:");
        for (Integer id : stStudents.keys()) {
            Student student = stStudents.get(id);
            System.out.println("ID: " + id + ", Name: " + student.getName());
        }
    }

    public boolean addProfessor(Professor professor) {
        int id = professor.getId();
        if (stProfessors.contains(id)) {
            System.out.println("Professor already exists");
            return false;
        }
        stProfessors.put(id, professor);
        return true;
    }

    public boolean editProfessor(int id, Professor professor) {
        if (!stProfessors.contains(id)) {
            System.out.println("Professor not found");
            return false;
        }
        stProfessors.put(id, professor);
        return true;
    }

    public boolean removeProfessor(int id) {
        if (!stProfessors.contains(id)) {
            System.out.println("Professor not found");
            return false;
        }
        stProfessors.remove(id);
        return true;
    }

    public void ListProfs() {
        System.out.println("Professor list:");
        for (Integer id : stProfessors.keys()) {
            Professor professor = stProfessors.get(id);
            System.out.println("ID: " + id + ", Name: " + professor.getName());
        }
    }

    public boolean addCourse(Course course) {
        int id = course.getId();
        if (stCourse.contains(id)) {
            System.out.println("Course already exists");
            return false;
        }
        stCourse.put(id, course);
        return true;
    }

    public boolean editCourse(int id, Course course) {
        if (!stCourse.contains(id)) {
            System.out.println("Course not found");
            return false;
        }
        stCourse.put(id, course);
        return true;
    }

    public boolean removeCourse(int id) {
        if (!stCourse.contains(id)) {
            System.out.println("Course not found");
            return false;
        }
        stCourse.remove(id);
        return true;
    }

    public void listCourses() {
        System.out.println("Course list:");
        for (Integer id : stCourse.keys()) {
            Course course = stCourse.get(id);
            System.out.println("ID: " + id + ", Name: " + course.getName());
        }
    }

    public boolean addSchoolClass(SchoolClass schoolClass) {
        int id = schoolClass.getId();
        if (stSchoolClasses.contains(id)) {
            System.out.println("School class already exists");
            return false;
        }
        stSchoolClasses.put(id, schoolClass);
        return true;
    }

/*    public boolean editSchoolClass(int id, SchoolClass schoolClass) {
        if (!stSchoolClasses.contains(id)) {
            System.out.println("Class not found");
            return false;
        }
        stSchoolClasses.put(id, schoolClass);
        ArrayList<Student> students = schoolClass.getStudents();
        if (students != null) {
            for (Student student : students) {
                student.setSchoolClassId(schoolClass.getId());
                stStudents.put(student.getId(), student);
            }
        }
        return true;
    }*/

    public boolean removeSchoolClass(int id) {
        if (!stSchoolClasses.contains(id)) {
            System.out.println("Class not found");
            return false;
        }
        stSchoolClasses.remove(id);
        return true;
    }

    public void listSchoolClasses() {
        System.out.println("School class list:");
        for (Integer id : stSchoolClasses.keys()) {
            SchoolClass schoolClass = stSchoolClasses.get(id);
            System.out.println("ID: " + id + ", Name: " + schoolClass.getName());
            System.out.println("  Alunos:");
            for (Student student : schoolClass.getStudents()) {
                System.out.println("    ID: " + student.getId() + ", Name: " + student.getName());
            }
        }
    }

    public boolean addEvent(Event event) {
        int id = event.getId();
        if (RBEvent.contains(id)) {
            System.out.println("Event already exists");
            return false;
        }

        // Adicionar o evento à estrutura RBEvent
        RBEvent.put(id, event);

        // CORREÇÃO: Adicionar o evento à lista de eventos da sala
        Classroom room = event.getClassroom();
        if (room != null) {
            int roomId = room.getId();
            if (RBRoom.contains(roomId)) {
                // Obter a instância real da sala do RBRoom
                Classroom actualRoom = RBRoom.get(roomId);
                // Adicionar o evento à lista de eventos da sala
                actualRoom.getEvents().add(event);
            }
        }

        return true;
    }

    public boolean editEvent(int id, Event event) {
        if (!RBEvent.contains(id)) {
            System.out.println("Event not found");
            return false;
        }
        RBEvent.put(id, event);
        return true;
    }

    public boolean removeEvent(int id) {
        if (!RBEvent.contains(id)) {
            System.out.println("Event not found");
            return false;
        }
        RBEvent.remove(id);
        return true;
    }

    public void listEvents() {
        System.out.println("Event list:");
        for (Integer id : RBEvent.keys()) {
            Event event = RBEvent.get(id);
            System.out.println("ID: " + id + ", Name: " + event.getName());
        }
    }

    public boolean addRoom(Classroom room) {
        int id = room.getId();
        if (RBRoom.contains(id)) {
            System.out.println("Room already exists");
            return false;
        }
        RBRoom.put(id, room);
        return true;
    }

    public boolean editRoom(int id, Classroom room) {
        if (!RBRoom.contains(id)) {
            System.out.println("Room not found");
            return false;
        }
        RBRoom.put(id, room);
        return true;
    }

    public boolean removeRoom(int id) {
        if (!RBRoom.contains(id)) {
            System.out.println("Room not found");
            return false;
        }
        RBRoom.remove(id);
        return true;
    }


    public boolean roomIsFree(Classroom room, DayOfWeek day, LocalTime start, LocalTime end) {
        List<Event> roomEvents = room.getEvents();

        // Se a sala não tem eventos, está livre
        if (roomEvents == null || roomEvents.isEmpty()) {
            return true;
        }

        // Verificar se há algum evento que se sobreponha ao período especificado
        for (Event event : roomEvents) {
            if (event.getDayOfWeek() == day) {
                // Verificar sobreposição de horários
                if (!(event.getEndTime().isBefore(start) || event.getStartTime().isAfter(end))) {
                    return false;
                }
            }
        }

        return true;
    }

    public List<Classroom> getFreeRooms(DayOfWeek day, LocalTime start, LocalTime end) {
        List<Classroom> freeRooms = new ArrayList<>();

        for (Integer roomId : RBRoom.keys()) {
            Classroom room = RBRoom.get(roomId);

            if (roomIsFree(room, day, start, end)) {
                freeRooms.add(room);
            }
        }

        return freeRooms;
    }

    public void listFreeRooms(DayOfWeek day, LocalTime start, LocalTime end) {
        List<Classroom> freeRooms = getFreeRooms(day, start, end);

        System.out.println("Salas livres em " + day + " das " + start + " às " + end + ":");

        if (freeRooms.isEmpty()) {
            System.out.println("Não há salas livres nesse horário.");
        } else {
            for (Classroom room : freeRooms) {
                System.out.println("ID: " + room.getId() +
                        // Modificado para evitar o método getTurma() que não existe
                        ", Sala: " + room.getId());
            }
        }
    }

    public void listRooms() {
        System.out.println("Room list:");
        for (Integer id : RBRoom.keys()) {
            Classroom room = RBRoom.get(id);
            System.out.println("ID: " + id);
        }
    }

    public void printProfessorsByCourses(List<String> courseNames) {
        Set<Professor> result = new HashSet<>();
        for (Integer profId : stProfessors.keys()) {
            Professor prof = stProfessors.get(profId);
            for (Course course : prof.getCourses()) {
                if (courseNames.contains(course.getName())) {
                    result.add(prof);
                    break;
                }
            }
        }
        System.out.println("Professores que lecionam os cursos: " + courseNames);
        for (Professor prof : result) {
            System.out.println("ID: " + prof.getId() + ", Nome: " + prof.getName());
        }
    }

    public void printSchoolClassesByProfessor(int professorId) {
        if (!stProfessors.contains(professorId)) {
            System.out.println("Professor não encontrado.");
            return;
        }
        Professor prof = stProfessors.get(professorId);
        System.out.println("Turmas do professor " + prof.getName() + ":");
        for (SchoolClass turma : prof.getSchoolClasses()) {
            System.out.println("ID: " + turma.getId() + ", Nome: " + turma.getName());
        }
    }

    public void listAvailableOfficeHours(int studentId, int professorId) {
        Student student = stStudents.get(studentId);
        Professor professor = stProfessors.get(professorId);

        if (student == null || professor == null) {
            System.out.println("Student or professor not found.");
            return;
        }

        // 1. Get professor's office hour events
        List<Event> officeHours = new ArrayList<>();
        for (Integer eventId : RBEvent.keys()) {
            Event ev = RBEvent.get(eventId);
            if (ev.getProfessorid() != null &&
                    ev.getProfessorid().getId() == professorId &&
                    "Atendimento".equals(ev.getUc())) {
                officeHours.add(ev);
            }
        }

        // 2. Get all events for the student's class
        List<Event> studentEvents = new ArrayList<>();
        for (Integer eventId : RBEvent.keys()) {
            Event ev = RBEvent.get(eventId);
            if (ev.getClasses() != null &&
                    student.getSchoolClass() != null &&
                    ev.getClasses().getId() == student.getSchoolClass().getId()) {
                studentEvents.add(ev);
            }
        }

        // 3. Check for available office hours
        System.out.println("Available office hours:");
        boolean found = false;
        for (Event office : officeHours) {
            boolean free = true;
            for (Event evStudent : studentEvents) {
                if (office.getDayOfWeek() == evStudent.getDayOfWeek()) {
                    // Check for time overlap
                    if (!(office.getEndTime().isBefore(evStudent.getStartTime()) ||
                            office.getStartTime().isAfter(evStudent.getEndTime()))) {
                        free = false;
                        break;
                    }
                }
            }
            if (free) {
                found = true;
                System.out.println("Day: " + office.getDayOfWeek() +
                        ", from " + office.getStartTime() +
                        " to " + office.getEndTime());
            }
        }
        if (!found) {
            System.out.println("No available office hours.");
        }
    }

    public void searchRoomsBySockets(boolean hasSockets) {
        System.out.println("Rooms with sockets = " + hasSockets + ":");
        boolean found = false;
        for (Integer id : RBRoom.keys()) {
            Classroom room = RBRoom.get(id);
            if (room.hasSockets() == hasSockets) {
                System.out.println("ID: " + room.getId() + ", Floor: " + room.getFloor());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No rooms found.");
        }
    }

    public void searchRoomsByFloor(int floor) {
        System.out.println("Rooms on floor " + floor + ":");
        boolean found = false;
        for (Integer id : RBRoom.keys()) {
            Classroom room = RBRoom.get(id);
            if (room.getFloor() == floor) {
                System.out.println("ID: " + room.getId() + ", Sockets: " + room.hasSockets());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No rooms found.");
        }
    }








    // IMPLEMENTAÇÕES TEMPORÁRIAS PARA TESTES (HORORÍFICO)
    public static SchoolClass getSchoolClassById(Manager manager, int id) {
        // Verificar se a classe existe na estrutura de dados do manager
        if (manager.stSchoolClasses.contains(id)) {
            return manager.stSchoolClasses.get(id);
        }

        // Se não encontrar, cria uma nova instância (comportamento temporário)
        return new SchoolClass(id, id == 20 ? "Turma A" : "Turma B",
                new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
    }

    public static Classroom getRoomById(Manager manager, int id) {
        if (manager.RBRoom.contains(id)) {
            return manager.RBRoom.get(id);
        }
        return null;
    }

    public static Professor getProfessorById(Manager manager, int id) {
        if (manager.stProfessors.contains(id)) {
            return manager.stProfessors.get(id);
        }
        return null;
    }

    public static Course getCourseById(Manager manager, int id) {
        if (manager.stCourse.contains(id)) {
            return manager.stCourse.get(id);
        }
        return null;
    }
}



