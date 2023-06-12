package study.dev.algorithm.배열;

import java.util.Scanner;

public class 소수 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        System.out.println(solution1(n));
    }

    /**
     * 내 풀이 (Time out)
     * <p>
     * 강의 풀이
     *
     * @param n
     * @return
     */
    private static int solution1(int n) {
        int answer = 0;

        int[] temp = new int[n + 1]; // 배열 길이 만큼 0으로 초기화
        for (int i = 2; i <= n; i++) {
            if (temp[i] == 0) {
                answer++;
                for (int j = i; j <= n; j = j + i) {
                    temp[j] = 1;
                }
            }
        }
        return answer;
    }
}
