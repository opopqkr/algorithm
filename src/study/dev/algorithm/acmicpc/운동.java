package study.dev.algorithm.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 운동 {

    /**
     * INPUT
     * <p>
     * 3 4
     * 1 2 1
     * 3 2 1
     * 1 3 5
     * 2 3 2
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken()), E = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()),
                    b = Integer.parseInt(st.nextToken()),
                    c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b, c));
        }

        solution();
    }

    private static final int INF = Integer.MAX_VALUE;
    private static ArrayList<ArrayList<Node>> graph;

    private static void solution() {
        int answer = INF;

        for (int i = 1; i < graph.size(); i++) {
            answer = Math.min(dijkstra(i), answer);
        }

        System.out.println(answer == INF ? -1 : answer);
    }

    private static int dijkstra(int start) {
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(new Node(start, 0));

        int[] distances = new int[graph.size()];
        Arrays.fill(distances, INF);

        while (!priorityQueue.isEmpty()) {
            Node current = priorityQueue.poll();

            if (distances[current.edge] < current.cost) continue;

            for (Node next : graph.get(current.edge)) {
                int cost = current.cost + next.cost;

                // 최소값 갱신
                if (cost < distances[next.edge]) {
                    distances[next.edge] = cost;
                    priorityQueue.offer(new Node(next.edge, cost));
                }
            }
        }

        return distances[start];
    }

    private static class Node implements Comparable<Node> {
        int edge, cost;

        public Node(int edge, int cost) {
            this.edge = edge;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}
