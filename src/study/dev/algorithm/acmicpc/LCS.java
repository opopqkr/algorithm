package study.dev.algorithm.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LCS {

    /**
     * INPUT
     * <p>
     * ACAYKP
     * CAPCAK
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String string1 = br.readLine(), string2 = br.readLine();

        int answer = Integer.MIN_VALUE;

        string1 = " " + string1;
        string2 = " " + string2;

        int[][] dp = new int[string1.length()][string2.length()];

        for (int i = 1; i < string1.length(); i++) {
            for (int j = 1; j < string2.length(); j++) {
                if (string1.charAt(i) == string2.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
                answer = Math.max(answer, dp[i][j]);
            }
        }

        System.out.println(answer);
    }
}
