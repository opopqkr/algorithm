package study.dev.algorithm.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 카드구매하기 {

    /**
     * INPUT
     * <p>
     * 4
     * 1 5 6 7
     * <p>
     * 5
     * 10 9 8 7 6
     * <p>
     * 10
     * 1 1 2 3 5 8 13 21 34 55
     * <p>
     * 10
     * 5 10 11 12 13 30 35 40 45 47
     * <p>
     * 4
     * 5 2 8 10
     * <p>
     * 4
     * 3 5 15 16
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] P = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            P[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(N, P));
    }

    private static int solution(int N, int[] P) {
        int[] dp = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                // 카드 구매 갯수가 1개(i)일 경우, 저장된 0개의 카드팩 구매 비용(dp[0]) + 1개의 카드팩 구매 비용(P[1])
                //
                // 카드 구매 갯수가 2개(i)일 경우, 저장된 1개의 카드팩 구매 비용(dp[1]) + 1개의 카드팩 구매 비용(P[1]) or
                //                             저장된 0개의 카드팩 구매 비용(dp[0]) + 2개의 카드팩 구매 비용(P[2]) 중 최대 값
                //
                // 카드 구매 갯수가 3개(i)일 경우, 저장된 2개의 카드팩 구매 비용(dp[2]) + 1개의 카드팩 구매 비용(P[1]) or
                //                             저장된 1개의 카드팩 구매 비용(dp[1]) + 2개의 카드팩 구매 비용(P[2]) or
                //                             저장된 0개의 카드팩 구매 비용(dp[0]) + 3개의 카드팩 구매 비용(P[3]) 중 최대 값
                // ...
                dp[i] = Math.max(dp[i], dp[i - j] + P[j]);
            }
        }

        return dp[N];
    }

}