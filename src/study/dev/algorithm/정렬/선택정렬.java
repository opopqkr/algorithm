package study.dev.algorithm.정렬;

import java.util.Scanner;

public class 선택정렬 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] inputs = new int[n];
        for (int i = 0; i < n; i++) {
            inputs[i] = in.nextInt();
        }

        for (int i : solution1(n, inputs)) {
            System.out.print(i + " ");
        }

        System.out.println();

        for (int i : solution2(n, inputs)) {
            System.out.print(i + " ");
        }
    }

    /**
     * 내 풀이
     *
     * @param n
     * @param inputs
     * @return
     */
    private static int[] solution1(int n, int[] inputs) {

        for (int i = 0; i < n - 1; i++) {
            int index = 0;
            int min = Integer.MAX_VALUE;
            for (int j = i + 1; j < n; j++) {
                if (min > inputs[j]) {
                    min = inputs[j];
                    index = j;
                }
            }
            if (inputs[i] > min) {
                inputs[index] = inputs[i];
                inputs[i] = min;
            }
        }

        return inputs;
    }

    /**
     * 강의 풀이
     * <p>
     * 선택 정렬은 배열의 최솟값을 구하여 swap
     *
     * @param n
     * @param inputs
     * @return
     */
    private static int[] solution2(int n, int[] inputs) {
        for (int i = 0; i < n - 1; i++) {
            int index = i;
            for (int j = i + 1; j < n; j++) {
                if (inputs[index] > inputs[j]) {
                    index = j;
                }
            }

            if (index != i) {
                int temp = inputs[i];
                inputs[i] = inputs[index];
                inputs[index] = temp;
            }
        }
        return inputs;
    }
}
