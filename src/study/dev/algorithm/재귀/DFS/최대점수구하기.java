package study.dev.algorithm.재귀.DFS;

import java.util.Scanner;

public class 최대점수구하기 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();

        int[][] inputs = new int[n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                inputs[i][j] = in.nextInt();
            }
        }

        dfs(m, n, inputs, 0, 0, 0);
        System.out.println(score);
    }

    private static int score = Integer.MIN_VALUE;

    /**
     * 내 풀이
     *
     * @param m
     * @param n
     * @param inputs
     * @param startPoint
     * @param sum
     * @param time
     */
    private static void dfs(int m, int n, int[][] inputs, int startPoint, int sum, int time) {
        if (time > m) {
            return;
        }
        if (startPoint == n) {
            score = Math.max(sum, score);
            return;
        } else {
            dfs(m, n, inputs, startPoint + 1, sum + inputs[startPoint][0], time + inputs[startPoint][1]);
            dfs(m, n, inputs, startPoint + 1, sum, time);
        }
    }
}
