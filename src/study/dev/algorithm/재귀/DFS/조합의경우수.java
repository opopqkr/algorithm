package study.dev.algorithm.재귀.DFS;

import java.util.Scanner;

public class 조합의경우수 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int r = in.nextInt();
        combination = new int[n + 1][r + 1];

        // System.out.println(dfs1(n, r));
        System.out.println(dfs2(n, r));
    }

    private static int[][] combination;

    /**
     * 메모이제이션 기법 사용 X
     *
     * @param n
     * @param r
     * @return
     */
    private static int dfs1(int n, int r) {
        if (n == r || r == 0) {
            return 1;
        } else {
            return dfs1(n - 1, r - 1) + dfs1(n - 1, r);
        }
    }

    /**
     * 메모이제이션 기법 사용
     *
     * @param n
     * @param r
     * @return
     */
    private static int dfs2(int n, int r) {
        if (combination[n][r] > 0) {
            return combination[n][r];
        }
        if (n == r || r == 0) {
            return 1;
        } else {
            return combination[n][r] = dfs2(n - 1, r - 1) + dfs2(n - 1, r);
        }
    }
}
