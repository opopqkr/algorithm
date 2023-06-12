package study.dev.algorithm.재귀.DFS;

import java.util.Scanner;

public class 조합구하기 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();

        int[] result = new int[m];

        dfs(n, m, result, 0, 1);
    }

    private static void dfs(int n, int m, int[] result, int index, int startPoint) {
        if (index == m) {
            for (int i : result) {
                System.out.print(i + " ");
            }
            System.out.println();
        } else {
            for (int i = startPoint; i <= n; i++) {
                result[index] = i;
                dfs(n, m, result, index + 1, i + 1);
            }
        }
    }
}
