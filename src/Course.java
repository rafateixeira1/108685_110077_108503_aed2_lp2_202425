import java.util.*;
import java.io.Serializable;
/**
 * Representa uma disciplina (curso) na universidade.
 * Armazena o identificador e o nome da disciplina.
 */
public class Course implements Serializable {
    private int id;
    private String name;

    /**
     * Construtor completo da disciplina.
     * @param id Identificador único da disciplina.
     * @param name Nome da disciplina.
     */
    public Course(int id, String name) {
        this.setId(id);
        this.setName(name);
    }

    /**
     * Obtém o identificador da disciplina.
     * @return id da disciplina.
     */
    public int getId() {
        return id;
    }

    /**
     * Define o identificador da disciplina.
     * @param id Novo id da disciplina.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtém o nome da disciplina.
     * @return Nome da disciplina.
     */
    public String getName() {
        return name;
    }

    /**
     * Define o nome da disciplina.
     * @param name Novo nome da disciplina.
     */
    public void setName(String name) {
        this.name = name;
    }
}