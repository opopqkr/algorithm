package study.dev.algorithm.재귀.DFS;

import java.util.Scanner;

public class 최대점수구하기2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();
        int[] scores = new int[n];
        int[] times = new int[n];
        for (int i = 0; i < n; i++) {
            scores[i] = in.nextInt();
            times[i] = in.nextInt();
        }

        dfs(n, m, scores, times, 0, 0, 0);
        System.out.println(answer);
    }

    private static int answer = Integer.MIN_VALUE;

    /**
     * 강의 풀이
     *
     * @param n
     * @param m
     * @param scores
     * @param times
     * @param startPoint
     * @param sum
     * @param time
     */
    private static void dfs(int n, int m, int[] scores, int[] times,
                            int startPoint, int sum, int time) {
        if (time > m) {
            return;
        }
        if (startPoint == n) {
            answer = Math.max(sum, answer);
        } else {
            dfs(n, m, scores, times, startPoint + 1, sum + scores[startPoint], time + times[startPoint]);
            dfs(n, m, scores, times, startPoint + 1, sum, time);
        }
    }
}
