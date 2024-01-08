package study.dev.algorithm.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 다리놓기 {

    /**
     * INPUT
     * <p>
     * 3
     * 2 2
     * 1 5
     * 13 29
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());

            System.out.println(solution(N, M));
        }
    }

    /**
     * 조합 문제.
     */
    private static int solution(int N, int M) {
        return combination(M, N);
    }

    // 조합 문제 임으로 다시 초기화 할 필요 없음.
    private final static int[][] dp = new int[30][30];

    private static int combination(int n, int r) {
        if (dp[n][r] > 0) {
            return dp[n][r];
        }

        if (n == r || r == 0) {
            return dp[n][r] = 1;
        }

        return dp[n][r] = combination(n - 1, r - 1) + combination(n - 1, r);
    }
}
