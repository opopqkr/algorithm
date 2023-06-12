package study.dev.algorithm.재귀.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 내 풀이 (상태 트리 이용)
 */
public class 그래프최단거리1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();

        // 인접행렬 풀이
        // int[][] graph1 = new int[n + 1][n + 1];
        // for (int i = 0; i < m; i++) {
        //     int a = in.nextInt();
        //     int b = in.nextInt();

        //     graph1[a][b] = 1;
        // }

        // int[] answer = bfs1(1, graph1);
        // for (int i = 2; i < answer.length; i++) {
        //     System.out.println(i + " : " + answer[i]);
        // }

        ArrayList<ArrayList<Integer>> graph2 = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph2.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            graph2.get(a).add(b);
        }

        int[] answer = bfs2(1, graph2);
        for (int i = 2; i < answer.length; i++) {
            System.out.println(i + " : " + answer[i]);
        }
    }

    /**
     * 내 풀이 (인접행렬 이용)
     *
     * @param startPoint
     * @param graph
     * @return
     */
    private static int[] bfs1(int startPoint, int[][] graph) {
        int[] answer = new int[graph.length];

        boolean[] visited = new boolean[graph.length];
        visited[startPoint] = true;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startPoint);

        int distance = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                int currentNode = queue.poll();
                answer[currentNode] = distance;
                for (int j = 0; j < graph.length; j++) {
                    int nextNode = graph[currentNode][j];
                    if (nextNode == 1 && !visited[j]) {
                        queue.offer(j);
                        visited[j] = true;
                    }
                }
            }
            distance++;
        }
        return answer;
    }

    /**
     * 내 풀이 (인접리스트 이용)
     *
     * @param startPoint
     * @param graph2
     * @return
     */
    private static int[] bfs2(int startPoint, ArrayList<ArrayList<Integer>> graph2) {
        int[] answer = new int[graph2.size()];

        boolean[] visited = new boolean[graph2.size()];
        visited[startPoint] = true;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startPoint);

        int distance = 0;
        while (!queue.isEmpty()) {
            int length = queue.size();
            for (int i = 0; i < length; i++) {
                int currentNode = queue.poll();
                answer[currentNode] = distance;
                for (int nextNode : graph2.get(currentNode)) {
                    if (!visited[nextNode]) {
                        queue.offer(nextNode);
                        visited[nextNode] = true;
                    }
                }
            }
            distance++;
        }
        return answer;
    }
}
