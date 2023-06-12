package study.dev.algorithm.정렬;

import java.util.Scanner;

public class 버블정렬 {

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
    }

    /**
     * 내 풀이 & 강의 풀이
     * <p>
     * 한번의 반복문을 통해서 가장 큰 숫자를 맨 뒤로 보냄.
     * 그러므로 배열의 끝 부분을 줄여나감. j < n - i - 1
     *
     * @param n
     * @param inputs
     * @return
     */
    private static int[] solution1(int n, int[] inputs) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (inputs[j] > inputs[j + 1]) {
                    int temp = inputs[j];
                    inputs[j] = inputs[j + 1];
                    inputs[j + 1] = temp;
                }
            }
        }
        return inputs;
    }
}
