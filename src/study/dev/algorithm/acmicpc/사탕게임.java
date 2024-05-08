package study.dev.algorithm.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 사탕게임 {

    /**
     * INPUT
     * <p>
     * 3
     * CCP
     * CCP
     * PPC
     * <p>
     * 4
     * PPPP
     * CYZY
     * CCPY
     * PPCC
     * <p>
     * 5
     * YCPZY
     * CYZZP
     * CCPPP
     * YCYZC
     * CPPZZ
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        board = new char[N][N];
        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            for (int j = 0; j < N; j++) {
                board[i][j] = temp.charAt(j);
            }
        }

        System.out.println(solution());
    }

    private static int solution() {
        int answer = 0;

        // 행 교환
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < N; j++) {
                swap(i, j, i + 1, j);
                answer = Math.max(answer, count());
                swap(i + 1, j, i, j);
            }
        }

        // 열 교환
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - 1; j++) {
                swap(i, j, i, j + 1);
                answer = Math.max(answer, count());
                swap(i, j + 1, i, j);
            }
        }

        return answer;
    }

    private static int count() {
        int max = 1;

        // 행 탐색
        for (int i = 0; i < N; i++) {
            int count = 1;
            for (int j = 0; j < N - 1; j++) {
                if (board[i][j] == board[i][j + 1]) {
                    count++;
                    max = Math.max(max, count);
                } else {
                    count = 1;
                }
            }
        }

        // 열 탐색
        for (int j = 0; j < N; j++) {
            int count = 1;
            for (int i = 0; i < N - 1; i++) {
                if (board[i][j] == board[i + 1][j]) {
                    count++;
                    max = Math.max(max, count);
                } else {
                    count = 1;
                }
            }
        }

        return max;
    }

    private static void swap(int x1, int y1, int x2, int y2) {
        char temp = board[x1][y1];
        board[x1][y1] = board[x2][y2];
        board[x2][y2] = temp;
    }

    private static int N;

    private static char[][] board;

}
