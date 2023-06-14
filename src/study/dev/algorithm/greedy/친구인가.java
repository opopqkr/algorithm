package study.dev.algorithm.greedy;

import java.util.Scanner;

public class 친구인가 {

    private static int[] disjointSet;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();

        disjointSet = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            disjointSet[i] = i;
        }

        for (int i = 0; i < m; i++) {
            union(in.nextInt(), in.nextInt());
        }

        if (find(in.nextInt()) == find(in.nextInt())) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    private static void union(int a, int b) {
        int x = find(a);
        int y = find(b);

        if (x != y) {
            disjointSet[x] = y;
        }
    }

    private static int find(int a) {
        if (disjointSet[a] == a) {
            return a;
        } else {
            return disjointSet[a] = find(disjointSet[a]);
        }
    }
}
