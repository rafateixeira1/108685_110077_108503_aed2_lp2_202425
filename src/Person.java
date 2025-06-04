import java.io.*;
/**
 * Classe base que representa uma pessoa na universidade.
 * Pode ser estendida para representar estudantes, professores, etc.
 */
public class Person implements Serializable {
    private int id;
    private String name;

    /**
     * Construtor completo da pessoa.
     * @param id Identificador único da pessoa.
     * @param name Nome da pessoa.
     */
    public Person(int id, String name) {
        this.setId(id);
        this.setName(name);
    }

    /**
     * Obtém o identificador da pessoa.
     * @return id da pessoa.
     */
    public int getId() {
        return id;
    }

    /**
     * Define o identificador da pessoa.
     * @param id Novo id da pessoa.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtém o nome da pessoa.
     * @return Nome da pessoa.
     */
    public String getName() {
        return name;
    }

    /**
     * Define o nome da pessoa.
     * @param name Novo nome da pessoa.
     */
    public void setName(String name) {
        this.name = name;
    }
}