package study.dev.algorithm.dynamicprogramming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * 내 풀이
 */
public class 최대점수구하기1 {

    private static int[][] dp;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int timeLimit = in.nextInt();

        ArrayList<Problem> problems = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            problems.add(new Problem(in.nextInt(), in.nextInt()));
        }

        dp = new int[n + 1][timeLimit + 1];
        System.out.println(solution(n, timeLimit, problems));
    }

    private static int solution(int n, int timeLimit, ArrayList<Problem> problems) {
        Collections.sort(problems);

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= timeLimit; j++) {
                if (j >= problems.get(i - 1).time) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - problems.get(i - 1).time] + problems.get(i - 1).score);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][timeLimit];
    }

    private static class Problem implements Comparable<Problem> {
        int score, time;

        public Problem(int score, int time) {
            this.score = score;
            this.time = time;
        }

        @Override
        public int compareTo(Problem o) {
            return this.time - o.time;
        }
    }
}
