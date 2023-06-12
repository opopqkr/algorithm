package study.dev.algorithm.재귀;

import java.util.Scanner;

public class 피보나치수열 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        int first = 1;
        int second = 1;
        recursive1(first, second, n);
        System.out.println();

        fibonacci = new int[n + 1];
        recursive2(n);
        for (int i = 1; i <= n; i++) {
            System.out.print(fibonacci[i] + " ");
        }

    }

    /**
     * 내 풀이
     *
     * @param first
     * @param second
     * @param n
     */
    private static void recursive1(int first, int second, int n) {
        if (n == 0) {
            return;
        } else {
            System.out.print(first + " ");
            n--;
            recursive1(second, first + second, n);
        }
    }

    /**
     * 배열에 미리 담아두는 경우, 그때그때 즉각 재 계산 할 필요 없음.
     */
    private static int[] fibonacci;

    /**
     * 강의 풀이
     * <p>
     * 메모이제이션 활용이 포인트
     * <p>
     * 1. 배열에 저장
     * 2. 배열에 저장된 값이 있으면 바로 배열의 값을 리턴
     *
     * @param n
     * @return
     */
    private static int recursive2(int n) {
        if (fibonacci[n] > 0) {
            return fibonacci[n];
        }

        if (n == 1) {
            return fibonacci[n] = 1;
        } else if (n == 2) {
            return fibonacci[n] = 1;
        } else {
            return fibonacci[n] = recursive2(n - 2) + recursive2(n - 1);
        }
    }
}
