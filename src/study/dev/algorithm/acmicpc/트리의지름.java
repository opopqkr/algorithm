package study.dev.algorithm.acmicpc;

import java.util.ArrayList;
import java.util.Scanner;

public class 트리의지름 {

    private static int answer = 0, node;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int v = in.nextInt();

        ArrayList<ArrayList<Edge>> tree = new ArrayList<>();
        for (int i = 0; i <= v; i++) {
            tree.add(i, new ArrayList<Edge>());
        }

        for (int i = 1; i <= v; i++) {
            int index = in.nextInt();
            while (true) {
                int node = in.nextInt();
                if (node == -1) {
                    break;
                } else {
                    tree.get(index).add(new Edge(node, in.nextInt()));
                }
            }
        }

        boolean[] visited;
        visited = new boolean[tree.size()];
        dfs(1, 0, tree, visited);

        visited = new boolean[tree.size()];
        dfs(node, 0, tree, visited);

        System.out.println(answer);
    }

    private static void dfs(int vertex, int cost, ArrayList<ArrayList<Edge>> tree, boolean[] visited) {
        if (cost > answer) {
            answer = cost;
            node = vertex;
        }

        visited[vertex] = true;

        for (int i = 0; i < tree.get(vertex).size(); i++) {
            Edge otherEdge = tree.get(vertex).get(i);
            if (!visited[otherEdge.vertex]) {
                dfs(otherEdge.vertex, otherEdge.cost + cost, tree, visited);
            }
        }
    }

    private static class Edge {
        int vertex, cost;

        public Edge(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }
    }
}