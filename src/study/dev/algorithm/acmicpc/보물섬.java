package study.dev.algorithm.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 보물섬 {

    /**
     * INPUT
     * <p>
     * 5 7
     * WLLWWWL
     * LLLWLLL
     * LWLWLWW
     * LWLWLLL
     * WLLWLWW
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] NM = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = NM[0];
        M = NM[1];

        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = temp.charAt(j);
            }
        }

        System.out.println(solution());
    }

    private static int solution() {
        int answer = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 'L') {
                    answer = Math.max(bfs(i, j, new boolean[N][M]), answer);
                }
            }
        }

        return answer;
    }

    private static int bfs(int x, int y, boolean[][] visited) {
        int max = 0;

        Queue<Coordinate> queue = new LinkedList<>();
        queue.offer(new Coordinate(x, y, 0));

        while (!queue.isEmpty()) {
            Coordinate current = queue.poll();

            if (visited[current.x][current.y]) continue;

            visited[current.x][current.y] = true;
            max = Math.max(max, current.distance);

            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

                if (!visited[nx][ny] && map[nx][ny] == 'L') {
                    queue.offer(new Coordinate(nx, ny, current.distance + 1));
                }
            }
        }

        return max;
    }

    private static int N, M;

    private static char[][] map;

    private static final int[] dx = {-1, 0, 1, 0};

    private static final int[] dy = {0, 1, 0, -1};

    private static class Coordinate {
        int x, y, distance;

        public Coordinate(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }
}
