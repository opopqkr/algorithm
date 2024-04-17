package study.dev.algorithm.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 특정한최단경로 {

    /**
     * INPUT
     * <p>
     * 4 6
     * 1 2 3
     * 2 3 3
     * 3 4 1
     * 1 3 5
     * 2 4 5
     * 1 4 4
     * 2 3
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        edgeInfo = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            edgeInfo.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            int[] temp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int a = temp[0], b = temp[1], c = temp[2];

            edgeInfo.get(a).add(new Edge(b, c));
            edgeInfo.get(b).add(new Edge(a, c));
        }

        st = new StringTokenizer(br.readLine());
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());

        System.out.println(solution());
    }

    private static int solution() {
        // 반드시 거쳐야 하는 정점들에 대해 나눠서 최단거리 구하기
        // case1) 1 -> v1 -> v2 -> N
        int case1 = dijkstra(1, v1) + dijkstra(v1, v2) + dijkstra(v2, N);
        // case2) 1 -> v2 -> v1 -> N
        int case2 = dijkstra(1, v2) + dijkstra(v2, v1) + dijkstra(v1, N);

        return case1 >= INF && case2 >= INF ? -1 : Math.min(case1, case2);
    }

    private static int dijkstra(int start, int end) {
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(new Edge(start, 0));

        int[] distances = new int[N + 1];
        Arrays.fill(distances, INF);

        while (!priorityQueue.isEmpty()) {
            Edge current = priorityQueue.poll();

            if (distances[current.vertex] < current.cost) continue;
            distances[current.vertex] = current.cost;

            for (Edge next : edgeInfo.get(current.vertex)) {
                int distance = current.cost + next.cost;
                if (distances[next.vertex] > distance) {
                    priorityQueue.offer(new Edge(next.vertex, distance));
                }
            }
        }

        return distances[end];
    }

    private static int N, E, v1, v2;

    private static final int INF = 200000000;

    private static ArrayList<ArrayList<Edge>> edgeInfo;

    private static class Edge implements Comparable<Edge> {

        int vertex, cost;

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
