package study.dev.algorithm.재귀.DFS;

import java.util.Scanner;

public class 섬나라아일랜드 {

    private static int n;
    private static int[][] board;
    private static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    private static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        board = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = in.nextInt();
            }
        }

        System.out.println(solution(board));
    }

    private static int solution(int[][] board) {
        int answer = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    answer++;
                    dfs(i, j);
                }
            }
        }

        return answer;
    }

    private static void dfs(int x, int y) {
        board[x][y] = 0; // 출발 지점 변경
        
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] == 1) {
                board[nx][ny] = 0;
                dfs(nx, ny);
            }
        }
    }

}

