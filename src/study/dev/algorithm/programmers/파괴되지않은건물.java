package study.dev.algorithm.programmers;

public class 파괴되지않은건물 {
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}}
                , new int[][]{{1, 0, 0, 3, 4, 4}, {1, 2, 0, 2, 3, 2}, {2, 1, 0, 3, 1, 2}, {1, 0, 1, 3, 3, 1}}));
        System.out.println(solution(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}
                , new int[][]{{1, 1, 1, 2, 2, 4}, {1, 0, 0, 1, 1, 2}, {2, 2, 0, 2, 0, 100}}));
    }

    public static int solution(int[][] board, int[][] skill) {
        int answer = 0;

        int[][] sum = new int[board.length + 1][board[0].length + 1];
        for (int[] info : skill) {
            int type = info[0], degree = info[5];
            int x1 = info[1], y1 = info[2], x2 = info[3], y2 = info[4];
            if (type == 1) {
                sum[x1][y1] -= degree;
                sum[x1][y2 + 1] += degree;
                sum[x2 + 1][y1] += degree;
                sum[x2 + 1][y2 + 1] -= degree;
            } else {
                sum[x1][y1] += degree;
                sum[x1][y2 + 1] -= degree;
                sum[x2 + 1][y1] -= degree;
                sum[x2 + 1][y2 + 1] += degree;
            }
        }

        // 왼쪽 -> 오른쪽 누적 합
        for (int i = 0; i < sum.length; i++) {
            for (int j = 0; j < sum[i].length - 1; j++) {
                sum[i][j + 1] += sum[i][j];
            }
        }

        // 위 -> 아래 누적 합
        for (int i = 0; i < sum.length - 1; i++) {
            for (int j = 0; j < sum[i].length; j++) {
                sum[i + 1][j] += sum[i][j];
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] + sum[i][j] > 0) {
                    answer++;
                }
            }
        }

        return answer;
    }
}
