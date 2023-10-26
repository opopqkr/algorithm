package study.dev.algorithm.programmers;

import java.util.LinkedList;
import java.util.Queue;

public class 네트워크BFS {

    public static void main(String[] args) {
        System.out.println(solution(3, new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
        System.out.println(solution(3, new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}}));
    }

    public static int solution(int n, int[][] computers) {
        int answer = n;

        boolean[] check = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!check[i]) {
                check[i] = true;
                answer -= bfs(i, check, computers);
            }
        }

        return answer;
    }

    private static int bfs(int start, boolean[] check, int[][] computers) {
        int count = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int i = 0; i < computers[current].length; i++) {
                if (!check[i] && computers[current][i] == 1) {
                    count++;
                    check[i] = true;
                    queue.offer(i);
                }
            }
        }

        return count;
    }
}
