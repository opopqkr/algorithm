package study.dev.algorithm.정렬;

import java.util.Scanner;

public class 좌표정렬 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        int[][] inputs = new int[n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < inputs[i].length; j++) {
                inputs[i][j] = in.nextInt();
            }
        }

        int[][] result = solution1(n, inputs);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }

    }

    /**
     * 내 풀이
     *
     * @param n
     * @param inputs
     * @return
     */
    private static int[][] solution1(int n, int[][] inputs) {

        for (int i = 1; i < n; i++) {
            int x_temp = inputs[i][0], y_temp = inputs[i][1], j;
            for (j = i - 1; j >= 0; j--) {
                if (inputs[j][0] > x_temp) {
                    inputs[j + 1][0] = inputs[j][0];
                    inputs[j + 1][1] = inputs[j][1];
                } else if (inputs[j][0] == x_temp) {
                    if (inputs[j][1] > y_temp) {
                        inputs[j + 1][0] = inputs[j][0];
                        inputs[j + 1][1] = inputs[j][1];
                    }
                } else {
                    break;
                }
            }
            inputs[j + 1][0] = x_temp;
            inputs[j + 1][1] = y_temp;
        }

        return inputs;
    }
}
