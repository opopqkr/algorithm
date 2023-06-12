package study.dev.algorithm.정렬;

import java.util.Scanner;

public class 삽입정렬 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] inputs = new int[n];
        for (int i = 0; i < n; i++) {
            inputs[i] = in.nextInt();
        }

//        for (int i : solution1(n, inputs)) {
//            System.out.print(i + " ");
//        }
//
//        System.out.println();

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
            for (int j = i + 1; j > 0; j--) {
                if (inputs[j - 1] > inputs[j]) {
                    int temp = inputs[j - 1];
                    inputs[j - 1] = inputs[j];
                    inputs[j] = temp;
                }
            }
        }
        return inputs;
    }

    /**
     * 강의 풀이
     * <p>
     * 두 번째 index 부터 시작
     *
     * @param n
     * @param inputs
     * @return
     */
    private static int[] solution2(int n, int[] inputs) {
        for (int i = 1; i < n; i++) {
            int temp = inputs[i], j;
            for (j = i - 1; j >= 0; j--) {
                if (inputs[j] > temp) {
                    // temp 보다 크면 j 번째를 j + 1 로 이동
                    inputs[j + 1] = inputs[j];
                } else {
                    break;
                }
            }
            inputs[j + 1] = temp;
        }
        return inputs;
    }
}
