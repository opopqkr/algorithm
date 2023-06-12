package study.dev.algorithm.재귀.DFS;

import java.util.Scanner;

public class 합이같은부분집합 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] inputs = new int[n];
        int total = 0;
        for (int i = 0; i < inputs.length; i++) {
            inputs[i] = in.nextInt();
            total += inputs[i];
        }

        // boolean[] check = new boolean[n + 1];
        // dfs1(inputs, check, 0, 0, total);

        dfs2(n, inputs, 0, 0, total);
        if (stop) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    private static boolean stop = false;

    /**
     * 내 풀이
     *
     * @param inputs
     * @param check
     * @param startPoint
     * @param sum
     * @param total
     */
    private static void dfs1(int[] inputs, boolean[] check, int startPoint, int sum, int total) {
        if (total - sum == sum) {
            stop = true;
        }
        if (stop || startPoint == check.length) {
            return;
        } else {
            int temp = 0;
            for (int i = 0; i < check.length; i++) {
                if (check[i]) {
                    temp += inputs[i];
                }
            }
            check[startPoint] = true;
            dfs1(inputs, check, startPoint + 1, temp, total);
            check[startPoint] = false;
            dfs1(inputs, check, startPoint + 1, temp, total);
        }
    }

    /**
     * 강의 풀이
     *
     * @param n
     * @param inputs
     * @param startPoint
     * @param sum
     * @param total
     */
    private static void dfs2(int n, int[] inputs, int startPoint, int sum, int total) {
        if (stop) {
            return;
        }
        if (sum > total / 2) {
            return;
        }
        if (startPoint == n) {
            if (total - sum == sum) {
                stop = true;
            }
        } else {
            dfs2(n, inputs, startPoint + 1, sum + inputs[startPoint], total);
            dfs2(n, inputs, startPoint + 1, sum, total);
        }
    }
}
