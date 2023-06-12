package study.dev.algorithm.재귀;

import java.util.Scanner;

public class 팩토리얼 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        System.out.println(recursive1(n));
    }

    /**
     * 내 풀이 & 강의 풀이
     *
     * @param n
     * @return
     */
    private static int recursive1(int n) {
        if (n == 1) {
            return 1;
        } else {
            return recursive1(n - 1) * n;
        }
    }
}
