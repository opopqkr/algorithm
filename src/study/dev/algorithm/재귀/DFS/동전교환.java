package study.dev.algorithm.재귀.DFS;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class 동전교환 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        Integer[] inputs = new Integer[n];
        for (int i = 0; i < n; i++) {
            inputs[i] = in.nextInt();
        }
        Arrays.sort(inputs, Collections.reverseOrder());
        int m = in.nextInt();
        dfs(n, m, inputs, 0, 0);
        System.out.println(answer);
    }

    private static int answer = Integer.MAX_VALUE;

    private static void dfs(int n, int m, Integer[] inputs, int count, int sum) {
        if (sum > m) {
            return;
        }
        if (count >= answer) {
            return;
        }
        if (sum == m) {
            answer = Math.min(count, answer);
        } else {
            for (int i = 0; i < n; i++) {
                dfs(n, m, inputs, count + 1, sum + inputs[i]);
            }
        }
    }
}
