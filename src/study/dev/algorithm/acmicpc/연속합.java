package study.dev.algorithm.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 연속합 {

    /**
     * INPUT
     * <p>
     * 10
     * 10 -4 3 1 5 6 -35 12 21 -1
     * <p>
     * 10
     * 2 1 -4 3 4 -4 6 5 -5 1
     * <p>
     * 5
     * -1 -2 -3 -4 -5
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] inputs = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            inputs[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(n, inputs));
    }

    private static int solution(int n, int[] inputs) {
        int[] dp = new int[n + 1];
        dp[0] = -1000; // 가장 작은 수로 초기화.

        for (int i = 1; i <= n; i++) {
            // 이전 연속합의 값 + 현재 수열의 값 or 현재 수열의 값 중 Maximum.
            dp[i] = Math.max(dp[i - 1] + inputs[i], inputs[i]);
        }

        return Arrays.stream(dp).max().getAsInt();
    }
}
