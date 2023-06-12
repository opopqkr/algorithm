package study.dev.algorithm.재귀.DFS;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 인접 리스트 이용
 * 노드의 수가 많아질수록 인접 행렬은 비효율적, 이 때 인접 리스트 이용
 */
public class 경로탐색2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            graph.get(a).add(b);
        }

        int[] check = new int[n + 1];
        check[1] = 1;
        dfs(1, n, check, graph);
        System.out.println(answer);
    }

    private static int answer = 0;

    private static void dfs(int startPoint, int n, int[] check, ArrayList<ArrayList<Integer>> graph) {
        if (startPoint == n) {
            answer++;
        } else {
            for (int nextPoint : graph.get(startPoint)) {
                if (check[nextPoint] == 0) {
                    check[nextPoint] = 1;
                    dfs(nextPoint, n, check, graph);

                    check[nextPoint] = 0;
                }
            }
        }
    }
}
