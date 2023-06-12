package study.dev.algorithm.재귀.DFS;

import java.util.Scanner;

public class 순열구하기 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();
        int[] inputs = new int[n];
        int[] outputs = new int[m];
        for (int i = 0; i < n; i++) {
            inputs[i] = in.nextInt();
        }
        boolean[] check = new boolean[n];
        dfs(n, m, inputs, outputs, check, 0);
    }

    private static void dfs(int n, int m, int[] inputs, int[] outputs, boolean[] check, int index) {
        if (index == m) {
            for (int i : outputs) {
                System.out.print(i + " ");
            }
            System.out.println();
        } else {
            for (int i = 0; i < n; i++) {
                if (!check[i]) {
                    outputs[index] = inputs[i];
                    check[i] = true;
                    dfs(n, m, inputs, outputs, check, index + 1);
                    check[i] = false;
                }
            }
        }
    }
}
