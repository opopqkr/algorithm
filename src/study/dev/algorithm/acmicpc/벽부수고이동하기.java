package study.dev.algorithm.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 벽부수고이동하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp;

        temp = br.readLine().split(" ");
        int N = Integer.parseInt(temp[0]), M = Integer.parseInt(temp[1]);

        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            temp = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(temp[j]);
            }
        }

        System.out.println(bfs(N, M, map));
    }

    private static int bfs(int N, int M, int[][] map) {
        boolean[][][] visited = new boolean[N][M][2];
        visited[0][0][0] = true;

        Queue<Coordinate> queue = new LinkedList<>();
        queue.offer(new Coordinate(0, 0, 1, false));

        while (!queue.isEmpty()) {
            Coordinate current = queue.poll();

            if (current.x + 1 == N && current.y + 1 == M) {
                return current.distance;
            }

            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

                if (map[nx][ny] == 0) {
                    if (!current.destroy && !visited[nx][ny][0]) {
                        visited[nx][ny][0] = true;
                        queue.offer(new Coordinate(nx, ny, current.distance + 1, false));
                    } else if (current.destroy && !visited[nx][ny][1]) {
                        visited[nx][ny][1] = true;
                        queue.offer(new Coordinate(nx, ny, current.distance + 1, true));
                    }
                } else {
                    if (!current.destroy) {
                        visited[nx][ny][1] = true;
                        queue.offer(new Coordinate(nx, ny, current.distance + 1, true));
                    }
                }
            }
        }

        return -1;
    }

    private final static int[] dx = {-1, 0, 1, 0};

    private final static int[] dy = {0, 1, 0, -1};

    private static class Coordinate {
        int x, y, distance;
        boolean destroy;

        public Coordinate(int x, int y, int distance, boolean destroy) {
            this.x = x;
            this.y = y;
            this.distance = distance;
            this.destroy = destroy;
        }
    }
}
