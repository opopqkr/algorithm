package study.dev.algorithm.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * <a href="https://www.acmicpc.net/problem/14501">퇴사 14916번</a>
 */
public class 퇴사 {

    /**
     * INPUT
     * <p>
     * 7
     * 3 10
     * 5 20
     * 1 10
     * 1 20
     * 2 15
     * 4 40
     * 2 200
     * <p>
     * 10
     * 1 1
     * 1 2
     * 1 3
     * 1 4
     * 1 5
     * 1 6
     * 1 7
     * 1 8
     * 1 9
     * 1 10
     * <p>
     * 10
     * 5 10
     * 5 9
     * 5 8
     * 5 7
     * 5 6
     * 5 10
     * 5 9
     * 5 8
     * 5 7
     * 5 6
     * <p>
     * 10
     * 5 50
     * 4 40
     * 3 30
     * 2 20
     * 1 10
     * 1 10
     * 2 20
     * 3 30
     * 4 40
     * 5 50
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] T = new int[N + 2];
        int[] P = new int[N + 2];

        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(N, T, P));
    }

    private static int solution(int N, int[] T, int[] P) {
        int[] dp = new int[N + 2];

        for (int date = 1; date <= N + 1; date++) {
            // 현재 일자의 정산 금액 보다 어제의 정산 금액이 더 클 경우, 현재 일자의 정산 금액 update.
            if (dp[date] < dp[date - 1]) {
                dp[date] = dp[date - 1];
            }

            // 정산 일자 = 현재 일자 + 현재 일자에 상담 했을 때 걸리는 일자.
            int payDate = date + T[date];
            // 정산 일자가 퇴사일 보다 큰 경우, 정산 금액 계산 X.
            if (payDate > N + 1) continue;
            dp[payDate] = Math.max(dp[payDate], dp[date] + P[date]);
        }

        // 최종 정산일 = 퇴사일 = N + 1일
        return dp[N + 1];
    }
}
