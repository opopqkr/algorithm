package study.dev.algorithm.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class 최소스패닝트리 {

    /**
     * INPUT
     * <p>
     * 3 3
     * 1 2 1
     * 2 3 2
     * 1 3 3
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken()), E = Integer.parseInt(st.nextToken());

        disjointSet = new int[V + 1];
        for (int i = 1; i <= V; i++) {
            disjointSet[i] = i;
        }

        edges = new ArrayList<>();
        while (E-- > 0) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken()),
                    B = Integer.parseInt(st.nextToken()),
                    C = Integer.parseInt(st.nextToken());

            edges.add(new Edge(A, B, C));
        }

        System.out.println(solutionWithKruskal());
    }

    private static int solutionWithKruskal() {
        Collections.sort(edges);
        int answer = 0;

        for (Edge edge : edges) {
            if (find(edge.vertex1) != find(edge.vertex2)) {
                union(edge.vertex1, edge.vertex2);
                answer += edge.cost;
            }
        }

        return answer;
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y)
            disjointSet[x] = y;
    }

    private static int find(int x) {
        if (disjointSet[x] == x) return x;
        else return disjointSet[x] = find(disjointSet[x]);
    }

    private static int[] disjointSet;

    private static ArrayList<Edge> edges;

    private static class Edge implements Comparable<Edge> {
        int vertex1, vertex2, cost;

        public Edge(int vertex1, int vertex2, int cost) {
            this.vertex1 = vertex1;
            this.vertex2 = vertex2;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }
}
