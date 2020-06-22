package graph;

import java.util.*;

public class Graph_BFS<T> {

    private static class Vertex<T> {
        T data;
        boolean visited;
        Vertex(T data) {
            this.data = data;
            this.visited = false;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }

    private Map<T, LinkedList<Vertex>> adjMap;
    private Map<T, Vertex<T>> vertexMap;

    private Graph_BFS(int vertices) {
        this.adjMap = new HashMap<>();
        this.vertexMap = new HashMap<>(vertices);
    }

    private void addVertex(T data) {
        if(adjMap.containsKey(data)) {
            return;
        }
        Vertex<T> v = new Vertex<>(data);
        vertexMap.put(data, v);
        adjMap.put(data, new LinkedList<>());
    }

    private void addEdge(T source, T destination) {
        if(adjMap.containsKey(source) && adjMap.containsKey(destination)) {
            Vertex<T> dest = vertexMap.get(destination);
            adjMap.get(source).add(dest);
        }
    }

    private void doBFS(T startVertex) {
        if(!adjMap.containsKey(startVertex))
            return;
        Queue<Vertex<T>> q = new LinkedList<>();
        q.offer(vertexMap.get(startVertex));
        while (!q.isEmpty()) {
            Vertex<T> v = q.poll();
            v.visited = true;
            System.out.print(v + " ");
            for(Vertex neighbor : adjMap.get(v.data)) {
                if(!neighbor.visited) {
                    neighbor.visited = true;
                    q.offer(neighbor);
                }
            }
        }
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        for (T key : adjMap.keySet()) {
            builder.append(key.toString() + ": ");
            for (Vertex v : adjMap.get(key)) {
                builder.append(v.toString() + " ");
            }
            builder.append("\n");
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        Graph_BFS<Integer> graph = new Graph_BFS<>(5);
        graph.addVertex(0);
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);

        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(1, 4);
        graph.addEdge(3, 2);
        graph.addEdge(2, 4);

        System.out.println(graph);

        graph.doBFS(0);
    }

}
