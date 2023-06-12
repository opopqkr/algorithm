package study.dev.algorithm.재귀.DFS;

import java.util.Scanner;

public class 미로탐색 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[][] miro = new int[8][8];
        for (int i = 1; i <= 7; i++) {
            for (int j = 1; j <= 7; j++) {
                miro[i][j] = in.nextInt();
            }
        }

        miro[1][1] = 1;
        dfs(1, 1, miro);
        System.out.println(answer);
    }

    private static int answer = 0;
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};

    private static void dfs(int xIndex, int yIndex, int[][] miro) {
        if (xIndex == 7 && yIndex == 7) {
            answer++;
        } else {
            for (int i = 0; i < 4; i++) {
                int x = xIndex + dx[i];
                int y = yIndex + dy[i];
                if (x >= 1 && x <= 7 && y >= 1 && y <= 7 && miro[x][y] == 0) {
                    miro[x][y] = 1;
                    dfs(x, y, miro);
                    miro[x][y] = 0;
                }
            }
        }
    }
}
