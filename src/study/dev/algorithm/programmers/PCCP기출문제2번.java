package study.dev.algorithm.programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class PCCP기출문제2번 {
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{0, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 1, 1, 0, 0}, {1, 1, 0, 0, 0, 1, 1, 0}, {1, 1, 1, 0, 0, 0, 0, 0}, {1, 1, 1, 0, 0, 0, 1, 1}}));
        System.out.println(solution(new int[][]{{1, 0, 1, 0, 1, 1}, {1, 0, 1, 0, 0, 0}, {1, 0, 1, 0, 0, 1}, {1, 0, 0, 1, 0, 0}, {1, 0, 0, 1, 0, 1}, {1, 0, 0, 0, 0, 0}, {1, 1, 1, 1, 1, 1}}));
    }

    public static int solution(int[][] land) {
        int[] answers = new int[land[0].length];

        boolean[][] visited = new boolean[land.length][land[0].length];

        for (int j = 0; j < land[0].length; j++) {
            for (int i = 0; i < land.length; i++) {
                if (land[i][j] == 1 && !visited[i][j]) {
                    bfs(i, j, visited, answers, land);
                }
            }
        }

        return Arrays.stream(answers).max().orElse(0);
    }

    private final static int[] dx = {1, 0, -1, 0};
    private final static int[] dy = {0, 1, 0, -1};

    private static void bfs(int x, int y, boolean[][] visited, int[] answers, int[][] land) {
        int count = 0;

        boolean[] newOils = new boolean[answers.length];
        Queue<Coordinate> queue = new LinkedList<>();
        queue.offer(new Coordinate(x, y));

        while (!queue.isEmpty()) {
            Coordinate current = queue.poll();

            if (visited[current.x][current.y]) {
                continue;
            }

            visited[current.x][current.y] = true;
            newOils[current.y] = true;
            count++;

            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (nx >= 0 && nx < land.length && ny >= 0 && ny < land[0].length) {
                    if (!visited[nx][ny] && land[nx][ny] == 1) {
                        queue.offer(new Coordinate(nx, ny));
                    }
                }
            }
        }

        for (int i = 0; i < answers.length; i++) {
            if (newOils[i]) {
                answers[i] += count;
            }
        }
    }

    private static class Coordinate {
        int x, y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
