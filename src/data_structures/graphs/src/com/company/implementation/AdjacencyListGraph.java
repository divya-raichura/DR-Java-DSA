package com.company.implementation;

import java.util.*;

public class AdjacencyListGraph<T> {

    private LinkedList<Vertex> vertices;

    public AdjacencyListGraph() {
        this.vertices = new LinkedList<>();
    }

    public void addVertex(T value) {
        if (!vertices.contains(value)) {
            vertices.add(new Vertex(value));
        }
    }

    public void addEdge(T first, T second) {
        Vertex f = get(first);
        Vertex s = get(second);

        if (f != null && s != null) {
            f.neighbours.add(s);
            s.neighbours.add(f);
        }
    }

    public void display() {
        System.out.println("vertex -> it's neighbours");
        for (Vertex vertex : vertices) {
            System.out.print(vertex.value + " -> ");
            for (Vertex neighbours : vertex.neighbours) {
                System.out.print(neighbours.value + " ");
            }
            System.out.println();
        }
    }

    public boolean dfs(T value) {
        if (vertices.isEmpty())
            return false;

        Vertex vertex = vertices.get(0);

        Set<Vertex> visited = new HashSet<>();
        Stack<Vertex> stack = new Stack<>();

        stack.add(vertex);
        visited.add(vertex);

        while (!stack.isEmpty()) {
            Vertex top = stack.pop();
            System.out.print(top.value + " ");
            if (top.value.equals(value))
                return true;

            for (Vertex neighbour : top.neighbours) {
                if (!visited.contains(neighbour)) {
                    visited.add(neighbour);
                    stack.push(neighbour);
                }
            }
        }
        System.out.println();
        return false;
    }

    public boolean bfs(T value) {

        if (vertices.isEmpty()) {
            return false;
        }

        Queue<Vertex> queue = new LinkedList<>();
        Set<Vertex> visited = new HashSet<>();

        Vertex vertex = vertices.get(0);

        queue.add(vertex);
        visited.add(vertex);

        while (!queue.isEmpty()) {
            Vertex front = queue.remove();

            System.out.print(front.value + " ");
            if (front.value.equals(value))
                return true;

            for (Vertex neighbour : front.neighbours) {
                if (!visited.contains(neighbour)) {
                    visited.add(neighbour);
                    queue.add(neighbour);
                }
            }
        }
        System.out.println();
        return false;
    }

    public LinkedList<LinkedList<Vertex>> getConnectedComponents() {
        if (vertices.isEmpty()) {
            System.out.println("empty list!");
            return null;
        }

        Queue<Vertex> queue = new LinkedList<>();
        Set<Vertex> visited = new HashSet<>();

        LinkedList<LinkedList<Vertex>> list = new LinkedList<>();

        for (Vertex vertex : vertices) {
            if (visited.contains(vertex))
                continue;
            visited.add(vertex);
            queue.add(vertex);

            LinkedList<Vertex> level = new LinkedList<>();

            while (!queue.isEmpty()) {
                Vertex front = queue.remove();
                level.add(front);

                for (Vertex neighbour : vertices) {
                    if (!visited.contains(neighbour)) {
                        visited.add(neighbour);
                        queue.add(neighbour);
                    }
                }
            }
            list.add(level);
        }
        return list;
    }

    private Vertex get(T value) {
        for (Vertex vertex : vertices) {
            if (vertex.value.equals(value)) {
                return vertex;
            }
        }
        return null;
    }

    private class Vertex {
        T value;
        LinkedList<Vertex> neighbours;

        public Vertex(T value) {
            this.value = value;
            this.neighbours = new LinkedList<>();
        }
    }

}
