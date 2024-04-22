package study.dev.algorithm.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class 도시분할계획 {

    /**
     * INPUT
     * <p>
     * 7 12
     * 1 2 3
     * 1 3 2
     * 3 2 1
     * 2 5 2
     * 3 4 4
     * 7 3 6
     * 5 1 5
     * 1 6 2
     * 6 4 1
     * 6 5 3
     * 4 5 3
     * 6 7 4
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] temp;
        temp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = temp[0];
        M = temp[1];

        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            temp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int a = temp[0], b = temp[1], c = temp[2];

            graph.get(a).add(new Edge(b, c));
            graph.get(b).add(new Edge(a, c));
        }

        System.out.println(solutionWithPrimAlgorithm());
    }

    /**
     * 최소 신장 트리 (Minimum Spanning Tree) <br>
     * 모든 정점을 연결하는 트리, 단 사이클이 존재하지 않아야 함.
     * <p>
     * 크루스칼 알고리즘 혹은 프림 알고리즘으로 해결 가능하며,
     * 크루스칼 알고리즘은 Union-Find
     * <p>
     * 프림 알고리즘을 이용하여 해결하였으며,
     * 프림 알고리즘은 우선순위 큐를 이용.
     *
     * @return answer
     */
    private static int solutionWithPrimAlgorithm() {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(1, 0));

        boolean[] visited = new boolean[N + 1];

        // 도시를 연결하는 간선 중, 가장 큰 값을 제외.
        // 도시가 두개로 분할되며 최소값으로 도시를 구성하는 간선의 비용을 구할 수 있음.
        int answer = 0, maxCost = Integer.MIN_VALUE;
        while (!pq.isEmpty()) {
            Edge current = pq.poll();

            if (visited[current.v]) continue;

            visited[current.v] = true;
            answer += current.c;
            maxCost = Math.max(maxCost, current.c);

            for (Edge next : graph.get(current.v)) {
                if (!visited[next.v]) {
                    pq.offer(next);
                }
            }
        }

        return answer - maxCost;
    }

    private static int N, M;

    private static ArrayList<ArrayList<Edge>> graph;

    private static class Edge implements Comparable<Edge> {
        int v, c;

        public Edge(int v, int c) {
            this.v = v;
            this.c = c;
        }

        @Override
        public int compareTo(Edge o) {
            return this.c - o.c;
        }
    }
}
