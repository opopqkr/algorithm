package study.dev.algorithm.acmicpc;

import java.util.Scanner;

/**
 * <a href="https://www.acmicpc.net/problem/11726">2xn 타일링 11726번</a>
 */
public class TwoXn타일링 {

    /**
     * INPUT
     * <p>
     * 2
     * <p>
     * 9
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        System.out.println(solution(n));
    }

    private static int solution(int n) {
        int[] dp = new int[n + 2];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            // 10007로 나머지 연산을 한 이유
            // = 기본 자료형으로만 계산이 불가하여 10000 보다 큰 최소 소수로 나눈 나머지 값을 이용
            dp[i] = (dp[i - 2] + dp[i - 1]) % 10007;
        }

        return dp[n];
    }
}
