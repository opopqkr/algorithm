package study.dev.algorithm.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 단지번호붙이기 {

    /**
     * INPUT
     * <p>
     * 7
     * 0110100
     * 0110101
     * 1110101
     * 0000111
     * 0100000
     * 0111110
     * 0111000
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            int[] temp = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
            if (N >= 0) System.arraycopy(temp, 0, map[i], 0, N);
        }

        System.out.print(solution());
    }

    private static int N;

    private static int[][] map;

    private static final int[] dx = {-1, 0, 1, 0};
    private static final int[] dy = {0, 1, 0, -1};

    private static String solution() {
        ArrayList<Integer> answer = new ArrayList<>();

        boolean[][] visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !visited[i][j])
                    answer.add(bfs(i, j, visited));
            }
        }

        Collections.sort(answer);

        StringBuilder sb = new StringBuilder();
        sb.append(answer.size()).append("\n");
        answer.forEach(o -> sb.append(o).append("\n"));
        return sb.toString();
    }

    private static int bfs(int x, int y, boolean[][] visited) {
        int count = 0;

        Queue<Coordinate> queue = new LinkedList<>();
        queue.offer(new Coordinate(x, y));

        while (!queue.isEmpty()) {
            Coordinate current = queue.poll();

            if (visited[current.x][current.y]) continue;
            visited[current.x][current.y] = true;
            count++;

            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;

                if (map[nx][ny] == 1) {
                    queue.offer(new Coordinate(nx, ny));
                }
            }
        }

        return count;
    }

    private static class Coordinate {
        int x, y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
