package study.dev.algorithm.재귀.DFS;

import java.util.Scanner;

public class 바둑이승차 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int c = in.nextInt();
        int n = in.nextInt();

        int[] inputs = new int[n];
        for (int i = 0; i < n; i++) {
            inputs[i] = in.nextInt();
        }

        dfs(c, n, inputs, 0, 0);
        System.out.println(answer);
    }

    private static int answer = 0;

    /**
     * 내 풀이
     *
     * @param c          - 최대 트럭에 태울 수 있는 무게
     * @param n
     * @param inputs
     * @param startPoint
     * @param sum        - 트럭에 타는 바둑이의 무게
     */
    private static void dfs(int c, int n, int[] inputs, int startPoint, int sum) {
        if (sum > c) {
            return;
        }
        if (startPoint == n) {
            answer = Math.max(answer, sum);
            return;
        } else {
            dfs(c, n, inputs, startPoint + 1, sum + inputs[startPoint]);
            dfs(c, n, inputs, startPoint + 1, sum);
        }
    }
}
