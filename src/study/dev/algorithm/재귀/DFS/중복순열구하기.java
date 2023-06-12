package study.dev.algorithm.재귀.DFS;

import java.util.Scanner;

public class 중복순열구하기 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();
        int[] inputs = new int[m];

        dfs(n, m, inputs, 0);
    }

    /**
     * 강의 풀이
     *
     * @param n
     * @param m
     * @param inputs
     * @param index
     */
    private static void dfs(int n, int m, int[] inputs, int index) {
        if (index == m) {
            for (int i : inputs) {
                System.out.print(i + " ");
            }
            System.out.println();
        } else {
            for (int i = 1; i <= n; i++) {
                inputs[index] = i;
                dfs(n, m, inputs, index + 1);
            }
        }
    }
}
