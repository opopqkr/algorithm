package study.dev.algorithm.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 바이러스 {

    /**
     * INPUT
     * <p>
     * 7
     * 6
     * 1 2
     * 2 3
     * 1 5
     * 5 2
     * 5 6
     * 4 7
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int C = Integer.parseInt(br.readLine()), N = Integer.parseInt(br.readLine());

        // union & find 방식 초기화
        disjointSet = new int[C + 1];
        for (int i = 1; i <= C; i++) {
            disjointSet[i] = i;
        }

        // bfs 방식 초기화
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= C; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < N; i++) {
            String[] temp = br.readLine().split(" ");
            int comp1 = Integer.parseInt(temp[0]), comp2 = Integer.parseInt(temp[1]);

            // union
            union(comp1, comp2);

            // graph add
            graph.get(comp1).add(comp2);
            graph.get(comp2).add(comp1);
        }

        System.out.println(solutionWithBFS(graph));
        System.out.println(solutionWithUnionFind());
    }

    /**
     * BFS 방식 풀이
     *
     * @param graph - 그래프
     * @return - answer
     */
    private static int solutionWithBFS(ArrayList<ArrayList<Integer>> graph) {
        int count = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);

        boolean[] visited = new boolean[graph.size()];
        visited[1] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int next : graph.get(current)) {
                if (!visited[next]) {
                    visited[next] = true;
                    count++;
                    queue.offer(next);
                }
            }
        }

        return count;
    }

    private static int[] disjointSet;

    /**
     * union & find 방식 풀이
     *
     * @return - answer
     */
    private static int solutionWithUnionFind() {
        int count = 0;

        int root = disjointSet[1];
        for (int i = 2; i < disjointSet.length; i++) {
            if (root == find(i)) {
                count++;
            }
        }

        return count;
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x > y)
            disjointSet[x] = y;
        else
            disjointSet[y] = x;
    }

    private static int find(int x) {
        if (disjointSet[x] == x)
            return x;
        else
            return disjointSet[x] = find(disjointSet[x]);
    }
}
