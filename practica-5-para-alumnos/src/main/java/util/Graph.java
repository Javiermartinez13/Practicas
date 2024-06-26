package util;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.stream.Collectors;

public class Graph<V>{

    //Lista de adyacencia.
    private Map<V, Set<V>> adjacencyList = new HashMap<>();

    /**
     * Añade el vértice `v` al grafo.
     *
     * @param v vértice a añadir.
     * @return `true` si no estaba anteriormente y `false` en caso contrario.
     */
    public boolean addVertex(V v){
        if (adjacencyList.containsKey(v))
        {
            return false;
        }
        adjacencyList.put(v, new HashSet<>());

        return true; //Este código no hay que modificarlo.
    }

    /**
     * Añade un arco entre los vértices `v1` y `v2` al grafo. En caso de
     * que no exista alguno de los vértices, lo añade también.
     *
     * @param v1 el origen del arco.
     * @param v2 el destino del arco.
     * @return `true` si no existía el arco y `false` en caso contrario.
     */
    public boolean addEdge(V v1, V v2){
        addVertex(v1); // Asegura que v1 esté en el grafo.
        addVertex(v2); // Asegura que v2 esté en el grafo.

        boolean added = false;
        // Solo añade el arco si aún no existe
        if (!adjacencyList.get(v1).contains(v2))
        {
            adjacencyList.get(v1).add(v2);
            adjacencyList.get(v2).add(v1); // Asume un grafo no dirigido.
            added = true;
        }

        return added; //Este código no hay que modificarlo.
    }

    /**
     * Obtiene el conjunto de vértices adyacentes a `v`.
     *
     * @param v vértice del que se obtienen los adyacentes.
     * @return conjunto de vértices adyacentes.
     */
    public Set<V> obtainAdjacents(V v) {
        Set<V> adjacents = adjacencyList.get(v);
        return adjacents != null ? adjacents : new HashSet<>();
    }

    /**
     * Comprueba si el grafo contiene el vértice dado. 
     *
     * @param v vértice para el que se realiza la comprobación.
     * @return `true` si `v` es un vértice del grafo.
     */
    public boolean containsVertex(V v){

        return adjacencyList.containsKey(v); //Este código no hay que modificarlo.
    }

    /**
     * Método `toString()` reescrito para la clase `Grafo.java`.
     * @return una cadena de caracteres con la lista de adyacencia.
     */
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (V v: adjacencyList.keySet()){
            sb.append(v.toString()).append(":").append(adjacencyList.get(v).toString()).append("\n");
        }
        return sb.toString(); //Este código hay que modificarlo.
    }

    /**
     * Obtiene, en caso de que exista, el camino más corto entre
     * `v1` y `v2`. En caso contrario, devuelve `null`.
     * 
     * @param v1 el vértice origen.
     * @param v2 el vértice destino.
     * @return lista con la secuencia de vértices del camino más corto
     * entre `v1` y `v2`
     **/
    public List<V> shortestPath(V v1, V v2) {
        // Verifica si los vértices existen en el grafo
        if (!containsVertex(v1) || !containsVertex(v2)) {
            return null; // Uno de los vértices no existe
        }

        Queue<V> queue = new LinkedList<>();
        Map<V, V> predecessors = new HashMap<>();
        Set<V> visited = new HashSet<>();

        queue.add(v1);
        visited.add(v1);
        predecessors.put(v1, null); // El inicio no tiene predecesor

        while (!queue.isEmpty()) {
            V current = queue.poll();

            // Si encontramos el vértice de destino, construimos el camino
            if (current.equals(v2)) {
                return buildPath(predecessors, v2);
            }

            // Explora los vecinos del vértice actual
            try {
                for (V neighbor : obtainAdjacents(current)) {
                    if (!visited.contains(neighbor)) {
                        queue.add(neighbor);
                        visited.add(neighbor);
                        predecessors.put(neighbor, current);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null; // No se encontró camino
    }

    // Método privado para construir el camino desde el inicio hasta el destino
    private List<V> buildPath(Map<V, V> predecessors, V goal) {
        LinkedList<V> path = new LinkedList<>();
        for (V v = goal; v != null; v = predecessors.get(v)) {
            path.addFirst(v);
        }
        return path;
    }
}
