package study.dev.algorithm.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 가장큰증가하는부분수열 {

    /**
     * INPUT
     * <p>
     * 10
     * 1 100 2 50 60 3 5 6 7 8
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arrays = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arrays[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(N, arrays));
    }

    private static int solution(int N, int[] arrays) {
        // dp에 배열 값 clone
        int[] dp = arrays.clone();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) { // 0번째 부터 i까지 비교 반복
                // i번째 보다 값이 작을 경우,
                // 현재 dp의 값(가장 큰 증가수열의 합) or
                // 현재 i번째 값 + j까지 가장 큰 증가 수열 값 중에 Maximum
                if (arrays[i] > arrays[j]) {
                    dp[i] = Math.max(dp[i], arrays[i] + dp[j]);
                }
            }
        }

        return Arrays.stream(dp).max().getAsInt();
    }
}
