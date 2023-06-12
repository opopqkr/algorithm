package study.dev.algorithm.재귀;

import java.util.Scanner;

public class 이진수출력 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        recursive1(n);
        System.out.println();
        recursive2(n);
    }

    /**
     * 내 풀이
     *
     * @param n
     */
    private static void recursive1(int n) {
        if (n == 1) {
            System.out.print(n);
            return;
        } else {
            recursive1(n / 2);
            System.out.print(n % 2);
        }
    }

    /**
     * 강의 풀이
     *
     * @param n
     */
    private static void recursive2(int n) {
        if (n == 0) {
            return;
        } else {
            recursive2(n / 2);
            System.out.print(n % 2);
        }
    }
}
