package study.dev.algorithm.배열;

import java.util.Scanner;

public class 피보나치수열 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        for (int result : solution1(n)) {
            System.out.print(result + " ");
        }
        System.out.println();
        solution2(n);
    }

    /**
     * 내 풀이 && 강의 풀이
     *
     * @param n
     * @return
     */
    private static int[] solution1(int n) {
        int[] answer = new int[n];
        answer[0] = 1;
        answer[1] = 1;

        for (int i = 2; i < n; i++) {
            answer[i] = answer[i - 1] + answer[i - 2];
        }
        return answer;
    }

    /**
     * 강의 풀이 (배열 없이)
     *
     * @param n
     */
    private static void solution2(int n) {
        int a = 1, b = 1, c;
        System.out.print(a + " " + b + " ");
        for (int i = 2; i < n; i++) {
            c = a + b;
            System.out.print(c + " ");
            a = b;
            b = c;
        }
    }
}
