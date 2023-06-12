package study.dev.algorithm.재귀;

import java.util.Scanner;

public class 재귀함수 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        // solution1(1, n);
        solution2(n);
    }


    /**
     * 내 풀이
     *
     * @param n
     */
    private static void solution1(int temp, int n) {
        System.out.print(temp + " ");
        if (temp == n) {
            return;
        } else {
            solution1(temp + 1, n);
        }
    }

    /**
     * 강의 풀이 (DFS)
     * <p>
     * 재귀함수 : 자기가 자기 자신을 호출하는 함수
     * 재귀함수는 스택 프레임을 사용
     * 매개변수 정보, 지역변수 정보, 복귀주소정보등을 스택에 쌓아둠
     *
     * @param n
     */
    private static void solution2(int n) {
        if (n == 0) {
            return;
        } else {
            solution2(n - 1);
            System.out.print(n + " ");
        }
    }

}
