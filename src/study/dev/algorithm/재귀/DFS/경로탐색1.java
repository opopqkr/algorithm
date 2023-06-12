package study.dev.algorithm.재귀.DFS;

import java.util.Scanner;

/**
 * 인접 행렬 이용
 */
public class 경로탐색1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        int[][] graph = new int[n + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            graph[a][b] = 1;
        }

        int[] check = new int[n + 1];
        check[2] = 1;
        dfs(2, n, check, graph);
        System.out.println(answer);
    }

    private static int answer = 0;

    private static void dfs(int startPoint, int n, int[] check, int[][] graph) {
        if (startPoint == n) {
            answer++;
        } else {
            for (int i = 1; i <= n; i++) {
                if (graph[startPoint][i] == 1 && check[i] == 0) {
                    check[i] = 1;
                    dfs(i, n, check, graph);

                    // 경로 체크 후 재귀를 빠져나오면 경로 재사용을 위해 다시 0으로 변경
                    check[i] = 0;
                }
            }
        }
    }
}
