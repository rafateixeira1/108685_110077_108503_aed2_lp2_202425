public class Student extends Person {
    private int schoolClassId;

    public Student(int id, String name, int schoolClassId) {
        super(id, name);
        this.schoolClassId = schoolClassId;
    }

    public int getSchoolClassId() {
        return schoolClassId;
    }

    public void setSchoolClassId(int schoolClassId) {
        this.schoolClassId = schoolClassId;
    }
}