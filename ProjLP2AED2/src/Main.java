public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager();
        DataLoader.populateAll(manager);

        //manager.listStudents();
        //manager.ListProfs();
        //manager.listCourses();
        //manager.listRooms();
        manager.listEvents();
        manager.listSchoolClasses();
    }
}