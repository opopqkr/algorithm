package study.dev.algorithm.acmicpc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 최단거리 {

    /**
     * INPUT
     * <p>
     * 5 6
     * 1
     * 5 1 1
     * 1 2 2
     * 1 3 3
     * 2 3 4
     * 2 4 5
     * 3 4 6
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int V = in.nextInt();
        int E = in.nextInt();

        int K = in.nextInt();

        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            graph.add(i, new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            int u = in.nextInt(), v = in.nextInt(), w = in.nextInt();
            // 단 방향 그래프 연결.
            graph.get(u).add(new Edge(v, w));
        }

        int[] answer = dijkstra(K, V, graph);

        for (int i = 1; i <= V; i++) {
            if (answer[i] == Integer.MAX_VALUE)
                System.out.println("INF");
            else
                System.out.println(answer[i]);
        }
    }

    private static int[] dijkstra(int K, int V, ArrayList<ArrayList<Edge>> graph) {
        int[] distances = new int[V + 1];
        Arrays.fill(distances, Integer.MAX_VALUE);

        boolean[] visited = new boolean[V + 1];

        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(new Edge(K, 0));

        while (!priorityQueue.isEmpty()) {
            Edge current = priorityQueue.poll();

            if (visited[current.v]) {
                continue;
            }

            distances[current.v] = current.w;
            visited[current.v] = true;

            for (Edge edge : graph.get(current.v)) {
                int distance = current.w + edge.w;
                if (distance < distances[edge.v]) {
                    priorityQueue.offer(new Edge(edge.v, distance));
                }
            }
        }

        return distances;
    }

    private static class Edge implements Comparable<Edge> {
        int v, w;

        public Edge(int v, int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return this.w - o.w;
        }
    }
}
