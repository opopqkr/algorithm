package study.dev.algorithm.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 유기농배추 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());

        for (int c = 0; c < t; c++) {
            st = new StringTokenizer(br.readLine());

            int m = Integer.parseInt(st.nextToken()), n = Integer.parseInt(st.nextToken());
            int[][] map = new int[m][n];

            int k = Integer.parseInt(st.nextToken());
            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
                map[x][y] = 1;
            }

            System.out.println(solution(m, n, map));
        }
    }

    private static int solution(int m, int n, int[][] map) {
        int answer = 0;

        Queue<Coordinate> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    queue.offer(new Coordinate(i, j));
                    visited[i][j] = true;
                    bfs(map, visited, queue);
                    answer++;
                }
            }
        }

        return answer;
    }

    private static final int[] dx = {-1, 0, 1, 0};
    private static final int[] dy = {0, 1, 0, -1};

    private static class Coordinate {
        int x, y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static void bfs(int[][] map, boolean[][] visited, Queue<Coordinate> queue) {
        while (!queue.isEmpty()) {
            Coordinate current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (nx >= 0 && nx < map.length && ny >= 0 && ny < map[0].length) {
                    if (map[nx][ny] == 1 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        queue.offer(new Coordinate(nx, ny));
                    }
                }
            }
        }
    }
}
