import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;
import edu.princeton.cs.algs4.*;
import java.io.*;

/**
 * Classe responsável pela gestão central dos dados da aplicação universitária.
 * Gerencia estudantes, professores, turmas, cursos, salas, eventos e fornece métodos
 * para operações CRUD, importação/exportação de dados e consultas diversas.
 */
public class Manager {
    private ST_Student stStudents;
    private ST_Professor stProfessors;
    private ST_SchoolClass stSchoolClasses;
    private ST_Course stCourse;
    private RedBlack_Event RBEvent;
    private RedBlack_Room RBRoom;

    /**
     * Construtor da classe Manager.
     * Inicializa as estruturas de dados para gerenciar estudantes, professores, turmas, cursos,
     * eventos e salas.
     */
    public Manager() {
        this.stStudents = new ST_Student();
        this.stProfessors = new ST_Professor();
        this.stSchoolClasses = new ST_SchoolClass();
        this.stCourse = new ST_Course();
        this.RBEvent = new RedBlack_Event();
        this.RBRoom = new RedBlack_Room();
    }

    /**
     * Método para adicionar um estudante.
     * Verifica se o estudante já existe, adiciona-o à lista de estudantes e associa-o à turma, se aplicável.
     *
     * @param student O estudante a ser adicionado.
     * @return true se o estudante foi adicionado com sucesso, false se já existia.
     */
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

    /**
     * Método para editar as informações de um estudante.
     * Verifica se o estudante existe, atualiza suas informações e mantém a associação com a turma.
     *
     * @param id      O identificador do estudante a ser editado.
     * @param student O novo objeto Student com as informações atualizadas.
     * @return true se o estudante foi editado com sucesso, false se não foi encontrado.
     */
    public boolean editStudent(int id, Student student) {
        if (!stStudents.contains(id)) {
            System.out.println("Student not found");
            return false;
        }
        stStudents.put(id, student);
        return true;
    }

    /**
     * Método para remover um estudante.
     * Verifica se o estudante existe, remove-o da lista de estudantes e da turma associada, se aplicável.
     *
     * @param id O identificador do estudante a ser removido.
     * @return true se o estudante foi removido com sucesso, false se não foi encontrado.
     */
    public boolean removeStudent(int id) {
        if (!stStudents.contains(id)) {
            System.out.println("Student not found");
            return false;
        }
        Student student = stStudents.get(id);

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

    /**
     * Método para listar todos os estudantes.
     * Exibe o identificador e o nome de cada estudante na lista.
     */
    public void listStudents() {
        System.out.println("Student list:");
        for (Integer id : stStudents.keys()) {
            Student student = stStudents.get(id);
            System.out.println("ID: " + id + ", Name: " + student.getName());
        }
    }

    /**
     * Método para adicionar um professor.
     * Verifica se o professor já existe, adiciona-o à lista de professores e associa-o às turmas, se aplicável.
     *
     * @param professor O professor a ser adicionado.
     * @return true se o professor foi adicionado com sucesso, false se já existia.
     */
    public boolean addProfessor(Professor professor) {
        int id = professor.getId();
        if (stProfessors.contains(id)) {
            System.out.println("Professor already exists");
            return false;
        }
        stProfessors.put(id, professor);
        return true;
    }

    /**
     * Método para editar as informações de um professor.
     * Verifica se o professor existe, atualiza suas informações e mantém a associação com as turmas.
     *
     * @param id        O identificador do professor a ser editado.
     * @param professor O novo objeto Professor com as informações atualizadas.
     * @return true se o professor foi editado com sucesso, false se não foi encontrado.
     */
    public boolean editProfessor(int id, Professor professor) {
        if (!stProfessors.contains(id)) {
            System.out.println("Professor not found");
            return false;
        }
        stProfessors.put(id, professor);
        return true;
    }

    /**
     * Método para remover um professor.
     * Verifica se o professor existe, remove-o da lista de professores e das turmas associadas, se aplicável.
     *
     * @param id O identificador do professor a ser removido.
     * @return true se o professor foi removido com sucesso, false se não foi encontrado.
     */
    public boolean removeProfessor(int id) {
        if (!stProfessors.contains(id)) {
            System.out.println("Professor not found");
            return false;
        }
        Professor professor = stProfessors.get(id);

        for (SchoolClass schoolClass : professor.getSchoolClasses()) {
            schoolClass.getProfessors().remove(professor);
        }

        for (Integer eventId : RBEvent.keys()) {
            Event event = RBEvent.get(eventId);
            if (event.getProfessorid() != null && event.getProfessorid().getId() == id) {
                event.setProfessorid(null);
            }
        }

        stProfessors.remove(id);
        return true;
    }

    /**
     * Método para listar todos os professores.
     * Exibe o identificador e o nome de cada professor na lista.
     */
    public void ListProfs() {
        System.out.println("Professor list:");
        for (Integer id : stProfessors.keys()) {
            Professor professor = stProfessors.get(id);
            System.out.println("ID: " + id + ", Name: " + professor.getName());
        }
    }

    /**
     * Método para adicionar um curso.
     * Verifica se o curso já existe, adiciona-o à lista de cursos e associa-o aos professores e turmas, se aplicável.
     *
     * @param course O curso a ser adicionado.
     * @return true se o curso foi adicionado com sucesso, false se já existia.
     */
    public boolean addCourse(Course course) {
        int id = course.getId();
        if (stCourse.contains(id)) {
            System.out.println("Course already exists");
            return false;
        }
        stCourse.put(id, course);
        return true;
    }

    /**
     * Método para editar as informações de um curso.
     * Verifica se o curso existe, atualiza suas informações e mantém a associação com os professores e turmas.
     *
     * @param id     O identificador do curso a ser editado.
     * @param course O novo objeto Course com as informações atualizadas.
     * @return true se o curso foi editado com sucesso, false se não foi encontrado.
     */
    public boolean editCourse(int id, Course course) {
        if (!stCourse.contains(id)) {
            System.out.println("Course not found");
            return false;
        }
        stCourse.put(id, course);
        return true;
    }

    /**
     * Método para remover um curso.
     * Verifica se o curso existe, remove-o da lista de cursos e das associações com professores e turmas, se aplicável.
     *
     * @param id O identificador do curso a ser removido.
     * @return true se o curso foi removido com sucesso, false se não foi encontrado.
     */
    public boolean removeCourse(int id) {
        if (!stCourse.contains(id)) {
            System.out.println("Course not found");
            return false;
        }
        Course course = stCourse.get(id);

        for (Integer profId : stProfessors.keys()) {
            Professor prof = stProfessors.get(profId);
            prof.getCourses().remove(course);
        }

        for (Integer classId : stSchoolClasses.keys()) {
            SchoolClass schoolClass = stSchoolClasses.get(classId);
            schoolClass.getCourses().remove(course);
        }

        stCourse.remove(id);
        return true;
    }

    /**
     * Método para listar todos os cursos.
     * Exibe o identificador e o nome de cada curso na lista.
     */
    public void listCourses() {
        System.out.println("Course list:");
        for (Integer id : stCourse.keys()) {
            Course course = stCourse.get(id);
            System.out.println("ID: " + id + ", Name: " + course.getName());
        }
    }

    /**
     * Método para adicionar uma turma.
     * Verifica se a turma já existe, adiciona-a à lista de turmas e associa os alunos e professores, se aplicável.
     *
     * @param schoolClass A turma a ser adicionada.
     * @return true se a turma foi adicionada com sucesso, false se já existia.
     */
    public boolean addSchoolClass(SchoolClass schoolClass) {
        int id = schoolClass.getId();
        if (stSchoolClasses.contains(id)) {
            System.out.println("School class already exists");
            return false;
        }
        stSchoolClasses.put(id, schoolClass);
        return true;
    }

    /**
     * Método para editar as informações de uma turma.
     * Verifica se a turma existe, atualiza suas informações e mantém a associação com os alunos e professores.
     *
     * @param id          O identificador da turma a ser editada.
     * @param schoolClass O novo objeto SchoolClass com as informações atualizadas.
     * @return true se a turma foi editada com sucesso, false se não foi encontrada.
     */
    public boolean editSchoolClass(int id, SchoolClass schoolClass) {
        if (!stSchoolClasses.contains(id)) {
            System.out.println("Class not found");
            return false;
        }
        stSchoolClasses.put(id, schoolClass);
        ArrayList<Student> students = schoolClass.getStudents();
        if (students != null) {
            for (Student student : students) {
                student.setSchoolClass(schoolClass);
                stStudents.put(student.getId(), student);
            }
        }
        return true;
    }

    /**
     * Método para remover uma turma.
     * Verifica se a turma existe, remove-a da lista de turmas e remove as associações com alunos e professores, se aplicável.
     *
     * @param id O identificador da turma a ser removida.
     * @return true se a turma foi removida com sucesso, false se não foi encontrada.
     */
    public boolean removeSchoolClass(int id) {
        if (!stSchoolClasses.contains(id)) {
            System.out.println("Class not found");
            return false;
        }
        SchoolClass schoolClass = stSchoolClasses.get(id);

        for (Student student : schoolClass.getStudents()) {
            student.setSchoolClass(null);
        }

        for (Professor professor : schoolClass.getProfessors()) {
            professor.getSchoolClasses().remove(schoolClass);
        }

        stSchoolClasses.remove(id);
        return true;
    }

    /**
     * Método para listar todas as turmas.
     * Exibe o identificador e o nome de cada turma na lista, além dos alunos associados.
     */
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

    /**
     * Método para adicionar um evento.
     * Verifica se o evento já existe, adiciona-o à lista de eventos e associa-o à sala, turma e professor, se aplicável.
     *
     * @param event O evento a ser adicionado.
     * @return true se o evento foi adicionado com sucesso, false se já existia.
     */
    public boolean addEvent(Event event) {
        int id = event.getId();
        if (RBEvent.contains(id)) {
            System.out.println("Event already exists");
            return false;
        }

        // Adicionar o evento à estrutura RBEvent
        RBEvent.put(id, event);

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

    /**
     * Método para editar as informações de um evento.
     * Verifica se o evento existe, atualiza suas informações e mantém as associações com a sala, turma e professor.
     *
     * @param id    O identificador do evento a ser editado.
     * @param event O novo objeto Event com as informações atualizadas.
     * @return true se o evento foi editado com sucesso, false se não foi encontrado.
     */
    public boolean editEvent(int id, Event event) {
        if (!RBEvent.contains(id)) {
            System.out.println("Event not found");
            return false;
        }
        RBEvent.put(id, event);
        return true;
    }

    /**
     * Método para remover um evento.
     * Verifica se o evento existe, remove-o da lista de eventos e das associações com a sala, turma e professor, se aplicável.
     *
     * @param id O identificador do evento a ser removido.
     * @return true se o evento foi removido com sucesso, false se não foi encontrado.
     */
    public boolean removeEvent(int id) {
        if (!RBEvent.contains(id)) {
            System.out.println("Event not found");
            return false;
        }
        Event event = RBEvent.get(id);

        // Remover evento da sala
        if (event.getClassroom() != null) {
            Classroom room = event.getClassroom();
            room.getEvents().remove(event);
        }

        // Remover evento da turma
        if (event.getClasses() != null) {
            SchoolClass schoolClass = event.getClasses();
            schoolClass.getEvent().remove(event);
        }

        // Remover evento do professor
        if (event.getProfessorid() != null) {
            Professor prof = event.getProfessorid();
            prof.getEvents().remove(event);
        }

        RBEvent.remove(id);
        return true;
    }

    /**
     * Método para listar todos os eventos.
     * Exibe o identificador, nome e outras informações de cada evento na lista.
     */
    public void listEvents() {
        System.out.println("Event list:");
        for (Integer id : RBEvent.keys()) {
            Event event = RBEvent.get(id);
            System.out.println("ID: " + id + ", Name: " + event.getName());
        }
    }

    /**
     * Método para adicionar uma sala.
     * Verifica se a sala já existe, adiciona-a à lista de salas e associa-a aos eventos, se aplicável.
     *
     * @param room A sala a ser adicionada.
     * @return true se a sala foi adicionada com sucesso, false se já existia.
     */
    public boolean addRoom(Classroom room) {
        int id = room.getId();
        if (RBRoom.contains(id)) {
            System.out.println("Room already exists");
            return false;
        }
        RBRoom.put(id, room);
        return true;
    }

    /**
     * Método para editar as informações de uma sala.
     * Verifica se a sala existe, atualiza suas informações e mantém as associações com os eventos, se aplicável.
     *
     * @param id   O identificador da sala a ser editada.
     * @param room O novo objeto Classroom com as informações atualizadas.
     * @return true se a sala foi editada com sucesso, false se não foi encontrada.
     */
    public boolean editRoom(int id, Classroom room) {
        if (!RBRoom.contains(id)) {
            System.out.println("Room not found");
            return false;
        }
        RBRoom.put(id, room);
        return true;
    }

    /**
     * Método para remover uma sala.
     * Verifica se a sala existe, remove-a da lista de salas e remove as associações com os eventos, se aplicável.
     *
     * @param id O identificador da sala a ser removida.
     * @return true se a sala foi removida com sucesso, false se não foi encontrada.
     */
    public boolean removeRoom(int id) {
        if (!RBRoom.contains(id)) {
            System.out.println("Room not found");
            return false;
        }

        for (Integer eventId : RBEvent.keys()) {
            Event event = RBEvent.get(eventId);
            if (event.getClassroom() != null && event.getClassroom().getId() == id) {
                event.setClassroom(null);
            }
        }

        RBRoom.remove(id);
        return true;
    }

    /**
     * Método para verificar se uma sala está livre em um determinado dia e horário.
     * Verifica se há eventos agendados que se sobreponham ao período especificado.
     *
     * @param room  A sala a ser verificada.
     * @param day   O dia da semana em que se deseja verificar a disponibilidade.
     * @param start Hora de início do período a ser verificado.
     * @param end   Hora de término do período a ser verificado.
     * @return true se a sala estiver livre, false caso contrário.
     */
    public boolean roomIsFree(Classroom room, DayOfWeek day, LocalTime start, LocalTime end) {
        List<Event> roomEvents = room.getEvents();

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

    /**
     * Método para obter uma lista de salas livres em um determinado dia e horário.
     * Percorre todas as salas e verifica se estão livres no período especificado.
     *
     * @param day   O dia da semana em que se deseja verificar a disponibilidade.
     * @param start Hora de início do período a ser verificado.
     * @param end   Hora de término do período a ser verificado.
     * @return Lista de salas livres no período especificado.
     */
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

    /**
     * Método para listar as salas livres em um determinado dia e horário.
     * Exibe o identificador e o nome de cada sala livre no período especificado.
     *
     * @param day   O dia da semana em que se deseja verificar a disponibilidade.
     * @param start Hora de início do período a ser verificado.
     * @param end   Hora de término do período a ser verificado.
     */
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

    /**
     * Método para listar todas as salas.
     * Exibe o identificador de cada sala na lista.
     */
    public void listRooms() {
        System.out.println("Room list:");
        for (Integer id : RBRoom.keys()) {
            Classroom room = RBRoom.get(id);
            System.out.println("ID: " + id);
        }
    }

    /**
     * Método para imprimir os professores que lecionam determinados cursos.
     * Recebe uma lista de nomes de cursos e exibe os professores que lecionam esses cursos.
     *
     * @param courseNames Lista de nomes dos cursos a serem pesquisados.
     */
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

    /**
     * Método para imprimir as turmas de um professor específico.
     * Recebe o ID do professor e exibe as turmas associadas a ele.
     *
     * @param professorId O identificador do professor cujas turmas serão exibidas.
     */
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

    /**
     * Método para listar os horários de atendimento disponíveis de um professor para um aluno.
     * Verifica os eventos de atendimento do professor e os eventos do aluno, e exibe os horários disponíveis.
     *
     * @param studentId   O identificador do aluno.
     * @param professorId O identificador do professor.
     */
    public void listAvailableOfficeHours(int studentId, int professorId) {
        Student student = stStudents.get(studentId);
        Professor professor = stProfessors.get(professorId);

        if (student == null || professor == null) {
            System.out.println("Student or professor not found.");
            return;
        }
        // Verifica se o professor tem eventos de atendimento
        List<Event> officeHours = new ArrayList<>();
        for (Integer eventId : RBEvent.keys()) {
            Event ev = RBEvent.get(eventId);
            if (ev.getProfessorid() != null &&
                    ev.getProfessorid().getId() == professorId &&
                    "Atendimento".equals(ev.getUc())) {
                officeHours.add(ev);
            }
        }
        // Verifica se o aluno tem eventos agendados
        List<Event> studentEvents = new ArrayList<>();
        for (Integer eventId : RBEvent.keys()) {
            Event ev = RBEvent.get(eventId);
            if (ev.getClasses() != null &&
                    student.getSchoolClass() != null &&
                    ev.getClasses().getId() == student.getSchoolClass().getId()) {
                studentEvents.add(ev);
            }
        }

        System.out.println("Available office hours:");
        boolean found = false;
        for (Event office : officeHours) {
            boolean free = true;
            for (Event evStudent : studentEvents) {
                if (office.getDayOfWeek() == evStudent.getDayOfWeek()) {
                    // verifica se os horários se sobrepõem
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

    /**
     * Método para pesquisar salas por disponibilidade de tomadas.
     * Exibe as salas que possuem ou não possuem tomadas, conforme o parâmetro fornecido.
     *
     * @param hasSockets true para pesquisar salas com tomadas, false para salas sem tomadas.
     */
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

    /**
     * Método para pesquisar salas por andar.
     * Exibe as salas que estão localizadas no andar especificado.
     *
     * @param floor O número do andar a ser pesquisado.
     */
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

    /**
     * Obtém uma turma pelo seu ID.
     *
     * @param manager Instância do Manager.
     * @param id      O identificador da turma.
     * @return A turma correspondente ao ID, ou null se não encontrada.
     */
    public static SchoolClass getSchoolClassById(Manager manager, int id) {
        if (manager.stSchoolClasses.contains(id)) {
            return manager.stSchoolClasses.get(id);
        }
        return null;
    }

    /**
     * Obtém uma sala pelo seu ID.
     *
     * @param manager Instância do Manager.
     * @param id      O identificador da sala.
     * @return A sala correspondente ao ID, ou null se não encontrada.
     */
    public static Classroom getRoomById(Manager manager, int id) {
        if (manager.RBRoom.contains(id)) {
            return manager.RBRoom.get(id);
        }
        return null;
    }

    /**
     * Obtém um professor pelo seu ID.
     *
     * @param manager Instância do Manager.
     * @param id      O identificador do professor.
     * @return O professor correspondente ao ID, ou null se não encontrado.
     */
    public static Professor getProfessorById(Manager manager, int id) {
        if (manager.stProfessors.contains(id)) {
            return manager.stProfessors.get(id);
        }
        return null;
    }

    /**
     * Obtém um curso pelo seu ID.
     *
     * @param manager Instância do Manager.
     * @param id      O identificador do curso.
     * @return O curso correspondente ao ID, ou null se não encontrado.
     */
    public static Course getCourseById(Manager manager, int id) {
        if (manager.stCourse.contains(id)) {
            return manager.stCourse.get(id);
        }
        return null;
    }

    //GRAVAÇÃO DE DADOS EM FICHEIRO TXT
    /**
     * Método para exportar a lista de estudantes para um arquivo de texto.
     * Cada linha do arquivo contém o ID, nome e turma do estudante, separados por ponto e vírgula.
     *
     * @param filename O nome do arquivo onde os dados serão exportados.
     */
    public void exportStudentsToFile(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Integer id : stStudents.keys()) {
                Student s = stStudents.get(id);
                writer.write(s.getId() + ";" + s.getName() + ";" + (s.getSchoolClass() != null ? s.getSchoolClass().getId() : "") + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Método para exportar a lista de professores para um arquivo de texto.
     * Cada linha do arquivo contém o ID, nome, cursos e turmas do professor, separados por ponto e vírgula.
     *
     * @param filename O nome do arquivo onde os dados serão exportados.
     */
    public void exportProfessorsToFile(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Integer id : stProfessors.keys()) {
                Professor p = stProfessors.get(id);
                StringBuilder courses = new StringBuilder();
                for (Course c : p.getCourses()) {
                    if (courses.length() > 0) courses.append(",");
                    courses.append(c.getId());
                }
                StringBuilder classes = new StringBuilder();
                for (SchoolClass sc : p.getSchoolClasses()) {
                    if (classes.length() > 0) classes.append(",");
                    classes.append(sc.getId());
                }
                writer.write(p.getId() + ";" + p.getName() + ";" + courses + ";" + classes + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Método para exportar a lista de cursos para um arquivo de texto.
     * Cada linha do arquivo contém o ID e nome do curso, separados por ponto e vírgula.
     *
     * @param filename O nome do arquivo onde os dados serão exportados.
     */
    public void exportCoursesToFile(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Integer id : stCourse.keys()) {
                Course c = stCourse.get(id);
                writer.write(c.getId() + ";" + c.getName() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Método para exportar a lista de salas para um arquivo de texto.
     * Cada linha do arquivo contém o ID da sala e os IDs dos eventos associados, separados por ponto e vírgula.
     * @param filename O nome do arquivo onde os dados serão exportados.
     */
    public void exportRoomsToFile(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Integer id : RBRoom.keys()) {
                Classroom room = RBRoom.get(id);
                StringBuilder events = new StringBuilder();
                for (Event ev : room.getEvents()) {
                    if (events.length() > 0) events.append(",");
                    events.append(ev.getId());
                }
                writer.write(room.getId() + ";" + events + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Método para exportar a lista de eventos para um arquivo de texto.
     * Cada linha do arquivo contém o ID, nome, dia da semana, horário de início e fim, UC, ID da sala, ID da turma e ID do professor, separados por ponto e vírgula.
     *
     * @param filename O nome do arquivo onde os dados serão exportados.
     */
    public void exportEventsToFile(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Integer id : RBEvent.keys()) {
                Event ev = RBEvent.get(id);
                writer.write(ev.getId() + ";" + ev.getName() + ";" + ev.getDayOfWeek() + ";" +
                        ev.getStartTime() + ";" + ev.getEndTime() + ";" + ev.getUc() + ";" +
                        (ev.getClassroom() != null ? ev.getClassroom().getId() : "") + ";" +
                        (ev.getClasses() != null ? ev.getClasses().getId() : "") + ";" +
                        (ev.getProfessorid() != null ? ev.getProfessorid().getId() : "") + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Método para exportar a lista de turmas para um arquivo de texto.
     * Cada linha do arquivo contém o ID e nome da turma, separados por ponto e vírgula.
     *
     * @param filename O nome do arquivo onde os dados serão exportados.
     */
    public void exportSchoolClassesToFile(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Integer id : stSchoolClasses.keys()) {
                SchoolClass sc = stSchoolClasses.get(id);
                writer.write(sc.getId() + ";" + sc.getName() + "\n");            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Método para exportar a lista de salas livres em um determinado dia e horário para um arquivo de texto.
     * Cada linha do arquivo contém o ID da sala e uma mensagem indicando que a sala está livre.
     *
     * @param filename O nome do arquivo onde os dados serão exportados.
     * @param dia      O dia da semana em que se deseja verificar a disponibilidade.
     * @param inicio   Hora de início do período a ser verificado.
     * @param fim      Hora de término do período a ser verificado.
     */
    public void exportFreeRoomsToFile(String filename, DayOfWeek dia, LocalTime inicio, LocalTime fim) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Integer id : RBRoom.keys()) {
                Classroom r = RBRoom.get(id);
                if (roomIsFree(r,dia, inicio, fim)) {
                    writer.write("ID: " + r.getId() + " - Sala livre\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //HISTÓRICO DE PESQUISAS
    private ArrayList<String> searchHistory = new ArrayList<>();

    /**
     * Método para exportar o histórico de pesquisas para um arquivo de texto.
     * Cada entrada do histórico é escrita em uma nova linha no arquivo.
     *
     * @param filename O nome do arquivo onde o histórico será exportado.
     */
    public void exportSearchHistory(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (String entry : searchHistory) {
                writer.write(entry + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Método para adicionar uma entrada ao histórico de pesquisas.
     * Adiciona a pesquisa à lista de histórico, que pode ser exportada posteriormente.
     *
     * @param search A pesquisa a ser adicionada ao histórico.
     */
    public void addSearchHistory(String search) {
        searchHistory.add(search);
    }


    //GRAVAÇÃO DE DADOS EM FICHEIRO BINÁRIO
    /**
     * Método para exportar a lista de estudantes para um arquivo binário.
     * Serializa a lista de estudantes e grava no arquivo especificado.
     *
     * @param filename O nome do arquivo onde os dados serão exportados.
     */
    public void exportStudentsToBinary(String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            ArrayList<Student> studentList = new ArrayList<>();
            for (Integer id : stStudents.keys()) {
                studentList.add(stStudents.get(id));
            }
            oos.writeObject(studentList);
            System.out.println("Alunos exportados para ficheiro binário com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao exportar: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**     * Método para exportar a lista de professores para um arquivo binário.
     * Serializa a lista de professores e grava no arquivo especificado.
     *
     * @param filename O nome do arquivo onde os dados serão exportados.
     */
    public void exportProfessorsToBinary(String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            ArrayList<Professor> professorList = new ArrayList<>();
            for (Integer id : stProfessors.keys()) {
                professorList.add(stProfessors.get(id));
            }
            oos.writeObject(professorList);
            System.out.println("Professores exportados para ficheiro binário com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao exportar: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Método para exportar a lista de cursos para um arquivo binário.
     * Serializa a lista de cursos e grava no arquivo especificado.
     *
     * @param filename O nome do arquivo onde os dados serão exportados.
     */
    public void exportCoursesToBinary(String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            ArrayList<Course> courseList = new ArrayList<>();
            for (Integer id : stCourse.keys()) {
                courseList.add(stCourse.get(id));
            }
            oos.writeObject(courseList);
            System.out.println("Cursos exportados para ficheiro binário com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao exportar: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Método para exportar a lista de salas para um arquivo binário.
     * Serializa a lista de salas e grava no arquivo especificado.
     *
     * @param filename O nome do arquivo onde os dados serão exportados.
     */
    public void exportRoomsToBinary(String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            ArrayList<Classroom> roomList = new ArrayList<>();
            for (Integer id : RBRoom.keys()) {
                roomList.add(RBRoom.get(id));
            }
            oos.writeObject(roomList);
            System.out.println("Salas exportadas para ficheiro binário com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao exportar: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Método para exportar a lista de eventos para um arquivo binário.
     * Serializa a lista de eventos e grava no arquivo especificado.
     *
     * @param filename O nome do arquivo onde os dados serão exportados.
     */
    public void exportEventsToBinary(String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            ArrayList<Event> eventList = new ArrayList<>();
            for (Integer id : RBEvent.keys()) {
                eventList.add(RBEvent.get(id));
            }
            oos.writeObject(eventList);
            System.out.println("Eventos exportados para ficheiro binário com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao exportar: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Método para exportar a lista de turmas para um arquivo binário.
     * Serializa a lista de turmas e grava no arquivo especificado.
     *
     * @param filename O nome do arquivo onde os dados serão exportados.
     */
    public void exportSchoolClassesToBinary(String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            ArrayList<SchoolClass> classList = new ArrayList<>();
            for (Integer id : stSchoolClasses.keys()) {
                classList.add(stSchoolClasses.get(id));
            }
            oos.writeObject(classList);
            System.out.println("Turmas exportadas para ficheiro binário com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao exportar: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Método para exportar a lista de salas livres em um determinado dia e horário para um arquivo binário.
     * Serializa a lista de salas livres e grava no arquivo especificado.
     *
     * @param filename O nome do arquivo onde os dados serão exportados.
     * @param dia      O dia da semana em que se deseja verificar a disponibilidade.
     * @param inicio   Hora de início do período a ser verificado.
     * @param fim      Hora de término do período a ser verificado.
     */
    public void exportFreeRoomsToBinary(String filename, DayOfWeek dia, LocalTime inicio, LocalTime fim) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            ArrayList<Classroom> freeRooms = new ArrayList<>();
            for (Integer id : RBRoom.keys()) {
                Classroom room = RBRoom.get(id);
                if (roomIsFree(room, dia, inicio, fim)) {
                    freeRooms.add(room);
                }
            }
            oos.writeObject(freeRooms);
            System.out.println("Salas livres exportadas para ficheiro binário com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao exportar: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Método para exportar o histórico de pesquisas para um arquivo binário.
     * Serializa o histórico de pesquisas e grava no arquivo especificado.
     *
     * @param filename O nome do arquivo onde o histórico será exportado.
     */
    public void exportSearchHistoryBinary(String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            System.out.println("A exportar histórico: " + searchHistory); // Debug
            oos.writeObject(searchHistory);
            System.out.println("Histórico exportado para ficheiro binário com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao exportar: " + e.getMessage());
            e.printStackTrace();
        }
    }


    //LEITURA DE DADOS DE FICHEIRO TXT
    /**
     * Método para carregar a lista de estudantes de um arquivo de texto.
     * Cada linha do arquivo deve conter o ID, nome e IDs das turmas do estudante, separados por ponto e vírgula.
     *
     * @param filename O nome do arquivo de onde os dados serão carregados.
     */
    public void loadStudentsFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length >= 2) {
                    int id = Integer.parseInt(parts[0]);
                    String name = parts[1];

                    List<SchoolClass> classes = new ArrayList<>();
                    if (parts.length == 3 && !parts[2].isEmpty()) {
                        String[] classIds = parts[2].split(",");
                        for (String cid : classIds) {
                            int classId = Integer.parseInt(cid);
                            SchoolClass sc = stSchoolClasses.get(classId);
                            if (sc != null) {
                                classes.add(sc);
                            }
                        }
                    }

                    Student s = new Student(id, name, classes.isEmpty() ? null : classes.get(0));
                    stStudents.put(id, s);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Método para carregar a lista de professores de um arquivo de texto.
     * Cada linha do arquivo deve conter o ID, nome, IDs dos cursos e IDs das turmas do professor, separados por ponto e vírgula.
     *
     * @param filename O nome do arquivo de onde os dados serão carregados.
     */
    public void loadProfessorsFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length >= 2) {
                    int id = Integer.parseInt(parts[0]);
                    String name = parts[1];

                    List<Course> courses = new ArrayList<>();
                    if (parts.length >= 3 && !parts[2].isEmpty()) {
                        for (String courseId : parts[2].split(",")) {
                            Course c = stCourse.get(Integer.parseInt(courseId));
                            if (c != null) courses.add(c);
                        }
                    }

                    List<SchoolClass> classes = new ArrayList<>();
                    if (parts.length >= 4 && !parts[3].isEmpty()) {
                        for (String classId : parts[3].split(",")) {
                            SchoolClass sc = stSchoolClasses.get(Integer.parseInt(classId));
                            if (sc != null) classes.add(sc);
                        }
                    }

                    Professor p = new Professor(id, name);
                    p.setCourses(new ArrayList<>(courses));
                    p.setSchoolClasses(new ArrayList<>(classes));
                    stProfessors.put(id, p);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Método para carregar a lista de cursos de um arquivo de texto.
     * Cada linha do arquivo deve conter o ID e nome do curso, separados por ponto e vírgula.
     *
     * @param filename O nome do arquivo de onde os dados serão carregados.
     */
    public void loadCoursesFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 2) {
                    int id = Integer.parseInt(parts[0]);
                    String name = parts[1];
                    Course c = new Course(id, name);
                    stCourse.put(id, c);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Método para carregar a lista de salas de um arquivo de texto.
     * Cada linha do arquivo deve conter o ID, se possui tomadas e o andar da sala, separados por ponto e vírgula.
     *
     * @param filename O nome do arquivo de onde os dados serão carregados.
     */
    public void loadClassroomsFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length >= 3) {
                    int id = Integer.parseInt(parts[0]);
                    boolean sockets = Boolean.parseBoolean(parts[1]);
                    int floor = Integer.parseInt(parts[2]);
                    Classroom r = new Classroom(id, new ArrayList<>(), sockets, floor);
                    RBRoom.put(id, r);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Método para carregar a lista de eventos de um arquivo de texto.
     * Cada linha do arquivo deve conter o ID, nome, dia da semana, horário de início e fim, UC, ID da sala, ID da turma e ID do professor, separados por ponto e vírgula.
     *
     * @param filename O nome do arquivo de onde os dados serão carregados.
     */
    public void loadEventsFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length >= 2) {
                    int id = Integer.parseInt(parts[0]);
                    String name = parts[1];
                    Event e = new Event(id, name,null, null, null, null, null, null, null);
                    RBEvent.put(id, e);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Método para carregar a lista de eventos de um arquivo de texto.
     * Cada linha do arquivo deve conter o ID, nome, dia da semana, horário de início e fim, UC, ID da sala, ID da turma e ID do professor, separados por ponto e vírgula.
     *
     * @param filename O nome do arquivo de onde os dados serão carregados.
     */
    public void loadSchoolClassesFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length >= 2) {
                    int id = Integer.parseInt(parts[0]);
                    String name = parts[1];
                    SchoolClass sc = new SchoolClass(id, name);
                    stSchoolClasses.put(id, sc);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //LEITURA DE DADOS DE FICHEIRO BINÁRIO
    /**
     * Método para carregar a lista de estudantes de um arquivo binário.
     * Deserializa a lista de estudantes e adiciona ao mapa de estudantes.
     *
     * @param filename O nome do arquivo de onde os dados serão carregados.
     */
    public void loadStudentsFromBinary(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            List<Student> students = (List<Student>) ois.readObject();
            for (Student s : students) {
                stStudents.put(s.getId(), s);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    /**
     * Método para carregar a lista de professores de um arquivo binário.
     * Deserializa a lista de professores e adiciona ao mapa de professores.
     *
     * @param filename O nome do arquivo de onde os dados serão carregados.
     */
    public void loadProfessorsFromBinary(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            List<Professor> professors = (List<Professor>) ois.readObject();
            for (Professor p : professors) {
                stProfessors.put(p.getId(), p);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Método para carregar a lista de cursos de um arquivo binário.
     * Deserializa a lista de cursos e adiciona ao mapa de cursos.
     *
     * @param filename O nome do arquivo de onde os dados serão carregados.
     */
    public void loadCoursesFromBinary(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            List<Course> courses = (List<Course>) ois.readObject();
            for (Course c : courses) {
                stCourse.put(c.getId(), c);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Método para carregar a lista de salas de um arquivo binário.
     * Deserializa a lista de salas e adiciona ao mapa de salas.
     *
     * @param filename O nome do arquivo de onde os dados serão carregados.
     */
    public void loadClassroomsFromBinary(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            List<Classroom> rooms = (List<Classroom>) ois.readObject();
            for (Classroom r : rooms) {
                RBRoom.put(r.getId(), r);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Método para carregar a lista de eventos de um arquivo binário.
     * Deserializa a lista de eventos e adiciona ao mapa de eventos.
     *
     * @param filename O nome do arquivo de onde os dados serão carregados.
     */
    public void loadEventsFromBinary(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            List<Event> events = (List<Event>) ois.readObject();
            for (Event e : events) {
                RBEvent.put(e.getId(), e);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Método para carregar a lista de turmas de um arquivo binário.
     * Deserializa a lista de turmas e adiciona ao mapa de turmas.
     *
     * @param filename O nome do arquivo de onde os dados serão carregados.
     */
    public void loadSchoolClassesFromBinary(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            List<SchoolClass> schoolClasses = (List<SchoolClass>) ois.readObject();
            for (SchoolClass sc : schoolClasses) {
                stSchoolClasses.put(sc.getId(), sc);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}




