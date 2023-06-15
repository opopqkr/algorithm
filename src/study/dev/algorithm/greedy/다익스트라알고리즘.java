package study.dev.algorithm.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 다익스트라의 전제 조건, 가중치가 모두 양수여야 함.
 */
public class 다익스트라알고리즘 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();

        // 그래프
        ArrayList<ArrayList<Edge>> graph = new ArrayList<ArrayList<Edge>>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Edge>());
        }

        for (int i = 0; i < m; i++) {
            graph.get(in.nextInt()).add(new Edge(in.nextInt(), in.nextInt()));
        }

        int[] costs = solution(n, graph, 1);

        for (int i = 2; i <= n; i++) {
            if (costs[i] != Integer.MAX_VALUE) {
                System.out.println(i + " : " + costs[i]);
            } else {
                System.out.println(i + " : impossible");
            }
        }
    }

    private static int[] solution(int n, ArrayList<ArrayList<Edge>> graph, int vertex) {
        int[] costs = new int[n + 1];
        Arrays.fill(costs, Integer.MAX_VALUE);

        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();
        // 초기화
        costs[vertex] = 0;
        priorityQueue.offer(new Edge(vertex, 0));

        while (!priorityQueue.isEmpty()) {
            Edge currentEdge = priorityQueue.poll();
            int currentVertex = currentEdge.vertex;
            int currentCost = currentEdge.cost;

            // 기존의 간선간의 비용 보다 현재 비용이 더 크면 continue
            if (currentCost > costs[currentVertex])
                continue;

            for (Edge otherEdge : graph.get(currentVertex)) {
                if (costs[otherEdge.vertex] > currentCost + otherEdge.cost) {
                    costs[otherEdge.vertex] = currentCost + otherEdge.cost;
                    priorityQueue.offer(new Edge(otherEdge.vertex, currentCost + otherEdge.cost));
                }
            }
        }

        return costs;
    }

    private static class Edge implements Comparable<Edge> {
        int vertex;
        int cost;

        public Edge(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }
}
