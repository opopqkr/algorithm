package study.dev.algorithm.dynamicprogramming;

import java.util.Scanner;

/**
 * 강의 풀이
 */
public class 최대점수구하기2 {

    private static int[] dp;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int timeLimit = in.nextInt();
        dp = new int[timeLimit + 1];

        Problem[] problems = new Problem[n];
        for (int i = 0; i < n; i++) {
            problems[i] = new Problem(in.nextInt(), in.nextInt());
        }

        System.out.println(solution(n, timeLimit, problems));
    }

    private static int solution(int n, int timeLimit, Problem[] problems) {
        for (int i = 0; i < n; i++) {
            Problem currentProblem = problems[i];
            // 주어진 문제의 갯수가 1개 이상이 아닌 경우는 뒤에서 부터
            for (int j = timeLimit; j >= currentProblem.time; j--) {
                dp[j] = Math.max(dp[j], dp[j - currentProblem.time] + currentProblem.score);
            }
        }

        return dp[timeLimit];
    }

    private static class Problem {
        int score, time;

        public Problem(int score, int time) {
            this.score = score;
            this.time = time;
        }
    }
}
