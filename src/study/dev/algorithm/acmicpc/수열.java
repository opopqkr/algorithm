package study.dev.algorithm.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * <a href="https://www.acmicpc.net/problem/2491">수열 2491번</a>
 */
public class 수열 {

    /**
     * INPUT
     * <p>
     * 9
     * 1 2 2 4 4 5 7 7 2
     * <p>
     * 9
     * 4 1 3 3 2 2 9 2 3
     * <p>
     * 11
     * 1 5 3 6 4 7 1 3 2 9 5
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] inputs = new int[N + 1];
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            inputs[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        System.out.println(solution(N, inputs));
    }

    private static int solution(int N, int[] inputs) {
        int answer = 0;
        int[][] dp = new int[2][N + 1];
        // dp[0][N], 수열의 값이 증가할 경우 count 저장.
        // dp[1][N], 수열의 값이 감소할 경우 count 저장.

        for (int i = 1; i <= N; i++) {
            if (inputs[i - 1] < inputs[i]) { // 수열이 증가 하는 경우
                dp[0][i] = dp[0][i - 1] + 1; // 증가 값은 + 1
                dp[1][i] = 1; // 감소 값은 1로 변경
            } else if (inputs[i - 1] > inputs[i]) { // 수열이 감소 하는 경우
                dp[0][i] = 1; // 증가 값은 1로 변경
                dp[1][i] = dp[1][i - 1] + 1; // 감소 값은 + 1
            } else { // 같은 경우, 증가값 감소값 둘 다 + 1
                dp[0][i] = dp[0][i - 1] + 1;
                dp[1][i] = dp[1][i - 1] + 1;
            }
            answer = Math.max(answer, Math.max(dp[0][i], dp[1][i]));
        }

        return answer;
    }
}
