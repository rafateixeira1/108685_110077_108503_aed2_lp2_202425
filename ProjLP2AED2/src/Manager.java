import java.time.LocalDateTime;
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
        int classId = student.getSchoolClassId();
        if (stSchoolClasses.contains(classId)) {
            SchoolClass schoolClass = stSchoolClasses.get(classId);
            schoolClass.getStudents().add(student);
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
        int classId = student.getSchoolClassId();
        if (stSchoolClasses.contains(classId)) {
            SchoolClass schoolClass = stSchoolClasses.get(classId);
            ArrayList<Student> students = schoolClass.getStudents();
            students.remove(student);
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

    public boolean editSchoolClass(int id, SchoolClass schoolClass) {
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
    }

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
        }
    }

    public boolean addEvent(Event event) {
        int id = event.getId();
        if (RBEvent.contains(id)) {
            System.out.println("Event already exists");
            return false;
        }
        RBEvent.put(id, event);
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

    public void listRooms() {
        System.out.println("Room list:");
        for (Integer id : RBRoom.keys()) {
            Classroom room = RBRoom.get(id);
            System.out.println("ID: " + id + ", Turma: " + (room.getTurma() != null ? room.getTurma().getName() : "Sem turma"));
        }
    }
}

