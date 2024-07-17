package study.dev.algorithm.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 컴백홈 {

    /**
     * INPUT
     * <p>
     * 3 4 6
     * ....
     * .T..
     * ....
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] temp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        R = temp[0];
        C = temp[1];
        K = temp[2];

        map = new char[R][C];
        for (int i = 0; i < R; i++) {
            if (C >= 0) System.arraycopy(br.readLine().toCharArray(), 0, map[i], 0, C);
        }

        answer = 0;
        int startX = R - 1, startY = 0;

        boolean[][] visited = new boolean[R][C];
        visited[startX][startY] = true;
        dfs(startX, startY, 1, visited);

        System.out.println(answer);
    }

    private static void dfs(int x, int y, int distance, boolean[][] visited) {
        if ((x == 0 && y == C - 1) && distance == K) {
            answer++;
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= R || ny < 0 || ny >= C || map[nx][ny] == 'T') continue;

            if (!visited[nx][ny]) {
                visited[nx][ny] = true;
                dfs(nx, ny, distance + 1, visited);
                visited[nx][ny] = false;
            }
        }
    }

    private static int R, C, K, answer;

    private static char[][] map;

    private static final int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};

}
