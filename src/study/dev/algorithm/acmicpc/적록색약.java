package study.dev.algorithm.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 적록색약 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new char[N][N];
        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = temp.charAt(j);
            }
        }

        System.out.println(solution());
    }

    private static String solution() {
        StringBuilder sb = new StringBuilder();

        int count;
        boolean[][] visited;

        // 정상인
        count = 0;
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    count++;
                    visited[i][j] = true;
                    bfs(false, i, j, map[i][j], visited);
                }
            }
        }

        sb.append(count).append(" ");

        // 적녹색약
        count = 0;
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    count++;
                    visited[i][j] = true;
                    bfs(true, i, j, map[i][j], visited);
                }
            }
        }

        sb.append(count);

        return sb.toString();
    }

    private static void bfs(boolean isBlindness, int x, int y, char color, boolean[][] visited) {
        Queue<CoordinateInfo> queue = new LinkedList<>();
        queue.offer(new CoordinateInfo(x, y, color));

        while (!queue.isEmpty()) {
            CoordinateInfo current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny]) continue;

                if (current.isSameColor(map[nx][ny], isBlindness)) {
                    visited[nx][ny] = true;
                    queue.offer(new CoordinateInfo(nx, ny, map[nx][ny]));
                }
            }
        }
    }

    private static int N;

    private static char[][] map;

    private static final int[] dx = {-1, 0, 1, 0};

    private static final int[] dy = {0, 1, 0, -1};

    private static class CoordinateInfo {
        int x, y;

        char color;

        public CoordinateInfo(int x, int y, char color) {
            this.x = x;
            this.y = y;
            this.color = color;
        }

        public boolean isSameColor(char other, boolean isBlindness) {
            if (color == other)
                return true;

            if (isBlindness) {
                if (color == 'R' && other == 'G')
                    return true;
                if (color == 'G' && other == 'R')
                    return true;
            }

            return false;
        }
    }
}
