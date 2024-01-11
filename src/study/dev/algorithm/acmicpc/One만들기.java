package study.dev.algorithm.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <a href="https://www.acmicpc.net/problem/1463">1로 만들기 1463번</a>
 */
public class One만들기 {

    /**
     * INPUT
     * <p>
     * 2
     * <p>
     * 10
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        System.out.println(solution(N));
    }

    private static int solution(int N) {
        int[] dp = new int[N + 4];
        dp[2] = 1; // 2로 나눌 수 있을 때의 횟수.
        dp[3] = 1; // 3으로 나눌 수 있을 때의 횟수.

        for (int i = 4; i <= N; i++) {
            if (i % 3 == 0 && i % 2 == 0) {
                // 3과 2 둘 다 나누어 질 경우, 현재 수(i) / 2를 만드는 최소 횟수 or 
                //                          현재 수(i) / 3을 만드는 최소 횟수 중 Minimum 
                //                          + 2 혹은 3으로 나눈 횟수(1회)
                dp[i] = Math.min(dp[i / 3], dp[i / 2]) + 1;
            } else if (i % 3 == 0) {
                // 3으로 나누어 질 경우, 현재 수(i) / 3을 만드는 최소 횟수 + 3으로 나눈 횟수(1회) or
                //                    이전 수를 만드는 최소 횟수 + 1을 뺀 횟수(1회) 중 Minimum
                // ex) 9 일 경우, 9 / 3인 3을 만드는 최소 횟수(1회) + 3으로 나눈 횟수(1회) = 2
                dp[i] = Math.min(dp[i / 3], dp[i - 1]) + 1;
            } else if (i % 2 == 0) {
                // 2로 나누어 질 경우, 현재 수(i) / 2를 만드는 최소 횟수 + 2로 나눈 횟수(1회) or
                //                  이전 수를 만드는 최소 횟수 + 1을 뺀 횟수(1회) 중 Minimum
                // ex) 8 일 경우, 8 / 2인 4를 만드는 최소 횟수(2회) + 2로 나눈 횟수(1회) = 3
                dp[i] = Math.min(dp[i / 2], dp[i - 1]) + 1;
            } else {
                // 3과 2 둘 다 나뉘어 지지 않을 경우가 있기 때문에(ex - 5, 7, 11) 이전 수를 만드는 최소 횟수 + 1을 뺀 횟수(1회)
                dp[i] = dp[i - 1] + 1;
            }
        }

        return dp[N];
    }
}
