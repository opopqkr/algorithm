package study.dev.algorithm.재귀.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 강의 풀이 (배열 이용)
 */
public class 그래프최단거리2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int a = in.nextInt();
            int b = in.nextInt();

            graph.get(a).add(b);
        }

        int[] answer = bfs(1, graph);
        for (int i = 2; i < answer.length; i++) {
            System.out.println(i + " : " + answer[i]);
        }
    }

    /**
     * 강의 풀이
     *
     * @param startNode
     * @param graph
     */
    private static int[] bfs(int startNode, ArrayList<ArrayList<Integer>> graph) {
        int[] distance = new int[graph.size()];
        boolean[] visited = new boolean[graph.size()];

        visited[startNode] = true;
        distance[startNode] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startNode);

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            for (int nextNode : graph.get(currentNode)) {
                if (!visited[nextNode]) {
                    visited[nextNode] = true;
                    queue.offer(nextNode);
                    distance[nextNode] = distance[currentNode] + 1;
                }
            }
        }

        return distance;
    }
}