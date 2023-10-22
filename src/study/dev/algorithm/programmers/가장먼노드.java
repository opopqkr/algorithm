package study.dev.algorithm.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 가장먼노드 {

    public static void main(String[] args) {
        System.out.println(solution(6, new int[][]{{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}}));
    }

    public static int solution(int n, int[][] edge) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] node : edge) {
            graph.get(node[0]).add(node[1]);
            graph.get(node[1]).add(node[0]);
        }

        int answer = 0;
        int[] answerList = bfs(n, graph);

        int max = Arrays.stream(answerList).max().orElse(0);
        for (int i : answerList) {
            if (i == max) answer++;
        }

        return answer;
    }

    private static int[] bfs(int n, ArrayList<ArrayList<Integer>> graph) {
        Queue<Integer> queue = new LinkedList<>();
        int[] distances = new int[n + 1];

        queue.offer(1);
        distances[1] = 1;

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            int distance = distances[currentNode];

            for (int linkedNode : graph.get(currentNode)) {
                if (distances[linkedNode] == 0) {
                    distances[linkedNode] = distance + 1;
                    queue.offer(linkedNode);
                }
            }
        }

        return distances;
    }
}
