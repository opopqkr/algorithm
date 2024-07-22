package study.dev.algorithm.programmers;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class 배달 {

    public static void main(String[] args) {
        System.out.println(solution(5,
                new int[][]{{1, 2, 1}, {2, 3, 3}, {5, 2, 2}, {1, 4, 2}, {5, 3, 1}, {5, 4, 2}}, 3));

        System.out.println(solution(6,
                new int[][]{{1, 2, 1}, {1, 3, 2}, {2, 3, 2}, {3, 4, 3}, {3, 5, 2}, {3, 5, 3}, {5, 6, 1}}, 4));

        // 반례
        System.out.println(solution(4, new int[][]{{1, 2, 0}, {1, 2, 1}, {2, 3, 1}, {3, 4, 1}}, 2));
    }

    private static int solution(int N, int[][] road, int K) {
        graph = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] info : road) {
            int node1 = info[0], node2 = info[1], distance = info[2];
            graph.get(node1).add(new Edge(node2, distance));
            graph.get(node2).add(new Edge(node1, distance));
        }

        return dijkstra(N, K);
    }

    private static int dijkstra(int N, int K) {
        int count = 0;

        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(new Edge(1, 0));

        boolean[] visited = new boolean[N + 1];

        while (!priorityQueue.isEmpty()) {
            Edge current = priorityQueue.poll();

            // 우선순위 큐이기 때문에 거리가 짧은 순으로 poll, 즉 linkNode 중 가장 거리가 짧은 순으로 poll.
            if (visited[current.linkNode])
                continue;

            visited[current.linkNode] = true;
            count++;

            for (Edge next : graph.get(current.linkNode)) {
                if (current.distance + next.distance <= K) {
                    priorityQueue.offer(new Edge(next.linkNode, current.distance + next.distance));
                }
            }
        }

        return count;
    }

    private static ArrayList<ArrayList<Edge>> graph;

    private static class Edge implements Comparable<Edge> {
        int linkNode, distance;

        public Edge(int linkNode, int distance) {
            this.linkNode = linkNode;
            this.distance = distance;
        }

        @Override
        public int compareTo(Edge o) {
            return this.distance - o.distance;
        }
    }
}
