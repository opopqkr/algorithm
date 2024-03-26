package study.dev.algorithm.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 내려가기 {

    /**
     * INPUT
     * <p>
     * 3
     * 1 2 3
     * 4 5 6
     * 4 9 0
     * <p>
     * 3
     * 0 0 0
     * 0 0 0
     * 0 0 0
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        inputs = new int[N][3];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                inputs[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(solution());
    }

    private static int N;

    private static int[][] inputs;

    private static String solution() {
        int[][] minDp = new int[N][3];
        int[][] maxDp = new int[N][3];
        minDp[0] = maxDp[0] = inputs[0].clone();

        for (int i = 1; i < N; i++) {
            minDp[i][0] = Math.min(minDp[i - 1][0], minDp[i - 1][1]) + inputs[i][0];
            maxDp[i][0] = Math.max(maxDp[i - 1][0], maxDp[i - 1][1]) + inputs[i][0];

            minDp[i][1] = Math.min(Math.min(minDp[i - 1][0], minDp[i - 1][1]), minDp[i - 1][2]) + inputs[i][1];
            maxDp[i][1] = Math.max(Math.max(maxDp[i - 1][0], maxDp[i - 1][1]), maxDp[i - 1][2]) + inputs[i][1];

            minDp[i][2] = Math.min(minDp[i - 1][1], minDp[i - 1][2]) + inputs[i][2];
            maxDp[i][2] = Math.max(maxDp[i - 1][1], maxDp[i - 1][2]) + inputs[i][2];
        }

        return Arrays.stream(maxDp[N - 1]).max().orElse(0) +
                " " + Arrays.stream(minDp[N - 1]).min().orElse(0);
    }
}
