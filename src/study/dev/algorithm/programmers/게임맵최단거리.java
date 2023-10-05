package study.dev.algorithm.programmers;

import java.util.LinkedList;
import java.util.Queue;

public class 게임맵최단거리 {
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}}));
        System.out.println(solution(new int[][]{{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 0}, {0, 0, 0, 0, 1}}));
    }

    public static int solution(int[][] maps) {
        int[][] distances = new int[maps.length][maps[0].length];

        Queue<Coordinate> queue = new LinkedList<>();
        queue.offer(new Coordinate(0, 0));
        distances[0][0] = 1;

        while (!queue.isEmpty()) {
            Coordinate current = queue.poll();
            int x = current.x;
            int y = current.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < maps.length && ny >= 0 && ny < maps[0].length && maps[nx][ny] == 1) {
                    if (distances[nx][ny] == 0) {
                        distances[nx][ny] = distances[x][y] + 1;
                        queue.offer(new Coordinate(nx, ny));
                    }
                }
            }
        }

        int answer = distances[maps.length - 1][maps[0].length - 1];
        if (answer == 0) {
            return -1;
        } else {
            return answer;
        }
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
}
