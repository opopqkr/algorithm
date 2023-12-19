package study.dev.algorithm.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 최소비용구하기 {

    /**
     * INPUT
     * <p>
     * 5
     * 8
     * 1 2 2
     * 1 3 3
     * 1 4 1
     * 1 5 10
     * 2 4 2
     * 3 4 1
     * 3 5 1
     * 4 5 3
     * 1 5
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<City>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(i, new ArrayList<>());
        }

        int M = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            graph.get(Integer.parseInt(st.nextToken()))
                    .add(new City(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken()), end = Integer.parseInt(st.nextToken());

        System.out.println(dijkstra(start, end, graph));
    }

    private static int dijkstra(int start, int end, ArrayList<ArrayList<City>> graph) {
        int[] costs = new int[graph.size()];
        Arrays.fill(costs, Integer.MAX_VALUE);
        costs[start] = 0;

        boolean[] visited = new boolean[graph.size()];

        PriorityQueue<City> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(new City(start, 0));

        while (!priorityQueue.isEmpty()) {
            City current = priorityQueue.poll();

            if (visited[current.city]) {
                continue;
            }

            visited[current.city] = true;

            for (City next : graph.get(current.city)) {
                int cost = costs[current.city] + next.cost;
                if (costs[next.city] > cost) {
                    costs[next.city] = cost;
                    priorityQueue.offer(new City(next.city, cost));
                }
            }
        }

        return costs[end];
    }

    private static class City implements Comparable<City> {
        int city, cost;

        public City(int city, int cost) {
            this.city = city;
            this.cost = cost;
        }

        @Override
        public int compareTo(City o) {
            return this.cost - o.cost;
        }
    }
}
