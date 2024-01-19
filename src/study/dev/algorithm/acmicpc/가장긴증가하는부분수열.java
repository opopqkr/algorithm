package study.dev.algorithm.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 가장긴증가하는부분수열 {

    /**
     * INPUT
     * <p>6
     * * 10 20 10 30 20 50
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] inputs = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            inputs[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(N, inputs));
    }

    private static int solution(int N, int[] inputs) {
        int[] dp = new int[N + 1];
        Arrays.fill(dp, 1); // 수열내 모든 원소의 최소 길이는 1

        for (int current = 1; current <= N; current++) {
            for (int before = 1; before < current; before++) {
                // 1번째 원소부터 비교하려는 현재 원소까지 반복하면서,
                // 비교하려는 현재 원소보다 작은 원소가 있다면 현재 원소의 최대 길이 update.
                if (inputs[before] < inputs[current]) {
                    // 이전 최대 길이 + 1 or 현재 원소의 길이 중 Maximum
                    dp[current] = Math.max(dp[before] + 1, dp[current]);
                }
            }
        }

        return Arrays.stream(dp).max().orElse(1);
    }
}
