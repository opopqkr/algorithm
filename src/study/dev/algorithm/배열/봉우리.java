package study.dev.algorithm.배열;

import java.util.Scanner;

public class 봉우리 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] inputs1 = new int[n + 2][n + 2];
        int[][] inputs2 = new int[n][n];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int input = in.nextInt();
                inputs1[i][j] = input;
                inputs2[i - 1][j - 1] = input;
            }
        }

        System.out.println(solution1(n, inputs1));
        System.out.println(solution2(n, inputs2));
    }

    /**
     * 내 풀이
     *
     * @param n
     * @param inputs
     * @return
     */
    public static int solution1(int n, int[][] inputs) {
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (inputs[i][j] > inputs[i - 1][j] &&
                        inputs[i][j] > inputs[i + 1][j] &&
                        inputs[i][j] > inputs[i][j - 1] &&
                        inputs[i][j] > inputs[i][j + 1]) {
                    answer++;
                }
            }
        }

        return answer;
    }

    /**
     * 강의 풀이
     * <p>
     * 방향 배열을 추가
     *
     * @param n
     * @param inputs
     * @return
     */
    public static int solution2(int n, int[][] inputs) {
        int answer = 0;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                boolean flag = true;
                for (int k = 0; k < 4; k++) {
                    int x = i + dx[k];
                    int y = j + dy[k];
                    if (x >= 0 && x < n &&
                        y >= 0 && y < n &&
                        inputs[x][y] >= inputs[i][j]) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    answer++;
                }
            }
        }

        return answer;
    }

}
