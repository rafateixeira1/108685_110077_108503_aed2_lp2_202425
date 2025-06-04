/**
 * Representa um ponto no mapa do edifício da universidade.
 * Cada ponto possui coordenadas, tipo, descrição e indica se está em ambiente interno.
 */
public class MapPoint {
    private int id;
    private double x;
    private double y;
    private String type;
    private String description;
    private boolean indoor;

    /**
     * Construtor completo do ponto no mapa.
     * @param id Identificador único do ponto.
     * @param x Coordenada X do ponto.
     * @param y Coordenada Y do ponto.
     * @param type Tipo do ponto (ex: sala de aula, banheiro).
     * @param description Descrição adicional do ponto.
     * @param indoor Indica se o ponto está em ambiente interno (true) ou externo (false).
     */
    public MapPoint(int id, double x, double y, String type, String description, boolean indoor) {
        this.setId(id);
        this.setX(x);
        this.setY(y);
        this.setType(type);
        this.setDescription(description);
        this.setIndoor(indoor);
    }

    /**
     * Obtém o identificador do ponto.
     * @return id do ponto.
     */
    public int getId() {
        return id;
    }

    /**
     * Define o identificador do ponto.
     * @param id Novo id do ponto.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtém as coordenadas X do ponto.
     * @return Coordenada X do ponto.
     */
    public double getX() {
        return x;
    }

    /**
     * Define as coordenadas X do ponto.
     * @param x Nova coordenada X do ponto.
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * Obtém as coordenadas Y do ponto.
     * @return Coordenada Y do ponto.
     */
    public double getY() {
        return y;
    }

    /**
     * Define as coordenadas Y do ponto.
     * @param y Nova coordenada Y do ponto.
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * Obtém o tipo do ponto.
     * @return Tipo do ponto (ex: sala de aula, banheiro).
     */
    public String getType() {
        return type;
    }

    /**
     * Define o tipo do ponto.
     * @param type Novo tipo do ponto.
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Obtém a descrição do ponto.
     * @return Descrição adicional do ponto.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Define a descrição do ponto.
     * @param description Nova descrição do ponto.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Verifica se o ponto está em ambiente interno.
     * @return true se o ponto for interno, false se for externo.
     */
    public boolean isIndoor() {
        return indoor;
    }

    /**
     * Define se o ponto está em ambiente interno.
     * @param indoor true para ponto interno, false para externo.
     */
    public void setIndoor(boolean indoor) {
        this.indoor = indoor;
    }
}