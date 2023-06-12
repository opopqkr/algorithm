package study.dev.algorithm.재귀.DFS;

import java.util.Scanner;

public class 수열추측하기 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int f = in.nextInt();

        combination = new int[n][n];
        int[] combinationList = new int[n]; // combination
        for (int i = 0; i < n; i++) {
            combinationList[i] = createCombination(n - 1, i);
        }

        int[] result = new int[n];
        boolean[] check = new boolean[n + 1];
        dfs(n, f, combinationList, result, check, 0, 0);
    }

    private static boolean stop = false;

    private static void dfs(int n, int f, int[] combinationList, int[] result, boolean[] check, int index, int sum) {
        if (stop) {
            return;
        }
        if (sum > f) {
            return;
        }
        if (index == n) {
            if (sum == f) {
                for (int i : result) {
                    System.out.print(i + " ");
                }
                stop = true;
            }
        } else {
            for (int i = 1; i <= n; i++) {
                if (!check[i]) {
                    result[index] = i;
                    check[i] = true;
                    dfs(n, f, combinationList, result, check, index + 1, sum + (result[index] * combinationList[index]));
                    check[i] = false;
                }
            }
        }
    }

    private static int[][] combination;

    private static int createCombination(int n, int r) {
        if (combination[n][r] > 0) {
            return combination[n][r];
        }
        if (n == r || r == 0) {
            return combination[n][r] = 1;
        } else {
            return combination[n][r] = createCombination(n - 1, r - 1) + createCombination(n - 1, r);
        }
    }
}
