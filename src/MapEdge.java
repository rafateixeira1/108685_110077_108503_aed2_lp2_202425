import edu.princeton.cs.algs4.Edge;

/**
 * Representa uma aresta ponderada no mapa do edifício, estendendo {@link edu.princeton.cs.algs4.Edge}.
 * Além do peso padrão, armazena o tempo de travessia e o tipo de caminho (ex: escadas, elevador, corredor).
 */
public class MapEdge extends Edge {
    private double time;
    private String pathType;

    /**
     * Construtor da aresta do mapa.
     * @param v Vértice de origem.
     * @param w Vértice de destino.
     * @param weight Peso da aresta (ex: distância).
     * @param time Tempo de travessia da aresta.
     * @param pathType Tipo de caminho (ex: "escada", "elevador").
     */
    public MapEdge(int v, int w, double weight, double time, String pathType) {
        super(v, w, weight);
        this.setTime(time);
        this.setPathType(pathType);
    }

    /**
     * Obtém o tempo de travessia da aresta.
     * @return Tempo em unidades apropriadas.
     */
    public double getTime() {
        return time;
    }

    /**
     * Define o tempo de travessia da aresta.
     * @param time Novo tempo.
     */
    public void setTime(double time) {
        this.time = time;
    }

    /**
     * Obtém o tipo de caminho da aresta.
     * @return Tipo de caminho (ex: "escada", "elevador").
     */
    public String getPathType() {
        return pathType;
    }

    /**
     * Define o tipo de caminho da aresta.
     * @param pathType Novo tipo de caminho.
     */
    public void setPathType(String pathType) {
        this.pathType = pathType;
    }
}