import java.io.Serializable;

/**
 * Representa um estudante da universidade.
 * Herda de {@link Person} e armazena informações sobre a turma do estudante.
 */
public class Student extends Person implements Serializable {
    private SchoolClass schoolClass;

    /**
     * Construtor do estudante.
     * @param id Identificador único do estudante.
     * @param name Nome do estudante.
     * @param schoolClass Turma à qual o estudante pertence.
     */
    public Student(int id, String name, SchoolClass schoolClass) {
        super(id, name);
        this.setSchoolClass(schoolClass);
    }

    /**
     * Obtém a turma do estudante.
     * @return A turma associada ao estudante.
     */
    public SchoolClass getSchoolClass() {
        return schoolClass;
    }

    /**
     * Define a turma do estudante.
     * @param schoolClass Nova turma a ser associada ao estudante.
     */
    public void setSchoolClass(SchoolClass schoolClass) {
        this.schoolClass = schoolClass;
    }
}