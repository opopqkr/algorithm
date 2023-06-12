package study.dev.algorithm.배열;

import java.util.Scanner;

public class 임시반장정하기 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] inputs = new int[n + 1][6];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < inputs[i].length; j++) {
                inputs[i][j] = in.nextInt();
            }
        }
        System.out.println(solution1(n, inputs));
    }

    /**
     * 강의 풀이 (다시 확인)
     *
     * @param n
     * @param inputs
     * @return
     */
    public static int solution1(int n, int[][] inputs) {
        int answer = 0, max = Integer.MIN_VALUE;

        for (int i = 1; i <= n; i++) {
            int count = 0;
            for (int j = 1; j <= n; j++) {
                if (i != j) {
                    for (int k = 1; k <= 5; k++) {
                        // 한번이라도 같으면 count 하면 안됨.
                        if (inputs[i][k] == inputs[j][k]) {
                            count++;
                            break;
                        }
                    }
                }
                if (count > max) {
                    max = count;
                    answer = i;
                }
            }
        }
        return answer;
    }
}
