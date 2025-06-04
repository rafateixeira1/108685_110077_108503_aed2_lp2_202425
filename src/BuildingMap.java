import edu.princeton.cs.algs4.EdgeWeightedGraph;
import java.util.*;

/**
 * Representa o mapa do edifício da universidade, contendo pontos (MapPoint) e conexões (MapEdge).
 * Permite operações de consulta, adição e remoção de pontos e arestas, além de cálculos de caminhos mínimos
 * e verificação de conectividade do grafo.
 */
public class BuildingMap {
    private EdgeWeightedGraph graph;
    private Map<Integer, MapPoint> points;

    /**
     * Construtor do BuildingMap.
     * @param graph Grafo ponderado de arestas representando as conexões do edifício.
     * @param points Mapa de pontos do edifício, indexados pelo id.
     */
    public BuildingMap(EdgeWeightedGraph graph, Map<Integer, MapPoint> points) {
        this.setGraph(graph);
        this.setPoints(points);
    }

    /**
     * Obtém o grafo do edifício.
     * @return O grafo de arestas ponderadas.
     */
    public EdgeWeightedGraph getGraph() {
        return graph;
    }

    /**
     * Define o grafo do edifício.
     * @param graph Novo grafo.
     */
    public void setGraph(EdgeWeightedGraph graph) {
        this.graph = graph;
    }

    /**
     * Obtém o mapa de pontos do edifício.
     * @return Mapa de pontos.
     */
    public Map<Integer, MapPoint> getPoints() {
        return points;
    }

    /**
     * Define o mapa de pontos do edifício.
     * @param points Novo mapa de pontos.
     */
    public void setPoints(Map<Integer, MapPoint> points) {
        this.points = points;
    }

    /**
     * Adiciona um novo ponto ao mapa.
     * @param point Ponto a ser adicionado.
     */
    public void addPoint(MapPoint point) {
        getPoints().put(point.getId(), point);
    }

    /**
     * Remove um ponto do mapa pelo id.
     * @param id Identificador do ponto a ser removido.
     */
    public void removePoint(int id) {
        getPoints().remove(id);
        // Note: EdgeWeightedGraph does not support direct vertex removal
    }

    /**
     * Obtém um ponto pelo id.
     * @param id Identificador do ponto.
     * @return O MapPoint correspondente ou null se não existir.
     */
    public MapPoint getPoint(int id) {
        return getPoints().get(id);
    }

    /**
     * Obtém todos os pontos do mapa.
     * @return Iterable de MapPoint representando todos os pontos.
     */
    public Iterable<MapPoint> getAllPoints() {
        return getPoints().values();
    }

    /**
     * Adiciona uma aresta ao grafo do edifício.
     * @param edge Aresta a ser adicionada.
     */
    public void addEdge(MapEdge edge) {
        getGraph().addEdge(edge);
    }

    /**
     * Obtém todas as arestas do grafo.
     * @return Iterable de MapEdge representando todas as arestas.
     */
    public Iterable<MapEdge> getAllEdges() {
        List<MapEdge> edges = new ArrayList<>();
        for (var e : getGraph().edges()) {
            if (e instanceof MapEdge) {
                edges.add((MapEdge) e);
            }
        }
        return edges;
    }

    /**
     * Obtém todas as arestas conectadas a um ponto específico.
     * @param id Identificador do ponto.
     * @return Iterable de MapEdge representando as arestas conectadas ao ponto.
     */
    public Iterable<MapEdge> getEdgesOfPoint(int id) {
        List<MapEdge> edges = new ArrayList<>();
        for (var e : getGraph().adj(id)) {
            if (e instanceof MapEdge) {
                edges.add((MapEdge) e);
            }
        }
        return edges;
    }

    /**
     * Remove uma aresta específica do grafo.
     * @param edgeToRemove Aresta a ser removida.
     */
    public void removeEdge(MapEdge edgeToRemove) {
        List<MapEdge> edgesToKeep = new ArrayList<>();
        for (var e : getGraph().edges()) {
            if (e instanceof MapEdge && !e.equals(edgeToRemove)) {
                edgesToKeep.add((MapEdge) e);
            }
        }
        EdgeWeightedGraph newGraph = new EdgeWeightedGraph(getGraph().V());
        for (MapEdge e : edgesToKeep) {
            newGraph.addEdge(e);
        }
        setGraph(newGraph);
    }

    /**
     * Imprime informações sobre o grafo, como número de vértices e arestas.
     */
    public void printGraphInfo() {
        System.out.println("Number of vertices: " + getGraph().V());
        int edgeCount = 0;
        for (var e : getGraph().edges()) {
            edgeCount++;
        }
        System.out.println("Number of edges: " + edgeCount);
    }

    /**
     * Calcula o caminho mais curto por distância entre dois pontos.
     * @param startId Id do ponto inicial.
     * @param endId Id do ponto final.
     * @return Lista de ids dos pontos no caminho.
     */

    public List<Integer> shortestPathByDistance(int startId, int endId) {
        edu.princeton.cs.algs4.DijkstraUndirectedSP sp = new edu.princeton.cs.algs4.DijkstraUndirectedSP(graph, startId);

        if (!sp.hasPathTo(endId)) {
            return Collections.emptyList();
        }

        List<Integer> path = new ArrayList<>();
        for (edu.princeton.cs.algs4.Edge e : sp.pathTo(endId)) {
            int v = e.either();
            int w = e.other(v);
            if (path.isEmpty()) path.add(v);
            path.add(w);
        }
        return path;
    }

    /**
     * Imprime o caminho mais curto por distância entre dois pontos.
     * @param startId Id do ponto inicial.
     * @param endId Id do ponto final.
     */
    public void printShortestPathByDistance(int startId, int endId) {
        List<Integer> path = shortestPathByDistance(startId, endId);
        System.out.println("Shortest path by distance:");
        for (int id : path) {
            MapPoint p = getPoint(id);
            System.out.println("ID: " + id + " - " + (p != null ? p.getDescription() : "Unknown"));
        }
    }

    /**
     * Calcula o caminho mais curto por tempo entre dois pontos.
     * @param startId Id do ponto inicial.
     * @param endId Id do ponto final.
     * @return Lista de ids dos pontos no caminho.
     */
    public List<Integer> shortestPathByTime(int startId, int endId) {
        edu.princeton.cs.algs4.EdgeWeightedGraph timeGraph = new edu.princeton.cs.algs4.EdgeWeightedGraph(graph.V());
        for (var e : getAllEdges()) {
            MapEdge edge = (MapEdge) e;
            MapEdge timeEdge = new MapEdge(edge.either(), edge.other(edge.either()), edge.getTime(), edge.getTime(), edge.getPathType());
            timeGraph.addEdge(timeEdge);
        }

        edu.princeton.cs.algs4.DijkstraUndirectedSP sp = new edu.princeton.cs.algs4.DijkstraUndirectedSP(timeGraph, startId);

        if (!sp.hasPathTo(endId)) {
            return Collections.emptyList();
        }

        List<Integer> path = new ArrayList<>();
        for (edu.princeton.cs.algs4.Edge e : sp.pathTo(endId)) {
            int v = e.either();
            int w = e.other(v);
            if (path.isEmpty()) path.add(v);
            path.add(w);
        }
        return path;
    }

    /**
     * Imprime o caminho mais curto por tempo entre dois pontos.
     * @param startId Id do ponto inicial.
     * @param endId Id do ponto final.
     */
    public void printShortestPathByTime(int startId, int endId) {
        List<Integer> path = shortestPathByTime(startId, endId);
        System.out.println("Shortest path by time:");
        for (int id : path) {
            MapPoint p = getPoint(id);
            System.out.println("ID: " + id + " - " + (p != null ? p.getDescription() : "Unknown"));
        }
    }

    /**
     * Calcula o caminho mais curto entre dois pontos, evitando pontos proibidos.
     * @param startId Id do ponto inicial.
     * @param endId Id do ponto final.
     * @param forbiddenPoints Conjunto de ids de pontos proibidos.
     * @return Lista de ids dos pontos no caminho, ou uma lista vazia se não houver caminho.
     */
    public List<Integer> shortestPathAvoidingPoints(int startId, int endId, Set<Integer> forbiddenPoints) {
        if (forbiddenPoints.contains(startId) || forbiddenPoints.contains(endId)) {
            return Collections.emptyList();
        }

        // Cria um novo grafo sem os nós proibidos
        edu.princeton.cs.algs4.EdgeWeightedGraph filteredGraph = new edu.princeton.cs.algs4.EdgeWeightedGraph(graph.V());
        for (MapEdge edge : getAllEdges()) {
            int v = edge.either();
            int w = edge.other(v);
            if (!forbiddenPoints.contains(v) && !forbiddenPoints.contains(w)) {
                filteredGraph.addEdge(new MapEdge(v, w, edge.weight(), edge.getTime(), edge.getPathType()));
            }
        }

        edu.princeton.cs.algs4.DijkstraUndirectedSP sp = new edu.princeton.cs.algs4.DijkstraUndirectedSP(filteredGraph, startId);
        if (!sp.hasPathTo(endId)) {
            return Collections.emptyList();
        }

        List<Integer> path = new ArrayList<>();
        for (edu.princeton.cs.algs4.Edge e : sp.pathTo(endId)) {
            int v = e.either();
            int w = e.other(v);
            if (path.isEmpty()) path.add(v);
            path.add(w);
        }
        return path;
    }

    /**
     * Imprime o caminho mais curto entre dois pontos, evitando pontos proibidos.
     * @param startId Id do ponto inicial.
     * @param endId Id do ponto final.
     * @param forbiddenPoints Conjunto de ids de pontos proibidos.
     */
    public void printShortestPathAvoidingPoints(int startId, int endId, Set<Integer> forbiddenPoints) {
        List<Integer> path = shortestPathAvoidingPoints(startId, endId, forbiddenPoints);
        System.out.println("Shortest path avoiding points " + forbiddenPoints + ":");
        for (int id : path) {
            MapPoint p = getPoint(id);
            System.out.println("ID: " + id + " - " + (p != null ? p.getDescription() : "Unknown"));
        }
    }

    /**
     * Verifica se o grafo é conexo, ou seja, se existe um caminho entre todos os pares de vértices.
     * @param subset Conjunto de vértices a serem verificados. Se null ou vazio, verifica o grafo completo.
     * @return true se o grafo (ou subgrafo) for conexo, false caso contrário.
     */
    public boolean isConnected(Set<Integer> subset) {
        Set<Integer> vertices = (subset == null || subset.isEmpty()) ? points.keySet() : subset;
        if (vertices.isEmpty()) return true;

        // Escolhe um ponto inicial do conjunto
        int start = vertices.iterator().next();
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            int v = queue.poll();
            for (MapEdge edge : getEdgesOfPoint(v)) {
                int w = edge.other(v);
                if (vertices.contains(w) && !visited.contains(w)) {
                    visited.add(w);
                    queue.add(w);
                }
            }
        }
        return visited.containsAll(vertices);
    }

    /**
     * Imprime se o grafo (ou subgrafo) é conexo.
     * @param subset Conjunto de vértices a serem verificados. Se null ou vazio, verifica o grafo completo.
     */
    public void printIsConnected(Set<Integer> subset) {
        boolean connected = isConnected(subset);
        if (subset == null || subset.isEmpty()) {
            System.out.println("The full graph is " + (connected ? "connected." : "not connected."));
        } else {
            System.out.println("The subgraph with points " + subset + " is " + (connected ? "connected." : "not connected."));
        }
    }
}