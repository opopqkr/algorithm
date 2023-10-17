package study.dev.algorithm.programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 전력망둘로나누기 {

    public static void main(String[] args) {
        System.out.println(solution(9, new int[][]{{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}}));
        System.out.println(solution(4, new int[][]{{1, 2}, {2, 3}, {3, 4}}));
        System.out.println(solution(7, new int[][]{{1, 2}, {2, 7}, {3, 7}, {3, 4}, {4, 5}, {6, 7}}));
    }

    public static int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        ArrayList<Integer>[] graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] wire : wires) {
            int v1 = wire[0], v2 = wire[1];
            graph[v1].add(v2);
            graph[v2].add(v1);
        }

        for (int[] wire : wires) {
            int v1 = wire[0], v2 = wire[1];

            int network1 = bfs(v1, v2, n, graph);
            int network2 = bfs(v2, v1, n, graph);

            answer = Math.min(answer, Math.abs(network1 - network2));
        }

        return answer;
    }

    /**
     * @param v1    연결을 끊고 새로 만들 전력망 네트워크의 기준이 되는 송전 탑
     * @param v2    연결을 끊을 송전 탑
     * @param n     송전 탑 갯수
     * @param graph 송전 탑 그래프
     * @return 연결을 끊은 이후의 송전 탑 갯수
     */
    private static int bfs(int v1, int v2, int n, ArrayList<Integer>[] graph) {
        int count = 0;

        Queue<Integer> queue = new LinkedList<>();
        boolean[] check = new boolean[n + 1];
        queue.offer(v1);
        check[v1] = true;

        while (!queue.isEmpty()) {
            int currentTop = queue.poll();
            count++;
            for (int linkedTop : graph[currentTop]) {
                // check 되어 있지 않고, 연결을 끊을 송전탑이 아닌 송전 탑 연결
                if (!check[linkedTop] && linkedTop != v2) {
                    check[linkedTop] = true;
                    queue.offer(linkedTop);
                }
            }
        }

        return count;
    }
}
