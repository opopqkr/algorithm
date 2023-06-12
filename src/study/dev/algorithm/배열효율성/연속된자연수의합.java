package study.dev.algorithm.배열효율성;

import java.util.Scanner;

public class 연속된자연수의합 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        System.out.println(solution1(n));
        System.out.println(solution2(n));
    }

    /**
     * 내 풀이 & 강의의 풀이와 동일
     *
     * @param n
     * @return
     */
    private static int solution1(int n) {
        int answer = 0;

        int len = n / 2 + 1;
        int[] array = new int[len];
        for (int i = 0; i < len; i++) {
            array[i] = i + 1;
        }

        int sum = 0, sp = 0;
        for (int ep = 0; ep < array.length; ep++) {
            sum += array[ep];
            if (sum == n) {
                answer++;
            }
            while (sum >= n) {
                sum -= array[sp++];
                if (sum == n) {
                    answer++;
                }
            }
        }
        return answer;
    }

    /**
     * 강의 풀이
     *
     * @param n
     * @return
     */
    private static int solution2(int n) {
        int answer = 0, count = 1;

        n--;
        while (n > 0) {
            count++;
            n = n - count;
            if (n % count == 0) {
                answer++;
            }
        }
        return answer;
    }
}