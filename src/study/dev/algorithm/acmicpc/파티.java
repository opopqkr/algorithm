package study.dev.algorithm.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 파티 {

    /**
     * INPUT
     * <p>
     * 4 8 2
     * 1 2 4
     * 1 3 2
     * 1 4 7
     * 2 1 1
     * 2 3 5
     * 3 1 2
     * 3 4 4
     * 4 2 3
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken()), X = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(i, new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken()), E = Integer.parseInt(st.nextToken()), T = Integer.parseInt(st.nextToken());
            graph.get(S).add(new Node(E, T));
        }

        System.out.println(solution(X, graph));
    }

    private static int solution(int X, ArrayList<ArrayList<Node>> graph) {
        int answer = 0;

        for (int i = 1; i < graph.size(); i++) {
            // 시작지점에서 도착지점까지의 거리 + 도착지점에서 시작지점까지의 거리
            answer = Math.max(answer, dijkstra(i, X, graph) + dijkstra(X, i, graph));
        }

        return answer;
    }

    private static int dijkstra(int start, int end, ArrayList<ArrayList<Node>> graph) {
        int[] distances = new int[graph.size()];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[start] = 0;

        boolean[] visited = new boolean[graph.size()];

        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(new Node(start, 0));

        while (!priorityQueue.isEmpty()) {
            Node current = priorityQueue.poll();
            if (visited[current.E]) {
                continue;
            }
            visited[current.E] = true;

            for (Node next : graph.get(current.E)) {
                int distance = distances[current.E] + next.T;
                if (distances[next.E] > distance) {
                    distances[next.E] = distance;
                    priorityQueue.offer(new Node(next.E, distance));
                }
            }
        }

        return distances[end];
    }

    private static class Node implements Comparable<Node> {
        int E, T;

        public Node(int E, int T) {
            this.E = E;
            this.T = T;
        }

        @Override
        public int compareTo(Node o) {
            return this.T - o.T;
        }
    }
}
