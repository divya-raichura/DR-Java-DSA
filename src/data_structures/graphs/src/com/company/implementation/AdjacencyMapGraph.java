package com.company.implementation;

import com.company.practice.Dj;

import java.util.*;

public class AdjacencyMapGraph<T> {
    Map<T, Vertex> vertices;
    Map<Vertex, Vertex> parents;

    public AdjacencyMapGraph() {
        vertices = new HashMap<>();
    }

    public void addVertex(T value) {
        if (!vertices.containsKey(value)) {
            vertices.put(value, new Vertex(value));
        }
    }

    public void addEdge(T first, T second, int weight) {
        if (vertices.containsKey(first) && vertices.containsKey(second)) {
            vertices.get(first).addNeighbours(second, weight);
            vertices.get(second).addNeighbours(first, weight);
        }
    }

    public void bft() {
        if (vertices.isEmpty()) {
            System.out.println("empty graph!");
            return;
        }

        Vertex vertex = vertices.values().iterator().next();

        Queue<Vertex> queue = new LinkedList<>();
        Set<Vertex> vis = new HashSet<>();

        queue.add(vertex);
        vis.add(vertex);

        while (!queue.isEmpty()) {
            Vertex top = queue.remove();

            System.out.print(top.value + " ");

            for (Vertex ne : top.neighbours.keySet()) {
                if (!vis.contains(ne)) {
                    vis.add(ne);
                    queue.add(ne);
                }
            }
        }
    }

    public void refreshUnion() {
        parents = new HashMap<>();
        for (Vertex vertex : vertices.values()) {
            parents.put(vertex, null);
        }
    }

    public Vertex find(Vertex vertex) {
        while (parents.get(vertex) != null) {
            vertex = parents.get(vertex);
        }
        return vertex;
    }

    public void union(Vertex first, Vertex second) {
        parents.put(find(first), find(second));
    }

    public int mstKruskal() {
        refreshUnion();

        int mstSum = 0;
        LinkedList<Edge> result = new LinkedList<>();
        ArrayList<Edge> edges = new ArrayList<>();

        for (Vertex vertex : vertices.values()) {
            for (Vertex ne : vertex.neighbours.keySet()) {
                edges.add(new Edge(vertex, ne, vertex.neighbours.get(ne)));
            }
        }
        edges.sort(Comparator.comparingInt((Edge o) -> o.weight));

        for (Edge edge : edges) {
            if (find(edge.first) != find(edge.second)) {
                result.add(edge);
                union(edge.first, edge.second);
                mstSum += edge.weight;
            }
        }

        for (Edge edge : result) {
            System.out.println(edge.first + " <--" + edge.weight + "--> " + edge.second);
        }

        return mstSum;
    }

    public int prims() {
        refreshUnion();
        if (vertices.isEmpty()) {
            System.out.println("empty graph");
            return 0;
        }

        int mstSum = 0;

        Set<Vertex> vis = new HashSet<>();
        PriorityQueue<Edge> pq = new PriorityQueue<>();

        Vertex vertex = vertices.values().iterator().next();

        vis.add(vertex);

        for (Vertex ne : vertex.neighbours.keySet()) {
            pq.add(new Edge(vertex, ne, vertex.neighbours.get(ne)));
        }
        while (!pq.isEmpty()) {
            Edge edge = pq.remove();
            if (vis.contains(edge.first) && vis.contains(edge.second)) {
                continue;
            }
            mstSum += edge.weight;
            if (!vis.contains(edge.first)) {
                for (Vertex ne : edge.first.neighbours.keySet()) {
                    pq.add(new Edge(edge.first, ne, edge.first.neighbours.get(ne)));
                }
                vis.add(edge.first);
            }

            if (!vis.contains(edge.second)) {
                for (Vertex ne : edge.second.neighbours.keySet()) {
                    pq.add(new Edge(edge.second, ne, edge.second.neighbours.get(ne)));
                }
                vis.add(edge.second);
            }
        }
        return mstSum;
    }

    private class Vertex {
        T value;
        Map<Vertex, Integer> neighbours;

        public Vertex(T value) {
            this.value = value;
            neighbours = new HashMap<>();
        }

        public void addNeighbours(T value, int weight) {
            neighbours.put(vertices.get(value), weight);
        }
    }

    private class Edge implements Comparable<Edge> {

        Vertex first;
        Vertex second;
        int weight;

        public Edge(Vertex first, Vertex second, int weight) {
            this.first = first;
            this.second = second;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }
}
