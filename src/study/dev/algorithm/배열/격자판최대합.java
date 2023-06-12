package study.dev.algorithm.배열;

import java.util.Scanner;

public class 격자판최대합 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] inputs = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                inputs[i][j] = in.nextInt();
            }
        }
        System.out.println(solution1(n, inputs));
        System.out.println(solution2(n, inputs));
    }

    /**
     * 내 풀이
     *
     * @param n
     * @param inputs
     * @return
     */
    private static int solution1(int n, int[][] inputs) {
        int answer = Integer.MIN_VALUE;

        int cross1 = 0;
        int cross2 = 0;
        for (int i = 0; i < n; i++) {
            int row = 0;
            int col = 0;
            for (int j = 0; j < n; j++) {
                row += inputs[i][j];
                col += inputs[j][i];
                if (i == j) {
                    cross1 += inputs[i][j];
                }
                if (i + j == n - 1) {
                    cross2 += inputs[i][j];
                }
            }
            if (answer < row) {
                answer = row;
            } else if (answer < col) {
                answer = col;
            } else if (answer < cross1) {
                answer = cross1;
            } else if (answer < cross2) {
                answer = cross2;
            }
        }

        return answer;
    }

    /**
     * 강의 풀이
     *
     * @param n
     * @param inputs
     * @return
     */
    private static int solution2(int n, int[][] inputs) {
        int answer = Integer.MIN_VALUE;

        int row, col;
        for (int i = 0; i < n; i++) {
            row = col = 0;
            for (int j = 0; j < n; j++) {
                row += inputs[i][j];
                col += inputs[j][i];
            }
            answer = Math.max(answer, row);
            answer = Math.max(answer, col);
        }

        int cross1 = 0, cross2 = 0;
        for (int i = 0; i < n; i++) {
            cross1 += inputs[i][i];
            cross2 += inputs[i][n - i - 1];
        }
        answer = Math.max(answer, cross1);
        answer = Math.max(answer, cross2);
        return answer;
    }
}
