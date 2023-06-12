package study.dev.algorithm.재귀.DFS;

import java.util.Scanner;

public class 부분집합구하기 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] check = new int[n + 1];
        int temp = 1;
        dfs(n, check, temp);
    }

    /**
     * 강의 풀이
     *
     * @param n
     * @param check
     * @param temp
     */
    private static void dfs(int n, int[] check, int temp) {
        if (temp == n + 1) {
            for (int i = 1; i <= n; i++) {
                if (check[i] == 1) {
                    System.out.print(i + " ");
                }
            }
            System.out.println();
        } else {
            check[temp] = 1;
            dfs(n, check, temp + 1);
            check[temp] = 0;
            dfs(n, check, temp + 1);
        }
    }
}
