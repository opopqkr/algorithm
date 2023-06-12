package study.dev.algorithm.재귀.BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 토마토 {

    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int m = in.nextInt();
        int n = in.nextInt();

        int[][] box = new int[n][m];
        int[][] days = new int[n][m];
        Queue<Coordinate> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int input = in.nextInt();
                box[i][j] = input;
                if (input == 1) {
                    queue.offer(new Coordinate(i, j));
                }
            }
        }

        int answer = bfs(n, m, queue, box, days);
        System.out.println(answer);
    }

    private static int bfs(int n, int m, Queue<Coordinate> queue, int[][] box, int[][] days) {
        int day = 0;

        while (!queue.isEmpty()) {
            Coordinate current = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (box[nx][ny] == 0) {
                        box[nx][ny] = 1;
                        queue.offer(new Coordinate(nx, ny));
                        days[nx][ny] = days[current.x][current.y] + 1;
                    }
                }
            }
        }

        // queue 전체 탐색 후, box 배열에 0이 존재하면 토마토가 모두 익지 못하는 상황이므로 return -1
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (box[i][j] == 0) {
                    return -1;
                }
            }
        }

        // days 배열 중 가장 큰 값이 토마토가 익을 때 까지의 가장 최솟 값.
        // days 배열이 모두 0 인경우는 모든 토마토가 익어 있는 상황
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (day < days[i][j]) {
                    day = Math.max(day, days[i][j]);
                }
            }
        }
        
        return day;
    }

    /**
     * 좌표
     */
    private static class Coordinate {
        int x;
        int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
