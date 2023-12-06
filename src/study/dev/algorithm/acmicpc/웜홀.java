package study.dev.algorithm.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 웜홀 {

    /**
     * INPUT
     * <p>
     * 2
     * 3 3 1
     * 1 2 2
     * 1 3 4
     * 2 3 1
     * 3 1 3
     * 3 2 1
     * 1 2 3
     * 2 3 4
     * 3 1 8
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());
        for (int i = 0; i < TC; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken()), W = Integer.parseInt(st.nextToken());

            ArrayList<ArrayList<Node>> graph = new ArrayList<>();

            for (int j = 0; j <= N; j++) {
                graph.add(j, new ArrayList<>());
            }

            for (int j = 0; j < M + W; j++) {
                st = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(st.nextToken()), E = Integer.parseInt(st.nextToken()), T = Integer.parseInt(st.nextToken());

                if (j < M) {
                    // 도로 양방향 그래프
                    graph.get(S).add(new Node(E, T));
                    graph.get(E).add(new Node(S, T));
                } else {
                    // 웜홀 단방향 그래프
                    graph.get(S).add(new Node(E, -T));
                }
            }

            String answer = bellmanFord(graph) ? "YES" : "NO";
            System.out.println(answer);
        }
    }

    private static boolean bellmanFord(ArrayList<ArrayList<Node>> graph) {
        int[] distances = new int[graph.size()];

        boolean update = false;
        for (int i = 1; i < graph.size(); i++) {
            update = false;

            for (int current = 1; current < graph.size(); current++) {
                for (Node next : graph.get(current)) {
                    int distance = distances[current] + next.T;
                    if (distances[next.E] > distance) {
                        distances[next.E] = distance;
                        update = true;
                    }
                }
            }
            if (!update) {
                break;
            }
        }

        return update;
    }

    private static class Node {
        int E, T;

        public Node(int E, int T) {
            this.E = E;
            this.T = T;
        }
    }
}
