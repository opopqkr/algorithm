package study.dev.algorithm.programmers;

import java.util.Arrays;

public class 정수삼각형 {

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}}));
    }

    public static int solution(int[][] triangle) {
        int[][] dp = new int[triangle.length][triangle.length];
        dp[0][0] = triangle[0][0];

        for (int i = 1; i < triangle.length; i++) {
            // 왼쪽
            dp[i][0] = dp[i - 1][0] + triangle[i][0];

            // 중간
            for (int j = 1; j < triangle[i].length - 1; j++) {
                dp[i][j] = Math.max(dp[i - 1][j - 1] + triangle[i][j], dp[i - 1][j] + triangle[i][j]);
            }

            // 오른쪽
            dp[i][i] = dp[i - 1][i - 1] + triangle[i][i];
        }

        return Arrays.stream(dp[triangle.length - 1]).max().orElse(0);
    }
}
