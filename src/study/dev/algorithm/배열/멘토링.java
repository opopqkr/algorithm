package study.dev.algorithm.배열;

import java.util.Scanner;

public class 멘토링 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] inputs = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                inputs[i][j] = in.nextInt();
            }
        }

        System.out.println(solution1(n, m, inputs));
    }

    /**
     * 강의 풀이
     *
     * @param n
     * @param m
     * @param inputs
     * @return
     */
    public static int solution1(int n, int m, int[][] inputs) {
        int answer = 0;

        // 모든 학생의 경우의 수
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int count = 0;
                if (i != j) {
                    for (int test = 0; test < m; test++) {
                        int iRank = 0, jRank = 0;
                        for (int rank = 0; rank < n; rank++) {
                            if (inputs[test][rank] == i) {
                                iRank = rank;
                            }
                            if (inputs[test][rank] == j) {
                                jRank = rank;
                            }
                        }
                        if (iRank < jRank) {
                            count++;
                        }
                    }

                }
                if (count == m) {
                    answer++;
                }
            }
        }
        return answer;
    }
}
