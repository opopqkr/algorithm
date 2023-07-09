package study.dev.algorithm.dynamicprogramming;

import java.util.Arrays;
import java.util.Scanner;

public class 최대부분증가수열 {

    // 최대 부분 증가수열의 길이를 저장
    private static int[] dp;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        dp = new int[n];

        int[] inputs = new int[n];
        for (int i = 0; i < n; i++) {
            inputs[i] = in.nextInt();
        }

        System.out.println(solution2(inputs));
    }

    private static int solution1(int[] inputs) {
        for (int i = 0; i < inputs.length; i++) {
            // i번째 까지의 길이를 1로 초기화.
            dp[i] = 1;

            // i 이전의 배열을 탐색
            for (int j = 0; j < i; j++) {
                // i번째 보다 작은 수가 있으면, i번째 길이 + 작은 수의 길이
                if (inputs[j] < inputs[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }

    private static int solution2(int[] inputs) {
        int answer = 0;

        dp[0] = 1;
        for (int i = 1; i < inputs.length; i++) {
            int max = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (inputs[j] < inputs[i] && dp[j] > max) {
                    max = dp[j];
                }
            }
            dp[i] = max + 1;
            answer = Math.max(answer, dp[i]);
        }

        return answer;
    }

}
